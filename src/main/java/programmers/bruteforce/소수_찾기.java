package programmers.bruteforce;

import java.util.*;

public class 소수_찾기 {
    static boolean[] isPrime = new boolean[10000000];
    static int answer = 0;
    static Set<Integer> numSet = new LinkedHashSet<>();

    public int solution(String numbers) {

        // 소수인지 아닌지 판단하는 boolean 배열 초기화
        init();

        char[] nums = numbers.toCharArray();
        int[] array = new int[nums.length];
        int[] result = new int[nums.length];
        boolean[] visited = new boolean[nums.length];

        int i = 0;

        for (char num : nums) {
            array[i++] = num - '0';
        }

        dfs(array, result, visited, 0, array.length, array.length);

        Iterator<Integer> iter = numSet.iterator();
        while (iter.hasNext()) {
            int num = iter.next();
            if (isPrime[num])
                answer++;
        }

        return answer;
    }

    public void dfs(int[] array, int[] result, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            String res = "";
            for (int i = 0; i < depth; i++) {
                res += String.valueOf(result[i]);
            }

            numSet.add(Integer.valueOf(res));
            return;
        } else if (depth != 0) {
            String res = "";
            for (int i = 0; i < depth; i++) {
                res += String.valueOf(result[i]);
            }
            numSet.add(Integer.valueOf(res));
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = array[i];
                dfs(array, result, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    public void init() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < 10000000; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j < 10000000; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
    }
}
