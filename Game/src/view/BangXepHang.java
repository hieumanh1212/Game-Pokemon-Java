package view;

import java.awt.Font;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
public class BangXepHang extends JFrame{
    
    private Connection connect = null;
    private JTable jtable = new JTable();
    private DefaultTableModel tableModel = new DefaultTableModel();
    Font font = new Font("Time New Roman", 1, 15);
    public BangXepHang() throws SQLException, ClassNotFoundException
    {
        String []colsName = {"User", "Score", "Time"};
        tableModel.setColumnIdentifiers(colsName);
        jtable.setModel(tableModel);
        jtable.setFont(font);
        
        buildForm();
        connectSQL();
        update(view());
    }
    private void buildForm()
    {
        setSize(400, 225);
        setTitle("Bảng Xếp Hạng");
        JScrollPane scroll = JTable.createScrollPaneForTable(jtable);
        add(scroll);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void connectSQL() throws ClassNotFoundException, SQLException
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = new String("jdbc:mysql://localhost:3306/user");
            
            try
            {
                connect = DriverManager.getConnection(url, "root", "");
            }catch(SQLException e)
            {
                throw e;
            }
        }catch(ClassNotFoundException e)
        {
            throw e;
        }
    }
    private void update(ResultSet rs) throws SQLException
    {
        String []colsName = {"Name", "Score", "Time"};
        tableModel.setColumnIdentifiers(colsName);
        
        try
        {
            while(rs.next())
            {
                String rows[] = new String[3];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);
                rows[2] = rs.getString(3);
                tableModel.addRow(rows);
            }
        }catch(SQLException e)
        {
            throw e;
        }
    }
    public ResultSet view() throws SQLException, ClassNotFoundException
    {
        ResultSet result = null;
        Connection connect = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = new String("jdbc:mysql://localhost:3306/user");
            connect = DriverManager.getConnection(url, "root", "");
        }catch(SQLException e){
            throw e;
        }
        String sql = "Select user, score, time from nguoidung1 ORDER BY Score DESC, Time DESC Limit 10";
        try
        {
            Statement stmt = connect.createStatement();
            return stmt.executeQuery(sql);
        }catch(SQLException e)
        {
            throw e;
        }
    }
}
