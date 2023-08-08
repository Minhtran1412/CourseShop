/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.NewsDAO;
import Model.AccountAdmin;
import Model.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 *
 * @author Admin
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class UpdateNewsContrller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsDAO dao = new NewsDAO();
        HttpSession session = req.getSession();
        AccountAdmin a = (AccountAdmin) session.getAttribute("account");

        String title = req.getParameter("news_title");
        String desc = req.getParameter("news_description");
        String shortDes = req.getParameter("short");
        String news_id = req.getParameter("newsId");

        LocalDate createDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String convertCD = createDate.format(dateTimeFormatter);
        LocalDate modifyDate = LocalDate.now();
        String convertModifyDate = modifyDate.format(dateTimeFormatter);
        String createBy = a.getAccount_name();
        String modifyBy = a.getAccount_name();

        String img = dao.getNewsId(news_id).getImg();
        Part filePart = req.getPart("file");
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = UUID.randomUUID() + "_" + getFileName(filePart);
            String uploadPath = getServletContext().getRealPath("usercss/images/NewsImage");
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            filePart.write(uploadPath + File.separator + fileName);
            img = fileName;
        }
        dao.newsUpdate(news_id, title, desc, shortDes, img);
        resp.sendRedirect("newsmanage");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("mode").equals("newsupdate")) {
            String id = req.getParameter("newsId");
            NewsDAO dao = new NewsDAO();
            News n = dao.getNewsId(id);
            req.setAttribute("newsInfo", n);
            req.setAttribute("mode", "newsupdate");
        }
        req.getRequestDispatcher("newsUpdate.jsp").forward(req, resp);
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return UUID.randomUUID().toString();
    }
}
