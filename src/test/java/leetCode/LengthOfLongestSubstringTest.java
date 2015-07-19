package leetCode;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.TestFactory;

public class LengthOfLongestSubstringTest extends TestFactory {

	/**
	 * 数据
	 * @param method
	 * @return
	 */
	@DataProvider
	public Object[][] providerData(Method method) {
		Object[][] result = null;
		if (method.getName().equals("test")) {
			result = new Object[][] { new Object[] { "abcabcbb", 3 },
					new Object[] { "bbbbb", 1 } };
		}
		return result;
	}

	@Test(dataProvider = "providerData")
	public void test(String s, int expected) {
		LengthOfLongestSubstring l = new LengthOfLongestSubstring();

		int actual = l.lengthOfLongestSubstring(s);

		logger.info(s + "最长连续重复字符串为:" + actual);

		Assert.assertEquals(actual, expected);

	}
}
