package com.yatop.lambda.core.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public class PagerUtil {

    //页码1时，默认查询一次total count，小于1时全部查询，最多查询第1000页
    private int pageNo;

    //页大小，每次请求的分页大小，小于1时全部查询，每页最多1000条
    private int pageSize;

    private Page page;

    public PagerUtil() {
        init();
    }

    public PagerUtil(int pageNo, int pageSize) {
        init(pageNo, pageSize);
    }

    private void init() {
        init(1, 10);
    }

    private void init(int pageNo, int pageSize) {
        setPageNo(pageNo);
        setPageSize(pageSize);
        this.page = null;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo < 1000 ? pageNo : 1000;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize < 1000 ? pageSize : 1000;
    }

    public long getTotalCount() {
        if(this.isNeedTotalCount() && DataUtil.isNotNull(this.page)) {
            return this.getPage().getTotal();
        }
        return -1;
    }

    public boolean isNeedTotalCount() {
        return pageNo == 1 ? pageSize > 0 : false;
    }

    public boolean isNeedPage() {
        return pageNo > 0 && pageSize > 0;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public static void startPage(PagerUtil pager) {
        if(DataUtil.isNotNull(pager) && pager.isNeedPage()) {
            pager.setPage(PageHelper.startPage(pager.getPageNo(), pager.getPageSize(), pager.isNeedTotalCount()));
        }
    }

    public static void clearPage(PagerUtil pager) {
        if(DataUtil.isNotNull(pager) && pager.isNeedPage()) {
            PageHelper.clearPage();
        }
        pager.init();
    }
}
