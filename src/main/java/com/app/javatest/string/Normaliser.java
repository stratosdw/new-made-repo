package com.app.javatest.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Normaliser {

	private List<String> normalisedList = Arrays.asList("Architect", "Software engineer", "Quantity surveyor",
			"Accountant");

	/***
	 * Normalises a string based on the Levenshtein distance algorithm with the
	 * given normalised list ["Architect", "Software engineer", "Quantity surveyor",
	 * "Accountant"] <br/>
	 * <br/>
	 * Finds the Levenshtein distance between two strings, the higher the score the
	 * greater the distance. <br/>
	 * 
	 * @param string1
	 * @return Returns the string with the highest distance value
	 */
	public String normalise(String string1) {
		if (this.empty(string1)) {
			throw new IllegalArgumentException("String must not be null or empty");
		}

		List<StringMatch> qualityScores = new ArrayList<>();
		StringMatch rtrn = new StringMatch();

		// Loops the normalised list with the given input and calculates the quality
		// score for all the possibilities, with the use of the Levenshtein library
		for (String string2 : normalisedList) {
			if (!this.empty(string2)) {
				int longestString = (string1.length() > string2.length()) ? string1.length() : string2.length();

				double result = (longestString - this.calculatesDistance(string1, string2)) / (double) longestString;
				StringMatch n = new StringMatch(string2, result);
				qualityScores.add(n);
			}
		}

		// Runs the stream and gets the highest quality score
		Optional<StringMatch> resultTitle = qualityScores.stream()
				.max(Comparator.comparing(StringMatch::getQualityScore));
		if (resultTitle.isPresent()) {
			rtrn = resultTitle.get();
			System.out.println("quality score: " + rtrn.getQualityScore());
		}
		return rtrn.getTitle();
	}

	private int calculatesDistance(String left, String right) {
		int leftLength = left.length() + 1;
		int rightLength = right.length() + 1;
		
		int[][] matrix = new int[leftLength][rightLength];

		for (int i = 1; i < leftLength; i++) {
			// fills x-axis
			matrix[i][0] = i;
			int indexIMinus = i - 1;
			for (int j = 1; j < rightLength; j++) {
				// fills y-axis
				matrix[0][j] = j;
				int operationCost = 0;
				int indexJMinus = j - 1;
				
				// if an operation is done (insert, replace, delete), costs 1
				if (left.charAt(indexIMinus) != right.charAt(indexJMinus)) {
					operationCost = 1;
				}
				
				// gets the minimum value of the three operations
				matrix[i][j] = Math.min(
						Math.min(matrix[indexIMinus][j] + 1, matrix[i][indexJMinus] + 1),
						matrix[indexIMinus][indexJMinus] + operationCost);
			}
		}

		return matrix[left.length()][right.length()];
	}
		
	/***
	 * Checks if string is empty ("") or null.
	 * 
	 * @param val
	 * @return
	 */
	public boolean empty(String val) {
		return val == null || val.length() == 0;
	}

}
