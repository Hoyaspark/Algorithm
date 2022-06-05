package boj.day7;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_1946 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> result = new ArrayList<>();

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {

            int N = scanner.nextInt();

            ArrayList<Person> list = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();
                list.add(new Person(num1, num2));
            }

            list.sort((a, b) -> a.getFirst() - b.getFirst());
            result.add(start(list));
        }

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static int start(ArrayList<Person> list) {
        int result = 1;

        int pivot = list.get(0).getSecond();

        for (int i = 1; i < list.size(); i++) {
            if (pivot > list.get(i).getSecond()) {
                pivot = list.get(i).getSecond();
                result++;
            }
        }


        return result;

    }

    static class Person {

        private int first;
        private int second;

        public Person(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }

}
