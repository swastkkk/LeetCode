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
    int res=Integer.MIN_VALUE;
    int getSum(TreeNode root){
        if(root==null)
            return 0;
        int leftSum=Math.max(0,getSum(root.left));
        int rightSum=Math.max(0,getSum(root.right));
        res=Math.max(res,root.val+leftSum+rightSum);
        return root.val+Math.max(leftSum,rightSum);
    }
    public int maxPathSum(TreeNode root) {
        getSum(root);
        return res;
    }
}