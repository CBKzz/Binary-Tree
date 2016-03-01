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
        sub(root);
        return count;
    }
    public int sub(TreeNode root){
        if (root==null) {
            return 2;
        }
        int left=sub(root.left);
        int right=sub(root.right);
        if(left==2&&right==2) {
            count++;
            return 1;//it is 
        }
        if(left==0||right==0) return 0;
        if(left==1&&right==2){
            if(root.left.val==root.val) {
                count++;
                return 1;
            }
            return 0;
        }
        if(left==2&&right==1){
            if(root.right.val==root.val) {
                count++;
                return 1;
            }
            return 0;
        }
        if(root.right.val==root.val&&root.left.val==root.val){
            count++;
            return 1;
        }
        return 0;
        
    }
}
