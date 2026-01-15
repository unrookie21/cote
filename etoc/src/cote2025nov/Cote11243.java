package cote2025nov;

import java.util.*;

public class Cote11243 {

    class Solution {
        public int[] solution(int[] answers) {

            int[] p1 = {1,2,3,4,5};
            int[] p2 = {2,1,2,3,2,4,2,5};
            int[] p3 = {3,3,1,1,2,2,4,4,5,5};

            int[] scores = new int[3];

            for (int i = 0 ; i < answers.length; i++){

                if(answers[i] == p1[i % p1.length]) scores[0]++;
                if(answers[i] == p2[i % p2.length]) scores[1]++;
                if(answers[i] == p3[i % p3.length]) scores[2]++;
            }

            // int maxScore = Arrays.stream(scores).max().getAsInt();
            int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
            List<Integer> winners = new ArrayList<>();
            for (int i = 0; i < 3; i++){
                if (scores[i] == maxScore){
                    winners.add(i+1);
                }
            }
            return winners.stream().mapToInt(i->i).toArray();
        }
    }
}
