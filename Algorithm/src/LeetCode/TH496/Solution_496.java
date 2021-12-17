package LeetCode.TH496;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_496
 * @Description TODO:496. 下一个更大元素 I
 * 给你两个 没有重复元素 的数组  nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * @Author sth_199509@163.com
 * @Date 2021/10/26 19:13
 * @Version 1.0
 */
public class Solution_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        outer:
        for (int i = 0; i < nums1.length; i++) {
            boolean isFlag = false;
            inner:
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]){
                    isFlag = true;
                    continue inner;
                }
                if (isFlag && nums1[i] < nums2[j]){
                    nums1[i] = nums2[j];
                    continue outer;
                }
            }
            nums1[i] = -1;
        }
        return nums1;
    }
}
