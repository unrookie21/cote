import java.util.*;

public class Cote10274 {

    class Solution {
        public int[] solution(int[] weights) {

            int[] answer = new int[weights.length];
            Deque<int[]> stack = new ArrayDeque<>();

            for (int i = 0; i < weights.length; i++){

                int currentWeight = weights[i];
                while(!stack.isEmpty() && stack.peek()[1] < currentWeight){
                    // 스택 top 을 pop 하고 거리 계산, [0] 에 들어있는 날짜 index 기반으로 걸린 일수 계산
                    int[] item = stack.pop();
                    int dayIdx = item[0];
                    answer[dayIdx] = i - dayIdx;
                }

                int[] toAdd = {i, currentWeight};
                stack.push(toAdd);
            }
            return answer;
        }
    }
    public static void main(String[] args) {


    }
}
