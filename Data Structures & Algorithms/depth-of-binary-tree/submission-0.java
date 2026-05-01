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
        int l=Math.max(check(node.left,h+1),h);
        int r=Math.max(check(node.right,h+1),h);

        return Math.max(l,r);
    }

}
