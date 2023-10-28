package EPIC;



import java.time.Instant;
import java.time.Duration;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.color.*;

public class computerOrganisation2 {
	public static void main(String[] args) {
		// List of all possible 6 questions contained in an ArrayList
		ArrayList<String> q = new ArrayList<String>(); 
		q.add("What is the name of the third level of the ‘Contemporary Multilevel Machine’?");
		q.add("What does ALU stand for?");
		q.add("Which three levels of the 'Contemporary Multilevel Machine' are numeric?");
		q.add("True or False: 'Translation is when each line of code must\n be examined and decoded before being executed'");
		q.add("What is the octal equivalent of the hexadecimal 3EC?");
		q.add("What is the hexadecimal equivalent of the octal 56?");
		
		// List of multiple choice answers for question 1
		ArrayList<String> q1 = new ArrayList<String>();
		q1.add("(a) Operating system machine level");
		q1.add("(b)Assembly language level");
		q1.add("(c) Microarchitecture level");
		q1.add("(d) Instruction set architecture level");

		// List of multiple choice answers for question 2
		ArrayList<String> q2 = new ArrayList<String>();
		q2.add("(a) Arithmetic Level Unit");
		q2.add("(b) Arithmetic Logic Unit");
		q2.add("(c) Assisted Level User");
		q2.add("(d) Ancient Law User");
		
		// List of multiple choice answers for question 3
		ArrayList<String> q3 = new ArrayList<String>();
		q3.add("(a) 0,1,2");
		q3.add("(b) 1,2,3");
		q3.add("(c) 2,3,4");
		q3.add("(d) 3,4,5");
		
		// List of multiple choice answers for question 4
		ArrayList<String> q4 = new ArrayList<String>();
		q4.add("(a) True");
		q4.add("(b) False");
		q4.add("");
		q4.add("");
		
		// List of multiple choice answers for question 5
		ArrayList<String> q5 = new ArrayList<String>();
		q5.add("(a) 1354");
		q5.add("(b) 2376");
		q5.add("(c) 9878");
		q5.add("(d) 9967");
		
		// List of multiple choice answers for question 6
		ArrayList<String> q6 = new ArrayList<String>();
		q6.add("(a) 4f");
		q6.add("(b) 9a");
		q6.add("(c) 2e");
		q6.add("(d) 8c");
		
		// this array list combines all the multiple choice questions so that it is easier to access throughout the code
		ArrayList<ArrayList> q_op = new ArrayList<ArrayList>();
		q_op.add(q1); q_op.add(q2); q_op.add(q3); q_op.add(q4); q_op.add(q5); q_op.add(q6); 

		
		// this array list contains the correct options for each of the 6 questions in order
		ArrayList<String> a = new ArrayList<String>(); // list of all possible 6 answers, index of question matches// index of answer
		a.add("a"); a.add("b"); a.add("b"); a.add("b"); a.add("a");a.add("c");
		
		
		// 
		
		
		// this block of code makes the screen
		JFrame frame = new JFrame(); // creates new JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes frame when x button is clicked
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // ensures frame fits screen
		frame.setLayout(null);// no layout managers, manually chose size and position of components
		frame.setForeground(new Color (0x0f29ad8));
		frame.getContentPane().setBackground(new Color (0x0f29ad8) );
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // gets screen dimensions
		// triggers first method
		modes(frame, screenSize, q, a, q_op);
		frame.setResizable(false); // frame size can't be changed
		frame.setVisible(true); // makes us able to see the screen
		

		
	
		

		
		 
	}

	public static void modes(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op) {
// this is the first screen that appears once the button "computer organisation button is clicked
// this first section is just for aesthetics
		int screen_width = (int) screenSize.getWidth();
		int screen_height = (int) screenSize.getHeight();
		Font f2 = new Font(Font.DIALOG, Font.BOLD, 30); // the font that i have chose
		
        
		//background image for design purposes
		 JLabel first_background = new JLabel();
		 first_background.setIcon(new ImageIcon("C:\\Users\\adeto\\Downloads\\Computer Organisation (5) (1).jpg"));
	     Dimension size = first_background.getPreferredSize();
	     first_background.setBounds(0,0,size.width,size.height);
		
		


		JLabel Quiz_mode = new JLabel("Please choose a Quiz mode");
		
// quiz 1 where user is given one random question to answer
		JButton Random = new JButton();
		Random.setFont(f2);
		Random.setText("Random Question Mode");
		Random.setForeground(new Color(0x0FFFFFF) ); //sets text colour
		Random.setBackground(new Color(0x0f039b1));// sets background colour
		Random.setBorder(BorderFactory.createLineBorder(new Color (0x0e305ad), 5));
		Random.setBounds((screen_width / 2) - 210, (screen_height / 2) - 110, 400, 50);
		
		Random.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();/* these remove all of the elements on screen so the others can be shown and not
									overlap */
				frame.repaint();
				
				int mode = 1; // used to identify what show results method to use
				
				Random rand = new Random();
				int rand_question = rand.nextInt(6)+1; /* generates a random integer between 1 and 6 and depending on the output, one of the six questions is selected*/
				if (rand_question ==1 ) {
					easy1(frame, screenSize, q, a, q_op, mode, null, null); /* imports the necessary variables, the nulls are stand ins for other variables that arent being used here but 
					are being used in when the methods are called later on*/
				} else if (rand_question == 2) {
					easy2(frame, screenSize, q, a, q_op, null, mode, null, null);
				}else if (rand_question == 3) {
					Intermed1(frame, screenSize, q, a, q_op, null, mode, null, null);
				}else if (rand_question == 4) {
					intermed2(frame, screenSize, q, a, q_op, null, mode, null, null);
				}else if (rand_question == 5) {
					difficult1(frame, screenSize, q, a, q_op, null, mode, null, null);
				} else if (rand_question == 6) {
					difficult2(frame, screenSize, q, a, q_op, null, mode, null, null);
				}

			};

		});
