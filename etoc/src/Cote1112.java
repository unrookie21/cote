import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Cote1112 {

    static class Body implements Comparable<Body>{
        int height;
        int weight;

        public Body(int height, int weight){
            this.height = height;
            this.weight = weight;
        }

        // 키 기준 내림차순 정렬
        @Override
        public int compareTo(Body o) {
            return o.height - this.height;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Body> list = new ArrayList<>();

        for (int i = 0 ; i < N; i++){

            String[] line = br.readLine().split(" ");

            int height = Integer.parseInt(line[0]);
            int weight = Integer.parseInt(line[1]);

            list.add(new Body(height, weight));
        }

        int maxWeight = Integer.MIN_VALUE; // (키는 이미 내림차순으로 정렬 된 상태에서, 몸무게가 나보다 높은 놈이 한 놈이라도 있으면 탈락이기 때문에, 최대 몸무게를 관리해야함)
        int count = 0;
        Collections.sort(list); // 키 기준 내림차순 정렬

        // greedy
        for (Body body : list){
            if (body.weight > maxWeight){
                maxWeight = body.weight;
                count++;
                // 선발 처리
            }
        }

        System.out.print(count);
    }
}
