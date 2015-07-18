package leetCode;

import org.junit.Test;

import utils.ListNode;

public class AddTwoNumbersTest {

	@Test
	public void test() {
		AddTwoNumbers add = new AddTwoNumbers();

		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(4);

		ListNode addTwoNumbers = add.addTwoNumbers(l1, l2);

		for (ListNode l = addTwoNumbers; l != null; l = l.next) {
			System.out.println(l.val);
		}

	}
}
