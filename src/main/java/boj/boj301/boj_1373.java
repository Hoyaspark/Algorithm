package boj.boj301;

import java.util.Scanner;

public class boj_1373 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder str = new StringBuilder(input);
        // 뒤에서부터 3개씩 끊어준다.
        if (input.length() % 3 != 0) {
            for (int i = 0; i < 3 - (input.length() % 3); i++){
                str.insert(0, "0");
            }
        }

        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            if (i % 3 == 2) {
                result.append((str.charAt(i - 2) - '0') * 4 + (str.charAt(i - 1) - '0') * 2
                    + (str.charAt(i) - '0') * 1);
            }
        }

        System.out.println(result);



    }

}
