package boj510;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class boj_15664 {
    static LinkedHashSet<ArrayList<Integer>> set = new LinkedHashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        list.sort((a, b) -> a - b);

        dfs(list, set, visited, 0, n, r);

        Iterator<ArrayList<Integer>> iterator = set.iterator();

        while (iterator.hasNext()) {
            ArrayList<Integer> next = iterator.next();

            for (int i = 0; i < next.size(); i++) {
                System.out.print(next.get(i) + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(ArrayList<Integer> list, LinkedHashSet<ArrayList<Integer>> set, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    arr.add(list.get(i));
                }
            }
            set.add(arr);
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(list, set, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }
}
