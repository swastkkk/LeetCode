/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int height(TreeNode root){
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    int diameter(TreeNode root){
        if(root==null)
            return 0;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        int diaRoot=leftHeight+rightHeight;
        return(Math.max(diaRoot,Math.max(diameter(root.left),diameter(root.right))));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root);
    }
}