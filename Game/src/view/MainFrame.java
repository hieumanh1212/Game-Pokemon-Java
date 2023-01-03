
package view;
import controller.DoiMatKhau;
import controller.ThemCSDL;
import controller.Update;
import controller.UpdatePass;
import model.ButtonEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class MainFrame extends JFrame implements ActionListener, Runnable {

    private static final long serialVersionUID = 1L;

    private int maxTime = 300;
    public int time = maxTime;
    private int row = 8;
    private int col = 8;
    private int width = 700;
    private int height = 500;
    public JLabel lbScore;
    private JProgressBar progressTime;
    private JButton btnNewGame;
    private JButton btnLevel1, btnLevel2, btnLevel3;
    private JButton btnPause, btnEnd, btnRank, btnExit, btnChangePass;
    private ButtonEvent graphicsPanel;
    private JPanel mainPanel;

    private boolean pause = false;
    private boolean resume = false;
    
    private ThemCSDL a;
    private Update update;
    private DoiMatKhau change;
    private ThongBaoDiem x;
    private UpdatePass update2;
    //Menu
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Giới thiệu");
    private JMenuItem menuHD = new JMenuItem("Hướng dẫn");
    private JMenuItem itemGroup = new JMenuItem("Giới thiệu nhóm");
    private JMenuItem itemGame = new JMenuItem("Giới thiệu game");
    private String user, pass;
    //Frame
    public MainFrame(String user, String pass) 
    {
        this.user = user;
        this.pass = pass;
        
        add(mainPanel = createMainPanel());
        setTitle("Pokemon Game");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        
        //MenuBar
        menu.add(itemGroup);
        menu.add(itemGame);
        
        menuBar.add(menu);
        menuBar.add(menuHD);
        setJMenuBar(menuBar);
        
        itemGroup.addActionListener(this);
        itemGame.addActionListener(this);
        menuHD.addActionListener(this);
        setVisible(true);
    }


    //Panel chính
    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createGraphicsPanel(), BorderLayout.CENTER);
        panel.add(createControlPanel(), BorderLayout.EAST);
        
