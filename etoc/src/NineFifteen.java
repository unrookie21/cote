import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NineFifteen {

    static int N,S;
    static int[] arr;
    static int answer = 0;

    static void DFS(int depth, int sum){
        if (depth == N){
            if (sum == S){
                answer++;
            }
            return;
        }

        // 왼쪽 탐색은 원소포함하는 경우
        DFS(depth+1, sum + arr[depth]);
        // 오른쪽 탐색은 원소 포함하지 않는 경우
        DFS(depth+1 , sum);
    }

    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] =  Integer.parseInt(st.nextToken());
        }

        DFS(0,0);


        if (S == 0) System.out.println(answer-1); // 아무것도 포함하지 않는 공집합은 , asnwer 에서 카운트 빼ㅑ야함
        else System.out.println(answer);



    }
}
