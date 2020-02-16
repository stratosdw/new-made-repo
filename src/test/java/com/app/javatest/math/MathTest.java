package com.app.javatest.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.javatest.math.service.impl.CalcServiceImpl;

public class MathTest {

	private static CalcServiceImpl calcService;
	private static int[] array;

	@BeforeAll
	static void setUp() {
		calcService = new CalcServiceImpl();
	}

	@BeforeEach
	public void init() {
		array = new int[] { 1, 2, 2, 2, 2, 4, 5, 6, 6, 6, 6, 7, 8 };
	}

	@Test
	public void calcMedian() {
		double median = 5;
		assertNotNull(calcService.calculateMedian(array));
		assertEquals(median, (double) calcService.calculateMedian(array));

		array = new int[] { -1 };
		assertNotNull(calcService.calculateMedian(array));
	}

	@Test
	public void calcMean() {
		double median = 4.384615384615385;
		assertNotNull(calcService.calculateMean(array));
		assertEquals(median, (double) calcService.calculateMean(array));

		array = new int[] { -1 };
		assertNotNull(calcService.calculateMean(array));

	}

	@Test
	public void calcMode() {
		List<Integer> list = Arrays.asList(2, 6);
		assertNotNull(calcService.calculateMode(array));
		assertEquals(list, calcService.calculateMode(array));

		array = new int[] { -1 };
		assertNotNull(calcService.calculateMode(array));
	}

	@Test
	public void calcRange() {
		String testString = "(4) range [min: " + 1 + "; max: " + 8 + "]";
		assertNotNull(calcService.calculateRange(array));
		assertEquals(testString, calcService.calculateRange(array));

		array = new int[] { -1 };
		assertNotNull(calcService.calculateRange(array));
	}

	@Test
	public void calcArrayEmpty() {
		array = new int[] {};
		assertThrows(IllegalArgumentException.class, () -> calcService.calculateMedian(array));
		assertThrows(IllegalArgumentException.class, () -> calcService.calculateMean(array));
		assertThrows(IllegalArgumentException.class, () -> calcService.calculateMode(array));
		assertThrows(IllegalArgumentException.class, () -> calcService.calculateRange(array));
	}

	@Test
	public void calcArrayNull() {
		array = null;
		assertThrows(NullPointerException.class, () -> calcService.calculateMedian(array));
		assertThrows(NullPointerException.class, () -> calcService.calculateMedian(array));
		assertThrows(NullPointerException.class, () -> calcService.calculateMode(array));
		assertThrows(NullPointerException.class, () -> calcService.calculateRange(array));
	}

}
