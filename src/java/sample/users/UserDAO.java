package sample.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sample.utils.DBUtils;

public class UserDAO {

    private static final String LOGIN = "SELECT name, role FROM tblUsers WHERE email = ? AND password = ?";
    private static final String CHECK_DUPLICATE = "SELECT email FROM tblUsers WHERE email = ?";
    private static final String SIGNUP = "INSERT INTO tblUsers(name,email,password,role)" + "VALUES(?,?,?,?)";

    public UserDTO checkLogin(String email, String pass) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, email);
                ptm.setString(2, pass);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    String role = rs.getString("role");
                    user = new UserDTO(name, email, pass, role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

    public boolean check_duplicate(String email) throws SQLException {
        boolean check = false;
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean signUp(UserDTO user) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SIGNUP);
                ptm.setString(1, user.getName());
                ptm.setString(2, user.getEmail());
                ptm.setString(3, user.getPass());
                ptm.setString(4, user.getRole());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
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
