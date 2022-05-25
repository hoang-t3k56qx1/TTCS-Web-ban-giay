package dal;

import model.Catalog;
import model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Item;
import model.User;

/**
 *
 * @author trinh
 */
public class DAO extends DBContext{
    //lay ra tat ca sp product trang chu
    public  List<Product> getAllProduct()  {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    //lay ra tat ca sp Catalog cid trang chu
    public List<Product> getProductByCID(int c_id)  {
        if(c_id ==0){
            return getAllProduct();
        }
        String sql = "select * from product where c_id= ?";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, c_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    // tim kiem nhu nhap tu
    public List<Product> getProductSearch(String txtsearch)  {
        String sql = "select * from product where p_name like ?";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+txtsearch+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    // lay ra sp co id khi kick vao trang chu
    public Product getProductByID(int p_id)  {
        String sql = "select * from product where p_id= ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, p_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                    Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
                    return product;
            }
        } catch (Exception e) {
        }
        return null;
    }
    //lay ra tat ca sp Catalog
    public List<Catalog> getAllCatalog() {
        List<Catalog> list = new ArrayList<>();
        String sql = "select * from Catalog";
        try {
           PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Catalog(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    // lay sp cuoi cung trong bang product
    public Product getLast() {
        String sql = "select top 1 * from Product\n"
                + "order by p_id desc";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
    // kiem tra luc dang nhap
    //select * from [User] where [user] = 'admin' and pass = 123;
    public User login(String user, String pass){
        String sql = "select * from [User] \n"
                + "where [user] = ? and pass = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return null;
    }
    // dang ki taikhoan
    //INSERT INTO [User] VALUES (N'sa', N'123', N'Hoa',N'16/02/2008', N'abc@gmail.com', N'07865676', 0);
    public void addUser(String user, String pass, String u_name, 
            String dateofbirth, String email, String phone){
        String sql = "INSERT INTO [User] VALUES (?, ?, ?,?, ?, ?, 0);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, u_name);
            ps.setString(4, dateofbirth);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    // xoa product
    // select from Product where p_id = ?
    public void deleteProduct(int p_id){
        String sql = "delete from Product where p_id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, p_id);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    // them sp
    
    public void addproduct(String name, String image, Double price, 
            String title, String description, int catalog){
        String sql = "INSERT INTO [Product] VALUES (?, ?, ?,?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setDouble(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setInt(6, catalog);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    //UPDATE [Product]
//SET p_name=N'Giày nam adidas', image=N'https://cf.shopee.vn/file/504fad5c8366ba9857f19a594e2c587a', price=250.0,title=N'Giày adidas cho nam.', description=N'Giày adidas cho nam. Size từ 34-42'
//WHERE p_id = 1;
    public void fixproduct(int p_id,String p_name, String image, Double price, 
            String title, String description){
        String sql = "UPDATE [Product] \n" +
            " SET p_name=?, [image]=?, price=?,title=?, [description]=? \n" +
            " WHERE p_id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p_name);
            ps.setString(2, image);
            ps.setDouble(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setInt(6, p_id);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    // them vao hoa don
    public void addOrder(User u, Cart cart){
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        try{
            String sql ="insert into [Order] values(?, ?, ?);";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, date);
            st.setInt(2, u.getU_id());
            st.setDouble(3, cart.getTotalMoney());
            st.executeUpdate();
            // lay ra id cua Order vua add
            String sql1 ="select top 1 o_id from [Order] order by o_id desc;";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();
            // them vao bang OrderLine
            while(rs.next()){
                int oid = rs.getInt(1);
                for (Item i : cart.getItems()) { 
                    String sql2 = "insert into [OrderLine] values(?,?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, oid);
                    st2.setInt(2, i.getProduct().getP_id());
                    st2.setInt(3, i.getQuantity());
                    st2.setDouble(4, i.getTotalMoney());
                    st2.executeQuery();
                }
                
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    // thay doi thong tin ca nhan
    
    public void UpdateUser(int id, String ten, String ns, String sdt, String email){
        String sql="UPDATE [User]\n " +
                    "SET u_name = ?, dateofbirth = ?,email= ?, phone = ?\n " +
                    "WHERE u_id= ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ten);
            ps.setString(2, ns);
            ps.setString(3, sdt);
            ps.setString(4, email);
            ps.setInt(5, id);
            ps.executeUpdate();      
        } catch (Exception e) {
        }
    }
    // thay doi mk
    public void UpdatePassUser(int id, String pass){
        String sql="UPDATE [User]\n " +
                   "SET pass = ?\n " +
                   "WHERE u_id= ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setInt(2, id);
            ps.executeUpdate();      
        } catch (Exception e) {
        }
    }
    // lấy ra User co id
    public User getUserById(int id){
        String sql = "SELECT * FROM [User]\n " +
                     "WHERE u_id= ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));
            }
            
        } catch (Exception e) {
        }
    return null;
    }
    
        // test ket noi co so du lieu
    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Product> list = dao.getAllProduct();
        List<Catalog> listC = dao.getAllCatalog();
        System.out.println(list.size());
        System.out.println(listC.size());
        Product a = dao.getLast();
        System.out.println(a);
        dao.fixproduct(1, "Giày nam", "https://cf.shopee.vn/file/504fad5c8366ba9857f19a594e2c587a",
                250.0, "Giày adidas cho nam.", "Giày adidas cho nam. Size từ 34-42");

        

    }
}
