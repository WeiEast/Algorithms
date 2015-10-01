package lintcode.China.section02;

/**
 * LintCode 编程面试题在线训练平台
	Language 
	面试真题
	阶梯训练
	braydenleo 
	中等 寻找旋转排序数组中的最小值
	
	33% 通过
	假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。
	
	你需要找到其中最小的元素。
	
	你可以假设数组中不存在重复的元素。
	
	您在真实的面试中是否遇到过这个题？ 
	哪家公司问你的这个题？ Airbnb Alibaba Amazon Apple Baidu Bloomberg Cisco Dropbox Ebay Facebook Google Hulu Intel Linkedin Microsoft NetEase Nvidia Oracle Pinterest Snapchat Tencent Twitter Uber Xiaomi Yahoo Yelp Zenefits
	样例
	给出[4,5,6,7,0,1,2]  返回 0
	http://www.lintcode.com/zh-cn/problem/find-minimum-in-rotated-sorted-array/
 *
 */
public class FindMin {
	public int findMin(int[] num) {
		return bestSolution(num);
	}

	private int bestSolution(int[] num) {
		int l = 0;
		int r = num.length - 1;
		if (num[l] < num[r])
			return num[l];

		while (l < r) {
			int mid = (l + r) / 2;
			if (num[mid] > num[r]) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}

		return num[l];
	}

	private int anotherSolution(int[] num) {
		int i = 0;
		for (i = 1; i < num.length; i++) {
			if (num[i] < num[i - 1]) {
				break;
			}
		}
		return i == num.length ? num[0] : num[i];
	}

	private int mySolution(int[] num) {
		if (num == null || num.length == 0)
			return 0;
		int min = num[0];
		for (int i = 1; i < num.length; i++) {
			min = Math.min(num[i], min);
		}
		return min;
	}

	public static void main(String[] args) {
		FindMin f = new FindMin();
		System.out.println(f.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
	}
}
