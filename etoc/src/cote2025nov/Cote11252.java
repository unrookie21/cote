package cote2025nov;

import java.util.*;

public class Cote11252 {

    class Solution {

        public int solution(int balance, int[][] countries) {

            int n = countries.length;

            int maxCountries = 0;

            boolean[] visited = new boolean[n];
            List<List<int[]>> paths = new ArrayList<>();

            backtrack(new ArrayList<>() , countries, visited, paths);

            // 현재 paths 에는 모든 순열 리스트가 만들어진 상태이다.

            for (List<int[]> path : paths){

                int currentBalance = balance;
                int count = 0;
                for (int[] country : path){
                    int cost = country[0];
                    int minBalance = country[1];

                    if (currentBalance >= minBalance)
                    {
                        currentBalance -= cost;
                        count++;
                    } else{
                        break;
                    }

                    maxCountries = Math.max(maxCountries, count);
                }
            }
            return maxCountries;

        }

        // 순열 생성
        public void backtrack(List<int[]> path, int[][] countries, boolean[] visited,
                              List<List<int[]>> paths){

            if (path.size() == countries.length){
                paths.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < countries.length; i++){
                if (!visited[i]){
                    visited[i] = true;
                    path.add(countries[i]);
                    backtrack(path, countries, visited, paths);
                    path.remove(path.size() - 1);
                    visited[i] = false;
                }

            }





        }
    }
}
