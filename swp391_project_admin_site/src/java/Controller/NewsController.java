/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.NewsDAO;
import Model.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NewsController extends HttpServlet {

    NewsDAO dao = new NewsDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tit = req.getParameter("title");
        if (tit == null) {
            tit = "";
        }
        List<News> data = dao.getListNews(tit);
        req.setAttribute("listNews", data);
        req.setAttribute("title", tit);
        req.getRequestDispatcher("newsmanage.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<News> data = dao.getListNews("");
        req.setAttribute("listNews", data);
        req.getRequestDispatcher("newsmanage.jsp").forward(req, resp);
    }

}
