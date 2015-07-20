package leetCode;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 */
public class ZigZag {
	public String convert(String s, int numRows) {
		int len = s.length();
		if (len <= 1 || numRows == 1) {
			return s;
		}
		int jump = 2 * numRows - 2;
		StringBuffer a = new StringBuffer();
		for (int i = 0; i < numRows; i++) {
			for (int j = i; j < len; j += jump) {
				a.append(s.charAt(j));
				int mid = j + jump - 2 * i;
				if (i != 0 && i != numRows - 1 && mid < len) {
					a.append(s.charAt(mid));
				}
			}
		}
		return a.toString();

	}
}
