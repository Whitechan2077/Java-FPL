/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pha_data_base;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;

/**
 *
 * @author buidu
 */
public class Pha_data_base {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ResultSet rs;
            try (Statement stm = connect().createStatement()) {
                rs = stm.executeQuery("SELECT sach.ma_loai,sach.ten_sach "
                        + "FROM loai_sach JOIN sach ON "
                        + "loai_sach.ma_loai = sach.ma_loai");
                ResultSetMetaData rsmtd = rs.getMetaData();
                while (rs.next()) {
                    for(int i = 1 ; i<= rsmtd.getColumnCount();i++){
                        System.out.print(rsmtd.getColumnName(i));
                        System.out.print(rs.getString(i)+" ");
                    }
                    System.out.println("");
                }
            }
            rs.close();
            connect().close();
           
        } catch (SQLException ex) {
            System.out.println("Nhap that bai");
        }
    }

    public static Connection connect() throws SQLException {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("06122004");
        ds.setDatabaseName("thu_vien");
        ds.setServerName("HOANG-DUNG");
        ds.setPortNumber(1433);
        ds.setEncrypt(false);
        try (Connection conn = ds.getConnection()) {
            System.out.println("Ket noi thanh cong");
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        }
        return ds.getConnection();
    }
}
