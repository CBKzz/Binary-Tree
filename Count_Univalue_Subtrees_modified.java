/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int count=0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root!=null) sub(root);
        return count;
    }
    public boolean sub(TreeNode root){
        if(root==null) return true;
        boolean right=sub(root.right);
        boolean left=sub(root.left);
        int leftval=root.left==null?root.val:root.left.val;
        int rightval=root.right==null?root.val:root.right.val;
        if(left&&right&&(root.val==leftval)&&(root.val==rightval))
        {
            count++;
            return true;
        }
        
        return false;
    }
}
