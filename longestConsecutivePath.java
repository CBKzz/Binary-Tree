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
    public int longestConsecutive(TreeNode root) {
        int[] result=sub(root);
        return Math.max(result[0],result[1]);
    }
    public int[] sub(TreeNode root) {
        int[] result=new int[2];
        if(root==null) return result;
        int right1=1;//inculde this node
        int right2=0;//exclude this node
        int left1=1;//include this node
        int left2=0;//exclude this node
        if(root.right!=null) {
            int[] l=sub(root.right);
            if(root.right.val==root.val+1){
                right1=l[0]+1;
                right2=l[1];
            }
            else{
                right2=Math.max(l[0],l[1]);
                right1=1;
            }
        }
        if(root.left!=null) {
            int[] l=sub(root.left);
            if(root.left.val==root.val+1){
                left1=l[0]+1;
                left2=l[1];
            }
            else{
                left2=Math.max(l[0],l[1]);
                left1=1;
            }
        }
        
        result[0]=Math.max(right1,left1);
        result[1]=Math.max(left2,right2);
        return result;
    }
}
