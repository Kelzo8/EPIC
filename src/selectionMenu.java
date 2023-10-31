import javax.swing.*;
import java.awt.*;

public class selectionMenu {
    public static void Main(JFrame frame, Dimension screenSize) {
        int screenWidth = (int) screenSize.getWidth();//getting screen dimensions
        int screenHeight = (int) screenSize.getHeight();
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\images\\selectionBg.png"));
        Dimension size = background.getPreferredSize();
        background.setBounds(-110,0,size.width,size.height);
        JButton returnButton = new JButton("Return to Login menu");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),200,50);
        JLabel typeOfQuiz = new JLabel("Please select the type of quiz you would like to do: ");
        typeOfQuiz.setBounds((screenWidth/2)-150,(screenHeight/2)-180,300,20);
        JButton foundationsOfCompSci = new JButton(); // declaring a new button of the name foundationsOfCompSci
        foundationsOfCompSci.setText("Foundations of Computer Science");
        foundationsOfCompSci.setBounds((screenWidth/2)-150,(screenHeight/2)-150,300,30);// setting location for element on frame
        foundationsOfCompSci.setBackground(Color.decode("#38b000"));
        JButton discreteMaths = new JButton();
        discreteMaths.setBounds((screenWidth/2)-150,(screenHeight/2)-100,300,30);
        discreteMaths.setBackground(Color.decode("#168aad"));
        discreteMaths.setText("Discrete Mathematics");
        JButton compOrg = new JButton();
        compOrg.setBounds((screenWidth/2)-150,(screenHeight/2)-50,300,30);
        compOrg.setBackground(Color.decode("#f039b1"));
        compOrg.setText("Computer Organisation");
        frame.add(foundationsOfCompSci);frame.add(discreteMaths);frame.add(compOrg);frame.add(typeOfQuiz);frame.add(returnButton);
        frame.add(background);

        foundationsOfCompSci.addActionListener(e -> {
            //JOptionPane.showMessageDialog(frame, "Foundations of Computer Science");
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            ComputerScience.gameModeSelection(frame,screenSize);
        });
        discreteMaths.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            DiscreteMaths.DifficultyMenu(frame, screenSize);


            // JAMES ADD DISCRETE CODE FUNCTION CALL HERE
        });
        compOrg.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            computerOrganisation.main(null);


            // KELLY ADD COMPUTER ORGANISATION FUNCTION CALL HERE
        });
        returnButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            Login.Main(frame,screenSize);
        });
        foundationsOfCompSci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                foundationsOfCompSci.setBackground(Color.decode("#40cb00"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                foundationsOfCompSci.setBackground(Color.decode("#38b000"));
            }
        });
        compOrg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                compOrg.setBackground(Color.decode("#f361c1"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                compOrg.setBackground(Color.decode("#f039b1"));
            }
        });
        discreteMaths.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                discreteMaths.setBackground(Color.decode("#1fb5e3"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                discreteMaths.setBackground(Color.decode("#168aad"));
            }
        });
        frame.setVisible(true);//making the frame visible
    }
}
