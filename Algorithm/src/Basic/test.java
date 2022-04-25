package Basic;

import java.util.*;

/**
 * @ClassName test
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2022/4/1 22:59
 * @Version 1.0
 */
public class test {
    Random rand ;
    Map<Integer,ArrayList<Integer>> map;
    public test(int[] nums) {
        map = new HashMap<>();
        rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i],new ArrayList<>());// 不存在，创建一个，存在不管了
            map.get(nums[i]).add(i);// 添加索引到列表
        }
    }

    public int pick(int target) {
        ArrayList<Integer> list = map.get(target);
        return list.get(rand.nextInt(list.size()));
    }
    
}
