package com.javacto.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        String name=req.getParameter("userName");
        String pwd=req.getParameter("pwd");
        String cpwd=req.getParameter("cpwd");
        String email=req.getParameter("email");
        String phone=req.getParameter("phone");

        PrintWriter pw=resp.getWriter();
        pw.println("登陆成功");

    }
}
