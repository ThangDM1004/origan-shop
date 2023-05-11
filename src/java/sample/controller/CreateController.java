/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import sample.products.ProductERROR;
import sample.products.ProductDAO;
import sample.products.ProductDTO;
import sample.users.UserError;

/**
 *
 * @author MSI AD
 */
public class CreateController extends HttpServlet {

    private static final String ERROR = "admin.jsp";
    private static final String SUCCESS = "admin.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            boolean checkValid = true;
            ProductERROR error = new ProductERROR();
            String proID = request.getParameter("proId");
            String proName = request.getParameter("proName");
            float price = Float.parseFloat(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String information = request.getParameter("information");
            String description = request.getParameter("description");
            
            ProductDAO dao = new ProductDAO();
            boolean checkDuplicate = dao.checkDuplicate(proID);
            if (checkDuplicate) {
                error.setMessage("ID product duplicate");
                checkValid = false;

            }
            if (checkValid){
                ProductDTO pro = new ProductDTO(proID, proName, price, information, quantity, "", description);
                boolean checkInsert = dao.INSERT(pro);
                if (checkInsert) {
                    url = SUCCESS;
                }
            }else{
                request.setAttribute("PRODUCT_ERROR", error);
            }

        } catch (Exception e) {
            log("ERROR at CreateController: " + e.toString());
            
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
