package com.app.javatest.string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringTest {

	private Normaliser normaliser = new Normaliser();

	@Test
	public void testNormalise() {
		String jt = "Java engineer";
		assertNotNull(normaliser.normalise(jt));
		assertEquals("Software engineer", normaliser.normalise(jt));

		jt = "C# engineer";
		assertNotNull(normaliser.normalise(jt));
		assertEquals("Software engineer", normaliser.normalise(jt));

		jt = "Accountant";
		assertNotNull(normaliser.normalise(jt));
		assertEquals("Accountant", normaliser.normalise(jt));

		jt = "Chief Accountant";
		assertNotNull(normaliser.normalise(jt));
		assertEquals("Accountant", normaliser.normalise(jt));
	}

	@Test
	public void normaliseException() {
		String jt = null;
		assertThrows(IllegalArgumentException.class, () -> normaliser.normalise(jt));

		String jt2 = "";
		assertThrows(IllegalArgumentException.class, () -> normaliser.normalise(jt2));
	}
}
