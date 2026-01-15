package cote2025nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cote11012 {

    public static boolean BFS(List<List<Integer>> graph, int start, int[] team){

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        team[start] = 0; // 0 팀으로 설정

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int next : graph.get(cur)){
                // 만약 cur 와 next 노드가 같은 팀이면.. false 반환. 이분 그래프가 아니니까
                if (team[cur] == team[next]) return false;
                if (team[next] == -1){
                    queue.offer(next);
                    team[next] = 1- team[cur];
                }
            }
        }

        return true;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine()); // 테스트 case 의 수


        for (int i = 0; i < K; i++){
            String answer = "YES";

            String[] info = br.readLine().split(" ");
            int V = Integer.parseInt(info[0]); // 정점 개수
            int E = Integer.parseInt(info[1]); // 간선 개수

            // 팀 배열 초기화
            int[] team = new int[V+1];
            Arrays.fill(team, -1);

             // 정점의 인접 리스트 초기화.
            List<List<Integer>> graph = new ArrayList<>();
            for (int v = 0; v <= V; v++){
                graph.add(new ArrayList<>());
            }
            for (int e = 0; e < E; e++){
                // 간선 정보 입력 받기
                String[] edge = br.readLine().split(" ");
                int a = Integer.parseInt(edge[0]);
                int b = Integer.parseInt(edge[1]);

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            // 여기서 BFS 수행
            for (int nodeIdx = 1; nodeIdx <= V;  nodeIdx++){
                if(team[nodeIdx] == -1){
                    if(!BFS(graph, nodeIdx, team)){
                        answer = "NO";
                        break;
                    }
                }
            }


            sb.append(answer);
            if (i < K - 1) {  // 마지막이 아니면 줄바꿈 추가
                sb.append("\n");
            }

        }

        System.out.println(sb);

    }
}
