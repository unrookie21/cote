package cote2025oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cote1030 {

    public static void DFS(Map<Integer, List<Integer>> graph, int cur, boolean[] visited){
        visited[cur] = true;
        for (int next : graph.get(cur)){
            if (!visited[next]){
                DFS(graph, next, visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        boolean[] visited = new boolean[N+1];
        int answer = 0;

        // 인접리스트 초기화
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // 정점 별 리스트 초기화
        for (int i = 1; i <= N; i++){
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < M; i++){

            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++){

            if (!visited[i]){
                visited[i] = true;
                DFS(graph, i, visited);
                answer++;
            }
        }

        System.out.print(answer);
    }
}
