/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sample.utils.DBUtils;

public class BillDAO {

    private static final String INSERT = "INSERT INTO tblBill(first,last,phone,city,district,ward,address,note,payment,email)" + "VALUES(?,?,?,?,?,?,?,?,?,?)";

    public boolean checkInsert(BillDTO bill) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, bill.getFirst());
                ptm.setString(2, bill.getLast());
                ptm.setString(3, bill.getPhone());
                ptm.setString(4, bill.getCity());
                ptm.setString(5, bill.getDistrist());
                ptm.setString(6, bill.getWard());
                ptm.setString(7, bill.getAddress());
                ptm.setString(8, bill.getNote());
                ptm.setString(9, bill.getPayment());
                ptm.setString(10, bill.getEmail());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {

        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
