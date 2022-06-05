package boj.boj500;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_6064 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            //10,12  3,11 --> 23번째

            // 최대 공약수
            int xx =x,yy =y,lcd =0;

            while (true) {
                if (xx % yy == 0) {
                    lcd = yy;
                    break;
                }
                int a = xx % yy;
                xx = yy;
                yy = a;
            }

            int gcd = x * y / lcd;
            int year = x % (m+1);
            while (true) {
                if (year > gcd) {
                    result.add(-1);
                    break;
                }

                year += m;
            }

        }

        for (int i = 0; i < t; i++) {
            if (result.get(i) == -1) {
                System.out.println(-1);
            } else {
                System.out.println(result.get(i));
            }
        }

    }
}
