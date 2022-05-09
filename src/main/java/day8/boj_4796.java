package day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class boj_4796 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Tent> list = new ArrayList<>();
        while (true) {
            String s = scanner.nextLine();

            String[] s1 = s.split(" ");

            int L = Integer.parseInt(s1[0]);
            int P = Integer.parseInt(s1[1]);
            int V = Integer.parseInt(s1[2]);

            if (L == 0 && P == 0 && V == 0) {
                break;
            }
            list.add(new Tent(L, P, V));
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Tent tent = list.get(i);

            int a = tent.getV() / tent.getP();
            int b = Math.min(tent.getV() % tent.getP(), tent.getL());

            result.add(a * tent.getL() + b);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println("Case " + (i + 1) + ": " + result.get(i));
        }

    }

    static class Tent {
        private int L;
        private int P;
        private int V;

        public Tent(int l, int p, int v) {
            L = l;
            P = p;
            V = v;
        }

        public int getL() {
            return L;
        }

        public int getP() {
            return P;
        }

        public int getV() {
            return V;
        }
    }

}
