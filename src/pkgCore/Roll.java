package pkgCore;

import pkgCore.Die;
import pkgCore.Roll;

public class Roll {

	private Die d1;
	private Die d2;
	private int Score;

	public Roll() {
		// TODO: Create an instance of d1 and d2...
		// TODO: Determine 'Score'
		d1 = new Die();
		d2 = new Die();
		Score = d1.getDieValue() + d2.getDieValue();
	}

	public int getScore() {
		return Score;
	}
	public static void main(String [] args)
	{
		Roll r = new Roll();
		System.out.print(r.getScore());
	}
}
