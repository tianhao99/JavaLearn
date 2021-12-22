package LeetCode.TH423;



import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @ClassName Solution_423
 * @Description TODO:通过一个唯一字符代替一个单词，如seven，有1个v势必有1个7，
 *         数组中存的就是个数
 *         cnt[0] = c.getOrDefault('z', 0);
 *         cnt[2] = c.getOrDefault('w', 0);
 *         cnt[4] = c.getOrDefault('u', 0);
 *         cnt[6] = c.getOrDefault('x', 0);
 *         cnt[8] = c.getOrDefault('g', 0);
 *
 *         cnt[3] = c.getOrDefault('h', 0) - cnt[8];因为找不到唯一元素，只能找重复元素，要筛掉上边已经统计出来的
 *         cnt[5] = c.getOrDefault('f', 0) - cnt[4];
 *         cnt[7] = c.getOrDefault('s', 0) - cnt[6];
 *
 *         cnt[1] = c.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];
 *
 *         cnt[9] = c.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];
 * @Author sth_199509@163.com
 * @Date 2021/11/24 0:14
 * @Version 1.0
 */
public class Solution_423 {
    @Test
    public void test(){
        long start = System.currentTimeMillis();
        System.out.println(originalDigits("zeroonetwothreefourfivesixseveneightnine"));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public String originalDigits(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int str = s.charAt(i) - 'a';
            arr[str]++;
        }
        int[] nums = new int[10]; // 存数字的具体个数，1存在nums[1]里面 其他同理
        nums[0] = arr['z' - 'a'];
        nums[2] = arr['w' - 'a'];
        nums[4] = arr['u' - 'a'];
        nums[6] = arr['x' - 'a'];
        nums[8] = arr['g' - 'a'];
        // 涉及到重复元素了
        nums[3] = arr['h' - 'a'] - nums[8];
        nums[5] = arr['f' - 'a'] - nums[4];
        nums[7] = arr['s' - 'a'] - nums[6];
        nums[1] = arr['o' - 'a'] - nums[0] - nums[2] - nums[4];
        nums[9] = arr['i' - 'a'] - nums[5] - nums[6] - nums[8];
        String result = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < nums[i]; j++) {
                result = result + i;
            }
        }
        return result;
    }
}
