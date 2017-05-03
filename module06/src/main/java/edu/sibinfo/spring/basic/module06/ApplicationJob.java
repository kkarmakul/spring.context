package edu.sibinfo.spring.basic.module06;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

@Component
public class ApplicationJob {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Schedules({
		@Scheduled(cron="*/3 * * * * *"),
		@Scheduled(fixedRate=2000),
		@Scheduled(fixedDelay=2000)})
	public void work() {
		System.out.printf("ApplicationJob.work: %s %s%n", Thread.currentThread().getName(), LocalDateTime.now());
		publisher.publishEvent("ApplicationJob.work done");
	}
}
