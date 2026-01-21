package org.example.queue;

import java.util.ArrayList;
import java.util.Stack;
/*
232. Implement Queue using Stacks
 */
public class MyQueue {
     private Stack<Integer> inputStack;

    public MyQueue() {
        inputStack = new Stack<>();
    }

    public void push(int x) {

        ArrayList<Integer> temp = new ArrayList<>();
        int size = inputStack.size();
        for (int i = 0; i < size; i++) {
            temp.add(inputStack.pop());
        }

        inputStack.push(x);

        for (int i = 0; i < temp.size(); i++) {
            inputStack.push(temp.removeLast());
        }


    }

    public int pop() {

       return inputStack.pop();
    }

    public int peek() {
       return inputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty();
    }





    // --- Local Test Runner ---
    public static void main(String[] args) {
        System.out.println("--- Starting Local Test ---");

        // Instantiate the Queue
        MyQueue myQueue = new MyQueue();
        System.out.println("MyQueue initialized");

        // Command: push(1)
        myQueue.push(1);
        System.out.println("push(1) -> Queue should contain [1]");

        // Command: push(2)
        myQueue.push(2);
        System.out.println("push(2) -> Queue should contain [1, 2]");

        // Command: peek()
        int peekResult = myQueue.peek();
        System.out.println("peek() -> Expected: 1, Actual: " + peekResult);

        // Command: pop()
        int popResult = myQueue.pop();
        System.out.println("pop() -> Expected: 1, Actual: " + popResult);

        // Command: empty()
        boolean isEmpty = myQueue.empty();
        System.out.println("empty() -> Expected: false, Actual: " + isEmpty);

        System.out.println("--- Test Finished ---");
    }
}