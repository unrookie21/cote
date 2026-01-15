package cote2025nov;

import java.util.*;
import java.io.*;

public class Cote11134 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 상근이의 동기수
        int M = Integer.parseInt(br.readLine()); // 리스트의 길이

        int[] distance = new int[N+1]; // 상근의 학번이 1이므로, 1부터 관리한다.
        Arrays.fill(distance, -1);

        List<List<Integer>> graph = new ArrayList<>();

        // 빈리스트 초기화
        for (int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        // 그래프 초기화
        for (int i = 0; i < M; i++){

            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int answer = 0;

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1); // 상근이 부터 탐색 시작
        distance[1] = 0; // 상근이 거리는 0부터 시작 (시작 위치이므로)

        while(!queue.isEmpty()){
            int cur = queue.poll();
            // 현재 노드까지의 탐색 거리가 2보다 작거나 같은 경우에만 , answer ++
            if (distance[cur] <= 2){
                answer++;
            }

            for (int next : graph.get(cur)){
                if (distance[next] == -1){
                    queue.offer(next);
                    distance[next] = distance[cur] + 1;
                }
            }
        }

        writer.write(String.valueOf(answer - 1));
        writer.flush();
    }
}
