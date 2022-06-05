package programmers.hash;

import java.util.*;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String,Integer> map = new HashMap<>();

        for(String person : participant){
            Integer count = map.getOrDefault(person,0);
            map.put(person,count+1);
        }

        for(String person : completion){
            Integer count = map.get(person);
            count--;
            if(count == 0){
                map.remove(person);
            }else{
                map.put(person,count);
            }
        }
        Iterator<String> iter = map.keySet().iterator();
        return iter.next();
    }

}
