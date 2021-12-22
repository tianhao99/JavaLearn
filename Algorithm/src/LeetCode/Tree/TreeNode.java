package LeetCode.Tree;

import apple.laf.JRSUIUtils;

import java.util.Queue;

/**
 * @ClassName createTree
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/12/21 1:40 AM
 * @Version 1.0
 */
public class TreeNode {
    // Fields
    int val;
    TreeNode left;
    TreeNode right;
    // Constructors
    public void TreeNode(){};
    public void TreeNode(int val){
        this.val = val;
    }
    public void TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
