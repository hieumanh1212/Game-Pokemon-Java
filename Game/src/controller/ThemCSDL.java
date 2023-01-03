package controller;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class ThemCSDL 
{

    public ThemCSDL(int score, int time, String user, String pass) throws SQLException, ClassNotFoundException
    {
        KetNoi_CSDL b = new KetNoi_CSDL();
        b.setStmt(b.getConn().createStatement()); 
        String sql = "INSERT INTO nguoidung1 " +
                        "VALUES ('"+user+"','"+pass+"','"+score+"','"+time+"')";
        b.getStmt().executeUpdate(sql);     
    }
}
