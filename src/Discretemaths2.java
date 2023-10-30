import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Discretemaths2 {
    public static void MainQuizGUI(JFrame frame, Dimension screenSize,int difficulty) {
        if (difficulty == 0){
            Easy(frame,screenSize);
        }
        if (difficulty == 1) {
        	intermediate1(frame,screenSize);
        }
        if (difficulty == 2) {
        	Advanced1(frame,screenSize);
        }

    }
    public static void Easy(JFrame frame, Dimension screenSize) {
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
        JLabel Question1 = new JLabel("What does a proposition mean?");
        //return button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
        //discrete math's image
        JLabel Discretemaths = new JLabel();
        Discretemaths.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\discretemathslogo.jpg"));
        Dimension size = Discretemaths.getPreferredSize();
        Discretemaths.setBounds( (screenWidth / 2)-(size.width/2),(screenHeight/2)-350,size.width,size.height);
        
        Question1.setFont(new Font("Arial", Font.PLAIN, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        Question1.setBounds(screenWidth/4,(screenHeight/6)+100,1000,50);
        int[] question = {1,2};// compare question with result to show to the user at the end
        int[] result = new int[2];
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        // VARIABLE NAMING CONVENTION first digit notates the question 2nd digit notates the option
        JRadioButton option11 = new JRadioButton("A proposition is a declarative sentence that is either true or false, but not both");
        JRadioButton option12 = new JRadioButton("A proposition is a declarative sentence that is just true");
        JRadioButton option13 = new JRadioButton("A proposition is a declarative sentence that is just false.");
        JRadioButton option14 = new JRadioButton("A proposition is a declarative sentence that is either true or false");
        //setting the button location
        option11.setBounds((screenWidth/4),(screenHeight/6)+150,500,50);
        option12.setBounds((screenWidth/4),(screenHeight/6)+200,500,50);
        option13.setBounds((screenWidth/4),(screenHeight/6)+250,500,50);
        option14.setBounds((screenWidth/4),(screenHeight/6)+300,500,50);
        //adds colour
        option11.setBackground(new Color(51,153,225));
        option12.setBackground(new Color(51,204,225));//https://teaching.csse.uwa.edu.au/units/CITS1001/colorinfo.html
        option13.setBackground(new Color(51,153,225));
        option14.setBackground(new Color(51,204,225));
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
                result[0] = 1;
                Easy2(frame,screenSize,result);
            }
        });
        option12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = 0;
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
      //goes back to previous page(listens for click and clears page)
        returnButton.addActionListener((e)->{
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            DifficultyMenu(frame, screenSize);
        });
        // adding the buttons to the JFrame frame
        frame.add(option11);frame.add(option12);frame.add(option13);frame.add(option14);frame.add(Question1);frame.add(Discretemaths);frame.add(returnButton);
    }public static void intermediate1(JFrame frame, Dimension screenSize) {
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
        JLabel Question1 = new JLabel("A{1,2,3,4,5,6}, B{2,4,6,8} A-B=");
        //return button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
        //discrete math's image
        JLabel Discretemaths = new JLabel();
        Discretemaths.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\discretemathslogo.jpg"));
        Dimension size = Discretemaths.getPreferredSize();
        Discretemaths.setBounds( (screenWidth / 2)-(size.width/2),(screenHeight/2)-350,size.width,size.height);
        
        String[] result = new String [1];
        Question1.setFont(new Font("Arial", Font.PLAIN, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        Question1.setBounds(screenWidth/4,(screenHeight/6)+100,1000,50);
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        // VARIABLE NAMING CONVENTION first digit notates the question 2nd digit notates the option
        JRadioButton option11 = new JRadioButton("{1,2,3,6,8");
        JRadioButton option12 = new JRadioButton("{1,3,6,8,10}");
        JRadioButton option13 = new JRadioButton("{1,3,5}");
        JRadioButton option14 = new JRadioButton("{1,2,3,5}");
        //setting the button location
        option11.setBounds((screenWidth/4),(screenHeight/6)+150,300,50);
        option12.setBounds((screenWidth/4),(screenHeight/6)+200,300,50);
        option13.setBounds((screenWidth/4),(screenHeight/6)+250,300,50);
        option14.setBounds((screenWidth/4),(screenHeight/6)+300,300,50);
        //adds colour
        option11.setBackground(new Color(51,153,225));
        option12.setBackground(new Color(51,204,225));//https://teaching.csse.uwa.edu.au/units/CITS1001/colorinfo.html
        option13.setBackground(new Color(51,153,225));
        option14.setBackground(new Color(51,204,225));
        // adding the buttons to the button group under the name buttonGroup
        buttonGroup.add(option11);
        buttonGroup.add(option12);
        buttonGroup.add(option13);
        buttonGroup.add(option14);

        option11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = "Incorrect";
                intermediate2(frame,screenSize,result);
            }
        });
        option12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = "Incorrect";
                intermediate2(frame,screenSize,result);
            }
        });
        option13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = "Correct";
                intermediate2(frame,screenSize,result);
            }
        });
        option14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = "Incorrect";
                intermediate2(frame,screenSize,result);
            }
        });
      //goes back to previous page(listens for click and clears page)
        returnButton.addActionListener((e)->{
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            DifficultyMenu(frame, screenSize);
        });
        // adding the buttons to the JFrame frame
        frame.add(option11);frame.add(option12);frame.add(option13);frame.add(option14);frame.add(Question1);frame.add(Discretemaths);frame.add(returnButton);
    }
    public static void intermediate2(JFrame frame, Dimension screenSize,String[] result) {//Easy question no.2 also not effective but not sure of any other way to do it using Java Swing
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
        JLabel Question1 = new JLabel("What is the differnece between a function and a relation?");
        //return button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
        //discrete math's image
        JLabel Discretemaths = new JLabel();
        Discretemaths.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\discretemathslogo.jpg"));
        Dimension size = Discretemaths.getPreferredSize();
        Discretemaths.setBounds( (screenWidth / 2)-(size.width/2),(screenHeight/2)-350,size.width,size.height);
        
   
        Question1.setFont(new Font("Arial", Font.PLAIN, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        Question1.setBounds(screenWidth/4,(screenHeight/6)+100,1000,50);
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        // VARIABLE NAMING CONVENTION first digit notates the question 2nd digit notates the option
        JRadioButton option11 = new JRadioButton("A relationship can have many outputs for a single input, but a function has a single output");
        JRadioButton option12 = new JRadioButton("A relationship has only one output for a single input, but a function has multiple outputs");
        JRadioButton option13 = new JRadioButton("A relationship has one input with numerous outputs, but a function has many outputs for a single output");
        JRadioButton option14 = new JRadioButton("There is no difference");
        //setting the button location
        option11.setBounds((screenWidth/4),(screenHeight/6)+150,700,50);
        option12.setBounds((screenWidth/4),(screenHeight/6)+200,700,50);
        option13.setBounds((screenWidth/4),(screenHeight/6)+250,700,50);
        option14.setBounds((screenWidth/4),(screenHeight/6)+300,700,50);
        //adds colour
        option11.setBackground(new Color(51,153,225));
        option12.setBackground(new Color(51,204,225));//https://teaching.csse.uwa.edu.au/units/CITS1001/colorinfo.html
        option13.setBackground(new Color(51,153,225));
        option14.setBackground(new Color(51,204,225));
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
            }
        });
      //goes back to previous page(listens for click and clears page)
        returnButton.addActionListener((e)->{
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            DifficultyMenu(frame, screenSize);
        });
        // adding the buttons to the JFrame frame
        frame.add(option11);frame.add(option12);frame.add(option13);frame.add(option14);frame.add(Question1);frame.add(Discretemaths);frame.add(returnButton);
    }
    public static void Easy2(JFrame frame, Dimension screenSize,int[] result) {//Easy question no.2 also not effective but not sure of any other way to do it using Java Swing
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
        JLabel Question1 = new JLabel("Which one means p and q?");
        //return button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
        //discrete math's image
        JLabel Discretemaths = new JLabel();
        Discretemaths.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\discretemathslogo.jpg"));
        Dimension size = Discretemaths.getPreferredSize();
        Discretemaths.setBounds( (screenWidth / 2)-(size.width/2),(screenHeight/2)-350,size.width,size.height);
        

        Question1.setFont(new Font("Arial", Font.PLAIN, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        Question1.setBounds(screenWidth/4,(screenHeight/6)+100,1000,50);
        
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        // VARIABLE NAMING CONVENTION first digit notates the question 2nd digit notates the option
        JRadioButton option11 = new JRadioButton("p↔q");
        JRadioButton option12 = new JRadioButton("p∨q");
        JRadioButton option13 = new JRadioButton("p∧q");
        JRadioButton option14 = new JRadioButton("q→p");
        //setting the button location
        option11.setBounds((screenWidth/4),(screenHeight/6)+150,300,50);
        option12.setBounds((screenWidth/4),(screenHeight/6)+200,300,50);
        option13.setBounds((screenWidth/4),(screenHeight/6)+250,300,50);
        option14.setBounds((screenWidth/4),(screenHeight/6)+300,300,50);
        //adds colour
        option11.setBackground(new Color(51,153,225));
        option12.setBackground(new Color(51,204,225));//https://teaching.csse.uwa.edu.au/units/CITS1001/colorinfo.html
        option13.setBackground(new Color(51,153,225));
        option14.setBackground(new Color(51,204,225));
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
                result[0] = 0;
            }
        });
        option12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = 0;
            }
        });
        option13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[1] = 1;
            }
        });
        option14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = 0;
            }
        });
        //goes back to previous page(listens for click and clears page)
        returnButton.addActionListener((e)->{
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            DifficultyMenu(frame, screenSize);
        });
        // adding the buttons to the JFrame frame
        frame.add(option11);frame.add(option12);frame.add(option13);frame.add(option14);frame.add(Question1);frame.add(Discretemaths);frame.add(returnButton);
    }
    public static void Advanced1(JFrame frame, Dimension screenSize) {//Easy question no.2 also not effective but not sure of any other way to do it using Java Swing
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
        JLabel Question1 = new JLabel ("If a relation is both symmetric and antisymmetric,what can be said about the relation?");
        //return button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
        //discrete maths image
        JLabel Discretemaths = new JLabel();
        Discretemaths.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\discretemathslogo.jpg"));
        Dimension size = Discretemaths.getPreferredSize();
        Discretemaths.setBounds( (screenWidth / 2)-(size.width/2),(screenHeight/2)-350,size.width,size.height);
        
        Question1.setFont(new Font("Arial", Font.PLAIN, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        Question1.setBounds(screenWidth/4,(screenHeight/6)+100,900,50);
        int[] question = {1,2};
        String [] result = new String[2];
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        // VARIABLE NAMING CONVENTION first digit notates the question 2nd digit notates the option
        JRadioButton option11 = new JRadioButton("It is an equivalence relation");
        JRadioButton option12 = new JRadioButton("It is a partial order");
        JRadioButton option13 = new JRadioButton("It is a total order");
        JRadioButton option14 = new JRadioButton("It is not possible for a relation to be both");
        //setting the button location
        option11.setBounds((screenWidth/4),(screenHeight/6)+150,300,50);
        option12.setBounds((screenWidth/4),(screenHeight/6)+200,300,50);
        option13.setBounds((screenWidth/4),(screenHeight/6)+250,300,50);
        option14.setBounds((screenWidth/4),(screenHeight/6)+300,300,50);
        //adds colour
        option11.setBackground(new Color(51,153,225));
        option12.setBackground(new Color(51,204,225));//https://teaching.csse.uwa.edu.au/units/CITS1001/colorinfo.html
        option13.setBackground(new Color(51,153,225));
        option14.setBackground(new Color(51,204,225));
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
                Advanced2(frame,screenSize,result);
            }
        });
        option12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                Advanced2(frame,screenSize,result);
            }
        });
        option13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                Advanced2(frame,screenSize,result);
            }
        });
        option14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                Advanced2(frame,screenSize,result);
             
            }
        });
        returnButton.addActionListener((e)->{
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            DifficultyMenu(frame, screenSize);
        });
        // adding the buttons to the JFrame frame
        frame.add(option11);frame.add(option12);frame.add(option13);frame.add(option14);frame.add(Question1);frame.add(Discretemaths);frame.add(returnButton);
    }
    public static void Advanced2(JFrame frame, Dimension screenSize,String[] result) {//Easy question no.2 also not effective but not sure of any other way to do it using Java Swing
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();
        JLabel Question1 = new JLabel ("If A is a 3x2 matrix and B is a 2x4 matrix, what is the size of the matrix when B is multiplied by A?");
        //return button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
        //add image
        JLabel Discretemaths = new JLabel();
        Discretemaths.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\discretemathslogo.jpg"));
        Dimension size = Discretemaths.getPreferredSize();
        Discretemaths.setBounds( (screenWidth / 2)-(size.width/2),(screenHeight/2)-350,size.width,size.height);
        
        
        Question1.setFont(new Font("Arial", Font.PLAIN, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        Question1.setBounds(screenWidth/4,(screenHeight/6)+100,1100,50);
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        // VARIABLE NAMING CONVENTION first digit notates the question 2nd digit notates the option
        JRadioButton option11 = new JRadioButton("3x4");
        JRadioButton option12 = new JRadioButton("3x2");
        JRadioButton option13 = new JRadioButton("2x2");
        JRadioButton option14 = new JRadioButton("4x3");
        //setting the button location
        option11.setBounds((screenWidth/4),(screenHeight/6)+150,300,50);
        option12.setBounds((screenWidth/4),(screenHeight/6)+200,300,50);
        option13.setBounds((screenWidth/4),(screenHeight/6)+250,300,50);
        option14.setBounds((screenWidth/4),(screenHeight/6)+300,300,50);
        //adds colour
        option11.setBackground(new Color(51,153,225));
        option12.setBackground(new Color(51,204,225));//https://teaching.csse.uwa.edu.au/units/CITS1001/colorinfo.html
        option13.setBackground(new Color(51,153,225));
        option14.setBackground(new Color(51,204,225));
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
             
            }
        });
        //goes back to previous page(listens for click and clears page)
        returnButton.addActionListener((e)->{
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            DifficultyMenu(frame, screenSize);
        });
        // adding the buttons to the JFrame frame
        frame.add(option11);frame.add(option12);frame.add(option13);frame.add(option14);frame.add(Question1);frame.add(Discretemaths);frame.add(returnButton);
    }


    public static int DifficultyMenu(JFrame frame, Dimension screenSize) {
        //Essentially identical to the selection menu method
        // return 0 for easy
        //return 1 for intermediate
        // return 2 for intense
        // return 3 for random -- not accessible yet until basic modes are complete
    	frame.getContentPane().setBackground(Color.decode("#A2DDE4"));
        int screenWidth = (int) screenSize.getWidth();//getting screen dimensions
        int screenHeight = (int) screenSize.getHeight();
        

        JLabel Discretemaths = new JLabel();
        Discretemaths.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\discretemathslogo.jpg"));
        Dimension size = Discretemaths.getPreferredSize();
        Discretemaths.setBounds( (screenWidth / 2)-(size.width/2),(screenHeight/2)-350,size.width,size.height);
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
        frame.add(easy);frame.add(intermediate);frame.add(intense);frame.add(gameMode);frame.add(Discretemaths);

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
                MainQuizGUI(frame,screenSize,1);

            }
        });
        intense.addActionListener(new ActionListener() {
            private static int screen_width;
			@Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                MainQuizGUI(frame,screenSize,2);
            }
			 
        });
        // return 1 for Foundations of computer science
        // return 2 for Discrete Mathematics
        // return 3 for Computer Organisation
        return 0;
    }

}
