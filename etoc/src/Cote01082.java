import java.util.*;

public class Cote01082 {

    static class Solution1 {

        public void backtracking(List<Integer> cur, List<List<Integer>> ans, boolean[] visited, int n){
            if (cur.size() == n){
                ans.add(new ArrayList<>(cur));
                return;
            }

            for (int i = 1; i <= n; i++){
                if (!visited[i]){
                    visited[i] = true;
                    cur.add(i);
                    backtracking(cur, ans, visited, n);
                    cur.remove(cur.size() - 1);
                    visited[i] = false;
                }
            }

        }


        public String getPermutation(int n, int k) {

            List<List<Integer>> permutations = new ArrayList<>();
            boolean[] visited = new boolean[n+1];
            backtracking(new ArrayList<>(), permutations, visited, n);
            List<Integer> p = permutations.get(k-1);
            String answer = "";
            for (int num : p){
                answer += String.valueOf(num);
            }

            return answer;
        }
    }


    static class Solution2 {

        public String recursion(int k, int n, int[] factorial, List<Integer> availableNumbers){

            // base
            if (n == 1){
                return String.valueOf(availableNumbers.get(0));
            }

            int curIdx = k / factorial[n-1]; // 사용할 index
            String num = String.valueOf(availableNumbers.get(curIdx));
            availableNumbers.remove(curIdx);

            int nextK = k % factorial[n-1];

            return num + recursion(nextK , n-1, factorial, availableNumbers);
        }


        public String getPermutation(int n, int k) {

            List<Integer> availableNumbers = new ArrayList<>();

            int[] factorial = new int[n];
            factorial[0] = 1;
            for (int i = 1; i < n; i++){
                factorial[i] = factorial[i-1] * i;
            }

            for (int i = 1; i <= n; i++){
                availableNumbers.add(i);
            }

            return recursion(k-1, n, factorial, availableNumbers);
        }
    }
}
