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
    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        MaxSum(root);
        return maxsum;
    }
    private int MaxSum(TreeNode node){
        if(node==null)return 0;
        int left=MaxSum(node.left);
        int right=MaxSum(node.right);
        if(left<0)left=0;
        if(right<0)right=0;
        int sum=left+right+node.val;
        maxsum=Math.max(maxsum,sum);
        return node.val+Math.max(left,right);
    }
}
