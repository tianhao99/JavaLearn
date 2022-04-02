package LeetCode.TH238;

import java.awt.im.InputMethodRequests;

/**
 * @ClassName Solution
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2022/1/28 12:05 AM
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        for (int i : productExceptSelf(arr)) {
            System.out.print(i + "\t");
        }

    }

    /**
     * 常规：两个数组，一个i位置保存i左侧所有数乘积，另一个数组保存i右侧所有数的乘积，最后一次遍历两个数组res[i] = a[i] * b[i],
     * 优化：主要优化空间，直接用res保存左侧所有数乘积，右侧遍历时用一个变量rightNum保存右边的乘积，然后直接res[i] *= rightNUm;即可
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // There is no product on the left side at the beginning,res[0] = 1;
        res[0] = 1;
        for(int i = 1;i < n; i++){
            res[i] =  res[i-1] * nums[i-1];
        }
        // There is no product on the right side at the beginning,rightNum = 1;;
        int rightNum = 1;
        for(int i = n-2; i >= 0;i--){
            // The product of all numbers on the right
            rightNum *= nums[i+1];
            // result
            res[i] *= rightNum;
        }
        return res;

    }
}
