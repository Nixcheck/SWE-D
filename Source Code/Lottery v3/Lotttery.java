package Lottery;

import java.util.Scanner;

public class Lotttery {

	private RandomNumberGenerator randomNumGen;
	private PlayerList allPlayers = new PlayerList();

	public RandomNumberGenerator getRandomNumGen() {
		return randomNumGen;
	}

	public Lotttery() {
		randomNumGen = new RandomNumberGenerator();
	}

	public void generateNumbers() {
		randomNumGen.newNumbers();
	}

	public void addPlayer(Scanner input) {
		allPlayers.add(new Player(input));
	}

	public PlayerList getAllPlayers() {
		return allPlayers;
	}

	public void printResult() {
		allPlayers.sorter(randomNumGen);
		System.out.println("\nAnd the winner/s is/are :\n");
		if (allPlayers.hasWinner()) {
			System.out.println(allPlayers.toWinnerString());
		} else {
			System.out.println("- none -\n");
		}
		System.out.println("Honorable Mentions :\n");
		if (allPlayers.hasHonorable()) {
			System.out.println(allPlayers.toRestString());
		} else {
			System.out.println("- none -\n");
		}
		System.out
				.println("and now moment you all have been waiting for ...\n THE LOSERS ! :\n");
		if (allPlayers.hasLoser()) {
			try {
				System.out.print("Wait for it .");
				Thread.sleep(4000L);
				System.out.print(".");
				Thread.sleep(4000L);
				System.out.println(".");
				Thread.sleep(1000L);	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(allPlayers.toLoserString());
		} else {
			System.out.println("- none -\n");
		}
	}
}