package cote2026jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cote011222 {

    static int N, M;
    static int fuel; // 연료

    static int grid[][];

    static int taxiX, taxiY;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0 ,0 ,-1 ,1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        taxiX = Integer.parseInt(st.nextToken()) - 1;
        taxiY = Integer.parseInt(st.nextToken()) - 1;

        // 출발지 행, 열 , 목적지 행 , 열
        Map<Integer, int[]> passengerInfo = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] info = new int[4];
            for (int j = 0; j < 4; j++) {
                info[j] = Integer.parseInt(st.nextToken()) -1;
            }
            passengerInfo.put(i, info);
        }
        // 승객의 출발지, 목적지 정보 저장 완료

        // 승객을 태워서 목적지로 이동시키는 일을 M번 반복해야한다.
        for (int i = 0; i < M; i++) {

            // 태울 승객부터 먼저 선태해야한다. (최단거리에 있는 승객을 선택)
            int passengerNum = choosePassenger(passengerInfo);

            if (passengerNum == -1) {
                System.out.println(-1);
                return;
            }

            int[] info = passengerInfo.get(passengerNum);
            // 승객을 정상적으로 태운경우.. taxi 좌표도 업데이트해야한다.
            taxiX = info[0];
            taxiY = info[1];

            // 이제 승객을 도착지로 태워주자.
            boolean moveSuccess = movePassenger(info[2], info[3]);
            if (!moveSuccess){
                System.out.println(-1);
                return;
            }

            // 승객을 내려주는데 성공. 연료 빼고, 연로 채워야함.
            // 택시 좌표 업데이트
            taxiX = info[2];
            taxiY = info[3];

            // 승객을 내려주는데 성공했으면, passengerInfo 에서 승객 삭제
            passengerInfo.remove(passengerNum);


        }
        System.out.println(fuel);
    }

    // 선택된 승객의 번호를 반환
    public static int choosePassenger(Map<Integer, int[]> passengerInfo) {

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], -1);
        }

        queue.offer(new int[]{taxiX, taxiY, 0});
        distance[taxiX][taxiY] = 0;

        int minDistance = Integer.MAX_VALUE;
        List<int[]> candidates = new ArrayList<>();

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            if (distance[x][y] > minDistance){
                break;
            }

            // 현재 위치에, 승객이 있는지 확인한다.
            for (Map.Entry<Integer, int[]> entry : passengerInfo.entrySet()) {
                int key = entry.getKey();
                int[] info = entry.getValue(); // info[0] : 출발지 행 info[1] : 출발지 열

                if (x == info[0] && y == info[1]){
                    // 최단거리를 갱신해야겠지.
                    if (distance[x][y] < minDistance) {
                        minDistance = distance[x][y];
                        candidates.clear();
                        candidates.add(new int[]{key, info[0], info[1]});
                    } else if (distance[x][y] == minDistance){
                        candidates.add(new int[]{key, info[0], info[1]});
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && grid[nx][ny] == 0) {
                    if (distance[nx][ny] == -1) {
                        distance[nx][ny] = distance[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        if (candidates.isEmpty() || minDistance > fuel){
            return -1;
        }

        // 연료 감소
        fuel -= minDistance;

        // candidates 를 정렬 (행 기준 오름차순으로 먼저 정렬, 행이 같으면 열 기준 오름 차순 정렬)
        candidates.sort((a,b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        // 정렬 완료. 맨 처음 원소가 선택된 승객임.
        return candidates.get(0)[0];
    }

    public static boolean movePassenger(int endX, int endY) {

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], - 1);
        }

        queue.offer(new int[]{taxiX, taxiY});
        distance[taxiX][taxiY] = 0;

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            // 도착점에 도달
            if (x == endX && y == endY){
                int movedDistance = distance[x][y];

                if (movedDistance > fuel){
                    return false;
                }

                fuel -= movedDistance;
                fuel += movedDistance * 2;

                return true;
            }

            // 도착점에 도달하지 않았으면 계속 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && grid[nx][ny] == 0) {
                    if (distance[nx][ny] == -1){
                        distance[nx][ny] = distance[x][y] + 1;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        return false;
    }
}

