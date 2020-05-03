/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btchuong3_1760221;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tqtr
 */
public class Cau1 {
    public void Select()
    {
        try 
        {
            DataProvider.Connect("root", "");
        
            String sql = "SELECT * FROM nhanvien";

            ResultSet rs = DataProvider.Select(sql);
            while(rs.next())
            {
                String manv = rs.getString("manv");

                System.out.print(manv+"\n");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        DataProvider.Disconnect();
    }
    
    public int Insert(String ho,String tenlot,String ten,String manv,String ngaysinh,String diachi,String phai,int luong, String manql, String phong)
    {
        DataProvider.Connect("root", "");

        String sql = "INSERT INTO nhanvien(honv, tenlot, tennv, manv, ngsinh, phai, luong, ma_nql, phg, diachi) "
            + "VALUES('"+ ho +"','"+ tenlot+"', '"+ten+"', '"+manv+"', '"+ngaysinh+"', '"+phai +"', '"+luong +"', '"+manql +"', '"+phong +"', '"+diachi +"')";

        int rows = DataProvider.Insert(sql);

        DataProvider.Disconnect();

        return rows;
    }
    
    public int Delete(String manv)
    {
        DataProvider.Connect("root", "");

        String sql = "DELETE FROM nhanvien WHERE manv = '"+manv+"'";

        int rows = DataProvider.Delete(sql);

        DataProvider.Disconnect();

        return rows;
    }
    
    public boolean Update(int luong, String manv)
    {
        DataProvider.Connect("root", "");

        String sql = "UPDATE nhanvien SET luong = '"+luong+"' WHERE manv = '"+manv+"'"; 

        boolean isUpdate = DataProvider.Update(sql);

        DataProvider.Disconnect();

        return isUpdate;
        
    }
}