// quiz 2 where the user can choose the difficulty of the questions the want to answer
		JButton increasing_Difficulty = new JButton();
		increasing_Difficulty.setFont(f2);
		increasing_Difficulty.setText("Increasing Difficulty");
		increasing_Difficulty.setForeground(new Color(0x0FFFFFF) );
		increasing_Difficulty.setBackground(new Color(0x0f039b1));
		increasing_Difficulty.setBorder(BorderFactory.createLineBorder(new Color (0x0e305ad), 5));
		increasing_Difficulty.setBounds((screen_width / 2) - 210, (screen_height / 2) - 40, 400, 50);
		increasing_Difficulty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();// these remove all of the elements on screen so the others can be shown and not overlap
				frame.repaint();
				
// moves the user to the screen where they choose the difficulty level
				level_choice(frame, screenSize, q, a, q_op);

			};

		});
// quiz 3 where the user is timed and can repeat to beat their highscore
		
		JButton Timed_mode = new JButton();
		Timed_mode.setFont(f2);
		Timed_mode.setText("Timed mode");
		Timed_mode.setForeground(new Color(0x0FFFFFF) );
		Timed_mode.setBackground(new Color(0x0f039b1));
		Timed_mode.setBorder(BorderFactory.createLineBorder(new Color (0x0e305ad), 5));
		Timed_mode.setBounds((screen_width / 2) - 160, (screen_height / 2) + 30, 300, 50);
		Timed_mode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();// these remove all of the elements on screen so the others can be shown and not
									// overlap
				frame.repaint();
				
