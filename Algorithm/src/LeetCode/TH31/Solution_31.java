package LeetCode.TH31;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution_31
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2022/1/3 4:46 PM
 * @Version 1.0
 */
public class Solution_31 {
    public static void main(String[] args) {
        int[] arr = {5,1,1};
        Solution_31 solution_31 = new Solution_31();
        solution_31.nextPermutation(arr);
        for (int a : arr){
            System.out.print(a);
        }
    }
    public void nextPermutation(int[] nums) {
        int first = nums.length-1;
        int second = first;
        // 从后向前，找到第一个不是降序的位置
        while(first > 0 && nums[first] <= nums[first-1]){
            first--;
        }
        if(first == 0){
            reverse(first,nums.length-1,nums);
            return;
        }
        while(second > 0 && nums[second] <= nums[first-1]){
            second--;
        }
        // 交换第一个降序点和比它大的元素
        int temp = nums[first-1];
        nums[first-1] = nums[second];
        nums[second] = temp;

        reverse(first,nums.length-1,nums);
    }
    public void reverse(int begin,int end,int[] arr){
        if(begin < 0 || end > arr.length-1){
            return;
        }
        while(begin < end){
            int temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            begin++;
            end--;
        }
    }
}
