package cote2025oct;

import java.util.*;

public class Cote10271 {
    class Solution {
        public int solution(int[] prices, int target) {
            int answer = 0;
            int n = prices.length;
            Arrays.sort(prices);

            int lt = 0;
            int rt = n-1;

            while(lt<rt){
                int sum = prices[lt] + prices[rt];
                if (sum < target){
                    lt++;
                }
                else if (sum > target){
                    rt--;
                }
                else{
                    answer++;
                    lt++;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {


    }
}
