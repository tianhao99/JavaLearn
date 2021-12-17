package LeetCode.TH384;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution_384
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/22 8:08
 * @Version 1.0
 */

public class Solution_384 {

    // Fields
    private int[] nums;
    // Constructors
    public Solution_384(int[] nums){
        this.nums = nums;
    }
    // Methods
    public int[] reset(){
        return nums;
    }
    public int[] shuffle(){
        int right = nums.length;
        int[] arr = new int[right];
        int temp;
        for (int i = 0; i < right; i++) {
            arr[i] = nums[i];
        }

        while (right > 0) {
            int j = (int)(Math.random() * right--);
            temp = arr[right];
            arr[right] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}
