package com.android_spinner_demo;

public class SpinnerData_Items {
	String text;
	Integer image;

	// Getter and setter for custom spinner
	public SpinnerData_Items(String text, Integer image) {
		this.text = text;
		this.image = image;
	}

	// Return the text
	public String getText() {
		return text;
	}

	// Return the image
	public int getImage() {
		return image;
	}
}
