import java.awt.Color;

public class Computer {

	public static void valueIteration(int lookup, int turnCount)
	{
		if(turnCount <= 1)
			Board.getInstance().movePiece(
					Board.getInstance().getPiece(1, 4), 
					Board.getInstance().getPiece(2, 4),
					false, "", Color.black);
		for(int i = 0; i < lookup; i++)
		{
			;
		}
	}
}
