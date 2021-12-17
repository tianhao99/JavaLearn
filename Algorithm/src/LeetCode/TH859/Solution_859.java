package LeetCode.TH859;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @ClassName Solution_859
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/23 8:44
 * @Version 1.0
 */
public class Solution_859 {
    @Test
    public void test(){
        System.out.println(buddyStrings("ab", "ba"));
    }
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        int count = 0;
        boolean repeat = false;
        int temp = 0;
        int [] arr = new int[4];
        HashSet<Character> repeatSet = new HashSet<>();
        for(int i = 0;i < s.length();i++){
            // 判断两个交换的情况
            if(s.charAt(i) != goal.charAt(i)){
                // 已经有两个不相同的了，第三个直接false
                count++;
                if(count > 2)
                    return false;
                arr[temp++] = s.charAt(i);
                arr[temp++] = goal .charAt(i);

            }else{
                if (repeatSet.contains(s.charAt(i))){
                    repeat = true;
                }else {
                    repeatSet.add(s.charAt(i));
                }
            }
            // 判断有没有相等的连续元素
            if(i < s.length()-1 && s.charAt(i) == s.charAt(i+1))
                repeat = true;
        }

        if(count == 0){
            return repeat;
        }else if(count == 2){
            return (arr[2] == arr[1] && arr[0] == arr[3]);
        }
        return false;
    }
}
