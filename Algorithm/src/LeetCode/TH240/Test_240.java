package LeetCode.TH240;

/**
 * @ClassName Test_240
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/25 10:16
 * @Version 1.0
 */
public class Test_240 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6}};
        arr[0][0] = -5;
        Solution_240 solution_240 = new Solution_240();
        boolean b = solution_240.searchMatrix(arr, 5);
        System.out.println(b);
    }
}
