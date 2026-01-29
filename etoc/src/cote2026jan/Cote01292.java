package cote2026jan;
import java.util.*;
public class Cote01292 {

    static class Solution {

        public class Node implements Comparable<Node>{

            public int node;
            public int fare;

            public Node(int n, int f){
                this.node = n;
                this.fare = f;
            }

            @Override
            public int compareTo(Node other){
                return this.fare - other.fare;
            }
        }

        public int[] dijkstra(int n, int s, int[][] fares){

            List<List<Node>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++){
                graph.add(new ArrayList<>());
            }

            for (int[] fare : fares){
                graph.get(fare[0]).add(new Node(fare[1], fare[2]));
                graph.get(fare[1]).add(new Node(fare[0], fare[2]));
            }

            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            Queue<Node> pq = new PriorityQueue<>();

            // 시작점 처리
            dist[s] = 0;
            pq.offer(new Node(s, 0));

            while(!pq.isEmpty()){

                Node cur = pq.poll();

                if (cur.fare > dist[cur.node]){
                    continue;
                }

                for (Node next : graph.get(cur.node)){
                    int newFare = cur.fare + next.fare;

                    if (newFare < dist[next.node]){
                        dist[next.node] = newFare;
                        pq.offer(new Node(next.node, newFare));
                    }
                }
            }

            return dist;
        }
        public int solution(int n, int s, int a, int b, int[][] fares) {
            // n : 지점 개수
            // s : 출발지점
            // a : A 의 도착지점
            // b : B 의 도착지점

            int[] distS = dijkstra(n, s, fares);
            int[] distA = dijkstra(n, a, fares);
            int[] distB = dijkstra(n, b, fares);

            // totalCost = cost(S->X) + cost(A -> X) + cost(B -> X)
            // == cost(X-> S) + cost(X->A) + cost(X->B)

            int totalCost = Integer.MAX_VALUE;

            for (int i = 1; i <= n; i++){
                int cost = distS[i] + distA[i] + distB[i];
                totalCost = Math.min(totalCost, cost);
            }

            return totalCost;
        }
    }
}
