package cote2026jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cote0122 {


    static int N;  // 격자판 N * N
    static int M;  // 태워야하는 승객수 M

    static int fuel; // 연료의 양

    static int[][] grid; // 값이 0 : 빈칸 , 값이 1 : 벽

    static int taxiX;
    static int taxiY;
    
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        grid = new int[N][N]; // 격자 초기화 완료

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        // 택시의 시작 행 번호 , 열번호
        taxiX = Integer.parseInt(st.nextToken()) -1 ;
        taxiY = Integer.parseInt(st.nextToken()) -1 ;


        // 각 승객별로 Map<Long, int[]> 에 출발지와 목적지 정보를 저장하자
        // int[0] : 출발지 행 , int[1] : 출발지 열 , int[2] : 목적지 행 , int[3] : 목적지 열

        Map<Integer, int[]> passengerInfo = new HashMap<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[4];
            for (int j = 0; j < 4; j++) {
                temp[j] = Integer.parseInt(st.nextToken()) -1 ; // 2, 2, 5, 6
            }
            passengerInfo.put(i, temp);
        }
        // 승객 정보 초기화 완료

        // 승객을 태워서 목적지로 이동시키는 일 M번 반복
        for (int i = 0; i < M; i++) {

            // 택시의 현재 위치에서, 최단거리가 가장 짧은 승객을 선택한다. bfs 로 탐색하자.
            // 승객 선택 완료
            int passengerNumber = choosePassenger(taxiX , taxiY, passengerInfo);

            if (passengerNumber == -1){
                System.out.println(-1);
                return;
            }

            // 2번 승객 선택됨.
            // 이제, 2번 승객을 태우고.. 2번 목적지까지 도착해야한다.
            int[] arrivePoint = passengerInfo.get(passengerNumber);

            // 승객위치로 택시 이동해야함.!!!!!
            taxiX = arrivePoint[0];
            taxiY = arrivePoint[1];


            boolean moveSuccess = movePassenger(arrivePoint);

            if (!moveSuccess){
                // 목적지 도달에 실패한다면(연료 부족이 이유겟지)
                System.out.println(-1);
                return;
            }

            // 목적지 도착
            taxiX = arrivePoint[2];
            taxiY = arrivePoint[3];

            // 승객을 도착지에 태우는 것에 성공하고 난 다음에는, passgengerinfo 에서 지우자
            passengerInfo.remove(passengerNumber);
        }

        System.out.println(fuel);
    }

    private static boolean movePassenger(int[] arrivePoint) {

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

            // 승객의 목적지에 도달 했다는 의미이다. 이동한 거리만큼 연료를 채워야한다.
            if (x == arrivePoint[2] && y == arrivePoint[3]){
                int movedDistance = distance[x][y];

                // 연료 부족한지 확인
                if (movedDistance > fuel) {
                    return false;
                }

                fuel -= movedDistance;
                fuel += movedDistance * 2;

                return true;
            }

            //  목적지에 도달하지 못했으면 탐색을 계속해야한다.
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && distance[nx][ny] == -1) {
                    if (grid[nx][ny] == 0) {
                        distance[nx][ny] = distance[x][y] + 1;
                        queue.offer(new int[]{nx ,ny});
                    }
                }
            }
        }
        // 목적지에 도달 못하는 경우
        return false;
    }

    private static int choosePassenger(int taxiX, int taxiY, Map<Integer,int[]> passengerInfo) {

        Queue<int[]> queue = new ArrayDeque<>();
        
        int[][] distance = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], - 1);
        }
        
        // 시작점 초기화 
        queue.offer(new int[]{taxiX, taxiY});
        distance[taxiX][taxiY] = 0;

        int minDistance = Integer.MAX_VALUE;
        List<int[]> candidates = new ArrayList<>(); // 승객번호, x좌표, y좌표


        while (!queue.isEmpty()) {
            
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            if (distance[x][y] > minDistance) {
                break;
            }

            // 현재 위치에 승객이잇는지 확인한다.
            // 승객의 최단거리를 모두 계산하고, 제일 적은 걸 선택해야하므로..
            for (Map.Entry<Integer, int[]> entry : passengerInfo.entrySet()) {
                int key = entry.getKey();
                int[] info = entry.getValue();

                if (x == info[0] && y == info[1]) {
                    if (distance[x][y] < minDistance) {
                        minDistance = distance[x][y];
                        candidates.clear();
                        candidates.add(new int[]{key, x, y});
                    } else if (distance[x][y] == minDistance){
                        candidates.add(new int[]{key,x,y});
                    }
                }

            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 경계조건 검사 및 방문 검사 
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && distance[nx][ny] == -1) {
                    if (grid[nx][ny] == 0) { // 빈칸일 때만 이동 가능하다.
                        distance[nx][ny] = distance[x][y] + 1;
                        queue.offer(new int[]{nx,ny});
                    }

                }
            }
        }

        // 승객을 찾지 못했거나.. 연료가 부족하다면...
        if (candidates.isEmpty() || minDistance > fuel){
            return -1;
        }

        fuel -= minDistance;

        // 우선순위를 정해야한다. 행 작은 순 -> 열 작은 순
        candidates.sort((a , b) -> {
            if (a[1] != b[1])return a[1] - b[1];
            return a[2] - b[2];
        });

        // 오름차수능로 정렬된 상태이므로..
        return candidates.get(0)[0];
    }
}
