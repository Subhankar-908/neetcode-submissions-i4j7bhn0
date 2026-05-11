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
        //base case
        if(node==null)return 0;

        //recursive call to move left and right node
        int left=MaxSum(node.left);
        int right=MaxSum(node.right);

        //check node value positive or not
        if(left<0)left=0;
        if(right<0)right=0;

        //sum of current node or leaf node
        int sum=left+right+node.val;
        //maxsum check
        maxsum=Math.max(maxsum,sum);
        //return max value path
        return node.val+Math.max(left,right);
    }
}
