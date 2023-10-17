import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.Arrays;

public class ComputerScience {
    static boolean isRandom = false;
    static String[] answeredQuestions = new String[6];
    static String[] results = new String[2];
    public static void MainQuizGUI(JFrame frame, Dimension screenSize,int difficulty) throws Exception {
        if (difficulty == 0){
            showFrame(frame,screenSize,"Easy","Q1");
        } else if (difficulty == 1) {
            showFrame(frame,screenSize,"Intermediate","Q1");
        } else if (difficulty == 2) {
            showFrame(frame,screenSize,"Intense","Q1");
        }

    }
    public static int typeOfQuiz(JFrame frame, Dimension screenSize) {
        //Essentially identical to the selection menu method
        // return 0 for easy
        //return 1 for intermediate
        // return 2 for intense
        frame.getContentPane().setBackground(Color.decode("#A0E63F"));
        // return 3 for random -- not accessible yet until basic modes are complete
        int screenWidth = (int) screenSize.getWidth();//getting screen dimensions
        int screenHeight = (int) screenSize.getHeight();
        JButton returnButton = new JButton("Return to selection menu");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),200,50);
        JLabel compSciTitle = new JLabel();
        compSciTitle.setIcon(new ImageIcon("C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\images\\csf title.jpg"));
        Dimension size = compSciTitle.getPreferredSize();
        compSciTitle.setBounds( (screenWidth / 2)-(size.width/2), (screenHeight / 2)-350,size.width,size.height);

        JLabel gameMode = new JLabel("Please select a gameMode: ");
        gameMode.setBounds((screenWidth/2)-150,(screenHeight/2)-180,300,20);
        JButton random = new JButton(); // declaring a new button of the name easy
        random.setText("Random");
        random.setBounds((screenWidth/2)-150,(screenHeight/2)-150,300,30);// setting location for element on frame
        JButton levels = new JButton();
        levels.setBounds((screenWidth/2)-150,(screenHeight/2)-100,300,30);

        levels.setText("Levels");
        JButton intense = new JButton();
        intense.setBounds((screenWidth/2)-150,(screenHeight/2)-50,300,30);

        intense.setText("-------");
        frame.add(random);frame.add(levels);frame.add(intense);frame.add(gameMode);frame.add(returnButton);frame.add(compSciTitle);
        random.setBackground(Color.decode("#38b000"));
        levels.setBackground(Color.decode("#38b000"));
        intense.setBackground(Color.decode("#38b000"));
        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
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
                frame.getContentPane().setBackground(new Color(204,213,205));
                selectionMenu.Main(frame,screenSize);
            }
        });
        // return 1 for Foundations of computer science
        // return 2 for Discrete Mathematics
        // return 3 for Computer Organisation
        return 0;
    }

    // type (of question) as in easy intermediate or insane, question will determine specifics i.e. Q1 or Q2, correctAnswer stores which option is correct
    public static void showFrame(JFrame frame,Dimension screenSize,String type,String question) throws Exception{
        Object file = new JSONParser().parse(new FileReader("C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC - Copy\\src\\data.json"));
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();
        JButton returnButton = new JButton("Go back");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);// this will return the user to difficulty menu

        ButtonGroup buttonGroup = new ButtonGroup();
        JLabel compSciTitle = new JLabel();
        JLabel image = new JLabel();
        frame.getContentPane().setBackground(Color.decode("#A0E63F"));
        // typecasting obj to JSONObject
        JSONObject obj = (JSONObject) ((JSONObject) file).get(type);//gets which type of quiz it is i.e. easy, intermediate, insane
        // getting firstName and lastName
        JSONObject QuestionStore = (JSONObject) obj.get(question);//gets which question it is i.e. Q1 or Q2
        String Question = (String) QuestionStore.get("Q"); // Gets the question text itself
        JLabel questionLabel = new JLabel(Question);
        String CorrectAnswer = (String) QuestionStore.get("CorrectAnswer");//gets the correct answer to compare with given answer
        int questionXOffset = Integer.parseInt((String) QuestionStore.get("QuestionxOffset"));
        int questionYOffset = Integer.parseInt((String) QuestionStore.get("QuestionyOffset"));
        JSONObject Answers = (JSONObject) QuestionStore.get("A");//gets the set of answers
        if (!(QuestionStore.get("ImageLink") == null)) {// this will check if there is actually an image to be displayed
            int imageXOffset = Integer.parseInt((String) QuestionStore.get("ImagexOffset"));//difference between valueOf and parseInt, valueOf returns an Integer object while parseInt returns a primitive int source: https://www.geeksforgeeks.org/integer-valueof-vs-integer-parseint-with-examples/
            int imageYOffset = Integer.parseInt((String) QuestionStore.get("ImageyOffset"));
            String imageFile = (String) QuestionStore.get("ImageLink");
            System.out.println(imageFile);
            System.out.println(imageXOffset);
            image.setIcon(new ImageIcon(imageFile));
            Dimension imageSize = image.getPreferredSize();
            image.setBounds((screenWidth / 4) + imageXOffset, (screenHeight / 2) + imageYOffset, imageSize.width, imageSize.height);
        }
        System.out.println(Arrays.toString(results));
        compSciTitle.setIcon(new ImageIcon("C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\images\\csf title.jpg"));
        Dimension size = compSciTitle.getPreferredSize();
        compSciTitle.setBounds( (screenWidth / 2)-(size.width/2), (screenHeight / 2)-350,size.width,size.height);

        questionLabel.setFont(new Font("Arial", Font.BOLD, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        questionLabel.setBounds((screenWidth/2)+questionXOffset,(screenHeight/2)+questionYOffset,1000,120);

        // declaring new radio buttons labelled 1-4
        JRadioButton option1 = new JRadioButton((String) Answers.get("1"));
        JRadioButton option2 = new JRadioButton((String) Answers.get("2"));
        JRadioButton option3 = new JRadioButton((String) Answers.get("3"));
        JRadioButton option4 = new JRadioButton((String) Answers.get("4"));

        // setting background colour
        option2.setBackground(Color.decode("#38b000"));
        option1.setBackground(Color.decode("#38b000"));
        option3.setBackground(Color.decode("#38b000"));
        option4.setBackground(Color.decode("#38b000"));
        // setting the font to be bold and stand out
        option1.setFont(new Font("Arial", Font.BOLD, 24));
        option2.setFont(new Font("Arial", Font.BOLD, 24));
        option3.setFont(new Font("Arial", Font.BOLD, 24));
        option4.setFont(new Font("Arial", Font.BOLD, 24));
        // adding the buttons to the button group under the name buttonGroup so only 1 can be selected at a time
        buttonGroup.add(option1);
        buttonGroup.add(option2);
        buttonGroup.add(option3);
        buttonGroup.add(option4);
        //setting the button location
        option1.setBounds((screenWidth/2)-250,(screenHeight/2)-150,500,50);
        option2.setBounds((screenWidth/2)-250,(screenHeight/2)-100,500,50);
        option3.setBounds((screenWidth/2)-250,(screenHeight/2)-50,500,50);
        option4.setBounds((screenWidth/2)-250,(screenHeight/2),500,50);

        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                if (question.equals("Q1")){
                    if (CorrectAnswer.equals("1")){
                        results[0] = "Correct";
                    }else {
                        results[0] = "Incorrect";
                    }
                    try {
                        showFrame(frame,screenSize,type,"Q2");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                if (question.equals("Q1")){
                    if (CorrectAnswer.equals("2")){
                        results[0] = "Correct";
                    }else {
                        results[0] = "Incorrect";
                    }
                    try {
                        showFrame(frame,screenSize,type,"Q2");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (question.equals("Q2")){
                    if (CorrectAnswer.equals("2")){
                        results[1] = "Correct";
                    }else {
                        results[1] = "Incorrect";
                    }
                    try {
                        showResults(frame,screenSize);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                if (question.equals("Q1")){
                    if (CorrectAnswer.equals("3")){
                        results[0] = "Correct";
                    }else {
                        results[0] = "Incorrect";
                    }
                    try {
                        showFrame(frame,screenSize,type,"Q2");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (question.equals("Q2")){
                    if (CorrectAnswer.equals("3")){
                        results[1] = "Correct";
                    }else {
                        results[1] = "Incorrect";
                    }
                    try {
                        showResults(frame,screenSize);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        option4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                if (question.equals("Q1")){
                    if (CorrectAnswer.equals("4")){
                        results[0] = "Correct";
                    }else {
                        results[0] = "Incorrect";
                    }
                    try {
                        showFrame(frame,screenSize,type,"Q2");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (question.equals("Q2")){
                    if (CorrectAnswer.equals("4")){
                        results[1] = "Correct";
                    }else {
                        results[1] = "Incorrect";
                    }
                    try {
                        showResults(frame,screenSize);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        // on hover methods was learned from https://stackoverflow.com/questions/22638926/how-to-put-hover-effect-on-jbutton
        option1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                option1.setBackground(Color.decode("#40cb00"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                option1.setBackground(Color.decode("#38b000"));
            }
        });
        option2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                option2.setBackground(Color.decode("#40cb00"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                option2.setBackground(Color.decode("#38b000"));
            }
        });
        option3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                option3.setBackground(Color.decode("#40cb00"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                option3.setBackground(Color.decode("#38b000"));
            }
        });
        option4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                option4.setBackground(Color.decode("#40cb00"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                option4.setBackground(Color.decode("#38b000"));
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                if (question.equals("Q2")){
                    try {
                        showFrame(frame,screenSize,type,"Q1");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } else{
                    try {
                        DifficultyMenu(frame,screenSize);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        frame.add(option1);frame.add(option2);frame.add(option3);frame.add(option4);
        frame.add(compSciTitle);frame.add(image);frame.add(questionLabel);frame.add(returnButton);

    }

    public static void showResults(JFrame frame, Dimension screenSize) {
        System.out.println(Arrays.toString(results));
        //RESULTS ARE IN ARRAY -- > JUST NEED TO BE DISPLAYED 18/10/2023 DO TOMORROW
    }

    public static void DifficultyMenu(JFrame frame, Dimension screenSize) {
        //Essentially identical to the selection menu method
        // 0 for easy
        //1 for intermediate
        // 2 for intense

        int screenWidth = (int) screenSize.getWidth();//getting screen dimensions to calculate item placements
        int screenHeight = (int) screenSize.getHeight();

        JLabel compSciTitle = new JLabel();
        compSciTitle.setIcon(new ImageIcon("C:\\Users\\Niall\\OneDrive - University of Limerick\\Desktop\\EPIC\\images\\csf title.jpg"));
        Dimension size = compSciTitle.getPreferredSize();
        compSciTitle.setBounds( (screenWidth / 2)-(size.width/2), (screenHeight / 2)-350,size.width,size.height);

        JButton returnButton = new JButton("Return to game mode menu");
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),200,50);

        JLabel gameMode = new JLabel("Please select the quiz mode: ");
        gameMode.setBounds((screenWidth/2)-150,(screenHeight/2)-180,300,20);
        JButton easy = new JButton(); // declaring a new button of the name easy
        easy.setText("Easy");
        easy.setBounds((screenWidth/2)-150,(screenHeight/2)-150,300,30);// setting location for element on frame
        JButton intermediate = new JButton();
        intermediate.setBounds((screenWidth/2)-150,(screenHeight/2)-100,300,30);

        intermediate.setText("Intermediate");
        JButton intense = new JButton();
        intense.setBounds((screenWidth/2)-150,(screenHeight/2)-50,300,30);

        intense.setText("INTENSE");
        intermediate.setBackground(Color.decode("#38b000"));
        easy.setBackground(Color.decode("#38b000"));
        intense.setBackground(Color.decode("#38b000"));
        frame.add(easy);frame.add(intermediate);frame.add(intense);frame.add(gameMode);frame.add(returnButton);frame.add(compSciTitle);
        // ACTION LISTENERS LOOK FOR BUTTON CLICKS
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                try {
                    MainQuizGUI(frame,screenSize,0);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        intermediate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                try {
                    MainQuizGUI(frame,screenSize,1);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        intense.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                try {
                    MainQuizGUI(frame,screenSize,2);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
                typeOfQuiz(frame,screenSize);
            }
        });
    }
}