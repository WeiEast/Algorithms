package lintcode.America.binarySearch;

import lombok.extern.log4j.Log4j;

/**
 * 容易 搜索插入位置

28% 通过
给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。

你可以假设在数组中无重复元素。

您在真实的面试中是否遇到过这个题？ Yes
样例
[1,3,5,6]，5 → 2

[1,3,5,6]，2 → 1

[1,3,5,6]， 7 → 4

[1,3,5,6]，0 → 0

http://www.lintcode.com/zh-cn/problem/search-insert-position/
 *
 */
@Log4j
public class SearchInsert {
	public int searchInsert(int[] A, int target) {
		return mySolution(A, target);
	}

	private int mySolution(int[] a, int target) {
		int i = 0;
		int j = a.length;
		int mid = (j - i) / 2 + i;

		while (i < j && i < mid) {
			if (a[mid] > target) {
				j = mid;
			} else if (a[mid] == target) {
				break;
			} else {
				i = mid;
			}
			mid = (j - i) / 2 + i;
		}
		return i >= mid && mid != 0 ? i + 1 : mid;
	}

	public static void main(String[] args) {
		SearchInsert s = new SearchInsert();
		log.info(s.searchInsert(new int[] { 1, 3, 5, 6, 8, 9 }, 7));
	}
}
