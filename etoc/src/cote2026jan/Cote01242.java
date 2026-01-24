package cote2026jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Cote01242 {

    static int N, M;
    static int[][] grid;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        int answer = -1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2];

        // 시작점 처리
        queue.add(new int[]{0 , 0 , 0, 1});
        visited[0][0][0] = true;

        while(!queue.isEmpty()){

            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int broken = cur[2];
            int dist = cur[3];

            // 도착점 도달시, ret dist
            if (x == N -1  && y == M - 1){
                System.out.println(dist);
                return;
            }

            // 다음칸이 빈칸이면 일반 이동
            for (int i = 0; i < 4; i++){

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if (grid[nx][ny] == 0){
                        if(!visited[nx][ny][broken]){
                            queue.offer(new int[]{nx,ny, broken, dist + 1});
                            visited[nx][ny][broken] = true;
                        }

                    } else {
                        if(broken == 0 && !visited[nx][ny][broken]) {
                            queue.offer(new int[]{nx, ny, 1, dist + 1});
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }

        System.out.println(answer);

    }
}
