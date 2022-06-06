package programmers.stackqueue;

import java.util.*;

public class 기능개발 {
    public LinkedList<Integer> solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> result = new LinkedList<>();

        Queue<Node> queue = new LinkedList<>();

        for(int i=0;i<progresses.length;i++){
            Node node = new Node(progresses[i],i);
            queue.add(node);
        }


        while(!queue.isEmpty()){
            Node peek = queue.peek();

            if(peek.progress >= 100){
                queue.poll();
                int count = 1;
                System.out.println("in");
                int size = queue.size();
                for(int i=0;i<size;i++){
                    Node pk = queue.peek();
                    System.out.println(pk.index);
                    if(pk.progress >= 100){
                        queue.poll();
                        count++;
                    }else{
                        break;
                    }
                }
                result.add(count);
            }

            for(int i=0;i<queue.size();i++){
                Node node = queue.poll();
                queue.add(new Node(node.progress + speeds[node.index], node.index));
            }
        }


        return result;
    }

    static class Node{
        int progress;
        int index;

        public Node(int progress, int index){
            this.progress = progress;
            this.index = index;
        }
    }
}
