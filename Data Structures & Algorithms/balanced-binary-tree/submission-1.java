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
    public boolean isBalanced(TreeNode root) {
     
        return check(root);
    }
    private boolean check(TreeNode node){
        if(node==null)return true;
        int l=hight(node.left);
        int r=hight(node.right);
        if(Math.abs(l-r)>1){
            return false;
        }
        
        
        return check(node.left) && check(node.right);
    }
    private int hight(TreeNode node){
        if (node==null)return 0;
        return 1+Math.max(hight(node.left),hight(node.right));
    }
}
