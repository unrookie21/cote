package cote2025nov;

import java.util.*;

public class Cote1102 {

    class Solution {
        public int solution(int[] coins, int amount) {
            Deque<int[]> queue = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();

            queue.offer(new int[]{amount, 0});
            visited.add(amount);

            while(!queue.isEmpty()){
                int[] current = queue.poll();
                int curAmount = current[0];
                int count = current[1];

                if (curAmount == 0) return count;

                for (int coin : coins){
                    int nextAmount = curAmount - coin;
                    if (nextAmount >= 0 && !visited.contains(nextAmount)){
                        queue.offer(new int[]{nextAmount, count + 1});
                        visited.add(nextAmount);
                    }

                }
            }

            return -1;
        }
    }
}
