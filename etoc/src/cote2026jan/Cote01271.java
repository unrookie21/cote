package cote2026jan;

import java.util.*;

public class Cote01271 {

    public int[] topologicalSort(int n, int[][] edges) {

        // edges 를 그래프로 변형하자.
        Map<Integer, List<Integer>> graph = new HashMap<>();

        int[] indegree = new int[n];

        // edges 의 [v, u] 는  u -> v 의 방향을 가진 edge 를 뜻함.
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);
            // 0 은 v , 1 은 u

            indegree[edge[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        int[] order = new int[n];

        // indegree 가 0인 노드를 큐에 집어넣자.
        int count = 0;
        for (int c = 0; c < n; c++){
            if (indegree[0] == 0){
                queue.add(c);
                visited[c] = true;
                order[count] = c;
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (graph.containsKey(cur)){
                // 해당 노드와 연결된 노드들의 진입 차수에서 1을 뺀다.
                for (int next : graph.get(cur)) {
                    indegree[next]--;
                    // 진입차수가 0이면, 방문 가능하기 때문에 q 에 추가
                    if (indegree[next] == 0) {
                        visited[next] = true;
                        order[count] = next;
                        count++;
                        queue.add(next);
                    }

                }



            }
        }
        return order;
    }
}
