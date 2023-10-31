package EPIC;

import javax.swing.*;
import java.awt.*;

public class selectionMenu {
    public static void Main(JFrame frame, Dimension screenSize) {
        int screenWidth = (int) screenSize.getWidth();//getting screen dimensions
        int screenHeight = (int) screenSize.getHeight();
        Font f2 = new Font(Font.DIALOG, Font.BOLD, 30); // the font kelly chose
        
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("src\\images\\selectionBg.png"));
        
        Dimension size = background.getPreferredSize();
        background.setBounds(0,0,size.width,size.height);
        
        JButton returnButton = new JButton("Return to Login menu");
        returnButton.setFont(f2);
        returnButton.setForeground(new Color (0x0ffffff));
        returnButton.setBackground(new Color (0x2A7608));
        returnButton.setBorder(BorderFactory.createLineBorder(new Color (0x005D02), 5));
        returnButton.setBounds((screenWidth/8) - 90,screenHeight-(screenHeight/5),400,50);
        
        JLabel typeOfQuiz = new JLabel("Please select the type of quiz you would like to do: ");
        typeOfQuiz.setFont(f2);
        typeOfQuiz.setForeground(new Color (0x0ffffff));
        typeOfQuiz.setBounds((screenWidth/2)-360,(screenHeight/2)-220,900,35);
        
        JButton foundationsOfCompSci = new JButton(); // declaring a new button of the name foundationsOfCompSci
        foundationsOfCompSci.setText("Foundations of Computer Science");
        foundationsOfCompSci.setFont(f2); // added the font
        foundationsOfCompSci.setForeground(new Color (0x0ffffff));
        foundationsOfCompSci.setBackground(new Color (0x38b000));
        foundationsOfCompSci.setBorder(BorderFactory.createLineBorder(new Color (0x008000), 5));
        foundationsOfCompSci.setBounds((screenWidth/2)-280,(screenHeight/2)-150,600,40);// setting location for element on frame
        //foundationsOfCompSci.setBackground(Color.decode("#38b000"));
        
        JButton discreteMaths = new JButton();
        discreteMaths.setFont(f2);
        discreteMaths.setForeground(new Color (0x0ffffff));
        discreteMaths.setBackground(new Color (0x0168aad));
        discreteMaths.setBorder(BorderFactory.createLineBorder(new Color (0x1E6091), 5));
        discreteMaths.setBounds((screenWidth/2)-190,(screenHeight/2)-80,400,40);
        //discreteMaths.setBackground(Color.decode("#168aad"));
        discreteMaths.setText("Discrete Mathematics");
        
        JButton compOrg = new JButton();
        compOrg.setFont(f2);
        compOrg.setForeground(new Color (0x0ffffff));
        compOrg.setBackground(new Color (0x0f039b1));
        compOrg.setBorder(BorderFactory.createLineBorder(new Color (0x0e305ad), 5));
        compOrg.setBounds((screenWidth/2)-210,(screenHeight/2)-10,450,45);
        //compOrg.setBackground(Color.decode("#f039b1"));
        compOrg.setText("Computer Organisation");
        frame.add(foundationsOfCompSci);frame.add(discreteMaths);frame.add(compOrg);frame.add(typeOfQuiz);frame.add(returnButton);
        frame.add(background);

        foundationsOfCompSci.addActionListener(e -> {
            //JOptionPane.showMessageDialog(frame, "Foundations of Computer Science");
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            //ComputerScience.gameModeSelection(frame,screenSize);
        });
        discreteMaths.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Discrete Maths");
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();


            // JAMES ADD DISCRETE CODE FUNCTION CALL HERE
        });
        compOrg.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Computer Organisation");
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            computerOrganisation2.main(null);


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
