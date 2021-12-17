package NowCoder.ByteDance;
import java.util.*;
/**
 * @ClassName ThreeAgents
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/12 17:12
 * @Version 1.0
 */
public class ThreeAgents {
    public static void main(String[] args){
        //输入
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        int[] addrs = new int[n];
        for(int i = 0;i < n;i++){
            addrs[i] = scan.nextInt();
        }

        //处理
        long result = 0;//结果
        int p = 0;
        //从第三个数开始，遍历数组，
        // 1、如果特工人数够3个，但是间距太远，让第一个特工p++
        // 2、i和p间距保证大于3个特工，否则表示只有两个特工的地方了，王大锤向后移动i++
        // 3、如果满足三个特工，而且间距不超过D，此时求C（2）（i-p）
        // （i-p）中选两个，再加上王大锤位置，必定不会重复
        for(int i = 2;i < n;){//距离超出d之后，第一个人向前移动，王大锤不动，所以i++放到内部处理
            if(addrs[i] - addrs[p] > d){
                p++;
            }else if(i - p < 2){
                i++;
            }else{
                result += (long)(i-p)*(i-p-1)/2;
                i++;
            }
        }
        System.out.println(result % 99997867);//按要求取模
    }
}
