package LeetCode.TH3;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Main
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/12/21 12:37 AM
 * @Version 1.0
 */

public class Main{

    public static void  main(String[] args){

        System.out.println(maxLength("asdfgggg"));
        String date = "2019-02-10";
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8));

        //创建月份天数数组
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};

        // 判断闰年
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 == 0)){
            months[1] = 29;
        }
        // 计算天数
        for(int i = 0; i < month-1;i++){
            day += months[i];
        }

        System.out.println(year);
        System.out.println(month);
        System.out.println(day);

    }

    public static int maxLength(String str){
        int  result = 1;
        int begin = 0;
        // 创建map存储字符串
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
                // 判断是否存在重复元素
                if(map.containsKey(str.charAt(i))){
                        begin = Math.max(begin,map.get(str.charAt(i)) + 1 );
                }
                // 存入数据
                map.put(str.charAt(i),i);
                // 判断结果长度，取最长的值
                result = Math.max(result,i - begin + 1);
        }
        return result;
    }

}

