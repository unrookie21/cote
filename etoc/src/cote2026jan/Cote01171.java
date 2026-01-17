package cote2026jan;

import java.util.*;
public class Cote01171 {
    static class Solution {

        int max = Integer.MIN_VALUE;

        // sheep : 양의 수, wolf : 늑대 수
        public void dfs(int[] info, int[][] edges, boolean[] visited,
                        int sheep, int wolf){

            // base : 양의 수 == 늑대의 수이면, 잡아먹히게 되므로 더이상 깊이 있는 탐색을 하지 못함.
            if (sheep == wolf){
                return;
            }

            max = Math.max(sheep, max);

            for (int[] edge : edges){
                int parent = edge[0]; // 부모 노드
                int child = edge[1]; // 자식 노드

                if (visited[parent] && !visited[child]){
                    // 방문처리
                    visited[child] = true;
                    if (info[child] == 0){ // 양인 경우
                        dfs(info, edges, visited, sheep + 1, wolf);
                    } else { // 늑대인 경우
                        dfs(info, edges, visited, sheep, wolf + 1);
                    }
                    visited[child] = false;
                }
            }
        }


        public int solution(int[] info, int[][] edges) {

            // dfs, backtracking

            boolean[] visited = new boolean[info.length];
            // 첫번째 노드 방문 처리
            visited[0] = true;
            dfs(info, edges, visited, 1, 0);
            return max;
        }
    }

}
