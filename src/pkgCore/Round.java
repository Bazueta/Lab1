package pkgCore;

import java.util.LinkedList;

public class Round {

	private int ComeOutScore;
	private eGameResult eGameResult;
	private LinkedList<Roll> rolls = new LinkedList<Roll>();

	public Round() {
		Roll comeOutRoll = new Roll();
		ComeOutScore = comeOutRoll.getScore();
		rolls.add(comeOutRoll);
		// TODO: Execute Come Out roll, value ComeOutScore

		// TODO: Create a loop that will execute a roll until point is made, or
		// seven-out
		if(ComeOutScore == 7 || ComeOutScore == 11)
		{
			this.eGameResult = eGameResult.NATURAL;
		}
		else if(ComeOutScore == 2 || ComeOutScore == 3 || ComeOutScore == 12)
		{
			this.eGameResult = eGameResult.CRAPS;
		}
		else
		{
			Roll newRoll;
			boolean b = false;
			while(b == false)
			{
				newRoll = new Roll();
				rolls.add(newRoll);
				if(newRoll.getScore() == 7)
				{
					eGameResult = eGameResult.SEVEN_OUT;
					b = true;
				}
				else if(newRoll.getScore() == ComeOutScore)
				{
					eGameResult = eGameResult.POINT;
					b = true;
				}
			}
		}
	}

	public int RollCount() {
		// Return the roll count
		return rolls.size();
	}
	public String printRolls()
	{
		String strRolls = new String();
		for(Roll r : rolls)
		{
			strRolls = strRolls + r.getScore() + ' ';
		}
		return strRolls;
	}
	public int getInitialScore()
	{
		return rolls.getFirst().getScore();
	}
	public int getLastScore()
	{
		return rolls.getLast().getScore();
	}
	public eGameResult geteGameResult()
	{
		return this.eGameResult;
	}
}
