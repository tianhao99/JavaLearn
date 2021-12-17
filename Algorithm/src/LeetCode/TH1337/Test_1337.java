package LeetCode.TH1337;

import java.util.Arrays;

public class Test_1337 {
    public static void main(String[] args) {
        Solution_1377 one = new Solution_1377();
        int[][] arry = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int[] result;
        result = one.kWeakestRows(arry, 3);
//        String ss = Arrays.toString(result);
        System.out.println(Arrays.toString(result));
    }
}
