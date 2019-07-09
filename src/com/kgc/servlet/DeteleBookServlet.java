package com.kgc.servlet;

import com.kgc.service.BookService;
import com.kgc.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeteleBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String bookid = request.getParameter("bookid");


        BookService bookService=new BookServiceImpl();
        if(bookid!=null){
            String url=request.getContextPath()+"/index.jsp";
            if(bookService.deteleBook(Integer.parseInt(bookid))){
                response.getWriter().write("<script type='application/javascript'>alert('删除成功');location.href='"+url+"'</script>");
            }else {
                response.getWriter().write("<script type='application/javascript'>alert('删除失败');location.href='"+url+"'</script>");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
