package com.tianhao.service.impl;

import com.tianhao.bean.*;
import com.tianhao.dao.BookDao;
import com.tianhao.dao.OrderDao;
import com.tianhao.dao.OrderItemDao;
import com.tianhao.dao.impl.BookDaoImpl;
import com.tianhao.dao.impl.OrderDaoImpl;
import com.tianhao.dao.impl.OrderItemDaoImpl;
import com.tianhao.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/16 16:37
 * @Version 1.0
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer user_id) {
        // 订单号【如何保证唯一？？】
        // 1、时间戳【双十一高并发怎么办】
        // 2、加上用户id，每个id同一时间【必然唯一】
        String order_id = System.currentTimeMillis() + "" + user_id;
        // 创建一个订单对象
        Order order = new Order(order_id,new Date(),cart.getTotalPrice(),0,user_id);
        // 保存订单
        orderDao.saveOrder(order);

        // 遍历购物车中每一个商品项转换成为订单项保存到数据库
        for (Map.Entry<Integer, CartItem>entry : cart.getItems().entrySet()){
            // 获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
            // 转换为每一个订单项
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), order_id);
            // 保存到数据库中
            orderItemDao.saveOrderItem(orderItem);

            // 通过id查到这本书的对象
            Book book = bookDao.queryBookById(cartItem.getId());
            // 对这个对象进行销量库存的调整
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            // 调用bookDao更新数据库中这本书的信息【库存和销量】
            bookDao.updateBook(book);
        }
        // 清空购物车【结账完成】
        cart.clear();
        return order_id;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDao.queryOrder();
    }

    @Override
    public void sendOrder(String order_id) {
        orderDao.changeOrderStatus(order_id,1);
    }

    @Override
    public List<OrderItem> showOrderDetail(String order_id) {
        return orderItemDao.queryOrderItemsByOrder_id(order_id);
    }

    @Override
    public List<Order> showMyOrders(Integer user_id) {
        return orderDao.queryOrdersByUser_id(user_id);
    }

    @Override
    public void receiverOrder(String order_id) {
        orderDao.changeOrderStatus(order_id,2);
    }
}
