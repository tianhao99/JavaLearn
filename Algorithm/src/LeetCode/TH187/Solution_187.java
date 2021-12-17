package LeetCode.TH187;

import java.util.*;

/**
 * @ClassName Solution_187
 * @Description TODO:
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 *
 * For example, "ACGAATTCCG" is a DNA sequence.
 * When studying DNA, it is useful to identify repeated sequences within the DNA.
 *
 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 *
 * Example 2:
 *
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 * @Author sth_199509@163.com
 * @Date 2021/10/8 21:46
 * @Version 1.0
 */
public class Solution_187 {
    static final int L = 10;//重复子串长度
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, Integer> strs = new HashMap<>();//使用哈希表，重复的直接value++，最后判断value==2即可
        for (int i = 0; i <= s.length()-L; i++) {
            String str = s.substring(i,i+L);
            strs.put(str, strs.getOrDefault(str,0)+1);
            //使用getOrDefault(str,0)，若为空，默认值为0，后再加一
            //直接在里面遍历就可以，因为第一次该串value == 1；不进if语句
            //第二个重复子串时，会在同一个位置value++，此时value == 2，添加到result
            if (strs.get(str) == 2){
                result.add(str);
            }
        }
        return result;

    }
}
