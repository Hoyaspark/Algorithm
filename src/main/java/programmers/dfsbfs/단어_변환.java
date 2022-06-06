package programmers.dfsbfs;

import java.util.*;

public class 단어_변환 {

    public int solution(String begin, String target, String[] words) {

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.add(new Node(begin,0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            String poll = node.str;

            if(poll.equals(target)){
                return node.count;
            }


            for(int i=0;i<words.length;i++){
                if(!visited[i]){
                    if(isTrue(poll,words[i])){
                        visited[i] = true;
                        queue.add(new Node(words[i], node.count + 1));
                    }
                }
            }
        }

        return 0;
    }

    public boolean isTrue(String source, String dest){
        char[] sourceChar = source.toCharArray();
        char[] destChar = dest.toCharArray();

        int count = 0;

        for(int i=0;i<destChar.length;i++){
            if(sourceChar[i] != destChar[i])
                count++;
        }

        if(count == 1) return true;

        return false;
    }

    static class Node {
        String str;
        int count;

        public Node(String str, int count){
            this.str = str;
            this.count = count;
        }
    }
}
