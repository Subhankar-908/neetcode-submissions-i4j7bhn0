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
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        return check(root,0);

    }
    private int check(TreeNode node,int h){
        if(node==null){
            return h;
        }
        int l=check(node.left,h+1);
        int r=check(node.right,h+1);

        return Math.max(l,r);
    }

}
