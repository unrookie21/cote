package cote2026feb;

public class Cote02033 {

    static class Solution {
        public int solution(String s) {

            int minLength = s.length(); // 어떻게 짤라도 압축되지 않는 경우가 최대


            // 자르는 단위를 1부터, s.length() / 2 까지 진행
            for (int unit = 1; unit <= s.length() / 2; unit++){
                // 자른 결과를 담아 놓은 String[] 을 생성해놓자.
                String[] cutString = new String[(s.length() / unit) + 1];


                int idx = 0;
                // 이제 s 를 unit 만큼 자르면서, cutString 에 자른 결과를 저장하자.
                for (int i = 0; i < s.length(); i = i + unit){

                    int end = Math.min(i + unit, s.length());
                    String cut = s.substring(i, end); // i + unit 이 s 범위 밖으로 넘어갈 수도 있음.
                    cutString[idx++] = cut;

                }

                String compressedStr = "";

                for (int i = 0; i < idx; i++){

                    if (i == idx - 1 || i + 1 < idx && !cutString[i].equals(cutString[i+1])){
                        compressedStr += cutString[i];
                        continue;
                    }

                    // 같은 경우
                    String tmp = cutString[i];
                    int length = 1;

                    while (i + 1 < idx && cutString[i].equals(cutString[i+1])){
                        length++;
                        i++;
                    }

                    compressedStr += length + tmp;

                }

                minLength = Math.min(minLength, compressedStr.length());


            }

            return minLength;
        }

    }
}
