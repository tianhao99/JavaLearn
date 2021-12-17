
/*
素数（质数）：是指在大于1的自然数中,除了1和它本身外,不能被其他自然数整除(除0以外)的数。
*/
public class PrimeNumber {
    public static void main(String[] args){
        label:for (int i = 2; i <100000; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    continue label;//存在可以整除的数，跳出当前循环，回到外层循环继续执行。
                }
            }
            System.out.println(i);//因非质数已经通过continue跳出本层循环，凡是可以运行到此位置的，均为质数
        }
    }
}
