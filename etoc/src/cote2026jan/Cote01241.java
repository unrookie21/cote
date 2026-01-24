package cote2026jan;

import java.util.*;

public class Cote01241 {

    static class Solution {

        public int[] dx = {1,-1,0,0};
        public int[] dy = {0,0,-1,1};

        public int[] jdx = {2,-2,0,0};
        public int[] jdy = {0,0,-2,2};

        public int[][] makeGrid(int[][] hole, int m, int n){

            int[][] grid = new int[m][n]; // grid 원소를 모두 0으로 초기화

            for (int [] oneHole : hole){

                int b = oneHole[0]; // col 정보
                int a = oneHole[1]; // a 에는 row 정보 있음

                int convertedRowIdx = m - a;
                int convertedColIdx = b - 1;

                grid[convertedRowIdx][convertedColIdx] = 1; // 구멍은 1로 처리.

                // 구멍이 아닌 칸은 0(빈칸) 인 상태.
            }

            return grid;
        }

        public int solution(int n, int m, int[][] hole) {
            int answer = -1;

            int endX = 0;
            int endY = n - 1;

            int[][] grid = makeGrid(hole, m, n); // hole 정보를 받아서 grid 만들자. (좌표 변환도 함께)

            boolean[][][] visited = new boolean[m][n][2];
            Queue<int[]> queue = new ArrayDeque<>();

            // 시작점 처리
            int startX = m -1;
            int startY = 0;

            queue.add(new int[]{startX, startY, 0, 0}); // 0 : 점프사용여부, 0 : 이동거리
            visited[startX][startY][0] = true;

            while(!queue.isEmpty()){

                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int jumped = cur[2];
                int dist = cur[3];

                // 보물 칸 도달
                if (x == endX && y == endY){
                    return dist;
                }

                // 일반 상하좌우 이동
                for (int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0) {
                        if(!visited[nx][ny][jumped]){
                            visited[nx][ny][jumped] = true;
                            queue.offer(new int[]{nx,ny, jumped, dist + 1});
                        }
                    }
                }

                // 점프를 아직 안 썻다면
                if (jumped == 0){
                    for (int i = 0; i < 4; i++){
                        int nx = x + jdx[i];
                        int ny = y + jdy[i];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0){
                            if(!visited[nx][ny][1]){
                                visited[nx][ny][1] = true;
                                queue.offer(new int[]{nx, ny, 1, dist + 1});
                            }
                        }
                    }

                }

            }

            return answer;
        }
    }





}
