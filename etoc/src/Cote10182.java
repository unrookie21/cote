import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 송아지 찾기
// ch 배열을 두어서, O(n^2) 의 사간복잡도를 피하도록 한다.
public class Cote10182 {

    static Queue<Integer> Q = new LinkedList<>();
    static int[] dist = {1,-1,5};
    static int[] ch = new int[10001];

    public int BFS(int s, int e){
        Q.offer(s);
        int L = 0;
        ch[s] = 1;
        while (!Q.isEmpty()){
            int len = Q.size();
            for (int i = 0 ; i < len; i++){
                int cur = Q.poll();
                if (cur == e) return L;
                for (int operation : dist){
                    int newS = cur + operation;
                    if (newS >=1 && newS <= 10000 && ch[newS] == 0){
                        ch[newS] = 1;
                        Q.offer(newS);
                    }
                }
            }
            L++;
        }

        return -1;
    }
    public static void main(String[] args) {

        Cote10182 T = new Cote10182();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(T.BFS(s,e));

    }
}
