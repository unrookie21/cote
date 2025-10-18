import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class NineThirteen2 {

    static int N,S;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int sum = 0;


        ArrayList<Integer> list = new ArrayList<>();

        for (int rt = 0; rt < N; rt++){

            sum += arr[rt];
            while (sum >= S){
                int length = rt - lt + 1;
                list.add(length);
                sum = sum - arr[lt++];
            }
        }

        if (list.isEmpty()) System.out.print(0);
        else {
            int min = Collections.min(list);
            System.out.print(min);
        }





    }
}
