package boj.day7;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1049 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        ArrayList<Integer> setList = new ArrayList<>();
        ArrayList<Integer> oneList = new ArrayList<>();


        for (int i = 0; i < M; i++) {
            int set = scanner.nextInt();
            int one = scanner.nextInt();
            setList.add(set);
            oneList.add(one);
        }

        setList.sort((a, b) -> a - b);
        oneList.sort((a, b) -> a - b);

        PriorityQueue<Integer> result = new PriorityQueue<>((a, b) -> a - b);

        int sum = 0; // 세트 + 낱개
        sum += setList.get(0) * (N / 6); // 세트
        sum += oneList.get(0) * (N % 6); // 낱개
        result.add(sum);

        // 세트로만
        result.add(setList.get(0) * ((N / 6) + 1));

        // 낱개로만
        result.add(oneList.get(0) * N);

        System.out.println(result.poll());

    }

}
