import java.util.*;
import java.io.*;

public class Cote11253 {

    static int minCost = Integer.MAX_VALUE;

    public static void DFS(int cur, int cost, int visitedCount, int N, int[][] W,
                           boolean[] visited) {

        // cost 가 현재 minCost 보다 크거나 같으면 중단
        if (cost >= minCost) return;

        // 모든 도시 방문 완료했을 때,
        if (visitedCount == N) {
            // 시작점으로 돌아갈 수 있는지 확인한다.
            if (W[cur][0] != 0) {
                minCost = Math.min(minCost, cost + W[cur][0]);
            }
            return;
        }

        for (int next = 0; next < N; next++) {

            if(!visited[next] && W[cur][next] != 0) {
                visited[next] = true;
                DFS(next, cost + W[cur][next], visitedCount + 1, N, W, visited);
                visited[next] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시 개수
        int N = Integer.parseInt(br.readLine());
        int[][] W = new int[N][N];

        for (int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++){
                W[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 방문 배열
        boolean[] visited = new boolean[N];

        visited[0] = true; // 첫번째 도시 방문!
        // DFS 탐색 시작  (현재 도시, 현재까지의 비용,현재까지 방문한 도시 수 )
        DFS(0, 0, 1, N, W , visited);

        System.out.println(minCost);

    }

}



