package cote2026feb;

import java.util.*;
public class Cote02041 {

    static class Solution {

        public String solution(String new_id) {


            String result = new_id.toLowerCase();

            char[] charArr = result.toCharArray();

            StringBuilder sb = new StringBuilder();

            for (char c : charArr){
                // 조건 검사
                if(Character.isDigit(c) || Character.isLetter(c) ||
                        c == '-' || c == '_' || c == '.'){
                    sb.append(c);
                }
            }

            result = sb.toString();

            while (result.contains("..")){
                result = result.replace("..", ".");
            }

            if (result.startsWith(".")){
                result = result.substring(1);
            }

            if (result.endsWith(".")){
                // [0, 1, 2, 3]
                result = result.substring(0, result.length() - 1);
            }

            if (result.isEmpty()){
                result = "a";
            }

            if (result.length() >= 16){
                result = result.substring(0,15);
            }
            if (result.endsWith(".")){
                result = result.substring(0, result.length() - 1);
            }

            while (result.length() < 3){
                result += result.charAt(result.length() - 1);

            }

            return result;
        }
    }
}
