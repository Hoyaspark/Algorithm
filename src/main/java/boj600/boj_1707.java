package boj600;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1707 {
    static boolean check = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int e = scanner.nextInt();

            check = false;
            ArrayList<Integer>[] list = new ArrayList[n + 1];
            int[] color = new int[n + 1];

            for (int j = 0; j < n + 1; j++) {
                list[j] = new ArrayList<>();
            }

            for (int j = 0; j < e; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                list[a].add(b);
                list[b].add(a);
            }

            for (int j = 1; j < n + 1; j++) {
                if (check) {
                    break;
                }

                if (color[j] == 0) {
                    bfs(list, color, j);
                }
            }

            if (check) {
                str.append("NO");
                str.append("\n");
            } else {
                str.append("YES");
                str.append("\n");
            }

        }

        System.out.println(str);
    }

    private static void bfs(ArrayList<Integer>[] list, int[] color, int node) {

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(node);
        color[node] = -1;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (int i = 0; i < list[poll].size(); i++) {
                Integer v = list[poll].get(i);
                if (color[v] == 0) {
                    color[v] = color[poll] * -1;
                    queue.add(v);
                } else if (color[v] == color[poll]) {
                    check = true;
                    return;
                }
            }
        }

    }
}
