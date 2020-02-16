package com.app.javatest.stack.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Observable;

import com.app.javatest.stack.service.IStack;

/***
 * Stack implementation with notification using Observable
 * 
 * @param <T>
 */
public class ObservableStackImpl<T> extends Observable implements IStack<T> {

	private List<T> array;

	public ObservableStackImpl() {
		array = new ArrayList<>();
	}

	@Override
	public boolean empty() {
		return array == null || array.isEmpty();
	}

	@Override
	public T peek() {
		if (this.empty()) {
			throw new NoSuchElementException("Can't peek of an empty stack.");
		}
		return array.get(array.size() - 1);
	}

	/***
	 * Removes and returns the entry at the top of the stack
	 * <br/>
	 * Will notify the subscribed observers in case of a change 
	 */
	@Override
	public T pop() {
		if (this.empty()) {
			throw new NoSuchElementException("Can't pop of an empty stack.");
		}
		setChanged();
		notifyObservers();
		return array.remove(array.size() - 1);
	}

	/***
	 * Pushes item onto the stack top
	 * <br/>
	 * Will notify the subscribed observers in case of a change
	 */
	@Override
	public void push(T item) {
		if (item == null) {
			throw new IllegalArgumentException("item can't be null.");
		}
		setChanged();
		notifyObservers();
		array.add(item);
	}

}