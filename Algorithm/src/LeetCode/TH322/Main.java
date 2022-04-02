package LeetCode.TH322;

import java.util.Arrays;

/**
 * @ClassName Main
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2022/3/30 20:27
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println(coinChange(coins, 11));
    }
    public static int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount+1];
        // 要凑这个，硬币个数不可能大于他本身，最小的硬币也是1
        Arrays.fill(arr,amount+1);
        // 0 怎么也不能凑出来
        arr[0] = 0;
        int n = coins.length;
        // 动态规划数组，需要哪个返回哪个
        for(int i = 1; i <= amount;i++){
            // 对硬币组合遍历，如1、2、5，目标11
            //    对比arr[10],arr[9],arr[6]这三个哪个小，取最小的，然后+1
            //   【+1是因为：假设取arr[6]就还得增加一个5硬币】
            for(int j = 0;j < n;j++){
                // 大的就不用算了，比目标面值都大了，还凑啥，需要凑3元，你5元面值直接就舍弃了
                if(coins[j] <= i){
                    arr[i] = Math.min(arr[i],arr[i-coins[j]]+1);
                }
            }
        }
        // 判断有没有赋值，没有赋值还是amount+1，那就表示凑不成
        return arr[amount] > amount ? -1:arr[amount];
    }
}
