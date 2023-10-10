import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComputerScience {
    public static void MainQuizGUI(JFrame frame, Dimension screenSize,int difficulty) {
        if (difficulty == 0){
            Easy(frame,screenSize);
        }

    }
    public static void Easy(JFrame frame, Dimension screenSize) {
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
        JLabel Question1 = new JLabel("What does the acronym B.N.F stand for?");

        Question1.setFont(new Font("Arial", Font.PLAIN, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        Question1.setBounds(screenWidth/4,(screenHeight/6)-75,1000,50);
        int[] question = {1,2};// compare question with result to show to the user at the end
        int[] result = new int[2];
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        // VARIABLE NAMING CONVENTION first digit notates the question 2nd digit notates the option
        JRadioButton option11 = new JRadioButton("Binary Notation Framework");
        JRadioButton option12 = new JRadioButton("Backus-Naur Form");
        JRadioButton option13 = new JRadioButton("Basic Network Function");
        JRadioButton option14 = new JRadioButton("Boolean Naming Function");
        //setting the button location
        option11.setBounds((screenWidth/4),(screenHeight/6),300,50);
        option12.setBounds((screenWidth/4),(screenHeight/6)+50,300,50);
        option13.setBounds((screenWidth/4),(screenHeight/6)+100,300,50);
        option14.setBounds((screenWidth/4),(screenHeight/6)+150,300,50);
        // adding the buttons to the button group under the name buttonGroup
        buttonGroup.add(option11);
        buttonGroup.add(option12);
        buttonGroup.add(option13);
        buttonGroup.add(option14);

        // Not the most effective code in the world -- MUST OPTIMISE
        option11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = 0;
                Easy2(frame,screenSize,result);
            }
        });
        option12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = 1;
                Easy2(frame,screenSize,result);
            }
        });
        option13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = 0;
                Easy2(frame,screenSize,result);
            }
        });
        option14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = 0;
                Easy2(frame,screenSize,result);
            }
        });
        // adding the buttons to the JFrame frame
        frame.add(option11);frame.add(option12);frame.add(option13);frame.add(option14);frame.add(Question1);
    }public static void Easy2(JFrame frame, Dimension screenSize,int[] result) {//Easy question no.2 also not effective but not sure of any other way to do it using Java Swing
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
        JLabel Question1 = new JLabel("What denotes assignment/definiton in B.N.F grammar?");

        Question1.setFont(new Font("Arial", Font.PLAIN, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        Question1.setBounds(screenWidth/4,(screenHeight/6)-75,1000,50);
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        // VARIABLE NAMING CONVENTION first digit notates the question 2nd digit notates the option
        JRadioButton option11 = new JRadioButton("=:");
        JRadioButton option12 = new JRadioButton(":=");
        JRadioButton option13 = new JRadioButton("=::");
        JRadioButton option14 = new JRadioButton("::=");
        //setting the button location
        option11.setBounds((screenWidth/4),(screenHeight/6),300,50);
        option12.setBounds((screenWidth/4),(screenHeight/6)+50,300,50);
        option13.setBounds((screenWidth/4),(screenHeight/6)+100,300,50);
        option14.setBounds((screenWidth/4),(screenHeight/6)+150,300,50);
        // adding the buttons to the button group under the name buttonGroup
        buttonGroup.add(option11);
        buttonGroup.add(option12);
        buttonGroup.add(option13);
        buttonGroup.add(option14);

        option11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
            }
        });
        option12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
            }
        });
        option13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
            }
        });
        option14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[1] = 1;
            }
        });
        // adding the buttons to the JFrame frame
        frame.add(option11);frame.add(option12);frame.add(option13);frame.add(option14);frame.add(Question1);
    }


    public static int DifficultyMenu(JFrame frame, Dimension screenSize) {
        //Essentially identical to the selection menu method
        // return 0 for easy
        //return 1 for intermediate
        // return 2 for intense
        // return 3 for random -- not accessible yet until basic modes are complete
        int screenWidth = (int) screenSize.getWidth();//getting screen dimensions
        int screenHeight = (int) screenSize.getHeight();

        JLabel gameMode = new JLabel("Please select the quiz mode: ");
        gameMode.setBounds((screenWidth/2)-150,(screenHeight/2)-180,300,20);
        JButton easy = new JButton(); // declaring a new button of the name easy
        easy.setText("Easy");
        easy.setBounds((screenWidth/2)-150,(screenHeight/2)-150,300,20);// setting location for element on frame
        JButton intermediate = new JButton();
        intermediate.setBounds((screenWidth/2)-150,(screenHeight/2)-100,300,20);

        intermediate.setText("Intermediate");
        JButton intense = new JButton();
        intense.setBounds((screenWidth/2)-150,(screenHeight/2)-50,300,20);

        intense.setText("INTENSE");
        frame.add(easy);frame.add(intermediate);frame.add(intense);frame.add(gameMode);

        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                MainQuizGUI(frame,screenSize,0);
            }
        });
        intermediate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();

            }
        });
        intense.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
            }
        });
        // return 1 for Foundations of computer science
        // return 2 for Discrete Mathematics
        // return 3 for Computer Organisation
        return 0;
    }

}
