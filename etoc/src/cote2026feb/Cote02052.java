package cote2026feb;

import java.util.*;
public class Cote02052 {

    static class Solution {

        public int parseDateToInteger(String date){

            String[] splited = date.split("\\.");

            int year = Integer.parseInt(splited[0]);
            int month = Integer.parseInt(splited[1]);
            int day = Integer.parseInt(splited[2]);

            return year * 336 + month * 28 + day;
        }

        public int[] solution(String today, String[] terms, String[] privacies) {

            // terms 의 원소 : "약관종류 유효기간" 공백 기준
            // privacies 의 원소 : "날짜 약관종류" 공백 기준
            // terms 를 일단 map 으로 바꾸자.
            Map<String, String> termMap = new HashMap<>();

            for (String term : terms){
                String[] splitTerm = term.split(" ");
                String type = splitTerm[0];
                String date = splitTerm[1];
                termMap.put(type, date);
            }

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < privacies.length; i++){

                String privacy = privacies[i];
                String[] splited = privacy.split(" ");

                String originalDate = splited[0]; // 기준 날짜 2021.05.02
                // 2021.05.02 -> 2021 * 336 + 5 * 28 + 2 = 679198
                String type = splited[1]; // 약관 종류  // A

                String termDate = termMap.get(type); // 6달 -> 6 x 28 = 168
                int toAdd = Integer.parseInt(termDate) * 28;

                int originalDateInt = parseDateToInteger(originalDate);
                int calculatedDate = originalDateInt + toAdd - 1;

                int todayInt = parseDateToInteger(today);

                // calculatedDate 가 today 보다 작으면 ->파기.

                if (calculatedDate < todayInt){
                    list.add(i + 1);
                }
            }

            int[] answer = new int[list.size()];

            for (int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }

            return answer;


        }
    }

}
