package cote2026jan;

import java.util.*;
public class Cote01162 {

    static class Solution {

        public int bfs(int start, int[] coins, int amount){

            // int[0] = 현재 amount , int[1] = 현재 코인 개수
            Queue<int[]> q = new ArrayDeque<>();
            boolean[] visited = new boolean[amount+1];

            q.offer(new int[]{start, 0});
            visited[start] = true;

            while(!q.isEmpty()){

                int[] item = q.poll();
                int curAmount = item[0];
                int count = item[1];

                // 현재 amount 와 amount 가 같으면 현재 코인 개수 return
                if (curAmount == amount){
                    return count;
                }

                // coins length 만큼 순회하면서 탐색 뻗어나간다.
                for (int i = 0; i < coins.length; i++){
                    int nextAmount = curAmount + coins[i];
                    if (nextAmount >= 0 && nextAmount <= amount && !visited[nextAmount]){
                        visited[nextAmount] = true;
                        q.offer(new int[]{nextAmount , count + 1});
                    }
                }
            }
            // 탐색 끝난 지점. 정답을 못 찾았으므로.
            return -1;
        }


        public int coinChange(int[] coins, int amount) {

            return bfs(0, coins, amount);
        }
    }
}
