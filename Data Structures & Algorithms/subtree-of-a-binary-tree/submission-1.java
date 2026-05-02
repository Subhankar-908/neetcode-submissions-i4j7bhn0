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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return check(root,subRoot);
    }
    private boolean check(TreeNode p,TreeNode q){
        if(p==null)return false;
        
        if(balence(p,q)){
            return true;
        }
        return check(p.left,q) || check(p.right,q);
    }
    private boolean balence(TreeNode p,TreeNode q){
        if(p==null && q==null)return true;
        if((p==null || q==null) || (p.val!=q.val))return false;
        return balence(p.left,q.left) && balence(p.right,q.right);

    }
}
