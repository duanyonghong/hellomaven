package web.servlet;


import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author dyh
 * @date 2020.08.27 上午 9:17
 */
@WebServlet(name = "hello",urlPatterns = "/hello")
public class Hello extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name",name);
        jsonObject.put("age",age);
        System.out.println("进来了doPost");
        System.out.println("我是json"+jsonObject);

        PrintWriter out = response.getWriter();
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进来了doGet");
        PrintWriter out = response.getWriter();
        out.println("我是doGet");
        out.println("哈哈哈");
        out.flush();
        out.close();
    }



}
