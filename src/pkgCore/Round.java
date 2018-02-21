package pkgCore;

import java.util.LinkedList;

public class Round {

	private int ComeOutScore;
	private eGameResult eGameResult;
	private int RollCount;
	private LinkedList<Roll> rolls = new LinkedList<Roll>();

	public Round() {
		ComeOutScore = new Roll().getScore();
		RollCount = 1;
		// TODO: Execute Come Out roll, value ComeOutScore

		// TODO: Create a loop that will execute a roll until point is made, or
		// seven-out
		if( 4 <= ComeOutScore && ComeOutScore <= 10 && ComeOutScore != 7)
		{
			Roll temp = new Roll();
			RollCount++;
			while(true)
			{
				if(temp.getScore() == 7) 
				{
					eGameResult = eGameResult.SEVEN_OUT;
					break;
				}
				if(temp.getScore() == ComeOutScore)
				{
					eGameResult = eGameResult.POINT;
					break;
				}
				temp = new Roll();
				RollCount++;
			}
		}
		else {
			if(ComeOutScore == 7 || ComeOutScore == 11)
				eGameResult = eGameResult.NATURAL;
			else eGameResult = eGameResult.CRAPS;
		}

		// TODO: value the eGameResult after the round is complete
	}

	public int RollCount() {
		// Return the roll count
		return RollCount;
	}
	public static void main(String [] args)
	{
		Round round = new Round();
		System.out.print(round.RollCount());
	}
}
