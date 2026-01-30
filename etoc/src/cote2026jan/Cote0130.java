package cote2026jan;

import java.util.*;
public class Cote0130 {

    static class Solution {

        // 위상정렬 문제
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            // prerequisites 를 graph 로 변환하기
            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i < numCourses; i++){
                graph.add(new ArrayList<>());
            }

            // indegree 배열 초기화.
            int[] indegree = new int[numCourses];


            int[] order = new int[numCourses];
            int count = 0;

            for (int[] edge : prerequisites){
                // edge[1] - > edge[0]
                graph.get(edge[1]).add(edge[0]);
                indegree[edge[0]]++;
            }


            Queue<Integer> queue = new ArrayDeque<>();

            // indegree 가 0인 노드를 큐에 넣자.
            for (int i = 0; i < numCourses; i++){
                if (indegree[i] == 0){
                    queue.offer(i);
                    order[count++] = i;
                }
            }

            while(!queue.isEmpty()){

                int cur = queue.poll();

                for (int next : graph.get(cur)){

                    // next 의 indegree 를 1씩 감소시킨다.
                    indegree[next]--;
                    if (indegree[next] == 0){
                        queue.offer(next);
                        order[count++] = next;
                    }
                }
            }


            int zeroCount = 0;
            // 모든 코스를 끝내는게 불가능할 경우 빈배열 반환
            for (int i = 0 ; i < numCourses; i++){
                if (order[i] == 0){
                    zeroCount++;
                    if (zeroCount >= 2){
                        return new int[]{};
                    }
                }

            }
            return order;

        }
    }
}
