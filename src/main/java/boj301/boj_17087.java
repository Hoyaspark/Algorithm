package boj301;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class boj_17087 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        long X = scanner.nextInt();

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        ArrayList<Long> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            long max = Math.max(arr[i], X);
            long min = Math.min(arr[i], X);

            list.add(max - min);
        }

        Collections.sort(list, Comparator.reverseOrder());


        if (list.size() == 1) {
            System.out.println(list.get(0));

            return;
        }

        long num = gcd(list.get(0), list.get(1));

        for (int i = 2; i < list.size(); i++) {
            num = gcd(num, list.get(i));
        }

        System.out.println(num);

    }

    public static long gcd(long n, long m) {
        long a = 0;
        while (true) {
            if (n % m == 0) {
                return m;
            }

            a = m;
            m = n % m;
            n = a;
        }
    }

}
