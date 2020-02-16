package com.app.javatest.stack;

import com.app.javatest.stack.service.impl.ObservableStackImpl;
import com.app.javatest.stack.service.impl.StackImpl;

public class MyStackClass {

	private static final String PEEKING = "Peeking: ";

	/**
	 * Generic Stack implementation
	 * 
	 * @return
	 */
	public Object genericStack() {
		StackImpl<Object> stack = new StackImpl<>();
		
		for (int i = 0; i < 50; i++) {
			stack.push(Math.random() * 100);
			System.out.println(PEEKING + stack.peek());
		}
		System.out.println(PEEKING + stack.peek());
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.pop();
		System.out.println(PEEKING + stack.peek());
		stack.push(5);
		stack.push(2);
		System.out.println(PEEKING + stack.peek());

		return stack.peek();
	}

	/***
	 * Stack implementation with Observer notification
	 */
	public int notifyStack() {
		ObservableStackImpl<Object> observableStack = new ObservableStackImpl<>();
		ObserverSubject firstObserver = new ObserverSubject("John Smith");
		ObserverSubject secondObserver = new ObserverSubject("John Doe");

		observableStack.addObserver(firstObserver);
		observableStack.push(1);
		observableStack.push(2);
		observableStack.push(3);
		observableStack.addObserver(secondObserver);
		observableStack.push(4);
		observableStack.deleteObserver(firstObserver);
		observableStack.pop();
		System.out.println(PEEKING + observableStack.peek());
		observableStack.push(5);
		System.out.println(PEEKING + observableStack.peek());
		observableStack.pop();
		observableStack.push(2);
		System.out.println(PEEKING + observableStack.peek());

		return observableStack.countObservers();
	}
}
