package com.app.javatest.math;

import java.util.Arrays;
import java.util.List;

import com.app.javatest.math.service.impl.CalcServiceImpl;

public class MyMathClass {

	public void getStats(int[] array) {
		CalcServiceImpl calcService = new CalcServiceImpl();
		// Sorts the array
		Arrays.sort(array);
		// that calculates the (1) median, (2) mean, (3) mode and (4) range for the
		// array
		double median = calcService.calculateMedian(array);
		double mean = calcService.calculateMean(array);
		List<Integer> mode = calcService.calculateMode(array);
		System.out.println("(1) median: " + median);
		System.out.println("(2) mean: " + mean);
		System.out.println("(3) mode: " + mode);
		System.out.println(calcService.calculateRange(array));
	}

}
