package exe3;

import java.util.Scanner;

public class Lottery {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int eingabe;
		String[] nameOfPlayers;
		int[][] lotteryNumbers = null;
		int[] lottery = null;
		int zaehler = 0, lottoCount = 0, numberOfPlayers = 0;

		while (true) {

			System.out
					.println("=== Lottery Menu ===\n 1 Enter ticket \n 2 Lottery drawing\n 3 Show result\n 0 Quit\n Please enter (0-3): _");

			eingabe = sc.nextInt();

			switch (eingabe) {

			case 1:

				nameOfPlayers = new String[100];
				lotteryNumbers = new int[100][6];
				System.out.println("Please enter the Number of Players!");
				numberOfPlayers = sc.nextInt();

				while (numberOfPlayers > 0) {
					numberOfPlayers--;
					System.out
							.println("Player please enter your name then 6 numbers!");

					sc.nextLine();

					nameOfPlayers[zaehler] = sc.nextLine();

					for (int j = 0; j < 6; j++) {
						lotteryNumbers[zaehler][j] = sc.nextInt();
					}
					zaehler++;

					System.out.println("Very Good!");

				}

				break;

			case 2:

				lottery = new int[6];

				for (int i = 0; i < 6; i++) {
					double value = (Math.random() * 100 % 48) + 1;
					lottery[i] = (int) value;
				}

				break;

			case 3:

				for (int i = 0; i < zaehler; i++) {
					System.out.print("Player #" + i + " Numbers: ");
					ausgabe(lotteryNumbers[i]);
					lottoCount = 0;
					for (int j = 0; j < 6; j++) {

						if (lotteryNumbers[i][j] == lottery[j]) {
							System.out.println("This Number was correct: "
									+ lottery[j]);
							lottoCount++;
						}
					}
					if (lottoCount == 6) {
						System.out.println("LOTTO!!!!!");
					} else {
						System.out.println(lottoCount + " Right Numbers!");
					}
				}

				System.out.print("The Lotto Numbers: ");
				ausgabe(lottery);
				break;

			default:
				System.out.println("Wrong Input Try again");
				break;
			}

		}

	}

	private static void ausgabe(int[] is) {

		for (int i = 0; i < is.length; i++) {
			System.out.print(is[i] + " ");
		}
		System.out.println("");
	}
}
