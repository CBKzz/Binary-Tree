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
    int i=-1;//preorder
    int j=0;//inorder
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=new TreeNode(1);
        TreeNode temp=root;
        while(j<inorder.length){
            temp.right=right(preorder, inorder,preorder[j]);
            temp=temp.right;
        }
        return root.right;
    }
    public TreeNode right(int[] preorder, int[] inorder,int stop){//deal with inorder until we meet stop
        Stack<Integer> stack=new Stack<>();
        do{
            stack.push(preorder[++i]);
        }while(preorder[i]!=inorder[j]);
        TreeNode root=new TreeNode(stack.pop());
        j++;
        while(!stack.isEmpty()){
            if(stack.peek()==inorder[j]) {
                TreeNode temp=root;
                root=new TreeNode(stack.pop());
                root.left=temp;
                j++;
            }
            else{
                root.right=right(preorder,inorder,stack.peek());
            }
        }
        if(j<preorder.length&&inorder[j]!=stop) root.right=right(preorder,inorder,stop);
        return root;
        
    }
}
