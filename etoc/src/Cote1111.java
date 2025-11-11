import java.util.*;
import java.io.*;

public class Cote1111 {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static int BFS(int[][] board,int N, int M){

        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        int maxDay = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int day = cur[2];

            maxDay = Math.max(maxDay, day);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (board[nx][ny] == 0) {
                        queue.offer(new int[]{nx, ny, day+1});
                        board[nx][ny] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    return -1;
                }
            }
        }

        return maxDay;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]); // 열
        int N = Integer.parseInt(input[1]); // 행

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
        System.out.print(BFS(board, N, M));

    }
}
