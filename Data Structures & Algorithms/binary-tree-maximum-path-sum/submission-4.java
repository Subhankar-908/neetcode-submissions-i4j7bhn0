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
        MaxSum(root,0);
        return maxsum;
    }
    private int MaxSum(TreeNode node,int sum){
        if(node==null)return 0;
        int left=MaxSum(node.left,sum);
        int right=MaxSum(node.right,sum);
        if(left<0)left=0;
        if(right<0)right=0;
        sum=left+right+node.val;
        maxsum=Math.max(maxsum,sum);
        return node.val+Math.max(left,right);
    }
}
