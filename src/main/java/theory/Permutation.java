package theory;

import java.util.Scanner;

public class Permutation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

        int[] array = new int[n];
        int[] output = new int[r];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // nPr

        permutation(array, output, visited, 0, n, r);

    }

    static void permutation(int[] array, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = array[i];
                permutation(array, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

}
