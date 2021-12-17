package LeetCode.TH38;

import java.util.HashMap;

/**
 * @ClassName Solution_38
 * @Description TODO:
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。

    1.     1
    2.     11
    3.     21
    4.     1211
    5.     111221
    第一项是数字 1
    描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
    描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
    描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
    描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"

 * @Author sth_199509@163.com
 * @Date 2021/10/15 18:50
 * @Version 1.0
 */
public class Solution_38 {
    public String countAndSay(int n) {
        String[] strs = new String[31];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = "";
        }
        strs[1] = "1";
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < strs[i-1].length(); j++) {
                int count = 1;
                while(j+1 < strs[i-1].length() && strs[i-1].charAt(j) == strs[i-1].charAt(j+1)){
                    count++;
                    j++;
                }
                if (count > 1){
                    strs[i] += "" + count + strs[i-1].charAt(j);
                }else{
                    strs[i] += "" + 1 + strs[i-1].charAt(j);
                }
            }
        }
        return strs[n];
    }
}
