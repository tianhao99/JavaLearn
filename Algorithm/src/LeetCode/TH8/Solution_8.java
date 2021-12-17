package LeetCode.TH8;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution_8
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/24 8:55
 * @Version 1.0
 */
public class Solution_8 {
    @Test
    public void test(){
        System.out.println(myAtoi("    -478"));
//        System.out.println(myAtoi("4193 with words"));
//        System.out.println(myAtoi("with 4193 with words"));
//        System.out.println(myAtoi("-91283472332"));
//        System.out.println(myAtoi("9223372036854775808999"));
//        System.out.println(myAtoi("-922337203685477580"));
    }
    public int myAtoi(String s) {
        long result = 0;
        boolean postive = true;
        long temp = 0;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-' && i == 0) {
                postive = false;
                continue;
            }
            if (s.charAt(i) == '+' && i == 0) {
                continue;
            }
            if (s.charAt(i) > 47 && s.charAt(i) < 58){
                result = result * 10 + (s.charAt(i) - '0');
                if (!postive) {
                    temp = -result;
                }else{
                    temp = result;
                }
                if (temp < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
                if (temp > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }else{
                break;
            }
        }
        return (int)temp;
    }
}
