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
    boolean r=true;
    public boolean isValidBST(TreeNode root) {
        check(root,Long.MIN_VALUE, Long.MAX_VALUE);
        return r;

    }
    private boolean check(TreeNode node,long min,long max){
        if(node==null )return true;
        if(node.val<=min || node.val>=max){
            r=false;
        }
        return check(node.left,min,node.val) 
        && check(node.right,node.val,max);

    }
}
