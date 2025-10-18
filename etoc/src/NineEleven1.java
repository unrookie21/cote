import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NineEleven1 {

    static int N,M;
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열 초기화
        A = new int[N];
        B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0; int p2 =0;
        ArrayList<Integer> list = new ArrayList<>();
        while (p1 < N && p2 < M){
            if (A[p1] < B[p2])  list.add(A[p1++]);
            else{
                list.add(B[p2++]);
            }
        }
        while (p1 < N) list.add(A[p1++]);
        while (p2 < M) list.add(B[p2++]);

        for (Integer i : list) {
            System.out.print(i + " ");

        }
    }
}
