package org.example.queue;

import java.util.*;

public class MyStackSolution {

    public static void main(String[] args) {
        // 1. Test Your Variant (ArrayList + Queue)
        System.out.println("=== Testing User Variant (ArrayList + Queue) ===");
        testStack(new MyStackUserVariant());

        // 2. Test Two Queue Variant (Will fail until you implement it)
        System.out.println("\n=== Testing Two Queue Variant (Boilerplate) ===");
        testStack(new MyStackTwoQueue());
    }

    // Helper method to test any implementation
    private static void testStack(MyStackInterface stack) {
        try {
            stack.push(1);
            System.out.println("push(1)");
            stack.push(2);
            System.out.println("push(2)");

            int top = stack.top();
            System.out.println("top() -> Expected: 2, Actual: " + top);

            int pop = stack.pop();
            System.out.println("pop() -> Expected: 2, Actual: " + pop);

            boolean empty = stack.empty();
            System.out.println("empty() -> Expected: false, Actual: " + empty);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Interface to allow testing both classes
    interface MyStackInterface {
        void push(int x);
        int pop();
        int top();
        boolean empty();
    }

    // ---------------------------------------------------------
    // 1. YOUR VARIANT (Fixed Loop Logic)
    // ---------------------------------------------------------
    static class MyStackUserVariant implements MyStackInterface {
        Queue<Integer> q1;

        public MyStackUserVariant() {
            q1 = new ArrayDeque<>();
        }

        public void push(int x) {
            List<Integer> list = new ArrayList<>();

            // FIX: Use 'while' loop.
            // The original 'for (int i=0; i < q1.size(); i++)' failed
            // because q1.size() shrinks every time you remove an item.
            while (!q1.isEmpty()) {
                list.add(q1.remove());
            }

            // Add the new element (which becomes the Top)
            q1.add(x);

            // Add everything back behind the new element
            for (Integer i : list) {
                q1.add(i);
            }
        }

        public int pop() {
            return q1.remove(); // remove() throws exception if empty, poll() returns null
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

    // ---------------------------------------------------------
    // 2. TWO QUEUE BOILERPLATE (For you to implement)
    // ---------------------------------------------------------
    static class MyStackTwoQueue implements MyStackInterface {

        // TODO: Define your two queues here
         Queue<Integer> q1;
         Queue<Integer> q2;

        public MyStackTwoQueue() {
            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();
        }

        public void push(int x) {
            q1.add(x);
        }

        public int pop() {
            // TODO: Implement pop logic
            top();
            return q2.poll();
        }

        public int top() {
            if (!q2.isEmpty()){
                return q2.peek();
            }

            int size = q1.size();
            for (int i = 0; i < size; i++) {


            }


            return q2.peek();
        }

        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }
}