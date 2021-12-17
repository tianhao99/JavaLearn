package LeetCode.TH5;

/**
 * @ClassName Solution_good_5
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/16 16:54
 * @Version 1.0
 */
public class Solution_good_5 {
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s == null){
            return "";
        }
        //中心扩散方法
        int start = 0,end = 0;
        String str = null;
        for(int i = 0;i < s.length();i++){//以每个点为中心进行扩散
            int oddLen = CenterExpend(s,i,i);//回文子串为奇数时
            int evenLen = CenterExpend(s,i,i+1);//回文子串为偶数时
            int len = Math.max(oddLen,evenLen);
            if(len > end - start){//对比此前保存的回文子串的长度
                start = i - (len-1)/2;
                end = i + len/2;
            }
            str = s.substring(start,end + 1);
        }

        return str;
    }
    //中心扩散，返回扩散成功长度
    public int CenterExpend(String s,int left,int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;//返回扩散长度,当退出循环时已经left/right已经越界，所以－1为正确值
    }
}