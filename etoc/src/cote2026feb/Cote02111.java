package cote2026feb;

import java.util.*;
public class Cote02111 {

    class BottomUp{

        public Map<Integer, Integer> memo = new HashMap<>();
        private int[] coins;

        public int coinChange(int[] coins, int amount) {
            this.coins = coins;
            return dp(amount);
        }

        public int dp(int curAmount){

            if (curAmount == 0) return 0;
            if (memo.containsKey(curAmount)) return memo.get(curAmount);

            int result = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (curAmount - coin >= 0){
                    int temp = dp(curAmount - coin);
                    if (temp != -1) {
                        result = Math.min(result, temp + 1);
                    }
                }
            }

            int finalResult = (result == Integer.MAX_VALUE) ? -1 : result;
            memo.put(curAmount,finalResult);
            return finalResult;
        }


    }

    class TopDown {
        public Map<Integer, Integer> memo = new HashMap<>();
        private int[] coins;

        public int coinChange(int[] coins, int amount) {
            this.coins = coins;
            return dp(amount);
        }

        public int dp(int curAmount){

            if (curAmount == 0) return 0;
            if (memo.containsKey(curAmount)) return memo.get(curAmount);

            int result = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (curAmount - coin >= 0){
                    int temp = dp(curAmount - coin);
                    if (temp != -1) {
                        result = Math.min(result, temp + 1);
                    }
                }
            }

            int finalResult = (result == Integer.MAX_VALUE) ? -1 : result;
            memo.put(curAmount,finalResult);
            return finalResult;
        }

    }
}
