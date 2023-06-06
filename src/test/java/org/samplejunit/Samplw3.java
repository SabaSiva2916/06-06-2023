package org.samplejunit;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class Samplw3 {

	@Test
	public void tc0() {
		String s = "abc";

		System.out.println("Assert failure");
		System.out.println("hi");

	}

	@Test
	public void tc01() {
		System.out.println("Method 2");

	}

	@Ignore
	@Test
	public void tc02() {
		System.out.println("Method 3");

	}

	@Test
	public void tc03() {
		System.out.println("Method 4");

	}

	@Test
	public void tc04() {
		System.out.println("Method 5");

	}

	@Test
	public void tc05() {
		System.out.println("Method 6");

	}

	@Test
	public void tc06() {
		System.out.println("Method 7");

	}

}
