import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Cote1104 {

    public static int answer = Integer.MIN_VALUE;

    public static void backtrack(List<Integer> cur, int[] nums, boolean[] visited){
        if (cur.size() == nums.length){
            int result = 0;
            for (int i = 0; i < cur.size() -1; i++){
                result += Math.abs(cur.get(i) - cur.get(i+1));
                answer = Math.max(answer, result);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (!visited[i]){
                cur.add(nums[i]);
                visited[i] = true;
                backtrack(cur, nums, visited);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        boolean[] visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        backtrack(new ArrayList<>(), nums, visited);
        System.out.print(answer);
    }
}
