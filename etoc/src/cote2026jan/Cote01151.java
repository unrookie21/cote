package cote2026jan;
import java.util.*;
public class Cote01151 {


    static class Solution {
        public int solution(int[] queue1, int[] queue2) {
            int answer = 0;


            Queue<Integer> q1 = new ArrayDeque<>();
            Queue<Integer> q2 = new ArrayDeque<>();


            long totalSum = 0; // 30
            long q1Sum = 0;
            long q2Sum = 0;

            for (int q1Num : queue1){
                totalSum += q1Num;
                q1.offer(q1Num);
                q1Sum += q1Num;

            }
            for (int q2Num : queue2){
                totalSum += q2Num;
                q2.offer(q2Num);
                q2Sum += q2Num;
            }

            // q1 ,q2 모두 완성된 상태

            if (totalSum % 2 != 0 ) return -1; // 홀수면 불가능하므로 ret -1

            long qSum = totalSum / 2; // 각 큐의 합을 qSum 과 같게 만들어야한다.

            int n = queue1.length;


            int count = 0;
            while(count < 4 * n){

                // 합이 큰 큐가, 합이 작은 큐에 insert
                if (q1Sum > q2Sum){ // q1 -> q2 insert
                    int item1 = q1.poll();
                    q2.offer(item1);
                    count++;
                    q1Sum -= item1;
                    q2Sum += item1;
                } else if (q2Sum > q1Sum){
                    int item2 = q2.poll();
                    q1.offer(item2);
                    count++;
                    q2Sum -= item2;
                    q1Sum += item2;
                } else { // q1Sum == q2Sum
                    return count;
                }

            }

            //empty 가 되어버려서 while 문 나온경ㅇ우
            return -1;
        }
    }
}
