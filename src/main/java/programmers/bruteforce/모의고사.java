package programmers.bruteforce;

import java.util.*;

public class 모의고사 {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<int[]> people = new ArrayList<>();

        int[] p1 = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] p2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        people.addAll(Arrays.asList(p1,p2,p3));

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<answers.length;i++){
            int ans = answers[i];
            if(people.get(0)[i%10] == ans){
                int count = map.getOrDefault(1,0);
                map.put(1,count+1);
            }

            if(people.get(1)[i%16] == ans){
                int count = map.getOrDefault(2,0);
                map.put(2,count+1);
            }

            if(people.get(2)[i%20] == ans){
                int count = map.getOrDefault(3,0);
                map.put(3,count+1);
            }
        }

        int max = Integer.MIN_VALUE;

        max = Math.max(max, map.getOrDefault(1,0));
        max = Math.max(max, map.getOrDefault(2,0));
        max = Math.max(max, map.getOrDefault(3,0));

        ArrayList<Integer> answer = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Integer key = entry.getKey();
            Integer count = entry.getValue();

            if(count == max){
                answer.add(key);
            }
        }

        return answer;
    }
}
