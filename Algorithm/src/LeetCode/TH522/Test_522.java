package LeetCode.TH522;

/**
 * @ClassName Test_522
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/22 0:03
 * @Version 1.0
 */
public class Test_522 {
    public static void main(String[] args) {
        Solution_522 solution_522 = new Solution_522();
//        String[] strs = new String[]{"aaa","aaa","bbb","bbb","cc"};
        String[] strs = new String[]{"aba","cdc","eae"};
//        String[] strs = new String[]{"aba","cdc","eae"};


        int luSlength = solution_522.findLUSlength(strs);
        System.out.println(luSlength);
    }
}
