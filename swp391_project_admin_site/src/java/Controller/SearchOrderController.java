/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.OrderDAO;
import Model.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author doanq
 */
public class SearchOrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDAO od  = new OrderDAO();
        String filter = req.getParameter("filter");
        String search = req.getParameter("search");
        
        String index_row = req.getParameter("index");
        if(index_row==null){
            index_row="1";
        }
        int index = Integer.parseInt(index_row);
        
        int count = od.getTotalOrder(search);
        int endPage = count/10;
        if(count%10!=0){
            endPage++;
        }
        List<Order> listSearchOrder = od.getOrderByFilter(filter,search,index);
        req.setAttribute("mode", "searchorder");
        req.setAttribute("endP", endPage);
        req.setAttribute("index", index);
        req.setAttribute("filter", filter);
        req.setAttribute("search", search);
        req.setAttribute("listAllOrder", listSearchOrder);
        req.getRequestDispatcher("ordermanage.jsp").forward(req, resp);
    }
    
}