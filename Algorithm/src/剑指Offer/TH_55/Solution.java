package 剑指Offer.TH_55;


/**
 * @ClassName Solution
 * @Description TODO:
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * @Author sth_199509@163.com
 * @Date 2021/10/17 22:10
 * @Version 1.0
 */
//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int diff = left - right;
        if (diff > 1 || diff < -1)
            return false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    //二叉树深度递归
    public int treeDepth(TreeNode root){
        if (root == null)
            return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return (left > right) ? left + 1 : right +1;
    }
}
