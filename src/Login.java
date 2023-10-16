import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login {
    public static void Main(JFrame frame, Dimension screenSize){
        // CSV READER & WRITER LEARNED FROM BRO CODE

        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        JLabel title = new JLabel("<html>WELCOME TO THE QUIZ!</html>");
        title.setBounds((screenWidth/2)-185,(screenHeight/2)-300,370,100);
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        JLabel userNameLabel = new JLabel("username: ");
        JTextField userName = new JTextField(20);
        userNameLabel.setBounds((screenWidth/2)-100,(screenHeight/2)-170,100,20);
        userName.setBounds((screenWidth/2)-100,(screenHeight/2)-150,200,30);


        JLabel passwordLabel = new JLabel("password: ");
        passwordLabel.setBounds((screenWidth/2)-100,(screenHeight/2)-120,100,20);
        JTextField password = new JPasswordField(20);
        password.setBounds((screenWidth/2)-100,(screenHeight/2)-100,200,30);


        JButton submit = new JButton();
        submit.setText("Submit");
        submit.setBounds((screenWidth/2)-100,(screenHeight/2)-50,200,30);
        frame.add(userName);frame.add(password);frame.add(submit);frame.add(userNameLabel);frame.add(passwordLabel);
        frame.add(title);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the submit is clicked
                String userDataFile = "C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\logins.csv"; // this file contains the login details  of every password
                BufferedReader reader = null;
                String line = "";
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

            }
        });
    }
}
