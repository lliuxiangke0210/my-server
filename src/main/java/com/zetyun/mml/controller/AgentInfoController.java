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

	@RequestMapping(value = "/trace", method = RequestMethod.GET)
	public String doTrace() {
		String trace = "[2018-02-01 20:22:23,264] TRACE Broker 1001 completed LeaderAndIsr request correlationId 13 from controller 1001 epoch 1 for the become-leader transition for partition [app,0] (state.change.logger)";
		String parntern = "(?<timestamp>%{YEAR}-%{MONTHNUM}-%{MONTHDAY} %{HOUR}:%{MINUTE}:%{SECOND})] %{LOGLEVEL:level} %{GREEDYDATA:msg}";
		logger.trace(trace);
		return "Hello  trace";
	}

	@RequestMapping(value = "/debug", method = RequestMethod.GET)
	public String doDebug() {
		String debug = "[2018-02-23 17:18:24,166] DEBUG [Controller 1001]: topics not in preferred replica Map() (kafka.controller.KafkaController)";
		String parntern = "\\[(?<timestamp>%{YEAR}-%{MONTHNUM}-%{MONTHDAY} %{HOUR}:%{MINUTE}:%{SECOND})\\] %{LOGLEVEL:level} \\[%{DATA:thread}\\]: %{GREEDYDATA:msg}";
		logger.debug(debug);
		return "Hello  debug";
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String doInfo() {
		String info = "2018-02-16 17:58:03,897 - INFO  [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:NIOServerCnxnFactory@197] - Accepted socket connection from /172.20.1.23:47266";
		String parntern = "(?<timestamp>%{YEAR}-%{MONTHNUM}-%{MONTHDAY} %{HOUR}:%{MINUTE}:%{SECOND}) - %{LOGLEVEL:level}  \\[%{DATA:thread}\\] - %{GREEDYDATA:msg}";
		return "Hello  info";
	}

	@RequestMapping(value = "/warn", method = RequestMethod.GET)
	public String doWarn() {
		String warn = "[2018-02-05T16:30:45,468][WARN ][logstash.config.source.multilocal] Ignoring the 'pipelines.yml' file because modules or command line options are specified";
		String parntern = "\\[(?<timestamp>%{YEAR}-%{MONTHNUM}-%{MONTHDAY}T%{HOUR}:%{MINUTE}:%{SECOND})\\]\\[%{LOGLEVEL:logLevel} \\]\\[%{GREEDYDATA:opt}\\] %{GREEDYDATA:msg}";
		logger.warn(warn);
		return "Hello  warn";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String doError() {
		String error = "[17:03:46:894] [ERROR] - org.apache.juli.logging.DirectJDKLog.log(DirectJDKLog.java:181) - Servlet.service() for servlet [dispatcherServlet] in co\r\n"
				+ "ntext with path [/ingest] threw exception [Request processing failed; nested exception is com.alibaba.fastjson.JSONException: No enum constant com\r\n"
				+ ".zetyun.aiops.common.entity.StatusEnum.BEGAIN] with root cause\r\n"
				+ "java.lang.IllegalArgumentException: No enum constant com.zetyun.aiops.common.entity.StatusEnum.BEGAIN\r\n"
				+ "        at java.lang.Enum.valueOf(Enum.java:238) ~[?:1.8.0_141]\r\n"
				+ "        at com.alibaba.fastjson.parser.deserializer.EnumDeserializer.deserialze(EnumDeserializer.java:48) ~[fastjson-1.2.15.jar!/:?]\r\n"
				+ "        at com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer.parseField(DefaultFieldDeserializer.java:55) ~[fastjson-1.2.15.jar!/:\r\n"
				+ "?]\r\n"
				+ "        at com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.parseField(JavaBeanDeserializer.java:662) ~[fastjson-1.2.15.jar!/:?]\r\n"
				+ "        at com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(JavaBeanDeserializer.java:564) ~[fastjson-1.2.15.jar!/:?]\r\n"
				+ "        at com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.parseRest(JavaBeanDeserializer.java:795) ~[fastjson-1.2.15.jar!/:?]\r\n"
				+ "        at com.alibaba.fastjson.parser.deserializer.FastjsonASMDeserializer_1_Collector.deserialze(Unknown Source) ~[?:?]\r\n"
				+ "        at com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(JavaBeanDeserializer.java:185) ~[fastjson-1.2.15.jar!/:?]\r\n"
				+ "        at com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(DefaultJSONParser.java:614) ~[fastjson-1.2.15.jar!/:?]\r\n"
				+ "        at com.alibaba.fastjson.JSON.parseObject(JSON.java:339) ~[fastjson-1.2.15.jar!/:?]\r\n"
				+ "        at com.alibaba.fastjson.JSON.parseObject(JSON.java:307) ~[fastjson-1.2.15.jar!/:?]\r\n"
				+ "        at com.alibaba.fastjson.JSON.parseObject(JSON.java:270) ~[fastjson-1.2.15.jar!/:?]\r\n"
				+ "        at com.alibaba.fastjson.JSON.parseObject(JSON.java:370) ~[fastjson-1.2.15.jar!/:?]\r\n"
				+ "        at com.alibaba.fastjson.JSON.parseObject(JSON.java:452) ~[fastjson-1.2.15.jar!/:?]\r\n"
				+ "        at com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter.read(FastJsonHttpMessageConverter.java:192) ~[fastjson-1.2.15.jar!/:?]\r\n"
				+ "        at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver.readWithMessageConverters(Abstract\r\n"
				+ "MessageConverterMethodArgumentResolver.java:201) ~[spring-webmvc-4.3.13.RELEASE.jar!/:4.3.13.RELEASE]\r\n"
				+ "        at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.readWithMessageConverters(RequestResponseBodyM\r\n"
				+ "ethodProcessor.java:150) ~[spring-webmvc-4.3.13.RELEASE.jar!/:4.3.13.RELEASE]\r\n"
				+ "        at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.resolveArgument(RequestResponseBodyMethodProce\r\n"
				+ "ssor.java:128) ~[spring-webmvc-4.3.13.RELEASE.jar!/:4.3.13.RELEASE]\r\n"
				+ "        at org.springframework.web.method.support.HandlerMethodArgumentResolverComposite.resolveArgument(HandlerMethodArgumentResolverComposite.ja\r\n"
				+ "va:121) ~[spring-web-4.3.13.RELEASE.jar!/:4.3.13.RELEASE]\r\n"
				+ "        at org.springframework.web.method.support.InvocableHandlerMethod.getMethodArgumentValues(InvocableHandlerMethod.java:158) ~[spring-web-4.3\r\n"
				+ ".13.RELEASE.jar!/:4.3.13.RELEASE]\r\n"
				+ "        at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:128) ~[spring-web-4.3.13.REL\r\n"
				+ "EASE.jar!/:4.3.13.RELEASE]\r\n"
				+ "        at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:\r\n"
				+ "97) ~[spring-webmvc-4.3.13.RELEASE.jar!/:4.3.13.RELEASE]\r\n"
				+ "        at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.jav\r\n"
				+ "a:827) ~[spring-webmvc-4.3.13.RELEASE.jar!/:4.3.13.RELEASE]\r\n"
				+ "        at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:738\r\n"
				+ ") ~[spring-webmvc-4.3.13.RELEASE.jar!/:4.3.13.RELEASE]\r\n"
				+ "        at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:85) ~[spring-webmvc-4.\r\n"
				+ "3.13.RELEASE.jar!/:4.3.13.RELEASE]\r\n"
				+ "        at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:967) ~[spring-webmvc-4.3.13.RELEASE.jar!/:4.3.13.RE\r\n"
				+ "LEASE]\r\n"
				+ "        at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:901) ~[spring-webmvc-4.3.13.RELEASE.jar!/:4.3.13.REL\r\n"
				+ "EASE]\r\n"
				+ "        at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:970) ~[spring-webmvc-4.3.13.RELEASE.jar!/:4.3.13.\r\n"
				+ "RELEASE]\r\n"
				+ "        at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:872) ~[spring-webmvc-4.3.13.RELEASE.jar!/:4.3.13.RELEASE]\r\n"
				+ "        at javax.servlet.http.HttpServlet.service(HttpServlet.java:661) ~[tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:846) ~[spring-webmvc-4.3.13.RELEASE.jar!/:4.3.13.RELEASE\r\n"
				+ "]\r\n"
				+ "        at javax.servlet.http.HttpServlet.service(HttpServlet.java:742) ~[tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231) ~[tomcat-embed-core-8.5.23.jar!/:8.5.\r\n"
				+ "23]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52) ~[tomcat-embed-websocket-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.23.jar!/:8.5.\r\n"
				+ "23]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.springframework.boot.web.filter.ApplicationContextHeaderFilter.doFilterInternal(ApplicationContextHeaderFilter.java:55) ~[spring-bo\r\n"
				+ "ot-1.5.9.RELEASE.jar!/:1.5.9.RELEASE]\r\n"
				+ "        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.3.13.RELEASE.jar!/:4.3.13.RE\r\n"
				+ "LEASE]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.23.jar!/:8.5.\r\n"
				+ "23]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:123) ~[druid-1.0.18.jar!/:1.0.18]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.23.jar!/:8.5.\r\n"
				+ "23]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.springframework.boot.actuate.trace.WebRequestTraceFilter.doFilterInternal(WebRequestTraceFilter.java:110) ~[spring-boot-actuator-1.\r\n"
				+ "5.9.RELEASE.jar!/:1.5.9.RELEASE]\r\n"
				+ "        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.3.13.RELEASE.jar!/:4.3.13.RE\r\n"
				+ "LEASE]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.23.jar!/:8.5.\r\n"
				+ "23]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:99) ~[spring-web-4.3.13.RELEASE.jar!/:4.\r\n"
				+ "3.13.RELEASE]\r\n"
				+ "        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.3.13.RELEASE.jar!/:4.3.13.RE\r\n"
				+ "LEASE]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.23.jar!/:8.5.\r\n"
				+ "23]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.springframework.web.filter.HttpPutFormContentFilter.doFilterInternal(HttpPutFormContentFilter.java:108) ~[spring-web-4.3.13.RELEASE\r\n"
				+ ".jar!/:4.3.13.RELEASE]\r\n"
				+ "        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.3.13.RELEASE.jar!/:4.3.13.RE\r\n"
				+ "LEASE]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.23.jar!/:8.5.\r\n"
				+ "23]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:81) ~[spring-web-4.3.13.RELEASE.jar!\r\n"
				+ "/:4.3.13.RELEASE]\r\n"
				+ "        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.3.13.RELEASE.jar!/:4.3.13.RE\r\n"
				+ "LEASE]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.23.jar!/:8.5.\r\n"
				+ "23]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:197) ~[spring-web-4.3.13.RELEASE.j\r\n"
				+ "ar!/:4.3.13.RELEASE]\r\n"
				+ "        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.3.13.RELEASE.jar!/:4.3.13.RE\r\n"
				+ "LEASE]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.23.jar!/:8.5.\r\n"
				+ "23]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.springframework.boot.actuate.autoconfigure.MetricsFilter.doFilterInternal(MetricsFilter.java:106) ~[spring-boot-actuator-1.5.9.RELE\r\n"
				+ "ASE.jar!/:1.5.9.RELEASE]\r\n"
				+ "        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.3.13.RELEASE.jar!/:4.3.13.RE\r\n"
				+ "LEASE]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.23.jar!/:8.5.\r\n"
				+ "23]\r\n"
				+ "        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:199) [tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96) [tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:478) [tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:140) [tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:81) [tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:87) [tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:342) [tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:803) [tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66) [tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868) [tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1459) [tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) [tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149) [?:1.8.0_141]\r\n"
				+ "        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624) [?:1.8.0_141]\r\n"
				+ "        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-8.5.23.jar!/:8.5.23]\r\n"
				+ "        at java.lang.Thread.run(Thread.java:748) [?:1.8.0_141]abcdefg";
		logger.error(error);
		return "Hello  error";
	}

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

	@RequestMapping(value = "/relog")
	public String reinfo() {
		CacheManager.getInstance();
		return "relog info and warn";
	}

}
