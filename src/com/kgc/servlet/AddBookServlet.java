package com.kgc.servlet;

import com.kgc.entity.Book;
import com.kgc.service.BookService;
import com.kgc.service.impl.BookServiceImpl;
import com.kgc.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String author = request.getParameter("author");
        String bookname = request.getParameter("bookname");
        String price = request.getParameter("price");
        String pubtime = request.getParameter("pubtime");
        String typeid = request.getParameter("typeid");

        BookService bookService=new BookServiceImpl();
        Book book=new Book();
        book.setAuthor(author);
        book.setBookname(bookname);
        book.setPrice(Double.parseDouble(price));
        book.setPubtime(DateUtils.String2Date(pubtime,"yyyy-MM-dd"));
        book.setTypeid(Integer.parseInt(typeid));

        if(bookService.addBook(book)){
            String url=request.getContextPath()+"/index.jsp";
            response.getWriter().write("<script type='application/javascript'>alert('添加成功');location.href='"+url+"'</script>");
        }else {
            response.getWriter().write("<script type='application/javascript'>alert('添加失败');history.go(-1)</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
