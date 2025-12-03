import java.util.*;

public class Cote12031 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 특정 구간 내에 몇명의 병정이 배치되어있는지 계산

        int N = sc.nextInt(); // 병정의 수
        int Q = sc.nextInt(); // 하트 여왕의 질문 수

        int[] places = new int[N];
        for (int i = 0 ; i < N; i++){
            places[i] = sc.nextInt();
        }

        int[][] questions = new int[Q][2];

        for (int i = 0; i < Q; i++){
            for (int j = 0; j < 2; j++){
                questions[i][j] = sc.nextInt();
            }
        }
        // 정렬후,
        Arrays.sort(places);
        // 이분탐색
        for (int i = 0; i < Q; i++){
            int[] question = questions[i];
            int a = question[0];
            int b = question[1];

            // ex) a = 3, b = 9라고 해보자.
            // places = [1,3,5,7,9,11]
            // 답은 index(5) - index(1) = 4 가 나와야한다.

            int left = lower(places, a); // a 이상인 수의 첫 인덱스 구하기
            int right = upper(places, b); // b 를 초과하는 수의 첫 인덱스 구하기

            System.out.println(right - left);
        }
    }

    public static int lower (int[] places, int target){
        int left = 0;
        int right = places.length - 1;
        int result = places.length;

        while (left <= right){
            int mid = (left + right) / 2;

            if (places[mid] >=  target){ // target 보다 크면
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }

        }

        return result;
    }

    public static int upper (int[] places, int target){
        int left = 0;
        int right = places.length - 1;
        int result = places.length;

        while (left <= right){
            int mid = (left + right) / 2;

            if (places[mid] >  target){ // target 보다 크면
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }

        }
        return result;
    }
}
