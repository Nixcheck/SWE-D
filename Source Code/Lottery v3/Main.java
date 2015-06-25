package Lottery;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean quit = true, lockNumbers = false;
		Lotttery lottery = new Lotttery();

		while (quit) {
			prompt();
			switch (input.nextInt()) {
			case 0:
				quit = false;
				break;
			case 1:
				if (lockNumbers) {
					System.out
							.println("\n!!! Please Proceed to \"Show Results\". Lottery is currently running !!!\n");
				} else {
					lottery.addPlayer(input);
					System.out.println("\nPlayer Added.\n");
				}
				break;
			case 2:
				if (lockNumbers) {
					System.out
							.println("\n!!! Please Proceed to \"Show Results\". Numbers were alredy Drawn !!!\n");
				} else {
					lottery.generateNumbers();
					lockNumbers = true;
					System.out.println(lottery.getRandomNumGen().toString());
				}
				break;
			case 3:
				if (lockNumbers) {
					lottery.printResult();
					lottery.getAllPlayers().clear();
					lockNumbers = false;
				} else {
					System.out.println("\n!!! There was no draw !!!\n");
				}
				break;
			default:
				System.out.println("\n!!! - Wrong input try again - !!!\n");
				break;
			}
		}
		System.out.println("Lottery-Program terminated");
		input.close();
	}

	private static void prompt() {
		System.out
				.print("=== Lottery Menu ===\n1 Enter ticket\n2 Lottery drawing\n3 Show result\n0 Quit\nPlease enter (0-3): ");
	}
}