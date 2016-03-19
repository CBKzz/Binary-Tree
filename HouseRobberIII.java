/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
*/
public class Solution {
    /* This is an wrong answer
    public int rob(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        if(root==null) return 0;
        int prepre=0;
        int pre=0;
        stack.push(root);
        while(!stack.isEmpty()){
            int cur=0;
            Stack<TreeNode> temp=new Stack<>();
            for(TreeNode n:stack){
                cur=cur+n.val;
                if(n.left!=null) temp.add(n.left);
                if(n.right!=null) temp.add(n.right);
            }
            stack=temp;
            int ttemp=pre;
            pre=Math.max(pre,prepre+cur);
            prepre=ttemp;
        }
        return pre;
        
    }
    */
    /* This answer takes too long
    public int rob(TreeNode root){
        if(root==null) return 0;
        int left=0;
        int right=0;
        int left_child=0;
        int right_child=0;
        if(root.left!=null){
            left=rob(root.left);
            left_child=rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            right=rob(root.right);
            right_child=rob(root.right.left)+rob(root.right.right);
        }
        return Math.max(root.val+left_child+right_child,Math.max(left,left_child)+Math.max(right,right_child));
    }*/
    public int rob(TreeNode root){
        if(root==null) return 0;
        int[] a=subrob(root);
        return Math.max(a[0],a[1]);
    }
    public int[] subrob(TreeNode root){
        int[] result=new int[2];
        int[] left=new int[2];
        int[] right=new int[2];
        if(root.left!=null) left=subrob(root.left);
        if(root.right!=null) right=subrob(root.right);
        result[0]=root.val+left[1]+right[1];
        result[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return result;
    }
    
}
