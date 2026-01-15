package cote2025nov;

public class Cote11261 {
    // 완전탐색 DFS
    class Solution {

        int maxDungeon;

        public int DFS(int k, int count, int[][] dungeons, boolean[] visited){

            // 최대 던전수 갱신
            maxDungeon = Math.max(count, maxDungeon);

            for (int i = 0; i < dungeons.length; i++){
                if(!visited[i] && k >= dungeons[i][0]){
                    visited[i] = true;
                    DFS(k - dungeons[i][1] , count + 1, dungeons, visited);
                    visited[i] = false;
                }
            }

            return maxDungeon;
        }


        public int solution(int k, int[][] dungeons) {

            int N = dungeons.length; // 던전 개수
            boolean[] visited = new boolean[N];

            maxDungeon = 0;
            return DFS(k, 0, dungeons, visited);
        }
    }
}
