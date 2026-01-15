package cote2025oct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Cote10173 {

    static class Node{
        char data;
        Node lt;
        Node rt;
        public Node(char data){
            this.data = data;
            lt = rt = null;
        }
    }

    static void preOrder(Node root){
        if (root == null) return;
        System.out.print(root.data);
        preOrder(root.lt);
        preOrder(root.rt);
    }
    static void inOrder(Node root){
        if (root == null) return;
        inOrder(root.lt);
        System.out.print(root.data);
        inOrder(root.rt);
    }
    static void postOrder(Node root){
        if (root == null) return;
        postOrder(root.lt);
        postOrder(root.rt);
        System.out.print(root.data);
    }

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Map<Character, Node> map = new HashMap<>();

        for (int i = 0; i < N; i++){
            String[] inputs = br.readLine().split(" ");
            char parent =  inputs[0].charAt(0);
            char left = inputs[1].charAt(0);
            char right = inputs[2].charAt(0);

            // MAP 초기화
            if (!map.containsKey(parent)){
                map.put(parent, new Node(parent));
            }

            // 왼쪽 자식
            if (left != '.'){
                if (!map.containsKey(left)){
                    map.put(left, new Node(left));

                }
                map.get(parent).lt = map.get(left);
            }


            // 오른쪽 자식
            if (right != '.'){
                if (!map.containsKey(right)){
                    map.put(right, new Node(right));

                }
                map.get(parent).rt = map.get(right);
            }

        }

        Node root = map.get('A');
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);




    }
}
