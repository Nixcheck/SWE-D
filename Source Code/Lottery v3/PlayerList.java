package Lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerList extends ArrayList<Player> {

	private List<Player> winners;
	private List<Player> losers;

	public PlayerList() {
		winners = new ArrayList<Player>();
		losers = new ArrayList<Player>();
	}

	public boolean hasLoser() {
		if (losers.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean hasWinner() {
		if (winners.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean hasHonorable() {
		if (this.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void sorter(RandomNumberGenerator randomNumGen) {
		for (Player player : this) {
			player.calculateHits(randomNumGen);
		}
		Collections.sort(this);
		calcWinners();
		calcLosers();
	}

	private void calcWinners() {
		int size = this.get(0).getNumOfHits().size();
		for (int i = 0; i < this.size(); i++) {
			Player player = this.get(i);
			if (size != player.getNumOfHits().size() || size == 0) {
				break;
			}
			winners.add(player);
			this.remove(i);
			i--;
		}
	}

	private void calcLosers() {
		for (int i = this.size() - 1; i >= 0; i--) {
			Player tmp = this.get(i);
			if (tmp.getNumOfHits().size() != 0) {
				break;
			}
			losers.add(tmp);
			this.remove(i);
			i = this.size();
		}
	}

	public String toWinnerString() {
		String tmp = "";
		for (Player player : winners) {
			tmp += player.toString();
		}
		return tmp;
	}

	public String toLoserString() {
		String tmp = "";
		for (Player player : losers) {
			tmp += player.toString();
		}
		return tmp;
	}

	public String toRestString() {
		String tmp = "";
		for (Player player : this) {
			tmp += player.toString();
		}
		return tmp;
	}

	@Override
	public void clear() {
		super.clear();
		winners.clear();
		losers.clear();
	}
}
