import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ComputerScience {
    static boolean isRandom = false;
    static String[] answeredQuestions = new String[6];
    public static void MainQuizGUI(JFrame frame, Dimension screenSize,int difficulty) {
        if (difficulty == 0){
            Easy(frame,screenSize);
        } else if (difficulty == 1) {
            Intermediate(frame,screenSize);
        } else if (difficulty == 2) {
            Intense(frame, screenSize);
        }

    }
    public static int typeOfQuiz(JFrame frame, Dimension screenSize) {
        //Essentially identical to the selection menu method
        // return 0 for easy
        //return 1 for intermediate
        // return 2 for intense

        // return 3 for random -- not accessible yet until basic modes are complete
        int screenWidth = (int) screenSize.getWidth();//getting screen dimensions
        int screenHeight = (int) screenSize.getHeight();
        JButton returnButton = new JButton("Return to selection menu");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),200,50);

        JLabel gameMode = new JLabel("Please select a gameMode: ");
        gameMode.setBounds((screenWidth/2)-150,(screenHeight/2)-180,300,20);
        JButton random = new JButton(); // declaring a new button of the name easy
        random.setText("Random");
        random.setBounds((screenWidth/2)-150,(screenHeight/2)-150,300,20);// setting location for element on frame
        JButton levels = new JButton();
        levels.setBounds((screenWidth/2)-150,(screenHeight/2)-100,300,20);

        levels.setText("Levels");
        JButton intense = new JButton();
        intense.setBounds((screenWidth/2)-150,(screenHeight/2)-50,300,20);

        intense.setText("-------");
        frame.add(random);frame.add(levels);frame.add(intense);frame.add(gameMode);frame.add(returnButton);

        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                randomGame(frame,screenSize);
            }
        });
        levels.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                DifficultyMenu(frame,screenSize);

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
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                selectionMenu.Main(frame,screenSize);
            }
        });
        // return 1 for Foundations of computer science
        // return 2 for Discrete Mathematics
        // return 3 for Computer Organisation
        return 0;
    }

    public static void Easy(JFrame frame, Dimension screenSize) {
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
        JLabel Question1 = new JLabel("What does the acronym B.N.F stand for?");
        JButton returnButton = new JButton("Return to menu");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);// this will return the user to difficulty menu
        Question1.setFont(new Font("Arial", Font.PLAIN, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        Question1.setBounds((screenWidth/2)-250,(screenHeight/2)-250,1000,50);
        String[] result = new String[2];
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        // VARIABLE NAMING CONVENTION first digit notates the question 2nd digit notates the option
        JRadioButton option11 = new JRadioButton("Binary Notation Framework");
        JRadioButton option12 = new JRadioButton("Backus-Naur Form");
        JRadioButton option13 = new JRadioButton("Basic Network Function");
        JRadioButton option14 = new JRadioButton("Boolean Naming Function");
        //setting the button location
        option11.setBounds((screenWidth/2)-250,(screenHeight/2)-200,300,50);
        option12.setBounds((screenWidth/2)-250,(screenHeight/2)-150,300,50);
        option13.setBounds((screenWidth/2)-250,(screenHeight/2)-100,300,50);
        option14.setBounds((screenWidth/2)-250,(screenHeight/2)-50,300,50);

        // setting background colour for radio buttons
        option12.setBackground(new Color(204,213,205));
        option11.setBackground(new Color(204,213,205));
        option13.setBackground(new Color(204,213,205));
        option14.setBackground(new Color(204,213,205));
        // adding the buttons to the button group under the name buttonGroup
        buttonGroup.add(option11);
        buttonGroup.add(option12);
        buttonGroup.add(option13);
        buttonGroup.add(option14);
        buttonGroup.add(returnButton);

        // Not the most effective code in the world -- MUST OPTIMISE
        option11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = "Incorrect";
                if (!isRandom) {
                    Easy2(frame, screenSize, result);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        option12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = "Correct";
                if (!isRandom) {
                    Easy2(frame, screenSize, result);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        option13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = "Incorrect";
                if (!isRandom) {
                    Easy2(frame, screenSize, result);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        option14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = "Incorrect";
                if (!isRandom) {
                    Easy2(frame, screenSize, result);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                DifficultyMenu(frame,screenSize);
            }
        });
        // adding the buttons to the JFrame frame
        frame.add(option11);frame.add(option12);frame.add(option13);frame.add(option14);frame.add(Question1);frame.add(returnButton);
    }
    public static void Easy2(JFrame frame, Dimension screenSize,String[] result) {//Easy question no.2 also not effective but not sure of any other way to do it using Java Swing
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
        JButton returnButton = new JButton("Return to Q1");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
        JLabel Question1 = new JLabel("What denotes assignment/definiton in B.N.F grammar?");
        Question1.setFont(new Font("Arial", Font.PLAIN, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        Question1.setBounds((screenWidth/2)-250,(screenHeight/2)-250,1000,50);
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        // VARIABLE NAMING CONVENTION first digit notates the question 2nd digit notates the option
        JRadioButton option11 = new JRadioButton("=:");
        JRadioButton option12 = new JRadioButton(":=");
        JRadioButton option13 = new JRadioButton("=::");
        JRadioButton option14 = new JRadioButton("::=");
        //setting the button location
        option11.setBounds((screenWidth/2)-250,(screenHeight/2)-200,300,50);
        option12.setBounds((screenWidth/2)-250,(screenHeight/2)-150,300,50);
        option13.setBounds((screenWidth/2)-250,(screenHeight/2)-100,300,50);
        option14.setBounds((screenWidth/2)-250,(screenHeight/2)-50,300,50);

        option12.setBackground(new Color(204,213,205));
        option11.setBackground(new Color(204,213,205));
        option13.setBackground(new Color(204,213,205));
        option14.setBackground(new Color(204,213,205));
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
                result[1] = "Incorrect";
                if (!isRandom) {
                    showResults(frame,screenSize,result,0);
                }else {
                    randomGame(frame, screenSize);
                }

            }
        });
        option12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[1] = "Incorrect";
                if (!isRandom) {
                    showResults(frame,screenSize,result,0);
                }else {
                    randomGame(frame, screenSize);
                }

            }
        });
        option13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[1] = "Incorrect";
                if (!isRandom) {
                    showResults(frame,screenSize,result,0);
                }else {
                    randomGame(frame, screenSize);
                }

            }
        });
        option14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[1] = "Correct";
                if (!isRandom) {
                    showResults(frame,screenSize,result,0);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                Easy(frame,screenSize);
            }
        });
        // adding the buttons to the JFrame frame
        frame.add(option11);frame.add(option12);frame.add(option13);frame.add(option14);frame.add(Question1);frame.add(returnButton);
    }

    public static void Intermediate(JFrame frame, Dimension screenSize) {
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
        JLabel Question1 = new JLabel("<html>Consider the set X={a,b,c,d,e} " +
                                            "under the partial ordering<br>" +
                                            "R={(a,a),(a,b),(a,c),(a,d),(a,e),(b,b),(b,c),(b,e),(c,c),(c,e),(d,d),(d,e),(e,e)}<br>" +
                                            "What is the minimum number of ordered pairs to make X a lattice?</html>");
        JLabel latticeImg = new JLabel();
        JButton returnButton = new JButton("Return to menu");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
        latticeImg.setIcon(new ImageIcon("C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\images\\latticeq1.png"));
        Dimension size = latticeImg.getPreferredSize();
        latticeImg.setBounds((screenWidth / 4)+500, (screenHeight / 6)+150,size.width,size.height);
        frame.add(latticeImg);
        Question1.setFont(new Font("Arial", Font.PLAIN, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        Question1.setBounds((screenWidth / 4), (screenHeight / 6) - 150, 1000, 500);
        String[] result = new String[2];
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        // VARIABLE NAMING CONVENTION first digit notates the question 2nd digit notates the option
        JRadioButton option21 = new JRadioButton("0");
        JRadioButton option22 = new JRadioButton("1");
        JRadioButton option23 = new JRadioButton("2");
        JRadioButton option24 = new JRadioButton("3");
        //setting the button location
        option21.setBounds((screenWidth / 4), (screenHeight / 6)+150, 200, 50);
        option22.setBounds((screenWidth / 4), (screenHeight / 6) + 200, 200, 50);
        option23.setBounds((screenWidth / 4), (screenHeight / 6) + 250, 200, 50);
        option24.setBounds((screenWidth / 4), (screenHeight / 6) + 300, 200, 50);

        option22.setBackground(new Color(204,213,205));
        option21.setBackground(new Color(204,213,205));
        option23.setBackground(new Color(204,213,205));
        option24.setBackground(new Color(204,213,205));
        // adding the buttons to the button group under the name buttonGroup
        buttonGroup.add(option21);
        buttonGroup.add(option22);
        buttonGroup.add(option23);
        buttonGroup.add(option24);

        // Not the most effective code in the world -- MUST OPTIMISE
        option21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = "Correct";

                if (!isRandom) {
                    Intermediate2(frame, screenSize, result);
                }else {
                    randomGame(frame, screenSize);
                }

            }
        });
        option22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = "Incorrect";
                if (!isRandom) {
                    Intermediate2(frame, screenSize, result);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        option23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = "Incorrect";
                if (!isRandom) {
                    Intermediate2(frame, screenSize, result);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        option24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = "Incorrect";
                if (!isRandom) {
                    Intermediate2(frame, screenSize, result);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                DifficultyMenu(frame, screenSize);
            }
        });
        frame.add(option21);frame.add(option22);frame.add(option23);frame.add(option24);frame.add(Question1);frame.add(returnButton);
    }
    public static void Intermediate2(JFrame frame, Dimension screenSize, String[] result) {
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
        JLabel Question1 = new JLabel("<html>Consider the following lattices:<br>Which ones are lattices?</html> ");
        JLabel latticeImg = new JLabel();
        JButton returnButton = new JButton("Return to Q1");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
        latticeImg.setIcon(new ImageIcon("C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\images\\latticeq2.png"));
        Dimension size = latticeImg.getPreferredSize();
        latticeImg.setBounds((screenWidth / 4)+400, (screenHeight / 6)-120,size.width,size.height);
        frame.add(latticeImg);
        Question1.setFont(new Font("Arial", Font.PLAIN, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        Question1.setBounds((screenWidth / 4), (screenHeight / 6) - 150, 1000, 500);
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        // VARIABLE NAMING CONVENTION first digit notates the question 2nd digit notates the option
        JRadioButton option21 = new JRadioButton("(i) and (iv) only");
        JRadioButton option22 = new JRadioButton("(ii) and (iii) only");
        JRadioButton option23 = new JRadioButton("(iii) only");
        JRadioButton option24 = new JRadioButton("(i),(ii) and (iv) only");
        option22.setBackground(new Color(204,213,205));
        option21.setBackground(new Color(204,213,205));
        option23.setBackground(new Color(204,213,205));
        option24.setBackground(new Color(204,213,205));
        //setting the button location
        option21.setBounds((screenWidth / 4), (screenHeight / 6)+150, 200, 50);
        option22.setBounds((screenWidth / 4), (screenHeight / 6) + 200, 200, 50);
        option23.setBounds((screenWidth / 4), (screenHeight / 6) + 250, 200, 50);
        option24.setBounds((screenWidth / 4), (screenHeight / 6) + 300, 200, 50);
        // adding the buttons to the button group under the name buttonGroup
        buttonGroup.add(option21);
        buttonGroup.add(option22);
        buttonGroup.add(option23);
        buttonGroup.add(option24);

        // Not the most effective code in the world -- MUST OPTIMISE
        option21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[1] = "Correct";
                if (!isRandom) {
                    showResults(frame,screenSize,result,1);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        option22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[1] = "Inorrect";
                if (!isRandom) {
                    showResults(frame,screenSize,result,1);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        option23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[1] = "Incorrect";
                if (!isRandom) {
                    showResults(frame,screenSize,result,1);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        option24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[1] = "Incorrect";
                if (!isRandom) {
                    showResults(frame,screenSize,result,1);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                Intermediate(frame, screenSize);
            }
        });

        frame.add(option21);frame.add(option22);frame.add(option23);frame.add(option24);frame.add(Question1);frame.add(returnButton);
    }

    public static void Intense(JFrame frame, Dimension screenSize){
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        JLabel Question1 = new JLabel("<html>In the lattice defined by the hasse diagram given in following figure,<br>how many complements does the element 'e' have?</html> ");
        JLabel latticeImg = new JLabel();
        JButton returnButton = new JButton("Return to menu");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
        String[] result = new String[2];
        latticeImg.setIcon(new ImageIcon("C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\images\\latticeq3.png"));
        Dimension size = latticeImg.getPreferredSize();
        latticeImg.setBounds((screenWidth / 4)+400, (screenHeight / 6)+140,size.width,size.height);
        frame.add(latticeImg);
        Question1.setFont(new Font("Arial", Font.PLAIN, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        Question1.setBounds((screenWidth / 4), (screenHeight / 6) - 150, 1000, 500);
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        // VARIABLE NAMING CONVENTION first digit notates the question 2nd digit notates the option
        JRadioButton option21 = new JRadioButton("2");
        JRadioButton option22 = new JRadioButton("3");
        JRadioButton option23 = new JRadioButton("0");
        JRadioButton option24 = new JRadioButton("1");

        option22.setBackground(new Color(204,213,205));
        option21.setBackground(new Color(204,213,205));
        option23.setBackground(new Color(204,213,205));
        option24.setBackground(new Color(204,213,205));
        //setting the button location
        option21.setBounds((screenWidth / 4), (screenHeight / 6)+150, 200, 50);
        option22.setBounds((screenWidth / 4), (screenHeight / 6) + 200, 200, 50);
        option23.setBounds((screenWidth / 4), (screenHeight / 6) + 250, 200, 50);
        option24.setBounds((screenWidth / 4), (screenHeight / 6) + 300, 200, 50);
        // adding the buttons to the button group under the name buttonGroup
        buttonGroup.add(option21);
        buttonGroup.add(option22);
        buttonGroup.add(option23);
        buttonGroup.add(option24);

        // Not the most effective code in the world -- MUST OPTIMISE
        option21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = "Incorrect";
                if (!isRandom) {
                    Intense2(frame,screenSize, result);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        option22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = "Correct";
                if (!isRandom) {
                    Intense2(frame,screenSize, result);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        option23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = "Incorrect";
                if (!isRandom) {
                    Intense2(frame,screenSize,result);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        option24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[0] = "Incorrect";
                if (!isRandom) {
                    Intense2(frame,screenSize, result);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                DifficultyMenu(frame, screenSize);
            }
        });
        frame.add(option21);frame.add(option22);frame.add(option23);frame.add(option24);frame.add(Question1);frame.add(returnButton);
    }
    public static void Intense2(JFrame frame, Dimension screenSize, String[] result) {
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();//<html>Consider the grammar:<br> f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f </html>
        JLabel Question1 = new JLabel("<html>Consider the grammar:<br>f ::= true | false | x | ¬ f | f ∩ f | f ∪ f | f → f | f ↔ f <br>How many </html>");
        JLabel latticeImg = new JLabel();
        //latticeImg.setIcon(new ImageIcon("C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\images\\latticeq2.png"));
        //Dimension size = latticeImg.getPreferredSize();
        //latticeImg.setBounds((screenWidth / 4)+400, (screenHeight / 6)-120,size.width,size.height);
        //frame.add(latticeImg);
        JButton returnButton = new JButton("Return to Q1");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);

        Question1.setFont(new Font("Arial", Font.PLAIN, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        Question1.setBounds((screenWidth / 4), (screenHeight / 6) - 150, 1000, 500);
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        // VARIABLE NAMING CONVENTION first digit notates the question 2nd digit notates the option
        JRadioButton option21 = new JRadioButton("(i) and (iv) only");
        JRadioButton option22 = new JRadioButton("(ii) and (iii) only");
        JRadioButton option23 = new JRadioButton("(iii) only");
        JRadioButton option24 = new JRadioButton("(i),(ii) and (iv) only");
        option22.setBackground(new Color(204,213,205));
        option21.setBackground(new Color(204,213,205));
        option23.setBackground(new Color(204,213,205));
        option24.setBackground(new Color(204,213,205));
        //setting the button location
        option21.setBounds((screenWidth / 4), (screenHeight / 6)+150, 200, 50);
        option22.setBounds((screenWidth / 4), (screenHeight / 6) + 200, 200, 50);
        option23.setBounds((screenWidth / 4), (screenHeight / 6) + 250, 200, 50);
        option24.setBounds((screenWidth / 4), (screenHeight / 6) + 300, 200, 50);
        // adding the buttons to the button group under the name buttonGroup
        buttonGroup.add(option21);
        buttonGroup.add(option22);
        buttonGroup.add(option23);
        buttonGroup.add(option24);

        // Not the most effective code in the world -- MUST OPTIMISE
        option21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[1] = "Correct";
                if (!isRandom) {
                    showResults(frame,screenSize,result,2);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        option22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[1] = "Inorrect";
                if (!isRandom) {
                    showResults(frame,screenSize,result,2);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        option23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[1] = "Incorrect";
                if (!isRandom) {
                    showResults(frame,screenSize,result,2);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        option24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                result[1] = "Incorrect";
                if (!isRandom) {
                    showResults(frame,screenSize,result,2);
                }else {
                    randomGame(frame, screenSize);
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                Intense(frame, screenSize);
            }
        });
        frame.add(option21);frame.add(option22);frame.add(option23);frame.add(option24);frame.add(Question1);frame.add(returnButton);
    }

    public static void showResults(JFrame frame, Dimension screenSize, String[] results, int qNumber) {

        //question number
        // Easy is 0
        // Intermediate is 1
        // Intense is 2
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // EASY QUESTIONS
        String Q11 = "<html>Question 1: <br><br> What does the acronym B.N.F stand for?<br>Answer: Backus-naur form <br><br> You got this question: "+ results[0] +"<br><br>-------------------------------------------<html>";
        String Q12 = "<html>Question 2: <br><br>What denotes assignment/definiton in B.N.F grammar?<br>Answer: ::= <br><br> You got this question: "+ results[1] +"<html>";


        // INTERMEDIATE QUESTIONS
        String Q21 = "<html>Question 1: <br><br>Consider the set X={a,b,c,d,e} \" +\n" + "under the partial ordering<br>" + "R={(a,a),(a,b),(a,c),(a,d),(a,e),(b,b),(b,c),(b,e),(c,c),(c,e),(d,d),(d,e),(e,e)}<br>" + "What is the minimum number of ordered pairs to make X a lattice?<br>Answer: (i) and (iv) <br><br> You got this question: "+ results[0] +"<br><br>-------------------------------------------<html>";
        String Q22 = "<html>Question 2: <br><br>Consider the following lattices - Which ones are lattices?<br>Answer: (i) and (iv) <br><br> You got this question: "+ results[1] +"<html>";


        // INTENSE QUESTIONS
        String Q31 = "<html>Question 1: <br><br>In the lattice defined by the hasse diagram given in following figure,<br>how many complements does the element 'e' have?<br>Answer: 3 <br><br> You got this question: "+ results[0] +"<br><br>-------------------------------------------<html>";
        String Q32 = "<html>Question 2: <br><br>Consider the following lattices - Which ones are lattices?<br>Answer: (i) and (iv) <br><br> You got this question: "+ results[1] +"<html>";

        JLabel result1 = new JLabel(Q11);
        JLabel result2 = new JLabel(Q12);
        if (qNumber == 0) {
            result1 = new JLabel(Q11);
            result2 = new JLabel(Q12);
        } else if (qNumber == 1) {
             result1 = new JLabel(Q21);
             result2 = new JLabel(Q22);
        }
        else if (qNumber == 2) {
            result1 = new JLabel(Q31);
            result2 = new JLabel(Q32);
        }
        result1.setFont(new Font("Arial", Font.PLAIN, 24));
        result2.setFont(new Font("Arial", Font.PLAIN, 24));
        result1.setBounds(screenWidth/3-250,(screenHeight/4)-100,1000,300);
        result2.setBounds(screenWidth/3-250,(screenHeight/4)+120,1000,300);
        frame.add(result1);frame.add(result2);
    }
    public static void randomGame(JFrame frame, Dimension screenSize){
        isRandom = true;
        int ranNum= (int)(Math.random()*5);;//0-5 --- should be 6 havent made intense yet!!!
        System.out.println(ranNum);
        var listedArray = Arrays.asList(answeredQuestions);
        if (ranNum == 0 && !listedArray.contains("Easy")){
            Easy(frame, screenSize);
            answeredQuestions[0] = "Easy";
        }
        else if (ranNum == 1 && !listedArray.contains("Easy2")){
            Easy2(frame, screenSize,new String[2]);
            answeredQuestions[1] = "Easy2";
        }
        else if (ranNum == 2 && !listedArray.contains("Intermediate")){
            Intermediate(frame, screenSize);
            answeredQuestions[2] = "Intermediate";
        }
        else if (ranNum == 3 && !listedArray.contains("Intermediate2")){
            Intermediate2(frame, screenSize, new String[2]);
            answeredQuestions[3] = "Intermediate2";
        }
        else if (ranNum == 4 && !listedArray.contains("Intense")) {
            Intense(frame, screenSize);
            answeredQuestions[4] = "Intense";
        }



    }
    public static void DifficultyMenu(JFrame frame, Dimension screenSize) {
        //Essentially identical to the selection menu method
        // 0 for easy
        //1 for intermediate
        // 2 for intense
        int screenWidth = (int) screenSize.getWidth();//getting screen dimensions to calculate item placements
        int screenHeight = (int) screenSize.getHeight();

        JButton returnButton = new JButton("Return to game mode menu");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),200,50);

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
        frame.add(easy);frame.add(intermediate);frame.add(intense);frame.add(gameMode);frame.add(returnButton);
        // ACTION LISTENERS LOOK FOR BUTTON CLICKS
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
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                MainQuizGUI(frame,screenSize,2);
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                selectionMenu.Main(frame,screenSize);
            }
        });
    }
}
