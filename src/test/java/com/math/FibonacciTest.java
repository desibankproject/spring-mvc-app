package com.math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * 
 * @author Nagendra
 * This is your JUnit test class
 * for Fibonacci class
 * here we will write all the possible test cases
 *
 */
public class FibonacciTest {
	
	private Fibonacci fibbo;

	@Before
	public void initObject(){
		fibbo=new Fibonacci();
	}
	
	/**
	 * Name of the test case should be descriptive.
	 */
	@Test
	public void testGenerateFebbInputNegative() {
		List<Integer> results=fibbo.generateFebb(-3);
		assertNotNull(results);
		assertEquals(0,results.size());
	}
	
	@Test
	public void testGenerateFebbInputZero() {
		List<Integer> results=fibbo.generateFebb(0);
		assertNotNull(results);
		assertEquals("Mismatch in values",0,results.size());
	}
	
	@Test
	public void testGenerateFebbInputIsOne() {
		List<Integer> results=fibbo.generateFebb(1);
		assertNotNull(results);
		assertEquals("Mismatch in values",1,results.size());
		assertEquals(new Integer(0),(Integer)results.get(0));
	}
	
	@Ignore
	public void testGenerateFebbInputIsTw0() {
		List<Integer> results=fibbo.generateFebb(2);
		assertNotNull(results);
		assertEquals("Mismatch in values",2,results.size());
		assertEquals(new Integer(0), results.get(0));
		assertEquals(new Integer(1), results.get(1));
	}
	
	@Test
	public void testGenerateFebb() {
		List<Integer> results=fibbo.generateFebb(4);
		assertNotNull(results);
		assertEquals("Mismatch in values",4,results.size());
		assertEquals(new Integer(0), results.get(0));
		assertEquals(new Integer(1), results.get(1));
		assertEquals(new Integer(1), results.get(2));
		assertEquals(new Integer(2), results.get(3));
	}
	
	@Test(expected=RuntimeException.class)
	public void testGenerateFebbFor6000() {
		fibbo.generateFebb(6000);
	}
}
