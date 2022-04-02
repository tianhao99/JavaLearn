package LeetCode.TH215;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @ClassName Solution
 * @Description TODO:数组中第K个最大元素------就是快排，找到那个pivot，快排就是每次取一个pivot，左边小于他，右边大于他，如果刚好是n-k，那就是第k大元素
 * @Author sth_199509@163.com
 * @Date 2022/1/27 5:21 PM
 * @Version 1.0
 */
public class Solution {
    @Test
    public void test(){
        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(arr, 1));
    }
    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0, nums.length-1, k-1);
    }

    /**
     * 快速选择【左侧大、右侧小】【递减排序】【k-1位置就是第K大元素的索引值】
     * @param arr 目标数组
     * @param left 分治以后的左边界
     * @param right 分治以后的右边界
     * @param index 第K大的，索引位置k-1
     * @return
     */
    public int quickSelect(int[] arr,int left,int right,int index){
        int pivot = randomPivot(arr,left,right);
        if (pivot == index){
            // find target，return
            return arr[pivot];
        }else if(pivot < index){
            // Go right
            return quickSelect(arr,pivot+1,right,index);
        }else{
            // Go left
            return quickSelect(arr,left,pivot-1,index);
        }
    }

    /**
     * 快排，随机选一个中枢pivot，完成一次快排，返回中枢pivot
     * @return
     */
    private int randomPivot(int[] arr,int left,int right) {
        // random pivot
        int pivot = random.nextInt(right-left+1) + left;
        // placed to the far right【循环结束刚好到他这里，然后把他放到pivot位置】
        swap(arr,pivot,right);
        int temp = arr[right];
        pivot = left;
        for (int i = left; i < right; i++) {
            // The big one is placed on the left,and pivot++
            if (arr[i] >= temp){
                swap(arr,pivot++,i);
            }
        }
        // Get back the pivot value
        swap(arr,pivot,right);
        return pivot;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
