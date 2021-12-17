package LeetCode.TH384;

import java.util.Arrays;

/**
 * @ClassName Test_384
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/22 8:22
 * @Version 1.0
 */
public class Test_384 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Solution_384 solution_384 = new Solution_384(arr);
        int[] reset = solution_384.reset();
        int[] shuffle = solution_384.shuffle();
        System.out.println(Arrays.toString(reset));
        System.out.println(Arrays.toString(shuffle));
    }

}
