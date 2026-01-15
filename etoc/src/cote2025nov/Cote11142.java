package cote2025nov;

import java.util.*;

public class Cote11142 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        int answer = 1;

        // arr 배열 초기화
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        // dp 배열 초기화
        int[] dp = new int[N];
        //dp[i] 정의 : arr[i] 를 가장 마지막 수로 하는 증가 수열의 최대길이
        dp[0] = 1;

        for (int i = 1; i < N; i++){
            int max = 0;
            for (int j = i - 1; j >=0; j--){
                if (arr[j] < arr[i] && dp[j] > max){
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            answer = Math.max(dp[i], answer);
        }

        System.out.print(answer);
    }
}
