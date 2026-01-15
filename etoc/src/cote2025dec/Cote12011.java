package cote2025dec;

import java.util.*;

public class Cote12011 {

    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            Set<String> set = new HashSet<>();
            for (String number : phone_book){
                set.add(number);
            }

            for (String number : phone_book){
                for (int i = 1; i < number.length(); i++){
                    if (set.contains(number.substring(0,i))){
                        return false;
                    }
                }

            }
            return answer;
        }
    }

}
