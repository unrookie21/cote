package cote2026jan;

public class Cote01081 {

    static class Solution {

        public int max = Integer.MIN_VALUE;

        public void dfs(int k, int[][] dungeons, int count, boolean[] visited){

            max = Math.max(max, count);
            if (count == dungeons.length) return; // base (없어도 무방)

            for (int i = 0; i < dungeons.length; i++){
                // 던전에 입장 가능한지 check. 입장 비용이 현재 피로보다 작거나 같은 경우에만 가능
                if (!visited[i] && dungeons[i][0] <= k){
                    visited[i] = true; // 방문처리
                    dfs(k - dungeons[i][1] , dungeons, count + 1, visited); // 탐색 진행
                    visited[i] = false; // 복귀 후, 방문 해제 (다른 경로도 탐색 진행해야하므로)
                }
            }
        }
        public int solution(int k, int[][] dungeons) {

            // 유저가 탐험할 수 있는 최대 던전 수를 return 한다.
            // dungeons 에 대해 완전 탐색 진행한다.
            // k 는 현재 피로도

            boolean[] visited = new boolean[dungeons.length]; // 방문 배열 선언
            dfs(k, dungeons, 0, visited);

            return max;
        }
    }


    static class Solution2 {

        public int max = Integer.MIN_VALUE;

        public void dfs(int k, int[][] dungeons, int count, boolean[] visited){

            max = Math.max(max, count);
            if (count == dungeons.length) return; // base (없어도 무방)

            for (int i = 0; i < dungeons.length; i++){
                // 던전에 입장 가능한지 check. 입장 비용이 현재 피로보다 작거나 같은 경우에만 가능
                if (!visited[i] && dungeons[i][0] <= k){
                    visited[i] = true; // 방문처리
                    dfs(k - dungeons[i][1] , dungeons, count + 1, visited); // 탐색 진행
                    visited[i] = false; // 복귀 후, 방문 해제 (다른 경로도 탐색 진행해야하므로)
                }
            }
        }
        public int solution(int k, int[][] dungeons) {

            // 유저가 탐험할 수 있는 최대 던전 수를 return 한다.
            // dungeons 에 대해 완전 탐색 진행한다.
            // k 는 현재 피로도

            boolean[] visited = new boolean[dungeons.length]; // 방문 배열 선언
            dfs(k, dungeons, 0, visited);

            return max;
        }
    }
}
