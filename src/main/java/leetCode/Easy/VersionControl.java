package leetCode.Easy;

public class VersionControl {
	/**
	  * 2126753390 versions
		1702766719 is the first bad version.
	 * @param version
	 * @return
	 */
	boolean isBadVersion(int version) {
		if (version >= 1702766719) {
			return true;
		}
		return false;
	}
}
