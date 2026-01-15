package cote2025oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cote10092 {
    static Set<String> anagrams;
    static char[] chars;
    static char[] result;
    static boolean[] visited;

    public static void DFS(int depth){
        if (depth == chars.length){
            anagrams.add(new String(result));
            return;
        }

        for (int i = 0; i < chars.length; i++){
            if (visited[i]) continue;
            if (i > 0 && chars[i] == chars[i-1] && !visited[i-1]) continue;

            visited[i] = true;
            result[depth] = chars[i];
            DFS(depth + 1);
            visited[i] = false;
        }

    }
    // 첫째 줄 단어개수 N
    // 둘째 줄부터 N 개 영단어 주어짐.
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 1; i++){
            String word = br.readLine();

            anagrams = new TreeSet<>();
            chars = word.toCharArray();
            Arrays.sort(chars);
            result = new char[chars.length];
            visited = new boolean[chars.length];

            DFS(0);

            for (String anagram : anagrams){
                sb.append(anagram).append("\n");
            }
        }
        System.out.print(sb);
    }
}
