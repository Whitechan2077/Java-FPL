package Connect;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
    
    public static void main(String[] args) throws SQLException {
//        while (true) {            
//            connect();
//        }
        Statement stm = connect().createStatement();
//        stm.executeUpdate("INSERT INTO sach "
//                + "VALUES(124,'Ong Vua Tinh Duc','Nguyen Chim','200','sex','69','10','Quay sex','IT','SQL','2023-1-4');");
        ResultSet rs =  stm.executeQuery("SELECT * FROM sach");
        while (rs.next()) {            
                  String tenSach = rs.getNString("ten_sach");
                  System.out.println("Ten Sach"+tenSach);  
        }
        
    }
    
    public static Connection connect() throws SQLException{
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("06122004");
        ds.setDatabaseName("thu_vien");
        ds.setServerName("HOANG-DUNG");
        ds.setPortNumber(1433);
        ds.setEncrypt(false);
        try(Connection conn = ds.getConnection()){
            System.out.println("ket noi");
        }
        
      catch (SQLServerException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
       return ds.getConnection();
}
}
