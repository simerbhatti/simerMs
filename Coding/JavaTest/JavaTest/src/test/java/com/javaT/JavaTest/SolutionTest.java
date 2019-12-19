package com.javaT.JavaTest;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void countDivSolutionTest1() {
		Assert.assertEquals(Solution.intcount_divisible(6, 11, 2), 3);
	}

	@Test
	public void countDivSolutionTest2() {
		Assert.assertEquals(Solution.intcount_divisible(1000000000, 2000000000, 500000000), 3);
	}

	@Test
	public void countDivSolutionTest3() {
		Assert.assertEquals(Solution.intcount_divisible(99999999, 199999999, 50000000), 2);
	}

	@Test
	public void countDivSolutionTest4() {
		Assert.assertEquals(Solution.intcount_divisible(99999998, 199999999, 99999999), 2);
	}

	@Test
	public void countDivSolutionTest5() {
		Assert.assertEquals(Solution.intcount_divisible(0, 100, 3), 34);
	}

	@Test
	public void countDivSolutionTest6() {
		Assert.assertEquals(Solution.intcount_divisible(22001, 55000, 5), 6600);
	}
	@Test
	public void countPairsTest1() {
		Assert.assertEquals(Solution.countPairs(new Long[]{10000000000L, 3L, 20000000000L, 2L, 25L}, 30000000000L),1);
	}

	@Test
	public void countPairsTest2() {
		Assert.assertEquals(Solution.countPairs(new Long[]{1L, 3L, 2L, 2L, 25L}, 3L),3);
	}
	@Test
	public void countPairsTest3() {
		Assert.assertEquals(Solution.countPairs(new Long[]{1L, 3L, 2L, 2L, 4L}, 5L),4);
	}
	@Test
	public void countPairsTest4() {
		Assert.assertEquals(Solution.countPairs(new Long[]{10000000000L, 12L, 18L, 5L, 25L}, 30L),2);
	}
}
