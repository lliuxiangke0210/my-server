package com.zetyun.mml.controller;

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

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String sayWorld(@PathVariable("name") String name) {
		return "Hello " + name + " , are you ok? you are the best!";
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
