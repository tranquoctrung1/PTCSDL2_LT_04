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
public class Cau3 {
    public void Search(String ten, String phong, int luong)
    {
        try 
        {
            DataProvider.Connect("root", "");
        
            String sql = "SELECT * FROM nhanvien WHERE tennv = '"+ten+"'AND phg='"+phong+"'AND luong='"+luong+"'";

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
}
