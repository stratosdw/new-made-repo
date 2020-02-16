package com.app.javatest;

import java.security.SecureRandom;

import com.app.javatest.math.MyMathClass;

public class MathMain {

	/***
	 * Main method of the second problem
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int input = 5000;
		int[] mybigarray = generateSomeHugeArray(input);

		MyMathClass myClass = new MyMathClass();
		myClass.getStats(mybigarray);

	}

	/***
	 * Generates a huge array with a defined input
	 * 
	 * @param input
	 * @return
	 */
	private static int[] generateSomeHugeArray(int input) {
		int[] array = new int[input];
		SecureRandom r = new SecureRandom();
		for (int i = 0; i < input; i++) {
			array[i] = r.nextInt(input);
		}
		return array;
	}
}
