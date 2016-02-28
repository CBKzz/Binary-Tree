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
    int i;
    int p;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        p=i=inorder.length-1;
        TreeNode root=new TreeNode(1);
        TreeNode temp=root;
        while(i>=0){
            temp.left=subBuild(inorder,postorder,postorder[i]);
            temp=temp.left;
        }
        return root.left;
    }
    public TreeNode subBuild(int[] in, int[] po, int stop){
        Stack<Integer> stack=new Stack<>();
        while(in[i]!=po[p]){
            stack.push(po[p]);
            p--;
        }
        TreeNode root=new TreeNode(po[p]);
        i--;
        p--;
        while(!stack.isEmpty()){
            if(stack.peek()==in[i]){
                TreeNode temp=root;
                root=new TreeNode(stack.pop());
                root.right=temp;
                i--;
            }
            else{
                root.left=subBuild(in, po,stack.peek());
            }
        }
        if(i>=0&&in[i]!=stop) root.left=subBuild(in,po,stop);
        return root;
    }
    
    
}
