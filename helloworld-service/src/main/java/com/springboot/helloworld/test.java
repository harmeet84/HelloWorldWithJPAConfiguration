package com.springboot.helloworld;

import java.util.Locale;

import org.apache.commons.lang.RandomStringUtils;

public class test {
	public static void main (String args[]) {
		int min = 8;
		int max = 8;
		String randomNum = RandomStringUtils.randomNumeric(6).toUpperCase(Locale.ENGLISH);
		
		System.out.println("value of rand = " + randomNum + "80");
	}
}