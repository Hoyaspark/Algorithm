package theory;

import java.util.Scanner;

public class Combination {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

        int[] array = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        combination(array, visited, 0, n, r);
    }

    private static void combination(int[] array, boolean[] visited, int start, int n,
        int r) {
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.print(array[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(array, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }


    }

}
