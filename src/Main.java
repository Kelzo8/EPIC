import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // This is main do not create code here, create different functions(methods)
        JFrame frame=new JFrame();//creating instance of JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);//using no layout managers
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // this gets the dimension of the current frame source: https://stackoverflow.com/questions/6593322/why-does-the-jframe-setsize-method-not-set-the-size-correctly
        logIn(frame,screenSize);
        frame.setResizable(false);
        frame.setVisible(true);//making the frame visible
    }
    public static void selectionMenu(JFrame frame,Dimension screenSize) {
        int screenWidth = (int) screenSize.getWidth();//getting screen dimensions
        int screenHeight = (int) screenSize.getHeight();

        JLabel typeOfQuiz = new JLabel("Please select the type of quiz you would like to do: ");
        typeOfQuiz.setBounds((screenWidth/2)-150,(screenHeight/2)-180,300,20);
        JButton foundationsOfCompSci = new JButton(); // declaring a new button of the name foundationsOfCompSci
        foundationsOfCompSci.setText("Foundations of Computer Science");
        foundationsOfCompSci.setBounds((screenWidth/2)-150,(screenHeight/2)-150,300,20);// setting location for element on frame
        JButton discreteMaths = new JButton();
        discreteMaths.setBounds((screenWidth/2)-150,(screenHeight/2)-100,300,20);

        discreteMaths.setText("Discrete Mathematics");
        JButton compOrg = new JButton();
        compOrg.setBounds((screenWidth/2)-150,(screenHeight/2)-50,300,20);

        compOrg.setText("Computer Organisation");
        frame.add(foundationsOfCompSci);frame.add(discreteMaths);frame.add(compOrg);frame.add(typeOfQuiz);

        foundationsOfCompSci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(frame, "Foundations of Computer Science");
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                ComputerScience.DifficultyMenu(frame,screenSize);
            }
        });
        discreteMaths.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Discrete Maths");
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();


                // JAMES ADD DISCRETE CODE FUNCTION CALL HERE
            }
        });
        compOrg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Computer Organisation");
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();

                // KELLY ADD COMPUTER ORGANISATION FUNCTION CALL HERE
            }
        });
    }
    public static boolean logIn(JFrame frame,Dimension screenSize){
        // CSV READER & WRITER LEARNED FROM BRO CODE
        String usernamesFile = "C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\usernames.csv";
        String passwordsFile = "C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\passwords.csv";
        BufferedReader reader = null;
        String line = "";
        ArrayList<String> users = new ArrayList<>();
        ArrayList<String> pass = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(usernamesFile));
            while ((line = reader.readLine())!=null) {
                String[] row = line.split(",");
                users.addAll(Arrays.asList(row));//WHAT DOES THIS ACTUALLY MEAN INTELLIJ AUTO CHANGED IT -- SAME AS FOR EACH I PRESUME
            }
            reader = new BufferedReader(new FileReader(passwordsFile));
            while ((line = reader.readLine())!=null) {
                String[] row = line.split(",");
                pass.addAll(Arrays.asList(row));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }


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
        submit.setText("Submit");
        submit.setBounds((screenWidth/2)-100,(screenHeight/2)-50,200,30);
        frame.add(userName);frame.add(password);frame.add(submit);frame.add(userNameLabel);frame.add(passwordLabel);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the submit is clicked
                String usernameFinal = userName.getText();

                String passwordFinal = password.getText();
                for (int i=0;i< users.size();i++){//ERROR HERE FOR SOME REASON ITS PRINTING FALSE RATHER THAN TRUE EVEN THOUGH THEY EQUAL ONE ANOTHER // FIXED added ',' before the first item in both csv files
                    if (users.get(i).equals(usernameFinal)){
                        System.out.println("In 1");
                        if (pass.get(i).equals(passwordFinal)){
                            System.out.println("YOURE IN");
                            frame.getContentPane().removeAll();
                            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                            frame.repaint();
                            selectionMenu(frame,screenSize);
                        }
                        else{
                            System.out.println("WRONG PASSWORD");
                        }
                    }
                }

            }
        });
        return true;
    }

    public static void DiscreteMathematics() {
        // James
    }
    public static void ComputerOrganisation() {
        // Kelly
    }

}