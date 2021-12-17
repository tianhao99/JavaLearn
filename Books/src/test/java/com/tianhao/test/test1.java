package com.tianhao.test;

import org.junit.jupiter.api.Test;

/**
 * @ClassName test1
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/12 15:56
 * @Version 1.0
 */
public class test1 {
    @Test
    public void test(){
        System.out.println(testInt());
    }
    public int testInt(){
        try {
            if (1==1)
                return 100;
        } finally {
            System.out.println("我是try-finally内部");
        }
        return 99;
    }
}
