package cote2025oct;

import java.util.*;
public class Cote10273Improved {

    class Solution {

        public int solution(String s) {
            int answer = 0;

            Deque<Character> stack = new ArrayDeque<>();
            char[] charArr = s.toCharArray();
            for (char ch : charArr){
                if (ch == '(') stack.push(ch);
                else if (ch == ')'){
                    // stack 이 비어있으면 , 유효하지 않은 상황. -1 반환
                    if (stack.isEmpty()){
                        return -1;
                    }
                    // 비어있지 않다면
                    stack.pop();
                    answer++;
                }
            }
            if (!stack.isEmpty()) answer = -1;
            return answer;
        }
    }
    public static void main(String[] args) {


    }
}
