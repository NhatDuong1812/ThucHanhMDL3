package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    Connection connection = ConnectDB.getConnection();
//    List<Product> productList = new ArrayList<>();

//    private final String ADD_NEW_PRODUCT = "call addNewProduct(?, ?, ?, ?, ?, ?)";
//    private final String EDIT_PRODUCT = "call editProduct(?, ?, ?, ?, ?, ?)";
//    private final String DELETE_PRODUCT = "call deleteProduct(?)";
//    private final String GET_ALL_PRODUCT = "select * form productlist";

    public ProductService() {
    }

    public boolean addNewProduct(Product product) {
        boolean isAdd = false;
        String sql = "insert into productlist values (?,?,?,?,?,?)";
        try {
            PreparedStatement cs = connection.prepareStatement(sql);
            cs.setInt(1, product.getId());
            cs.setString(2, product.getName());
            cs.setString(3, product.getPrime());
            cs.setString(4, product.getQuantity());
            cs.setString(5, product.getColor());
            cs.setString(6, product.getStatus());
            isAdd = cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdd;
    }

    public boolean edieProduct(Product product) {
        boolean isEdit = false;
        String sql = "update productlist set Name = ?,Prime = ?, Quantity = ?,Color =? , Status = ?   where id = ?";
        try {
            PreparedStatement cs = connection.prepareStatement(sql);
            cs.setString(1, product.getName());
            cs.setString(2, product.getPrime());
            cs.setString(3, product.getQuantity());
            cs.setString(4, product.getColor());
            cs.setString(5, product.getStatus());
            cs.setInt(6, product.getId());
            isEdit = cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isEdit;
    }

    public List<Product> getProductList() {
        List<Product> products = new ArrayList<>();
        String sql = "select * from productlist";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String prime = rs.getString("prime");
                String quantity = rs.getString("quantity");
                String color = rs.getString("color");
                String status = rs.getString("status");
//int catId = rs.getInt("catId");
                Product product = new Product(id, name, prime, quantity, color, status);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public boolean deleteProduct(int productID) {
        boolean isDelete = false;
        String sql = "delete from productlist where id = ?";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setInt(1, productID);
            isDelete = cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDelete;
    }

    public Product searchProductByID(int productId) {
        Product product = null;
        String sql = "select * from productlist where id = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, productId);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String prime = resultSet.getString("prime");
                String quantity = resultSet.getString("quantity");
                String color = resultSet.getString("color");
                String status = resultSet.getString("status");

                product = new Product(productId, name, prime, quantity, color, status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    public Product getProductByName(String productName) {
        Product product = null;
        String sql = "select * from productlist where name = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, productName);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String prime = rs.getString("prime");
                String quantity = rs.getString("quantity");
                String color = rs.getString("color");
                String status = rs.getString("status");

                product = new Product(id, name, prime, quantity, color, status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

///test code

//    public Product selectProduct(int id) {
//        Product product = null;
//        String sql = "select productlist.id,productlist.name,productlist.amount,productlist.color,productlist.description,productlist.price,category.cat_name from productlist join category on productlist.cat_id = category.cat_id"
//        try {
//            PreparedStatement pstm = connection.prepareStatement(sql);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

}
