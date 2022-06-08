package programmers.stackqueue;

import java.util.*;

public class 프린터 {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Node> queue = new LinkedList<>();

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<priorities.length;i++)
            queue.add(new Node(priorities[i],i));

        while(!queue.isEmpty()){
            Node poll = queue.poll();
            boolean isTrue = false;
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node check = queue.poll();
                if(check.priority > poll.priority)
                    isTrue = true;
                queue.add(check);
            }

            if(isTrue)
                queue.add(poll);
            else{
                answer++;
                map.put(poll.index,answer);
            }
        }

        return map.get(location);
    }

    static class Node{
        int priority;
        int index;

        public Node(int priority,int index){
            this.priority = priority;
            this.index = index;
        }
    }
}
