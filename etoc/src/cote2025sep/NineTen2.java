package cote2025sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NineTen2 {

    static int N,M;
    static int[] input;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        input = new int[N];

        // 두번째 줄 읽기
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            input[i] = temp;
            max = Math.max(max, temp);

        }

        visited = new boolean[max+1];
        Arrays.sort(input);

        DFS(0);
        System.out.println(sb);
    }

    static void DFS(int depth) {
        if (depth == M){
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }

            sb.append('\n');
            return;
        }

        for (int num : input){
            if(!visited[num]){
                visited[num] = true;
                arr[depth] = num;
                DFS(depth+1);
                visited[num] = false;
            }
        }


    }
}
