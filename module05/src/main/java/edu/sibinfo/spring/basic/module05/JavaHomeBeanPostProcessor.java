package edu.sibinfo.spring.basic.module05;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class JavaHomeBeanPostProcessor implements BeanPostProcessor{

	@Autowired
	Environment environment;
	
	private Map<String, String> fieldNames = new HashMap<>();  
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.printf("CustomBeanPostProcessor.Before: %s - %s, %n", beanName, bean);
		for (Field field : bean.getClass().getFields()) {
			if (field.isAnnotationPresent(JavaHome.class)) {
				if (field.getType() != String.class) {
					throw new BeanInitializationException(String.format("CustomBeanPostProcessor: Field '%s' must be a String", field.getName()));
				}
				fieldNames.put(beanName, field.getName());
				return bean;
			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		String fieldName = fieldNames.get(beanName);
		if (fieldName == null) {
			System.out.printf("CustomBeanPostProcessor.After : %s - %s%n", beanName, bean);
			return bean;
		}
		try {
			Field field = bean.getClass().getField(fieldName);
			field.set(bean, environment.getProperty("JAVA_HOME"));
		} catch (NoSuchFieldException | SecurityException e) {
			throw new BeanInitializationException(String.format("CustomBeanPostProcessor: Field '%s' is missing", fieldName), e);
		} catch (IllegalAccessException | IllegalArgumentException e) {
			throw new BeanInitializationException(String.format("CustomBeanPostProcessor: Failed to set '%s'", fieldName), e);
		}
		System.out.printf("CustomBeanPostProcessor.After : %s - %s%n", beanName, bean);
		return bean;
	}

}
