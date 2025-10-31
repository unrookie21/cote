import java.util.*;
public class Cote1031 {
    class Solution {

        public void BFS(List<List<Integer>> graph, int start, boolean[] visited, int[][] lockers){
            int n = graph.size(); // node count
            Deque<Integer> queue = new ArrayDeque<>();

            queue.offer(start);
            visited[start] = true;

            while(!queue.isEmpty()){
                int cur = queue.poll();

                for (int next : lockers[cur]){
                    if (!visited[next]){
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        public int solution(int[][] lockers) {
            int answer = 0;
            List<List<Integer>> graph = new ArrayList<>();
            int n = lockers.length; // 노드 개수
            boolean[] visited = new boolean[n];

            BFS(graph, 0, visited, lockers);
            for (boolean flag : visited){
                if (flag == false) answer++;
            }
            return answer;
        }
    }
    public static void main(String[] args) {


    }
}
