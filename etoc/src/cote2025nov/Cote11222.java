package cote2025nov;

import java.util.*;

public class Cote11222 {

    class Solution {
        public String solution(String[] participant, String[] completion) {

            String answer = "";
            Map<String, Integer> map = new HashMap<>();
            for (String name : participant){
                map.put(name, map.getOrDefault(name, 0) + 1);
            }

            for (String finisher : completion){
                map.put(finisher, map.get(finisher) - 1);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()){
                if (entry.getValue() != 0){
                    answer = entry.getKey();
                }
            }
            return answer;

        }
    }
}
