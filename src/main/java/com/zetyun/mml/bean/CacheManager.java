package com.zetyun.mml.bean;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public class CacheManager {

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
					System.out.println("TimerTask is called!");
					doRun();
				}
			};

			Timer timer = new Timer();
			timer.schedule(task, 0, 1000 * 3);
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
