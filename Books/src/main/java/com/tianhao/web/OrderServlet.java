package com.tianhao.web; /**
 * @ClassName ${NAME}
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/16 16:57
 * @Version 1.0
 */

import com.tianhao.bean.Cart;
import com.tianhao.bean.Order;
import com.tianhao.bean.OrderItem;
import com.tianhao.bean.User;
import com.tianhao.service.OrderService;
import com.tianhao.service.impl.OrderServiceImpl;
import com.tianhao.utils.JdbcUtils;
import com.tianhao.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    /**
     * 签收订单/确认收货 status = 2
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void receiverOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String order_id = request.getParameter("order_id");
        orderService.receiverOrder(order_id);
        List<Order> orders = orderService.showAllOrders();
        request.getSession().setAttribute("orders",orders);
        response.sendRedirect(request.getContextPath() + "/pages/manager/order_manager.jsp");
    }

    /**
     * 查看我的订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showMyOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数user_id
        int user_id = WebUtils.parseInt(request.getParameter("user_id"),1);
        // 调用orderService.showMyOrders(user_id)方法
        List<Order> myOrders = orderService.showMyOrders(user_id);
        // 设置session域保存获取到订单信息
        request.getSession().setAttribute("myOrders",myOrders);
        // 重定向
        response.sendRedirect(request.getContextPath() + "/pages/order/order.jsp");
    }

    /**
     * 查看订单详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showOrderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        String order_id = request.getParameter("order_id");
        // 调用orderService.showOrderDetail(order_id)方法，获取订单的详细信息【包=包括里面的每一项orderitem】
        List<OrderItem> orderItems = orderService.showOrderDetail(order_id);
        request.getSession().setAttribute("orderItems",orderItems);
        response.sendRedirect(request.getContextPath() + "/pages/order/order_manager_detail.jsp");
    }

    /**
     * 变更订单状态为【发货】status = 1
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String order_id = request.getParameter("order_id");
        orderService.sendOrder(order_id);
        // 修改完成后，重新获取一下订单列表
        List<Order> orders = orderService.showAllOrders();
        // 将重新获取的订单列表放在session域中，不获取的话，不能立即变更状态，
        // 因为session域中还是修改之前的订单对象【退出页面再进去，才能看见新的状态】
        request.getSession().setAttribute("orders",orders);
        // 重定向回订单管理页面
        response.sendRedirect(request.getContextPath() + "/pages/manager/order_manager.jsp");
    }


    /**
     * 查看所有订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = orderService.showAllOrders();
        request.getSession().setAttribute("orders",orders);
        response.sendRedirect(request.getContextPath() + "/pages/manager/order_manager.jsp");

    }

    /**
     * 创建订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 先获取cart对象
    Cart cart = (Cart) request.getSession().getAttribute("cart");
    // 再获取userid
    User loginUser = (User) request.getSession().getAttribute("user");
    if (loginUser == null){
        // 用户为空，让他去登录
        request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        // 一般转发和重定向之后，不再需要继续执行时，后边加一个return
        return;
    }
    Integer user_Id = loginUser.getId();

    // 调用orderService.createOrder(Cart,User_id);生成订单
    String order_id = orderService.createOrder(cart, user_Id);

    // 把生成的order_id 保存到域中，后面页面要展示
    request.getSession().setAttribute("order_id",order_id);
    // 请求转发到/pages/cart/checkout.jsp
    response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
//        request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request,response);

    }

}
