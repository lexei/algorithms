package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
 *
 * Implementation of queue using two stacks
 */
public class MyQueue<T> {

    private final Deque<T> stackToAdd = new ArrayDeque<>();
    private final Deque<T> stackToRemove = new ArrayDeque<>();

    public void enqueue(T value) {
        stackToAdd.push(value);
    }

    private void populateStackToRemove() {
        while (!stackToAdd.isEmpty()) {
            stackToRemove.push(stackToAdd.pop());
        }
    }

    public void dequeue() {
        if (stackToRemove.isEmpty()) {
            populateStackToRemove();
        }
        stackToRemove.pop();
    }

    public T peek() {
        if (stackToRemove.isEmpty()) {
            populateStackToRemove();
        }
        return stackToRemove.peek();
    }

    public static void main(String[] args) {

        MyQueue<Integer> queue = new MyQueue<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
    }
}
