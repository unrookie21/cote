package cote2026jan;

import java.util.*;
public class Cote01091 {

    static class Solution {

        public void backtracking(List<String> cur, List<List<String>> answer, String s){
            if (s.length() == 0){ // base
                answer.add(new ArrayList<>(cur));
                return;
            }

            for (int i = 1; i <= s.length(); i++){
                String firstStr = s.substring(0, i); // a
                if (!isPalindrome(firstStr)){
                    continue;
                }
                cur.add(firstStr);
                backtracking(cur, answer, s.substring(i, s.length()));
                cur.remove(cur.size() - 1);
            }

        }


        public List<List<String>> partition(String s) {

            List<List<String>> answer = new ArrayList<>();
            backtracking(new ArrayList<>() , answer, s);

            return answer;
        }

        public boolean isPalindrome(String str){
            if (str.length() <= 1) return true;
            if (str.charAt(0) != str.charAt(str.length() - 1)) return false;
            return isPalindrome(str.substring(1, str.length() - 1));
        }
    }
}
