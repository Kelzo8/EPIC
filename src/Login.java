import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login {
    public static void Main(JFrame frame, Dimension screenSize){
        // CSV READER & WRITER LEARNED FROM BRO CODE

        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        JLabel background = new JLabel();
        JLabel rqLogo = new JLabel();


        background.setIcon(new ImageIcon("C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\images\\loginbbg.png"));
        Dimension sizeBg = background.getPreferredSize();
        background.setBounds(0,0,sizeBg.width,sizeBg.height);

        rqLogo.setIcon(new ImageIcon("C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\images\\loginrqLogo.jpg"));
        Dimension sizeLogo = rqLogo.getPreferredSize();
        rqLogo.setBounds((screenWidth/2)-322,(screenHeight/2)-360,sizeLogo.width,sizeLogo.height);

        JLabel loginbg = new JLabel();
        loginbg.setIcon(new ImageIcon("C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\images\\loginbg.png"));
        Dimension size = loginbg.getPreferredSize();
        loginbg.setBounds((screenWidth/2)-213,(screenHeight/2)-201,size.width,size.height);
        JLabel userNameLabel = new JLabel("username: ");
        JTextField userName = new JTextField(20);
        userNameLabel.setBounds((screenWidth/2)-100,(screenHeight/2)-70,100,20);
        userName.setBounds((screenWidth/2)-100,(screenHeight/2)-50,200,30);
        JRadioButton tncs = new JRadioButton("<html>Please accept the terms and conditions of RISKY QUIZNESS™</html>");

        JLabel passwordLabel = new JLabel("password: ");
        passwordLabel.setBounds((screenWidth/2)-100,(screenHeight/2)-20,100,20);
        tncs.setBounds((screenWidth/2)-110,(screenHeight/2)+30,220,50);
        tncs.setBackground(new Color(204,213,205));
        JTextField password = new JPasswordField(20);
        password.setBounds((screenWidth/2)-100,(screenHeight/2),200,30);


        JButton submit = new JButton();
        submit.setText("Login");
        submit.setBounds((screenWidth/2)-100,(screenHeight/2)+80,200,30);
        submit.setBackground(Color.decode("#2a7608"));
        frame.add(rqLogo);frame.add(tncs);frame.add(userName);frame.add(password);frame.add(submit);
        frame.add(userNameLabel);frame.add(passwordLabel);frame.add(loginbg);
        frame.add(background);

        submit.addActionListener(e -> {
            // This code will be executed when the submit is clicked
            String userDataFile = "C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\logins.csv"; // this file contains the login details  of every password
            BufferedReader reader;
            String line;
            String usernameFinal = userName.getText(); // we don't need to  convert this into a hashcode as it wil;l allow usto search for users in the login file
            int passwordFinal = password.getText().hashCode(); // this converts the password into a hashcode - allowing us to compare the stored password with the inputted one
            try {
                reader = new BufferedReader(new FileReader(userDataFile));
                while ((line = reader.readLine())!=null) {
                    String[] row = line.split(",");
                    if (row[0].equals(usernameFinal)){
                        if (Integer.parseInt(row[1]) == passwordFinal) {
                            frame.getContentPane().removeAll();
                            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                            frame.repaint();
                            selectionMenu.Main(frame, screenSize);
                        }
                        else {
                            JOptionPane.showMessageDialog(frame,"Incorrect password");
                        }
                    }
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });
    }
}
