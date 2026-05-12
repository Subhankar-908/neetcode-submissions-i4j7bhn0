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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return  s(root,"");
    }
    private String s(TreeNode node,String t){
        if(node==null){
            
            return t+"N,";
        }
        return node.val+","+s(node.left,t)+s(node.right,t);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr=data.split(",");
        return ds(arr);
    }
    int i=0;
    private TreeNode ds(String[] arr){
        if(arr[i].equals("N")){
            i++;
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(arr[i++]));
        node.left=ds(arr);
        node.right=ds(arr);
        return node;
    }
}
