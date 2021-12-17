/*
* 1、属于两个整数
* 2、输出两个数的最大公约数和最小公倍数
*/

import java.util.Scanner;

public class MultipleAndDivisor {
    public static void main(String[] args){
        //创建一个对象
        Scanner scan = new Scanner(System.in);
        //输入两个整数
        System.out.println("请输入第一个整数");
        int num1 = scan.nextInt();
        System.out.println("请输入第二个整数");
        int num2 = scan.nextInt();

        int min = 1;
        int max = 1;
        int divisor = 1;        //divisor保存最大公约数
        int multiple = 1;           //multiple保存最小公倍数

        if(num1 > num2){
            max = num1;
            min = num2;
        }else if(num1 < num2){
            max = num2;
            min = num1;
        }else{
            divisor = num1;     //两数相等时，最大公约数==最小公倍数
            multiple = num1;
        }


        //最大公约数
        //取小的那个值，递减迭代
        for (int i = min; i >= 1; i--) {//公约数
            if(num2 % i ==0 && num1 % i ==0){
                divisor = i;
                break;
            }
        }
        //最小公倍数
        multiple = max;        //假设最小公倍数为max本身
        for (int i = 1; multiple <= num1 * num2; i++){//公倍数
            multiple = max * i;     //倍数迭代
            if(multiple % min == 0){
                break;
            }
        }
        System.out.println(num1 + "和" + num2 + "的最大公约数是" + divisor + ",最小公倍数是" + multiple);
    }
}
