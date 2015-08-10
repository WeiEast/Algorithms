package leetCode;

import org.junit.Test;

public class RectangleAreaTest {
	@Test
	public void testName() throws Exception {
		RectangleArea r = new RectangleArea();
		int computeArea = r.computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1);
		System.out.println(computeArea);
	}
}
