package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getName() {
        return queue.toString();
    }

    public String getLastHappyCustomer() {
        for (int index = 0; index < count - 1; index++) {
            queue.poll();
        }
        if (queue.peek() == null) {
            return "There was enough product for everyone";
        }
        return queue.peek().getName();
    }

    public String getFirstUpsetCustomer() {
        for (int index = 0; index < count; index++) {
            queue.poll();
        }
        if (queue.peek() == null) {
            return "There was enough product for everyone";
        }
        return queue.peek().getName();
    }
}
