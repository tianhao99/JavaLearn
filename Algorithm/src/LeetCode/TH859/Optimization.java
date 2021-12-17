package LeetCode.TH859;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Optimization
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/23 9:05
 * @Version 1.0
 */
public class Optimization {
    /**
     * 创建两个存储26个字母的int数组
     * 情况一：若存在两个能够交换，势必两个字符串中，每个字符出现的次数相同
     * 情况二：若两个字符串全部相同，判断是不是存在重复的元素
     * 其他情况：false
     */
    @Test
    public void test(){
        System.out.println(buddyStrings("ab", "ba"));
    }
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int count = 0;
        // 将字符串拆解，存入，相同元素位置++
        for (int i = 0; i < s.length(); i++) {
            // 字符串转换成索引，有一个就++
            int a = s.charAt(i) - 'a';
            int b = goal.charAt(i) - 'a';
            arr1[a]++;
            arr2[b]++;
            // 如果a、b不相同，表示该位置字符不同
            if (a != b) count++;
        }

        // 遍历，看是否存在相同
        boolean repeat = false;
        for (int i = 0; i < 26; i++) {
            // 情况一：有字符个数不相等，直接false
            if (arr1[i] != arr2[i]) return false;
            // 同一位置，数量大于1 ，表示有重复字符
            if (arr1[i] > 1) repeat = true;
        }

        // 到这里时，所有字符个数都是能对上的
        // 1、只要不同的个数是2，那就true，因为每个字符的数量都能对上，就看需要交换的元素有几个
        // 2、count==0，这时候就要看有没有重复元素
        return count == 2 || (count == 0 && repeat);
    }
}
