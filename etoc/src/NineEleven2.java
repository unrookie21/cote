import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NineEleven2 {

    static int N,X;
    static int arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 1;

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        // 배열 초기화
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0; int p2 =0;
        int sum = 0;
        for (int i = 0; i < X; i++){
            sum += arr[i];
        }
        p2 += X - 1;
        int max = sum;

        while (p2 + 1 < N){
            sum = sum - arr[p1] + arr[p2+1];
            p1++;
            p2++;

            if (sum > max){
                max = sum;
                count = 1;
            } else if (sum == max){
                count++;
            }

        }

        if (max == 0){
            System.out.print("SAD");
        } else {
            System.out.println(max);
            System.out.print(count);
        }





    }
}
