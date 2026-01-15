package cote2026jan;

import java.util.*;
public class Cote01092 {

    static class Solution {
        public int solution(String[][] relation) {

            int rowLength = relation.length;
            int colLength = relation[0].length;

            // 후보키 리스트
            List<Set<Integer>> candidateKeys = new ArrayList<>();

            for (int i = 1; i <= colLength; i++){
                List<Set<Integer>> combinations = new ArrayList<>();
                makeCombinations(0, 0, i, new HashSet<>(), colLength, combinations);
                // 조합 생성 완료

                for (Set<Integer> columns : combinations){


                    // 하나의 columns 에 대해, 최소성 검사 -> 유일성 검사를 진행한다.
                    boolean minimality = true;

                    // 1. 최소성 검사
                    for (Set<Integer> candidateKey : candidateKeys){
                        if (columns.containsAll(candidateKey)){
                            // 최소성 위반
                            minimality = false;
                            break;
                        }
                    }

                    if (!minimality){
                        continue;
                    }

                    // 2. 유일성 검사
                    Set<String> rowSet = new HashSet<>(); // row 중복검사용 hash set.
                    for (String[] row : relation){
                        StringBuilder sb = new StringBuilder();
                        for (int col : columns){
                            sb.append(row[col]);
                        }
                        rowSet.add(sb.toString());
                    }

                    if (rowSet.size() == rowLength){
                        candidateKeys.add(new HashSet<>(columns));
                    }
                }



            }


            return candidateKeys.size();
        }

        // 조합을 만든다. (1개짜리 조합, 2개짜리 조합, ..... 순서대로 만듦)
        public void makeCombinations(int start, int depth, int maxDepth,
                                     Set<Integer> cur, int colLength, List<Set<Integer>> ans){

            if (depth == maxDepth){
                ans.add(new HashSet<>(cur));
                return;
            }

            for (int i = start; i < colLength; i++){
                cur.add(i);
                makeCombinations(i+1, depth+1, maxDepth, cur, colLength, ans);
                cur.remove(i);

            }

        }







    }
}
