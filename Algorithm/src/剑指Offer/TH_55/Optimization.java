package 剑指Offer.TH_55;

/**
 * @ClassName Optimization
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/17 22:42
 * @Version 1.0
 */
public class Optimization {
    public boolean isBalanced(TreeNode root) {
        return depth(root) >= 0;//若平衡，返回高度，不平衡返回-1
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        int diff = left - right;
        if (left == -1 || right == -1 || Math.abs(diff) > 1) {//左子树不平衡、右子树不平衡、此节点左右子树不平衡
            return -1;
        } else {
            return Math.max(left, right) + 1;//返回高度
        }
    }
}
