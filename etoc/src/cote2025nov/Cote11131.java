package cote2025nov;

import java.util.*;
import java.io.*;

public class Cote11131 {

    static class Meeting implements Comparable<Meeting> {
        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meeting o){
            if (o.endTime == this.endTime){
                return this.startTime - o.startTime;
            } else{
                return this.endTime - o.endTime;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Meeting> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n ; i++){
            String[] line = br.readLine().split(" ");

            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);

            list.add(new Meeting(start, end));
        }

        Collections.sort(list);

        int end = Integer.MIN_VALUE;
        int count = 0;
        for (Meeting meeting : list){
            if(meeting.startTime >= end){
                end = meeting.endTime;
                count++;
            }
        }

        System.out.print(count);
    }
}