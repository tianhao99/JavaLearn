package com.tianhao.service;

import com.tianhao.bean.Book;
import com.tianhao.bean.Page;

import java.util.List;

/**
 * @ClassName BookService
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/12 17:32
 * @Version 1.0
 */
public interface BookService {
    /**
     * 添加图书
     * @param book
     * @return
     */
    void addBook(Book book);

    /**
     * 根据ID删除图书
     * @param id
     * @return
     */
    void deleteBookById(Integer id);

    /**
     * 更改图书信息
     * @param book
     * @return
     */
    void updateBook(Book book);

    /**
     * 根据ID查找图书
     * @param id
     * @return
     */
    Book queryBookById(Integer id);

    /**
     * 查询所有图书
     * @return
     */
    List<Book> queryBooks();

    /**
     * 实现分页功能
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Book> page(int pageNo, int pageSize);

    /**
     * 根据价格区间搜索图书
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Book> pageByPrice(int pageNo, int pageSize,int min,int max);
}
