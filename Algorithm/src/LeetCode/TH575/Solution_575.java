package LeetCode.TH575;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Solution_575
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/1 16:39
 * @Version 1.0
 */
public class Solution_575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int result = candyType.length / 2;
        for (int i = 0;i < candyType.length;i++){
            set.add(candyType[i]);//重复元素不入集合
        }
        if (set.size() <= result) //如果糖果种类小于n/2，则最多只能分到set.size()个
            result = set.size();
        return result;//糖果种类大于n/2那他只能分到n/2个，直接返回即可
    }
}