//        panel.add(createStatusPanel(), BorderLayout.PAGE_END);
        return panel;
    }
    
    //Panel trung tâm
    private JPanel createGraphicsPanel() {
        graphicsPanel = new ButtonEvent(this, row, col);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.GREEN);
        panel.add(graphicsPanel);
        return panel;
    }
    //Panel bên phải
    private JPanel createControlPanel() {
        lbScore = new JLabel("0");
        // lbTime = new JLabel("0");
        //Tạo một thanh tiến trình ngang với giá trị từ 0-100
        progressTime = new JProgressBar(0, 100);
        progressTime.setValue(100);

        // create panel container score and time
        //0 hàng, 1 cột, khoảng cách giữa các component theo chiều ngang và dọc là 5
        
        JPanel panelLeft = new JPanel(new GridLayout(0, 1, 5, 5));
        panelLeft.add(new JLabel("Điểm:"));
        panelLeft.add(new JLabel("Thời gian:"));

        JPanel panelCenter = new JPanel(new GridLayout(0, 1, 5, 5));
        panelCenter.add(lbScore);
        panelCenter.add(progressTime);
        
        JPanel panelHack = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        panelHack.add(new JLabel(" "), c);
        c.gridx = 0;
        c.gridy = 1;
        panelHack.add(new JLabel(" "));
        
        JPanel panelScoreAndTime = new JPanel(new BorderLayout(5, 0));
        panelScoreAndTime.add(panelLeft, BorderLayout.WEST);
        panelScoreAndTime.add(panelCenter, BorderLayout.CENTER);
        panelScoreAndTime.add(panelHack, BorderLayout.SOUTH);
        //Họ Tên
        JPanel nhom = new JPanel(new GridBagLayout());
        GridBagConstraints m = new GridBagConstraints();
        m.fill = GridBagConstraints.HORIZONTAL;
        m.insets = new Insets(10, 10, 10, 10);
        JLabel tacgia = new JLabel("Tác giả: ");
        JLabel hoten1 = new JLabel("Đặng Mạnh Hiếu - 201210121");
        JLabel hoten2 = new JLabel("Hoàng Minh Duy Thiện - 201206512");
        JLabel hoten3 = new JLabel("Nguyễn Quang Hào - 201200110");
        m.gridx = 0;
        m.gridy = 0;
        nhom.add(tacgia, m);
        m.gridx = 0;
        m.gridy = 1;
        nhom.add(hoten1, m);
        m.gridx = 0;
        m.gridy = 2;
        nhom.add(hoten2, m);
        m.gridx = 0;
        m.gridy = 3;
        nhom.add(hoten3, m);
        
        //button Game Mới và button Tạm Dừng
        JPanel controlButton = new JPanel();
        controlButton.setLayout(new GridBagLayout());
        GridBagConstraints k = new GridBagConstraints();
        k.fill = GridBagConstraints.BOTH;
        
        k.gridx = 0;
        k.gridy = 0;
        k.gridwidth = 3;
        controlButton.add(btnNewGame = createButton("Game mới"), k);
        k.gridx = 0;
        k.gridy = 1;
        k.gridwidth = 3;
        controlButton.add(btnPause = createButton("Tạm dừng"), k);
        
        
        k.gridx = 0;
        k.gridy = 2;
        k.gridwidth = 1;
        controlButton.add(btnLevel1 = createButton("Dễ"), k);
        k.gridx = 1;
        k.gridwidth = 1;
        controlButton.add(btnLevel2 = createButton("Thường"), k);
        k.gridx = 2;
        k.gridwidth = 1;
        controlButton.add(btnLevel3 = createButton("Khó"), k);
        
        k.gridx = 0;
        k.gridy = 3;
        k.gridwidth = 3;
        controlButton.add(btnEnd = createButton("Kết Thúc"), k);
        
        k.gridx = 0;
        k.gridy = 4;
        controlButton.add(new JLabel(" "), k);
        
        k.gridx = 0;
        k.gridwidth = 3;
        controlButton.add(btnRank = createButton("Bảng Xếp Hạng"), k);
        
        k.gridx = 0;
        k.gridy = 5;
        controlButton.add(btnExit = createButton("Đăng Xuất"), k);
        
        k.gridx = 0;
        k.gridy = 6;
        controlButton.add(btnChangePass = createButton("Đổi mật khẩu"), k);
        
        //button Game Mới
        JPanel panelControl = new JPanel();
        panelControl.setLayout(new BorderLayout());
        panelControl.add(BorderLayout.NORTH, panelScoreAndTime);
        panelControl.add(BorderLayout.CENTER, controlButton);
        panelControl.add(BorderLayout.SOUTH, nhom);
//        panelControl.add(btnNewGame = createButton("Game Mới"),
//                BorderLayout.PAGE_END);
        //Thông tin
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("Thông tin"));
        panel.add(panelControl, BorderLayout.PAGE_START);
        return panel;
    }

