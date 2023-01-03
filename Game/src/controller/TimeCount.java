package controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ButtonEvent;
import view.MainFrame;

public class TimeCount 
{

    MainFrame frame;
    private String user, pass;
    public TimeCount(String user, String pass) 
    {
        this.user = user;
        this.pass = pass;
        
        frame = new MainFrame(user, pass);
        MyTimeCount timeCount = new MyTimeCount();
        timeCount.start();
        new Thread(frame).start();
    }

//    public static void main(String[] args) {
//        new TimeCount();
//    }

    //Xử lý thời gian
    class MyTimeCount extends Thread 
    {

        public void run() 
        {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Kiểm tra xem thời gian đã tạm dừng hay chưa
                if (frame.isPause()) {
                    //Nếu thời gian tiếp tục thì thời gian sẽ giảm dần
                    if (frame.isResume()) {
                        frame.time--;
                    }
                } else {
                    frame.time--;
                }

                if (frame.time == 0) {
                    try {
                    frame.setCSDL();
                } catch (SQLException ex) {
                    Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ButtonEvent.class.getName()).log(Level.SEVERE, null, ex);
                }
                    if (frame.showDialogNewGame(
                            "Hết giờ\nBạn có muốn chơi lại không?","Lose", 1) == true) {
                    };
                }
            }
        }
        public int getTime(){return frame.time;}
    }
}