package LeetCode.TH229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Solution_299
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/22 19:45
 * @Version 1.0
 */
public class Solution_299 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length / 3;
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
            if (map.get(nums[i]) > n && !list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        return list;
    }
}
