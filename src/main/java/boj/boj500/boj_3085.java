package boj.boj500;

import java.util.Scanner;

public class boj_3085 {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        char[][] matrix = new char[n + 1][n + 1];

        scanner.nextLine();
        for (int i = 1; i <= n; i++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = line[j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            checkRow(matrix, i, n);
        }

        for (int j = 1; j <= n; j++) {
            checkCol(matrix, j, n);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 맨 오른쪽이고 맨 아래 일때
                if (i + 1 > n && j + 1 > n) {
                    continue;
                }

                // 맨 오른쪽이고 맨 아래가 아닐때
                if (j + 1 > n && i + 1 < n + 1) {

                    // 아래로만 swap
                    char c = matrix[i][j];
                    char d = matrix[i + 1][j];
                    matrix[i][j] = d;
                    matrix[i + 1][j] = c;

                    //가로 검사
                    checkRow(matrix, i, n);
                    checkRow(matrix, i + 1, n);

                    // 세로 검사
                    checkCol(matrix, j, n);

                    matrix[i][j] = c;
                    matrix[i + 1][j] = d;

                    continue;
                }

                // 맨 아래일때
                if (i + 1 > n) {
                    //오른쪽으로만 swap
                    char a = matrix[i][j];
                    char b = matrix[i][j + 1];

                    matrix[i][j] = b;
                    matrix[i][j + 1] = a;

                    //가로 검사
                    checkRow(matrix, i, n);
                    // 세로 검사
                    checkCol(matrix, j, n);
                    checkCol(matrix, j + 1, n);

                    // 원 상태 복구
                    matrix[i][j] = a;
                    matrix[i][j + 1] = b;

                    continue;

                }
                // 그 외일때

                char a = matrix[i][j];
                char b = matrix[i][j + 1];

                matrix[i][j] = b;
                matrix[i][j + 1] = a;

                // 가로 검사
                checkRow(matrix, i, n);

                checkCol(matrix, j, n);
                checkCol(matrix, j + 1, n);

                // 원 상태 복구
                matrix[i][j] = a;
                matrix[i][j + 1] = b;

                char c = matrix[i][j];
                char d = matrix[i + 1][j];
                matrix[i][j] = d;
                matrix[i + 1][j] = c;

                // 세로 검사
                checkCol(matrix, j, n);

                checkRow(matrix, i, n);
                checkRow(matrix, i + 1, n);

                // 원 상태 복구
                matrix[i][j] = c;
                matrix[i + 1][j] = d;
            }
        }

        System.out.println(max);

    }

    static void checkRow(char[][] matrix, int r, int n) {
        int count = 0;
        int s = 0;
        char a = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                a = matrix[r][i];
                count++;
                continue;
            }

            if (a == matrix[r][i]) {
                count++;
            } else {
                a = matrix[r][i];
                s = Math.max(s, count);
                count = 1;
            }

        }
        s = Math.max(s, count);

        max = Math.max(max, s);

    }

    static void checkCol(char[][] matrix, int r, int n) {
        int count = 0;
        int s = 0;
        char a = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                a = matrix[i][r];
                count++;
                continue;
            }

            if (a == matrix[i][r]) {
                count++;
            } else {
                a = matrix[i][r];
                s = Math.max(s, count);
                count = 1;
            }
        }
        s = Math.max(s, count);

        max = Math.max(max, s);

    }


}
