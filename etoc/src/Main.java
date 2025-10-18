import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

   static int N,M;
   // 수열을 담을 배열
    static int[] arr;
    // 방문 표시 배열
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N + 1];

        dfs(0);

        System.out.print(sb);

    }

    static void dfs(int depth){
        // depth 가 M 이면.
        if (depth == M){
            for (int i = 0; i< M; i++){
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 1부터 N 까지 중에서 조합을 선택함.
        for (int i = 1; i <= N; i++){
            if (!visited[i]) { // 숫자를 사용하지 않았으면
                visited[i] = true;
                arr[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }


}
