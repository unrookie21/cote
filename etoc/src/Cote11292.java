import java.util.*;

public class Cote11292 {

    class Solution {

        public int answer = 0;

        public int solution(int n, int[][] results) {
            boolean[][] win = new boolean[n+1][n+1];


            for (int[] result : results){
                int winner = result[0];
                int loser = result[1];

                win[winner][loser] = true;
            }

            // 만약, (i > k) 이고 (k > j) 이면 win[i][j] 또한 true 가 되어야한다.
            // k 를 경유하는 (i,j) 쌍을 체크
            for (int k = 1; k <= n ;k++){
                for (int i = 1; i <=n; i ++){
                    for (int j = 1; j<=n; j++){
                        if (win[i][k] && win[k][j]) win[i][j] = true;
                    }
                }
            }

            // 전이 상태까지 입력완료햇으면, 이제 1번~n번 선수에 대해 조건 검사
            // 정확하게 순위를 매길 수 있는 조건 == (나를 이긴 놈의 수) + (나한테 진놈의 수 ) == n - 1

            for (int i = 1; i <=n; i++){
                int count = 0;
                for (int j = 1; j <= n; j++){
                    if (i == j) continue;

                    if (win[i][j] || win[j][i]) count++;
                }

                if (count == n-1) answer++;

            }

            return answer;
        }
    }
}
