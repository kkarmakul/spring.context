package edu.sibinfo.spring.basic.module02.impl;

import edu.sibinfo.spring.basic.module02.SmsService;

public class SmsServiceImpl implements SmsService {

	public void send(String mobile, String text) {
		System.out.printf("%s : \"%s\"", mobile, text).println();;
	}
}
