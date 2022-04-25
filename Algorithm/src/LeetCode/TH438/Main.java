package LeetCode.TH438;

import java.util.List;

/**
 * @ClassName Main
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2022/4/5 16:13
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.findAnagrams("cbaebabacd","abc");
        for(Integer r : res){
            System.out.println(r);
        }
    }
}
