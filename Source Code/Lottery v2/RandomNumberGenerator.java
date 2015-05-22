package Lottery;

import java.util.Arrays;

public class RandomNumberGenerator {
	private final int DRAWNNUMBERSIZE = 6;
	private int drawnNumbers[];

	public RandomNumberGenerator() {
		this.drawnNumbers = new int[DRAWNNUMBERSIZE];
	}

	public void newNumbers() {
		drawnNumbers = new int[DRAWNNUMBERSIZE];
		for (int i = 0; i < drawnNumbers.length; i++) {
			drawnNumbers[i] = (int) ((Math.random() * 49) + 1);
			for (int j = i - 1; j >= 0; j--) {
				if (drawnNumbers[i] == drawnNumbers[j]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(drawnNumbers);
	}

	public int[] getDrawnNumbers() {
		return drawnNumbers;
	}

	@Override
	public String toString() {
		String tmp = "Drawn Numbers";
		for (int i = 0; i < drawnNumbers.length; i++) {
			tmp += String.format(" - %2d", drawnNumbers[i]);
		}
		return tmp + " -\n";
	}
}