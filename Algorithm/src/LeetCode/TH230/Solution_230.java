package LeetCode.TH230;

/**
 * @ClassName Solution_230
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/17 20:20
 * @Version 1.0
 */

import java.util.Stack;


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
       this.right = right;
    }
}

public class Solution_230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){//当栈不空，或者树不是空节点时，进入循环【空树不会进入】
            if (root != null){//节点非空，进栈
                stack.push(root);
                root = root.left;//继续向左走
            }else{
                root = stack.pop();//节点空，出栈
                k -= 1;//相应的遍历操作
                if (k == 0)
                    break;
                root = root.right;//因为该节点已经遍历过，直接向右走
            }
        }
        return root.val;
    }
}

