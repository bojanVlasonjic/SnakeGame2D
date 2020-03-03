package auxiliary;

import java.util.Comparator;

import model.HighScore;

public class HighScoreSorter implements Comparator<HighScore> {

	@Override
	public int compare(HighScore hs1, HighScore hs2) {
		
		return hs1.getScore().compareTo(hs2.getScore()) * -1;
	}

}
