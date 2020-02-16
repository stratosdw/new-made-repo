package com.app.javatest.math.service;

import java.util.List;

public interface ICalcService {

	String calculateRange(int[] array);

	List<Integer> calculateMode(int[] array);

	double calculateMean(int[] array);

	double calculateMedian(int[] array);
}
