package LeetCode.TH594;

import java.util.HashMap;

/**
 * @ClassName Solution_594
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/20 23:42
 * @Version 1.0
 */
public class Solution_594 {

    public int findLHS(int[] nums){
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.get(nums[i]) == null ? 1 : map.get(nums[i]) + 1);
        }
        for (Integer key : map.keySet()){
            int keyAdd1 = map.get(key + 1) == null ? 0 : map.get(key + 1);
            int keyOut1 = map.get(key - 1) == null ? 0 : map.get(key - 1);
            if (keyAdd1 != 0 || keyOut1 != 0)
                result = Math.max(result,Math.max(keyAdd1,keyOut1) + map.get(key));
        }
        return result;
    }
}
