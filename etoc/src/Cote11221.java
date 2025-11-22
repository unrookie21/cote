import java.util.*;

public class Cote11221 {

    class Solution {

        public int answer = 0;

        public void DFS(int start, int[] numbers, int target, int sum){
            // 종료 조건
            if (start == numbers.length){
                if (sum == target) answer ++;
                return;
            }
            DFS(start + 1, numbers, target, sum + numbers[start]);
            DFS(start + 1, numbers, target, sum - numbers[start]);

        }
        public int solution(int[] numbers, int target) {

            DFS(0, numbers, target, 0);
            return answer;

        }
    }
}
