package boj.day7;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1202 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Bag> bags = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int weight = scanner.nextInt();
            int value = scanner.nextInt();
            items.add(new Item(weight, value,false));
        }

        for (int i = 0; i < K; i++) {
            int weight = scanner.nextInt();
            bags.add(new Bag(0, weight, false));
        }

        items.sort((a, b) -> a.getWeight() - b.getWeight());
        bags.sort((a, b) -> a.getWeight() - b.getWeight());

        long sum = 0L;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0, j = 0; i < bags.size(); i++) {
            Bag bag = bags.get(i);

            while (j < N) {
                Item item = items.get(j);

                if (item.getWeight() <= bag.getWeight()) {
                    queue.add(item.getValue());
                    j++;
                } else {
                    break;
                }
            }
            if (!queue.isEmpty()) {
                sum += queue.poll();
            }
        }
        System.out.println(sum);

    }

    static class Item {
        private int weight;
        private int value;
        private boolean used;

        public Item(int weight, int value, boolean used) {
            this.weight = weight;
            this.value = value;
            this.used = used;
        }

        public boolean isUsed() {
            return used;
        }

        public int getWeight() {
            return weight;
        }

        public int getValue() {
            return value;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }
    }

    static class Bag {
        private int value;
        private int weight;
        private boolean full;

        public Bag(int value, int weight, boolean full) {
            this.value = value;
            this.weight = weight;
            this.full = full;
        }

        public int getValue() {
            return value;
        }

        public int getWeight() {
            return weight;
        }

        public boolean isFull() {
            return full;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public void setFull(boolean full) {
            this.full = full;
        }

        @Override
        public String toString() {
            return "Bag{" +
                "value=" + value +
                ", weight=" + weight +
                ", full=" + full +
                '}';
        }
    }

}
