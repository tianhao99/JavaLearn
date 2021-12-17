package LeetCode.TH541;

/**541. 反转字符串 II
 *
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 *
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 */

class Solution_541 {
    public String reverseStr(String s, int k) {
        String result = "";//保存新的字符串
        int n =s.length();
        for (int i = 0;i < n;i+=2*k){//2k为单位递增
            if(n-i >= 2*k){//n-i为剩余未检查的字符串长度
                result += (reverse(s.substring(i,i+k)) + s.substring(i+k,i+2*k));//反转前k个，添加k~2k个。
            }else if(n-i < 2 * k && n-i > k){//不足2k，但大于k个时。
                result += reverse(s.substring(i,i+k)) + s.substring(i+k);//继续反转前k个，添加剩余。
            }else if(n-i <= k){//小于k个时
                result += reverse(s.substring(i));//全部反转
            }
        }
        return result;
    }
    //反转
    public String reverse(String s){
        String temp = "";
        for(int i = s.length()-1; i >= 0; i --){
            temp += s.charAt(i);
        }
        return temp;
    }
}
