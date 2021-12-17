package LeetCode.TH492;

/**
 * @ClassName Solution_492
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/23 20:54
 * @Version 1.0
 */
public class Solution_492 {
    public int[] constructRectangle(int area) {
        //定义一个数组，长度只要2就可以
        int[] arr = new int[2];
        //初始化，默认肯定是1*area == area
        arr[0] = area;
        arr[1] = 1;
        //从根号处开始遍历，长和宽最接近的一定是根号值，逐一递减
        for(int i = (int)Math.sqrt(area);i > 1;i--){
            if (area % i == 0){
                arr[0] = area / i;
                arr[1] = i;
                break;//只要找到就退出，一定是最相近的
            }
        }//若没找到，返回初始值
        return arr;
    }
}
