package controller;
import controller.UpdatePass;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.ThongBaoMatKhau;
import view.ThongBaoMatKhauCuSai;
import view.ThongBaoMatKhauThanhCong;
import view.ThongBaoTrong;
public class DoiMatKhau extends JFrame{
    JLabel label1 = new JLabel("Mật khẩu cũ: ");
    JLabel label2 = new JLabel("Mật khẩu mới: ");
    JLabel label3 = new JLabel("Nhập lại: ");

    JPasswordField pass1 = new JPasswordField();
    JPasswordField pass2 = new JPasswordField();
    JPasswordField pass3 = new JPasswordField();
    
    JButton button1 = new JButton("Thay đổi");
    JButton button2 = new JButton("Hủy");
    public String oldpass, newpass, newpasscheck, passfinal;
    
    
    private UpdatePass update2;
    public DoiMatKhau(String user, String pass)
    {      
        String passfinal = null, passfinal2;
        buildForm();
        buildButton(pass, user);
        
        setTitle("Đổi mật khẩu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void buildForm()
    {
        JPanel panel = new JPanel(new GridBagLayout());
        add(panel);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);
        
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        panel.add(label1, c);
        c.gridx = 1;
        c.weightx = 4;
        panel.add(pass1, c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        panel.add(label2, c);
        c.gridx = 1;
        c.weightx = 4;
        panel.add(pass2, c);
        
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 1;
        panel.add(label3, c);
        c.gridx = 1;
        c.weightx = 4;
        panel.add(pass3, c);
    }
    private void buildButton(String pass, String user)
    {
        JPanel panel2 = new JPanel();
        add(panel2, BorderLayout.SOUTH);
        panel2.add(button1);
        panel2.add(button2);
        
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oldpass = pass1.getText();
                newpass = pass2.getText();
                newpasscheck = pass3.getText();
                if(!oldpass.equals(pass))
                    {
                        new ThongBaoMatKhauCuSai();
                    }
                else if(!newpass.equals(newpasscheck))
                    {
                        new ThongBaoMatKhau();
                    }
                else if(newpass.equals("") || newpasscheck.equals(""))
                    {
                        new ThongBaoTrong();
                    }
                else
                {
                    try {
                    update2 = new UpdatePass(user, newpass);
                    new ThongBaoMatKhauThanhCong();
                    setVisible(false);
                    } catch (SQLException ex) {
                        Logger.getLogger(DoiMatKhau.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DoiMatKhau.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
    public String getPass()
    {
        return pass2.getText();
    }
//    public static void main(String[] args) {
//        DoiMatKhau doiMatKhau = new DoiMatKhau("buiphuonglinh", "123456");
//        String pass = doiMatKhau.getPass();
//        System.out.println("newpass = " + pass);
//    }
}
