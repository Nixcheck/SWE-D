package Lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player implements Comparable<Player> {

	private String name;
	private Ticket ticket;
	private List<Integer> numOfHits;

	public Player(Scanner input) {
		input.nextLine();
		System.out.print("Player Name: ");
		this.name = input.nextLine();
		ticket = new Ticket(input);
		numOfHits = new ArrayList<Integer>();
	}

	public Player(Player player) {
		name = player.getName();
		ticket = player.getTicket();
		numOfHits = player.getNumOfHits();
	}

	public String getName() {
		return name;
	}

	public List<Integer> getNumOfHits() {
		return numOfHits;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void calculateHits(RandomNumberGenerator rng) {
		int tmpRNG[] = rng.getDrawnNumbers();
		int tmpDrawnNum[] = ticket.getTicketNumbers();
		for (int i = 0; i < tmpDrawnNum.length; i++) {
			for (int j = 0; j < tmpRNG.length; j++) {
				if (tmpDrawnNum[i] < tmpRNG[j]) {
					break;
				} else if (tmpDrawnNum[i] == tmpRNG[j]) {
					numOfHits.add(tmpRNG[j]);
				}
			}
		}
	}

	@Override
	public String toString() {
		if (numOfHits.size() == 6) {
			return "Player Name: " + name + "\n" + ticket.toString()
					+ "Hits: JACKPOT !!!  <<<\n";
		} else {
			String tmp = new String();
			for (Integer integer : numOfHits) {
				tmp += " - " + integer;
			}
			tmp += " -\n\n";
			return "Player Name: " + name + "\n" + ticket.toString()
					+ "Hit Count: " + numOfHits.size() + "\n" + "Hits: " + tmp;
		}
	}

	@Override
	public int compareTo(Player o) {
		return Integer.compare(o.getNumOfHits().size(), numOfHits.size());
	}
}