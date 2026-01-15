package cote2025nov;

import java.util.Arrays;
import java.util.Scanner;

public class Cote1116 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] coins = new int[N];
        for (int i = 0; i < N; i++){
            coins[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int coin : coins){
                if (i - coin >= 0 && dp[i-coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        System.out.println(dp[amount]);


    }
}
