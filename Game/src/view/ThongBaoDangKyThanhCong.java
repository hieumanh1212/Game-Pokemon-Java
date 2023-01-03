package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThongBaoDangKyThanhCong extends JFrame{
    JLabel status = new JLabel("Đăng Ký Thành Công");
    
    JButton button = new JButton("Đăng Nhập");
    public ThongBaoDangKyThanhCong()
    {
        JPanel panel = new JPanel();
        add(panel);
        panel.add(status);
        panel.add(button);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignIn();
                setVisible(false);
            }
        });
        setTitle("Đăng ký");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(200, 100);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
