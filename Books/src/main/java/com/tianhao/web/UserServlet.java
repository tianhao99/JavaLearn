package com.tianhao.web; /**
 * @ClassName ${NAME}
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/12 10:23
 * @Version 1.0
 */

import com.google.gson.Gson;
import com.tianhao.bean.User;
import com.tianhao.service.UserService;
import com.tianhao.service.impl.UserServiceImpl;
import com.tianhao.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 通过ajax 检查用户名是否存在
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxExistsUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、获取请求参数
        String username = request.getParameter("username");
        // 2、调用userService.existsUsername()方法
        boolean isExists =  userService.existsUsername(username);
        // 3、把要返回的结果封装成map对象
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("isExists",isExists);

        // 4、把map对象转换成json字符串
        Gson gson = new Gson();
        String resultJson = gson.toJson(resultMap);
        // 5、回传数据
        response.getWriter().write(resultJson);
    }

    /**
     * 处理注销登录用户操作
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、销毁Session中用户登录的信息（或者销毁Session）
        request.getSession().invalidate();// 销毁session会话
        // 2、重定向到首页（或者登录页面）
        response.sendRedirect(request.getContextPath());// 回到首页
    }
    /**
     * 处理登录请求
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、获取请求参数
        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        User user = new User(null, username, password, null);【用下边的jar包工具类代替了这行代码】
        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());


        // 2、验证登录
        User login = userService.login(user);
        if (login != null) {
            // 找到该用户信息
            // 保存用户登录的信息到Session域中
            request.getSession().setAttribute("user",login);// 把查询到的对象保存到session域中
            // 跳回登录成功页面
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        } else if (!userService.existsUsername(username)) {
            // 账号不存在
            request.setAttribute("msg", "用户名不存在");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            // 账号存在，但还是找不到，说明密码错误
            // 1、将已经输入的信息还显示在输入框中，
            request.setAttribute("msg", "密码错误");
            request.setAttribute("username", username);
            // 2、返回登录页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }

    /**
     * 处理注册请求
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // 获取用户输入的验证码
        String code = request.getParameter("code");
        // 获取网站提供的验证码
        String token = (String)request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 获取之后立即删除，防止重复提交
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        // 2、验证验证码是否正确
        if (token != null && token.equalsIgnoreCase(code)) {
            // 验证码正确
            // 验证账户信息
            User user = new User(null, username, password, email);

            if (userService.existsUsername(username)) {
                // 该账号已存在，跳回注册页面【并把回显信息保存到request域中】
                request.setAttribute("msg", "该账号已存在！");
                request.setAttribute("email", email);
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                // 成功注册
                // 保存用户信息
                userService.registUser(user);
                // 跳转注册成功地址
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }

        } else {
            // 验证码错误，跳回注册页面【并把回显信息保存到request域中】
            request.setAttribute("msg", "验证码错误，请重新输入！");
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }
}





















