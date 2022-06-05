package boj.day7;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_11399 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> input = new ArrayList<>();


        int N = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            int duration = scanner.nextInt();
            input.add(new Person(i, duration));
        }

        input.sort((a, b) -> a.getDuration() - b.getDuration());

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            if (i == 0) {
                result.add(input.get(i).getDuration());
                continue;
            }

            result.add(input.get(i).getDuration() + result.get(i - 1));
        }

        System.out.println(result.stream().mapToInt(a -> a).sum());

    }

    static class Person {
        private int index;
        private int duration;

        public Person(int index, int duration) {
            this.index = index;
            this.duration = duration;
        }

        public int getIndex() {
            return index;
        }

        public int getDuration() {
            return duration;
        }
    }

}
