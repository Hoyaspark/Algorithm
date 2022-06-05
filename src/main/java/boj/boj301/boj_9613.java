package boj.boj301;

import java.util.Scanner;

public class boj_9613 {
    static long sum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        int[][] arr = new int[t][];
        boolean[] visited;

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();

            arr[i] = new int[n];
            visited = new boolean[n];

            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }

            combination(arr[i], visited, 0, n, 2);
            System.out.println(sum);

            sum = 0;
        }


    }

    public static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            // visited 인곳만 체크 해서 두 쌍의 gcd를 구한다.
            int[] temp = new int[2];
            for (int i = 0,j=0; i < n; i++) {
                if (visited[i]) {
                    temp[j++] = arr[i];
                }
            }

            sum += gcd(Math.max(temp[0], temp[1]), Math.min(temp[0], temp[1]));
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }

    }

    public static int gcd(int n, int m) {
        int a = 0;
        while (true) {
            if (n % m == 0) {
                return m;
            }
            a = m;
            m = n % m;
            n = a;
        }
    }

}
