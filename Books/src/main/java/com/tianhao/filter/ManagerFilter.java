package com.tianhao.filter; /**
 * @ClassName ${NAME}
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/17 20:13
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        Object user = request1.getSession().getAttribute("user");
        if (user == null){
            request1.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }else{
            // 放行
            chain.doFilter(request, response);
        }
    }
}
