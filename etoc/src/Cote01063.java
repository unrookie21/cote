import java.util.*;

public class Cote01063 {

    static class Solution {

        public void backtracking(List<Integer> cur, int[] nums, List<List<Integer>> ans, boolean[] visited){
            if (cur.size() == nums.length){
                ans.add(new ArrayList<>(cur));
                return;
            }

            for (int i = 0; i < nums.length; i++){
                if(!visited[i]){
                    visited[i] = true;
                    cur.add(nums[i]);
                    backtracking(cur, nums, ans, visited);
                    cur.remove(cur.size() - 1);
                    visited[i] = false;
                }
            }
        }


        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> answer = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            backtracking(new ArrayList<>(), nums, answer, visited);
            return answer;
        }
    }
}
