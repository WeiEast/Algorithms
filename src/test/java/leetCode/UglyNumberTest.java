package leetCode;

import leetCode.UglyNumber.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UglyNumberTest {

	@Test
	public void testName() throws Exception {
		UglyNumber u = new UglyNumber();
		System.out.println(u.isUgly(14));
	}

}
