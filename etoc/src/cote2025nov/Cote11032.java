package cote2025nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Cote11032 {

    public static int solution(int[] coins, int[] dp, int k){

        for (int i = 1; i <=k ; i++){
            for (int coin : coins){
                if (i - coin >=0 && dp[i-coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        return dp[k] == Integer.MAX_VALUE ? -1 : dp[k];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        int[] dp = new int[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int[] coins = new int[n];
        for (int i = 0; i < n; i++){
            int element = Integer.parseInt(br.readLine());
            coins[i] = element;
        }

        System.out.print(solution(coins, dp, k));
    }
}
