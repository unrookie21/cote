package cote2026jan;

import java.util.*;
public class Cote01272 {

    static class Solution {

        public boolean canFinish(int numCourses, int[][] prerequisites) {

            // 위상정렬

            // prerequisites [ai, bi] 를 graph 로 일단 변환하자.
            // bi  (1) -> ai (0)

            Map<Integer, List<Integer>> graph = new HashMap<>();

            int[] indegree = new int[numCourses];

            for (int[] edge : prerequisites){
                graph.putIfAbsent(edge[1] , new ArrayList<>());
                graph.get(edge[1]).add(edge[0]);

                // indegree 계산.
                indegree[edge[0]]++;
            }

            int[] order = new int[numCourses];
            boolean[] visited = new boolean[numCourses];

            Queue<Integer> queue = new ArrayDeque<>();

            int count = 0;
            // indegree 가 0인 애들을 큐에 넣고, order 에 적자.
            for (int c = 0; c < numCourses; c++){
                if (indegree[c] == 0){
                    queue.offer(c);
                    visited[c] = true;
                    order[count] = c;
                    count++;
                }

            }

            while(!queue.isEmpty()){

                int cur = queue.poll();

                // cur 와 연결된 다음 노드들의 진입 차수를 1씩 감소시킨다.
                if (graph.containsKey(cur)){
                    for (int next : graph.get(cur)){
                        indegree[next]--;
                        if (indegree[next] == 0){
                            queue.offer(next);
                            visited[next] = true;
                            order[count] = next;
                            count++;
                        }
                    }
                }
            }

            // 이제 order 에는 수업을 수강해야하는 순서가 담겨잇다.
            // order 에 0의 개수가 2개이상이면 return false
            int zeroCount = 0;
            for (int i = 0; i < numCourses; i++){
                if (order[i] == 0){
                    zeroCount++;
                    if (zeroCount >= 2){
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
