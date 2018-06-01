package com.zetyun.mml.bean;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheManager {

	protected static Logger logger = LoggerFactory.getLogger(CacheManager.class);

	private ConcurrentHashMap<String, String> cacheContainer;
	private static volatile CacheManager cacheManager;
	private long timeout;
	private final String DELIMITER = ":";

	public static CacheManager getInstance() {
		if (cacheManager == null) {
			synchronized (CacheManager.class) {
				if (cacheManager == null) {
					cacheManager = new CacheManager(1000 * 30);
				}
			}
		}
		return cacheManager;
	}

	private CacheManager(long timeout) {
		this.timeout = timeout;
		cacheContainer = new ConcurrentHashMap<>();
		CleanCacheTimer cacheCleanerThread = new CleanCacheTimer();
		cacheCleanerThread.start();
	}

	public void setCache(AgentCache agent) {
		String updateTime = String.valueOf(System.currentTimeMillis());
		String key = String.join(DELIMITER, agent.getHostname(), agent.getIp(), agent.getPort());
		cacheContainer.put(key, updateTime);
	}

	public String getCache() {

		return cacheContainer.toString();
	}

	class CleanCacheTimer {

		public void start() {

			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					// System.out.println("TimerTask is called!");
					String info = "2018-02-16 17:58:03,897 - INFO  [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:NIOServerCnxnFactory@197] - Accepted socket connection from /172.20.1.23:47266";
					String warn = "[2018-02-05T16:30:45,468][WARN ][logstash.config.source.multilocal] Ignoring the 'pipelines.yml' file because modules or command line options are specified";
					logger.warn(warn);
					logger.info(info);
					// doRun();
				}
			};

			Timer timer = new Timer();
			timer.schedule(task, 0, 1000 * 8);
		}

		private void doRun() {

			for (Map.Entry<String, String> entry : cacheContainer.entrySet()) {
				String hostKey = entry.getKey();
				String lastTime = entry.getValue();
				if (System.currentTimeMillis() - Long.parseLong(lastTime) >= timeout) {
					cacheContainer.remove(hostKey);
				}
			}

		}

	}

}
