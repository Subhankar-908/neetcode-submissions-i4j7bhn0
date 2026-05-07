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
    int c=0;
    public int goodNodes(TreeNode root) {
        return check(root,root.val);
    }
    private int check(TreeNode node,int Nvalue){
        if(node==null)return 0;
        if(Nvalue<=node.val){
            Nvalue=node.val;
            c++;
        }
        check(node.left,Nvalue);
        check(node.right,Nvalue);
        return c;
    }
}