// moves user to a screen where they can click to start the stopwatch
				begin(frame, screenSize, q, a, q_op);

			};

		});

		frame.add(Quiz_mode);
		frame.add(Random);
		frame.add(increasing_Difficulty);
		frame.add(Timed_mode);
		frame.add(first_background);
		

	}
	

	public static void begin(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op) {
		int screen_width = (int) screenSize.getWidth();
		int screen_height = (int) screenSize.getHeight();
		Font f1 = new Font(Font.DIALOG,  Font.BOLD, 18);
		Font f2 = new Font(Font.DIALOG, Font.BOLD, 24);
		
		 JLabel general_background = new JLabel();
		 general_background.setIcon(new ImageIcon("C:\\Users\\adeto\\Downloads\\Computer Organisation (7) (2).jpg"));
	     Dimension size = general_background.getPreferredSize();
	     general_background.setBounds(0,0,size.width,size.height);
		
		int mode = 3; // Identifier for timed mode
		String[] all_six_results = new String[6];
		JLabel ask_begin = new JLabel("Try to complete 6 questions in as little time as possible.\n Press 'Start' to start the timer ");
		ask_begin.setForeground(new Color(0x0000000 ));
		ask_begin.setBackground(new Color(0x0f039b1));
		ask_begin.setFont(f2);
		ask_begin.setBounds((screen_width/2)-475,(screen_height/2)-180,1200,50);
		
		
		JButton begin = new JButton(); 
		begin.setText("START");
		begin.setForeground(new Color(0x0FFFFFF) );
		begin.setBackground(new Color(0x0f039b1));
		begin.setFont(f2);
		begin.setBorder(BorderFactory.createLineBorder(new Color (0x0e305ad), 5));
		begin.setBounds((screen_width/2)-100, (screen_height/2) - 80, 200, 35);
		frame.add(begin);
		frame.add(ask_begin);
		frame.add(general_background);

			begin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();// these remove all of the elements on screen so the others can be shown and not
										// overlap
					frame.repaint();

					Instant startTime = Instant.now(); // starts stop watch
					 easy1(frame, screenSize, q, a, q_op, mode, all_six_results, startTime); //startTime transfers the stopwatch between methods
					

				};

			});
		}  
	
	public static void level_choice( JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op) {
		int screen_width = (int) screenSize.getWidth();
		int screen_height = (int) screenSize.getHeight();
		Font f1 = new Font(Font.DIALOG,  Font.BOLD, 18);
		
		 JLabel general_background = new JLabel();
		 general_background.setIcon(new ImageIcon("C:\\Users\\adeto\\Downloads\\Computer Organisation (7) (2).jpg"));
	     Dimension size = general_background.getPreferredSize();
	     general_background.setBounds(0,0,size.width,size.height);
		
		int mode = 2; // Identifier increasing difficulty mode
		JButton easy = new JButton("Easy");
		easy.setForeground(new Color(0x0FFFFFF) );
		easy.setBackground(new Color(0x0f039b1));
		easy.setFont(f1);
		easy.setBorder(BorderFactory.createLineBorder(new Color (0x0e305ad), 5));
		easy.setBounds((screen_width/2) -100, (screen_height/2) - 140, 200, 35);
		frame.add(easy);
		
		easy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				easy1(frame, screenSize, q, a, q_op, mode, null, null);
			};

		});
		
		JButton Intermediate = new JButton("Intermediate");
		Intermediate.setForeground(new Color(0x0FFFFFF) );
		Intermediate.setBackground(new Color(0x0f039b1));
		Intermediate.setFont(f1);
		Intermediate.setBorder(BorderFactory.createLineBorder(new Color (0x0e305ad), 5));
		Intermediate.setBounds((screen_width/2)-100, (screen_height/2) - 80, 200, 35);
		frame.add(Intermediate);
		
		Intermediate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				Intermed1(frame, screenSize, q, a, q_op, null, mode, null, null);
			};

		});
		
		JButton Difficult = new JButton("Difficult");
		Difficult.setForeground(new Color(0x0FFFFFF) );
		Difficult.setBackground(new Color(0x0f039b1));
		Difficult.setFont(f1);
		Difficult.setBorder(BorderFactory.createLineBorder(new Color (0x0e305ad), 5));
		Difficult.setBounds((screen_width/2) -100, (screen_height/2) - 20, 200, 35);
		frame.add(Difficult);
		
		Difficult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				difficult1(frame, screenSize, q, a, q_op, null, mode, null, null);
			};

		});
		JButton rtrn = new JButton("Return");
		rtrn.setForeground(new Color(0x0FFFFFF) );
		rtrn.setBackground(new Color(0x0f039b1));
		rtrn.setFont(f1);
		rtrn.setBorder(BorderFactory.createLineBorder(new Color (0x0e305ad), 5));
		rtrn.setBounds((screen_width/2) - 100, (screen_height/2) + 40, 200, 35);
		frame.add(rtrn);
		

		rtrn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				modes(frame, screenSize, q, a, q_op);
				
				

			};

		});
		frame.add(general_background);
	}
	
	
		
	
	public static void easy1(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, int mode, String[] all_six_results, Instant startTime) {
		int screen_width = (int) screenSize.getWidth();
		int screen_height = (int) screenSize.getHeight();
		Font f1 = new Font(Font.DIALOG,  Font.BOLD, 18);
		
		 JLabel general_background = new JLabel();
		 general_background.setIcon(new ImageIcon("C:\\Users\\adeto\\Downloads\\Computer Organisation (7) (2).jpg"));
	     Dimension size = general_background.getPreferredSize();
	     general_background.setBounds(0,0,size.width,size.height);
		
			String[] resulte = new String[2]; // holds results for increasing difficulty mode
			String[] single_result = new String[1]; // holds results for random mode
			
			JLabel level = new JLabel();
			level.setText("Level 1: Easy");
			level.setBounds((screen_width/2)- 130, (screen_height/2) - 240, 800, 40);
			level.setFont(f1);
			
			frame.add(level);
			
			JLabel q1 = new JLabel();
			q1.setText("Question 1: " + q.get(0)); 
			q1.setBounds((screen_width/2) - 350, (screen_height/2) - 180, 800, 35);
			q1.setFont(f1);
			
			frame.add(q1);

				
				
			ButtonGroup ans = new ButtonGroup(); // question answer options
			JRadioButton first = new JRadioButton(((ArrayList<String>) q_op.get(0)).get(0));
			first.setBounds((screen_width/2) - 400, (screen_height/2) - 140, 800, 35);
			first.setFont(f1);
			first.setForeground(new Color(0x0FFFFFF) );
			first.setBackground(new Color(0x0f039b1));
			JRadioButton second = new JRadioButton(((ArrayList<String>) q_op.get(0)).get(1));
			second.setBounds((screen_width/2) - 400, (screen_height/2) - 100, 800, 35);
			second.setFont(f1);
			second.setForeground(new Color(0x0FFFFFF) );
			second.setBackground(new Color(0x0f039b1));
			JRadioButton third = new JRadioButton(((ArrayList<String>) q_op.get(0)).get(2));
			third.setBounds((screen_width/2) - 400, (screen_height/2) - 60, 800, 35);
			third.setFont(f1);
			third.setForeground(new Color(0x0FFFFFF) );
			third.setBackground(new Color(0x0f039b1));
			JRadioButton fourth = new JRadioButton(((ArrayList<String>) q_op.get(0)).get(3));
			fourth.setBounds((screen_width/2) - 400, (screen_height/2) -20 , 800, 35);
			ans.add(first); ans.add(second); ans.add(third);ans.add(fourth);
			fourth.setFont(f1);
			
			fourth.setForeground(new Color(0x0FFFFFF) );
			fourth.setBackground(new Color(0x0f039b1));
			first.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();
					frame.repaint();
					
					if (mode == 1) { // for random mode
						single_result[0] = "correct";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 1); /* the 1 represent the question number, necessary for the 
						showing of results*/
					} else if (mode == 2) { // for increasing difficulty mode
						resulte[0] = "correct";
						easy2(frame, screenSize, q, a, q_op, resulte, mode, null, null);
					} else if(mode == 3) { // for timed mode
						all_six_results[0] = "correct"; 
						easy2(frame, screenSize, q, a, q_op, resulte, mode, all_six_results, startTime);	
					}

				};

			});
			second.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();
					frame.repaint();
					if (mode == 1) { // for random mode
						single_result[0] = "incorrect";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 1);
					} else if (mode == 2) { // for increasing difficulty mode
						resulte[0] = "incorrect";
						easy2(frame, screenSize, q, a, q_op, resulte, mode, null, null);
					}else if (mode == 3) { // for timed mode
						all_six_results[0] = "incorrect";
						easy2(frame, screenSize, q, a, q_op, resulte, mode, all_six_results, startTime);	
					}
				};

			});
			third.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();
					frame.repaint();
					if (mode == 1) { // for random mode
						single_result[0] = "incorrect";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 1);
					} else if (mode == 2) { // for increasing difficulty mode
						resulte[0] = "incorrect";
						easy2(frame, screenSize, q, a, q_op, resulte, mode, null, null);
					} else if (mode == 3) { // for timed mode
						all_six_results[0] = "incorrect";
						easy2(frame, screenSize, q, a, q_op, resulte, mode, all_six_results, startTime);	
					}
				};

			});
			fourth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();
					frame.repaint();
					if (mode == 1) { // for random mode
						single_result[0] = "incorrect";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 1);
					} else if (mode == 3) { // for increasing difficulty mode
						resulte[0] = "incorrect";
						easy2(frame, screenSize, q, a, q_op, resulte, mode, null, null);
					}else if (mode == 3) {// for timed mode
						all_six_results[0] = "incorrect"; // stores result in first position
						easy2(frame, screenSize, q, a, q_op, resulte, mode, all_six_results, startTime);	
					}

				};

			});
			frame.add(first);frame.add(second);frame.add(third);frame.add(fourth);
			frame.add(general_background);

				

					}
	public static void easy2(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, String[] resulte,  int mode, String[] all_six_results, Instant startTime) {
		int screen_width = (int) screenSize.getWidth();
		int screen_height = (int) screenSize.getHeight();
		String[] single_result = new String[1];
		Font f1 = new Font(Font.DIALOG,  Font.BOLD, 18);
		
		 JLabel general_background = new JLabel();
		 general_background.setIcon(new ImageIcon("C:\\Users\\adeto\\Downloads\\Computer Organisation (7) (2).jpg"));
	     Dimension size = general_background.getPreferredSize();
	     general_background.setBounds(0,0,size.width,size.height);
	     
			JLabel q2 = new JLabel();
			q2.setText("Question 2: " + q.get(1)); 
			q2.setBounds((screen_width/2) - 350, (screen_height/2) - 180, 800, 35);
			q2.setFont(f1);
			frame.add(q2);
			
				
				
			ButtonGroup ans = new ButtonGroup();
			JRadioButton first = new JRadioButton(((ArrayList<String>) q_op.get(1)).get(0));
			first.setBounds((screen_width/2) - 400, (screen_height/2) - 140, 800, 35);
			first.setFont(f1);
			first.setForeground(new Color(0x0FFFFFF) );
			first.setBackground(new Color(0x0f039b1));
			JRadioButton second = new JRadioButton(((ArrayList<String>) q_op.get(1)).get(1));
			second.setBounds((screen_width/2) - 400, (screen_height/2) - 100, 800, 35);
			second.setFont(f1);
			second.setForeground(new Color(0x0FFFFFF) );
			second.setBackground(new Color(0x0f039b1));
			JRadioButton third = new JRadioButton(((ArrayList<String>) q_op.get(1)).get(2));
			third.setBounds((screen_width/2) - 400, (screen_height/2) - 60, 800, 35);
			third.setFont(f1);
			third.setForeground(new Color(0x0FFFFFF) );
			third.setBackground(new Color(0x0f039b1));
			JRadioButton fourth = new JRadioButton(((ArrayList<String>) q_op.get(1)).get(3));
			fourth.setBounds((screen_width/2) - 400, (screen_height/2) - 20, 800, 35);
			fourth.setFont(f1);
			fourth.setForeground(new Color(0x0FFFFFF) );
			fourth.setBackground(new Color(0x0f039b1));
			ans.add(first); ans.add(second); ans.add(third);ans.add(fourth);
			frame.add(first);frame.add(second);frame.add(third);frame.add(fourth);
			
			first.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();
					frame.repaint();
					if (mode == 1) {
						single_result[0] = "incorrect";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 2);
					} else if (mode == 2){
						resulte[1] = "incorrect";
						showresults_incrdiff(frame, screenSize, q, a, q_op, 1, resulte);
					}else if (mode == 3) {
						all_six_results[1] = "incorrect";
						Intermed1(frame, screenSize, q, a, q_op, resulte, mode, all_six_results, startTime);	
					}
				};

			});
			second.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();
					frame.repaint();
					if (mode == 1) {
						single_result[0] = "correct";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 2);
					} else if (mode == 2) {
						resulte[1] = "correct";
						showresults_incrdiff(frame, screenSize, q, a, q_op, 1, resulte);
					} else if (mode == 3) {
						all_six_results[1] = "correct";
						Intermed1(frame, screenSize, q, a, q_op, resulte, mode, all_six_results, startTime);	
					}
				};

			});
			third.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();
					frame.repaint();
					if (mode == 1) {
						single_result[0] = "incorrect";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 2);
					} else if (mode == 2) {
					resulte[1] = "incorrect";
					showresults_incrdiff(frame, screenSize, q, a, q_op, 1, resulte);
					} else if (mode == 3) {
						all_six_results[1] = "correct";
						Intermed1(frame, screenSize, q, a, q_op, resulte, mode, all_six_results, startTime);	
					}
				};

			});
			fourth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();
					frame.repaint();
					if (mode == 1) {
						single_result[0] = "incorrect";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 2);
					} else if (mode == 2){
						resulte[1] = "incorrect";
						showresults_incrdiff(frame, screenSize, q, a, q_op,1, resulte);
					}else if (mode == 3) {
						all_six_results[1] = "correct";
						Intermed1(frame, screenSize, q, a, q_op, resulte, mode, all_six_results, startTime);	
					}

				};

			});
			
			frame.add(general_background);
			
	} public static void Intermed1(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, String[] resulte, int mode, String[] all_six_results, Instant startTime) {
		int screen_width = (int) screenSize.getWidth();
		int screen_height = (int) screenSize.getHeight();
		
		 JLabel general_background = new JLabel();
		 general_background.setIcon(new ImageIcon("C:\\Users\\adeto\\Downloads\\Computer Organisation (7) (2).jpg"));
	     Dimension size = general_background.getPreferredSize();
	     general_background.setBounds(0,0,size.width,size.height);
		
		Font f1 = new Font(Font.DIALOG,  Font.BOLD, 18);
			String[] resulti = new String[2];
			String[] single_result = new String[1];
			
			
			JLabel q3 = new JLabel();
			q3.setText("Question 3: " + q.get(2)); 
			q3.setBounds((screen_width/2) - 400, (screen_height/2) - 180, 800, 35);
			q3.setFont(f1);
			frame.add(q3);
			
			JLabel level = new JLabel();
			level.setText("Level 2: Intermediate");
			level.setBounds((screen_width/2)- 110, (screen_height/2) - 400, 800, 350 );
			level.setFont(f1);
			frame.add(level);
				
				
			ButtonGroup ans = new ButtonGroup();
			JRadioButton first = new JRadioButton(((ArrayList<String>) q_op.get(2)).get(0));
			first.setForeground(new Color(0x0FFFFFF) );
			first.setBackground(new Color(0x0f039b1));
			first.setFont(f1);
			first.setBounds((screen_width/2) - 400, (screen_height/2) - 140, 800, 35);
			JRadioButton second = new JRadioButton(((ArrayList<String>) q_op.get(2)).get(1));
			second.setForeground(new Color(0x0FFFFFF) );
			second.setBackground(new Color(0x0f039b1));
			second.setFont(f1);
			second.setBounds((screen_width/2) - 400, (screen_height/2) - 100, 800, 35);
			JRadioButton third = new JRadioButton(((ArrayList<String>) q_op.get(2)).get(2));
			third.setForeground(new Color(0x0FFFFFF) );
			third.setBackground(new Color(0x0f039b1));
			third.setFont(f1);
			third.setBounds((screen_width/2) - 400, (screen_height/2) - 60, 800, 35);
			JRadioButton fourth = new JRadioButton(((ArrayList<String>) q_op.get(2)).get(3));
			fourth.setForeground(new Color(0x0FFFFFF) );
			fourth.setBackground(new Color(0x0f039b1));
			fourth.setFont(f1);
			fourth.setBounds((screen_width/2) - 400, (screen_height/2) - 20, 800, 35);
			ans.add(first); ans.add(second); ans.add(third);ans.add(fourth);
			frame.add(first);frame.add(second);frame.add(third);frame.add(fourth);
			
			first.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();
					frame.repaint();
					if (mode == 1) {
						single_result[0] = "incorrect";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 3);
					} else if (mode == 2) {
					resulti[0] = "incorrect";
					intermed2(frame, screenSize, q, a, q_op, resulti, mode, null, null);
					} else if (mode == 3) {
						all_six_results[2] = "incorrect";
						intermed2(frame, screenSize, q, a, q_op, resulte, mode, all_six_results, startTime);	
					}
				};

			});
			second.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();
					frame.repaint();
					if (mode == 1) {
						single_result[0] = "correct";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 3);
					} else if (mode == 2){
					resulti[0] = "correct";
					intermed2(frame, screenSize, q, a, q_op, resulti, mode, null, null);
					} else if (mode == 3) {
						all_six_results[2] = "correct";
						intermed2(frame, screenSize, q, a, q_op, resulte, mode, all_six_results, startTime);	
					}
				};

			});
			third.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();
					frame.repaint();
					if (mode == 1) {
						single_result[0] = "incorrect";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 3);
					} else if (mode == 2){
					resulti[0] = "incorrect";
					intermed2(frame, screenSize, q, a, q_op, resulti, mode, null, null);
					}else if (mode == 3) {
						all_six_results[2] = "incorrect";
						intermed2(frame, screenSize, q, a, q_op, resulte, mode, all_six_results, startTime);	
					}
				};

			});
			fourth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();
					frame.repaint();
					if (mode == 1) {
						single_result[0] = "incorrect";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 3);
					} else if (mode == 2) {
						resulti[0] = "incorrect";
						intermed2(frame, screenSize, q, a, q_op, resulti, mode, null, null);
					}else if (mode == 3) {
						all_six_results[2] = "incorrect";
						intermed2(frame, screenSize, q, a, q_op, resulte, mode, all_six_results, startTime);	
					}

				};

			});
			
			frame.add(general_background);
			
	} public static void intermed2(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, String[] resulti, int mode, String[] all_six_results, Instant startTime) {
		int screen_width = (int) screenSize.getWidth();
		int screen_height = (int) screenSize.getHeight();
		String[] single_result = new String[1];
		
		 JLabel general_background = new JLabel();
		 general_background.setIcon(new ImageIcon("C:\\Users\\adeto\\Downloads\\Computer Organisation (7) (2).jpg"));
	     Dimension size = general_background.getPreferredSize();
	     general_background.setBounds(0,0,size.width,size.height);
	     
		Font f1 = new Font(Font.DIALOG,  Font.BOLD, 18); 
		
		
			JLabel q4 = new JLabel();
			q4.setText("Question 4: " + q.get(3)); 
			q4.setBounds((screen_width/2) - 400, (screen_height/2) - 180, 1200, 35);
			q4.setFont(f1);
			frame.add(q4);
			
				
				
			ButtonGroup ans = new ButtonGroup();
			JRadioButton first = new JRadioButton(((ArrayList<String>) q_op.get(3)).get(0));
			first.setForeground(new Color(0x0FFFFFF) );
			first.setBackground(new Color(0x0f039b1));
			first.setFont(f1);
			first.setBounds((screen_width/2) - 400, (screen_height/2) - 140, 800, 35);
			JRadioButton second = new JRadioButton(((ArrayList<String>) q_op.get(3)).get(1));
			second.setForeground(new Color(0x0FFFFFF) );
			second.setBackground(new Color(0x0f039b1));
			second.setFont(f1);
			second.setBounds((screen_width/2) - 400, (screen_height/2) - 100, 800, 35);
			frame.add(first); frame.add(second);
			
			first.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();
					frame.repaint();
					if (mode == 1) {
						single_result[0] = "incorrect";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 4);
					} else if (mode == 2) {
					resulti[1] = "incorrect";
					showresults_incrdiff(frame, screenSize, q, a, q_op, 2, resulti);
					}else if (mode == 3) {
						all_six_results[3] = "incorrect";
						difficult1(frame, screenSize, q, a, q_op, resulti, mode, all_six_results, startTime);	
					}
				};

			});
			second.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();
					frame.repaint();
					if (mode == 1) {
						single_result[0] = "correct";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 4);
					} else if (mode == 2) {
					resulti[1] = "correct";
					showresults_incrdiff(frame, screenSize, q, a, q_op, 2, resulti);
					}else if (mode == 3) {
						all_six_results[3] = "correct";
						difficult1(frame, screenSize, q, a, q_op, resulti, mode, all_six_results, startTime);	
					}
				};

			});

			frame.add(general_background);
			
} public static void difficult1(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, String[] resulti, int mode, String[] all_six_results, Instant startTime) {
	int screen_width = (int) screenSize.getWidth();
	int screen_height = (int) screenSize.getHeight();
	
	Font f1 = new Font(Font.DIALOG,  Font.BOLD, 18); 
	
	 JLabel general_background = new JLabel();
	 general_background.setIcon(new ImageIcon("C:\\Users\\adeto\\Downloads\\Computer Organisation (7) (2).jpg"));
    Dimension size = general_background.getPreferredSize();
    general_background.setBounds(0,0,size.width,size.height);
	
		String[] resultd = new String[2];
		String[] single_result = new String[1];
		
		JLabel q5 = new JLabel();
		q5.setText("Question 5: " + q.get(4)); 
		q5.setBounds((screen_width/2) - 400, (screen_height/2) - 180, 800, 35);
		q5.setFont(f1);
		frame.add(q5);
		JLabel level = new JLabel();
		level.setText("Level 3: Difficult");
		level.setFont(f1);
		level.setBounds((screen_width/2)- 110, (screen_height/2) - 220, 800, 35 );
		frame.add(level);
			
			
		ButtonGroup ans = new ButtonGroup();
		JRadioButton first = new JRadioButton(((ArrayList<String>) q_op.get(4)).get(0));
		first.setForeground(new Color(0x0FFFFFF) );
		first.setBackground(new Color(0x0f039b1));
		first.setFont(f1);
		first.setBounds((screen_width/2) - 400, (screen_height/2) - 140, 800, 35);
		JRadioButton second = new JRadioButton(((ArrayList<String>) q_op.get(4)).get(1));
		second.setForeground(new Color(0x0FFFFFF) );
		second.setBackground(new Color(0x0f039b1));
		second.setFont(f1);
		second.setBounds((screen_width/2) - 400, (screen_height/2) - 100, 800, 35);
		JRadioButton third = new JRadioButton(((ArrayList<String>) q_op.get(4)).get(2));
		third.setForeground(new Color(0x0FFFFFF) );
		third.setBackground(new Color(0x0f039b1));
		third.setFont(f1);
		third.setBounds((screen_width/2) - 400, (screen_height/2) - 60, 800, 35);
		JRadioButton fourth = new JRadioButton(((ArrayList<String>) q_op.get(4)).get(3));
		fourth.setForeground(new Color(0x0FFFFFF) );
		fourth.setBackground(new Color(0x0f039b1));
		fourth.setFont(f1);
		fourth.setBounds((screen_width/2) - 400, (screen_height/2) - 20, 800, 35);
		ans.add(first); ans.add(second); ans.add(third);ans.add(fourth);
		frame.add(first);frame.add(second);frame.add(third);frame.add(fourth);
		
		first.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				if (mode == 1) {
					single_result[0] = "correct";
					showresult_random(frame, screenSize, q, a, q_op, single_result, 5);
				} else if (mode == 2) {
				resultd[0] = "correct";
				difficult2(frame, screenSize, q, a, q_op, resultd, mode, null, null);
				}else if (mode == 3) {
					all_six_results[4] = "correct";
					difficult2(frame, screenSize, q, a, q_op, resulti, mode, all_six_results, startTime);	
				}
			};

		});
		second.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				if (mode == 1) {
					single_result[0] = "incorrect";
					showresult_random(frame, screenSize, q, a, q_op, single_result, 5);
				} else if (mode == 2){
					resultd[0] = "incorrect";
					difficult2(frame, screenSize, q, a, q_op, resultd, mode, null, null);
				}else if (mode == 3) {
					all_six_results[4] = "incorrect";
					difficult2(frame, screenSize, q, a, q_op, resulti, mode, all_six_results, startTime);	
				}
			};

		});
		third.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				if (mode == 1) {
					single_result[0] = "incorrect";
					showresult_random(frame, screenSize, q, a, q_op, single_result, 5);
				} else if (mode == 2){
					resultd[0] = "incorrect";
					difficult2(frame, screenSize, q, a, q_op, resultd, mode, null, null);
				}else if (mode == 3) {
					all_six_results[4] = "incorrect";
					difficult2(frame, screenSize, q, a, q_op, resulti, mode, all_six_results, startTime);	
				}
			};

		});
		fourth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				if (mode == 1) {
					single_result[0] = "incorrect";
					showresult_random(frame, screenSize, q, a, q_op, single_result, 5);
				} else if (mode == 2) {
					resultd[0] = "incorrect";
					difficult2(frame, screenSize, q, a, q_op, resultd, mode, null, null);
				}else if (mode == 3) {
					all_six_results[4] = "incorrect";
					difficult2(frame, screenSize, q, a, q_op, resulti, mode, all_six_results, startTime);	
				}

			};

		});
		
		frame.add(general_background);
		
} public static void difficult2(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, String[] resultd,  int mode, String[] all_six_results, Instant startTime) {
	int screen_width = (int) screenSize.getWidth();
	int screen_height = (int) screenSize.getHeight();
	Font f1 = new Font(Font.DIALOG,  Font.BOLD, 18); 
	
	 JLabel general_background = new JLabel();
	 general_background.setIcon(new ImageIcon("C:\\Users\\adeto\\Downloads\\Computer Organisation (7) (2).jpg"));
    Dimension size = general_background.getPreferredSize();
    general_background.setBounds(0,0,size.width,size.height);
    
    
	String[] single_result = new String[1];
		JLabel q6 = new JLabel();
		q6.setText("Question 6: " + q.get(5)); 
		q6.setFont(f1);
		q6.setBounds((screen_width/2) - 400, (screen_height/2) - 180, 800, 35);
		frame.add(q6);
		
			
			
		ButtonGroup ans = new ButtonGroup();
		JRadioButton first = new JRadioButton(((ArrayList<String>) q_op.get(5)).get(0));
		first.setForeground(new Color(0x0FFFFFF) );
		first.setBackground(new Color(0x0f039b1));
		first.setFont(f1);
		first.setBounds((screen_width/2) - 400, (screen_height/2) - 140, 800, 35);
		JRadioButton second = new JRadioButton(((ArrayList<String>) q_op.get(5)).get(1));
		second.setForeground(new Color(0x0FFFFFF) );
		second.setBackground(new Color(0x0f039b1));
		second.setFont(f1);
		second.setBounds((screen_width/2) - 400, (screen_height/2) - 100, 800, 35);
		JRadioButton third = new JRadioButton(((ArrayList<String>) q_op.get(5)).get(2));
		third.setForeground(new Color(0x0FFFFFF) );
		third.setBackground(new Color(0x0f039b1));
		third.setFont(f1);
		third.setBounds((screen_width/2) - 400, (screen_height/2) - 60, 800, 35);
		JRadioButton fourth = new JRadioButton(((ArrayList<String>) q_op.get(5)).get(3));
		fourth.setForeground(new Color(0x0FFFFFF) );
		fourth.setBackground(new Color(0x0f039b1));
		fourth.setFont(f1);
		fourth.setBounds((screen_width/2) - 400, (screen_height/2) - 20, 800, 35);
		ans.add(first); ans.add(second); ans.add(third);ans.add(fourth);
		frame.add(first);frame.add(second);frame.add(third);frame.add(fourth);
		
		first.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				if (mode == 1) {
					single_result[0] = "incorrect";
					showresult_random(frame, screenSize, q, a, q_op, single_result, 6);
				} else if (mode == 2) {
					resultd[1] = "incorrect";
					showresults_incrdiff(frame, screenSize, q, a, q_op, 3, resultd);
				} else if (mode == 3) {
					all_six_results[5] = "incorrect";
					showresults_countdown(frame, screenSize, q, a, q_op, all_six_results, startTime);
				}
			};

		});
		second.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				if (mode == 1) {
					single_result[0] = "incorrect";
					showresult_random(frame, screenSize, q, a, q_op, single_result, 6);
				} else if (mode == 2) {
					resultd[1] = "incorrect";
					showresults_incrdiff(frame, screenSize, q, a, q_op, 3, resultd);
				}else if (mode == 3) {
					all_six_results[5] = "incorrect";
					showresults_countdown(frame, screenSize, q, a, q_op, all_six_results, startTime);
				}
			};

		});
		third.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				if (mode == 1) {
					single_result[0] = "correct";
					showresult_random(frame, screenSize, q, a, q_op, single_result, 6);
				} else if (mode == 2){
				resultd[1] = "correct";
				showresults_incrdiff(frame, screenSize, q, a, q_op, 3, resultd);
				} else if (mode == 3) {
					all_six_results[5] = "correct";
					showresults_countdown(frame, screenSize, q, a, q_op, all_six_results, startTime);
				}
			};

		});
		fourth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				if (mode == 1) {
					single_result[0] = "incorrect";
					showresult_random(frame, screenSize, q, a, q_op, single_result, 6);
				} else if (mode == 2){
				resultd[1] = "incorrect";
				showresults_incrdiff(frame, screenSize, q, a, q_op, 3, resultd);
				
				} else if (mode == 3) {
					all_six_results[5] = "incorrect";
					showresults_countdown(frame, screenSize, q, a, q_op, all_six_results, startTime);
				}
			};

		});
		
		frame.add(general_background);
} 
public static void showresults_incrdiff(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, int Selection, String[] result) {
// shows result for the increasing difficulty mode, mode 2
	
	int screen_width = (int) screenSize.getWidth();
	int screen_height = (int) screenSize.getHeight();
	Font f1 = new Font(Font.DIALOG,  Font.BOLD, 100);
	Font f2 = new Font(Font.DIALOG,  Font.BOLD, 40);
	Font f3 = new Font(Font.DIALOG,  Font.BOLD, 36);
	
	JLabel results_background = new JLabel();
	results_background.setIcon(new ImageIcon("C:\\Users\\adeto\\Downloads\\results background.jpg"));
    Dimension size = results_background.getPreferredSize();
    results_background.setBounds(0,0,size.width,size.height);
    
    int totalQuestions = 2;
    int correctQuestions = 0;
    for (int i = 0; i < 2; i++) {
    	if (result[i].equals("correct")) {
    		correctQuestions ++;
    	}
    }
	JLabel totalValue = new JLabel(); // prints the question
	totalValue.setText("Out of " + totalQuestions + " questions correct!");
	totalValue.setFont(f2);
	totalValue.setForeground(new Color(0x000000));
	totalValue.setBounds((screen_width / 2) - 250, (screen_height / 2) + 300, 800, 50);
	frame.add(totalValue);
    
	JLabel correctAmount = new JLabel(); // prints the question
	correctAmount.setText(Integer.toString(correctQuestions));
	correctAmount.setFont(f1);
	correctAmount.setForeground(new Color(0x000000));
	correctAmount.setBounds((screen_width / 2) - 70, (screen_height / 2) - 70, 400, 90);
	frame.add(correctAmount);
	
	JLabel result_statement = new JLabel(); // prints the question
	result_statement.setText("You answered: ");
	result_statement.setFont(f2);
	result_statement.setForeground(new Color(0x000000));
	result_statement.setBounds((screen_width / 2) - 200, (screen_height / 2) - 350, 800, 50);
	frame.add(result_statement);
    
	
	
		JButton rtrn = new JButton("Return");
		rtrn.setForeground(new Color(0x0FFFFFF) );
		rtrn.setBackground(new Color(0x0f039b1));
		rtrn.setFont(f3);
		rtrn.setBorder(BorderFactory.createLineBorder(new Color (0x0e305ad), 5));
		rtrn.setBounds((screen_width/2) - 700, (screen_height/2) - 25, 200, 60);
		frame.add(rtrn);

		
		rtrn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				level_choice(frame, screenSize, q, a, q_op);
				


			};

		});
		frame.add(results_background);
		
} public static void showresult_random(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, String[] single_result, int question) {
	
	int screen_width = (int) screenSize.getWidth();
	int screen_height = (int) screenSize.getHeight();
	Font f1 = new Font(Font.DIALOG,  Font.BOLD, 100);
	Font f2 = new Font(Font.DIALOG,  Font.BOLD, 40);
	Font f3 = new Font(Font.DIALOG,  Font.BOLD, 36);
	
	JLabel results_background = new JLabel();
	results_background.setIcon(new ImageIcon("C:\\Users\\adeto\\Downloads\\results background.jpg"));
    Dimension size = results_background.getPreferredSize();
    results_background.setBounds(0,0,size.width,size.height);
    
    int totalQuestions = 1;
    int correctQuestions = 0;{
    if (single_result[0].equals("correct")) {
    		correctQuestions ++;
    	}
  
	JLabel totalValue = new JLabel(); // prints the question
	totalValue.setText("Out of " + totalQuestions + " question correct!");
	totalValue.setFont(f2);
	totalValue.setForeground(new Color(0x000000));
	totalValue.setBounds((screen_width / 2) - 250, (screen_height / 2) + 300, 800, 50);
	frame.add(totalValue);
    
	JLabel correctAmount = new JLabel(); // prints the question
	correctAmount.setText(Integer.toString(correctQuestions));
	correctAmount.setFont(f1);
	correctAmount.setForeground(new Color(0x000000));
	correctAmount.setBounds((screen_width / 2) - 70, (screen_height / 2) - 70, 400, 90);
	frame.add(correctAmount);
	
	JLabel result_statement = new JLabel(); // prints the question
	result_statement.setText("You answered: ");
	result_statement.setFont(f2);
	result_statement.setForeground(new Color(0x000000));
	result_statement.setBounds((screen_width / 2) - 200, (screen_height / 2) - 350, 800, 50);
	frame.add(result_statement);
    
	
	
		JButton rtrn = new JButton("Return");
		rtrn.setForeground(new Color(0x0FFFFFF) );
		rtrn.setBackground(new Color(0x0f039b1));
		rtrn.setFont(f3);
		rtrn.setBorder(BorderFactory.createLineBorder(new Color (0x0e305ad), 5));
		rtrn.setBounds((screen_width/2) - 700, (screen_height/2) - 25, 200, 60);
		frame.add(rtrn);

		
		rtrn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				modes(frame, screenSize, q, a, q_op);
				


			};

		});
		frame.add(results_background);}
	
} public static void showresults_countdown(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, String[] all_six_results, Instant startTime) {
	int screen_width = (int) screenSize.getWidth();
	int screen_height = (int) screenSize.getHeight();
	Font f1 = new Font(Font.DIALOG,  Font.BOLD, 100);
	Font f2 = new Font(Font.DIALOG,  Font.BOLD, 40);
	Font f3 = new Font(Font.DIALOG,  Font.BOLD, 36);
	
	
	JLabel results_background = new JLabel();
	results_background.setIcon(new ImageIcon("C:\\Users\\adeto\\Downloads\\results background.jpg"));
    Dimension size = results_background.getPreferredSize();
    results_background.setBounds(0,0,size.width,size.height);

	Instant endTime = Instant.now(); // stops the stopwatch
	Duration timeElapsed = Duration.between(startTime, endTime); // calculates the time taken
	
    int totalQuestions = 6;
    int correctQuestions = 0;
    for (int i = 0; i < 6; i++){
    if (all_six_results[i].equals("correct")) {
    		correctQuestions ++;
    	}
    }
  
	JLabel totalValue = new JLabel(); // prints the question
	totalValue.setText("Out of " + totalQuestions + " questions correct in " + formatDuration(timeElapsed)+ " ");
	totalValue.setFont(f2);
	totalValue.setForeground(new Color(0x000000));
	totalValue.setBounds((screen_width / 2) - 400, (screen_height / 2) + 300, 800, 50);
	frame.add(totalValue);
    
	JLabel correctAmount = new JLabel(); // prints the question
	correctAmount.setText(Integer.toString(correctQuestions));
	correctAmount.setFont(f1);
	correctAmount.setForeground(new Color(0x000000));
	correctAmount.setBounds((screen_width / 2) - 70, (screen_height / 2) - 70, 400, 90);
	frame.add(correctAmount);
	
	JLabel result_statement = new JLabel(); // prints the question
	result_statement.setText("You answered: ");
	result_statement.setFont(f2);
	result_statement.setForeground(new Color(0x000000));
	result_statement.setBounds((screen_width / 2) - 200, (screen_height / 2) - 350, 800, 50);
	frame.add(result_statement);
    
	
	
		JButton rtrn = new JButton("Return");
		rtrn.setForeground(new Color(0x0FFFFFF) );
		rtrn.setBackground(new Color(0x0f039b1));
		rtrn.setFont(f3);
		rtrn.setBorder(BorderFactory.createLineBorder(new Color (0x0e305ad), 5));
		rtrn.setBounds((screen_width/2) - 700, (screen_height/2) - 25, 200, 60);
		frame.add(rtrn);

		
		rtrn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				modes(frame, screenSize, q, a, q_op);
				


			};

		});
		frame.add(results_background);
	
} public static String formatDuration(Duration duration) {
    long hours = duration.toHours(); // isolates hours
    long minutes = duration.minusHours(hours).toMinutes(); // isolates minutes
    long seconds = duration.minusHours(hours).minusMinutes(minutes).getSeconds(); // isolates seconds
    long milliseconds = duration.minusHours(hours).minusMinutes(minutes).minusSeconds(seconds).toMillis(); // isolates milliseconds

    return String.format("%d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds); // formats how many decimal points wanted for each time measurement
}
}