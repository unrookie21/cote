package cote2026jan;

import java.util.*;
public class Cote01201 {


    static class Solution {

        public int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        public int[] dy = {-1  ,0  ,1 ,-1 ,1,-1, 0, 1};

        public int bfs(int startX, int startY, int endX, int endY, int[][] distance,
                       int[][] grid, boolean[][] visited ){

            int n = grid.length;

            // 큐 생성
            Queue<int[]> queue = new ArrayDeque<>();
            // 거리 초기화
            distance[startX][startY] = 1;
            visited[startX][startY] = true;
            queue.offer(new int[]{startX, startY});

            while(!queue.isEmpty()){

                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                if (x == endX && y == endY){
                    return distance[x][y];
                }

                for (int i = 0; i < 8; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n){
                        if (grid[nx][ny] == 0 && !visited[nx][ny]){
                            distance[nx][ny] = distance[x][y] + 1;
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }

            return -1;
        }

        public int shortestPathBinaryMatrix(int[][] grid) {

            int n = grid.length;
            int[][] distance = new int[n][n];

            // distance 는 -1 로 초기화해놓자.
            for (int i = 0 ; i < n ; i++){
                Arrays.fill(distance[i] , - 1);
            }

            boolean[][] visited = new boolean[n][n];

            if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

            return bfs(0,0, n-1, n-1, distance, grid, visited);
            // 0,0 에서 출발해서 n-1 , n-1 까지의 최단거리 구하기




        }
    }

}
