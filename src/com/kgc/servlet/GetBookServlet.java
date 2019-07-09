package com.kgc.servlet;

import com.kgc.entity.Book;
import com.kgc.service.BookService;
import com.kgc.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String bookid = request.getParameter("bookid");
        BookService bookService=new BookServiceImpl();
        if (null!=bookid){
            Book book=bookService.getById(Integer.parseInt(bookid));
            request.getSession().setAttribute("book",book);
            response.sendRedirect(request.getContextPath()+"/detail.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
