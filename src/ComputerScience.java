import javax.swing.*;
import java.awt.*;

public class ComputerScience {
    public static void MainQuizGUI(JFrame frame, Dimension screenSize) {
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();
        //creates a button group where only one radio button can be selected
        ButtonGroup buttonGroup = new ButtonGroup();
        //creates the radio button options
        JRadioButton option1 = new JRadioButton();
        JRadioButton option2 = new JRadioButton();
        JRadioButton option3 = new JRadioButton();
        JRadioButton option4 = new JRadioButton();
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

        // Niall
    }
    public static int DifficultyMenu(JFrame frame, Dimension screenSize) {
        // return 0 for easy
        //return 1 for intermediate
        // return 2 for Intense
        // return 3 for times -- Added feature include when other options are finished
        return 0;
    }

}
