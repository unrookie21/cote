package cote2026feb;

public class Cote02121 {

    class Solution {
        // 1130
        public int maxSubArray(int[] nums) {

            int[] dp = new int[nums.length];
            // dp[i] : i 번째 위치까지 subarray 의 합의 최댓값
            dp[0] = nums[0];

            for (int i = 1; i < nums.length; i++){
                dp[i] = Math.max(nums[i] , dp[i-1] + nums[i]);
            }

            int maxVal = Integer.MIN_VALUE;

            for (int num : dp){
                maxVal = Math.max(maxVal, num);
            }

            return maxVal;

        }
    }
}
