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
    public TreeNode invertTree(TreeNode root) {
        
        return convert(root);
    }
    private TreeNode convert(TreeNode node){
        if(node!=null){
             TreeNode r=node.right;
             TreeNode l=node.left;
            node.right=l;
            node.left=r;
            convert(l);
            convert(r);
        }
           

        return node;
    }
}
