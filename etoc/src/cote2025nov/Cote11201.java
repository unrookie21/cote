package cote2025nov;

import java.util.*;
import java.io.*;

public class Cote11201 {

    public int solution(String s){

        int answer = 0; // 올바른 소괄호 쌍의 개수

        Deque<Character> stack = new ArrayDeque<>();
        char[] charArr = s.toCharArray();

        // ( 는 push
        // ) 가 나오면, stack 비어있지 않은지 확인 후, ( 이면 pop
        // 마지막에, stack 에 남아있는 괄호가 있으면 -1 출력
        // ( ( ) ( ) ) ( )
        for (char c : charArr){



            if (c == '('){
                stack.push(c);
            } else if (c == ')'){
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        answer++;
                    }
                }
            }
        }

        if (!stack.isEmpty()) return -1;
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Cote11201 T = new Cote11201();
        System.out.println(T.solution(str));


    }
}
