package Lottery;

import java.util.Scanner;

public class Player {

	private String name;
	private Ticket ticket;
	private int numOfHits;

	public Player(Scanner input) {
		input.nextLine();
		System.out.print("Player Name: ");
		this.name = input.nextLine();
		ticket = new Ticket(input);
		numOfHits = 0;
	}

	public void calculateHits(RandomNumberGenerator rng) {
		int tmpRNG[] = rng.getDrawnNumbers();
		int tmpDrawnNum[] = ticket.getTicketNumbers();
		for (int i = 0; i < tmpDrawnNum.length; i++) {
			for (int j = 0; j < tmpRNG.length; j++) {
				if (tmpDrawnNum[i] < tmpRNG[j]) {
					break;
				} else if (tmpDrawnNum[i] == tmpRNG[j]) {
					numOfHits++;
				}
			}
		}
	}

	@Override
	public String toString() {
		if (numOfHits == 6) {
			return "Player Name: " + name + "\n" + ticket.toString()
					+ "Hits: JACKPOT !!!  <<<\n";
		} else {
			return "Player Name: " + name + "\n" + ticket.toString() + "Hits: "
					+ numOfHits + "\n";
		}

	}
}