package cote2025sep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class NineThirteen1 {

    static int N,K;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int lt = 0;

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int rt = 0; rt < N; rt++){
            countMap.put(arr[rt] , countMap.getOrDefault(arr[rt], 0) + 1);

            // k 초과원소 있을시, 왼쪽 포인터 이동
            while(countMap.get(arr[rt]) > K){
                // map 에서 arr[lt] 에 대응하는 개수를 하나 감소시킨다.
                countMap.put(arr[lt] , countMap.get(arr[lt]) - 1);
                // 근데 개수가 0이되면, map 에서 삭제해야겟지
                if (countMap.get(arr[lt]) == 0){
                    countMap.remove(arr[lt]);
                }
                lt++;
            }

            // 이제, 이 시점에는 k 초과하는 원소가 없는 상태이다.
            max = Math.max(max, rt-lt+1);
        }

        System.out.print(max);




    }


}
