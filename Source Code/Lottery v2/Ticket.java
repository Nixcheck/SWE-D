package Lottery;

import java.util.Arrays;
import java.util.Scanner;

public class Ticket {
	private final int TICKETSIZE = 6;
	private int ticketNumbers[];

	public Ticket(Scanner input) {
		this.ticketNumbers = new int[TICKETSIZE];
		for (int i = 0; i < ticketNumbers.length; i++) {
			System.out.print("Number " + (i + 1) + " > ");
			ticketNumbers[i] = input.nextInt();
			if (ticketNumbers[i] < 1 || ticketNumbers[i] > 49) {
				i--;
				System.out.println("Number has to be > 0 and < 50.");
				continue;
			}
			for (int j = i - 1; j >= 0; j--) {
				if (ticketNumbers[i] == ticketNumbers[j]) {
					i--;
					System.out.println("Number " + ticketNumbers[j]
							+ " already typed in.");
					break;
				}
			}
		}
		Arrays.sort(ticketNumbers);
	}

	public int[] getTicketNumbers() {
		return ticketNumbers;
	}

	@Override
	public String toString() {
		String tmp = "Ticket ";
		for (int i = 0; i < ticketNumbers.length; i++) {
			tmp += String.format(" - %2d", ticketNumbers[i]);
		}
		return tmp + " -\n";
	}

}