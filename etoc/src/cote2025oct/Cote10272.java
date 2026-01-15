package cote2025oct;

import java.util.*;

public class Cote10272 {

    class Solution {
        public int solution(int[] prices, int target) {
            int answer = 0;
            int n = prices.length;

            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < n; i++){
                if (set.contains(target - prices[i])){
                    answer++;
                } else{
                    set.add(prices[i]);
                }
            }
            return answer;
        }
    }
}
