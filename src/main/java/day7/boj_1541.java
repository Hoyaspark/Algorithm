package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj_1541 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] split = input.split("[-]");
        ArrayList<Integer> result = new ArrayList<>();
        int sum = 0;


        for (int i = 0; i < split.length; i++) {
            if (split[i].contains("+")) {
                String[] s = split[i].split("[+]");
                result.add(Arrays.stream(s).mapToInt(Integer::parseInt)
                    .sum());
            } else {
                result.add(Integer.parseInt(split[i]));
            }
        }

        for (int i = 0; i < result.size(); i++) {
            if (i == 0) {
                sum = result.get(i);
                continue;
            }

            sum -= result.get(i);
        }

        System.out.println(sum);



    }

}
