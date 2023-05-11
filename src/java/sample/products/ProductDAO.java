/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

public class ProductDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private static final String LOGIN = "SELECT proId,proName,price,information,quantity,img,decription FROM tblProducts";
    private static final String LOGIN1 = "SELECT proId,proName,price,img FROM tblFeaturedProducts";
    private static final String VIEW = "SELECT proName,price,img FROM tblProducts WHERE proId = ?";
    private static final String DETAIL = "SELECT proId,proName,price,img,information,decription FROM tblProducts WHERE proName=?";

    public ProductDTO checkProduct() throws SQLException {
        ProductDTO list = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String proId = rs.getString("proId");
                    String proName = rs.getString("proName");
                    float price = Float.parseFloat(rs.getString("price"));
                    String infomation = rs.getString("information");
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String url = rs.getString("img");
                    String decription = rs.getString("decription");
                    list = new ProductDTO(proId, proName, price, infomation, quantity, url, decription);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                rs.close();
            }
            if (conn != null) {
                rs.close();
            }
        }
        return list;
    }

    public FeaturedProduct checkFeatured() throws SQLException {
        FeaturedProduct list = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN1);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String proId = rs.getString("proId");
                    String proName = rs.getString("proName");
                    float price = Float.parseFloat(rs.getString("price"));
                    String url = rs.getString("img");
                    list = new FeaturedProduct(proId, proName, price, url);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                rs.close();
            }
            if (conn != null) {
                rs.close();
            }
        }
        return list;
    }

    public List<ProductDTO> getAllProduct() {
        try {
            String query = "SELECT * FROM tblProducts";
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<ProductDTO> list = new ArrayList<>();
            while (rs.next()) {
                ProductDTO p = new ProductDTO(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
                list.add(p);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<FeaturedProduct> getFeatureProduct() {
        try {
            String query = "SELECT * FROM tblFeaturedProducts";
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<FeaturedProduct> list = new ArrayList<>();
            while (rs.next()) {
                FeaturedProduct p = new FeaturedProduct(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getString(4));
                list.add(p);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<ProductCart> getViewProduct(String proId) {
        List<ProductCart> list = new ArrayList<>();
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW);
                ptm.setString(1, proId);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String proName = rs.getString("proName");
                    float price = Float.parseFloat(rs.getString("price"));
                    String url = rs.getString("img");
                    ProductCart pro = new ProductCart(proName, price, url, proId);
                    list.add(pro);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ProductDTO> getDetailProduct(String proName) throws SQLException, ClassNotFoundException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DETAIL);
                ptm.setString(1, proName);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String proId = rs.getString("proId");
                    Float price = Float.parseFloat(rs.getString("price"));
                    String url = rs.getString("img");
                    String information = rs.getString("information");
                    String decription = rs.getString("decription");
                    list.add(new ProductDTO(proId, proName, price, information, 0, url, decription));
                }
            }
        } catch (Exception e) {
        }
        return list;
    }
    private static final String STORE = "INSERT INTO tblCart(email,proName,quantity,total,status)" + "VALUES(?,?,?,?,?)";

    public boolean storeProduct(ProductPayment product) throws SQLException {
        boolean checkInsert = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(STORE);
                ptm.setString(1, product.getEmail());
                ptm.setString(2, product.getProName());
                ptm.setInt(3, product.getQuantity());
                ptm.setFloat(4, product.getTotal());
                ptm.setString(5, product.getStatus());
                checkInsert = ptm.executeUpdate() > 0 ? true : false;
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
        return checkInsert;
    }
    private static final String VIEWCART = "SELECT proName,total,status FROM tblCart WHERE email = ?";

    public List<ProductPayment> viewCart(String email) throws SQLException {
        List<ProductPayment> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEWCART);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String proName = rs.getString("proName");
                    float total = Float.parseFloat(rs.getString("total"));
                    String status = rs.getString("status");
                    list.add(new ProductPayment(email, proName, 0, 0, total, status));
                }
            }
        } catch (Exception e) {

        } finally {

        }
        return list;
    }

    private static final String TYPE = "SELECT proId,proName,price,img FROM tblProducts WHERE proId like ?";

    public List<ProductDTO> getTypeProduct(String proId) {
        List<ProductDTO> list = new ArrayList<>();
        PreparedStatement ptm = null;
        try {
            conn = new DBUtils().getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(TYPE);
                ptm.setString(1, proId + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String proName = rs.getString("proName");
                    float price = Float.parseFloat(rs.getString("price"));
                    String url = rs.getString("img");
                    list.add(new ProductDTO(proId, proName, price, "", 0, url, ""));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    private static final String UPDATE = "UPDATE tblCart SET status=? WHERE proName=?";

    public boolean updateStatus(String proName) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, "true");
                ptm.setString(2, proName);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {

        }
        return check;
    }
    private static final String SEARCH = "SELECT proId,proName,price,information,quantity,img,decription FROM tblProducts WHERE proName like ?";

    public List<ProductDTO> search(String search) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String proId = rs.getString("proId");
                    String proName = rs.getString("proName");
                    float price = Float.parseFloat(rs.getString("price"));
                    String url = rs.getString("img");
                    list.add(new ProductDTO(proId, proName, price, "", 0, url, ""));
                }
            }
        } catch (Exception e) {

        }
        return list;
    }

    private static final String LATEST = "SELECT proId,proName,price,img FROM tblLatest";

    public List<ProductDTO> latestProduct() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LATEST);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String proId = rs.getString("proId");
                    String proName = rs.getString("proName");
                    float price = Float.parseFloat(rs.getString("price"));
                    String url = rs.getString("img");
                    list.add(new ProductDTO(proId, proName, price, "", 0, url, ""));
                }
            }
        } catch (Exception e) {

        }
        return list;
    }
    private static final String INSERT = "INSERT INTO tblProducts(proId,proName,price,information,quantity,decription)"+"VALUES(?,?,?,?,?,?)";
    public boolean INSERT(ProductDTO pro) throws SQLException{
        boolean checkInsert = false;
        Connection conn= null;
        PreparedStatement ptm = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!= null){
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, pro.getProId());
                ptm.setString(2, pro.getProName());
                ptm.setFloat(3, pro.getPrice());
                ptm.setString(4, pro.getInformation());
                ptm.setInt(5, pro.getQuantity());
                ptm.setString(6, pro.getDecription());
                checkInsert = ptm.executeUpdate() > 0 ? true : false;
            }
        }catch(Exception e){
            
        }
        return checkInsert;
    }
    private static final String CHECK_DUPLICATE = "SELECT proId FROM tblProducts WHERE proId=?";
    public boolean checkDuplicate(String proID) throws SQLException{
        boolean checkDuplicate = false;
          Connection conn= null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!= null){
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, proID);
                rs = ptm.executeQuery();
                if(rs.next()){
                    checkDuplicate = true;
                }
            }
        }catch(Exception e){
            
        }
        return checkDuplicate;
    }
    private static final String UPDATE_PRODUCT = "UPDATE tblProducts SET price=?,quantity=? WHERE proId=? ";
    public boolean UPDATE(ProductDTO pro) throws SQLException{
        boolean checkUpdate = false;
        Connection conn= null;
        PreparedStatement ptm = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!= null){
                ptm = conn.prepareStatement(UPDATE_PRODUCT);
                ptm.setFloat(1, pro.getPrice());
                ptm.setInt(2, pro.getQuantity());
                ptm.setString(3, pro.getProId());
                checkUpdate = ptm.executeUpdate() > 0 ? true: false;
            }
        }catch(Exception e){
            
        }
        return checkUpdate;
    }
     private static final String DELETE = "DELETE tblProducts WHERE proId=?";
     public boolean DELETE(String proId) throws SQLException{
        boolean checkDelete = false;
        Connection conn= null;
        PreparedStatement ptm = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!= null){
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, proId);
                checkDelete = ptm.executeUpdate() > 0 ? true : false;
            }
        }catch(Exception e){
            
        }
        return checkDelete;
     }
}
