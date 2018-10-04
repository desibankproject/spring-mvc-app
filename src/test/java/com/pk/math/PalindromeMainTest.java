package com.pk.math;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


/**
 * 
 * @author Nagendra
 *  this is JUNIT Class for PalindromeMain class logic
 */
public class PalindromeMainTest {
	
	
	/**
	 * This is one test case
	 * This is called negative test cases!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 */
	@Ignore
	@Test(expected=RuntimeException.class)
	public void apapapapapa() {
		PalindromeMain main=new PalindromeMain();
		String result=main.isPalindrome("");
		//fail("Not yet implemented");
	}

	/**
	 * This is one test case
	 * This is called negative test cases!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 */
	@Test(expected=RuntimeException.class)
	public void testIsPalindromeWhenInputIsBlank() {
		PalindromeMain main=new PalindromeMain();
		main.isPalindrome("");
		//fail("Not yet implemented");
	}
	
	/**
	 * This is one test case
	 * This is called negative test cases!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 */
	@Test(expected=RuntimeException.class)
	public void testIsPalindromeWhenInputIsNull() {
		PalindromeMain main=new PalindromeMain();
		main.isPalindrome(null);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testIsPalindromeWhenInputLenIsOne() {
		PalindromeMain main=new PalindromeMain();
		String result=main.isPalindrome("A");
		assertEquals("yes", result);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testIsPalindromeWhenInputMoreThanOne() {
		PalindromeMain main=new PalindromeMain();
		String result=main.isPalindrome("nagendra");
		assertEquals("no", result);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testIsPalindrome() {
		PalindromeMain main=new PalindromeMain();
		String result=main.isPalindrome("tikit");
		assertEquals("yes", result);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testIsPalindromeWhenAllLetterSame() {
		PalindromeMain main=new PalindromeMain();
		String result=main.isPalindrome("aaaaaaaaaaaa");
		assertEquals("yes", result);
		//fail("Not yet implemented");
	}
	@Test
	public void testIsPalindromeWhenAllLetterNotSame() {
		PalindromeMain main=new PalindromeMain();
		String result=main.isPalindrome("aaaabbbb");
		assertEquals("no", result);
		//fail("Not yet implemented");
	}

}
