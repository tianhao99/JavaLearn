package LeetCode.TH4;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution_4
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/18 12:21
 * @Version 1.0
 */
public class Solution_4 {
    @Test
    public void test(){
        int[] nums1 = {1,1,2,2};
        int[] nums2 = {1,1,2,2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        // 递增序列，不论是奇是偶，在len / 2 位置的都是中位数 这里要求偶数取一半/2
        for (int i = 0; i <= len / 2; i++) {
            left = right;// 记录前一个值
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                // aStart没遍历完< m       并且     nums1的值小或者nums2遍历完了，没了
                // 此时继续遍历nums1
                right = nums1[aStart++];
            } else {
                // 条件相当于【aStrat >=m || (bStart < n && nums1[aStart] > nums2[bStart])】
                // nums1没了，或者nums2 < nums1 并且bStart要小于n
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0)// 若是偶数，取前一个值和现值除2
            return (left + right) / 2.0;
        else
            return right;

    }
}
