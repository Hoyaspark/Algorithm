package boj.require;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1080_not_solve {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        scanner.nextLine();

        int[][] matrix = new int[N][M];
        int[][] result = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] s = scanner.nextLine().split("");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            String[] s = scanner.nextLine().split("");
            for (int j = 0; j < M; j++) {
                result[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < M - 2; i++) {
            ArrayList<Double> list = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                double sum = 0;
                for (int k = i; k < i + 3; k++) {
                    if (k == 0) {
                        sum += matrix[j][k] * (Math.pow(2, 2));
                    } else if (k == 1) {
                        sum += matrix[j][k] * (Math.pow(2, 1));
                    } else if (k == 2) {
                        sum += matrix[j][k] * (Math.pow(2, 0));
                    }
                }
                list.add(sum);
            }

        }


        Queue<ArrayList<Double>> queue = new LinkedList<>();

    }

}
