package cote2025nov;

import java.util.*;

public class Cote11211 {

    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙 생성
            for (int scovilleElement : scoville){
                pq.offer(scovilleElement);
            }
            // 우선순위 큐에서 가장 작은 값이 K 보다 작은동안 계속 반복
            // 근데 하나만 남아있을 수도 있음.
            while(pq.peek() < K){

                if (pq.size() >= 2){
                    int min1 = pq.poll();
                    int min2 = pq.poll();

                    int newScovill = min1 + min2 * 2;
                    pq.offer(newScovill);

                    answer++;
                } else {
                    return -1;
                }
            }
            // 가장 작은 값이 K보다 크거나 같아지는 순간
            return answer;
        }
    }
}
