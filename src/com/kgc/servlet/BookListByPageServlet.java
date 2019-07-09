package com.kgc.servlet;

import com.kgc.entity.BookType;
import com.kgc.service.BookService;
import com.kgc.service.BookTypeService;
import com.kgc.service.impl.BookServiceImpl;
import com.kgc.service.impl.BookTypeServiceImpl;
import com.kgc.utils.BookParam;
import com.kgc.utils.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookListByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //取
        String typeid = request.getParameter("typeid");
        String author = request.getParameter("author");
        String min_price = request.getParameter("min_price");
        String max_price = request.getParameter("max_price");
        String s_pageNo = request.getParameter("pageNo");

        //调
        BookService bookService=new BookServiceImpl();
        BookTypeService bookTypeService=new BookTypeServiceImpl();

        //1、把参数封装到参数工具类
        BookParam bookParam=new BookParam(typeid,author,min_price,max_price);
        //2、判断是否是第1次访问，控制pageNo=null
        if(null==s_pageNo){
            s_pageNo="1";
        }
        Integer pageNo=Integer.parseInt(s_pageNo);
        //3、查询当前页存PageUtil
        Integer pageSize=3;
        PageUtil pageUtil = bookService.getBookByPage(pageNo, pageSize, bookParam);
        List<BookType> bookTypeList = bookTypeService.getBookTypeList();
        //4、存储数据PageUtil和全部的图书类型列表到作用域 request
        request.setAttribute("pageUtil",pageUtil);
        request.setAttribute("bookTypeList",bookTypeList);
        //5、存储回显数据（参数工具类）到作用域 request
        request.setAttribute("bookParam",bookParam);
        //6、转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}