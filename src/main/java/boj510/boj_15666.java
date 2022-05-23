package boj510;

import java.util.*;

public class boj_15666 {

    static Set<ArrayList<Integer>> set = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        list.sort(Integer::compareTo);

        int[] output = new int[n];

        dfs(list, output, 0, 0, n, r);

        Iterator<ArrayList<Integer>> iterator = set.iterator();

        StringBuilder str = new StringBuilder();

        while (iterator.hasNext()) {
            ArrayList<Integer> next = iterator.next();

            for (int i = 0; i < next.size(); i++) {
                str.append(next.get(i) + " ");
            }
            str.append("\n");
        }

        System.out.println(str);
    }

    private static void dfs(ArrayList<Integer> list, int[] output, int start, int depth, int n, int r) {
        if (depth == r) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                arr.add(output[i]);
            }

            set.add(arr);
            return;
        }

        for (int i = start; i < n; i++) {
            output[depth] = list.get(i);
            dfs(list, output, i, depth + 1, n, r);
        }

    }
}
