package leetCode;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 *
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null || "".equals(s))
			return true;
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			while (isAZ(s.charAt(left)) && left < right) {
				left++;
			}
			if (right < left) {
				break;
			}
			char charleft = s.charAt(left);
			while (isAZ(s.charAt(right)) && left < right) {
				right--;
			}
			if (right < left) {
				break;
			}
			char charright = s.charAt(right);

			if (getMin(charleft) != getMin(charright)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public boolean isAZ(char c) {
		return !((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'));

	}

	public char getMin(char c) {
		if (c >= 'a') {
			return (char) (c - 32);
		} else {
			return c;
		}

	}

}
