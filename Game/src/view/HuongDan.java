package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class HuongDan extends JFrame{
    String game = "Game “Pikachu cổ điển” gồm các Icon là các hình ảnh của những Pokemon. ";
    String game2 = "Trong một khoảng thời gian nhất định, người chơi phải đi tìm những Icon giống nhau và ăn chúng. ";
    String game3 = "Bạn chỉ cần nối cặp Pikachu giống nhau sao cho các đường thẳng không quá ba đường gấp khúc.";
    String game4 = "Nếu người chơi ăn hết tất cả các Icon trong khoảng thời gian thì sẽ chiến thắng và kết thúc trò chơi. Ngược lại thì sẽ thua cuộc.";
    JLabel status = new JLabel(game);
    JLabel status2 = new JLabel(game2);
    JLabel status3 = new JLabel(game3);
    JLabel status4 = new JLabel(game4);
    public HuongDan()
    {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);
        add(panel);
        
        c.gridx = 0;
        c.gridy = 0;
        panel.add(status, c);
        
        c.gridx = 0;
        c.gridy = 1;
        panel.add(status2, c);
        
        c.gridx = 0;
        c.gridy = 2;
        panel.add(status3, c);
        
        c.gridx = 0;
        c.gridy = 3;
        panel.add(status4, c);
        
        setTitle("Giới thiệu Game");
        setSize(800, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
