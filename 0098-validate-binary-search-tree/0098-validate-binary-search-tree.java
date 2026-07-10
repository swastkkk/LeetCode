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
    boolean isValid(TreeNode root,long curr,long max){
        if(root==null)
            return true;
        if(!(root.val>curr && root.val<max))
            return false;
        return isValid(root.right,root.val,max) && isValid(root.left,curr,root.val);
    }
    public boolean isValidBST(TreeNode root) {
           return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
}
}