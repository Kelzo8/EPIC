import javax.swing.*;
import java.awt.*;

// DEPENDENCIES:
// json-simple-1.1.1.jar


public class Main extends Thread{
    public static void main(String[] args) {
        Main thread = new Main();
        thread.start();
        // This is main do not create code here, create different functions(methods)
        JFrame frame=new JFrame("QUIZ");//creating instance of JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(new Color(204,213,205));
        //frame.getContentPane().setBackground(Color.decode("#A0E63F"));
        frame.setLayout(null);//using no layout managers
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // this gets the dimension of the current frame, source: https://stackoverflow.com/questions/6593322/why-does-the-jframe-setsize-method-not-set-the-size-correctly
        Login.Main(frame,screenSize);
        frame.setResizable(false);
        frame.setVisible(true);//making the frame visible
    }
    public void run() {
        MusicPlayer.playAudio("C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\images\\Puzzle-Dreams-3.wav");

    }
}