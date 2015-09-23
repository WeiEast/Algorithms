package lintcode.Array;

/**
 * 给定一个数组和一个值，在原地删除与值相同的数字，返回新数组的长度。

	元素的顺序可以改变，并且对新的数组不会有影响。
	
	您在真实的面试中是否遇到过这个题？ Yes
	样例
	给出一个数组 [0,4,4,0,0,2,4,4]，和值 4
	
	返回 4 并且4个元素的新数组为[0,0,0,2]
	http://www.lintcode.com/zh-cn/problem/remove-element/
 *
 */
public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		return bestSolution(A, elem);
	}

	private int bestSolution(int[] a, int elem) {
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != elem) {
				a[index++] = a[i];
			} 
		}
		return index;
	}

	private int mySolution(int[] a, int elem) {
		int size = a.length;
		int length = size;
		for (int i = 0; i < size; i++) {
			if (a[i] == elem) {
				length = size;
				size--;
				for (int j = i + 1; j < length; j++) {
					if (a[j] != elem) {
						System.arraycopy(a, j, a, i, a.length - j);
						j = a.length;
					} else {
						size--;
					}
				}

			}
		}

		return size;
	}

	public static void main(String[] args) {
		RemoveElement r = new RemoveElement();
		System.out.println(r.removeElement(new int[] { 0,4,4,0,4,4,4,0,2 }, 4));
	}
}
