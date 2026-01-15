package cote2026jan;

import java.util.*;

public class Cote01141 {


    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {

            // stack 정의
            Deque<int[]> stack = new ArrayDeque<>();

            // answer 배열 정의
            int[] answer = new int[temperatures.length];
            Arrays.fill(answer ,  0);

            for (int i = 0; i < temperatures.length; i++){


                int curTemperature = temperatures[i];

                // 어떤 경우에 pop 하냐? 를 생각해보자.
                while(!stack.isEmpty() && stack.peek()[0] < curTemperature){
                    int[] item = stack.pop();
                    int day = item[1];
                    // 날짜 계산후, answer 에 쓰기
                    int dateDiff = i - day;
                    answer[day] = dateDiff;
                }

                stack.push(new int[]{curTemperature, i});

            }
            return answer;
        }
    }
}
