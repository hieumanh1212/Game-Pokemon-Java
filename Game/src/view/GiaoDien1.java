package view;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.SignIn;

public class GiaoDien1 {
    public GiaoDien1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
    {
        String str = "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel";
        UIManager.setLookAndFeel(str);
        new SignIn();
    }
}
