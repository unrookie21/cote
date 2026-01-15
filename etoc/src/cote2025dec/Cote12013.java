package cote2025dec;

import java.util.*;
import java.io.*;

public class Cote12013 {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{

        Character answer = 0;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String inputStr = sc.next();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < inputStr.length(); i++){
            Character key = inputStr.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (Character key : map.keySet()){
            if (map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }

        System.out.println(answer);


    }


}
