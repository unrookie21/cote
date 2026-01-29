package cote2026jan;

import java.util.List;
import java.util.PriorityQueue;

public class cote01281 {

    static class Solution{

        public int[] smallestRange(List<List<Integer>> nums) {

            int k = nums.size();

            // PQ 에는 {값, 리스트의 인덱스, 원소의 인덱스를 집어넣자.{
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

            int maxVal = Integer.MIN_VALUE;

            // 각 리스트의 첫번ㅇ째 원소를 힙에 삽입하자

            for (int i = 0; i < k; i++) {
                pq.offer(new int[]{nums.get(i).get(0), i, 0});
                maxVal = Math.max(maxVal, nums.get(i).get(0));
            }

            int[] answer = {pq.peek()[0] , maxVal};

            while (true) {
                int[] min = pq.poll();
                int minVal = min[0];
                int listIdx = min[1];
                int elemIdx = min[2];

                // 다음 원소가 없으면 종료한다.
                if (elemIdx + 1 == nums.get(listIdx).size()){
                    break;
                }

                // 힙에 넣기
                int nextVal = nums.get(listIdx).get(elemIdx + 1);
                pq.offer(new int[]{nextVal, listIdx, elemIdx + 1});
                maxVal = Math.max(maxVal, nextVal);

                // 범위 갱신
                int curMin = pq.peek()[0];
                if (maxVal - curMin < answer[1] - answer[0]) {
                    answer = new int[]{curMin, maxVal};
                }

            }

            return answer;
        }



    }
}
