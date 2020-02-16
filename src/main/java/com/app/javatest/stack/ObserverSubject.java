package com.app.javatest.stack;

import java.util.Observable;
import java.util.Observer;

public class ObserverSubject implements Observer {

	private String name;

	public ObserverSubject(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(name + "- notified!");
	}

	public void setName(String name) {
		this.name = name;
	}
}
