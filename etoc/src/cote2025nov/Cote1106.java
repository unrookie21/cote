package cote2025nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.*;

public class Cote1106 {

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static int BFS(int[][] grid, int[][] distance, int N, int M){
        Deque<int[]> q = new ArrayDeque<>();
        distance[0][0] = 1;
        q.offer(new int[]{0,0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            if (r == N-1 && c == M-1){
                return distance[r][c];
            }
            for (int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < N && nc >=0 && nc < M && grid[nr][nc] == 1){
                    if (distance[nr][nc] == -1){
                        distance[nr][nc] = distance[r][c] + 1;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);

        int[][] grid = new int[N][M];
        int[][] distance = new int[N][M];
        for (int[] row : distance){
            Arrays.fill(row, -1);
        }

        //배열 초기화
        for (int i = 0; i < N; i++){
            String line = br.readLine();
            for (int j = 0; j < M; j++){
                grid[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.print(BFS(grid, distance, N, M));
    }
}
