package programmers.stackqueue;

import java.util.*;
import java.util.stream.Collectors;

public class 주식가격 {

    public List<Integer> solution(int[] prices) {

        List<Integer> list = Arrays.stream(prices).boxed().collect(Collectors.toList());
        List<Integer> result = new LinkedList<>();

        for(int i=0;i<list.size();i++){
            boolean isTrue = false;
            for(int j=i+1;j<list.size();j++){
                if(list.get(i) > list.get(j)){
                    result.add(j-i);
                    isTrue = true;
                    break;
                }
            }

            if(!isTrue){
                result.add(list.size() - i - 1);
            }
        }


        return result;
    }
    static class Node{
        int index;
        int price;

        public Node(int index,int price){
            this.index = index;
            this.price = price;
        }
    }

}
