package EPIC;

import java.util.Scanner;
import java.time.Instant;
import java.time.Duration;
import java.util.Random;
import java.util.ArrayList;

public class computerOrganisation {
	public static void main(String[] args) {
		ArrayList<String> q = new ArrayList<String>();
		q.add("What is the name of the most powerful Supercomputer in the world?\n a: Kay\n b: Cray\n c: Frontier\n d: Titan\n");
		q.add("What is the name of the third level of the ‘Contemporary Multilevel Machine’?\n a: Operating system machine level\n b:Assembly language level\n c: Microarchitecture level\n d: Instruction set architecture level");
		q.add("What does ALU stand for?\n a: Arithmetic Level Unit\n b: Arithmetic Logic Unit\n c: Assisted Level User\n d: Ancient Law User\n");
		q.add("Which three levels of the 'Contemporary Multilevel Machine' are numeric?\n a: 0,1,2\n b: 1,2,3\n c: 2,3,4\n d: 3,4,5\n");
		q.add("True or False: 'Translation is when each line of code must be examined and decoded before being executed'\n a: True\n b: False");
		q.add("What is the octal equivalent of the hexadecimal 3EC?\n a: 1354\n b: 2376\n c: 9878\n d: 9967\n");
		q.add("What is the hexadecimal equivalent of the octal 56?\n a: 4f \n b: 9a \n c: 2e \n d: 8c\n");

		ArrayList<String> a = new ArrayList<String>();
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("b");
		a.add("b");
		a.add("a");
		a.add("c");

		Scanner input = new Scanner(System.in);
		System.out.println(
				"Please enter '0' for 'Timed Random Mode',\n '1' for 'Increasing Difficulty Mode'\n or '2' for 'Survival Mode': ");
		int mode = input.nextInt();

		if (mode == 0) {
			timedRandomMode(q, a);
		} else if (mode == 1) {
			increasingDifficultyMode(q, a);
		} else if (mode == 2) {
			survivalMode(q, a);
		} else {
			System.out.println("Invalid output");
		}
		input.close();

	}

	public static void timedRandomMode(ArrayList q, ArrayList a) {
		Scanner scanner = new Scanner(System.in);
		System.out
				.print("You must answer 4 random questions in as little time as possible. Would you like to proceed? ");
		String proceed = (scanner.nextLine()).toLowerCase();

		if (proceed.equals("yes")) {
			ArrayList<Integer> used = new ArrayList<Integer>();
			int counter = 0;
			boolean timeOn = true;
			Instant st = Instant.now();

			while (timeOn) {
				for (int i = 0; i < 4; i++) {
					Random random = new Random();
					int randq = (int) (Math.random() * q.size());
					if (!used.contains(randq)) {
						System.out.println(q.get(randq));
						String answer = scanner.nextLine();
						used.add(randq);
						if (answer.equals(a.get(randq))) {
							counter++;
						}
					} else {
						i--;
					}
				}
				timeOn = false;

			}
			Instant et = Instant.now();
			Duration time_spent = Duration.between(st, et);
			System.out.println("You answered " + counter + " out of 4 questions right within the time of: "
					+ timeFormat(time_spent));
		}
		scanner.close();

	}

	public static void increasingDifficultyMode(ArrayList q, ArrayList a) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"You will be asked 2 questions at 3 different levels of difficulty. would you like to proceed: ");
		String proceed = (scanner.nextLine()).toLowerCase();

		if (proceed.equals("yes")) {
			int counter = 0;
			System.out.println("Level 1: beginners");
			for (int i = 0; i < 6; i++) {
				if (i == 2) {
					System.out.println("Level 2: intermediate");
				}
				if (i == 4) {
					System.out.println("Level 3: Expert");
				}
				System.out.println(q.get(i));
				String answer = scanner.nextLine();
				if (answer.equals(a.get(i))) {
					counter++;
				}
			}
			System.out.println("You answered " + counter + " out of 6 questions right!");
		} scanner.close();

	}

	public static void survivalMode(ArrayList q, ArrayList a) {
	int lives = 2;
	int counter = 0;
	int qsAns = 0;
	Scanner scanner = new Scanner(System.in);
	System.out.println("You will be asked a max of 6 questions. if you get 2 wrong, the quiz stops. Would you like to proceed: ");
	String proceed = (scanner.nextLine()).toLowerCase();
	
	if (proceed.equals("yes")){
		ArrayList<Integer> used = new ArrayList<Integer>();
		while (lives > 0) {
			for (int i = 0; i < 6; i++) {
				int randq = (int)(Math.random() * q.size());
				if (!used.contains(randq)) {
					used.add(randq);
					System.out.println(q.get(randq));
					String answer = scanner.nextLine();
					if (answer.equals(a.get(randq))){
						counter++;
						qsAns ++;
						System.out.println("You have "+ lives + " lives/life left.\n");
						
					} else {
						lives --;
						System.out.println("You have "+ lives + " lives/life left.\n");
						qsAns++;
					}
				}
			}
		} System.out.println("GAME OVER! You answered " + counter + " out of " + qsAns + " questions right");
		
	}

	}

	public static String timeFormat(Duration t) {
		long minutes = t.toMinutes();
		long seconds = t.minusMinutes(minutes).getSeconds();
		long milliseconds = t.minusMinutes(minutes).minusSeconds(seconds).toMillis();
		return String.format("%02d: %02d: %03dms", minutes, seconds, milliseconds);
	}
}
