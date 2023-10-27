import javax.swing.*;
import java.awt.*;
import java.io.*;

public class SignUp {
    public static void Main(JFrame frame, Dimension screenSize){
        // CSV READER & WRITER LEARNED FROM BRO CODE
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        JLabel background = new JLabel();
        JLabel rqLogo = new JLabel();

        background.setIcon(new ImageIcon("C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\images\\login-signin\\loginbbg.png"));
        Dimension sizeBg = background.getPreferredSize();
        background.setBounds(0,0,sizeBg.width,sizeBg.height);

        rqLogo.setIcon(new ImageIcon("C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\images\\login-signin\\loginrqLogo.jpg"));
        Dimension sizeLogo = rqLogo.getPreferredSize();
        rqLogo.setBounds((screenWidth/2)-129,(screenHeight/2)-176,sizeLogo.width,sizeLogo.height);

        JLabel loginbg = new JLabel();
        loginbg.setIcon(new ImageIcon("C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\images\\login-signin\\loginbg.png"));
        Dimension size = loginbg.getPreferredSize();
        loginbg.setBounds((screenWidth/2)-153,(screenHeight/2)-221,size.width,size.height);
        JLabel userNameLabel = new JLabel("Username:");
        JTextField userName = new JTextField(20);
        userNameLabel.setBounds((screenWidth/2)-100,(screenHeight/2)-90,100,20);
        userName.setBounds((screenWidth/2)-100,(screenHeight/2)-70,200,30);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds((screenWidth/2)-100,(screenHeight/2)-40,100,20);

        JTextField password = new JPasswordField(20);
        JTextField confirmPassword = new JPasswordField(20);

        password.setBounds((screenWidth/2)-100,(screenHeight/2)-20,200,30);
        confirmPassword.setBounds((screenWidth/2)-100,(screenHeight/2)+30,200,30);
        JLabel confirmPwdLabel = new JLabel("Confirm password:");
        confirmPwdLabel.setBounds((screenWidth/2)-100,(screenHeight/2)+10,150,20);

        JButton signUp = new JButton("Sign Up");
        signUp.setBounds((screenWidth/2)-100,(screenHeight/2)+80,200,30);
        signUp.setBackground(Color.decode("#2a7608"));

        JButton login = new JButton("Or login");
        login.setBounds((screenWidth/2)-100,(screenHeight/2)+120,200,30);
        login.setBackground(Color.decode("#2a7608"));

        frame.add(rqLogo);frame.add(signUp);frame.add(login);frame.add(userName);frame.add(password);
        frame.add(userNameLabel);frame.add(confirmPwdLabel);frame.add(passwordLabel);frame.add(loginbg);
        frame.add(background);frame.add(confirmPassword);

        signUp.addActionListener(e -> {
            String userDataFile = "C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\logins.csv"; // this file contains the login details  of every password
            BufferedReader reader;
            String line;
            boolean usernameExists = false;
            String usernameFinal = userName.getText(); // we don't need to  convert this into a hashcode as it wil;l allow usto search for users in the login file
            try {
                reader = new BufferedReader(new FileReader(userDataFile));
                while ((line = reader.readLine())!=null) {
                    String[] row = line.split(",");
                    if (row[0].equals(usernameFinal)){// so the user cannot create another account under the same username
                        usernameExists = true;
                    }
                }
                reader.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            if(usernameExists) {
                JOptionPane.showMessageDialog(frame, "Sorry that username already exists!");
            } else {
                if (password.getText().equals(confirmPassword.getText())) {
                    try{//source: https://www.youtube.com/watch?v=epDEG6YstSU
                        BufferedWriter writer = new BufferedWriter(new FileWriter(userDataFile,true));
                        writer.write("\n"+usernameFinal + "," + password.getText().hashCode()+"," + "\t"+0+","+0+","+0+",");
                        writer.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(frame,"You have successfully signed up");
                    frame.getContentPane().removeAll();
                    frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                    frame.repaint();
                    Login.Main(frame, screenSize);}
                else {
                    JOptionPane.showMessageDialog(frame,"Your passwords do not match, please try again!");
                }
            }


        });
        login.addActionListener((e)-> {
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            Login.Main(frame,screenSize);
        });
        signUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signUp.setBackground(Color.decode("#40cb00"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                signUp.setBackground(Color.decode("#38b000"));
            }
        });
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login.setBackground(Color.decode("#40cb00"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                login.setBackground(Color.decode("#38b000"));
            }
        });
        frame.setVisible(true);//making the frame visible
    }
}
