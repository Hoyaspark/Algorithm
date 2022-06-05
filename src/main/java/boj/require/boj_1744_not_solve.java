package boj.require;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class boj_1744_not_solve {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        Map<Boolean, List<Integer>> group = list.stream()
            .collect(Collectors.groupingBy(a -> a >= 0));

        Integer negativeSum = group.get(false).stream().reduce(0, (a, b) -> a + b);// 0보다 작은 집합

        List<Integer> integers = group.get(true);// 0보닫 큰 집합

        integers.sort((a, b) -> b - a);

        int sum = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < integers.size(); i++) {
            queue.add(integers.get(i));
        }

        while (!queue.isEmpty()) {
            Integer i = queue.poll();
            Integer j = queue.poll();

            sum += i * j;
        }

        Integer poll = queue.poll();

        if (poll == 0) {
            sum += negativeSum * poll;
        } else {
            sum += poll + negativeSum;
        }

        System.out.println(sum);
    }

}
