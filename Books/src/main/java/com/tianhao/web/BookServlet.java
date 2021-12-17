package com.tianhao.web; /**
 * @ClassName ${NAME}
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/12 23:35
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
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取传过来的末尾页面参数
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"),0);
        // 直接给他加一，，，，这样不管新添加数据后，是否增加新的页面都会跳转到末页
        // 【因为即使没有增加新页面，那么越界后会跳转最后一页】
        pageNo += 1;
        // 1、获取请求的参数   封装成Book对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        // 2、调用BookService.addBook() 保存图书
        bookService.addBook(book);
        // 3、跳回图书管理页面
        // 使用请求转发【这时所有操作归为一次请求】【如果用户刷新页面，会造成表单重复提交】
//        request.getRequestDispatcher("/manager/bookServlet?action=list").forward(request,response);
        // 应该使用请求重定向【重定向后，就是两次请求，刷新只会重新提交当前页面，之前添加图书操作已经是过去式了】
        //System.out.println(request.getContextPath());//    获取工程名/Books
        // 重定向默认地址是：Http://localhost:8080   所以要加上工程名
        // 【请求转发因为是一次请求，所以地址定位在当前工程下】
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、获取请求的参数   要删除的id
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        // 2、调用BookService.deleteBookById()   通过id删除图书
        bookService.deleteBookById(id);
        // 3、跳回图书管理页面
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、获取请求的参数   封装成Book对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        // 2、调用BookService.updateBook() 修改并保存图书
        bookService.updateBook(book);
        // 3、跳回图书管理页面
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、通过BookService 查询全部图书
        List<Book> books = bookService.queryBooks();
        // 2、把全部图书信息保存早Request域中
        request.setAttribute("books", books);
        // 3、请求转发到/pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、获取请求参数   获取要修改的图书id信息
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        // 2、查询图书信息
        Book book = bookService.queryBookById(id);
        // 3、把图书保存早Request域中
        request.setAttribute("book", book);// 第一个book是起的名字，第二个时Book对象
        // 4、请求转发到图书编辑页面
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

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
        page.setUrl("manager/bookServlet?action=page");
        // 3、保存Page对象到Request 域中
        request.setAttribute("page",page);
        // 4、请求转发到pages/manager/book_manager.jsp
        // !!!!!!请求转发别忘了.forward(request,response)
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }
}