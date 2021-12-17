package com.tianhao.bean;

import java.util.List;

/**
 * @ClassName Page
 * @Description TODO:分页模块
 * page是分页的模型对象
 * <T>是具体的模块的JavaBean【就是可以对任何页面，套用此分页模块，只要更换不同的对象就行了】
 * @Author sth_199509@163.com
 * @Date 2021/11/14 21:38
 * @Version 1.0
 */
public class Page<T> {
    // Fields
    // 每页显式数据条数
    public static final Integer PAGE_SIZE = 4;
    // 当前页码
    private Integer pageNo;
    // 总页码数
    private Integer pageTotal;
    // 当前页显式数量
    private Integer pageSize = PAGE_SIZE;
    // 总记录数
    private Integer pageTotalCount;
    // 当前页面数据
    private List<T> items;
    // 请求地址
    String url;

    // Constructors
    public Page() {}

    public Page(Integer pageNo, Integer pageTotal, Integer pageSize, Integer pageTotalCount, List<T> items, String url) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
        this.pageTotalCount = pageTotalCount;
        this.items = items;
        this.url = url;
    }

    // Methods
    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public void setPageNo(Integer pageNo) {
        // 数据边界的有效检查【这个代码要写在setPageSize后边，因为要用pageSize属性】
        /**
         * 方案：大于总页码，置为总页码
         * 小于第一页，置为第一页
         */
        if (pageNo < 1){
            this.pageNo = 1;
        }else if (pageNo > pageTotal){
            this.pageNo = pageTotal;
        }else{
            this.pageNo = pageNo;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
