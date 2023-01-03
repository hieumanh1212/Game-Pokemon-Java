package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ThongBaoMatKhau extends JFrame{
    JLabel status = new JLabel("Mật khẩu nhập lại không khớp");
    
    JButton button = new JButton("Ok");
    public ThongBaoMatKhau()
    {
        JPanel panel = new JPanel();
        add(panel);
        panel.add(status);
        panel.add(button);
        
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
