import java.util.*;

public class Cote01142 {

    static class Solution1 {

        public void dfs(int node , boolean[] visited, List<List<Integer>> graph){
            visited[node] = true;
            // dfs 는 깊이 우선탐색.
            for (int next : graph.get(node)){
                if (!visited[next]){
                    dfs(next, visited, graph);
                }
            }
        }
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {

            // 노드의 개수는 곧 rooms 의 size
            int n = rooms.size();

            boolean[] visited = new boolean[n];
            // 0번 방부터 탐색시작하자.
            dfs(0, visited, rooms);


            for (boolean element : visited){
                if (!element) return false;
            }

            return true;
        }
    }

    static class Solution2 {

        public void bfs(int startNode , boolean[] visited, List<List<Integer>> graph){
            // 큐 정의
            Queue<Integer> queue = new ArrayDeque<>();


            // startNode (시작 노드) 방문 처리.
            queue.offer(startNode);
            visited[startNode] = true;

            while (!queue.isEmpty()){
                int cur = queue.poll();

                // cur 노드와 연결된 노드들 (다음 탐색해야할 노드들)
                for (int next : graph.get(cur)){
                    if (!visited[next]){
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {

            // 노드의 개수는 곧 rooms 의 size
            int n = rooms.size();

            boolean[] visited = new boolean[n];
            // 0번 방부터 탐색시작하자.
            bfs(0, visited, rooms);

            // bfs 탐색 완료후, visited 순회하면서 false 가 있으면 바로 return false
            for (boolean element : visited){
                if (!element) return false;
            }

            return true;
        }
    }






}
