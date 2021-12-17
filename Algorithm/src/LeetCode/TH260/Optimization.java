package LeetCode.TH260;

import java.util.HashMap;

/**
 * @ClassName Optimization
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/30 21:40
 * @Version 1.0
 */
public class Optimization {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = null;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.get(nums[i]) == null ? 1:map.get(nums[i])+1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1){
                if (result == null){
                    result = new int[2];
                    result[0] = nums[i];
                }else{
                    result[1] = nums[i];
                    break;
                }
            }
        }
        return result;
    }
}
