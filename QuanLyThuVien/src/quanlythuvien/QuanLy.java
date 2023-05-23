/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvien;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuanLy implements DAO {

    Scanner s = new Scanner(System.in);

    @Override
    public void INSERT() {
        try {
            Statement stm = ketNoiDB().createStatement();
            System.out.println("Nhap ma loai");
            String maLoai = s.nextLine();
            System.out.println("Nhap ten loai");
            String tenLoai = s.nextLine();
            stm.executeUpdate("INSERT INTO loai_sach "
                    + "VALUES ('" + maLoai + "', N'" + tenLoai + "')");

        } catch (SQLException ex) {
            Logger.getLogger(QuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UPDATE() {
        
    }

    @Override
    public void DELETE() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void SELECT() {

        Scanner s = new Scanner(System.in);
        int op;
        do {
            System.out.println("Truy xuat bang loai sach");
            op = s.nextInt();
            switch (op) {
                case 1: {
                    try {
                        Statement stm = ketNoiDB().createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM loai_sach");
                        ResultSetMetaData mtd = rs.getMetaData();
                        while (rs.next()) {
                            for (int i = 1; i <= mtd.getColumnCount(); i++) {
                                System.out.print(mtd.getColumnName(i) + ":" + rs.getString(i) + "  ");

                            }
                            System.out.println("");
                        }
                        stm.close();
                        rs.close();
                        ketNoiDB().close();
                    } catch (SQLException ex) {
                        Logger.getLogger(QuanLy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case 2: {
                    try {
                        Statement stm = ketNoiDB().createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM sach");
                        ResultSetMetaData mtd = rs.getMetaData();
                        while (rs.next()) {
                            for (int i = 1; i <= mtd.getColumnCount(); i++) {
                                System.out.print(mtd.getColumnName(i) + ":" + rs.getString(i) + "  ");

                            }
                            System.out.println("");
                        }
                        stm.close();
                        rs.close();
                        ketNoiDB().close();
                    } catch (SQLException ex) {
                        Logger.getLogger(QuanLy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case 3: {
                    try {
                        Statement stm = ketNoiDB().createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM sinh_vien");
                        ResultSetMetaData mtd = rs.getMetaData();
                        while (rs.next()) {
                            for (int i = 1; i <= mtd.getColumnCount(); i++) {
                                System.out.print(mtd.getColumnName(i) + ":" + rs.getString(i) + "  ");

                            }
                            System.out.println("");
                        }
                        stm.close();
                        rs.close();
                        ketNoiDB().close();
                    } catch (SQLException ex) {
                        Logger.getLogger(QuanLy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                default:
                    throw new AssertionError();
            }
        } while (op != 0);
    }

    Connection ketNoiDB() throws SQLException {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("06122004");
        ds.setDatabaseName("thu_vien");
        ds.setServerName("HOANG-DUNG");
        ds.setPortNumber(1433);
        ds.setEncrypt(false);
        return ds.getConnection();
    }
}
