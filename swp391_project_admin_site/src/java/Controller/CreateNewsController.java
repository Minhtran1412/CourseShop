/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.NewsDAO;
import Model.AccountAdmin;
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
public class CreateNewsController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        NewsDAO dao = new NewsDAO();
        HttpSession session = req.getSession();
        AccountAdmin a = (AccountAdmin) session.getAttribute("account");
        if (req.getParameter("newscreate") != null) {
            Part filePart = req.getPart("file");
            String fileName = UUID.randomUUID() + "_" + getFileName(filePart);
            String uploadPath = getServletContext().getRealPath("usercss/images/NewsImage");
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            filePart.write(uploadPath + File.separator + fileName);
            String title = req.getParameter("news_title");
            String desc = req.getParameter("news_description");
            String short_des = req.getParameter("short");
            LocalDate createDate = LocalDate.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String convertCD = createDate.format(dateTimeFormatter);
            LocalDate modifyDate = LocalDate.now();
            String convertModifyDate = modifyDate.format(dateTimeFormatter);
            String createBy = a.getAccount_name();
            String modifyBy = a.getAccount_name();
//            String newsImg = "usercss/images/CourseImage/" + req.getParameter("newsImg");
            dao.newsCreate(title, desc, convertCD, convertModifyDate, createBy, modifyBy, short_des, fileName);
            resp.sendRedirect("newsmanage");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mode", req.getParameter("mode"));
        req.getRequestDispatcher("newscrud.jsp").forward(req, resp);

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
