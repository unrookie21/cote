import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cote10281 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){

            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[41];
            dp[0] = 0;
            dp[1] = 1;
            // dp 기본 새팅

            // 0출력 횟수를 담는 배열
            int [] zero = new int[41];
            zero[0] = 1;
            zero[1] = 0;

            // 1출력 횟수 담는 배열
            int [] one = new int[41];
            one[0] = 0;
            one[1] = 1;

            //dp table 계산
            for (int j = 2; j <= N; j++){
                dp[j] = dp[j-1] + dp[j-2];
                // one , zero 의 원소 또한 dp 배열의 양상과 동일하다.
                one[j] = one[j-1] + one[j-2];
                zero[j] = zero[j-1] + zero[j-2];
            }


            System.out.println(zero[N] + " " + one[N]);
        }
    }
}
