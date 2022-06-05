package boj.day1;

import java.util.*;
import java.util.stream.Collectors;

public class StudyWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine().toLowerCase(Locale.KOREA);

        Character result = 0;

        int max = 0;

        Map<Character, Integer> resultMap = new HashMap<>();

        for (char c : inputString.toCharArray()) {
            Integer getValue = resultMap.getOrDefault(c, 0);
            if (getValue.equals(0)) {
                resultMap.put(c, 1);
                continue;
            }

            resultMap.put(c, ++getValue);
        }

        for (Map.Entry<Character, Integer> entry : resultMap.entrySet()) {
            if (max < entry.getValue()) {
                result = entry.getKey();
                max = entry.getValue();
            }
        }

        int resultCount = 0;
        for (Integer value : resultMap.values()) {
            if (value.equals(max)) {
                resultCount++;
            }

            if (resultCount > 1) {
                System.out.println("?");
                return;
            }
        }

        System.out.println(result.toString().toUpperCase());

    }
}
