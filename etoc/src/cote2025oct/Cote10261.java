package cote2025oct;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Cote10261 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        // 첫째줄 : 문자열(길이는 N)
        // 둘째줄, 입력할 명령어의 개수(M)
        // 셋째줄부터 M 줄에 걸쳐 명령어가 주어짐.
        String inputStr = br.readLine();
        char[] charArray = inputStr.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for (char c : charArray){
            list.add(c);
        }
        ListIterator<Character> iterator = list.listIterator();
        // 커서를 문자열의 맨 뒤로 옮긴다.
        while (iterator.hasNext()){
            iterator.next();
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++){
            String operation = br.readLine();
            char op = operation.charAt(0);

            switch(op){

                case 'P':
                    char addChar = operation.charAt(2);
                    iterator.add(addChar);
                    // P 이면 뒤에 있는 문자를 커서 왼쪽에 추가
                    break;
                case 'L':
                    if (iterator.hasPrevious())  iterator.previous();
                    break;
                case 'D':
                    if (iterator.hasNext()) iterator.next();
                    break;
                case 'B':
                    if (iterator.hasPrevious()){
                        iterator.previous();
                        iterator.remove();
                    }
            }
        }
        // 커서 맨 앞으로 이동
        while (iterator.hasPrevious()){
            iterator.previous();
        }
        while (iterator.hasNext()){
            writer.write(iterator.next());
        }
        writer.flush();
    }
}
