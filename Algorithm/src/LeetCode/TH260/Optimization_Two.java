package LeetCode.TH260;

import 剑指Offer.TH_55.Solution;

/**
 * @ClassName Optimization_Two
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/30 22:22
 * @Version 1.0
 */
public class Optimization_Two {
    public int[] singleNumber(int[] nums) {
        //异或^=     0^0=0；   0^1=1；   1^0=1；   1^1=0；
        //所有数据异或，最后只有两个元素不同，必定不为0
        //两两相同的元素，异或为0，最后实际比较的就是两个不同的元素
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }
        // 取出二进制，倒数最后一个不是0的位置
        /**
         * 与运算&    0^0=0；   0^1=0；   1^0=0；   1^1=1；【只有都为1，才是1】
         * 原码xorsum
         * 补码(-xorsum)
         * 反码是原码取反得到，1变0,0变1    【所以如果 原码&反码，结果必定是0】
         * 补码是反码＋1得到，原本两两相反，现在+1后，如果原本是0，不论怎么变与运算&后，肯定还是0，
         * 倒数第一个xxx1000，后边反码xxx0111,加一后就肯定是xxx1000，与运算&直接找到倒数第四位是1
         * 原码： 5【101】  6【110】
         *           &         &
         * 补码：-5【011】 -6【010】
         * x&(-x) 【001】   【010】
         */
        int lsb = xorsum & (-xorsum);//找1的地方，就是两个数不同的地方

        // 【其中一个数的这个位是1，另一个数的这个位是0】
        // 将问题化为找到这个位置是1的数，和这个位置是0的数
        // 直接遍历一边，将这个位置是1的全部分出来，进行异或运算，最后两两成对变成0，只有单独的那一个不同的留下;
        // 同理，将位置上是0的，分出来，进行异或运算，最后仍是两两成对变成0，只有单独的那个一个不同的得以保存；
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & lsb) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
