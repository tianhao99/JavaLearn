package com.tianhao.web; /**
 * @ClassName ${NAME}
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/16 8:50
 * @Version 1.0
 */

import com.google.gson.Gson;
import com.tianhao.bean.Book;
import com.tianhao.bean.Cart;
import com.tianhao.bean.CartItem;
import com.tianhao.service.BookService;
import com.tianhao.service.impl.BookServiceImpl;
import com.tianhao.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    /**
     * 添加购物车，通过ajax和json回传数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数，商品编号
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        // 调用bookService.queryBookById(id);得到图书的信息
        Book book = bookService.queryBookById(id);
        // 把图书的信息，转换成为CartItem商品项
        CartItem cartItem = new CartItem(id, book.getName(), 1, book.getPrice(), book.getPrice());
        // 调用Cart.addItem(CartItem);添加商品
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        // 防止每次添加，都换新的车，这里把车保存在Session会话中
        if (cart == null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        // 通过json返回最后一个商品名称和购物车商品总数量
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());

        Gson gson = new Gson();
        String resultMapString = gson.toJson(resultMap);
        response.getWriter().write(resultMapString);
    }

    /**
     * 添加购物车，用session和请求重定向实现
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数，商品编号
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        // 调用bookService.queryBookById(id);得到图书的信息
        Book book = bookService.queryBookById(id);
        // 把图书的信息，转换成为CartItem商品项
        CartItem cartItem = new CartItem(id, book.getName(), 1, book.getPrice(), book.getPrice());
        // 调用Cart.addItem(CartItem);添加商品
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        // 防止每次添加，都换新的车，这里把车保存在Session会话中
        if (cart == null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        // 在session域中，保存最后一个加入的商品名称
        request.getSession().setAttribute("last",cartItem.getName());
        // 重定向回商品列表页面【回到原来商品所在的页面---加入购物车时的地址栏地址包含参数如页面】
        response.sendRedirect(request.getHeader("Referer"));
    }
    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、获取请求的参数
        int id = WebUtils.parseInt(request.getParameter("id"), 1);
        // 2、获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null){
            // 删除购物车商品
            cart.deleteItem(id);
            // 重定向 回到删除之前的页面
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null)
            cart.clear();
        response.sendRedirect(request.getHeader("Referer"));
    }
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数，商品编号及要修改的数量
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        int count = WebUtils.parseInt(request.getParameter("count"),1);

        Cart cart = (Cart)request.getSession().getAttribute("cart");
        // 防止每次添加，都换新的车，这里把车保存在Session会话中
        if (cart != null){
            cart.updateCount(id,count);
            // 重定向回商品列表页面【回到原来商品所在的页面---加入购物车时的地址栏地址包含参数如页面】
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
}
