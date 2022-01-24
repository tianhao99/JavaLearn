package LeetCode.TH1220;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1220
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2022/1/17 7:36 PM
 * @Version 1.0
 */
public class Solution_1220 {
    @Test
    public void test(){
        System.out.println(countVowelPermutation(3));

    }

    /**
     * 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
     *
     * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
     * 每个元音 'a' 后面都只能跟着 'e'
     * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
     * 每个元音 'i' 后面 不能 再跟着另一个 'i'
     * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
     * 每个元音 'u' 后面只能跟着 'a'
     *
     * @param n
     * @return
     */
    public int countVowelPermutation(int n) {
        List<String> result = new ArrayList<>();
        String[] data = new String[]{"a","e","i","o","u"};
        int num = 0;
        backTrack(num,n,data,new StringBuilder(),result);
        result.forEach(System.out::println);

        return num;
    }
    public void backTrack(int num,int n,String[] data,StringBuilder path,List<String> result){
        if(path.length() == n){
            result.add(String.valueOf(path));
            num++;
            return;
        }
        for(int i = 0;i < data.length;i++){
            path.append(data[i]);
            backTrack(num,n,data,path,result);
            path.delete(path.length()-1,path.length());
        }
    }
}
