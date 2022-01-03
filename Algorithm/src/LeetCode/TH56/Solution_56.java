package LeetCode.TH56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Solution_56
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2022/1/16 5:12 AM
 * @Version 1.0
 */
public class Solution_56 {
    public int[][] merge(int[][] intervals) {
        // 按每个数组的开头元素排序
        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2){
                return arr1[0]-arr2[0];
            }
        });



        List<int[]> list = new ArrayList<>();
        for(int i = 0;i < intervals.length-1;i++){
            int left = intervals[i][0];
            int right = intervals[i][1];
            // list为空、或者这个left > 这个表中的右边界
            if(list.size() == 0 || left > list.get(list.size()-1)[1]){
                list.add(new int[]{left,right});
            }else{
                // left <= 这个表的左边界，重合了
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],right);
            }
        }
        return list.toArray(new int[0][]);
    }
}
