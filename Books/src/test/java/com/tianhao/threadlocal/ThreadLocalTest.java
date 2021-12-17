package com.tianhao.threadlocal;

import java.util.Random;

/**
 * @ClassName ThreadLocalTest
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/17 20:44
 * @Version 1.0
 */
public class ThreadLocalTest {
//    public static Hashtable<String, Object> map = new Hashtable<>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    private static Random random = new Random();


    public static void main(String[] args){
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }

    public static class Task implements Runnable{

        @Override
        public void run(){
            // 在run方法中，随机生成一个变量（线程要关联的数据），然后以当前线程名为key，保存到map中
            int i = random.nextInt(1000); // 1000以内的随机整数
            // 获取当前线程名
            String name = Thread.currentThread().getName();
            System.out.println("线程【" + name + "】生成的随机数是：" + i);
//            map.put(name,i);
            threadLocal.set(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            // 在Run方法结束之前，以当前线程名获取出数据并打印，查看是否可以取出操作
//            Object o = map.get(name);
            Object o = threadLocal.get();
            System.out.println("在线程【" + name + "】快结束时取出关联的数据是：" + o);
        }
    }
}