//    //Panel ở dưới _ tác giả
//    private JPanel createStatusPanel() {
//        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//        panel.setBackground(Color.lightGray);
//        JLabel label = new JLabel("Hiếu Mạnh");
//        panel.add(label);
//        return panel;
//    }

    
    //Tạo một Button
    private JButton createButton(String buttonName) {
        JButton btn = new JButton(buttonName);
        btn.addActionListener(this);
        return btn;
    }
    
    //Gọi đến hàm newGame tất cả dữ liệu sẽ được cài lại mặc định ban đầu
    public void newGame() 
    {
        time = maxTime; //Thời gian ban đầu
        graphicsPanel.removeAll();  //gỡ hết các icon
        mainPanel.add(createGraphicsPanel(), BorderLayout.CENTER);
        mainPanel.validate();   //Thêm bảng Icon mới
        mainPanel.setVisible(true);
        lbScore.setText("0"); //Điểm trở về 0
        
    }

    //Action của button NewGame
    @Override
    public  void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewGame) {
            showDialogNewGame("Trò chơi của bạn chưa kết thúc, bạn có muốn chơi lại không ? ", "Chú ý", 0);
        }
        if(e.getSource() == btnPause){
            showDialogNewGame2("Trò chơi đang tạm dừng. Tiếp tục ?", "Tạm dừng", 0);
        }
        if(e.getSource() == btnLevel1){
            showDialogNewGame3("Chọn chế độ Dễ (300 giây)?", "Chọn chế độ", 0, 1);
        }
        if(e.getSource() == btnLevel2){
            showDialogNewGame3("Chọn chế độ Thường (150 giây)", "Chọn chế độ", 0, 2);
        }
        if(e.getSource() == btnLevel3){
            showDialogNewGame3("Chọn chế độ Khó ? (90 giây)", "Chọn chế độ", 0, 3);
        }
        if(e.getSource() == btnEnd){  
            try {
                    update = new Update(graphicsPanel.getScore(), getTime(), user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            x = new ThongBaoDiem(user, graphicsPanel.getScore(), getTime());
        }
        if(e.getSource() == btnRank){
            try {
                new BangXepHang();
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource() == btnExit){
            setVisible(false);
            new SignIn();
        }
        if(e.getSource() == btnChangePass){
            change = new DoiMatKhau(user, pass);
        }
        if(e.getSource() == itemGroup){
            new InfoGroup();
        }
        if(e.getSource() == itemGame){
            new InfoGame();
        }
        if(e.getSource() == menuHD){
            new HuongDan();
        }
    }
    //Thời gian của Game
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Liên tục cập nhật giá trị của thời gian
            progressTime.setValue((int) ((double) time / maxTime * 100));
        }
    }


    public JProgressBar getProgressTime() {
        return progressTime;
    }

    public void setProgressTime(JProgressBar progressTime) {
        this.progressTime = progressTime;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public boolean isResume() {
        return resume;
    }

    public void setResume(boolean resume) {
        this.resume = resume;
    }
    
    //Hiển thị ra 1 thông báo bằng JOptionPane.YES_NO_OPTION
    //Title là tiêu đề của hộp thoại thông báo
    //Biến t để kiểm tra nguồn xuất hiện.
    // Nếu t = 0 thì nguồn là NewGame; nếu t = 1 thì nguồn là thắng game hoặc thua game
    public boolean showDialogNewGame(String message, String title, int t) {
        pause = true;
        resume = false;
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                null, null);
        //Nếu chọn Yes trong cả 2 trường hợp thì sẽ chạy newGame
        if (select == 0) {
            pause = false;
            newGame();
            return true;
        //Chọn NO thì sẽ thoát Game
        } else {
            if (t == 1) {
                System.exit(0);
                return false;
            } else {
                resume = true;
                return true;
            }
        }
    }
    
    //Dia khác
    public boolean showDialogNewGame2(String message, String title, int t) {
        pause = true;
        resume = false;
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                null, null);
        //Nếu chọn Yes trong cả 2 trường hợp thì sẽ chạy newGame
        if (select == 0) {
            pause = false;
            return true;
        //Chọn NO thì sẽ thoát Game
        } else {
            if (t == 1) {
                return false;
            } else {
                resume = true;
                return true;
            }
        }
    }
    public void newGame1(int timechange) {
        time = timechange; //Thời gian ban đầu
        
        
        graphicsPanel.removeAll();  //gỡ hết các icon
        mainPanel.add(createGraphicsPanel(), BorderLayout.CENTER);
        mainPanel.validate();   //Thêm bảng Icon mới
        mainPanel.setVisible(true);
        lbScore.setText("0"); //Điểm trở về 0
    }
    //Level
    public boolean showDialogNewGame3(String message, String title, int t, int level) {
        int timechange = 0;
        if(level == 1)
        {
            timechange = 300;
        }
        if(level == 2)
        {
            timechange = 150;
        }
        if(level == 3)
        {
            timechange = 90;
        }
        pause = true;
        resume = false;
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                null, null);
        //Nếu chọn Yes trong cả 2 trường hợp thì sẽ chạy newGame
        if (select == 0) {
            pause = false;
            newGame1(timechange);
            return true;
        //Chọn NO thì sẽ thoát Game
        } else {
            if (t == 1) {
                return false;
            } else {
                resume = true;
                return true;
            }
        }
        
    }
    public int getTime()
    {
        return time;
    }
    
    public ThemCSDL setCSDL() throws SQLException, ClassNotFoundException
    {
        return a = new ThemCSDL(graphicsPanel.getScore(), getTime(), user, pass);
    }
    public ThongBaoDiem getTB()
    {
        return x;
    }
//    public void thongbaodiem()
//    {
//        getCSDL();
//        getTB();
//    }
}