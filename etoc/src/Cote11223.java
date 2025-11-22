import java.util.*;
public class Cote11223 {

    class Solution {

        public void BFS(int start , boolean[] visited, int[][] computers){

            Deque<Integer> q = new ArrayDeque<>();
            q.offer(start);
            visited[start] = true;

            while(!q.isEmpty()){
                int cur = q.poll();

                // computers 는 연결여부를 나타내는 인접 행렬임.
                for (int next = 0; next < computers[0].length; next++){
                    if(computers[cur][next] == 1 && !visited[next]){
                        q.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
        public int solution(int n, int[][] computers) {
            // graph 에 대한 탐색을 진행하자.
            // 네트워크의 개수 반환
            int answer = 0;
            boolean[] visited = new boolean[n];

            // 인접 행렬 이미, computers 로주어진 상태이다. 별도로 변환할 필요 없을 것 같다.
            //모든 노드에 대해 BFS 수행
            for (int i = 0; i < n; i++){
                if (!visited[i]){
                    BFS(i, visited, computers);
                    // 다 탐색하고 오면, answer(네트워크 개수) 증가
                    answer++;
                }
            }
            return answer;
        }
    }
}
