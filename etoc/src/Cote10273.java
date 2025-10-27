import java.util.*;
public class Cote10273 {

    class Solution {
        public int solution(String s) {
            int answer = 0;

            Deque<Character> stack = new ArrayDeque<>();
            char[] charArr = s.toCharArray();
            for (char ch : charArr){
                if (ch == '(') stack.push(ch);
                else if (ch == ')'){
                    if (!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                        answer++;
                    } else {
                        stack.push(ch);
                    }
                }
            }

            if (!stack.isEmpty()) answer = -1;
            return answer;
        }
    }
    public static void main(String[] args) {


    }
}
