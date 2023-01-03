
package controller;

import controller.KetNoi_CSDL;
import java.sql.SQLException;

public class Update 
{
    public Update(int score, int time, String user, String pass) throws SQLException, ClassNotFoundException
    {
        KetNoi_CSDL b = new KetNoi_CSDL();
        b.setStmt(b.getConn().createStatement()); 
        String sql = "UPDATE nguoidung1 SET score = " + score + ", time = " + time + " Where user = " + "'" + user + "'";
        b.getStmt().executeUpdate(sql);     
    }
}
