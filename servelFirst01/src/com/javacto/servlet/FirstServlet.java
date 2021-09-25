package com.javacto.servlet;

import com.sun.org.apache.xpath.internal.objects.XObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 1.创建一个类
 * 2.继承HttpServlet
 * 3.重写service 方法
 * 4.在web.xml里配置FirstServlet 类
 */
public class FirstServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
        resp.setContentType("text/html;charset=UTF-8");
        //创建打印对象
        PrintWriter scan=resp.getWriter();
        scan.println("欢迎使用 welcome to my servlet programme!");


    }
}
