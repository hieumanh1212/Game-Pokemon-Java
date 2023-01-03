package controller;
import controller.KetNoi_CSDL;
import java.sql.SQLException;
public class UpdatePass {
    public UpdatePass(String user, String newPass) throws SQLException, ClassNotFoundException
    {
        KetNoi_CSDL b = new KetNoi_CSDL();
        b.setStmt(b.getConn().createStatement()); 
        String sql = "UPDATE nguoidung1 SET pass = '" + newPass + "' where user = '" + user +"'" ;
        b.getStmt().executeUpdate(sql);     
    }
}
