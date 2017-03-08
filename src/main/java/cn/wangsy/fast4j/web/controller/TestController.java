package cn.wangsy.fast4j.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.quartz.SchedulerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wangsy.fast4j.core.annotation.Token;
import cn.wangsy.fast4j.core.annotation.TokenValid;
import cn.wangsy.fast4j.core.mail.MailService;
import cn.wangsy.fast4j.core.template.TemplateProcessService;
import cn.wangsy.fast4j.util.Pager;
import cn.wangsy.fast4j.web.quartz.QuartzTest;
import cn.wangsy.fast4j.web.service.DictionaryTypeService;
import cn.wangsy.fast4j.web.service.JobService;
import cn.wangsy.fast4j.web.service.TestService;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年8月1日 上午11:16:48
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@Resource
	private QuartzTest quartzTest;
	@Resource
	private JobService jobService;
	@Resource
	private DictionaryTypeService dictionaryTypeService;
	@Resource
	private TemplateProcessService templateProcessService;
	@Resource
	private MailService mailService;
	@Resource
	private TestService testService;
	
	@RequestMapping("/quartz")
	@ResponseBody
	public void quartz(){
		try {
			quartzTest.test();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/jobList")
	@ResponseBody
	public Object jobList(){
		return jobService.selectList();
	}
	
	@Token
	@RequestMapping("/getForm")
	public String getForm(HttpServletRequest request){
		return "/form";
	}
	
	@TokenValid
	@RequestMapping("/submitForm")
	@ResponseBody
	public Object submitForm(HttpServletRequest request, String tel, String address){
		System.out.println("tel="+tel+"&address="+address);
		return "提交成功！";
	}
	
	@RequestMapping("/listDict")
	@ResponseBody
	public Object listDict(Pager pager){
		return dictionaryTypeService.list(pager);
	}
	
	@RequestMapping("/template")
	@ResponseBody
	public Object template(){
		Map<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.put("siteName", "爱编程");
		rootMap.put("verifyCode", "2323");
		rootMap.put("limit", "5");
		String result = templateProcessService.process("welcome.ftl", rootMap);
		return result;
	}
	
	@RequestMapping("/mail")
	@ResponseBody
	public void send(){
		Map<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.put("siteName", "爱编程");
		rootMap.put("verifyCode", "2323");
		rootMap.put("limit", "5");
		String result = templateProcessService.process("welcome.ftl", rootMap);
		try {
			mailService.send("wangsongyanlove@163.com", "1104237534@qq.com", "验证码", result, false);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("transaction")
	@ResponseBody
	public void transaction(){
		testService.test();
	}
	
}
