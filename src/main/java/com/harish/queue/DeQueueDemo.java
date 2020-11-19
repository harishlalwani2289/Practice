package com.harish.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeQueueDemo {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(1);
        deque.addFirst(12);

        deque.addLast(13);
        deque.addLast(45);

        deque.offerFirst(111);

        deque.offerLast(145);

        System.out.println(deque);

        deque.pollFirst();
        System.out.println(deque);

        deque.pollLast();
        System.out.println(deque);
    }
}
