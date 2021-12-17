package LeetCode.TH299;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @ClassName Optimization
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/8 21:16
 * @Version 1.0
 */
public class Optimization {
    @Test
    public void test(){
        String hint = getHint("1122", "2211");
        System.out.println(hint);
    }
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] a = new int[10];
        int[] b = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)){
                bulls++; // 统计公牛数量
            }else{
                /**
                 * 创建两个长度为10 的整型数组  字符-'0'  ==》》字符换成 整型
                 *          0  1  2  3  4  5  6  7  8  9
                 * a        0  0  1  0  1  1  0  2  0  0
                 * b        0  1  1  0  1  0  0  1  0  0
                 * 取小求和  0+0+1+0+1+0+0+1+0+0=3
                 * 位置不同，字符相同的个数是3，取小是因为假设a有2个9，b有1个9，相同的必然只有一个9，所以对位取小
                 */
                a[secret.charAt(i) - '0']++;
                b[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            cows += Math.min(a[i],b[i]);
        }
        return bulls + "A" + cows +"B";
    }
}
