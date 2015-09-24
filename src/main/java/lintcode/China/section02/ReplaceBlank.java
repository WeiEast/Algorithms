package lintcode.China.section02;

/**
 * 设计一种方法，将一个字符串中的所有空格替换成 %20 。你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度。

	您在真实的面试中是否遇到过这个题？ Yes
	样例
	对于字符串"Mr John Smith", 长度为 13
	
	替换空格之后的结果为"Mr%20John%20Smith"
	
	注意
	如果使用 Java 或 Python, 程序中请用字符数组表示字符串。
	
	挑战
	在原字符串(字符数组)中完成替换，不适用额外空间
 *
 */
public class ReplaceBlank {

	public int replaceBlank(char[] string, int length) {
		int reallen = length;
		for (int i = length - 1; i > 0; i--) {
			char c = string[i];
			if (c == ' ') {
				reallen += 2;
				System.arraycopy(string, i, string, i + 2, reallen - i - 2);
				string[i] = '%';
				string[i + 1] = '2';
				string[i + 2] = '0';
			}
		}
		return reallen;

	}

	public static void main(String[] args) {
		ReplaceBlank r = new ReplaceBlank();
		System.out.println(r.replaceBlank("Mr John Smith    ".toCharArray(), 13));
	}

}
