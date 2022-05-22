package boj510;

import java.util.*;

public class boj_15663 {
    static StringBuilder str = new StringBuilder();
    static LinkedHashSet<List<Integer>> set = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        list.sort((a, b) -> a - b);

        int[] output = new int[n];
        boolean[] visited = new boolean[n];


        dfs(list, output, visited, 0, n, r);

        Iterator<List<Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            List<Integer> next = iterator.next();
            for (int i = 0; i < next.size(); i++) {
                System.out.print(next.get(i) + " ");
            }
            System.out.println();

        }

    }

    private static void dfs(List<Integer> list, int[] output, boolean[] visited,  int depth, int n, int r) {

        if (depth == r) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < depth; i++) {
                arr.add(output[i]);
            }
            set.add(arr);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = list.get(i);
                dfs(list, output, visited, depth + 1, n, r);
                visited[i] = false;
            }

        }
    }

}
