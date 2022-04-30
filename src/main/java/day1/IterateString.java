package day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IterateString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Game> games = new ArrayList<>();

        Integer totalCount = scanner.nextInt();

        for (int i = 0; i < totalCount; i++) {
            int iterateCount = scanner.nextInt();
            String inputString = scanner.next();

            games.add(new Game(iterateCount, inputString));
        }

        games.forEach(game -> System.out.println(game.make()));

    }

    private static class Game {
        private int iterateCount;
        private String inputString;

        public Game(int iterateCount, String inputString) {
            this.iterateCount = iterateCount;
            this.inputString = inputString;
        }

        public String make() {
            StringBuilder stringBuilder = new StringBuilder(iterateCount * inputString.length());
            for (int i = 0; i < inputString.length(); i++) {
                for (int j = 0; j < iterateCount; j++) {
                    stringBuilder.append(inputString.charAt(i));
                }
            }

            return stringBuilder.toString();
        }
    }
}
