package cote2026jan;

public class Cote01152 {

    static class Solution {
        public int trap(int[] height) {

            // height 길이가 3보다 작으면 물이 고일 수 없음
            if (height.length < 3) return 0;

            int trapNumber = 0;

            // two pointer
            int left = 0;
            int right = height.length - 1;

            int leftMax = height[left];
            int rightMax = height[right];

            while (left < right){
                if (leftMax <= rightMax){
                    // 물 배치할 수 있는 가능성이 생겼으므로.. left 를 오른쪽으로 열어본다.
                    left++;
                    leftMax = Math.max(leftMax, height[left]);
                    trapNumber += leftMax - height[left];


                } else {
                    // 왼쪽으로 물 배치할 수 있는 가능서이 생겼으므로, right 를 왼쪽으로 까본다.
                    right--;
                    rightMax = Math.max(rightMax, height[right]);
                    trapNumber += rightMax - height[right];
                }
            }

            return trapNumber;
        }


    }
}
