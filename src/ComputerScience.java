import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.ListIterator;

public class ComputerScience extends Thread{

    static boolean isRandom = false;
    static boolean resultsShown = false;
    static String[] difficulties = {"Easy","Intermediate","Intense"};// for random
    static Boolean[][] answered = {{false,false},{false,false},{false,false}};//answered[0][x] for easy,answered[1][x] for intermediate,answered[2][x] for intense
    static String[] results = new String[2];
    static String[][] randomResults = {{"Incorrect","Incorrect"},{"Incorrect","Incorrect"},{"Incorrect","Incorrect"}};//stores correct or incorrect answers
    static int elapsedTimeGlob = 0;
    static boolean isTimed = false;
    public static void MainQuizGUI(JFrame frame, Dimension screenSize, int difficulty) {
        switch (difficulty){ // 0 is easy, 1 is intermediate, 2 is intense
            case 0 -> showFrame(frame,screenSize,"Easy","Q1");
            case 1 -> showFrame(frame,screenSize,"Intermediate","Q1");
            case 2 -> showFrame(frame,screenSize,"Intense","Q1");
        }
        frame.setVisible(true);//making the frame visible
    }
    public static void clearFrame(JFrame frame){
        frame.getContentPane().removeAll();
        frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
        frame.repaint();
    } // NEW
    public static void gameModeSelection(JFrame frame, Dimension screenSize) {
        //Essentially identical to the selection menu method
        // return 0 for easy
        //return 1 for intermediate
        // return 2 for intense
        //frame.getContentPane().setBackground(Color.decode("#A0E63F"));
        JLabel background = setBackground("EPIC\\images\\compSci\\compSciBg.jpg");
        // return 3 for random -- not accessible yet until basic modes are complete
        int screenWidth = (int) screenSize.getWidth();//getting screen dimensions
        int screenHeight = (int) screenSize.getHeight();
        JButton returnButton = new JButton("Return to selection menu");
        Font f2 = new Font(Font.DIALOG, Font.BOLD, 30);
        returnButton.setFont(f2);
        returnButton.setForeground(new Color (0x0ffffff));
        returnButton.setBackground(new Color (0x2A7608));
        returnButton.setBorder(BorderFactory.createLineBorder(new Color (0x005D02), 5));
        returnButton.setBounds((screenWidth/8) - 90,screenHeight-(screenHeight/5),400,50);
        JLabel compSciTitle = new JLabel();
        compSciTitle.setIcon(new ImageIcon("EPIC\\images\\compSci\\csf title.jpg"));
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
        JButton timer = new JButton("Timed");
        timer.setBounds((screenWidth/2)-150,(screenHeight/2)-50,300,30);
        random.setBorder(BorderFactory.createLineBorder(new Color(1,127,2), 5));
        levels.setBorder(BorderFactory.createLineBorder(new Color(1,127,2), 5));
        timer.setBorder(BorderFactory.createLineBorder(new Color(1,127,2), 5));

        drawComponentsOnFrame(frame,new JRadioButton[]{}, new JLabel[]{compSciTitle,gameMode,background}, returnButton,new JButton[]{random,levels,timer});
        for (JButton button: new JButton[]{random,levels,timer}) {
            button.setBackground(Color.decode("#38b000"));
            mouseListener(button, "#38b000","#40cb00",new JRadioButton());
        }
        random.addActionListener(e -> {
            clearFrame(frame);
            randomGame(frame, screenSize);
        });
        levels.addActionListener(e -> {
            clearFrame(frame);
            DifficultyMenu(frame,screenSize);
        });
        timer.addActionListener(e -> {
            clearFrame(frame);
            isTimed = true;
            timer(frame,screenSize);
        });
        returnButton.addActionListener(e -> {
            clearFrame(frame);
            frame.getContentPane().setBackground(new Color(204,213,205));
            selectionMenu.Main(frame,screenSize);
        });
        frame.setVisible(true);//making the frame visible
    }
    public static void mouseListener(JButton button, String beforeColor, String afterColor, JRadioButton radioButton){
            button.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button.setBackground(Color.decode(beforeColor));
                }

                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button.setBackground(Color.decode(afterColor));
                }
            });
            radioButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button.setBackground(Color.decode(beforeColor));
                }

                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button.setBackground(Color.decode(afterColor));
                }
            });

    }// NEW
    // type (of question) as in easy intermediate or insane, question will determine specifics i.e. Q1 or Q2, correctAnswer stores which option is correct
    public static JLabel setBackground(String url){
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(url));
        Dimension sizeBg = background.getPreferredSize();
        background.setBounds(0,0,sizeBg.width,sizeBg.height);
        return background;
    }
    public static void showFrame(JFrame frame,Dimension screenSize,String type,String question){
        Object file;
        JLabel background = setBackground("EPIC\\images\\compSci\\compSciBg.jpg");
        try {
            file = new JSONParser().parse(new FileReader("EPIC\\src\\data.json"));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();
        JButton returnButton = new JButton("Go back");
        // this will return the user to difficulty menu
        Font f2 = new Font(Font.DIALOG, Font.BOLD, 30);
        returnButton.setFont(f2);
        returnButton.setForeground(new Color (0x0ffffff));
        returnButton.setBackground(new Color (0x2A7608));
        returnButton.setBorder(BorderFactory.createLineBorder(new Color (0x005D02), 5));
        returnButton.setBounds((screenWidth/8) - 90,screenHeight-(screenHeight/5),400,50);

        ButtonGroup buttonGroup = new ButtonGroup();
        JLabel compSciTitle = new JLabel();
        JLabel image = new JLabel();
        frame.getContentPane().setBackground(Color.decode("#A0E63F"));//setting background

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
            image.setIcon(new ImageIcon(imageFile));
            Dimension imageSize = image.getPreferredSize();
            image.setBounds((screenWidth / 4) + imageXOffset, (screenHeight / 2) + imageYOffset, imageSize.width, imageSize.height);
        }
        compSciTitle.setIcon(new ImageIcon("EPIC\\images\\compSci\\csf title.jpg"));
        Dimension size = compSciTitle.getPreferredSize();
        compSciTitle.setBounds( (screenWidth / 2)-(size.width/2), (screenHeight / 2)-350,size.width,size.height);

        questionLabel.setFont(new Font("Arial", Font.BOLD, 24));//www.sarthaks.com/3503147/how-do-i-set-the-font-size-of-a-jlabel-in-java
        questionLabel.setBounds((screenWidth/2)+questionXOffset,(screenHeight/2)+questionYOffset,1000,120);

        // declaring new radio buttons labelled 1-4
        JRadioButton option1 = new JRadioButton((String) Answers.get("1"));
        JRadioButton option2 = new JRadioButton((String) Answers.get("2"));
        JRadioButton option3 = new JRadioButton((String) Answers.get("3"));
        JRadioButton option4 = new JRadioButton((String) Answers.get("4"));

        for (JRadioButton button: new JRadioButton[]{option1,option2,option3,option4}){
            button.setBackground(Color.decode("#38b000"));
            button.setFont(new Font("Arial", Font.BOLD, 24));
            buttonGroup.add(button);
        }

        //setting the button location
        option1.setBounds((screenWidth/2)-250,(screenHeight/2)-150,500,50);
        option2.setBounds((screenWidth/2)-250,(screenHeight/2)-100,500,50);
        option3.setBounds((screenWidth/2)-250,(screenHeight/2)-50,500,50);
        option4.setBounds((screenWidth/2)-250,(screenHeight/2),500,50);

        option1.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            if (!isRandom) {
                if (question.equals("Q1")) {
                    nonRandomConditionals("1",0);
                    showFrame(frame, screenSize, type, "Q2");
                }
                else{
                    nonRandomConditionals("1",1);
                    showResults(frame,screenSize);
                }
            }
            else {
                if (type.equals("Easy")){
                    randomConditionals(type,question,0,CorrectAnswer,"1");
                }
                else if (type.equals("Intermediate")){
                    randomConditionals(type,question,1,CorrectAnswer,"1");
                }
                else {//INTENSE
                    randomConditionals(type,question,2,CorrectAnswer,"1");
                }
                randomGame(frame,screenSize);
            }
        });
        option2.addActionListener(e -> {
            clearFrame(frame);
            if (!isRandom) {
                if (question.equals("Q1")) {
                    nonRandomConditionals("2",0);
                    showFrame(frame, screenSize, type, "Q2");
                }
                else if (question.equals("Q2")){
                    nonRandomConditionals("2",1);
                    showResults(frame,screenSize);
                }
            }
            else {
                if (type.equals("Easy")){
                    randomConditionals(type,question,0,CorrectAnswer,"2");
                }
                else if (type.equals("Intermediate")){
                    randomConditionals(type,question,1,CorrectAnswer,"2");
                }
                else {//INTENSE
                    randomConditionals(type,question,2,CorrectAnswer,"2");
                }
                randomGame(frame,screenSize);
            }
        });
        option3.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            if (!isRandom) {
                if (question.equals("Q1")) {
                    nonRandomConditionals("3",0);
                    showFrame(frame, screenSize, type, "Q2");
                }
                else if (question.equals("Q2")){
                    nonRandomConditionals("3",1);
                    showResults(frame,screenSize);
                }
            }
            else {
                if (type.equals("Easy")){
                    randomConditionals(type,question,0,CorrectAnswer,"3");
                }
                else if (type.equals("Intermediate")){
                    randomConditionals(type,question,1,CorrectAnswer,"3");
                }
                else {//INTENSE
                    randomConditionals(type,question,2,CorrectAnswer,"3");
                }
                randomGame(frame,screenSize);
            }
        });
        option4.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
            frame.repaint();
            if (!isRandom) {
                if (question.equals("Q1")) {
                    nonRandomConditionals("4",0);
                    showFrame(frame, screenSize, type, "Q2");
                }
                else if (question.equals("Q2")){
                    nonRandomConditionals("4",1);
                    showResults(frame,screenSize);
                }
            }
            else {
                if (type.equals("Easy")){
                    randomConditionals(type,question,0,CorrectAnswer,"4");
                }
                else if (type.equals("Intermediate")){
                    randomConditionals(type,question,1,CorrectAnswer,"4");
                }
                else {//INTENSE
                    randomConditionals(type,question,2,CorrectAnswer,"4");
                }
                randomGame(frame,screenSize);
            }
        });

        mouseListener(new JButton(), "#38b000", "#40cb00",option1);
        mouseListener(new JButton(), "#38b000", "#40cb00",option2);
        mouseListener(new JButton(), "#38b000", "#40cb00",option3);
        mouseListener(new JButton(), "#38b000", "#40cb00",option4);
        // on hover methods was learned from https://stackoverflow.com/questions/22638926/how-to-put-hover-effect-on-jbutton
        returnButton.addActionListener(e -> {
            clearFrame(frame);
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
        });
        drawComponentsOnFrame(frame, new JRadioButton[]{option1,option2,option3,option4}, new JLabel[]{compSciTitle,questionLabel, background,image},returnButton,new JButton[]{});
    }
    public static void nonRandomConditionals(String CorrectAnswer, int num){
        if (CorrectAnswer.equals("2")) {
            results[num] = "Correct";
        } else {
            results[num] = "Incorrect";
        }
    } // NEW
    public static void randomConditionals(String type, String question, int num, String CorrectAnswer,String questionNum){
        if (question.equals("Q1")){
            if (CorrectAnswer.equals(questionNum)){
                randomResults[num][0] = "Correct";
            }else {
                randomResults[num][0] = "Incorrect";
            }
        }else{
            if (CorrectAnswer.equals("2")){
                randomResults[num][1] = "Correct";
            }else {
                randomResults[num][1] = "Incorrect";
            }
        }
    } // NEW
    public static void drawComponentsOnFrame(JFrame frame, JRadioButton[] buttons, JLabel[] labels, JButton returnBtn, JButton[] jButtons){
        for (JRadioButton button: buttons){
            frame.add(button);
        }
        for (JButton button: jButtons) {
            frame.add(button);
        }
        if (!isRandom) frame.add(returnBtn);
        frame.add(returnBtn);
        for (JLabel label: labels) {
            System.out.println(label);
            frame.add(label);
        }

        frame.setVisible(true);
       } // NEW
    public static void updateLeaderBoard(int score) {
        String userDataFile = "EPIC\\logins.csv"; // this file contains the login details of every password
        String usernameFinal = Login.loggedin; // we don't need to convert this into a hashcode as it will allow us to search for users in the login file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(userDataFile));
            StringBuilder fileContent = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[0].equals(usernameFinal)) {
                    row[2] = String.valueOf(Integer.parseInt(row[2])+score);//row[3] for compOrg, row[4] for discrete Maths
                }
                fileContent.append(String.join(",", row)).append("\n");
            }

            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(userDataFile));
            writer.write(fileContent.toString());
            writer.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    } // NEW
    public static void randomGame(JFrame frame,Dimension screenSize){
        isRandom = true;
        int ranDifficulty = (int)(Math.random()*3);
        int ranQuestion =((int) (Math.random() *2) + 1);
        boolean foundQuestion = false;
        boolean allTrue = true;
        for (Boolean[] booleans : answered) {// this will check if all the elements are true(have been answered)
            for (Boolean aBoolean : booleans) {
                if (!aBoolean) {
                    allTrue = false; // Set the flag to false if any element is false
                    break; // Exit the inner loop when a false element is encountered
                }
            }
            if (!allTrue) {
                break; // Exit the outer loop if a false element is encountered
            }
        }
        if (allTrue) {
            clearFrame(frame);
            showResults(frame, screenSize);
        }else {
            while (!foundQuestion) {//while the program checks for a question or there is a question to ask
                if (!answered[ranDifficulty][ranQuestion - 1]) {// if a question is equal to false -- meaning it hasn't been asked
                    answered[ranDifficulty][ranQuestion - 1] = true;//-1 for OBOE
                    foundQuestion = true;
                } else {
                    ranDifficulty = (int) (Math.random() * 3);// if a question has been asked it will do random again and try again
                    ranQuestion = ((int) (Math.random() * 2) + 1);
                }
            }
            showFrame(frame,screenSize,difficulties[ranDifficulty],"Q"+ranQuestion);
        }
        frame.setVisible(true);//making the frame visible
    }
    public static void randomAnswersReset(){
        for (Boolean[] booleans : answered) {
            Arrays.fill(booleans, false);
        }
        for (String[] strings: randomResults){
            Arrays.fill(strings, "Incorrect");
        }
    }
    public static int countResultForRand(){
        int count = 0;
        for (String[] randomResult : randomResults) {
            for (String s : randomResult) {
                if (s.equals("Correct")) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void timer(JFrame frame, Dimension screenSize){ // from https://stackoverflow.com/questions/12191029/running-two-independent-tasks-simultaneously-using-threads
        resultsShown = false;
        randomGame(frame,screenSize);
        if (isTimed) {
            Thread randomThread = new Thread(() -> {
                elapsedTimeGlob = 0;
                long startTime = System.currentTimeMillis();
                while (elapsedTimeGlob <= 30) {
                    elapsedTimeGlob = (int) (((new Date()).getTime() - startTime) / 1000);
                }
                System.out.println("FINISHED");
                if (!resultsShown) {
                    clearFrame(frame);
                    showResults(frame, screenSize);
                }
            });
            randomThread.start();
        }
        //randomThread.start();
    }
    public static int countResultForLevel(){
        int count = 0;
        try {
            for (String result : results) {
                if (result.equals("Correct")) {
                    count++;
                }
            }
        } catch (NullPointerException ignored) {
        }
        return count;
    }
    public static void showResults(JFrame frame, Dimension screenSize) {
        //gamemode should be 0 for comp sci, 1 for comp org, 2 for discrete maths
        JLabel background = setBackground("EPIC\\images\\compSci\\comp sci results background.jpg");
        resultsShown = true;
        // int type is for declaring whether the gamemode is Random, Levels or -----
        // 0 for random, 1 for levels, 2 for timed
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();
        int correctAmount;//what the user got correct
        int outOfAmount;//for displaying what you got out of i.e. out of 6 for random and out of 2 for levels
        if (isRandom) {
            outOfAmount = 6;
            correctAmount = countResultForRand();
            updateLeaderBoard(correctAmount);
        } else {
            outOfAmount = 2;
            correctAmount = countResultForLevel();
            updateLeaderBoard(correctAmount);
        }
        JLabel timeTaken = new JLabel("You took: "+ elapsedTimeGlob + " seconds out of 30 seconds");
        //CURRENTLY ONLY WORKS FOR RANDOM
        JLabel outOfText = new JLabel("OUT OF                "+outOfAmount+" CORRECT!");
        //JLabel outOfTime = new JLabel("Out of time!");
        JButton returnButton = new JButton("Go back");
        JLabel youGotText = new JLabel("YOU GOT");
        JLabel trophy = new JLabel();
        JLabel correct = new JLabel(String.valueOf(correctAmount));// gets the amount of correct values from the random game and displays them

        //setting the font for the labels
        timeTaken.setFont(new Font("Arial", Font.BOLD, 48));
        outOfText.setFont(new Font("Arial", Font.BOLD, 48));
        correct.setFont(new Font("Arial", Font.BOLD, 88));
        youGotText.setFont(new Font("Arial", Font.BOLD, 48));
        //outOfTime.setFont(new Font("Arial", Font.BOLD, 48));

        //setting location for the labels and buttons
        //outOfTime.setBounds((screenWidth/2)-135,(screenHeight/2)-300,1000,200);
        timeTaken.setBounds((screenWidth/2)-400,(screenHeight/2)-450,1000,200);
        youGotText.setBounds((screenWidth/2)-110,(screenHeight/2)-350,1000,200);
        returnButton.setBounds((screenWidth/8),screenHeight-(screenHeight/5),150,50);
        correct.setBounds((screenWidth/2)-25,(screenHeight/2)-65,100,100);
        outOfText.setBounds((screenWidth/2)-290,(screenHeight/2)+50,1000,200);

        drawComponentsOnFrame(frame,new JRadioButton[]{},new JLabel[]{correct,trophy,youGotText,outOfText},returnButton, new JButton[]{});
        if (isTimed) frame.add(timeTaken);frame.add(background);
        //if (isTimed) frame.add(outOfTime);
        //RESULTS ARE IN ARRAY -- > JUST NEED TO BE DISPLAYED 18/10/2023 DO TOMORROW
        Font f2 = new Font(Font.DIALOG, Font.BOLD, 30);
        returnButton.setFont(f2);
        returnButton.setForeground(new Color (0x0ffffff));
        returnButton.setBackground(new Color (0x2A7608));
        returnButton.setBorder(BorderFactory.createLineBorder(new Color (0x005D02), 5));
        returnButton.setBounds((screenWidth/8) - 90,screenHeight-(screenHeight/5),400,50);
        returnButton.addActionListener((e)-> {
            clearFrame(frame);
            randomAnswersReset();
            isRandom = false;
            isTimed = false;
            gameModeSelection(frame, screenSize);
        });
        frame.setVisible(true);//making the frame visible
    }
    public static void DifficultyMenu(JFrame frame, Dimension screenSize) {
        //Essentially identical to the selection menu method
        // 0 for easy
        //1 for intermediate
        // 2 for intense
        JLabel background = setBackground("EPIC\\images\\compSci\\compSciBg.jpg");
        int screenWidth = (int) screenSize.getWidth();//getting screen dimensions to calculate item placements
        int screenHeight = (int) screenSize.getHeight();

        JLabel compSciTitle = new JLabel();
        compSciTitle.setIcon(new ImageIcon("EPIC\\images\\compSci\\csf title.jpg"));
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
        Font f2 = new Font(Font.DIALOG, Font.BOLD, 30);

        returnButton.setFont(f2);
        returnButton.setForeground(new Color (0x0ffffff));
        returnButton.setBackground(new Color (0x2A7608));
        returnButton.setBorder(BorderFactory.createLineBorder(new Color (0x005D02), 5));
        returnButton.setBounds((screenWidth/8) - 90,screenHeight-(screenHeight/5),500,50);

        intense.setText("INTENSE");
        intermediate.setBackground(Color.decode("#38b000"));
        easy.setBackground(Color.decode("#38b000"));
        intense.setBackground(Color.decode("#38b000"));
        drawComponentsOnFrame(frame,new JRadioButton[]{},new JLabel[]{gameMode,compSciTitle,background},returnButton,new JButton[]{easy,intermediate,intense});
        easy.setBorder(BorderFactory.createLineBorder(new Color(1,127,2), 5));
        intermediate.setBorder(BorderFactory.createLineBorder(new Color (1,127,2), 5));
        intense.setBorder(BorderFactory.createLineBorder(new Color (1,127,2), 5));
        // ACTION LISTENERS LOOK FOR BUTTON CLICKS
        easy.addActionListener(e -> {
            clearFrame(frame);
            try {
                MainQuizGUI(frame,screenSize,0);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        intermediate.addActionListener(e -> {
            clearFrame(frame);
            try {
                MainQuizGUI(frame,screenSize,1);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        intense.addActionListener(e -> {
            clearFrame(frame);
            try {
                MainQuizGUI(frame,screenSize,2);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        returnButton.addActionListener(e -> {
            clearFrame(frame);
            gameModeSelection(frame,screenSize);
        });

        mouseListener(easy, "#38b000", "#40cb00",new JRadioButton());
        mouseListener(intermediate, "#38b000", "#40cb00",new JRadioButton());
        mouseListener(intense, "#38b000", "#40cb00",new JRadioButton());
    }
}
