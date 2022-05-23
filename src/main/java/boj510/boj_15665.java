package boj510;

import java.util.*;

public class boj_15665 {

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

        dfs(list, output, 0, n, r);

        StringBuilder str = new StringBuilder();

        Iterator<ArrayList<Integer>> iterator = set.iterator();

        while (iterator.hasNext()) {
            ArrayList<Integer> next = iterator.next();

            for (int i = 0; i < next.size(); i++) {
                str.append(next.get(i) + " ");
            }
            str.append("\n");
        }

        System.out.println(str);
    }

    private static void dfs(ArrayList<Integer> list, int[] output, int depth, int n, int r) {

        if (depth == r) {
            ArrayList<Integer> array = new ArrayList<>();
            for (int i = 0; i < depth; i++) {
                array.add(output[i]);
            }
            set.add(array);
            return;
        }

        for (int i = 0; i < n; i++) {
            output[depth] = list.get(i);
            dfs(list, output, depth + 1, n, r);
        }
    }
}
