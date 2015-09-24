package lintcode.America.String;

/**
 * 字符串查找（又称查找子字符串），是字符串操作中一个很有用的函数。你的任务是实现这个函数。
 * 
 * 对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。
 * 
 * 如果不存在，则返回 -1。
 * 
 * 样例 如果 source = "source" 和 target = "target"，返回 -1。
 * 
 * 如果 source = "abcdabcdefg" 和 target = "bcd"，返回 1。
 * 
 * 挑战 O(n2)的算法是可以接受的。如果你能用O(n)的算法做出来那更加好。（提示：KMP）
 * 
 * 说明 在面试中我是否需要实现KMP算法？
 * 
 * 不需要，当这种问题出现在面试中时，面试官很可能只是想要测试一下你的基础应用能力。当然你需要先跟面试官确认清楚要怎么实现这个题。
 *
 */
public class StrStr {
	/**
	 * Returns a index to the first occurrence of target in source, or -1 if
	 * target is not part of source.
	 * 
	 * @param source
	 *            string to be scanned.
	 * @param target
	 *            string containing the sequence of characters to match.
	 */
	public int strStr(String source, String target) {
		// write your code here
		return mySolution(source, target);
	}

	/**
	 * O(n^2)
	 * @param source
	 * @param target
	 * @return
	 */
	private int mySolution(String source, String target) {
		if (source == null && target == null)
			return -1;
		if (source != null && target != null) {
			if (source.length() < target.length()) {
				return -1;
			} else if (source.length() == target.length()) {
				if (source.equals(target)) {
					return 0;
				} else {
					return -1;
				}
			} else {
				int index = 0;
				for (int i = 0; i < target.length(); i++) {
					for (int j = 0; j < source.length() && i < target.length(); j++) {
						index++;
						char c = target.charAt(i);
						if (c == source.charAt(j)) {
							index--;
							i++;
						} else {
							continue;
						}
					}
					if(index>source.length()-target.length()){
						index=-1;
					}
				}
				return index;
			}

		} else if (target == null) {
			return -1;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		StrStr str = new StrStr();
		int strStr = str.strStr(
				"afjkshdfkjahsdfkhasdlkfhalkwfalkjhsdflkjhkjwehfkjahsdklfjhaskldjfhaskljdhfalkjsdhfkljahsdf",
				"*&^&$%&*(^&*&$$%*($#^$&%^)*&%$^%*^()^(&*%");
		System.out.println(strStr);
	}
}
