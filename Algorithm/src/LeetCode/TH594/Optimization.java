package LeetCode.TH594;

import java.util.HashMap;

/**
 * @ClassName Optimization
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/21 0:09
 * @Version 1.0
 */
public class Optimization {
    public int findLHS(int[] nums){
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],1));
        }
        for (Integer key : map.keySet()){

            if (map.containsKey(key+1))
                result = Math.max(result,map.get(key) + map.get(key+1));
        }
        return result;
    }
}
