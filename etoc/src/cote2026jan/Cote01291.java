package cote2026jan;
import java.util.*;

public class Cote01291 {

    static class Solution {
        // 최댓값(intensity) 를 최소화해야하는데....
        // 그럼 탐색도 비용 작은 놈을 선택하는게 유리하겟지


        public class Node implements Comparable<Node>{

            public int node;
            public int cost;

            public Node(int n, int c){
                this.node = n;
                this.cost = c;
            }

            @Override
            public int compareTo(Node other){
                return this.cost - other.cost;
            }
        }

        public int[] dijkstra(int n, int[][] paths,
                              Set<Integer> gates, Set<Integer> summits){

            List<List<Node>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++){
                graph.add(new ArrayList<>());
            }

            int[] intensity = new int[n+1];
            Arrays.fill(intensity, Integer.MAX_VALUE);


            // graph 초기화
            for (int[] path : paths){
                graph.get(path[0]).add(new Node(path[1], path[2]));
                graph.get(path[1]).add(new Node(path[0], path[2]));
            }

            Queue<Node> pq = new PriorityQueue<>();
            for (int gate : gates){
                pq.offer(new Node(gate, 0));
                intensity[gate] = 0;
            }


            while(!pq.isEmpty()){

                Node cur = pq.poll();

                if (cur.cost > intensity[cur.node]) continue;

                // 현재 위치가 산봉우리라면, 더 이상 탐색할 필요가 없다.
                if (summits.contains(cur.node)) continue;

                for (Node next : graph.get(cur.node)){

                    // 다음 노드가 출입구이면 안됨
                    if(gates.contains(next.node)) continue;

                    int newIntensity = Math.max(cur.cost, next.cost);

                    // 더 적은 intensity 로 갈수잇는지 검사
                    if (newIntensity < intensity[next.node]){
                        intensity[next.node] = newIntensity;
                        pq.offer(new Node(next.node, newIntensity));
                    }
                }
            }

            int minIntensity = Integer.MAX_VALUE;
            int sumResult = 0;

            // 이제 결과를 찾자.
            List<Integer> summitList = new ArrayList<>(summits);
            Collections.sort(summitList);

            for (int summit : summitList){
                if (intensity[summit] < minIntensity){
                    minIntensity = intensity[summit];
                    sumResult = summit;
                }
            }

            return new int[]{sumResult, minIntensity};
        }

        // n : 노드 개수, paths : 간선 정보, gates : 출입구 노드 번호, summits : 정상노드 번호
        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            int[] answer = new int[2];
            // answer[0] : intensity 가 최소가 되는 경로가 여러개라면, 낮은 산 봉우리 번호 택
            // answer[1] : 최소 intensity 값

            Set<Integer> gate = new HashSet<>();
            Set<Integer> summit = new HashSet<>();

            for (int i = 0; i < gates.length; i++){
                gate.add(gates[i]);
            }

            for (int i = 0; i < summits.length; i++){
                summit.add(summits[i]);
            }


            return dijkstra(n, paths, gate, summit);

        }
    }
}
