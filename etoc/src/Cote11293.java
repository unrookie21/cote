import java.util.*;

public class Cote11293 {

    class Solution {

        public int answer = 0;


        public int solution(int n, int[][] results) {

            List<List<Integer>> winGraph = new ArrayList<>();
            List<List<Integer>> loseGraph = new ArrayList<>();

            for (int i = 0; i <=n ; i++){
                winGraph.add(new ArrayList<>());
                loseGraph.add(new ArrayList<>());
            }


            for (int[] result : results){
                int winner = result[0];
                int loser = result[1];

                winGraph.get(winner).add(loser);
                loseGraph.get(loser).add(winner);
            }

            for (int i = 1; i <=n ; i++){
                int winCount = dfs(i, winGraph, new boolean[n+1]);
                int loseCount = dfs(i, loseGraph, new boolean[n+1]);

                if (winCount + loseCount == n - 1) answer++;
            }

            return answer;
        }

        public int dfs(int node, List<List<Integer>> graph, boolean[] visited){
            visited[node] = true;
            int count = 0;

            for (int next : graph.get(node)){
                if (!visited[next]){
                    count += 1 + dfs(next, graph, visited);
                }
            }

            return count;
        }
    }
}
