package cote2026feb;

import java.util.*;

public class Cote02032 {

    static class Solution {
        public int longestConsecutive(int[] nums) {

            Set<Integer> set = new HashSet<>();

            for (int num : nums){
                set.add(num);
            }

            int maxLen = 0;

            for (int num : set){

                // 수열의 시작점인지 체크
                if (!set.contains(num -1)){
                    int curNum = num;
                    int curLen = 1;

                    while(set.contains(curNum + 1)){
                        curNum++;
                        curLen++;
                    }

                    maxLen = Math.max(maxLen, curLen);
                }
            }

            return maxLen;
        }
    }
}
