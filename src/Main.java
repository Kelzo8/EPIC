import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // This is main do not create code here, create different functions(methods)

        JFrame frame=new JFrame();//creating instance of JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);//using no layout managers
        logIn(frame);

        frame.setResizable(false);
        frame.setVisible(true);//making the frame visible
    }

    public static boolean logIn(JFrame frame){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // this gets the dimension of the current frame source: https://stackoverflow.com/questions/6593322/why-does-the-jframe-setsize-method-not-set-the-size-correctly
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        JLabel userNameLabel = new JLabel("username: ");
        JTextField userName = new JTextField(20);
        userNameLabel.setBounds((screenWidth/2)-100,(screenHeight/2)-170,100,20);
        userName.setBounds((screenWidth/2)-100,(screenHeight/2)-150,200,30);


        JLabel passwordLabel = new JLabel("password: ");
        passwordLabel.setBounds((screenWidth/2)-100,(screenHeight/2)-120,100,20);
        JTextField password = new JPasswordField(20);
        password.setBounds((screenWidth/2)-100,(screenHeight/2)-100,200,30);


        JButton submit = new JButton();
        submit.setBounds((screenWidth/2)-100,(screenHeight/2)-50,200,30);
        frame.add(userName);frame.add(password);frame.add(submit);frame.add(userNameLabel);frame.add(passwordLabel);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the submit is clicked
                JOptionPane.showMessageDialog(frame, "Button Clicked!");
            }
        });
        return true;
    }
    public static void ComputerScience(JFrame f) {
        // Niall
    }
    public static void DiscreteMathematics() {
        // James
    }
    public static void ComputerOrganisation() {
        // Kelly
    }

}