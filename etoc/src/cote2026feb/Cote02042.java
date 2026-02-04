package cote2026feb;

import java.util.*;

public class Cote02042 {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            List<List<String>> answer = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            List<String> temp = new ArrayList<>();

            for (String str : strs){

                char[] charArr = str.toCharArray();
                Arrays.sort(charArr);

                String key = new String(charArr);

                // key 가 없으면 연산, 있으면 기존 값 반환
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);

            }

            for (List<String> str : map.values()){
                answer.add(str);
            }
            return answer;
        }
    }

}
