package com.app.javatest.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.javatest.stack.service.impl.ObservableStackImpl;

public class ObservableStackTest {

	private MyStackClass myStackClass = new MyStackClass();
	private ObservableStackImpl<Object> stack;


	@BeforeEach
	void init() {
		stack = new ObservableStackImpl<>();
	}

	@Test
	public void testStack() {
		// Observer count
		assertNotNull(myStackClass.notifyStack());
		assertEquals(1, myStackClass.notifyStack());
	}

	@Test
	public void stackPeek() {
		String testString = "Valid Test";
		stack.push(testString);
		assertNotNull(stack.peek());
		assertEquals(testString, stack.peek());
	}

	@Test
	public void stackPeekInvalid() {
		assertThrows(NoSuchElementException.class, () -> stack.peek());
	}

	@Test
	public void stackPush() {
		stack.push(2);
		assertEquals(2, stack.peek());
	}

	@Test
	public void stackPushInvalid() {
		assertThrows(IllegalArgumentException.class, () -> stack.push(null));
	}

	@Test
	public void stackPop() {
		stack.push(3);
		stack.push(4);
		stack.pop();
		assertEquals(3, stack.peek());
	}

	@Test
	public void stackPopInvalid() {
		assertThrows(NoSuchElementException.class, () -> stack.pop());
	}
}
