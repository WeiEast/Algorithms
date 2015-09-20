package leetCode;

import java.util.Arrays;

import org.junit.Test;

public class MoveZeroesTest {
	@Test
	public void testMethod() throws Exception {
		testName();
	}

	public void testName() throws Exception {
		MoveZeroes m = new MoveZeroes();
		int nums[] = new int[] { 0, 1, 0, 3, 12 };
		m.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));

	}
}
