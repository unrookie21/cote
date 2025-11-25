import java.util.*;

public class Cote11251 {
    class Solution {

        int maxCountries;


        public int solution(int balance, int[][] countries) {

            int n = countries.length;
            boolean[] visited = new boolean[n];

            maxCountries = 0;
            DFS(balance, 0, countries, visited);

            return maxCountries;

        }

        public void DFS(int balance, int count, int[][] countries, boolean[] visited){

            // 최대 국가 수 갱신
            maxCountries = Math.max(maxCountries, count);

            // 방문하지 않은 국가이고, balance 가 여행경비보다 큰 경우, 탐색 진행한다.
            for (int i = 0; i < countries.length; i++){
                if (!visited[i] && balance >= countries[i][1]){ // 최소 잔고보다 크거나 같아야 입국 가능
                    visited[i] = true;
                    DFS(balance - countries[i][0], count + 1, countries, visited);
                    // 탐색하고 돌아오면 방문 해제
                    visited[i] = false;
                }
            }


        }
    }
}
