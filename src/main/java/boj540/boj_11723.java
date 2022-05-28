package boj540;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int s = 0;

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];
            if (cmd.equals("add")) {
                int num = Integer.parseInt(input[1]);
                int mask = (int) Math.pow(2, 20) / (int) Math.pow(2, num);
                if ((s & mask) == 0) {
                    s = s | mask;
                }
            } else if (cmd.equals("remove")) {
                int num = Integer.parseInt(input[1]);
                int mask = (int) Math.pow(2, 20) / (int) Math.pow(2, num);
                if ((s & mask) != 0) {
                    s = s ^ mask;
                }
            } else if (cmd.equals("check")) {
                int num = Integer.parseInt(input[1]);
                int mask = (int) Math.pow(2, 20) / (int) Math.pow(2, num);
                if ((s & mask) != 0) {
                    str.append(1);
                    str.append("\n");
                } else {
                    str.append(0);
                    str.append("\n");
                }
            } else if (cmd.equals("toggle")) {
                int num = Integer.parseInt(input[1]);
                int mask = (int) Math.pow(2, 20) / (int) Math.pow(2, num);
                if ((s & mask) != 0) {
                    s = s ^ mask;
                } else {
                    s = s | mask;
                }
            } else if (cmd.equals("all")) {
                s = 0;
                for (int k = 0; k < 20; k++) {
                    s += (int) Math.pow(2, k);
                }
            } else if (cmd.equals("empty")) {
                s = 0;
            }
        }

        System.out.println(str);
    }
}
