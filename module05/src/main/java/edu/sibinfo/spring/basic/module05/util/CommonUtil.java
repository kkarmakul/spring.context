package edu.sibinfo.spring.basic.module05.util;

public class CommonUtil {

	private CommonUtil() {
		throw new AssertionError("CommonUtil is non-instantiable");
	}
	
	public static void waitABit() {
		try {
			Thread.sleep(101);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
