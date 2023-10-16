import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // This is main do not create code here, create different functions(methods)
        JFrame frame=new JFrame("QUIZ");//creating instance of JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(new Color(204,213,205));
        frame.setLayout(null);//using no layout managers
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // this gets the dimension of the current frame, source: https://stackoverflow.com/questions/6593322/why-does-the-jframe-setsize-method-not-set-the-size-correctly
        ComputerScience.Easy(frame,screenSize);// TEMPORARY
        //Login.Main(frame,screenSize);
        frame.setResizable(false);
        frame.setVisible(true);//making the frame visible
    }
}