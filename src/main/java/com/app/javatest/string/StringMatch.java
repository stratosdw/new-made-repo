package com.app.javatest.string;

public class StringMatch {

	private String title;
	private double qualityScore;

	public StringMatch() {
	}

	public StringMatch(String title, double qualityScore) {
		this.title = title;
		this.qualityScore = qualityScore;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getQualityScore() {
		return qualityScore;
	}

	public void setQualityScore(double qualityScore) {
		this.qualityScore = qualityScore;
	}
}
