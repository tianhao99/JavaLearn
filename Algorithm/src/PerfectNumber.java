/*
完数：如果一个数等于它的因子之和,则称该数为“完数”(或“完全数”)。
例如,6的因子为1、2、3,而 6=1+2+3,因此6是“完数”。
*/
//输出10000以内的完全数
public class PerfectNumber {
    public static void main(String[] args){
        int factor = 0;
        for (int i = 1; i <= 1000000; i++) {
            for (int j = 1; j <= i/2; j++) {//   i/2为最大值，因不包含小数，
                if(i % j == 0){         //求因数1和本身，2和i/2，3和i/3，不包括本身，所以最大遍历到i/2.
                    factor += j;
                }
            }
            if(factor == i){
                System.out.println(i);
            }
            factor = 0;//本次循环结束，重置为0，开始下次因子计数。
        }
    }
}
