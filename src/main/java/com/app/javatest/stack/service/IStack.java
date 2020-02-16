package com.app.javatest.stack.service;

public interface IStack<T> {

	/***
	 * Checks if the stack is empty
	 * 
	 * @return
	 */
	boolean empty();

	/***
	 * Look at and return (but don’t remove) the top of the stack
	 * 
	 * @return
	 */
	T peek();

	/***
	 * Removes and returns the entry at the top of the stack
	 * 
	 * @return
	 */
	T pop();

	/***
	 * Pushes item onto the stack top
	 * 
	 * @param item
	 */
	void push(T item);

}