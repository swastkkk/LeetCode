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
    int ind=0;
    TreeNode dfs(int preorder[],Map<Integer,Integer> map,int low,int high){
        if(low>high)
            return null;
        TreeNode root=new TreeNode(preorder[ind++]);
        int mid=map.get(preorder[ind-1]);
       
        root.left=dfs(preorder,map,low,mid-1);
        root.right=dfs(preorder,map,mid+1,high);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(inorder[i],i);
            int low=0,high=n-1;
        TreeNode root=dfs(preorder,map,low,high);
        return root;
    }
}