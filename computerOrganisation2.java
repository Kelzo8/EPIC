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
		// List of all possible 6 questions
		ArrayList<String> q = new ArrayList<String>(); 
		q.add("What is the name of the third level of the ‘Contemporary Multilevel Machine’?");
		q.add("What does ALU stand for?");
		q.add("Which three levels of the 'Contemporary Multilevel Machine' are numeric?");
		q.add("True or False: 'Translation is when each line of code must be examined and decoded before being executed'");
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
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(null);// using no layout managers
		frame.setForeground(new Color (0x0f29ad8));
		frame.getContentPane().setBackground(new Color (0x0f29ad8) );
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		modes(frame, screenSize, q, a, q_op);
		frame.setResizable(false); // frame size can't be changed
		frame.setVisible(true); // makes us able to see the screen
		
		
		 
	}

	public static void modes(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op) {
// this is the first screen that appears once the button "computer organisation button is clicked
		int screen_width = (int) screenSize.getWidth();
		int screen_height = (int) screenSize.getHeight();
		Font f2 = new Font(Font.DIALOG, Font.BOLD, 30); // the font that i have chose
		
        JLabel screen_title = new JLabel();
        screen_title.setIcon(new ImageIcon("C:\\Users\\adeto\\Downloads\\screen_title.JPG"));
        Dimension size = screen_title.getPreferredSize();
        screen_title.setBounds((screen_width / 2) - 435, (screen_height / 2) - 300,size.width,size.height);
        frame.add(screen_title);
        
        JLabel pointer = new JLabel();
        pointer.setIcon(new ImageIcon ("C:\\Users\\adeto\\Downloads\\output-onlinepngtools.png"));
        Dimension size1 = pointer.getPreferredSize();
        pointer.setBounds((screen_width / 2) - 675, (screen_height / 2) - 500,size1.width,size1.height);
        frame.add(pointer);
		
		


		JLabel Quiz_mode = new JLabel("Please choose a Quiz mode");
// quiz 1
		JButton Random = new JButton();
		Random.setFont(f2);
		Random.setText("Random Question Mode");
		Random.setForeground(new Color(0x0FFFFFF) );
		Random.setBackground(new Color(0x0f039b1));
		Random.setBorder(BorderFactory.createLineBorder(new Color (0x0e305ad), 5));
		Random.setBounds((screen_width / 2) - 210, (screen_height / 2) - 110, 400, 50);
		
		Random.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();// these remove all of the elements on screen so the others can be shown and not
									// overlap
				frame.repaint();
				
				int mode = 1;
				Random rand = new Random();
				int rand_question = rand.nextInt(6+1);
				if (rand_question ==1 ) {
					easy1(frame, screenSize, q, a, q_op, mode, null, null);
				} else if (rand_question == 2) {
					easy2(frame, screenSize, q, a, q_op, null, mode, null, null);
				}else if (rand_question == 3) {
					Intermed1(frame, screenSize, q, a, q_op, null, mode, null, null);
				}else if (rand_question == 4) {
					intermed2(frame, screenSize, q, a, q_op, null, mode, null, null);
				}else if (rand_question == 5) {
					difficult1(frame, screenSize, q, a, q_op, null, mode, null, null);
				} else {
					difficult2(frame, screenSize, q, a, q_op, null, mode, null, null);
				}

			};

		});
// quiz 2
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
				frame.revalidate();// these remove all of the elements on screen so the others can be shown and not
				frame.repaint();

				level_choice(frame, screenSize, q, a, q_op);

			};

		});
