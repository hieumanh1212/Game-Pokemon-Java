package model;
import controller.KetNoi_CSDL;
import java.sql.*;
import java.util.*;
public class Data {
    ArrayList<User> u = new ArrayList<>();    
    public Data() throws SQLException, ClassNotFoundException
    {
        
        KetNoi_CSDL b = new KetNoi_CSDL(); 
        b.setStmt(b.getConn().createStatement()); 
        
        ResultSet rs = b.getStmt().executeQuery("SELECT * FROM nguoidung1");
        while(rs.next())
            u.add(new User(rs.getString("user"), rs.getString("pass"), rs.getInt("Score"), rs.getInt("Time")));
        rs.close(); 
    }
    public ArrayList<User> getUser()
    {
        return u;
    }
    public boolean checkUser(String s) throws SQLException, ClassNotFoundException
    {
        boolean kt = false;
        for(User i: u)
        {
            if(i.getUser().equalsIgnoreCase(s))
                return kt=true;
        }
        return kt;
    }
    public boolean checkPass(String s) throws SQLException, ClassNotFoundException
    {
        boolean kt = false;
        for(User i: u)
        {
            if(i.getPass().equalsIgnoreCase(s))
                return kt=true;
        }
        return kt;
    }
} 
