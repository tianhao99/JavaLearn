package LeetCode.TH38;

/**
 * @ClassName Solution_Two_38
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/15 21:12
 * @Version 1.0
 */
public class Solution_Two_38 {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2;i <= n;i++){
            StringBuilder strs = new StringBuilder();
            int start = 0;
            int flag = 0;

            while(flag < str.length()){
                while(flag < str.length() && str.charAt(flag) == str.charAt(start)){
                    flag++;
                }
                strs.append(flag-start).append(str.charAt(start));
                start = flag;
            }
            str = strs.toString();
        }
        return str;
    }
}
