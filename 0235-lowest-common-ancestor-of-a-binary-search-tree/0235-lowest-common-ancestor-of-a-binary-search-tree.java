/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode LCA(TreeNode root,TreeNode p,TreeNode q){
        if(root.val==p.val || root.val==q.val)
            return root;
        if((root.val>p.val && root.val<q.val) || (root.val<p.val && root.val>q.val))
            return root;
        if(root.val>p.val && root.val>q.val)
            return LCA(root.left,p,q);
        return LCA(root.right,p,q);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root,p,q);
    }
}