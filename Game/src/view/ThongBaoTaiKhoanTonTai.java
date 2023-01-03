package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ThongBaoTaiKhoanTonTai extends JFrame{
    JLabel status = new JLabel("Tên đăng nhập đã tồn tại");
    
    JButton button = new JButton("Ok");
    public ThongBaoTaiKhoanTonTai()
    {
        JPanel panel = new JPanel();
        add(panel);
        panel.add(status);
        
        JPanel panel2 = new JPanel();
        add(panel2, BorderLayout.SOUTH);
        panel2.add(button);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        
        setTitle("Tài khoản tồn tại");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(200, 100);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
