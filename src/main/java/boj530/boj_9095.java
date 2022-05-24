package boj530;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_9095 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int[] arr = new int[]{1, 2, 3};

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // dfs 시작 1,2,3 배열로 list.get(i)를 만든다. depth는 list.get(i)까지 로..
            Integer num = list.get(i);
            // n -> num, r -> num, sum = 0
            dfs(arr, 0, 0, num, num);
            // count결과를 result에 넣어주고 count=0으로 초기화
            result.add(count);
            count = 0;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(result.get(i));
        }
    }

    private static void dfs(int[] arr, int sum, int depth, Integer n, Integer r) {
        if (sum == n) {
            count++;
            return;
        }

        if (depth == r) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            dfs(arr, sum + arr[i], depth + 1, n, r);
        }
    }
}
