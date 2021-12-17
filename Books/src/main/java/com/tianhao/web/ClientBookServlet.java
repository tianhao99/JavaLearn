package com.tianhao.web; /**
 * @ClassName ${NAME}
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/15 7:11
 * @Version 1.0
 */

import com.tianhao.bean.Book;
import com.tianhao.bean.Page;
import com.tianhao.service.BookService;
import com.tianhao.service.impl.BookServiceImpl;
import com.tianhao.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();
    /**
     * 处理分页功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1、获取请求参数 pageNo 和 pageSize【直接转换成整型】
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        // 2、调用BookService.page(pageNo,pageSize)方法，返回Page对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");
        // 3、保存Page对象到Request 域中
        request.setAttribute("page",page);
        // 4、请求转发到pages/manager/book_manager.jsp
        // !!!!!!请求转发别忘了.forward(request,response)
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1、获取请求参数 pageNo、pageSize、min、max【直接转换成整型】
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);
        // 2、调用BookService.pageByPrice(pageNo,pageSize,min,max)方法，返回Page对象
        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);


        StringBuilder stringBuilder = new StringBuilder("client/bookServlet?action=pageByPrice");
        // 如果有最小价格参数，追加到分页条的地址栏参数中
        if (request.getParameter("min") != null)
            stringBuilder.append("&min=").append(request.getParameter("min"));
        // 如果有最大价格参数，追加到分页条的地址栏参数中
        if (request.getParameter("max") != null)
            stringBuilder.append("&max=").append(request.getParameter("max"));


        page.setUrl(stringBuilder.toString());

        // 3、保存Page对象到Request 域中
        request.setAttribute("page",page);
        // 4、请求转发到pages/manager/book_manager.jsp
        // !!!!!!请求转发别忘了.forward(request,response)
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }
}
