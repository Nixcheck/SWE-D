package Lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Lotttery {

	private RandomNumberGenerator randomNumGen;
	private List<Player> allPlayers = new ArrayList<Player>();

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

	public void clearLottery() {
		allPlayers.clear();
	}

	public void printResult() {
		String tmp = "";
		for (Player player : allPlayers) {
			player.calculateHits(randomNumGen);
			tmp += player.toString();
		}
		System.out.println("\n" + randomNumGen.toString() + "\n" + tmp);
	}
}