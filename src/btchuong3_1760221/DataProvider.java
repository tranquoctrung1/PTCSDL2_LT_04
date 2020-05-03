package btchuong3_1760221;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.ResultSet;
/**
 *
 * @author tqtr
 */
public class DataProvider {
    
    static Connection conn;
    
    public static void Connect( String username, String password)
    {
        Properties infor = new Properties();
        infor.setProperty("characterEncoding", "utf8");
        infor.setProperty("user", username);
        infor.setProperty("password", password);
        String connection = "jdbc:mysql://localhost:8080/qldact";
        try 
        {
            conn = DriverManager.getConnection(connection, infor);
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Disconnect()
    {
        try 
        {
            if(conn != null)
            { 
               conn.close();   
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ResultSet Select(String sql)
    {
        try 
        {
           Statement statement = conn.createStatement();
        
            ResultSet rs = statement.executeQuery(sql);

            return rs;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static int Insert(String sql)
    {
        try 
        {
           Statement statement = conn.createStatement();
        
           int rows = statement.executeUpdate(sql);

           return rows;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static boolean Update(String sql)
    {
        try 
        {
           Statement statement = conn.createStatement();
        
            boolean isUpdate = statement.execute(sql);

            return isUpdate;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static int Delete(String sql)
    {
        try 
        {
           Statement statement = conn.createStatement();
        
            int rows = statement.executeUpdate(sql);

           return rows;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
