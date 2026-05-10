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
    int preIdx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return result(preorder,inorder,0,inorder.length-1);
    }
    private TreeNode result(int[] preorder,int[] inorder,int l,int r){
        if(l>r)return null;
        int rootvalue=preorder[preIdx++];
        TreeNode root=  new TreeNode(rootvalue);
        int c=check(inorder,l,r,rootvalue);
       
        root.left=result(preorder,inorder,l,c-1);
        root.right=result(preorder,inorder,c+1,r);
        return root;
    }
    private int check(int[] node,int l,int r,int v){
        for(int i=l;i<=r;i++){
            if(node[i]==v){
                return i;
            }

        }
        return -1;
    }

}
