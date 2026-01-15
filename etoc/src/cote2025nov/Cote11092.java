package cote2025nov;

import java.util.*;

public class Cote11092 {
    class Solution {

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        public int solution(String[] board) {
            int answer = -1;

            int m = board.length;
            int n = board[0].length();

            int startX = 0; int startY = 0;
            int goalX = 0; int goalY = 0;

            int[][] distance = new int[m][n];
            for (int[] arr : distance){
                Arrays.fill(arr, -1);
            }

            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (board[i].charAt(j) == 'R'){
                        startX = i;
                        startY = j;
                    }
                    if (board[i].charAt(j) == 'G'){
                        goalX = i;
                        goalY = j;
                    }
                }
            }

            Deque<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{startX, startY});
            distance[startX][startY] = 0;

            while(!q.isEmpty()){
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                if (x == goalX && y == goalY){
                    return distance[x][y];
                }

                for (int i = 0; i < 4; i++){
                    int nx = x;
                    int ny = y;

                    // 벽이나, 장애물 만날때까지 한방향으로 미끄러져야한다.
                    while(true){
                        int newX = nx + dx[i];
                        int newY = ny + dy[i];

                        // 벽까지 미끄러져서 도착한 경우, while 문 탈출
                        if (newX < 0 || newX >= m || newY < 0 || newY >= n){
                            break;
                        }
                        // 장애물까지 미끄러져서 도착한 경우, while 문 탈출
                        if (board[newX].charAt(newY) == 'D'){
                            break;
                        }

                        nx = newX;
                        ny = newY;
                    }

                    if (distance[nx][ny] == -1){
                        distance[nx][ny] = distance[x][y] + 1;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }

            return answer;
        }
    }
}
