package cote2026jan;

import java.util.*;
public class Cote01261 {

    class Solution {

        class Node implements Comparable<Node>{

            public int node; // 노드 번호
            public int cost; // 간선의 비용

            public Node(int node, int cost){
                this.node = node;
                this.cost = cost;
            }

            @Override
            public int compareTo(Node other){
                return this.cost - other.cost;
            }
        }

        public List<List<Node>> convertToGraph(int n, int[][] edges){
            // 인접리스트로 변환하자.
            List<List<Node>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++){
                graph.add(new ArrayList<>());
            }

            for (int[] edge : edges){
                graph.get(edge[0]).add(new Node(edge[1], edge[2]));
            }

            return graph;
        }

        public int dijkstra(int start, int n, int[][] edges){


            List<List<Node>> graph = convertToGraph(n, edges);

            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;

            // graph 초기화 완료.
            Queue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(start, 0));

            while(!pq.isEmpty()){

                Node cur = pq.poll();

                if (cur.cost > dist[cur.node]){
                    continue;
                }

                for (Node next : graph.get(cur.node)){

                    int newCost = cur.cost + next.cost;
                    if (newCost < dist[next.node]){
                        dist[next.node] = newCost;
                        pq.offer(new Node(next.node, newCost));
                    }
                }
            }

            int answer = Integer.MIN_VALUE;

            for (int i = 1; i <= n; i++){

                if (dist[i] == Integer.MAX_VALUE){
                    answer = -1;
                    break;
                }

                answer = Math.max(answer, dist[i]);
            }

            return answer;
        }


        public int networkDelayTime(int[][] times, int n, int k) {
            return dijkstra(k, n, times);
        }
    }


}
