package boj.boj530;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class boj_1759 {
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int l = scanner.nextInt();
        int c = scanner.nextInt();

        scanner.nextLine();
        ArrayList<Character> list = new ArrayList<>();
        String[] s = scanner.nextLine().split(" ");

        for (int i = 0; i < c; i++) {
            list.add(s[i].charAt(0));
        }

        list.sort(Character::compareTo);

        // cCl 조합이다!
        boolean[] visited = new boolean[c];
        char[] output = new char[l];
        dfs(list, output, visited, 0, 0, c, l);

        System.out.println(str);
    }

    private static void dfs(ArrayList<Character> list, char[] output, boolean[] visited, int depth, int start, int n, int r) {

        if (depth == r) {
            // 오름차순 판단
            for (int i = r - 1; i > 0; i--) {
                if (output[i - 1] > output[i]) {
                    return;
                }
            }
            // 한개의 모음, 2개의 자음이 있냐 판단
            // 3개의 모음이 있다면 return; 0개의 모음이 있다면 return;
            int count = 0, a = 0;
            for (int i = 0; i < r; i++) {
                if (output[i] == 'a' || output[i] == 'e' || output[i] == 'i' || output[i] == 'o' || output[i] == 'u') {
                    count++;
                } else {
                    a++;
                }
            }

            if (count >= 1 && a >= 2) {
                // 출력
                for (int i = 0; i < r; i++) {
                    str.append(output[i]);
                }
                str.append("\n");
            }

            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = list.get(i);
                dfs(list, output, visited, depth + 1, i + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
