package cote2025nov;

import java.util.*;

public class Cote11263 {

    class Solution {
        public String solution(int[] numbers) {

            String[] strNumbers = new String[numbers.length];
            for (int i = 0; i < numbers.length; i++){
                strNumbers[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(strNumbers, (a,b) -> (b + a).compareTo(a + b));

            //모두  0 인 케이스
            if (strNumbers[0].equals("0")){
                return "0";
            }

            // strNumbers 에 있는 요소들 이어붙이기
            StringBuilder sb = new StringBuilder();
            for (String element : strNumbers){
                sb.append(element);
            }

            return sb.toString();


        }
    }
}
