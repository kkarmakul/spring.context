package edu.sibinfo.spring.basic.module05;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CustomInitDestroyIfc implements InitializingBean, DisposableBean {

	@Autowired
	private ApplicationContext appContext;

	@Override
	public void destroy() throws Exception {
		System.out.printf("CustomInitDestroyIfc.destroy() %n");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.printf("CustomInitDestroyIfc.afterPropertiesSet: %s%n", this);
	}

	@Override
	public String toString() {
		return "CustomInitDestroyIfc [appContext=" + appContext + "]";
	}

}
