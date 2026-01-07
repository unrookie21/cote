import java.util.*;

public class Cote01071 {

    static class Solution {

        // 조합 생성
        public void backtracking(List<List<Integer>> ans,
                                 List<Integer> cur, int n,  int k , int start){

            // base
            if (cur.size() == k){
                ans.add(new ArrayList<>(cur));
                return;
            }

            for (int i = start; i <= n; i++){
                cur.add(i);
                backtracking(ans, cur, n, k, i+1);
                cur.remove(cur.size() - 1);
            }
        }
        public List<List<Integer>> combine(int n, int k) {

            List<List<Integer>> answer = new ArrayList<>();
            backtracking(answer, new ArrayList<>(), n, k, 1);
            return answer;

        }
    }
}
