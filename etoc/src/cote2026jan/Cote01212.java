package cote2026jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cote01212 {

    static int n;
    static int m;

    static char[][] board;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        // 좌측부터 빨간공의 x 좌표, y좌표 , 파란공의 x 좌표, y좌표
        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R'){
                    rx = i;
                    ry = j;
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
                // 이제, 초기 상태의 빨간공 및 파란공의 x 좌표 y 좌표 설정이 완료됨.
                // board 배열도 초기화 완료.
            }
        }

        // 큐에는, 빨간공, 파란공의 x, y 좌표를 한 번에 저장
        Queue<int[]> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        // 시작지점 처리
        queue.offer(new int[]{rx, ry , bx, by, 0});
        visited.add(rx + "," + ry + "," + bx + "," + by);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            // cur[0] : rx , cur[1] : ry , cur[2] : bx , cur[3] : by , cur[4] : 이동 횟수
            if (cur[4] >= 10) continue;

            for (int i = 0; i < 4; i++) {
                // 빨간공의 이동 후 좌표
                int[] redPosition = move(cur[0], cur[1], dx[i], dy[i]);
                // 파란공의 이동 후 좌표
                int[] bluePosition = move(cur[2], cur[3], dx[i], dy[i]);

                // 빨간공 및 파란공의 이동이 완료된 상태

                if (board[bluePosition[0]][bluePosition[1]] == 'O') continue;
                if (board[redPosition[0]][redPosition[1]] == 'O') {
                    System.out.println(1);
                    return;
                }

                // 두 공의 위치가 같은 경우
                if (redPosition[0] == bluePosition[0] && redPosition[1] == bluePosition[1]) {
                    // 더 많이 이동한 공을 한칸 땡긴다.
                    if (redPosition[2] > bluePosition[2]) {
                        //red 를 땡김
                        redPosition[0] -= dx[i];
                        redPosition[1] -= dy[i];
                    } else {
                        bluePosition[0] -= dx[i];
                        bluePosition[1] -= dy[i];
                    }

                }

                String state = redPosition[0] + "," + redPosition[1] + "," + bluePosition[0] + "," + bluePosition[1];
                if (!visited.contains(state)){
                    visited.add(state);
                    queue.offer(new int[]{redPosition[0], redPosition[1], bluePosition[0], bluePosition[1], cur[4] + 1});
                }
            }

        }

        System.out.println(0);

    }

    public static int[] move(int curX, int curY, int toMoveX, int toMoveY) {
        // 벽이나, 구멍을 만나지 않는 이상 계속 이동한다.
        int moveCount = 0;

        while (board[curX + toMoveX][curY + toMoveY] != '#' &&
                board[curX][curY] != 'O') {
            curX += toMoveX;
            curY += toMoveY;
            moveCount++;
        }

        return new int[]{curX, curY, moveCount};
    }
}
