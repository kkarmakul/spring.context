package edu.sibinfo.spring.basic.module05.slc;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.context.SmartLifecycle;

import edu.sibinfo.spring.basic.module05.util.CommonUtil;

public class AbstractLifeCycleChecker implements SmartLifecycle {
	private Lock lock = new ReentrantLock();
	private AtomicBoolean isRunning = new AtomicBoolean(false);

	@Override
	public void start() {
		log("start()...");
		if (isRunning()) {
			log("start()'ed long ago");
			return;
		}
		CompletableFuture.runAsync(() -> {
			lock.lock();
			try {
				if (isRunning.get()) {
					log("start()'ed a moment ago");
					return;
				}
				CommonUtil.waitABit();
				isRunning.set(true);
				log("start()'ed successfully");
			} finally {
				lock.unlock();
			}
		});
		log("start() finished");
	}

	@Override
	public void stop(final Runnable callback) {
		log("stop()...");
		CompletableFuture.runAsync(() -> {
			try {
				CommonUtil.waitABit();
				isRunning.set(false);
				log("stop()'ed");
			} finally {
				if (callback != null) {
					log("callback: " + callback);
					callback.run();
				}
			}
		});
		log("stop() finished");
	}
	
	@Override
	public void stop() {
		stop(null);
	}

	@Override
	public boolean isRunning() {
		return isRunning.get();
	}

	@Override
	public int getPhase() {
		return 0;
	}

	@Override
	public boolean isAutoStartup() {
		return true;
	}

	private void log(String message) {
		System.out.printf("%s %s: %s%n", LocalDateTime.now(), getClass().getSimpleName(), message);		
	}
}
