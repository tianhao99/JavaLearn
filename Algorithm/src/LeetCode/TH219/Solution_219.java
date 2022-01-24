package LeetCode.TH219;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution_219
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2022/1/19 2:53 AM
 * @Version 1.0
 */
public class Solution_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i],i);
            }else{
                int temp = map.get(nums[i]);
                if(Math.abs(temp - i) <= k) return true;
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
