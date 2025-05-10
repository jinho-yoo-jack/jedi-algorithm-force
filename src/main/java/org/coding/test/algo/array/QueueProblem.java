package org.coding.test.algo.array;

import java.util.*;
import java.util.LinkedList;

public class QueueProblem {
    public static class CoffeeOrder {
        private int id;
        private int time;

        public CoffeeOrder(int id, int time) {
            this.id = id;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public int getTime() {
            return time;
        }

        public void timeMinus() {
            --this.time;
        }
    }

    public static void main(String[] args) {
        int N = 3;
        int[] coffee = {4, 2, 2, 5, 3};
        int[] result = new int[coffee.length];
        Queue<CoffeeOrder> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            CoffeeOrder coffeeOrder = new CoffeeOrder(i + 1, coffee[i]);
            q.offer(coffeeOrder);
        }

        int count = 0;
        while (!q.isEmpty()) {
            CoffeeOrder coffeeOrder = q.poll();
            coffeeOrder.timeMinus();
            if (coffeeOrder.getTime() == 0) {
                result[count] = coffeeOrder.getId();
                count++;
                if (count == coffee.length) break;
                if (q.size() < N) {
                    int availableOrderCount = N - q.size();
                    int nextOrderId = N + count;
                    if (nextOrderId <= coffee.length){
                        for(int i = 0; i < availableOrderCount; i++)
                            q.add(new CoffeeOrder(nextOrderId, coffee[nextOrderId - 1]));
                    }
                }
            } else {
                q.add(coffeeOrder);
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
