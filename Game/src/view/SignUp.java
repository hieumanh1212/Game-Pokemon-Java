package view;
import controller.ThemCSDL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Data;
public class SignUp extends JFrame{
    JLabel userLabel = new JLabel("Tên đăng nhập: ");
    JTextField userText = new JTextField();
    
    JLabel passLabel = new JLabel("Mật khẩu: ");
    JPasswordField passText = new JPasswordField();
    
    JLabel pass2Label = new JLabel("Nhập lại mật khẩu: ");
    JPasswordField pass2Text = new JPasswordField();
    
    JButton button1 = new JButton("Quay lại");
    JButton button = new JButton("Đăng Ký");
    
    private Data t;
    public SignUp()
    {
        buildForm();
        buildButton();
        
        setTitle("Đăng Ký");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
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
        panel.add(userLabel, c);
        c.gridx = 1;
        c.weightx = 4;
        panel.add(userText, c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        panel.add(passLabel, c);
        c.gridx = 1;
        c.weightx = 4;
        panel.add(passText, c);
        
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 1;
        panel.add(pass2Label, c);
        c.gridx = 1;
        c.weightx = 4;
        panel.add(pass2Text, c);
    }
    
    private void buildButton()
    {
        JPanel panel2 = new JPanel();
        add(panel2, BorderLayout.SOUTH);
        panel2.add(button1);
        panel2.add(button);
        
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taikhoan = userText.getText();
                String matkhau = passText.getText();
                String check = pass2Text.getText();
                try {
                    t = new Data();
                } catch (SQLException ex) {
                    Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if(taikhoan.equals("") || matkhau.equals(""))
                        {
                            new ThongBaoTrong();
                        }
                    else if(t.checkUser(taikhoan))
                        {
                            new ThongBaoTaiKhoanTonTai();
                        }
                    else if(check.equals(matkhau))
                        {
                            try {
                                new ThemCSDL(0, 0, taikhoan, matkhau);
                                new ThongBaoDangKyThanhCong();
                                setVisible(false);
                            } catch (SQLException ex) {
                                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    else
                        {
                            new ThongBaoMatKhau();
                        }
                } catch (SQLException ex) {
                    Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignIn();
                setVisible(false);
            }
        });
    }
}
