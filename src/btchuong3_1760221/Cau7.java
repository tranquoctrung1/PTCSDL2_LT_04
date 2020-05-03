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
public class Cau7 {
    public void Select()
    {
        try 
        {
            DataProvider.Connect("root", "");
        
            String sql = "SELECT * FROM phancong";

            ResultSet rs = DataProvider.Select(sql);
            while(rs.next())
            {
                String manv = rs.getString("ma_nvien");

                System.out.print(manv+"\n");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        DataProvider.Disconnect();
    }
    
    public int Insert(String manv, String mada, int stt, String thoigian)
    {
        DataProvider.Connect("root", "");
        
        String sql = "INSERT INTO phancong(ma_nvien, mada, stt, thoigian) VALUES('"+manv+"','"+mada+"','"+stt+"','"+thoigian+"')";
        
        int rows = DataProvider.Insert(sql);
        
        DataProvider.Disconnect();
        
        return rows;
    }
    
    public int Delete(String manv)
    {
        DataProvider.Connect("root", "");

        String sql = "DELETE FROM phancong WHERE ma_nvien = '"+manv+"'";

        int rows = DataProvider.Delete(sql);

        DataProvider.Disconnect();

        return rows;
    }
    
    public boolean Update(String thoigian, String manv)
    {
        DataProvider.Connect("root", "");

        String sql = "UPDATE phancong SET thoigian = '"+thoigian+"' WHERE ma_nvien = '"+manv+"'"; 

        boolean isUpdate = DataProvider.Update(sql);

        DataProvider.Disconnect();

        return isUpdate;
    }
}
