package cote2026jan;
import java.util.*;
public class Cote01172 {

    static class Solution {
        public int longestValidParentheses(String s) {
            int max = 0;

            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(-1);

            char[] arr = s.toCharArray();

            for (int i = 0; i < arr.length; i++){

                if (arr[i] == '('){
                    stack.push(i);
                } else {
                    //
                    stack.pop();

                    // 스택이 빈 경우
                    if (stack.isEmpty()){
                        // 현재 인덱스로 기준점 다시 설정
                        stack.push(i);

                    } else{
                        max = Math.max(max, i - stack.peek());
                    }

                    // 비어있지 않은 경우 max 갱신

                }
            }
            return max;

        }
    }
}
