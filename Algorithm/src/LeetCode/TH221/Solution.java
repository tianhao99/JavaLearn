package LeetCode.TH221;

/**
 * @ClassName Solution
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2022/1/27 10:14 PM
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},
                                       {'1','0','1','1','1'},
                                       {'1','1','1','1','1'},
                                       {'1','0','1','1','1'}};
        System.out.println(maximalSquare(matrix));
    }
    public static int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] res = new int[row][column];
        int result = 0;

        for(int i = 0;i < row;i++){
            for(int j = 0;j < column;j++){
                // just consider 1，
                if(matrix[i][j] == '1'){
                    // if the first column or first row is 1,it can only be 1
                    if(i == 0 || j == 0){
                        res[i][j] = 1;
                    }else{
                        res[i][j] = Math.min(Math.min(res[i-1][j],res[i-1][j-1]),res[i][j-1]) + 1;
                        result = Math.max(result,res[i][j]);
                    }
                }
            }
        }
        return result * result;
    }
}
