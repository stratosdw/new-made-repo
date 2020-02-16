package com.app.javatest.stack.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.app.javatest.stack.service.IStack;

/***
 * Stack implementation without notification
 *
 * @param <T>
 */
public class StackImpl<T> implements IStack<T> {

	private List<T> array;

	public StackImpl() {
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

	@Override
	public T pop() {
		if (this.empty()) {
			throw new NoSuchElementException("Can't pop of an empty stack.");
		}
		return array.remove(array.size() - 1);
	}

	@Override
	public void push(T item) {
		if (item == null) {
			throw new IllegalArgumentException("item can't be null.");
		}
		array.add(item);
	}

}