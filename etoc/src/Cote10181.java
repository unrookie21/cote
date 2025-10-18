import java.util.LinkedList;
import java.util.Queue;

public class Cote10181 {

    static class Node{
        int data;
        Node lt, rt;
        public Node(int data){
            this.data = data;
            lt = rt = null;
        }

    }

    Node root;
    public void BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()){
            int len = Q.size();
            for (int i = 0; i < len; i++){
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                // 부모 노드에 연결된, 왼쪽 자식과 오른쪽 자식을 큐에 넣어야한다.
                if (cur.lt != null) Q.offer(cur.lt);
                if (cur.rt != null) Q.offer(cur.rt);
            }
            L++;
            System.out.println();

        }
    }

    public static void main(String[] args) {

        Cote10181 tree = new Cote10181();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}
