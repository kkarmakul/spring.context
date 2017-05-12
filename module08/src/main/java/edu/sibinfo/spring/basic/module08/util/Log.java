package edu.sibinfo.spring.basic.module08.util;

import java.time.LocalDateTime;

public class Log {

	public static final void log(String format, Object... args) {
		String prefix = String.format("[%s] [%s] ", 
				Thread.currentThread().getName(), 
				LocalDateTime.now());
		System.out.printf(prefix + format, args).println();
	}
}
