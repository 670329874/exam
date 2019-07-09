package com.kgc.servlet;

import com.kgc.entity.BookType;
import com.kgc.service.BookTypeService;
import com.kgc.service.impl.BookTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PerAddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        BookTypeService bookTypeService=new BookTypeServiceImpl();
        List<BookType> bookTypeList = bookTypeService.getBookTypeList();
        request.getSession().setAttribute("bookTypeList",bookTypeList);
        response.sendRedirect(request.getContextPath()+"/addBook.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
