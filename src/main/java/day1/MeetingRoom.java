package day1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MeetingRoom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Item> items = new ArrayList<>();
        int count = scanner.nextInt();
        int time = 0;
        int result = 0;

        for (int i = 0; i < count; i++) {
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            items.add(new Item(startTime, endTime));
        }
        items.sort(Comparator.comparing((Item a) -> a.getEndTime())
                .thenComparing(Item::getStartTime));

        for (int i = 0; i < count; i++) {
            if (i == 0) {
                time = items.get(0).getEndTime();
                result++;
                continue;
            }

            if (items.get(i).getStartTime() >= time) {
                result++;
                time = items.get(i).getEndTime();
            }
        }

        System.out.println(result);

    }

    private static class Item {
        private int startTime;
        private int endTime;

        public Item(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }
}
