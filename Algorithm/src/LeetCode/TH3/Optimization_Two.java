package LeetCode.TH3;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @ClassName Optimization_Two
 * @Description TODO:一次遍历+哈希表
 * 执行用时：
 * 7 ms, 在所有 Java 提交中击败了41.61%的用户
 * 内存消耗：
 * 38.5 MB, 在所有 Java 提交中击败了51.00%的用户
 * 通过测试用例：
 * 987 / 987
 * @Author sth_199509@163.com
 * @Date 2021/11/4 19:24
 * @Version 1.0
 */
public class Optimization_Two {
    @Test
    public void test(){
        int length = lengthOfLongestSubstring("abbbbbcbfdd");
        System.out.println(length);
    }

    /**
     * 哈希表存放字符和字符索引
     * 设置一个起始点 begin,一次遍历，若存在重复元素，将begin设置为重复元素下一个位置
     * 长度计算通过i - begin + 1即可
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int begin = 0;
        int resultMax = 0;
        for(int i = 0;i < s.length();i++){
            if(map.containsKey(s.charAt(i))){
                // 若存在重复元素，进入if 函数
                // 判断重复元素之前，的位置是不是比begin大，重新定义begin位置
                begin = Math.max(begin,map.get(s.charAt(i)) + 1);
            }
            // 将当前元素添加哈希表
            // 【因为所有元素都添加进去了，所以上边if要判断"相等元素"的地方，是不是在begin后边,在前边就不用管了】
            map.put(s.charAt(i),i);
            //判断此时的i 到 begin长度和之前保存的那个长
            resultMax = Math.max(resultMax,i - begin + 1);
        }
        return resultMax;
    }
}
