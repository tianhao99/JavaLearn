package LeetCode.TH8;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Optimization
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/24 12:44
 * @Version 1.0
 */
public class Optimization {
    @Test
    public void test(){
        System.out.println(myAtoi("    -478"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("with 4193 with words"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("9223372036854775808999"));
        System.out.println(myAtoi("-922337203685477580"));
    }
    public int myAtoi(String s) {
        long result = 0;
        boolean postive = true;
        int i = 0;
        //去除首尾空格
        s = s.trim();
        if (s.length() == 0) return 0;
        // 判断是不是有正负号，有的话i跳过第一个
        if ( s.charAt(0) == '-') {
            postive = false;
            i = 1;
        }
        if (s.charAt(0) == '+') i = 1;

        // 遍历
        for ( ; i < s.length(); i++) {
            // 是数字进入if
            if (s.charAt(i) > 47 && s.charAt(i) < 58){
                // 对结果赋值，不讨论正负
                result = result * 10 + (s.charAt(i) - '0');

                // 大于最大值了
                // 如果是负数，返回最小值MIN_VALUE
                // 如果是正数，返回最大值MAX_VALUE,没必要继续循环下去
                if (result > Integer.MAX_VALUE){
                    return postive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }else{
                // 不是数字开头，直接结束，输出0
                break;
            }
        }
        // 满足的直接转换输出，不满足的在循环时就输出了
        return postive ?  (int)result : -(int)result;
    }
}
