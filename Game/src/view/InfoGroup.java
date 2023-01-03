
package view;
import javax.swing.*;
import java.awt.*;
public class InfoGroup extends JFrame{
    JLabel header = new JLabel("Thông tin các thành viên");
    JLabel group = new JLabel("Nhóm 5");
    JLabel name1 = new JLabel("Đặng Mạnh Hiếu - 201210121");
    JLabel name2 = new JLabel("Hoàng Minh Duy Thiện - 201206512");
    JLabel name3 = new JLabel("Nguyễn Quang Hào - 201200110");
    
    public InfoGroup()
    {
        JPanel panel = new JPanel(new GridBagLayout());
        add(panel);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);
        
        c.gridx = 0;
        c.gridy = 0;
        panel.add(group, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(name1, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(name2, c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(name3, c);
        
        setTitle("Thông tin nhóm");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
   
}
