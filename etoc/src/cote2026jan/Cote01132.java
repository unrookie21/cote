package cote2026jan;

import java.util.*;

public class Cote01132 {

    static class Solution {
        public boolean isValid(String s) {

            // s 가 올바른 괄호쌍을 가지고 있는지 반환해야한다.

            boolean answer = true;

            Deque<Character> stack = new ArrayDeque<>();

            char[] charArr = s.toCharArray();

            for (char c : charArr){

                // 좌괄호는 무조건 push
                if (c == '(' || c == '[' || c == '{'){
                    stack.push(c);
                    continue;
                } else { // 우괄호

                    if (stack.isEmpty()) return false;

                    int top = stack.pop();
                    if (c == ')' && top != '(') return false;
                    if (c == '}' && top != '{') return false;
                    if (c == ']' && top != '[') return false;

                }
            }

            if (!stack.isEmpty()) return false;

            return true;



        }
    }


}
