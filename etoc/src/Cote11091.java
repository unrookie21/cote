import java.util.*;

public class Cote11091 {
    class Solution {
        public int[] solution(int[] sequence, int k) {
            int n = sequence.length;

            int left = 0;
            int right = 0;
            int sum = sequence[0];
            int minLen = Integer.MAX_VALUE;

            int leftAnswer = 0;
            int rightAnswer = 0;


            while (left <= right && right < n){

                if (sum == k){

                    int length = right - left + 1;
                    if (length < minLen){
                        minLen = length;
                        leftAnswer = left;
                        rightAnswer = right;
                    }

                    sum -= sequence[left];
                    left++;
                } else if (sum < k){
                    right++;
                    if (right < n){
                        sum += sequence[right];
                    }
                } else{
                    sum -= sequence[left];
                    left++;
                }





            }



            return new int[]{leftAnswer, rightAnswer};

        }
    }
}
