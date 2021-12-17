package LeetCode.TH6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @ClassName Solution_6
 * @Description TODO:Z 字形变换
 * @Author sth_199509@163.com
 * @Date 2021/11/9 22:26
 * @Version 1.0
 */
public class Solution_6 {
    @Test
    public void test(){
        String paypalishiring = convert("PAYPALISHIRING", 3);
        System.out.println(paypalishiring);
    }
    public String convert(String s, int numRows) {
        if (numRows < 2 ){
            return s;
        }
        ArrayList<StringBuilder> list = new ArrayList<>();
        // 列表下面挂链表
        // 列表长度是行，
        for (int i = 0; i < Math.min(s.length(),numRows); i++) {
            // 用math 防止字符串长度不够numrows，就不用多创建了
            list.add(new StringBuilder());// 为每行下边创建链表
        }
        int i = 0;
        int change = -1;// 先取-1，因为第一步i = 0，进去，直接满足if，把他变成1了
        for (Character cha : s.toCharArray()){
            list.get(i).append(cha);
            if (i == 0 || i == numRows - 1){// 到了第一行或者到最后一行，这时要变向
                change = - change;
            }
            i += change;
        }

        // 将所有行下边挂的链表，全部添加到第一个链表后边，合并。
        for (int j = 1; j < list.size(); j++) {
            list.get(0).append(list.get(j));
        }

        // 将list的第一个链表 转成String返回即可
        return list.get(0).toString();
    }
}
