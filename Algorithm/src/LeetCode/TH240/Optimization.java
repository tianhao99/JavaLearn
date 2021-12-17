package LeetCode.TH240;

/**
 * @ClassName Optimization
 * @Description TODO:每次排除一行，或者一列，直接用两个二分法，一次排除半行或半列
 * @Author sth_199509@163.com
 * @Date 2021/10/25 17:19
 * @Version 1.0
 */
public class Optimization {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[x].length-1;//从右上角开始检查
        while(x < matrix.length && y >= 0){//越界后退出
            if(matrix[x][y] == target){//找到返回true
                return true;
            }else if(matrix[x][y] > target){//比目标值大，因为已经在最右边，所以列减一个，找到比其小的那一列
                y -= 1;
            }else{//已经到了这一列，此时在第0行，比其小，行加一
                x += 1;
            }
        }
        return false;
    }
}
