package LeetCode.TH260;

import java.util.Arrays;

/**
 * @ClassName Test_260
 * @Description TODO:哈希表解决
 * @Author sth_199509@163.com
 * @Date 2021/10/30 21:22
 * @Version 1.0
 */
public class Test_260 {
    public static void main(String[] args) {
        Soultion_260 soultion_260 = new Soultion_260();
        Optimization optimization = new Optimization();
        int[] arr = new int[]{1,2,1,3,2,5};
        int[] ints = soultion_260.singleNumber(arr);
        int[] ints1 = optimization.singleNumber(arr);
        System.out.println(Arrays.toString(ints1));

        int xorsum = 0;
        for (int num : arr) {
            xorsum ^= num;
            System.out.println(xorsum);
        }

    }
}
