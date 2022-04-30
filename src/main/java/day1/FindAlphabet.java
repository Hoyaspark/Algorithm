package day1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindAlphabet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> alphabets = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

        String input = scanner.nextLine();

        List<Integer> result = alphabets.stream()
                .map((alphabet) -> input.indexOf(alphabet))
                .collect(Collectors.toList());

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}
