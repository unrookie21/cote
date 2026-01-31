package cote2026jan;
import  java.util.*;
public class CoteReview0131 {

    static class Solution1 {
        //1615
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

        // 시작 노드인 k 에서 출발하여, 모든 노드까지 신호가 도달하는 최소 시간을 반환.

        public int dijkstra(int n , int start, int[][] edges){

            // 단방향 그래프로 변환
            List<List<Node>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++){
                graph.add(new ArrayList<>());
            }

            for (int[] edge : edges){
                graph.get(edge[0]).add(new Node(edge[1], edge[2]));
            }

            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            Queue<Node> pq = new PriorityQueue<>();

            // 시작점 처리
            dist[start] = 0;
            pq.offer(new Node(start, 0));

            while(!pq.isEmpty()){

                Node cur = pq.poll();

                if (cur.cost > dist[cur.node]) continue;

                for (Node next : graph.get(cur.node)){

                    int newCost = cur.cost + next.cost;
                    if (newCost < dist[next.node]){
                        dist[next.node] = newCost;
                        pq.offer(new Node(next.node, newCost));
                    }
                }
            }

            int minTime = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++){
                if (dist[i] == Integer.MAX_VALUE){
                    return -1;
                } else {
                    minTime = Math.max(minTime, dist[i]);
                }
            }

