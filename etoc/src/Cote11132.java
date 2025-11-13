
import java.io.*;
import java.util.*;

public class Cote11132 {

    static class Time implements Comparable<Time>{

        public int time;
        public char status;

        public Time(int time, char status){
            this.time = time;
            this.status = status;
        }

        // 시간 기준 오름 차순 정렬
        // 시간이 같다면, end time 먼저 처리해야하므로 status 기준 오름차순 정렬
        @Override
        public int compareTo(Time o){
            if (this.time == o.time){
                return this.status - o.status;
            } else {
                return this.time - o.time;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 은 피로연에 참석한 인원수 (N <= 100,000)
        int N = Integer.parseInt(br.readLine());
        List<Time> list = new ArrayList<>();

        // list 초기화
        for (int i = 0 ; i < N; i++){
            String[] line = br.readLine().split(" ");
            int firstT = Integer.parseInt(line[0]);
            int secondT = Integer.parseInt(line[1]);

            list.add(new Time(firstT, 's'));
            list.add(new Time(secondT, 'e'));
        }

        Collections.sort(list);

        int count = 0; // 현재 피로연장에 존재하는 인원수
        int answer = Integer.MIN_VALUE; // 피로연장에 존재할 수 있는 최대 인원수 (구하고자 하는 것)

        for (Time t : list){
             // end time 먼저 처리후, 그 다음 s time 을 처리해야함.
            if (t.status == 's') count++;
            if (t.status == 'e') count--;

            if (count > answer) answer = count;
        }

        writer.write(String.valueOf(answer));
        writer.flush();
    }


}
