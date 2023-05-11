/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.users.UserDAO;
import sample.users.UserDTO;
import sample.users.UserError;

/**
 *
 * @author MSI AD
 */
public class SignUpController extends HttpServlet {

    private static final String ERROR = "create.jsp";
    private static final String SUCCESS = "login.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError user = new UserError();
        UserDAO dao = new UserDAO();
        boolean check = true;
        try {
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String pass = request.getParameter("pass");
            String confirm = request.getParameter("confirm");
            if (name.length() < 5 || name.length() > 20) {
                user.setName("Name must be in [5,20]");
                check = false;
            }
            if (email.length() < 9 || email.length() > 20) {
                if (!email.contains("@")) {
                    user.setEmail("Email not valid (...@...)");
                    check = false;
                }
            }
            boolean checkDuplicate = dao.check_duplicate(email);
            if (checkDuplicate) {
                user.setEmail("Duplicate email!!!");
                check = false;
            }
            if (!pass.equals(confirm)) {
                user.setConfirm("Password not equal!!!");
                check = false;
            }
            if (check == true) {
                UserDTO user_new = new UserDTO(name, email, pass, "US");
                boolean checkInsert = dao.signUp(user_new);
                if (checkInsert) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("USER_ERROR", user);
            }
        } catch (Exception e) {
            log("Error at SignUpController: " + e.toString());
            if (e.toString().contains("Duplicate")) {
                user.setEmail("Duplicate Email");
                request.setAttribute("USER_ERROR", user);
            }
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
