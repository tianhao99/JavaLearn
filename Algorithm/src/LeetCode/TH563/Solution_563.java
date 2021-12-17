package LeetCode.TH563;

import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 * @ClassName Solution_563
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/18 11:44
 * @Version 1.0
 */
class TreeNode1 {
     int val;
     TreeNode1 left;
     TreeNode1 right;
     TreeNode1() {}
     TreeNode1(int val) { this.val = val; }
     TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

public class Solution_563 {
    int ans = 0;

    public int findTilt(TreeNode1 root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode1 node) {
        if (node == null) {
            return 0;
        }
        int sumLeft = dfs(node.left);
        int sumRight = dfs(node.right);
        ans += Math.abs(sumLeft - sumRight);
        return sumLeft + sumRight + node.val;
    }


}
