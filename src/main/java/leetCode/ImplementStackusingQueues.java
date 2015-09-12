package leetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Implement the following operations of a stack using queues.

	push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	empty() -- Return whether the stack is empty.
	Notes:
	You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
	Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
	You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
	Update (2015-06-11):
	The class name of the Java function had been updated to MyStack instead of Stack.
 *
 */
public class ImplementStackusingQueues {
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.pop();
		System.out.println(stack.peek());
		// MyStack myStack = new MyStack();
		// myStack.push(1);
		// myStack.push(2);
		// myStack.pop();
		// myStack.push(2);
		// System.out.println(myStack.peek());
	}
}

class MyStack {
	Queue queue1 = new LinkedList();
	Queue queue2 = new LinkedList();

	// Push element x onto stack.
	public void push(int x) {
		if (!queue1.isEmpty()) {
			queue2.add(queue1.poll());
		}
		while (!queue2.isEmpty() && queue1.isEmpty()) {
			Object poll = queue2.poll();
			queue1.add(poll);
		}
		queue1.add(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		if (queue1.isEmpty()) {
			while (!queue2.isEmpty()) {
				queue1.add(queue2.poll());
			}
		}
		while (!queue1.isEmpty() && queue1.size() != 1) {
			Object poll = queue1.poll();
			queue2.add(poll);
		}
		queue1.poll();

	}

	// Get the top element.
	public int top() {
		if (queue1.isEmpty()) {
			while (!queue2.isEmpty()) {
				queue1.add(queue2.poll());
			}
		}
		while (!queue1.isEmpty() && queue1.size() != 1) {
			Object poll = queue1.poll();
			queue2.add(poll);
		}
		return (Integer) queue1.peek();

	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue2.isEmpty() && queue1.isEmpty();
	}
}