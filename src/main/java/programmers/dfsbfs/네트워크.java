package programmers.dfsbfs;

import java.util.*;

public class 네트워크 {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        // bfs 사용
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){
            Queue<Integer> queue = new LinkedList<>();
            if(!visited[i]){
                queue.add(i);
                visited[i] = true;
                while(!queue.isEmpty()){
                    Integer poll = queue.poll();

                    for(int j=0;j<n;j++){
                        if(!visited[j] && poll != j && computers[poll][j] == 1){
                            visited[j] = true;
                            queue.add(j);
                        }
                    }

                }
                answer++;
            }
        }

        return answer;
    }
}
