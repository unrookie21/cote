class Node{
    int data;
    Node lt;
    Node rt;
    public Node(int data){
        this.data = data;
        lt = null;
        rt = null;
    }
}


public class Cote10172 {

    Node root;

    public void DFS(Node root){
        if (root == null) return;
        else{
            System.out.print(root.data); // 전위순회
            DFS(root.lt);
            System.out.print(root.data); // 중위순회
            DFS(root.rt);
            System.out.print(root.data); // 후위 순회
        }

    }


    public static void main(String[] args) {
        Cote10172 tree = new Cote10172();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.DFS(tree.root);

    }
}
