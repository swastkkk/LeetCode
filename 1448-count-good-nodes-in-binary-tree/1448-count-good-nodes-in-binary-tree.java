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
    int count=0;
    void DFS(TreeNode root,int currentMax){
        if(root==null)
            return;
        if(root.val>=currentMax){
            count++;
            currentMax=root.val;
        }
           
        DFS(root.left,currentMax);
        DFS(root.right,currentMax);
    }
    public int goodNodes(TreeNode root) {
        if(root==null)
            return 0;
        int currentMax=root.val;
        DFS(root,currentMax);
        return count;
    }
}