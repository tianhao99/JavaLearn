package com.tianhao.filter; /**
 * @ClassName ${NAME}
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/17 22:05
 * @Version 1.0
 */

import com.tianhao.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        try {
            chain.doFilter(request, response);
            // 没有异常，提交事务
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            // 产生异常，回滚事务
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e);// 把异常抛给Toncat，让服务器来展示有好多错误页面
        }
    }
}
