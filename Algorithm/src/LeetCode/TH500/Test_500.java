package LeetCode.TH500;

import java.util.Arrays;

/**
 * @ClassName Test_500
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/31 23:38
 * @Version 1.0
 */
public class Test_500 {
    public static void main(String[] args) {
        Solution_500 solution_500 = new Solution_500();
        String[] strings = {"Hello", "Alaska", "Dad", "Peace"};
        String[] words = solution_500.findWords(strings);
        System.out.println(Arrays.toString(words));
    }
}
