import java.util.*;

public class Cote11141 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N+2];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N+1; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        System.out.print(dp[N+1]);
    }
}
