public class Cote01073 {

    static class Solution {
        public int search(int[] nums, int target) {

            // nums 는 오름차순 정렬되어 있다.

            // O(log n )만큼 걸리므로 binary search 가 적합하다.
            int left = 0;
            int right = nums.length - 1;

            while (left <= right){
                int mid = (left + right) / 2;

                if (nums[mid] == target){ // 타겟을 찾은 경우
                    return mid;
                } else if (nums[mid] > target){ // 타겟이 중간 값 보다 작은 경우
                    // 탐색 범위는 mid 왼쪽으로 축소되어야 한다.
                    right = mid - 1;
                } else{ // 타겟값이 중간 값 보다 큰 경우
                    // 탐석 범위는 mid 오른쪽으로 축소되어야한다.
                    left = mid + 1;
                }
            }

            // 탐색 실패시
            return -1;

        }
    }

}
