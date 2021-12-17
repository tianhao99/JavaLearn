package com.tianhao.service.impl;

import com.tianhao.bean.Book;
import com.tianhao.bean.Page;
import com.tianhao.service.BookService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName BookServiceImplTest
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/12 17:36
 * @Version 1.0
 */
class BookServiceImplTest {
    BookService bookService = new BookServiceImpl();
    @Test
    void addBook() {
        Book fortressBesieged = new Book(null,"围城", "钱钟书", new BigDecimal(100),100,88,"static/img/fortressbesieged.png");
        bookService.addBook(fortressBesieged);
    }

    @Test
    void deleteBookById() {
        bookService.deleteBookById(6);
    }

    @Test
    void updateBook() {
        Book sixChapters = new Book(4,"浮生六记", "沈复", new BigDecimal(88),155,77,"static/img/sixchapters.png");
        bookService.updateBook(sixChapters);
    }

    @Test
    void queryBookById() {
        Book book = bookService.queryBookById(4);
        System.out.println(book);
    }

    @Test
    void queryBooks() {
        List<Book> books = bookService.queryBooks();
        books.forEach(System.out::println);
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,5,55));
    }
}