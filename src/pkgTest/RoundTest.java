package pkgTest;

import static org.junit.Assert.*;
import org.junit.Test;
import pkgCore.Round;
import pkgCore.eGameResult;

public class RoundTest 
{
	@Test
	public void test()
	{
		for(int i=0; i<10000; i++)
		{
			Round addRound = new Round();
			System.out.println(addRound.printRolls());
			
			if((addRound.RollCount() == 1) && ((addRound.getInitialScore() == 7) || (addRound.getInitialScore() == 11)))
			{
				assertEquals(eGameResult.NATURAL, addRound.geteGameResult());
			}
			if((addRound.RollCount() == 1) && ((addRound.getInitialScore() == 2) || (addRound.getInitialScore() == 3) || (addRound.getInitialScore() == 12)))
			{
				assertEquals(eGameResult.CRAPS, addRound.geteGameResult());
			}
			if((addRound.RollCount() >= 2) && (addRound.getInitialScore() == addRound.getLastScore()))
			{
				assertEquals(eGameResult.POINT, addRound.geteGameResult());
			}
			if((addRound.RollCount() >= 2) && (addRound.getLastScore() == 7))
			{
				assertEquals(eGameResult.SEVEN_OUT, addRound.geteGameResult());
			}
		}
	}
}