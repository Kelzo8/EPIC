import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class DiscreteMaths {
	private static Timer timer;
    private static int secondsPassed = 0;
	// Main function to start the quiz based on the chosen difficulty level
    public static void MainQuizGUI(JFrame frame, Dimension screenSize,int difficulty) {
        if (difficulty == 0){
            Easy(frame,screenSize);
        }
        if (difficulty == 1) {
        	intermediate1(frame,screenSize);
        }
        if (difficulty == 2) {
        	Advanced1(frame,screenSize, results);
        } 

    }
    private static String[] results = new String[2]; // Array to store user's answers and results

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                DifficultyMenu(frame, screenSize);
            }
        });
    }
    // Function to display easy level question and options
    public static void Easy(JFrame frame, Dimension screenSize) {
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
        JLabel Question1 = new JLabel("What does a proposition mean?");
        //return button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
        //images
        JLabel Discretemathsbackground = new JLabel();
        Discretemathsbackground.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\9.jpg"));
        JLabel Discretemaths = new JLabel();
        Discretemaths.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\discretemathslogo.jpg"));
        Dimension size = Discretemaths.getPreferredSize();
     // Set bounds for Discretemathsbackground and Discretemaths JLabels
        Discretemathsbackground.setBounds(0, 0, screenWidth, screenHeight);
        Discretemaths.setBounds((screenWidth / 2) - (size.width / 2), (screenHeight / 2) - 350, size.width, size.height);
        
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

     // ActionListener for option buttons, updating the result array
        option11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                results[1] = "Correct";
                showResults(frame,screenSize, results);
            }
        });
        option12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                results[0] = "Incorrect";
                showResults(frame,screenSize, results);
            }
        });
        option13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                results[0] = "Incorrect";
                showResults(frame,screenSize, results);
            }
        });
        option14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                results[0] = "Incorrect";
                showResults(frame,screenSize, results);
            }
        });
     // ActionListener for return button, going back to the difficulty menu(listen's for click)
        returnButton.addActionListener((e)->{
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            DifficultyMenu(frame, screenSize);
        });
        // adding the buttons to the JFrame
        frame.add(option11);frame.add(option12);frame.add(option13);frame.add(option14);frame.add(Question1);frame.add(Discretemaths);frame.add(returnButton);frame.add(Discretemathsbackground);
    }
      public static void Easy2(JFrame frame, Dimension screenSize,int[] result) {//Easy question no.2 also not effective but not sure of any other way to do it using Java Swing
            int screenWidth = (int)screenSize.getWidth();
            int screenHeight = (int)screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
            JLabel Question1 = new JLabel("Which one means p and q?");
            //return button
            JButton returnButton = new JButton("Return");
            returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
            //images
            JLabel Discretemathsbackground = new JLabel();
            Discretemathsbackground.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\9.jpg"));
            JLabel Discretemaths = new JLabel();
            Discretemaths.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\discretemathslogo.jpg"));
            Dimension size = Discretemaths.getPreferredSize();
         // Set bounds for Discretemathsbackground and Discretemaths JLabels
            Discretemathsbackground.setBounds(0, 0, screenWidth, screenHeight);
            Discretemaths.setBounds((screenWidth / 2) - (size.width / 2), (screenHeight / 2) - 350, size.width, size.height);

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
                    results[0] = "Incorrect";
                    showResults(frame,screenSize, results);
                }
            });
            option12.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().removeAll();
                    frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                    frame.repaint();
                    results[0] = "Incorrect";
                    showResults(frame,screenSize, results);
                }
            });
            option13.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().removeAll();
                    frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                    frame.repaint();
                    results[1] = "Correct";
                    showResults(frame,screenSize, results);
                }
            });
            option14.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().removeAll();
                    frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                    frame.repaint();
                    results[0] = "Incorrect";
                    showResults(frame,screenSize, results);
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
            frame.add(option11);frame.add(option12);frame.add(option13);frame.add(option14);frame.add(Question1);frame.add(Discretemaths);frame.add(returnButton);frame.add(Discretemathsbackground);
        // Function to display intermediate level question and options
    }public static void intermediate1(JFrame frame, Dimension screenSize) {
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
        JLabel Question1 = new JLabel("A{1,2,3,4,5,6}, B{2,4,6,8} A-B=");
        //return button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
        //images
        JLabel Discretemathsbackground = new JLabel();
        Discretemathsbackground.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\9.jpg"));
        JLabel Discretemaths = new JLabel();
        Discretemaths.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\discretemathslogo.jpg"));
        Dimension size = Discretemaths.getPreferredSize();
     // Set bounds for Discretemathsbackground and Discretemaths JLabels
        Discretemathsbackground.setBounds(0, 0, screenWidth, screenHeight);
        Discretemaths.setBounds((screenWidth / 2) - (size.width / 2), (screenHeight / 2) - 350, size.width, size.height);
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
            public void actionPerformed(ActionEvent e) {               
            	frame.getContentPane().removeAll();
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
                result[1] = "Correct";
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
        frame.add(option11);frame.add(option12);frame.add(option13);frame.add(option14);frame.add(Question1);frame.add(Discretemaths);frame.add(returnButton);frame.add(Discretemathsbackground);
    }
    public static void intermediate2(JFrame frame, Dimension screenSize,String[] result) {//Easy question no.2 also not effective but not sure of any other way to do it using Java Swing
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
        JLabel Question1 = new JLabel("What is the differnece between a function and a relation?");
        //return button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
        //images
        JLabel Discretemathsbackground = new JLabel();
        Discretemathsbackground.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\9.jpg"));
        JLabel Discretemaths = new JLabel();
        Discretemaths.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\discretemathslogo.jpg"));
        Dimension size = Discretemaths.getPreferredSize();
     // Set bounds for Discretemathsbackground and Discretemaths JLabels
        Discretemathsbackground.setBounds(0, 0, screenWidth, screenHeight);
        Discretemaths.setBounds((screenWidth / 2) - (size.width / 2), (screenHeight / 2) - 350, size.width, size.height);
        
   
        Question1.setFont(new Font("Arial", Font.PLAIN, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        Question1.setBounds(screenWidth/4,(screenHeight/6)+100,1000,50);
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        // VARIABLE NAMING CONVENTION first digit notates the question 2nd digit notates the option
        JRadioButton option11 = new JRadioButton("A relationship can have many outputs for a single input, but a function has a single output");
        JRadioButton option12 = new JRadioButton("A relationship has only one output for a single input, but a function has multiple outputs");
        JRadioButton option13 = new JRadioButton("A relationship has one input with numerous outputs, but a function has many inputs with a single output");
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
                results[1] = "Correct";
                showResults(frame,screenSize, results);
             
            }
        });
        option12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                results[0] = "Incorrect";
                showResults(frame,screenSize, results);
            }
        });
        option13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                results[0] = "Incorrect";
                showResults(frame,screenSize, results);
            }
        });
        option14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                results[0] = "Incorrect";
                showResults(frame,screenSize, results);
            }
        });
      //goes back to previous page(listens for click and clears page)
        returnButton.addActionListener((e)->{
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            DifficultyMenu(frame, screenSize);
            results[0] = "Incorrect";
            showResults(frame,screenSize, results);
        });
        // adding the buttons to the JFrame frame
        frame.add(option11);frame.add(option12);frame.add(option13);frame.add(option14);frame.add(Question1);frame.add(Discretemaths);frame.add(returnButton);frame.add(Discretemathsbackground);
    }

 // Function to display advanced level question and options
    public static void Advanced1(JFrame frame, Dimension screenSize, String[] results) {
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
        JLabel Question1 = new JLabel ("If a relation is both symmetric and antisymmetric,what can be said about the relation?");
        //return button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
        //images
        JLabel Discretemathsbackground = new JLabel();
        Discretemathsbackground.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\9.jpg"));
        JLabel Discretemaths = new JLabel();
        Discretemaths.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\discretemathslogo.jpg"));
        Dimension size = Discretemaths.getPreferredSize();
     // Set bounds for Discretemathsbackground and Discretemaths JLabels
        Discretemathsbackground.setBounds(0, 0, screenWidth, screenHeight);
        Discretemaths.setBounds((screenWidth / 2) - (size.width / 2), (screenHeight / 2) - 350, size.width, size.height);
        
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
                results[0] = "Incorrect";
                showResults(frame,screenSize, results);
            }
        });
        option12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                results[1] = "Correct";
                Advanced2(frame,screenSize,results);
            }
        });
        option13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                results[0] = "Incorrect";
                showResults(frame,screenSize, results);
                
            }
        });
        option14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                results[0] = "Incorrect";
                showResults(frame,screenSize, results);
              
             
            }
        });
        returnButton.addActionListener((e)->{
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            DifficultyMenu(frame, screenSize);
        });
        // adding the buttons to the JFrame frame
        frame.add(option11);frame.add(option12);frame.add(option13);frame.add(option14);frame.add(Question1);frame.add(Discretemaths);frame.add(returnButton);frame.add(Discretemathsbackground);
     // Create a timer that fires an event every second
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsPassed++;
            }
        });
        timer.start(); // Start the timer when the question is displayed

        // ... existing code ...
    }
    public static void Advanced2(JFrame frame, Dimension screenSize, String[] results) {
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();
        JLabel Question1 = new JLabel ("If A is a 3x2 matrix and B is a 2x4 matrix, what is the size of the matrix when B is multiplied by A?");
        //return button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
        //images
        JLabel Discretemathsbackground = new JLabel();
        Discretemathsbackground.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\9.jpg"));
        JLabel Discretemaths = new JLabel();
        Discretemaths.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\discretemathslogo.jpg"));
        Dimension size = Discretemaths.getPreferredSize();
     // Set bounds for Discretemathsbackground and Discretemaths JLabels
        Discretemathsbackground.setBounds(0, 0, screenWidth, screenHeight);
        Discretemaths.setBounds((screenWidth / 2) - (size.width / 2), (screenHeight / 2) - 350, size.width, size.height);
     
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
                results[1] = "Correct";
                showResults(frame,screenSize, results);
            }
        });
        option12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                results[0] = "Incorrect";
                showResults(frame,screenSize, results);
            }
        });
        option13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                results[0] = "Incorrect";
                showResults(frame,screenSize, results);
            }
        });
        option14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                results[0] = "Incorrect";
                showResults(frame,screenSize, results);
             
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
        frame.add(option11);frame.add(option12);frame.add(option13);frame.add(option14);frame.add(Question1);frame.add(Discretemaths);frame.add(returnButton);frame.add(Discretemathsbackground);
        // Create a timer that fires an event every second
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsPassed++;
            }
        });
        timer.start(); // Start the timer when the question is displayed
    }
    public static void showResults(JFrame frame, Dimension screenSize, String[] results) {
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Assuming you have two questions(1 set)
        int totalQuestions = 1;

        // Count the number of answered questions
        int answeredQuestions = 0;
        for (String result : results) {
            if (result != null) {
                answeredQuestions++;
            }
        }

        if (answeredQuestions < totalQuestions) {
            // If not all questions are answered, display a message and return
            JLabel messageLabel = new JLabel("Please answer all questions before viewing your score.");
            messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            messageLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            messageLabel.setBounds((screenWidth / 2) - 300, (screenHeight / 2) - 50, 600, 50);
            frame.add(messageLabel);
        } else {
            // If all questions are answered, calculate and display the final score
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();

            int correctCount = 0;
            for (String result : results) {
                if ("Correct".equals(result)) {
                    correctCount++;
                }
            }

            double percentage = ((double) correctCount / totalQuestions) * 100;
            String resultString = String.format("Your score: %.2f%%", percentage);

            JLabel resultLabel = new JLabel(resultString);
            resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
            resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
            resultLabel.setBounds((screenWidth / 2) - 200, (screenHeight / 2) - 100, 400, 100);
            frame.add(resultLabel);
        }
       
      //images
        JLabel Discretemathsbackground = new JLabel();
        Discretemathsbackground.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\12.jpg"));
     // Set bounds for Discretemathsbackground and Discretemaths JLabels
        Discretemathsbackground.setBounds(0, 0, screenWidth, screenHeight);
    

        int correctCount = 0;
        for (String result : results) {
            if ("Correct".equals(result)) {
                correctCount++;
                // Stop the timer when showing results
                timer.stop();

                // Calculate minutes and seconds from secondsPassed
                int minutes = secondsPassed / 60;
                int seconds = secondsPassed % 60;
                // Display the time taken by the user
                JLabel timeLabel = new JLabel("Time taken: " + minutes + " minutes " + seconds + " seconds");
                timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
                timeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
                timeLabel.setBounds((screenWidth / 2) - 300, (screenHeight / 2) + 40, 600, 50);
                frame.add(timeLabel);frame.add(Discretemathsbackground);

            }
        }

        double percentage = ((double) correctCount / results.length) * 100;
        String resultString = String.format("Your score: %.2f%%", percentage);

        JLabel resultLabel = new JLabel(resultString);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 24));
        resultLabel.setBounds((screenWidth / 2) - 200, (screenHeight / 2) - 100, 400, 100);
        frame.add(resultLabel);

        String completionMessage = "";
        if (percentage == 100) {
            completionMessage = "Congratulations! You got all the questions correct!";
        } else if (percentage > 0) {
            completionMessage = "Well done! Keep practicing to improve.";
        } else {
            completionMessage = "Better luck next time. Keep practicing!";
        }

        JLabel messageLabel = new JLabel(completionMessage);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        messageLabel.setBounds((screenWidth / 2) - 300, (screenHeight / 2), 600, 50);
        frame.add(messageLabel);
        Arrays.fill(results, null);


    
       
                // Determine the next question based on results[0]
                int nextQuestion = Integer.parseInt(results[0]) + 1;
                if (nextQuestion == 1) {
                    Advanced1(frame, screenSize, results);
                } else if (nextQuestion == 2) {
                    Advanced2(frame, screenSize, results);
                } else {
                    // Handle the case when all questions are done
                    // might want to show a completion message or go back to the main menu
                }
                frame.repaint();
            }
     
    // Function to display the difficulty menu and handle user selection
    public static int DifficultyMenu(JFrame frame, Dimension screenSize) {
        //Essentially identical to the selection menu method
        // return 0 for easy
        //return 1 for intermediate
        // return 2 for intense
        // return 3 for random -- not accessible yet until basic modes are complete
    	frame.getContentPane().setBackground(Color.decode("#A2DDE4"));
        int screenWidth = (int) screenSize.getWidth();//getting screen dimensions
        int screenHeight = (int) screenSize.getHeight();
        //images
        JLabel Discretemathsbackground = new JLabel();
        Discretemathsbackground.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\9.jpg"));
        JLabel Discretemaths = new JLabel();
        Discretemaths.setIcon(new ImageIcon("C:\\Users\\User\\OneDrive - University of Limerick\\eclipse-workspace\\discretemathslogo.jpg"));
        Dimension size = Discretemaths.getPreferredSize();
     // Set bounds for Discretemathsbackground and Discretemaths JLabels
        Discretemathsbackground.setBounds(0, 0, screenWidth, screenHeight);
        Discretemaths.setBounds((screenWidth / 2) - (size.width / 2), (screenHeight / 2) - 350, size.width, size.height);

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

        intense.setText("Advanced");
        frame.add(easy);frame.add(intermediate);frame.add(intense);frame.add(gameMode);frame.add(Discretemaths);frame.add(Discretemathsbackground);

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
