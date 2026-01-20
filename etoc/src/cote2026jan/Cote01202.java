package cote2026jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Cote01202 {

    static int N; // 행
    static int M; // 열

    static int[][] grid;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    static int maxCount = Integer.MIN_VALUE;

    public static void bfs(){

        int[][] tempGrid = copyGrid();
        // 모든 바이러스 위치를 큐에넣고, 동시에 전염시킨다.

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0 ; i < N; i++){
            for (int j = 0; j < M; j++){
                if (tempGrid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){

            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 0 이면 확산 가능
                if (nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if (tempGrid[nx][ny] == 0){
                        tempGrid[nx][ny] = 2;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
        }

        int zeroCount = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (tempGrid[i][j] == 0) zeroCount++;
            }
        }
        maxCount = Math.max(zeroCount, maxCount);
    }

    private static int[][] copyGrid() {
        int[][] copyGrid = new int[N][M];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                copyGrid[i][j] = grid[i][j];
            }
        }
        return copyGrid;
    }

    public static void dfs(int start, int count){
        // count == 3 이 되면 탐색 종료
        if (count == 3){
            // 벽을 3개 다 만들었으면...
            bfs(); // 확산
            return;
        }

        for (int i = start; i < N * M; i++){

            int x = i / M;
            int y = i % M;

            // 0이면 벽 세우기
            if (grid[x][y] == 0){
                grid[x][y] = 1;
                dfs(i + 1, count + 1);
                grid[x][y] = 0;
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        // grid 안에서 백 트래킹하면서 벽 3개를 세운다.

        System.out.println(maxCount);
    }
}