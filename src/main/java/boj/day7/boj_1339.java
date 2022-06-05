package boj.day7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class boj_1339 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        scanner.nextLine();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }

        Map<Character, Double> map = new HashMap<Character, Double>();

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            for (int j = 0; j < str.length(); j++) {
                Double value = map.getOrDefault(str.charAt(j), 0.0);
                map.put(str.charAt(j), value + Math.pow(10, str.length() - 1 - j));
            }
        }

        ArrayList<Node> nodeArrayList = new ArrayList<>();
        for (Entry<Character, Double> entry : map.entrySet()) {
            nodeArrayList.add(new Node(entry.getKey(), entry.getValue()));
        }

        nodeArrayList.sort((a, b) -> (int) b.getValue() - (int) a.getValue());

        int num = 9;
        int sum = 0;
        for (int i = 0; i < nodeArrayList.size(); i++) {
            sum += (int) nodeArrayList.get(i).getValue() * num--;
        }

        System.out.println(sum);

    }

    static class Node {
        private Character c;
        private double value;

        public Node(Character c, double value) {
            this.c = c;
            this.value = value;
        }

        public Character getC() {
            return c;
        }

        public double getValue() {
            return value;
        }
    }

}
