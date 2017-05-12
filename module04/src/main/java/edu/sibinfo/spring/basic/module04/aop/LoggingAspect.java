package edu.sibinfo.spring.basic.module04.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	@Before("execution(* edu.sibinfo.spring.basic.module04.service.impl.ClientServiceImpl.register(..)) && args(first, family, ..)")
	void printBefore(String first, String family) {	
		System.out.printf("Started register(%s, %s)%n", first, family);
	}

	@After("execution(* edu.sibinfo.spring.basic.module04.service.impl.ClientServiceImpl.register(..))")
	void printAfter() {
		System.out.println("Finished");
	}
}
