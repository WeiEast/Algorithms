package leetCode;

import org.junit.Test;

public class MajorityElementTest {

	@Test
	public void test() throws Exception {
		MajorityElement m = new MajorityElement();
		System.out.println(m.majorityElement(new int[] { 1, 2, 1, 2, 2, 3, 3,
				3, 4, 4, 4, 4, 4, 4, 4, 4 }));
	}
}
