package com.app.javatest.math.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.app.javatest.math.service.ICalcService;

public class CalcServiceImpl implements ICalcService {

	/***
	 * Calculates the range (minimum and maximum) of the array
	 * 
	 * @param array
	 * @return (4) range [min: {@min}; max: {@max}]
	 */
	public String calculateRange(int[] array) {
		this.empty(array);		

		int min = 0;
		int max = 0;
		min = array[0];
		max = array[array.length - 1];
		
		return "(4) range [min: " + min + "; max: " + max + "]";
	}

	/***
	 * Calculates the mode (numbers that appear most often) of the array.
	 * <br/>
	 * When the number is found will look for duplicates and add to a list.
	 * 
	 * @param array
	 * @return List<Integer> 
	 */
	public List<Integer> calculateMode(int[] array) {
		this.empty(array);
		
		// Maps the array (key: number, value: count)
		Map<Integer, Integer> modeMap = new HashMap<>();
		List<Integer> mostCommonNumbers = new ArrayList<>();
		try {
			for (int i : array) {
				if (modeMap.containsKey(i)) {
					modeMap.put(i, modeMap.get(i) + 1);
				} else {
					modeMap.put(i, 1);
				}
			}
			// Maximum number of the most common numbers
			int maxCommon = Collections.max(modeMap.entrySet(), Map.Entry.comparingByValue()).getValue();

			// Looks other other possible maximum common duplicates
			for (Entry<Integer, Integer> entry : modeMap.entrySet()) {
				if (maxCommon == entry.getValue()) {
					mostCommonNumbers.add(entry.getKey());
				}
			}
		} catch (Exception e) {
			System.out.printf("An error occured while calculating mode: %s", e);
		}
		return mostCommonNumbers;
	}

	/***
	 * Calculates the mean of the array
	 * 
	 * @param array
	 * @return double
	 */
	public double calculateMean(int[] array) {
		this.empty(array);		
		double result = 0;
		double sum = 0;
		
		for (int i : array) {
			sum += i;
		}
		result = sum / array.length;

		return result;
	}

	/***
	 * Calculates the median of the array
	 * 
	 * @param array
	 * @return double
	 */
	public double calculateMedian(int[] array) {
		this.empty(array);
		
		double median = 0;
		if (array.length % 2 == 0) {
			median = ((double) array[array.length / 2] + (double) array[array.length / 2 - 1]) / 2;
		} else {
			median = (double) array[array.length / 2];
		}
		return median;
	}
	
	/***
	 * Checks if the array is null or zero-length
	 * 
	 * @param array
	 */
	public void empty(int[] array) {
		if (array == null) {
			throw new NullPointerException("Null arrays are invalid");
		}
		if (array.length == 0) {
			throw new IllegalArgumentException("Zero length arrays are invalid");
		}
	}
}
