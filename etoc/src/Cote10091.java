import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cote10091 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

     // HashMap 초기화
        Map<Integer, Boolean> map = new HashMap<>(28);


         for (int i = 0; i < 28; i++){
             map.put(Integer.parseInt(st.nextToken()), true);
             if (i != 27)  st = new StringTokenizer(br.readLine());

        }

         List<Integer> list = new ArrayList<>();
         for (int i = 1; i <= 30; i++){
             if (!map.containsKey(i)) list.add(i);
         }

        for (int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
            if (i != list.size() - 1) sb.append("\n");
        }

        System.out.print(sb);


    }
}
