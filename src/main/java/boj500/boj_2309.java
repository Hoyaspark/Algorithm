package boj500;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_2309 {

    static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[9];
        boolean[] visited = new boolean[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = scanner.nextInt();
        }

        combination(arr, visited, 0, 9, 7);

        ArrayList<Integer> list = result.get(0);
        list.sort(Integer::compareTo);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int count = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                if (visited[i]) {
                    count += arr[i];
                    list.add(arr[i]);
                }
            }
            if (count == 100) {
                result.add(list);
            }
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(arr, visited, i + 1, 9, r - 1);
                visited[i] = false;
            }
        }
    }
}
