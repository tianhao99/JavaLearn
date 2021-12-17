package LeetCode.TH496;

import java.util.Arrays;

/**
 * @ClassName Test_496
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/26 19:13
 * @Version 1.0
 */
public class Test_496 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,4};
        int[] nums2 = new int[]{1,2,3,4};
//        Solution_496 solution_496 = new Solution_496();
//        int[] result = solution_496.nextGreaterElement(nums1, nums2);
        Optimization optimization = new Optimization();
        int[] result = optimization.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
