package view;
import java.awt.*;
import javax.swing.*;
public class InfoGame extends JFrame{
    String game = "Khi nhắc đến Pikachu, đa số các bạn trẻ hiện nay đều biết đó là một ";
    String game2 = "trong những Pokemon đặc trưng trong loạt phim hoạt hình nổi tiếng Pokemon.";
    String game3 = "Pikachu cũng là một linh vật, một trong những biểu tượng của văn hóa Nhật Bản.";
    String game4 = "Nắm bắt được sức ảnh hướng đó, hàng loạt trò chơi (game) về Pokemon nói chung hay Pikachu nói riêng đã ra đời.";
    String game5 = "Những trò chơi này đã thu hút người chơi ở mọi lứa tuổi, mang đến cho người chơi những giây phút giải trí thú vị.";
    String game6 = "Trong đó thì không thể không kể đến game “Pikachu cổ điển” được ra đời vào năm 1998 bởi nhà phát hành Lig Studio.";
    String game7 = "Dựa trên ý tưởng của game “Pikachu cổ điển”, nhóm chúng em sẽ thuật lại tựa game này tới cô và các bạn,";
    String game8 = "cũng như những bạn nào chưa biết đến thì có thể biết thêm về tựa game “Pikachu cổ điển” để mọi người";
    String game9 = "có thể giải tỏa được được căng thẳng sau những giờ học, giờ làm việc mệt mỏi.";
    JLabel status = new JLabel(game);
    JLabel status2 = new JLabel(game2);
    JLabel status3 = new JLabel(game3);
    JLabel status4 = new JLabel(game4);
    JLabel status5 = new JLabel(game5);
    JLabel status6 = new JLabel(game6);
    JLabel status7 = new JLabel(game7);
    JLabel status8 = new JLabel(game8);
    JLabel status9 = new JLabel(game9);
    public InfoGame()
    {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);
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
        
        c.gridx = 0;
        c.gridy = 4;
        panel.add(status5, c);
        
        c.gridx = 0;
        c.gridy = 5;
        panel.add(status6, c);
        
        c.gridx = 0;
        c.gridy = 6;
        panel.add(status7, c);
        
        c.gridx = 0;
        c.gridy = 7;
        panel.add(status8, c);
        
        c.gridx = 0;
        c.gridy = 8;
        panel.add(status9, c);
        setTitle("Giới thiệu Game");
        setSize(700, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
