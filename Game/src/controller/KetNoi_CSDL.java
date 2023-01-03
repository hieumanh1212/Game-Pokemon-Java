
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DUY THIEN
 */
public class KetNoi_CSDL 
{
    static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/user";
    static final String USER = "root";
    static final String PASS ="";
    Connection conn = null;
    Statement stmt = null;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }
    public KetNoi_CSDL() throws SQLException,ClassNotFoundException
    {  
        try
        {
            //Dang ki driver
            Class.forName(DRIVER_CLASS);
            
            //Mo ket noi
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            //Truy van CSDL
            
        }
        catch(SQLException e)
        {
            throw e;
        }
       
    }
}
