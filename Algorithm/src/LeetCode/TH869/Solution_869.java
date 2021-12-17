package LeetCode.TH869;

import java.util.HashSet;

/**
 * @ClassName Solution_869
 * @Description TODO:869. 重新排序得到 2 的幂
 * 数据范围 1<= N <= 10^9
 * 2^0  <= N <= 2^log2(10^9)=2^29.89=2^30
 * 先预处理所有范围内2的次幂，对2的次幂变成字符，排序，统计0-9的出现次数，
 * 对N进行同样处理，如果排列后的数据在预处理列表中能找到，就返回true，
 * @Author sth_199509@163.com
 * @Date 2021/10/28 18:01
 * @Version 1.0
 */
public class Solution_869 {
    private HashSet<String> set = new HashSet<>();
    public boolean reorderedPowerOf2(int n) {
        //将范围内的2的幂全部统计处理，加入集合
        for (int i = 1; i <= Math.pow(10,9); i<<=1) {
            set.add(charCount(i));
            System.out.println(charCount(i));
        }
        //如果n处理后，集合里面有相同的，返回true
        if (set.contains(charCount(n)))
            return true;
        return false;
    }

    /**
     * 比如788765，处理步骤如下
     * ① 空表[ , , , , , , , , , , , ]10个空位
     * ② 对应  0,1,2,3,4,5,6,7,8,9索引
     * ③ 处理788765
     * ④     [ , , , , ,1,1,2,2, , , ]返回如下字符串，1个5，1个6，2个7,2个8，
     * @param num
     * @return
     */
    private String charCount(int num){
        char[] chars = new char[10];//0~9
        while (num > 0){
            chars[num % 10] += 1;//取个位，++
            num /= 10;//抛弃个位
        }
        return new String(chars);
    }
}
