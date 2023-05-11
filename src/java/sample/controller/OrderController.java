/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.bill.BillDAO;
import sample.bill.BillDTO;
import sample.products.ProductDAO;

/**
 *
 * @author MSI AD
 */
public class OrderController extends HttpServlet {

    private static final String error = "checkout.jsp";
    private static final String index = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = error;
        try {
            String email = request.getParameter("email");
            String first = request.getParameter("first");
            String last = request.getParameter("last");
            String phone = request.getParameter("Phone");
            String city = request.getParameter("city");
            String distrist = request.getParameter("distrist");
            String ward = request.getParameter("ward");
            String address = request.getParameter("address");
            String note = request.getParameter("note");
            String payment = request.getParameter("cmbPayment");
            BillDTO bill = new BillDTO(email, first, last, phone, city, distrist, ward, address, note, payment);
            BillDAO dao = new BillDAO();
            boolean check = dao.checkInsert(bill);
             Cookie[] cookies = request.getCookies();
            if (check) {
                String proName = request.getParameter("proName");
                ProductDAO pdao = new ProductDAO();
                boolean checkUpdate = pdao.updateStatus(proName);
                if (checkUpdate) {
                    url = index;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
