import java.util.*;

public class Cote11291 {

    class Solution {

        int answer = 0;

        public void BFS(List<List<Integer>> graph, int start, int n){

            Queue<Integer> queue = new ArrayDeque<>();
            int[] distance = new int[n + 1];
            Arrays.fill(distance, - 1);

            queue.offer(start);
            distance[start] = 0;

            while(!queue.isEmpty()){

                int cur = queue.poll();

                for (int next : graph.get(cur)){
                    if (distance[next] == -1){
                        queue.offer(next);
                        distance[next] = distance[cur] + 1;
                    }
                }

            }

            //distance 배열에서 최댓값을 찾고, 최댓값과 일치하는 원소가 몇개인지 반환하면 그것이 구하고자하는 정답
            int max = Arrays.stream(distance).max().getAsInt();
            for (int distanceElement : distance){

                if (distanceElement == max){
                    answer++;
                }

            }
        }
        public int solution(int n, int[][] edges) {

            // graph 선언
            List<List<Integer>> graph = new ArrayList<>();

            // n 은 노드 개수
            for (int i = 0; i <= n; i++){
                graph.add(i, new ArrayList<>());
            }

            // graph 초기화완료.
            for (int[] edge : edges){
                int a = edge[0];
                int b = edge[1];

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            BFS(graph, 1, n);

            return answer;
        }
    }
}
