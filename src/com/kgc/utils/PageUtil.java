package com.kgc.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 依赖关系：
 *    pageSize---totalCount----totalPage---pageNo(控制上下限)
 */
public class PageUtil {
    private Integer pageSize;
    private Integer pageNo;//页号
    private Integer totalPage;//总页数
    private Integer totalCount;//总条数    setter(存储)
    private List list=new ArrayList();//数据的集合   getter（页面取） setter(存储)

    //初始化pageNo、totalCount、totalPage
    //     1     0    3
    public PageUtil(Integer pageNo,Integer totalCount,Integer pageSize) {
        this.pageSize=pageSize;//3
        this.totalCount = totalCount;//初始化总条数 0
        //初始化总页数,根据总条数算出总页数 0
        this.totalPage=this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:
                this.totalCount/this.pageSize+1;
        if(this.totalPage>0){
            //计算当前页，控制上下限
            if(pageNo<1){//控制下限
                this.pageNo=1;
                //假设用户现在在第  3页显示数据，输入了一个条件，点击了下一页  pageNo=4
            }else if(pageNo>this.totalPage){//控制上限
                this.pageNo=this.totalPage;  //;pageNo=0
            }else{
                this.pageNo = pageNo;
            }
        }else{
            this.pageNo=1;
            this.totalPage=0;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
