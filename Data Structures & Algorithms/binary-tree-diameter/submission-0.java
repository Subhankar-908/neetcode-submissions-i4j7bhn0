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
    int Diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        check(root);
        return Diameter;
    }
    private int check(TreeNode node){
        if(node==null)return 0;

        int l=check(node.left);
        int r=check(node.right);
        Diameter=Math.max(Diameter,l+r);
        return 1+Math.max(l,r);
    }
}
