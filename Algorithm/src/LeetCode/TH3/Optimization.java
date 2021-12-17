package LeetCode.TH3;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @ClassName Optimization
 * @Description TODO:哈希表
 * 执行用时：
 * 74 ms, 在所有 Java 提交中击败了11.23%的用户
 * 内存消耗：
 * 39.2 MB, 在所有 Java 提交中击败了5.10%的用户
 * 通过测试用例：
 * 987 / 987
 * @Author sth_199509@163.com
 * @Date 2021/11/4 19:02
 * @Version 1.0
 */
public class Optimization {
    @Test
    public void test(){
        int length = lengthOfLongestSubstring("abbbbbcbfdd");
        System.out.println(length);
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int temp,step;
        int result = 0;
        for(int i = 0;i < s.length();i++){
            temp = i + 1;
            step = 1;
            map.put(s.charAt(i),1);
            while( temp < s.length() && map.get(s.charAt(temp)) == null){
                map.put(s.charAt(temp),1);
                temp++;
                step++;
            }
            map.clear();
            result = Math.max(result,step);
        }
        return result;
    }
}
