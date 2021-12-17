package LeetCode.TH240;

/**
 * @ClassName Solution_240
 * @Description TODO:240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * @Author sth_199509@163.com
 * @Date 2021/10/25 10:15
 * @Version 1.0
 */
public class Solution_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int line = search(matrix[0],target);
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][line] == target){
                return true;
            }
            if (matrix[i][line] > target){
                int temp = line;
                while(temp != -1 && matrix[i][temp] > target) {
                    temp -= 1;
                    if (matrix[i][temp] == target) {
                        return true;
                    }
                    if (matrix[i][temp] < target)
                        break;
                }
            }
        }
        return false;
    }
    private int search(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        int mid;
        while(left < right){
            mid = (left + right)/2;
            if (arr[mid] == target){
                return mid;
            }
            if (arr[mid] > target){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        if (arr[left] > target && left != 0){
            return left-1;
        }else{
            return left;
        }
    }
}
