package org.example.queue;

import java.util.ArrayList;
import java.util.Stack;

public class MyQueueSolution {

    public static void main(String[] args) {
        // 1. Test Your Variant
        System.out.println("=== Testing User Variant (ArrayList + Stack) ===");
        testQueue(new MyQueueUserVariant());

        // 2. Test Two Stack Variant (Will fail until you implement it)
        System.out.println("\n=== Testing Two Stack Variant (Boilerplate) ===");
        testQueue(new MyQueueTwoStack());
    }

    // Helper method to test any implementation of our Queue
    private static void testQueue(MyQueueInterface queue) {
        try {
            queue.push(1);
            System.out.println("push(1)");
            queue.push(2);
            System.out.println("push(2)");

            int peek = queue.peek();
            System.out.println("peek() -> Expected: 1, Actual: " + peek);

            int pop = queue.pop();
            System.out.println("pop()  -> Expected: 1, Actual: " + pop);

            boolean empty = queue.empty();
            System.out.println("empty()-> Expected: false, Actual: " + empty);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Interface to allow testing both classes interchangeably
    interface MyQueueInterface {
        void push(int x);
        int pop();
        int peek();
        boolean empty();
    }

    // ---------------------------------------------------------
    // 1. YOUR VARIANT (Fixed Loop Logic)
    // ---------------------------------------------------------
    static class MyQueueUserVariant implements MyQueueInterface {
        private Stack<Integer> inputStack;

        public MyQueueUserVariant() {
            inputStack = new Stack<>();
        }

        public void push(int x) {
            ArrayList<Integer> temp = new ArrayList<>();

            // Move everything from Stack to ArrayList
            // (Capturing size works here because we aren't modifying size in the condition)
            while (!inputStack.isEmpty()) {
                temp.add(inputStack.pop());
            }

            // Push new element to the bottom
            inputStack.push(x);

            // Move everything back from ArrayList to Stack
            // FIX: Use 'while' loop. A 'for' loop fails here because
            // temp.removeLast() shrinks the list size while i increases.
            while (!temp.isEmpty()) {
                // remove(size-1) is compatible with older Java versions (same as removeLast)
                inputStack.push(temp.remove(temp.size() - 1));
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
    }

    // ---------------------------------------------------------
    // 2. TWO STACK BOILERPLATE (For you to implement)
    // ---------------------------------------------------------
    static class MyQueueTwoStack implements MyQueueInterface {

         private Stack<Integer> input;
         private Stack<Integer> output;

        public MyQueueTwoStack() {
            input = new Stack<>();
            output = new Stack<>();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            output.peek();
            return output.pop();
        }

        public int peek() {
            if (!output.empty()){
                return output.peek();
            }

            while (!input.isEmpty()){
                output.add(input.pop());
            }

            return output.peek();
        }

        public boolean empty() {
            return input.isEmpty() && output.empty();
        }
    }
}