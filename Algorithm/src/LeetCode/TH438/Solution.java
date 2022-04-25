package LeetCode.TH438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2022/4/5 16:10
 * @Version 1.0
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int nP = p.length(), nS = s.length();
        int[] sNum = new int[26];
        int[] pNum = new int[26];
        if(nP > nS) return res;
        // 录入第一个目标p数据，并同时检测前一个是不是合适
        for (int i = 0; i < nP; i++) {
            ++sNum[s.charAt(i) - 'a'];
            ++pNum[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sNum,pNum)) res.add(0);

        for (int i = 0; i < nS-nP; i++) {
            // 滑动窗口
            --sNum[s.charAt(i) - 'a'];
            ++sNum[s.charAt(i+nP) - 'a'];
            if(Arrays.equals(sNum,pNum)) res.add(i+1);
        }
        return res;
    }

}
