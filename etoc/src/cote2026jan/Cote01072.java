package cote2026jan;

import java.util.*;
public class Cote01072 {

    static class Solution {

        public void backtracking(List<List<Integer>> ans,
                                 List<Integer> cur, int [] nums, int start){

            // 만들어지는 모든 cur 이 정답이므로
            ans.add(new ArrayList<>(cur));

            for (int i = start; i < nums.length; i++){
                cur.add(nums[i]);
                backtracking(ans, cur, nums, i+1);
                cur.remove(cur.size() - 1);
            }

        }
        public List<List<Integer>> subsets(int[] nums) {

            List<List<Integer>> answer = new ArrayList<>();
            backtracking(answer, new ArrayList<>(), nums, 0);
            return answer;

        }
    }
}
