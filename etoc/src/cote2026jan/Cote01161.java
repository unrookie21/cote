package cote2026jan;

import java.util.*;

public class Cote01161 {

    static class Solution {

        public boolean bfs(int start, int[][] graph, boolean[] visited, int[] color){

            Queue<Integer> queue = new ArrayDeque<>();

            // 시작점 방문처리
            queue.offer(start);
            visited[start] = true;

            // 팀도 할당하자
            color[start] = 0;

            while(!queue.isEmpty()){
                int cur = queue.poll();

                for (int next : graph[cur]){
                    if (color[next] == color[cur]){
                        return false;
                    }

                    // 다른 팀이면 팀 할당
                    if (!visited[next]){
                        color[next] = 1 - color[cur];
                        queue.offer(next);
                        visited[next] = true;
                    }

                }
            }
            return true;
        }


        public boolean isBipartite(int[][] graph) {

            int n = graph.length;
            boolean[] visited = new boolean[n];
            int[] color = new int[n];
            Arrays.fill(color , - 1);
            for (int i = 0; i < n; i++){
                // 만약 방문하지 않은 곳이면,  bfs 탐색들어가자.
                if (!visited[i]){
                    // true or fasle 반환
                    if (!bfs(i,  graph, visited, color)){
                        return false;
                    };
                }
            }

            return true;
        }
    }


}
