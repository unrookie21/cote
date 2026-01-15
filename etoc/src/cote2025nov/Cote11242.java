package cote2025nov;

public class Cote11242 {

    class Solution {
        public int solution(int[][] sizes) {

            int widthMax = Integer.MIN_VALUE; // 가로 최대길이
            int heightMax = Integer.MIN_VALUE; // 세로 최대길이

            for(int[] card : sizes){

                if (card[1] > card[0]){
                    int temp = card[0];
                    card[0] = card[1];
                    card[1] = temp;
                }

                widthMax = Math.max(card[0], widthMax);
                heightMax = Math.max(card[1], heightMax);

            }

            return widthMax * heightMax;
        }
    }
}
