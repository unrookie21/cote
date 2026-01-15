package cote2025nov;

import java.util.*;

public class Cote11241 {

    class Solution {

        // 현재 탐색 단어와 , 지금까지의 단계를 담고 있는 Item 클래스를 정의한다.
        static class Item{
            public String word;
            public int distance;

            public Item(String word, int distance){
                this.word = word;
                this.distance = distance;
            }
        }

        // "가장 짧은 변환 과정" 을 찾고 있으므로 최단거리를 구하는 BFS 탐색이 적합.
        public int BFS(String begin, String target, String[] words, Set<String> visited){

            // 큐 초기화 및 첫 탐색 진행
            Deque<Item> queue = new ArrayDeque<>();
            queue.offer(new Item(begin, 0));
            visited.add(begin);

            while (!queue.isEmpty()){

                Item item = queue.poll();

                String curWord = item.word;
                int curDist = item.distance;

                // 현재 단어가 타겟 단어와 같아지면 현재 거리를 return
                if (curWord.equals(target)) return curDist;

                for (String nextWord : words){
                    if (!visited.contains(nextWord)){

                        int diffCount = 0;

                        // 다음 탐색 후보 단어와, 현재단어와의 알파벳 개수 차이 구하기
                        for (int i = 0; i < nextWord.length(); i++){

                            if (nextWord.charAt(i) != curWord.charAt(i)){
                                diffCount++;
                            }
                        }
                        // 알파벳 개수 차이가 2개 이상 나면, 변환하지 못하니까 다음 단어 탐색으로 continue.
                        if (diffCount > 1) continue;

                        // 알파벳 개수 차이가 1개이면, 변환 가능. 큐에 넣고, 탐색을 계속 진행하자.
                        queue.offer(new Item(nextWord, curDist + 1));
                        visited.add(nextWord);
                    }
                }
            }

            return 0;
        }
        public int solution(String begin, String target, String[] words) {

            Set<String> visited = new HashSet<>(); // 방문 배열을 set 으로 정의
            return BFS(begin, target, words, visited);

        }
    }
}
