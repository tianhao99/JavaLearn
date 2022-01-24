package LeetCode.TH139;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @ClassName Solution
 * @Description TODO:单词拆分
 * @Author sth_199509@163.com
 * @Date 2022/1/23 8:36 PM
 * @Version 1.0
 */
public class Solution {
    @Test
    public void test(){
        List<String> wordDict = new ArrayList<>();
        wordDict.add("lll");
        wordDict.add("llll");
//        wordDict.add("etcode");
        String str = "lllllll";
        System.out.println(wordBreak(str,wordDict));
    }
    /**
     * 动态规划：以字符串s为标准，逐步向前，
     *      外层循环i之前均能被匹配，置为true
     *      内层循环i —— j之间有单词可以匹配，i置为j，
     *      布尔型数组，期初全是false，循环结束返回末尾，如果是true表示此位置之前全部能匹配
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] result = new boolean[n+1];
        // 0位置为true，其余为false
        Arrays.fill(result,false);
        result[0] = true;

        for (int i = 0; i < n; i++) {
            // 如果i位置不是true，直接不用进了
            if(!result[i]) continue;
            // 遍历每一个单词，看能不能从i为起点向后匹配，可以i加单词长度置为true
            for(String str:wordDict){
                if(s.startsWith(str,i)){
                    result[i+str.length()] = true;
                }
            }
        }
        return result[n];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        for(String str:wordDict){
            return backTrack(s,wordDict,new StringBuilder());
        }
        return false;
    }
    public boolean backTrack(String target,List<String> wordDict,StringBuilder path){
        if(target.equals(path)){
            return true;
        }
        for(String str:wordDict){
            if(path.length() < target.length()){
                path.append(str);
                if(backTrack(target,wordDict,path)){
                    return true;
                }
            }
            path.delete(path.length()-1,path.length());
        }
        return false;
    }
}
