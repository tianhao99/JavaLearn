package LeetCode.TH441;

/**
 * @ClassName Solution_441
 * @Description TODO:
 * 你总共有N枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 *
 * 给你一个数字n ，计算并返回可形成 完整阶梯行 的总行数。
 *
 * @Author sth_199509@163.com
 * @Date 2021/10/10 21:54
 * @Version 1.0
 */
public class Solution_441 {
    public int arrangeCoins(int n) {
        //不支持大数开方，失败
        double result = (Math.sqrt(1+(long)8*n)-1)/2;
        System.out.println(result);
        return (int)Math.floor(result);

    }
}
