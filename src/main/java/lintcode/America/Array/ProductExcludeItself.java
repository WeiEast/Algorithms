package lintcode.America.Array;

import java.util.ArrayList;

/**
 * 给定一个整数数组A。

	定义B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]， 计算B的时候请不要使用除法。
	
	您在真实的面试中是否遇到过这个题？ Yes
	样例
	给出A=[1, 2, 3]，返回 B为[6, 3, 2]
 *
 */
public class ProductExcludeItself {
	public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {

		ArrayList<Long> list = new ArrayList<Long>();
		for (int i = 0; i < A.size(); i++) {
			Long result = 1L;
			int j = A.size() - 1;
			while (j >= 0) {
				if (j != i) {
					result *= A.get(j);
				}
				j--;
			}
			list.add(result);

		}
		return list;

	}
	public static void main(String[] args) {
		ProductExcludeItself p = new ProductExcludeItself();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
//		list.add(2);
//		list.add(3);
		System.out.println(p.productExcludeItself(list));
	}
}
