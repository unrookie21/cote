package cote2025nov;

import java.util.*;

public class Cote1123 {

    class Solution {

        // 이동가능한 방향 : 동 , 서 , 남 , 북
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        public int BFS(int[][] maps, int startX, int startY, int n, int m, int[][] distance){

            int endX = n - 1;
            int endY = m - 1;

            Deque<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{startX, startY});
            distance[startX][startY] = 1; // 출발시점에서의 거리는 0이므로.

            while(!queue.isEmpty()){
                int[] cur = queue.poll();

                int x = cur[0];
                int y = cur[1];

                if (x == endX && y == endY){
                    return distance[x][y];
                }

                for (int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] != 0){
                        if (distance[nx][ny] == -1){
                            // 아직 방문하지 않았다면, 방문!
                            queue.offer(new int[]{nx,ny});
                            // 거리는 , 이전 거리에서 1더하기.
                            distance[nx][ny] = distance[x][y] + 1;
                        }
                    }
                }

            }
            return -1;
        }

        public int solution(int[][] maps) {

            // 암시적 그래프네요.
            int n = maps.length;
            int m = maps[0].length;
            int[][] distance = new int[n][m];
            // distance 의 모든 값을 처음에 -1 로 초기화한다. (방문하지 않은 것으로 설정)
            for (int[] arr : distance){
                Arrays.fill(arr, -1);
            }

            return BFS(maps, 0, 0, n, m, distance);
        }
    }
}