// quiz 3
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
				begin(frame, screenSize, q, a, q_op);

			};

		});

		frame.add(Quiz_mode);
		frame.add(Random);
		frame.add(increasing_Difficulty);
		frame.add(Timed_mode);

	}
	

	private static void setContentPane(JLabel backgroundLabel) {
		// TODO Auto-generated method stub
		
	}

	public static void begin(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op) {
		int screen_width = (int) screenSize.getWidth();
		int screen_height = (int) screenSize.getHeight();
		int mode = 3;
		String[] all_six_results = new String[6];
		JLabel ask_begin = new JLabel("Try to complete 6 questions in as little time as possible.\n Press 'Start' to start the timer ");
		ask_begin.setBounds((screen_width/2)-190,(screen_height/2)-180,600,50);
		JButton begin = new JButton(); 
		
		begin.setBackground(Color.magenta);
		begin.setText("START");
		begin.setBounds((screen_width / 2) - 150, (screen_height / 2) - 100, 300, 20);
		frame.add(begin);
		frame.add(ask_begin);
		

			begin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();// these remove all of the elements on screen so the others can be shown and not
										// overlap
					frame.repaint();

					Instant startTime = Instant.now();
					 easy1(frame, screenSize, q, a, q_op, mode, all_six_results, startTime);
					

				};

			});
		}  
	
	public static void level_choice( JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op) {
		int screen_width = (int) screenSize.getWidth();
		int screen_height = (int) screenSize.getHeight();
		int mode = 2;
		JButton easy = new JButton("easy");
		easy.setBounds((screen_width/2) -100, (screen_height/2) - 140, 200, 35);
		frame.add(easy);
		
		JButton Intermediate = new JButton("intermediate");
		Intermediate.setBounds((screen_width/2)-100, (screen_height/2) - 80, 200, 35);
		frame.add(Intermediate);
		
		JButton Difficult = new JButton("difficult");
		Difficult.setBounds((screen_width/2) -100, (screen_height/2) - 20, 200, 35);
		frame.add(Difficult);
		
		JButton rtrn = new JButton("Return");
		rtrn.setBounds((screen_width/2) - 100, (screen_height/2) + 40, 200, 35);
		frame.add(rtrn);
		
		
		easy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				easy1(frame, screenSize, q, a, q_op, mode, null, null);
			};

		});
		Intermediate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				Intermed1(frame, screenSize, q, a, q_op, null, mode, null, null);
			};

		});
		Difficult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				difficult1(frame, screenSize, q, a, q_op, null, mode, null, null);
			};

		});
		rtrn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				modes(frame, screenSize, q, a, q_op);
				
				

			};

		});
	}
	
	
		
	
	public static void easy1(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, int mode, String[] all_six_results, Instant startTime) {
		int screen_width = (int) screenSize.getWidth();
		int screen_height = (int) screenSize.getHeight();
		Font f1 = new Font(Font.DIALOG,  Font.BOLD, 18);
		
			String[] resulte = new String[2];
			String[] single_result = new String[1];
			
			JLabel level = new JLabel();
			level.setText("Level 1: Easy");
			level.setBounds((screen_width/2)- 80, (screen_height/2) - 240, 800, 40);
			level.setFont(f1);
			
			frame.add(level);
			
			JLabel q1 = new JLabel();
			q1.setText("Question 1: " + q.get(0)); 
			q1.setBounds((screen_width/2) - 350, (screen_height/2) - 180, 800, 35);
			q1.setFont(f1);
			
			frame.add(q1);

				
				
			ButtonGroup ans = new ButtonGroup();
			JRadioButton first = new JRadioButton(((ArrayList<String>) q_op.get(0)).get(0));
			first.setBounds((screen_width/2) - 350, (screen_height/2) - 120, 800, 35);
			first.setFont(f1);
			first.setForeground(new Color(0x0FFFFFF) );
			first.setBackground(new Color(0x0f039b1));
			JRadioButton second = new JRadioButton(((ArrayList<String>) q_op.get(0)).get(1));
			second.setBounds((screen_width/2) - 350, (screen_height/2) - 80, 800, 35);
			second.setFont(f1);
			second.setForeground(new Color(0x0FFFFFF) );
			second.setBackground(new Color(0x0f039b1));
			JRadioButton third = new JRadioButton(((ArrayList<String>) q_op.get(0)).get(2));
			third.setBounds((screen_width/2) - 350, (screen_height/2) - 40, 800, 35);
			third.setFont(f1);
			third.setForeground(new Color(0x0FFFFFF) );
			third.setBackground(new Color(0x0f039b1));
			JRadioButton fourth = new JRadioButton(((ArrayList<String>) q_op.get(0)).get(3));
			fourth.setBounds((screen_width/2) - 350, (screen_height/2) , 800, 35);
			ans.add(first); ans.add(second); ans.add(third);ans.add(fourth);
			fourth.setFont(f1);
			frame.add(first);frame.add(second);frame.add(third);frame.add(fourth);
			fourth.setForeground(new Color(0x0FFFFFF) );
			fourth.setBackground(new Color(0x0f039b1));
			first.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();
					frame.repaint();
					
					if (mode == 1) {
						single_result[0] = "correct";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 1);
					} else if (mode == 2) {
						resulte[0] = "correct";
						easy2(frame, screenSize, q, a, q_op, resulte, mode, null, null);
					} else if(mode == 3) {
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
					if (mode == 1) {
						single_result[0] = "incorrect";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 1);
					} else if (mode == 2) {
						resulte[0] = "incorrect";
						easy2(frame, screenSize, q, a, q_op, resulte, mode, null, null);
					}else if (mode == 3) {
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
					if (mode == 1) {
						single_result[0] = "incorrect";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 1);
					} else if (mode == 2) { 
						resulte[0] = "incorrect";
						easy2(frame, screenSize, q, a, q_op, resulte, mode, null, null);
					} else if (mode == 3) {
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
					if (mode == 1) {
						single_result[0] = "incorrect";
						showresult_random(frame, screenSize, q, a, q_op, single_result, 1);
					} else if (mode == 3) {
						resulte[0] = "incorrect";
						easy2(frame, screenSize, q, a, q_op, resulte, mode, null, null);
					}else if (mode == 3) {
						all_six_results[0] = "incorrect";
						easy2(frame, screenSize, q, a, q_op, resulte, mode, all_six_results, startTime);	
					}

				};

			});
				

				

					}
	public static void easy2(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, String[] resulte,  int mode, String[] all_six_results, Instant startTime) {
		int screen_width = (int) screenSize.getWidth();
		int screen_height = (int) screenSize.getHeight();
		String[] single_result = new String[1];
		Font f1 = new Font(Font.DIALOG,  Font.BOLD, 18);
		
		
			JLabel q2 = new JLabel();
			q2.setText("Question 2: " + q.get(1)); 
			q2.setBounds((screen_width/2) - 350, (screen_height/2) - 180, 800, 35);
			q2.setFont(f1);
			frame.add(q2);
			
				
				
			ButtonGroup ans = new ButtonGroup();
			JRadioButton first = new JRadioButton(((ArrayList<String>) q_op.get(1)).get(0));
			first.setBounds((screen_width/2) - 350, (screen_height/2) - 140, 800, 35);
			first.setFont(f1);
			first.setForeground(new Color(0x0FFFFFF) );
			first.setBackground(new Color(0x0f039b1));
			JRadioButton second = new JRadioButton(((ArrayList<String>) q_op.get(1)).get(1));
			second.setBounds((screen_width/2) - 350, (screen_height/2) - 100, 800, 35);
			second.setFont(f1);
			second.setForeground(new Color(0x0FFFFFF) );
			second.setBackground(new Color(0x0f039b1));
			JRadioButton third = new JRadioButton(((ArrayList<String>) q_op.get(1)).get(2));
			third.setBounds((screen_width/2) - 350, (screen_height/2) - 60, 800, 35);
			third.setFont(f1);
			third.setForeground(new Color(0x0FFFFFF) );
			third.setBackground(new Color(0x0f039b1));
			JRadioButton fourth = new JRadioButton(((ArrayList<String>) q_op.get(1)).get(3));
			fourth.setBounds((screen_width/2) - 350, (screen_height/2) - 20, 800, 35);
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
	} public static void Intermed1(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, String[] resulte, int mode, String[] all_six_results, Instant startTime) {
		int screen_width = (int) screenSize.getWidth();
		int screen_height = (int) screenSize.getHeight();
			String[] resulti = new String[2];
			String[] single_result = new String[1];
			JLabel q1 = new JLabel();
			q1.setText("Question 3: " + q.get(2)); 
			q1.setBounds((screen_width/2) - 250, (screen_height/2) - 180, 800, 35);
			frame.add(q1);
			JLabel level = new JLabel();
			level.setText("Level 2: Intermediate");
			level.setBounds((screen_width/2)- 60, (screen_height/2) - 200, 800, 10 );
			frame.add(level);
				
				
			ButtonGroup ans = new ButtonGroup();
			JRadioButton first = new JRadioButton(((ArrayList<String>) q_op.get(2)).get(0));
			first.setBounds((screen_width/2) - 300, (screen_height/2) - 140, 800, 35);
			JRadioButton second = new JRadioButton(((ArrayList<String>) q_op.get(2)).get(1));
			second.setBounds((screen_width/2) - 300, (screen_height/2) - 100, 800, 35);
			JRadioButton third = new JRadioButton(((ArrayList<String>) q_op.get(2)).get(2));
			third.setBounds((screen_width/2) - 300, (screen_height/2) - 60, 800, 35);
			JRadioButton fourth = new JRadioButton(((ArrayList<String>) q_op.get(2)).get(3));
			fourth.setBounds((screen_width/2) - 300, (screen_height/2) - 20, 800, 35);
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
	} public static void intermed2(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, String[] resulti, int mode, String[] all_six_results, Instant startTime) {
		int screen_width = (int) screenSize.getWidth();
		int screen_height = (int) screenSize.getHeight();
		String[] single_result = new String[1];
			JLabel q1 = new JLabel();
			q1.setText("Question 4: " + q.get(3)); 
			q1.setBounds((screen_width/2) - 250, (screen_height/2) - 180, 800, 35);
			frame.add(q1);
			
				
				
			ButtonGroup ans = new ButtonGroup();
			JRadioButton first = new JRadioButton(((ArrayList<String>) q_op.get(3)).get(0));
			first.setBounds((screen_width/2) - 300, (screen_height/2) - 140, 800, 35);
			JRadioButton second = new JRadioButton(((ArrayList<String>) q_op.get(3)).get(1));
			second.setBounds((screen_width/2) - 300, (screen_height/2) - 100, 800, 35);
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


} public static void difficult1(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, String[] resulti, int mode, String[] all_six_results, Instant startTime) {
	int screen_width = (int) screenSize.getWidth();
	int screen_height = (int) screenSize.getHeight();
		String[] resultd = new String[2];
		String[] single_result = new String[1];
		
		JLabel q1 = new JLabel();
		q1.setText("Question 5: " + q.get(4)); 
		q1.setBounds((screen_width/2) - 250, (screen_height/2) - 180, 800, 35);
		frame.add(q1);
		JLabel level = new JLabel();
		level.setText("Level 3: Difficult");
		level.setBounds((screen_width/2)- 60, (screen_height/2) - 200, 800, 10 );
		frame.add(level);
			
			
		ButtonGroup ans = new ButtonGroup();
		JRadioButton first = new JRadioButton(((ArrayList<String>) q_op.get(4)).get(0));
		first.setBounds((screen_width/2) - 300, (screen_height/2) - 140, 800, 35);
		JRadioButton second = new JRadioButton(((ArrayList<String>) q_op.get(4)).get(1));
		second.setBounds((screen_width/2) - 300, (screen_height/2) - 100, 800, 35);
		JRadioButton third = new JRadioButton(((ArrayList<String>) q_op.get(4)).get(2));
		third.setBounds((screen_width/2) - 300, (screen_height/2) - 60, 800, 35);
		JRadioButton fourth = new JRadioButton(((ArrayList<String>) q_op.get(4)).get(3));
		fourth.setBounds((screen_width/2) - 300, (screen_height/2) - 20, 800, 35);
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
} public static void difficult2(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, String[] resultd,  int mode, String[] all_six_results, Instant startTime) {
	int screen_width = (int) screenSize.getWidth();
	int screen_height = (int) screenSize.getHeight();
	String[] single_result = new String[1];
		JLabel q1 = new JLabel();
		q1.setText("Question 6: " + q.get(5)); 
		q1.setBounds((screen_width/2) - 250, (screen_height/2) - 180, 800, 35);
		frame.add(q1);
		
			
			
		ButtonGroup ans = new ButtonGroup();
		JRadioButton first = new JRadioButton(((ArrayList<String>) q_op.get(5)).get(0));
		first.setBounds((screen_width/2) - 300, (screen_height/2) - 140, 800, 35);
		JRadioButton second = new JRadioButton(((ArrayList<String>) q_op.get(5)).get(1));
		second.setBounds((screen_width/2) - 300, (screen_height/2) - 100, 800, 35);
		JRadioButton third = new JRadioButton(((ArrayList<String>) q_op.get(5)).get(2));
		third.setBounds((screen_width/2) - 300, (screen_height/2) - 60, 800, 35);
		JRadioButton fourth = new JRadioButton(((ArrayList<String>) q_op.get(5)).get(3));
		fourth.setBounds((screen_width/2) - 300, (screen_height/2) - 20, 800, 35);
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
} 
public static void showresults_incrdiff(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, int Selection, String[] result) {
	int screen_width = (int) screenSize.getWidth();
	int screen_height = (int) screenSize.getHeight();
	Font f1 = new Font(Font.SANS_SERIF,  Font.BOLD, 18);

	
	if (Selection == 1) {
		JLabel easy_q1 = new JLabel();
		easy_q1.setText("Question 1: " +(String) q.get(0));
		easy_q1.setFont(f1);
		easy_q1.setBounds((screen_width/2) - 700, (screen_height/2) - 325, 800, 35);
		frame.add(easy_q1);
		
		JLabel easy_a1 = new JLabel();
		easy_a1.setText("Answer: " + (String) q_op.get(0).get(0));
		easy_a1.setFont(f1);
		easy_a1.setBounds((screen_width/2) - 700, (screen_height/2) - 275, 800, 35);
		frame.add(easy_a1);
		
		JLabel easy_user1 = new JLabel();
		easy_user1.setText("Your answer was: " + result[0]);
		easy_user1.setFont(f1);
		easy_user1.setBounds((screen_width/2) - 700, (screen_height/2) - 200, 800, 35);
		frame.add(easy_user1);
		
		JLabel divider = new JLabel();
		divider.setText("---------------------------------------------------------------------------");
		divider.setFont(f1);
		divider.setBounds((screen_width/2) - 700, (screen_height/2) - 150, 800, 35);
		frame.add(divider);
		/////////////////////////////////////////////////////////////////////////////
		JLabel easy_q2 = new JLabel();
		easy_q2.setText("Question 2: " +(String) q.get(1));
		easy_q2.setFont(f1);
		easy_q2.setBounds((screen_width/2) - 700, (screen_height/2) - 100, 800, 35);
		frame.add(easy_q2);
		
		JLabel easy_a2 = new JLabel();
		easy_a2.setText("Answer: " + (String) q_op.get(1).get(1));
		easy_a2.setFont(f1);
		easy_a2.setBounds((screen_width/2) - 700, (screen_height/2) - 50, 800, 35);
		frame.add(easy_a2);
		
		JLabel easy_user2 = new JLabel();
		easy_user2.setText("Your answer was: " + result[1]);
		easy_user2.setFont(f1);
		easy_user2.setBounds((screen_width/2) - 700, (screen_height/2) + 25, 800, 35);
		frame.add(easy_user2);
		
		
		} else if (Selection == 2) {
			JLabel Intermed_q1 = new JLabel();
			Intermed_q1.setText("Question 1: " +(String) q.get(2));
			Intermed_q1.setFont(f1);
			Intermed_q1.setBounds((screen_width/2) - 700, (screen_height/2) - 325, 800, 35);
			frame.add(Intermed_q1);
			
			JLabel Intermed_a1 = new JLabel();
			Intermed_a1.setText("Answer: " + (String) q_op.get(2).get(1));
			Intermed_a1.setFont(f1);
			Intermed_a1.setBounds((screen_width/2) - 700, (screen_height/2) - 275, 800, 35);
			frame.add(Intermed_a1);
			
			JLabel Intermed_user1 = new JLabel();
			Intermed_user1.setText("Your answer was: " + result[0]);
			Intermed_user1.setFont(f1);
			Intermed_user1.setBounds((screen_width/2) - 700, (screen_height/2) - 200, 800, 35);
			frame.add(Intermed_user1);
			
			JLabel divider = new JLabel();
			divider.setText("---------------------------------------------------------------------------");
			divider.setFont(f1);
			divider.setBounds((screen_width/2) - 700, (screen_height/2) - 150, 800, 35);
			frame.add(divider);
			/////////////////////////////////////////////////////////////////////////////
			JLabel Intermed_q2 = new JLabel();
			Intermed_q2.setText("Question 2: " +(String) q.get(3));
			Intermed_q2.setFont(f1);
			Intermed_q2.setBounds((screen_width/2) - 700, (screen_height/2) - 100, 1100, 35);
			frame.add(Intermed_q2);
			
			JLabel Intermed_a2 = new JLabel();
			Intermed_a2.setText("Answer: " + (String) q_op.get(3).get(1));
			Intermed_a2.setFont(f1);
			Intermed_a2.setBounds((screen_width/2) - 700, (screen_height/2) - 50, 800, 35);
			frame.add(Intermed_a2);
			
			JLabel Intermed_user2 = new JLabel();
			Intermed_user2.setText("Your answer was: " + result[1]);
			Intermed_user2.setFont(f1);
			Intermed_user2.setBounds((screen_width/2) - 700, (screen_height/2) + 25, 800, 35);
			frame.add(Intermed_user2);
			
		} else if (Selection == 3) {
			JLabel difficult_q1 = new JLabel();
			difficult_q1.setText("Question 1: " +(String) q.get(4));
			difficult_q1.setFont(f1);
			difficult_q1.setBounds((screen_width/2) - 700, (screen_height/2) - 325, 800, 35);
			frame.add(difficult_q1);
			
			JLabel difficult_a1 = new JLabel();
			difficult_a1.setText("Answer: " + (String) q_op.get(4).get(0));
			difficult_a1.setFont(f1);
			difficult_a1.setBounds((screen_width/2) - 700, (screen_height/2) - 275, 800, 35);
			frame.add(difficult_a1);
			
			JLabel difficult_user1 = new JLabel();
			difficult_user1.setText("Your answer was: " + result[0]);
			difficult_user1.setFont(f1);
			difficult_user1.setBounds((screen_width/2) - 700, (screen_height/2) - 200, 800, 35);
			frame.add(difficult_user1);
			
			JLabel divider = new JLabel();
			divider.setText("---------------------------------------------------------------------------");
			divider.setFont(f1);
			divider.setBounds((screen_width/2) - 700, (screen_height/2) - 150, 800, 35);
			frame.add(divider);
			/////////////////////////////////////////////////////////////////////////////
			JLabel difficult_q2 = new JLabel();
			difficult_q2.setText("Question 2: " +(String) q.get(5));
			difficult_q2.setFont(f1);
			difficult_q2.setBounds((screen_width/2) - 700, (screen_height/2) - 100, 1100, 35);
			frame.add(difficult_q2);
			
			JLabel difficult_a2 = new JLabel();
			difficult_a2.setText("Answer: " + (String) q_op.get(5).get(2));
			difficult_a2.setFont(f1);
			difficult_a2.setBounds((screen_width/2) - 700, (screen_height/2) - 50, 800, 35);
			frame.add(difficult_a2);
			
			JLabel difficult_user2 = new JLabel();
			difficult_user2.setText("Your answer was: " + result[1]);
			difficult_user2.setFont(f1);
			difficult_user2.setBounds((screen_width/2) - 700, (screen_height/2) + 25, 800, 35);
			frame.add(difficult_user2);
		}
	
		JButton rtrn = new JButton("Return");
		rtrn.setBounds((screen_width/2) - 700, (screen_height/2) + 100, 200, 35);
		frame.add(rtrn);
		
		rtrn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.revalidate();
				frame.repaint();
				level_choice(frame, screenSize, q, a, q_op);
				
				

			};

		});
} public static void showresult_random(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, String[] single_result, int question) {
	int screen_width = (int) screenSize.getWidth();
	int screen_height = (int) screenSize.getHeight();
	Font f1 = new Font(Font.SANS_SERIF,  Font.BOLD, 18);
	
	if (question == 1) {
		JLabel easy_q1 = new JLabel();
		easy_q1.setText("Question 1: " +(String) q.get(0));
		easy_q1.setFont(f1);
		easy_q1.setBounds((screen_width/2) - 700, (screen_height/2) - 325, 800, 35);
		frame.add(easy_q1);
		
		JLabel easy_a1 = new JLabel();
		easy_a1.setText("Answer: " + (String) q_op.get(0).get(0));
		easy_a1.setFont(f1);
		easy_a1.setBounds((screen_width/2) - 700, (screen_height/2) - 275, 800, 35);
		frame.add(easy_a1);
		
		JLabel easy_user1 = new JLabel();
		easy_user1.setText("Your answer was: " + single_result[0]);
		easy_user1.setFont(f1);
		easy_user1.setBounds((screen_width/2) - 700, (screen_height/2) - 200, 800, 35);
		frame.add(easy_user1);
	} else if (question == 2) {
		JLabel easy_q2 = new JLabel();
		easy_q2.setText("Question 2: " +(String) q.get(1));
		easy_q2.setFont(f1);
		easy_q2.setBounds((screen_width/2) - 700, (screen_height/2) - 325, 800, 35);
		frame.add(easy_q2);
		
		JLabel easy_a2 = new JLabel();
		easy_a2.setText("Answer: " + (String) q_op.get(1).get(1));
		easy_a2.setFont(f1);
		easy_a2.setBounds((screen_width/2) - 700, (screen_height/2) - 275, 800, 35);
		frame.add(easy_a2);
		
		JLabel easy_user2 = new JLabel();
		easy_user2.setText("Your answer was: " + single_result[0]);
		easy_user2.setFont(f1);
		easy_user2.setBounds((screen_width/2) - 700, (screen_height/2) - 200, 800, 35);
		frame.add(easy_user2);
	} else if (question == 3) {
		JLabel Intermed_q1 = new JLabel();
		Intermed_q1.setText("Question 1: " +(String) q.get(2));
		Intermed_q1.setFont(f1);
		Intermed_q1.setBounds((screen_width/2) - 700, (screen_height/2) - 325, 800, 35);
		frame.add(Intermed_q1);
		
		JLabel Intermed_a1 = new JLabel();
		Intermed_a1.setText("Answer: " + (String) q_op.get(2).get(1));
		Intermed_a1.setFont(f1);
		Intermed_a1.setBounds((screen_width/2) - 700, (screen_height/2) - 275, 800, 35);
		frame.add(Intermed_a1);
		
		JLabel Intermed_user1 = new JLabel();
		Intermed_user1.setText("Your answer was: " + single_result[0]);
		Intermed_user1.setFont(f1);
		Intermed_user1.setBounds((screen_width/2) - 700, (screen_height/2) - 200, 800, 35);
		frame.add(Intermed_user1);
	} else if (question == 4) {
		JLabel Intermed_q2 = new JLabel();
		Intermed_q2.setText("Question 2: " +(String) q.get(3));
		Intermed_q2.setFont(f1);
		Intermed_q2.setBounds((screen_width/2) - 700, (screen_height/2) - 325, 800, 35);
		frame.add(Intermed_q2);
		
		JLabel Intermed_a2 = new JLabel();
		Intermed_a2.setText("Answer: " + (String) q_op.get(3).get(1));
		Intermed_a2.setFont(f1);
		Intermed_a2.setBounds((screen_width/2) - 700, (screen_height/2) - 275, 800, 35);
		frame.add(Intermed_a2);
		
		JLabel Intermed_user2 = new JLabel();
		Intermed_user2.setText("Your answer was: " + single_result[0]);
		Intermed_user2.setFont(f1);
		Intermed_user2.setBounds((screen_width/2) - 700, (screen_height/2) - 200, 800, 35);
		frame.add(Intermed_user2);	
	} else if (question == 5) {
		JLabel difficult_q1 = new JLabel();
		difficult_q1.setText("Question 1: " +(String) q.get(4));
		difficult_q1.setFont(f1);
		difficult_q1.setBounds((screen_width/2) - 700, (screen_height/2) - 325, 800, 35);
		frame.add(difficult_q1);
		
		JLabel difficult_a1 = new JLabel();
		difficult_a1.setText("Answer: " + (String) q_op.get(4).get(0));
		difficult_a1.setFont(f1);
		difficult_a1.setBounds((screen_width/2) - 700, (screen_height/2) - 275, 800, 35);
		frame.add(difficult_a1);
		
		JLabel difficult_user1 = new JLabel();
		difficult_user1.setText("Your answer was: " + single_result[0]);
		difficult_user1.setFont(f1);
		difficult_user1.setBounds((screen_width/2) - 700, (screen_height/2) - 200, 800, 35);
		frame.add(difficult_user1);
	} else if (question == 6) {
		JLabel difficult_q2 = new JLabel();
		difficult_q2.setText("Question 2: " +(String) q.get(5));
		difficult_q2.setFont(f1);
		difficult_q2.setBounds((screen_width/2) - 700, (screen_height/2) - 325, 800, 35);
		frame.add(difficult_q2);
		
		JLabel difficult_a2 = new JLabel();
		difficult_a2.setText("Answer: " + (String) q_op.get(5).get(2));
		difficult_a2.setFont(f1);
		difficult_a2.setBounds((screen_width/2) - 700, (screen_height/2) - 275, 800, 35);
		frame.add(difficult_a2);
		
		JLabel difficult_user2 = new JLabel();
		difficult_user2.setText("Your answer was: " + single_result[0]);
		difficult_user2.setFont(f1);
		difficult_user2.setBounds((screen_width/2) - 700, (screen_height/2) - 200, 800, 35);
		frame.add(difficult_user2);
	}
	JButton rtrn = new JButton("Return");
	rtrn.setBounds((screen_width/2) - 700, (screen_height/2) + 100, 200, 35);
	frame.add(rtrn);
	
	rtrn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().removeAll();
			frame.revalidate();
			frame.repaint();
			modes(frame, screenSize, q, a, q_op);
			
			

		};

	});
	
} public static void showresults_countdown(JFrame frame, Dimension screenSize, ArrayList q, ArrayList a, ArrayList<ArrayList> q_op, String[] all_six_results, Instant startTime) {
	int screen_width = (int) screenSize.getWidth();
	int screen_height = (int) screenSize.getHeight();
	Font f1 = new Font(Font.SANS_SERIF,  Font.BOLD, 18);
	
	Instant endTime = Instant.now();
	Duration timeElapsed = Duration.between(startTime, endTime);
	
	JLabel stopwatch = new JLabel();
	stopwatch.setText("Time taken: " + formatDuration(timeElapsed));
	stopwatch.setFont(f1);
	stopwatch.setBounds((screen_width/2) -100, (screen_height/2) + 200, 225, 25);
	stopwatch.setBackground(Color.magenta);
	stopwatch.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 5));
	frame.add(stopwatch);
	
	JLabel easy_q1 = new JLabel();
	easy_q1.setText("Question 1: " +(String) q.get(0));
	easy_q1.setFont(f1);
	easy_q1.setBounds((screen_width/2) - 700, (screen_height/2) - 325, 800, 35);
	frame.add(easy_q1);
	
	JLabel easy_a1 = new JLabel();
	easy_a1.setText("Answer: " + (String) q_op.get(0).get(0));
	easy_a1.setFont(f1);
	easy_a1.setBounds((screen_width/2) - 700, (screen_height/2) - 275, 800, 35);
	frame.add(easy_a1);
	
	JLabel easy_user1 = new JLabel();
	if ((all_six_results[0].equals("correct")) || (all_six_results[0].equals( "incorrect"))) {
		easy_user1.setText("Your answer was: " + all_six_results[0]);
		
	}else if( all_six_results[0] == null){
		easy_user1.setText("Your answer was: You did not answer this question");
	}
	
	easy_user1.setFont(f1);
	easy_user1.setBounds((screen_width/2) - 700, (screen_height/2) - 200, 800, 35);
	frame.add(easy_user1);
	
	JLabel divider = new JLabel();
	divider.setText("---------------------------------------------------------------------------");
	divider.setFont(f1);
	divider.setBounds((screen_width/2) - 700, (screen_height/2) - 150, 800, 35);
	frame.add(divider);
	/////////////////////////////////////////////////////////////////////////////
	JLabel easy_q2 = new JLabel();
	easy_q2.setText("Question 2: " +(String) q.get(1));
	easy_q2.setFont(f1);
	easy_q2.setBounds((screen_width/2) - 700, (screen_height/2) - 100, 800, 35);
	frame.add(easy_q2);
	
	JLabel easy_a2 = new JLabel();
	easy_a2.setText("Answer: " + (String) q_op.get(1).get(1));
	easy_a2.setFont(f1);
	easy_a2.setBounds((screen_width/2) - 700, (screen_height/2) - 50, 800, 35);
	frame.add(easy_a2);
	
	JLabel easy_user2 = new JLabel();
	if ((all_six_results[1].equals("correct")) || (all_six_results[1].equals( "incorrect"))) {
		easy_user2.setText("Your answer was: " + all_six_results[1]);
		
	}else if( all_six_results[1] == null) {
		easy_user2.setText("Your answer was: You did not answer this question");
	}
	
	easy_user2.setFont(f1);
	easy_user2.setBounds((screen_width/2) - 700, (screen_height/2) + 25, 800, 35);
	frame.add(easy_user2);
	
	JButton next_page = new JButton("Go to next page");
	next_page.setBounds((screen_width/2) - 700, (screen_height/2) + 100, 200, 35);
	frame.add(next_page);
	
	next_page.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().removeAll();
			frame.revalidate();
			frame.repaint();
			
			JLabel Intermed_q1 = new JLabel();
			Intermed_q1.setText("Question 1: " +(String) q.get(2));
			Intermed_q1.setFont(f1);
			Intermed_q1.setBounds((screen_width/2) - 700, (screen_height/2) - 325, 800, 35);
			frame.add(Intermed_q1);
			
			JLabel Intermed_a1 = new JLabel();
			Intermed_a1.setText("Answer: " + (String) q_op.get(2).get(1));
			Intermed_a1.setFont(f1);
			Intermed_a1.setBounds((screen_width/2) - 700, (screen_height/2) - 275, 800, 35);
			frame.add(Intermed_a1);
			
			JLabel Intermed_user1 = new JLabel();
			if ((all_six_results[2].equals("correct")) || (all_six_results[2].equals( "incorrect"))) {
				Intermed_user1.setText("Your answer was: " + all_six_results[2]);
				
			}else if( all_six_results[2] == null) {
				Intermed_user1.setText("Your answer was: You did not answer this question");
			}
			
			Intermed_user1.setFont(f1);
			Intermed_user1.setBounds((screen_width/2) - 700, (screen_height/2) - 200, 800, 35);
			frame.add(Intermed_user1);
			
			JLabel divider = new JLabel();
			divider.setText("---------------------------------------------------------------------------");
			divider.setFont(f1);
			divider.setBounds((screen_width/2) - 700, (screen_height/2) - 150, 800, 35);
			frame.add(divider);
			/////////////////////////////////////////////////////////////////////////////
			JLabel Intermed_q2 = new JLabel();
			Intermed_q2.setText("Question 2: " +(String) q.get(3));
			Intermed_q2.setFont(f1);
			Intermed_q2.setBounds((screen_width/2) - 700, (screen_height/2) - 100, 1100, 35);
			frame.add(Intermed_q2);
			
			JLabel Intermed_a2 = new JLabel();
			Intermed_a2.setText("Answer: " + (String) q_op.get(3).get(1));
			Intermed_a2.setFont(f1);
			Intermed_a2.setBounds((screen_width/2) - 700, (screen_height/2) - 50, 800, 35);
			frame.add(Intermed_a2);
			
			JLabel Intermed_user2 = new JLabel();
			if ((all_six_results[3].equals("correct")) || (all_six_results[3].equals( "incorrect"))) {
				Intermed_user2.setText("Your answer was: " + all_six_results[3]);
				
			}else if( all_six_results[3] == null) {
				Intermed_user2.setText("Your answer was: You did not answer this question");
			}
			Intermed_user2.setFont(f1);
			Intermed_user2.setBounds((screen_width/2) - 700, (screen_height/2) + 25, 800, 35);
			frame.add(Intermed_user2);
			
			JButton next_page2 = new JButton("Go to next Page");
			next_page2.setBounds((screen_width/2) - 700, (screen_height/2) + 100, 200, 35);
			frame.add(next_page2);
			
			next_page2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.revalidate();
					frame.repaint();
					
					JLabel difficult_q1 = new JLabel();
					difficult_q1.setText("Question 1: " +(String) q.get(4));
					difficult_q1.setFont(f1);
					difficult_q1.setBounds((screen_width/2) - 700, (screen_height/2) - 325, 800, 35);
					frame.add(difficult_q1);
					
					JLabel difficult_a1 = new JLabel();
					difficult_a1.setText("Answer: " + (String) q_op.get(4).get(0));
					difficult_a1.setFont(f1);
					difficult_a1.setBounds((screen_width/2) - 700, (screen_height/2) - 275, 800, 35);
					frame.add(difficult_a1);
					
					JLabel difficult_user1 = new JLabel();
					if ((all_six_results[4].equals("correct")) || (all_six_results[4].equals( "incorrect"))) {
						difficult_user1.setText("Your answer was: " + all_six_results[4]);
						
					}else if( all_six_results[4] == null) {
						difficult_user1.setText("Your answer was: You did not answer this question");
					}
					difficult_user1.setFont(f1);
					difficult_user1.setBounds((screen_width/2) - 700, (screen_height/2) - 200, 800, 35);
					frame.add(difficult_user1);
					
					JLabel divider = new JLabel();
					divider.setText("---------------------------------------------------------------------------");
					divider.setFont(f1);
					divider.setBounds((screen_width/2) - 700, (screen_height/2) - 150, 800, 35);
					frame.add(divider);
					/////////////////////////////////////////////////////////////////////////////
					JLabel difficult_q2 = new JLabel();
					difficult_q2.setText("Question 2: " +(String) q.get(5));
					difficult_q2.setFont(f1);
					difficult_q2.setBounds((screen_width/2) - 700, (screen_height/2) - 100, 1100, 35);
					frame.add(difficult_q2);
					
					JLabel difficult_a2 = new JLabel();
					difficult_a2.setText("Answer: " + (String) q_op.get(5).get(2));
					difficult_a2.setFont(f1);
					difficult_a2.setBounds((screen_width/2) - 700, (screen_height/2) - 50, 800, 35);
					frame.add(difficult_a2);
					
					JLabel difficult_user2 = new JLabel();
					if ((all_six_results[5].equals("correct")) || (all_six_results[5].equals( "incorrect"))) {
						difficult_user2.setText("Your answer was: " + all_six_results[5]);
						
					}else if( all_six_results[5] == null) {
						difficult_user2.setText("Your answer was: You did not answer this question");
					}
					difficult_user2.setFont(f1);
					difficult_user2.setBounds((screen_width/2) - 700, (screen_height/2) + 25, 800, 35);
					frame.add(difficult_user2);
					
					JButton rtrn = new JButton("Return");
					rtrn.setBounds((screen_width/2) - 700, (screen_height/2) + 100, 200, 35);
					frame.add(rtrn);
					
					rtrn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frame.getContentPane().removeAll();
							frame.revalidate();
							frame.repaint();
							modes(frame, screenSize, q, a, q_op);
							
							

						};

					});

				};

			});

		};

	});
	
} public static String formatDuration(Duration duration) {
    long hours = duration.toHours();
    long minutes = duration.minusHours(hours).toMinutes();
    long seconds = duration.minusHours(hours).minusMinutes(minutes).getSeconds();
    long milliseconds = duration.minusHours(hours).minusMinutes(minutes).minusSeconds(seconds).toMillis();

    return String.format("%d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
}
}
	