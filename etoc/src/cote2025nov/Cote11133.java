package cote2025nov;

import java.util.*;
import java.io.*;

public class Cote11133 {

    static class Assignment implements Comparable<Assignment> {

        public int d; // 과제 마감일까지 남은 일 수
        public int w; // 과제의 점수

        public Assignment(int d, int w){
            this.d = d;
            this.w = w;
        }

        // 과제 마감일 내림 차순 정렬
        @Override
        public int compareTo(Assignment other){
            return other.d - this.d;
        }
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Assignment> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int answer = 0;

        for (int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");

            int d = Integer.parseInt(line[0]);
            max = Math.max(d, max);
            int w = Integer.parseInt(line[1]);

            list.add(new Assignment(d, w));
        }

        Collections.sort(list); // 정렬 완료
        PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙 만들기

        int j = 0;
        for (int i = max; i >=1 ; i--){
            while(j < N){
                if (list.get(j).d < i) break;
                PQ.offer(list.get(j).w);
                j++;
            }
            // break 로 빠져나온 시점에서, PQ 에서 poll 한 후 answer 에 더한다.
            if (!PQ.isEmpty()) answer += PQ.poll();

        }

        writer.write(String.valueOf(answer));
        writer.flush();
    }
}
