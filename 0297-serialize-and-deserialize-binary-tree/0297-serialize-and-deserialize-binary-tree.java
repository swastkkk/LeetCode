/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    TreeNode root;
    // Encodes a tree to a single string.
    
    public String serialize(TreeNode root) {
        StringBuilder str=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if(temp!=null){
                queue.add(temp.left);
                queue.add(temp.right);
                str.append(String.valueOf(temp.val)+" ");
            }
            else{
                str.append("# ");
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String str[]=(data.trim()).split(" ");
        int count=1;
        Queue<TreeNode> queue=new LinkedList<>();
        if(str[0].equals("#"))
            return null;
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        TreeNode dummy=root;
        queue.add(root);
        while(!queue.isEmpty() && count<str.length){
            TreeNode temp=queue.poll();
            if(!str[count++].equals("#"))
                temp.left=new TreeNode(Integer.parseInt(str[count-1]));
            if(!str[count++].equals("#"))
                temp.right=new TreeNode(Integer.parseInt(str[count-1]));
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
            queue.add(temp.right);
        }
        return dummy;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));