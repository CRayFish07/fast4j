package cn.wangsy.fast4j.web.quartz;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import cn.wangsy.fast4j.web.model.entity.ScheduleJob;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年8月1日 上午11:10:07
 */
@Component
public class QuartzTest {

	@Resource
	private Scheduler scheduler;
	private Random random = new Random();
	
	public void test() throws SchedulerException{
		//schedulerFactoryBean 由spring创建注入
		//Scheduler scheduler = schedulerFactoryBean.getScheduler();
		//这里获取任务信息数据
		List<ScheduleJob> jobList = DataWorkContext.getAllJob();
		for (ScheduleJob job : jobList) {
			TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
			//获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			//不存在，创建一个
			if (null == trigger) {
				JobDetail jobDetail = null;
				//if(random.nextBoolean()){
					jobDetail = JobBuilder.newJob(QuartzJobFactory.class)
					.withIdentity(job.getJobName(), job.getJobGroup()).build();
				//}else{
//					jobDetail = JobBuilder.newJob(FileScanJob.class)
//					.withIdentity(job.getJobName(), job.getJobGroup()).build();
				//}
				jobDetail.getJobDataMap().put("scheduleJob", job);
				//表达式调度构建器
				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
				//按新的cronExpression表达式构建一个新的trigger
				trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();
				scheduler.scheduleJob(jobDetail, trigger);
			} else {
				// Trigger已存在，那么更新相应的定时设置
				//表达式调度构建器
				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
				//按新的cronExpression表达式重新构建trigger
				trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
				//按新的trigger重新设置job执行
				scheduler.rescheduleJob(triggerKey, trigger);
			}
		}
	}
	
}
