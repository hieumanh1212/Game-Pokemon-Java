package view;

import javax.swing.*;
import java.awt.*;
public class ThongBaoDiem extends JFrame{
    JLabel nameLabel = new JLabel("Họ Tên");
    JLabel scoreLabel = new JLabel("Điểm");
    JLabel timeLabel = new JLabel("Thời Gian Còn Lại");
    
    
    public ThongBaoDiem(String name1, int score1, int time1)
    {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        add(panel);
        c.insets = new Insets(10, 10, 10, 10);
        
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        panel.add(nameLabel, c);
        c.gridx = 1;
        c.weightx = 4;
        panel.add(scoreLabel, c);
        c.gridx = 2;
        c.weightx = 4;
        panel.add(timeLabel, c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        panel.add(new JLabel(name1), c);
        
        c.gridx = 1;
        c.weightx = 4;
        panel.add(new JLabel(score1 + " "), c);
        
        c.gridx = 2;
        c.weightx = 4;
        panel.add(new JLabel(time1 + " giây"), c);
        
        setTitle("Điểm");
        setSize(320, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
