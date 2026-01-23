package cote2026jan;

import java.util.*;
public class Cote01231 {

    static class Solution {

        public int solution(int[][] board) {
            int N = board.length;

            Queue<int[]> queue = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();

            queue.add(new int[]{0, 0, 0, 1, 0});
            visited.add("0,0,0,1");

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int x1 = cur[0], y1 = cur[1];
                int x2 = cur[2], y2 = cur[3];
                int time = cur[4];

                if ((x1 == N-1 && y1 == N-1) || (x2 == N-1 && y2 == N-1)){
                    return time;
                }

                // 1. 이동
                for (int i = 0; i < 4; i++){
                    int nx1 = x1 + dx[i], ny1 = y1 + dy[i];
                    int nx2 = x2 + dx[i], ny2 = y2 + dy[i];

                    if (isRangeValid(nx1, ny1, nx2, ny2, N, board)){
                        String state = nx1 + "," + ny1 + "," + nx2 + "," + ny2;
                        if (!visited.contains(state)){
                            queue.offer(new int[]{nx1, ny1, nx2, ny2, time + 1});
                            visited.add(state);
                        }
                    }
                }

                // 로봇이 가로 상태일때
                if (x1 == x2){

                    for (int i : new int[]{-1 , 1}){
                        // i 는 -1 - > 1
                        // i 를 논리적인 축의 의미로 해석해보자.
                        // 대각선 위치 + 나머지 이동 위치 검증
                        // i == -1 일때
                        if(isRangeValid(x1 + i, y1, x2 + i , y2, N, board)){
                            // 상태추가할때는, 축 정보 먼저, 이동 위치 나중에
                            addRotation(x2, y2, x2 + i , y2, queue, visited, time);
                            addRotation(x1, y1, x1 + i , y1, queue, visited, time);
                        }
                    }
                } else if (y1 == y2){ // 로봇이 세로 상태일때

                    for (int i : new int[]{-1, 1}){
                        if(isRangeValid(x1 , y1 + i, x2, y2 + i, N, board)){
                            addRotation(x1, y1, x1, y1 + i, queue, visited, time);
                            addRotation(x2, y2, x2, y2 + i, queue, visited, time);
                        }

                    }
                }
            }

            return -1;
        }

        private boolean isRangeValid(int x1, int y1, int x2, int y2, int N, int[][] board) {
            return x1 >= 0 && x1 < N && x2 >= 0 && x2 < N &&
                    y1 >= 0 && y1 < N && y2 >= 0 && y2 < N &&
                    board[x1][y1] == 0 && board[x2][y2] == 0;
        }

        private void addRotation(int x1, int y1, int x2, int y2,
                                 Queue<int[]> queue, Set<String> visited, int time) {
            String state = x1 + "," + y1 + "," + x2 + "," + y2;
            if (!visited.contains(state)){
                queue.offer(new int[]{x1, y1, x2, y2, time + 1});
                visited.add(state);
            }
        }
    }
}
