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
    public List<Integer> rightSideView(TreeNode root) {
        return find(root);
    }
    private List<Integer> find(TreeNode node){
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> result=new ArrayList<>();
        if(node==null)return result;
        q.offer(node);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                l.add(curr.val);
                if(curr.left!=null)q.offer(curr.left);
                if(curr.right!=null)q.offer(curr.right);

            }
            result.add(l.get(l.size()-1));
        }
        return result;
    }
}
