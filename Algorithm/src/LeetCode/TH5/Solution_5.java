package LeetCode.TH5;

/**
 * @ClassName Solution_5
 * @Description TODO:好家伙732ms，超时的边缘
 * @Author sth_199509@163.com
 * @Date 2021/10/16 11:21
 * @Version 1.0
 */
public class Solution_5 {
    public String longestPalindrome(String s) {
        int len = 1;
        int temp_i = 0;
        int temp_j = 0;
        String str = s.substring(0,1);
        for(int i = 1;i < s.length();i++){//统计每个位置之前的最长回文子串
            for(int j = 0;j < i;j++){//从0开始每个位置到i的最长回文子串
                temp_i = i;//暂存i、j的值
                temp_j = j;
                while(temp_j <= (temp_i) && s.charAt(temp_j) == s.charAt(temp_i)){//比较头尾，若相等继续
                    temp_j++;
                    temp_i--;
                }
                if(temp_j > temp_i && len < i - j +1){//temp_j>temp_i说明完全相等，再判断是否比之前的回文串长
                        len = i - j + 1;
                        str = s.substring(j,i+1);
                        break;
                }
            }
        }
        return str;
    }
}
