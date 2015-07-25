package leetCode;

import org.junit.Test;

public class PalindromeNumberTest {

	@Test
	public void test() {
		PalindromeNumber p = new PalindromeNumber();
		System.out.println(p.isPalindrome(0));
		System.out.println(p.isPalindrome(101));
		System.out.println(p.isPalindrome(1000000009));
		System.out.println(p.isPalindrome(1001));
		System.out.println(p.isPalindrome(-1001));
		
	}

}
