package Basic;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/12/27 9:33 PM
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        test test = new test(new int[]{1, 2, 3, 3, 3});
        int p1 = test.pick(3);
        int p2 = test.pick(1);
        int p3 = test.pick(2);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}