            return minTime;

        }

        // dist 배열이 완성되고, dist 배열에서 최댓값을 return 한다.
        // 만약에 Integer.MAX_VALUE 가 존재한다면 -1 을 return
        public int networkDelayTime(int[][] times, int n, int k) {

            return dijkstra(n, k , times);



        }
    }

    static class Solution2 {

        public class Process implements Comparable<Process>{

            public int processNumber;
            public int requestStart;
            public int workingTime;

            public Process(int pn, int rs, int wt){
                this.processNumber = pn;
                this.requestStart = rs;
                this.workingTime = wt;
            }

            @Override
            public int compareTo(Process other){
                if (this.workingTime == other.workingTime){

                    if (this.requestStart == other.requestStart){
                        return this.processNumber - other.processNumber;
                    }

                    return this.requestStart - other.requestStart;

                }

                return this.workingTime - other.workingTime;

            }

        }

        public int solution(int[][] jobs) {

            // jobs 를 작업 요청시간 기준으로 오름차순 정렬
            Arrays.sort(jobs, (a,b) -> a[0] - b[0]);


            // 우선순위 디스크 컨트롤러
            Queue<Process> pq = new PriorityQueue<>();

            int completedJobs = 0;
            int jobIdx = 0; // 현재 작업 번호

            int currentTime = 0;
            int totalTurnAroundTime = 0;

            while(completedJobs < jobs.length){

                // 대기 큐에 작업을 추가해야한다. 현재 시간 기준으로
                while(jobIdx < jobs.length && jobs[jobIdx][0] <= currentTime){
                    pq.offer(new Process(jobIdx, jobs[jobIdx][0], jobs[jobIdx][1]));
                    jobIdx++;
                }

                // 큐가 비어잇을 수도 잇음.
                if(pq.isEmpty()){
                    currentTime = jobs[jobIdx][0];
                    continue;
                }

                // 이 지점에서는 큐가 비어잇을 수 없음.
                // 작업 수행하자.
                Process job = pq.poll();
                // turn around time : 작업 끝난 시간 - 요청 시각
                int finish = currentTime + job.workingTime;
                currentTime = finish;
                int turnAroundTime = finish - job.requestStart;
                totalTurnAroundTime += turnAroundTime;


                completedJobs++;


            }

            return totalTurnAroundTime / jobs.length;


        }

    }

    static class Solution3 {

        public class Node implements Comparable<Node>{

            public int node;
            public double prob;

            public Node(int n , double p){
                this.node = n;
                this.prob = p;
            }

            @Override
            public int compareTo(Node other){
                return Double.compare(other.prob , this.prob);
            }


        }

        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

            List<List<Node>> graph = new ArrayList<>();

            for (int i = 0; i < n; i++){
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < edges.length; i++){

                int[] edge = edges[i];
                int a = edge[0];
                int b = edge[1];
                double prob = succProb[i];

                graph.get(a).add(new Node(b, prob));
                graph.get(b).add(new Node(a, prob));
            }

            double[] probability = new double[n];
            Arrays.fill(probability, 0.0);

            Queue<Node> pq = new PriorityQueue<>();
            // 시작점 처리

            probability[start_node] = 1.0;
            pq.offer(new Node(start_node, 1.0));


            while(!pq.isEmpty()){

                Node cur = pq.poll();

                if (cur.prob < probability[cur.node]) continue;

                for (Node next : graph.get(cur.node)){
                    double newProb = cur.prob * next.prob;
                    if (newProb > probability[next.node]){
                        probability[next.node] = newProb;
                        pq.offer(new Node(next.node, newProb));
                    }




                }



            }

            if (probability[end_node] != 0.0){
                return probability[end_node];
            }

            return 0;





            // 1655

            /// sucProb 는 두 노드 사이를 지나는 것의 성공 확률을 담고 잇음
            // start -> end 까지갈때, "성공 확률이 최대화" 되도록 경로를 구성해야함.
            // 다익스트라에서 대소비교만 반대로하면 되겟지



        }

    }



    static class Solution4 {

        class Node implements Comparable<Node>{

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

        public int[] dijkstra(int n, int[][] paths, Set<Integer> gates, Set<Integer> summits){

            // 이 배열이 다 채워지고 나면, 각 원소의 의미는 출발점에서 해당 지점까지의 최소 intensity 값.
            int[] intensity = new int[n+1];
            Arrays.fill(intensity, Integer.MAX_VALUE);

            List<List<Node>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++){
                graph.add(new ArrayList<>());
            }

            for (int[] edge : paths){
                graph.get(edge[0]).add(new Node(edge[1], edge[2]));
                graph.get(edge[1]).add(new Node(edge[0], edge[2]));
            }

            Queue<Node> pq = new PriorityQueue<>();

            // 시작점은 한 번에 초기화하자.
            for (int gate : gates){
                pq.offer(new Node(gate , 0));
                intensity[gate] = 0;
            }

            while (!pq.isEmpty()){

                Node cur = pq.poll();
                // 현재 노드가 산봉우리이면 넘어감.
                if (summits.contains(cur.node)){
                    continue;
                }

                if (cur.cost > intensity[cur.node]){
                    continue;
                }

                for (Node next : graph.get(cur.node)){
                    // 다음 노드가 출입구이면 넘어감
                    if (gates.contains(next.node)){
                        continue;
                    }

                    int newIntensity = Math.max(cur.cost, next.cost);
                    if (newIntensity < intensity[next.node]){
                        intensity[next.node] = newIntensity;
                        pq.offer(new Node(next.node, newIntensity));
                    }

                }
            }

            // 탐색종료. intensity 배열이 완성된 상태.
            int[] answer = new int[2];
            // {intensity 가 최소인 코스의 산봉우리 번호, intensity 의 최솟값}

            int minValue = Integer.MAX_VALUE;
            //             1번  2번 3번 4번 5번 6번   7번
            // intensity : [0,  3,  4,  3,   6  7  , 8]

            List<Integer> sumList = new ArrayList<>(summits);
            Collections.sort(sumList);

            int sumResult = 0;
            for (int sum : sumList){
                if (intensity[sum] < minValue){
                    minValue = intensity[sum];
                    sumResult = sum;
                }

            }

            return new int[]{sumResult, minValue};


        }






        // n : 노드 개수, paths : 간선 정보, gates : 출입구 노드 번호, summits : 정상노드 번호
        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            int[] answer = new int[2];
            // {intensity 가 최소인 코스의 산봉우리 번호, intensity 의 최솟값}


            // 휴식 없이 이동해야 하는 시간 중, 가장 긴 시간을 코스의 intensity 라고 부르자.
            // intensity 가 최소가 되도록 등산코스를 정한다

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



    static class Solution5 {

        public class Node implements Comparable<Node>{

            public int node;
            public int cost;

            public Node(int n , int c){
                this.node = n;
                this.cost = c;
            }
            @Override
            public int compareTo(Node other){
                return this.cost - other.cost;
            }

        }

        public int[] dijkstra(int n, int start, int[][] fares){

            List<List<Node>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++){
                graph.add(new ArrayList<>());
            }

            for (int[] edge : fares){
                graph.get(edge[0]).add(new Node(edge[1], edge[2]));
                graph.get(edge[1]).add(new Node(edge[0], edge[2]));
            }

            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            Queue<Node> pq = new PriorityQueue<>();

            // 시작점처리
            dist[start] = 0;
            pq.offer(new Node(start, 0));


            while(!pq.isEmpty()){

                Node cur = pq.poll();
                if (cur.cost > dist[cur.node]) continue;

                for (Node next : graph.get(cur.node)){
                    int newCost = cur.cost + next.cost;
                    if (newCost < dist[next.node]){
                        dist[next.node] = newCost;
                        pq.offer(new Node(next.node, newCost));
                    }

                }
            }

            return dist;
        }

        public int solution(int n, int s, int a, int b, int[][] fares)
        {

            int[] distS = dijkstra(n, s, fares);
            int[] distA = dijkstra(n, a, fares);
            int[] distB = dijkstra(n, b, fares);

            int minCost = Integer.MAX_VALUE;

            for (int i = 1; i <= n; i++){
                minCost = Math.min(minCost, distS[i] + distA[i] + distB[i]);
            }

            return minCost;
        }

    }




}
