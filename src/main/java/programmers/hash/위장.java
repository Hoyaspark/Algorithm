package programmers.hash;

import java.util.*;

public class 위장 {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String,ArrayList<String>> bag = new HashMap<>();

        for(int i=0;i<clothes.length;i++){
            String wear = clothes[i][0];
            String kind = clothes[i][1];

            ArrayList<String> list = bag.getOrDefault(kind,new ArrayList<>());

            // 리스트에 옷 추가
            list.add(wear);

            // 옷장에 옷 추가
            bag.put(kind,list);
        }

        int count = 1;
        for(Map.Entry<String,ArrayList<String>> entry : bag.entrySet()){
            ArrayList<String> wears = entry.getValue();
            count *= wears.size() + 1;
        }
        return count -1;
    }
}
