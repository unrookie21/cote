package cote2026jan;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Cote01211 {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    static int minTime = Integer.MAX_VALUE;

    static int N; // 연구소 크기
    static int M; // 놓을 수 있는 바이러스의 개수

    static int[][] grid; // 연구소

    public static int[][] copyGrid(){
        int[][] newGrid = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newGrid[i][j] = grid[i][j];
            }
        }
        return newGrid;
    }

    public static void bfs(){

        // 일단, grid 부터 복사해서 가져오자.
        int[][] factory = copyGrid();

        // distance 배열 생성
        int[][] distance = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i] , -1);
        }

        Queue<int[]> queue = new ArrayDeque<>();

        // factory(연구소) 에서, 원소가 3 인 것4들을 찾아서 큐에 한번에 집어넣는다.
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                if (factory[i][j] == 3){
                    queue.offer(new int[]{i,j});
                    distance[i][j] = 0;
                }
            }
        }

        // 시작점 처리 완료함.
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {

                    // 0은 빈칸, 2는 비활성 바이러스 -> 얘네는 전파 가능
                    if (factory[nx][ny] == 0 ||  factory[nx][ny] == 2){
                        if (distance[nx][ny] == -1){
                            queue.offer(new int[]{nx ,ny});
                            distance[nx][ny] = distance[x][y] + 1;
                        }

                    }
                }
            }
        }


        int maxTime = 0;
        // factory 에서 값이 가장 큰 원소가 정답
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 0 은 빈칸
                if (factory[i][j] == 0 && distance[i][j] == -1){ // 바이러스 전염이 실패했다는 것
                    return;
                }
                if (factory[i][j] == 0){
                    maxTime = Math.max(maxTime, distance[i][j]);
                }

            }
        }

        minTime = Math.min(maxTime, minTime);
    }

    // 첫째 줄에 연구소의 크기 N(4 ≤ N ≤ 50), 놓을 수 있는 바이러스의 개수 M(1 ≤ M ≤ 10)이 주어진다.
    // 연구소의 모든 빈 칸에 바이러스가 있게 되는 최소 시간을 출력한다.
    // 바이러스를 어떻게 놓아도 모든 빈 칸에 바이러스를 퍼뜨릴 수 없는 경우에는 -1을 출력한다.

    public static void dfs(int start, int count) {
        if (count == M){ // 바이러스 M개를 활성 바이러스로 변경 완료한 상태
            // bfs 로 바이러스 모두 퍼뜨리고, 최소 시간을 갱신한다.
            bfs();
            // 마지막에 return
            return;
        }

        // 조합 계산
        for (int i = start; i < N * N; i++){
            // 일단 2차원 배열을 1차원 배열처럼 생각할거니까, 인덱스 변환부터하자.
            int x = i / N;
            int y = i % N;

            if (grid[x][y] == 2){ // 바이러스를
                grid[x][y] = 3; // 활성바이러스로 바꾸고
                dfs(i + 1, count + 1);
                // backtracking
                grid[x][y] = 2; // 돌아와서 다시 바이러스로 바꾼다.
            }
        }
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        grid = new int[N][N];

        // grid 초기화 완료
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] =  sc.nextInt();
            }
        }

        dfs(0, 0);

        if (minTime == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(minTime);
        }

    }
}
