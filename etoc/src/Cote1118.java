import java.util.*;

class Cote1118 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;

        int left = 0;
        int right = people.length - 1;

        while (left <= right){

            if (people[left] + people[right] <= limit){
                // 가벼운 사람을 무거운 사람과함께 태울 수 있다면, 가벼운 사람은 태운다.
                left++;
            }
            // 무거운 사람은 무조건 태우기.
            right--;
            answer++; // 배 출발.

        }

        return answer;
    }
}