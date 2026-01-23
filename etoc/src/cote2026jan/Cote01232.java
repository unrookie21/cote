package cote2026jan;
import java.util.*;

public class Cote01232 {
    static class Solution {

        public int[] dx = {1,-1,0,0};
        public int[] dy = {0,0,-1,1};

        // board : ["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"]
        public char[][] initGrid(String[] board){
            char[][] grid = new char[5][5];

            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++){
                    grid[i][j] = board[i].charAt(j);
                }
            }
            return grid;
        }

        public boolean bfs(int startX, int startY, char[][] grid){

            Queue<int[]> queue = new ArrayDeque<>();
            int[][] distance = new int[5][5];

            for (int i = 0; i < 5; i++){
                Arrays.fill(distance[i], -1);
            }

            // 시작점 처리
            queue.offer(new int[]{startX, startY});
            distance[startX][startY] = 0;

            while(!queue.isEmpty()){

                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                // 현재 상태의 거리가 2라는 것은.. 거리가 2까지 오는 동안, 다른 사람이 없었다는 거임. 그럼 더 이상 탐색
                //하는건 무의미함.
                if (distance[x][y] >= 2) return true;


                for (int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    // 다음 위치가 X 가 아니면 큐에 추가
                    if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && distance[nx][ny] == -1
                            && grid[nx][ny] != 'X'){

                        if (grid[nx][ny] == 'P') return false;

                        distance[nx][ny] = distance[x][y] + 1;
                        queue.offer(new int[]{nx,ny});

                    }
                }

            }

            return true;
        }
        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];

            for (int i = 0; i < 5; i++){

                String[] board = places[i];
                char[][] grid = initGrid(board);

                boolean escapeFlag = false;

                boolean noPeople = true;

                for (int r = 0; r < 5; r++){
                    for (int c = 0; c < 5; c++){
                        if(grid[r][c] == 'P'){
                            noPeople = false;
                            // BFS 로 탐색시작하여, 거리 2까지 탐색
                            if(!bfs(r,c, grid)){
                                answer[i] = 0;
                                escapeFlag = true;
                                break;
                            } else{
                                answer[i] = 1;
                            }

                        }
                    }
                    if (escapeFlag) break;
                }

                if (noPeople) answer[i] = 1;

            }
            return answer;
        }
    }
}
