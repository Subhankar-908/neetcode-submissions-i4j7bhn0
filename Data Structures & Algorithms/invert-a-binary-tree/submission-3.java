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
        if(node==null)return null;
            TreeNode rr=node.right;
            node.right=node.left;
            node.left=rr;
        
        convert(node.left);
        convert(node.right);

        return node;
    }
}
