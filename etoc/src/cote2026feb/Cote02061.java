package cote2026feb;

import java.util.*;
public class Cote02061 {

    class Solution1 {
        public int lengthOfLongestSubstring(String s) {

            int maxLength = 1;

            if (s.length() == 0) return 0;

            for (int i = 0; i < s.length(); i++){
                Set<Character> set = new HashSet<>();
                set.add(s.charAt(i));
                int length = 1;
                for (int j = i + 1; j < s.length(); j++){
                    if(set.contains(s.charAt(j))){
                        break;
                    }
                    length++;
                    set.add(s.charAt(j));
                    maxLength = Math.max(maxLength, length);

                }

            }
            return maxLength;

        }
    }

    class Solution2 {
        public int lengthOfLongestSubstring(String s) {

            if (s.length() == 0) return 0;

            int maxLength = 1;

            // two pointer 와 hash map 을 같이 사용하자.
            int left = 0;

            Map<Character, Integer> map = new HashMap<>();

            for (int right = 0; right < s.length(); right++){

                char ch = s.charAt(right);

                if (map.containsKey(ch)){
                    left = Math.max(left, map.get(ch) + 1);
                }

                map.put(s.charAt(right), right);
                // max값 갱신
                maxLength = Math.max(maxLength, right - left + 1);

            }

            return maxLength;
        }
    }

    class Solution3 {
        public int lengthOfLongestSubstring(String s) {

            if (s.length() == 0) return 0;

            int maxLength = 1;

            // two pointer 와 hash map 을 같이 사용하자.
            int left = 0;

            Set<Character> set = new HashSet<>();

            for (int right = 0; right < s.length(); right++){

                if (set.contains(s.charAt(right))){

                    // 중복이 없을때까지 left  포인터 이동
                    while(set.contains(s.charAt(right))){
                        set.remove(s.charAt(left));
                        left++;
                    }
                }

                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);



            }

            return maxLength;




        }
    }

}
