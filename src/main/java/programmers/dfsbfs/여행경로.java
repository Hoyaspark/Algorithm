package programmers.dfsbfs;

import java.util.*;

public class 여행경로 {
    static LinkedList<String> answer = new LinkedList<>();
    static boolean check = false;
    public LinkedList<String> solution(String[][] tickets) {
        // 출발 공항
        String begin = "ICN";

        ArrayList<ArrayList<String>> array = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for(int i=0;i<tickets.length;i++){
            ArrayList<String> list = new ArrayList<String>();
            for(int j=0;j<2;j++){
                list.add(tickets[i][j]);
                set.add(tickets[i][j]);
            }
            array.add(list);
        }

        Collections.sort(array, (a,b)->{
            int pos = a.get(0).compareTo(b.get(0));
            if(pos == 0){
                return a.get(1).compareTo(b.get(1));
            }else{
                return pos;
            }
        });

        boolean[] visited = new boolean[tickets.length];

        LinkedList<String> init = new LinkedList<>();
        init.add(begin);
        dfs(array,visited,new Node(begin,init));

        return answer;
    }

    public void dfs(ArrayList<ArrayList<String>> array, boolean[] visited, Node node){
        if(!check){
            int count = 0;
            for(int i=0;i<visited.length;i++){
                if(visited[i])
                    count++;
            }
            if(count == visited.length){
                answer.addAll(node.route);
                check = true;
                return;
            }
        }

        for(int i=0;i<array.size();i++){
            if(array.get(i).get(0).equals(node.city)){
                if(!visited[i]){
                    visited[i] = true;
                    LinkedList<String> list = new LinkedList<>();
                    list.addAll(node.route);
                    list.add(array.get(i).get(1));
                    dfs(array,visited,new Node(array.get(i).get(1),list));
                    visited[i] = false;
                }
            }
        }
    }

    static class Node {
        String city;
        LinkedList<String> route;

        public Node(String city, LinkedList<String> list){
            this.city = city;
            this.route = list;
        }
    }
}
