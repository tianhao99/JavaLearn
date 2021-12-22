package Practice;

import java.util.Scanner;

/**
 * @ClassName Practice
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/12/21 4:54 PM
 * @Version 1.0
 */
public class Practice {

    public static void main(String[] args) {
        //录入数据
        Scanner scanner = new Scanner(System.in);
        System.out.println("本程序用于计算最大公约数和最小公倍数:\n");
        System.out.println("请输入第一个数，按回车输入下一个!");
        int num1 = scanner.nextInt();
        System.out.println("请输入第二个数，按回车计算结果!");
        int num2 = scanner.nextInt();

        // 求两数乘积，后面求最小公倍数
        int num12 = num1 * num2;
        // 存储最大公约数
        int divisor;
        // 存储最小公倍数
        int multiple;

        // 将num1置换为两个数中较小的
        if (num1 > num2){
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        // 辗转相除
        int modNum = num2 % num1;
        while(num1 != 0){
            modNum = num2 % num1;
            num2 = num1;
            num1 = modNum;
        }
        // 赋值 并输出最大公约数和最小公倍数
        divisor = num2;
        multiple = num12 / num2;
        System.out.println("最大公约数是：" + divisor + "，最小公倍数是：" + multiple);
    }
}
