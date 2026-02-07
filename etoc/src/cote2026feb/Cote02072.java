package cote2026feb;

import java.util.*;
public class Cote02072 {
    static class Solution {


        public String solution(String[][] folders, String p, String q) {

            Map<String,String> parentMap = new HashMap<>();

            // 결국 최소 공통 조상을 구하는 문제네.
            for (String[] folder : folders){
                parentMap.put(folder[1], folder[0]);
            }

            Set<String> pAncestors = new HashSet<>();

            String current = p;
            while (current != null){
                pAncestors.add(current);
                current = parentMap.get(current);
            }

            // q 도 root 까지 올라가면서, 공통 조상이 있는지 검사
            current = q;
            while (current != null){
                if (pAncestors.contains(current)){
                    return current;
                }
                current = parentMap.get(current);
            }
            // 사실 여기에 도달할 일은 없긴함
            return "root";
        }
    }
}
