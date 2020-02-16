package com.app.javatest;

import com.app.javatest.stack.MyStackClass;

public class StackMain {

	/***
	 * Main method of the third problem
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyStackClass myClass = new MyStackClass();

		myClass.genericStack();
		System.out.println("------------------------");
		myClass.notifyStack();
	}
}
