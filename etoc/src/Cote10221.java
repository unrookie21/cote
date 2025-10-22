import java.util.Scanner;

/**
 * 합이 같은 부분집합(DFS)
 *
 * 궁금했던 점과 그것에 대한 정리
 * visited 같은 방문배열은 언제 사용하는 걸까? 이런 부분집합 문제에서는 사용하지 않았는데..
 * 중복을 허용하지 않는 순열을 만드는 문제에서는 , visited 배열이 필요했음.
 * 왜냐하면 DFS 탐색이 이루어질때, L 단계에서 L+1 단계로 내려갈때, 뻗을 수 있는 가지의 범위가 1~N까지였음.
 * L+1 단게에서 L+2 단계로 내려갈때도, 뻗을 수 있는 가지가 1~N까지임.
 * visited 배열을 두지않는다면 중복 값을 계속사용하면서 탐색하기 때문에.. visited 가 필요한 것이었고..
 * 이번 문제처럼 부분집합과 관련된 문제는, 한 노드에서 아래 노드로 가지가 뻗는 경우가 "원소를 포함하냐" "포함하지 않느냐"
 * 로 나누어지는 상황임. L 단계에서 L+1 단계로 내려갈때 1을 선택했다면, L+1 에서 L+2 단계로 내려갈때 1을 다시 선택할 일은
 * 존재하지 않음. 중복 값을 사용할 일 자체가 없기 때문에 visited 배열이 필요가 없음.
 */
public class Cote10221 {

    static int N;
    static int[] arr;
    static int total = 0;
    static String answer = "NO";

    public void DFS(int L, int sum){

        if (L == N){
            if (sum == total - sum){
                answer = "YES";
            }
        } else{
            DFS(L+1, sum + arr[L]); // arr[L] 을 포함해서 탐색한다.
            DFS(L+1, sum); // arr[L] 을 포함하지 않고 탐색한다.
        }

    }

    public static void main(String[] args) {

        Cote10221 T = new Cote10221();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        T.DFS(0,0);
        System.out.println(answer);
    }
}
