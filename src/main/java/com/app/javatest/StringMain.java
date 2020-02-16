package com.app.javatest;

import com.app.javatest.string.Normaliser;

public class StringMain {

	/***
	 * Main method of the first problem
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Normaliser n = new Normaliser();
		
		String jt = "Java engineer";
		String normalisedTitle = n.normalise(jt);
		System.out.println("\"" + jt + "\"" + " -> " + "\"" + normalisedTitle + "\"" + "\n");

		jt = "C# engineer";
		normalisedTitle = n.normalise(jt);
		System.out.println("\"" + jt + "\"" + " -> " + "\"" + normalisedTitle + "\"" + "\n");

		jt = "Accountant";
		normalisedTitle = n.normalise(jt);
		System.out.println("\"" + jt + "\"" + " -> " + "\"" + normalisedTitle + "\"" + "\n");

		jt = "Chief Accountant";
		normalisedTitle = n.normalise(jt);
		System.out.println("\"" + jt + "\"" + " -> " + "\"" + normalisedTitle + "\"" + "\n");

	}

}
