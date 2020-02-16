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
	 * <br/>
	 * Levenshtein distance algorithm from
	 * org.apache.commons.text.similarity.LevenshteinDistance
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

				double result = (longestString - this.apply(string1, string2)) / (double) longestString;
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

	/***
	 * Levenshtein distance algorithm implementation taken from
	 * org.apache.commons.text.similarity.LevenshteinDistance.
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	private int apply(CharSequence left, CharSequence right) {
		if (left == null || right == null) {
			throw new IllegalArgumentException("CharSequences must not be null");
		}

		/*
		 * This implementation use two variable to record the previous cost counts, So
		 * this implementation use less memory than previous impl.
		 */

		int n = left.length(); // length of left
		int m = right.length(); // length of right

		if (n == 0) {
			return m;
		} else if (m == 0) {
			return n;
		}

		if (n > m) {
			// swap the input strings to consume less memory
			final CharSequence tmp = left;
			left = right;
			right = tmp;
			n = m;
			m = right.length();
		}

		final int[] p = new int[n + 1];

		// indexes into strings left and right
		int i; // iterates through left
		int j; // iterates through right
		int upperLeft;
		int upper;

		char rightJ; // jth character of right
		int cost; // cost

		for (i = 0; i <= n; i++) {
			p[i] = i;
		}

		for (j = 1; j <= m; j++) {
			upperLeft = p[0];
			rightJ = right.charAt(j - 1);
			p[0] = j;

			for (i = 1; i <= n; i++) {
				upper = p[i];
				cost = left.charAt(i - 1) == rightJ ? 0 : 1;
				// minimum of cell to the left+1, to the top+1, diagonally left and up +cost
				p[i] = Math.min(Math.min(p[i - 1] + 1, p[i] + 1), upperLeft + cost);
				upperLeft = upper;
			}
		}
		return p[n];
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
