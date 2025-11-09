import java.io.IOException;
import java.util.*;
import java.io.*;
public class Cote1108 {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // tc 개수
        for (int i = 0; i < T; i++){

            Map<Integer, List<Integer>> tree = new HashMap<>();

            int N = Integer.parseInt(br.readLine()); // 노드 수
            for (int j = 0; i < N-1; i++){
                // 간선 개수
                // 인접 리스트 할당
                String[] edge = br.readLine().split(" ");
                int parent = Integer.parseInt(edge[0]);
                int child = Integer.parseInt(edge[1]);

                tree.putIfAbsent(parent, new ArrayList<>());
                tree.get(parent).add(child);
            }





        }


    }
}
