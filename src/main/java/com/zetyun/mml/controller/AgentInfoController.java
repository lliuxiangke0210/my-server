package com.zetyun.mml.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zetyun.mml.bean.AgentCache;
import com.zetyun.mml.bean.CacheManager;

@RestController
@RequestMapping("/agent")
public class AgentInfoController {

	protected static Logger logger = LoggerFactory.getLogger(AgentInfoController.class);

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String sayWorld(@PathVariable("name") String name) {
		logger.error("sayWorld自己定义的日志输出异常");
		return "Hello " + name + " , are you ok? you are the best!";
	}

	@RequestMapping("/div")
	public String helloworld() {
		logger.error("sayWorld自己定义的日志输出异常");
		try {
			int num = 10;
			int div = 0;
			int result = num / div;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			for (StackTraceElement errorinfo : e.getStackTrace()) {
				logger.error(errorinfo.toString());
			}
			// 记录到日志
			logger.error("GlobalExceptionHandler,捕获异常:" + e.getMessage());

		}

		return "Hello world!";
	}

	@RequestMapping("/hello/{name}")
	public String helloName(@PathVariable String name) {
		logger.error("sayWorld自己定义的日志输出异常");
		logger.debug("访问helloName,Name={}", name);

		return "Hello " + name;
	}

	/**
	 * 请求内容是一个json串,spring会自动把他和我们的参数bean对应起来,不过要加@RequestBody注解
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	@RequestMapping(value = "/hostinfo", method = RequestMethod.POST)
	public String postHostInfo(@RequestBody AgentCache hostInfo) {
		CacheManager.getInstance().setCache(hostInfo);
		return CacheManager.getInstance().getCache();
	}

}
