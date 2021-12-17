package com.tianhao.service.impl;

import com.tianhao.bean.Book;
import com.tianhao.bean.Page;
import com.tianhao.dao.BookDao;
import com.tianhao.dao.impl.BookDaoImpl;
import com.tianhao.service.BookService;

import java.util.List;

/**
 * @ClassName BookServiceImpl
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/12 17:33
 * @Version 1.0
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        // 每页展示数量
        page.setPageSize(pageSize);
        // 总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        // 总页数【如果不是整除，证明页面放不下，在后面追加一个页面】
        page.setPageTotal(pageTotalCount % pageSize > 0 ? pageTotalCount/pageSize + 1 : pageTotalCount/pageSize);

        // 当前页码
        page.setPageNo(pageNo);//【因为，setPageNo方法，要用到pageTotal总页数属性，所以先设置总页数，再设置当前页】

        // 当前页面展示内容
        int begin = (page.getPageNo() - 1) * pageSize; // 因为setPageNo()方法有可能重置pageNo的值，所以用get方法，不用直接传的参数
        // 【索引开始值，假设每页4个，第3页开始第一个索引就是2*4】
        List<Book> booksItems = bookDao.queryForPageItems(begin,pageSize);
        page.setItems(booksItems);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize,int min,int max) {
        Page<Book> page = new Page<>();
        // 每页展示数量
        page.setPageSize(pageSize);
        // 总记录数
        Integer pagePriceTotalCount = bookDao.queryForPriceTotalCount(min,max);
        page.setPageTotalCount(pagePriceTotalCount);
        // 总页数【如果不是整除，证明页面放不下，在后面追加一个页面】
        page.setPageTotal(pagePriceTotalCount % pageSize > 0 ? pagePriceTotalCount/pageSize + 1 : pagePriceTotalCount/pageSize);

        // 当前页码
        page.setPageNo(pageNo);//【因为，setPageNo方法，要用到pageTotal总页数属性，所以先设置总页数，在设置当前页】

        // 当前页面展示内容
        int begin = (page.getPageNo() - 1) * pageSize; // 因为setPageNo()方法有可能重置pageNo的值，所以用get方法，不用直接传的参数
        // 【索引开始值，假设每页4个，第3页开始第一个索引就是2*4】
        List<Book> booksItems = bookDao.queryForPricePageItems(begin,pageSize,min,max);
        page.setItems(booksItems);
        return page;
    }
}
