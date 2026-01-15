package cote2025oct;

import java.io.*;
import java.util.*;

public class Cote10275 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] inputArr = new int[N];
        int[] answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++){

            int curNumber = inputArr[i];
            while (!stack.isEmpty() && stack.peek()[1] < curNumber){
                int[] item = stack.pop();
                int idx = item[0];
                answer[idx] = curNumber;
            }

            int[] toAdd = {i, inputArr[i]};
            stack.push(toAdd);

        }

        // stack 에 남아있는 것들에 대해서는, 오큰수를 -1 로 처리한다.
        while(!stack.isEmpty()){
            int[] popped = stack.pop();
            int idx = popped[0];
            answer[idx] = -1;
        }


        for (int num : answer){
            writer.write(num + " ");
        }
        writer.flush();

    }
}
