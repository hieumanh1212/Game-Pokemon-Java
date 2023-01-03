package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ThongBaoMatKhauThanhCong extends JFrame{
    JLabel status = new JLabel("Đổi mật khẩu thành công");
    
    JButton button = new JButton("Ok");
    public ThongBaoMatKhauThanhCong()
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
        setTitle("Mật khẩu không khớp");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(200, 100);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
