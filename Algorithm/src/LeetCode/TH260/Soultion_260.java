package LeetCode.TH260;

import java.util.Arrays;

/**
 * @ClassName Soultion_260
 * @Description TODO:快排，遍历输出
 * @Author sth_199509@163.com
 * @Date 2021/10/30 21:22
 * @Version 1.0
 */
public class Soultion_260 {
    public int[] singleNumber(int[] nums) {
        int[] result = null;
        //快排
        quickSort(nums,0,nums.length-1);
        //遍历
        for(int i = 0;i < nums.length;i+=2){
            if(i == nums.length-1){
                result[1] = nums[nums.length-1];
                break;
            }
            if(nums[i] != nums[i+1]){
                if(result == null){
                    result = new int[2];
                    result[0] = nums[i];
                    i -= 1;
                }else{
                    result[1] = nums[i];
                    i -= 1;
                    break;
                }
            }
        }
        return result;
    }
    private void quickSort(int[] arr,int left,int right){
        if(left < right){
            int m = partition(arr,left,right);//接收上次排序枢轴索引
            quickSort(arr,left,m-1);//根据枢轴区分左右，再次排序
            quickSort(arr,m+1,right);
        }
    }
    private int partition(int[] arr,int left,int right){
        int pivot = arr[left];
        while(left < right){
            while(left < right && arr[right] >= pivot) right--;
            arr[left] = arr[right];
            while(left < right && arr[left] <= pivot) left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;//防止枢轴最终位置
        return left;//返回枢轴索引
    }
}
