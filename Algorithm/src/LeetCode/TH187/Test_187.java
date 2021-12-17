package LeetCode.TH187;

import java.util.List;

/**
 * @ClassName Test_187
 * @Description TODO:测试力扣187
 * @Author sth_199509@163.com
 * @Date 2021/10/8 21:47
 * @Version 1.0
 */
public class Test_187 {
    public static void main(String[] args) {

        Solution_187 solution_187 = new Solution_187();
        List<String> result1 = solution_187.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        List<String> result2 = solution_187.findRepeatedDnaSequences("AAAAAAAAAAA");

        System.out.println(result1);
        System.out.println(result2);
    }

}
