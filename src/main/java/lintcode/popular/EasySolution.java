package lintcode.popular;

import utils.ListNode;

/**
 * Created by yupeng on 16/7/27.
 */
public class EasySolution {

    public ListNode addLists(ListNode l1, ListNode l2) {
        return bestSolution(l1, l2);

        // write your code here
    }

    private ListNode bestSolution(ListNode l1, ListNode l2) {

        int temp = 0;
        ListNode t = new ListNode(0);
        ListNode p = t;
        while (l1 != null || l2 != null) {

            temp += l1 == null ? 0 : l1.val;
            l1 = l1 == null ? null : l1.next;

            temp += l2 == null ? 0 : l2.val;
            l2 = l2 == null ? null : l2.next;

            p.next = new ListNode(temp % 10);
            p = p.next;
            temp /= 10;

        }

        if (temp == 1)
            p.next = new ListNode(temp);
        return t.next;

    }

    public static void main(String[] args) {
        String str = " ";

        String[] strarr = str.split(" ");
        System.out.println(strarr);


    }
}
