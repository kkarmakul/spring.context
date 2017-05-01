package edu.sibinfo.spring.basic.module06;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("app-config.properties")
public class ApplicationConfig {

	@Value("${JAVA_HOME}")
	private String javaHome;

	@Value("${edu.sibinfo.spring.basic.oauth.url}")
	private String oauthURL;

	public String getJavaHome() {
		return javaHome;
	}

	public String getOauthURL() {
		return oauthURL;
	}
}
