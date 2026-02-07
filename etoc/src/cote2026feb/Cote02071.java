package cote2026feb;

import java.util.*;
public class Cote02071 {

    static class Solution {
        public int solution(int n, int[][] wires) {

            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++){
                graph.add(new ArrayList<>());
            }

            // graph 초기화 (양방향)
            for (int[] wire : wires){
                graph.get(wire[0]).add(wire[1]);
                graph.get(wire[1]).add(wire[0]);
            }

            int minValue = Integer.MAX_VALUE;

            // 모든 전선을 탐색해보자. 탐색하는 전선마다, "끊어야 함."
            for (int[] wire : wires){

                int v1 = wire[0];
                int v2 = wire[1];

                boolean[] visited = new boolean[n+1];
                // 전선을 끊는다는건 곧, v2 로 이동을 못하게 만들면 됨/

                visited[v2] = true;

                // v1 에서 탐색시작해서 자식 노드의 개수를 계산해오자.
                int count = dfs(v1, visited, graph);
                int diff = Math.abs(2 * count - n);

                minValue = Math.min(minValue, diff);
            }

            return minValue;
        }

        public int dfs(int node, boolean[] visited, List<List<Integer>> graph){

            int count = 1;

            // 방문처리
            visited[node] = true;

            // 자식 노드 방문
            for (int child : graph.get(node)){
                if (!visited[child]){
                    visited[child] = true;
                    count += dfs(child, visited, graph);
                }
            }



            return count;
        }
    }
}
