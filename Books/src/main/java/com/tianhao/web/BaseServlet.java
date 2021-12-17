package com.tianhao.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @ClassName BaseServlet
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/12 11:06
 * @Version 1.0
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决post请求中文乱码问题
        // 一定要在请求参数之前，设置编码
        request.setCharacterEncoding("UTF-8");
        // 解决响应中文乱码问题
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        // 方式一：if - else判断调用哪个方法
//        if ("login".equals(action)) {
//            // 登录方法调用
//            login(request,response);
//        } else if ("regist".equals(action)) {
//            // 注册方法调用
//            regist(request, response);
//        }

        // 方式二：反射
        try {
            // 获取action 业务鉴别字符串，获取相应的业务方法反射对象
            // getDeclaredMethod(参数1，参数2)
            // 参数1：指明获取的方法名字
            // 参数2：指明获取的方法的【形参列表的类的class类对象】
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            // 调用目标方法
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);// 把异常抛给Filter过滤器，做统一处理
        }
    }
}
