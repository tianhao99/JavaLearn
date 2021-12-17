/*
*杨辉三角（Pascal's Triangle）
* 1、每个数等于它上方两数之和【直角模式等于上方和左上方元素之和】。
* 2、每行数字左右对称，由1开始逐渐变大。
* 3、第一行有1个元素，第n行有n个元素。
* 4、前n行共[(1+n)n]/2 个数。
* */

public class PascalTriangle {
    public static void main(String[] args){
        int line = 10;//10行的杨辉三角
        int[][] triangle = new int[line][];

        for (int i = 0; i < line; i++) {  //动态初始化列元素
            triangle[i] = new int[i+1];
        }
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                //根据性质对杨辉三角进行赋值
                if (j == 0 || j == i){
                    triangle[i][j] = 1;
                }else{
                    triangle[i][j] = triangle[i-1][j] + triangle[i-1][j-1];
                }
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
