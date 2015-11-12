package leetCode;

/**
 * Compare two version numbers version1 and version2.
	If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
	
	You may assume that the version strings are non-empty and contain only digits and the . character.
	The . character does not represent a decimal point and is used to separate number sequences.
	For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
	
	Here is an example of version numbers ordering:
	
	0.1 < 1.1 < 1.2 < 13.37
	Credits:
	Special thanks to @ts for adding this problem and creating all test cases.
	
	Subscribe to see which companies asked this question
	
	
	
 *
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		return mySolution(version1, version2);
	}

	private int mySolution(String version1, String version2) {
		int i = 0;

		String[] split = version1.split("\\.");
		String[] split2 = version2.split("\\.");
		int j = Math.min(split.length, split2.length);
		while (i < j) {

			if (Integer.valueOf(split[i]) > Integer.valueOf(split2[i])) {
				return 1;
			} else if (Integer.valueOf(split[i]) < Integer.valueOf(split2[i])) {
				return -1;
			} else {

			}
			i++;

		}

		if (i == split.length) {
			for (int m = i; m < split2.length; m++) {
				if (Integer.valueOf(split2[m]) > 0) {
					return -1;
				}
			}
			return 0;
		} else {
			for (int m = i; m < split.length; m++) {
				if (Integer.valueOf(split[m]) > 0) {
					return 1;
				}
			}
			return 0;
		}

	}

	public static void main(String[] args) {
		CompareVersionNumbers cvn = new CompareVersionNumbers();
		System.out.println(cvn.compareVersion("1", "1.1"));
	}
}
