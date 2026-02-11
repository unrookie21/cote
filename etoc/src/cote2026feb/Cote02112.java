package cote2026feb;

import java.util.*;
public class Cote02112 {

    class BottomUp {
        public int rob(int[] nums) {


            // bottom-up

            int n = nums.length;
            if (n == 1) return nums[0];

            int[] dp = new int[n];
            // dp[i] : i 번째 집을 털때까지의 돈의 최댓값
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < n; i++){
                dp[i] = Math.max(dp[i-1] , dp[i-2] + nums[i]);
            }

            return dp[n-1];



        }
    }

    class TopDown {

        public static final int NONE = Integer.MAX_VALUE;

        public int rob(int[] nums) {

            int[] memo = new int[nums.length];
            Arrays.fill(memo, NONE);

            return dp(memo, nums, nums.length - 1);

        }

        public int dp(int[] memo, int[] nums, int n){

            if (n == 0) return nums[0];

            if (n == 1) return Math.max(nums[0], nums[1]);

            if (memo[n] == NONE){
                memo[n] = Math.max(dp(memo, nums, n-1), dp(memo, nums , n-2) + nums[n]);
            }

            return memo[n];


        }
    }

}
