package cote2025oct;

import java.util.*;

public class Cote10282 {

    class Solution {

        static class Point{
            private int x;
            private int y;
            public Point(int x, int y){
                this.x = x;
                this.y = y;
            }
        }

        static int[] dx = {1,0,-1,0};
        static int[] dy = {0,-1,0,1};
        static int m,n;

        static void BFS(int x, int y , int[][] sky){
            Deque<Point> queue = new ArrayDeque<>();
            queue.offer(new Point(x,y));
            while(!queue.isEmpty()){
                Point point = queue.poll();
                for (int i = 0; i< 4; i++){
                    int nx = point.x + dx[i];
                    int ny = point.y + dy[i];
                    if (nx >=0 && nx < m && ny >=0 && ny < n && sky[nx][ny] == 1){
                        sky[nx][ny] = 0;
                        queue.offer(new Point(nx,ny));
                    }
                }
            }





        }
        public static int solution(int[][] sky) {
            int answer = 0;

            m = sky.length;
            n = sky[0].length;

            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (sky[i][j] == 1){
                        answer++;
                        sky[i][j] = 0;
                        BFS(i,j, sky);
                    }

                }

            }
            return answer;
        }
    }
    public static void main(String[] args) {

    }
}
