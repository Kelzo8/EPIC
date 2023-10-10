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
        int screenHeight = (int)screenSize.getHeight();
        int[] question = {1,2};// compare question with result to show to the user at the end
        String[] result = new String[2];
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        JRadioButton option1 = new JRadioButton("1");
        JRadioButton option2 = new JRadioButton("2");
        JRadioButton option3 = new JRadioButton("3");
        JRadioButton option4 = new JRadioButton("4");
        //setting the button location
        option1.setBounds((screenWidth/4),(screenHeight/6)-50,50,50);
        option2.setBounds((screenWidth/4),(screenHeight/6),50,50);
        option3.setBounds((screenWidth/4),(screenHeight/6)+50,50,50);
        option4.setBounds((screenWidth/4),(screenHeight/6)+100,50,50);
        // adding the buttons to the button group under the name buttonGroup
        buttonGroup.add(option1);
        buttonGroup.add(option2);
        buttonGroup.add(option3);
        buttonGroup.add(option4);
        // adding the buttons to the JFrame frame
        frame.add(option1);frame.add(option2);frame.add(option3);frame.add(option4);
    }


    public static int DifficultyMenu(JFrame frame, Dimension screenSize) {

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
                JOptionPane.showMessageDialog(frame, "Discrete Maths");
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();

            }
        });
        intense.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Computer Organisation");
                frame.getContentPane().removeAll();
                frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
                frame.repaint();
            }
        });
        // return 1 for Foundations of computer science
        // return 2 for Discrete Mathematics
        // return 3 for Computer Organisation
        return 0;
    }

}
