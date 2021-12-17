package LeetCode.TH3;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_3
 * @Description TODO:列表
 * 执行用时：
 * 577 ms, 在所有 Java 提交中击败了5.02%的用户
 * 内存消耗：
 * 38.6 MB, 在所有Java 提交中击败了35.22%的用户
 * 通过测试用例：
 * 987 / 987
 * @Author sth_199509@163.com
 * @Date 2021/11/4 18:49
 * @Version 1.0
 */
public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        int temp,step;
        int result = 0;
        for(int i = 0;i < s.length();i++){
            temp = i + 1;
            step = 1;
            list.add(s.charAt(i));
            while( temp < s.length() && !list.contains(s.charAt(temp))){
                list.add(s.charAt(temp));
                temp++;
                step++;
            }
            list.clear();
            result = Math.max(result,step);
        }
        return result;
    }
}
