package popularInterview;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TreeNode;

import java.lang.reflect.Method;

/**
 * Created by yupeng on 16/7/27.
 */

// 高频面试题
public class PopularInterviewPractise {


    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     * <p/>
     * <p/>
     * <p/>
     * <p/>
     * 样例 给出数组A = [1,2,3,4,5,6] B = [2,3,4,5]，中位数3.5
     * <p/>
     * 给出数组A = [1,2,3] B = [4,5]，中位数 3
     * <p/>
     * 两个排序的数组A和B分别含有m和n个数，找到两个排序数组的中位数，要求时间复杂度应为O(log (m+n))。
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        return simpleFindMedianSortedArrays(A, B);
    }


    private double simpleFindMedianSortedArrays(int[] A, int[] B) {
        int k = 0;
        for (int i : A) {
            k += i;
        }
        for (int i : B) {
            k += i;
        }
        int Alength = A.length;
        int Blength = B.length;

        return (double) k / (double) (Alength + Blength);
    }

    /**
     * 字符串反转
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        return simpleSpiltReverseWords(s);
    }

    /**
     * 需要注意 输入参数为" " 这种字符串 , split结果长度为0
     *
     * @param s
     * @return
     */
    private String simpleSpiltReverseWords(String s) {
        if (s == null) {
            return null;
        }
        String[] strarr = s.split(" ");
        StringBuilder str = new StringBuilder();
        if (strarr.length != 0) {
            for (int i = strarr.length - 1; i > 0; i--) {
                str.append(strarr[i]).append(" ");
            }
            str.append(strarr[0]);
        }
        return str.toString();
    }

    @DataProvider
    public Object[][] providerData(Method method) {
        Object[][] result = null;
        result = new Object[][]{new Object[]{new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 3, 4, 5}},
                new Object[]{new int[]{1, 2, 3}, new int[]{4, 5}},};

        return result;
    }

    @Test(dataProvider = "providerData")
    public void findMedianSortedArraysTest(int[] A, int[] B) {
        double medianSortedArrays = findMedianSortedArrays(A, B);
        System.out.println(medianSortedArrays);
    }


    @Test(dataProvider = "maxDepthTest")
    public void maxDepthTest(TreeNode root) {


    }


}
