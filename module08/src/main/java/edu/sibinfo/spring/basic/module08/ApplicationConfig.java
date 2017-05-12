package edu.sibinfo.spring.basic.module08;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ApplicationConfig {

	@Bean("eventExecutor")
	public TaskExecutor createEventExecutor() {
		return createExecutor("evt-");
	}
	
	@Bean("serviceExecutor")
	public TaskExecutor createServiceExecutor() {
		return createExecutor("svc-");
	}

	private ThreadPoolTaskExecutor createExecutor(String threadPrefix) {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		CustomizableThreadFactory threadFactory = new CustomizableThreadFactory();
		threadFactory.setThreadGroupName("async");
		threadFactory.setThreadNamePrefix(threadPrefix);
		executor.setThreadFactory(threadFactory);
		executor.setCorePoolSize(3);
		executor.setMaxPoolSize(4);
		
		// Guaranteed grace termination, unless tasks will take more than a second
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setAwaitTerminationSeconds(1);
		
		return executor;
	}
}
