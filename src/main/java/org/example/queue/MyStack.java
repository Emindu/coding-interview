package org.example.queue;

import java.util.*;


/*
  Implement Stack using Queues
 */
public class MyStack {

    // TODO: Define your Queue(s) here.
     Queue<Integer> q1;

    public MyStack() {
        q1 = new ArrayDeque<>();
    }

    public void push(int x) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < q1.size(); i++) {
            Integer remove = q1.remove();
            list.addLast(remove);
        }

        q1.add(x);
        for (Integer i : list) {
            q1.add(i);
        }


    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        // TODO: Implement logic to return true if the stack is empty, false otherwise.
        return q1.isEmpty();
    }

    // --- Local Test Runner ---
    public static void main(String[] args) {
        System.out.println("--- Starting Local Test ---");

        // Instantiate the Stack
        MyStack myStack = new MyStack();
        System.out.println("MyStack initialized");

        // Execute operations based on Example 1
        // Command: push(1)
        myStack.push(1);
        System.out.println("push(1)");

        // Command: push(2)
        myStack.push(2);
        System.out.println("push(2)");

        // Command: top()
        int topElement = myStack.top();
        System.out.println("top() -> Expected: 2, Actual: " + topElement);

        // Command: pop()
        int popElement = myStack.pop();
        System.out.println("pop() -> Expected: 2, Actual: " + popElement);

        // Command: empty()
        boolean isEmpty = myStack.empty();
        System.out.println("empty() -> Expected: false, Actual: " + isEmpty);

        System.out.println("--- Test Finished ---");
    }
}