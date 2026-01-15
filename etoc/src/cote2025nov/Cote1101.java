package cote2025nov;

import java.util.*;

public class Cote1101 {
    class Solution {

        public boolean BFS(int start, int[][] friends, int[] color){
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(start);
            color[start] = 0; //처음엔 홍팀배정

            while(!queue.isEmpty()){
                int cur = queue.poll();
                for (int next : friends[cur]){
                    // 같은 팀 소속이면 바로 false 반환. 이분그래프가 아님.
                    if (color[cur] == color[next]){
                        return false;
                    }
                    // 아직 방문하지 않은 경우(팀 배정 안된 경우)
                    if (color[next] == -1){
                        queue.offer(next);
                        color[next] = 1 - color[cur]; // 다른 팀으로 배정하기
                    }
                }
            }

            return true;
        }


        public boolean solution(int[][] friends) {
            boolean answer = true;

            int n = friends.length; // 노드개수
            int[] color = new int[n];
            Arrays.fill(color, -1);

            for (int i = 0; i < n; i++){
                if (color[i] == -1){ // 방문하지 않았으면
                    if(!BFS(i, friends, color)){
                        return false;
                    }
                }
            }


            return answer;
        }
    }
    public static void main(String[] args) {

    }
}
