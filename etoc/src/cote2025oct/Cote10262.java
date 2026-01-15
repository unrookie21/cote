package cote2025oct;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Cote10262 {


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

        // 스택을 사용하자.
        Deque<Character> leftStack = new ArrayDeque<>();
        Deque<Character> rightStack = new ArrayDeque<>();

        for (Character c : list) {
            leftStack.push(c);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++){
            String operation = br.readLine();
            char op = operation.charAt(0);

            switch(op){
                case 'P':
                    char ch = operation.charAt(2);
                    // 왼쪽 stack 에 push
                    leftStack.push(ch);
                    break;
                case 'L':
                    // 왼쪽 stack 에서 pop -> 오른쪽 stack 에 push
                    if (!leftStack.isEmpty()){
                        char poppedFromLeft = leftStack.pop();
                        rightStack.push(poppedFromLeft);
                    }
                    break;
                case 'D':
                    // 오른쪽 stack 에서 pop, 왼쪽 stack 에 push
                    if(!rightStack.isEmpty()){
                        char poppedFromRight = rightStack.pop();
                        leftStack.push(poppedFromRight);
                    }
                    break;
                case 'B':
                    // 왼쪽 stack pop
                    if (!leftStack.isEmpty()) leftStack.pop();
                    break;
            }
        }

        // 마지막 작업. left stack 모든 원소를 pop 하면서, 동시에
        // right stack 으로 push
        while (!leftStack.isEmpty()){
            char popped = leftStack.pop();
            rightStack.push(popped);
        }
        // right stack 의 모든 원소 pop 하면서 출력
        while(!rightStack.isEmpty()){
            writer.write(rightStack.pop());
        }
        writer.flush();
    }
}
