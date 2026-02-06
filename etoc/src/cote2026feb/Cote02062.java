package cote2026feb;

public class Cote02062 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            // root 가 null 이거나, p , q 인경우
            if (root == null || root == p || root == q){
                return root;
            }


            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right , p, q);

            if (left != null && right != null){
                return root;
            }

            // 둘중 하나라도 null 이 나오는 경우.
            return left != null ? left : right;
        }
    }

}
