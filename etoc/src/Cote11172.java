import java.util.*;

class Cote11172 {

    public List<List<Integer>> combine(int n, int r){
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, new ArrayList<>(), n, r, ans);
        return ans;
    }

    public void backtrack(int start, List<Integer> curr, int n, int r, List<List<Integer>> answer){
        if (curr.size() == r){
            answer.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= n; i++){
            curr.add(i);
            backtrack(i+1, curr, n, r, answer);
            curr.remove(curr.size() - 1);
        }
    }

    public boolean isValid(List<Integer> combination , int[][] q, int[] ans){

        for (int i = 0; i < q.length; i++){
            if (countMatches(combination, q[i]) != ans[i]){
                return false;
            }
        }

        return true;

    }

    public int countMatches(List<Integer> combination , int[] query){

        int count = 0;

        for (int i = 0; i < query.length; i++){
            if (combination.contains(query[i])){
                count++;
            }
        }
        return count;
    }

    public int solution(int n, int[][] q, int[] ans) {

        // 모든 combination 생성 (n,r 을 바탕으로)
        List<List<Integer>> allCombinations = combine(n, 5);

        int result = 0;

        for (List<Integer> combination : allCombinations){
            if (isValid(combination , q, ans)){
                result++;
            }
        }

        return result;


    }

}