import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Computer {

	private static final int BOARD_SIZE = 8;
	private List<Pair<Piece, Piece>> moveSet;
	private Piece liftedPiece;
	private Piece newPiece;
	
	public Computer(List<List<Piece>> board)
	{
		moveSet = new ArrayList<Pair<Piece, Piece>>();
		Pair<Piece, Piece> bothPieces = valueIteration(board, 20, 1);
		liftedPiece = bothPieces.getKey();
		newPiece = bothPieces.getValue();
	}
	
	public Pair<Piece, Piece> valueIteration(List<List<Piece>> board, int lookup, int turnCount)
	{
		/*if(turnCount <= 1)
			Board.getInstance().movePiece(
			Board.getInstance().getPiece(1, 4), 
			Board.getInstance().getPiece(2, 4),
			false, "", Color.black);
		for(int i = 0; i < lookup; i++)
		{
			;
		}*/
		
		for(int i = 0; i < BOARD_SIZE; i++)
			for(int j = 0; j < BOARD_SIZE; j++)
				if(board.get(i).get(j).getForeground().equals(Color.black) &&
				  !board.get(i).get(j).getActionCommand().equals(""))
					for(int k = 0; k < BOARD_SIZE; k++)
						for(int l = 0; l < BOARD_SIZE; l++)
							if(MovePiece.validMove(board.get(i).get(j), board.get(k).get(l)))
								moveSet.add(new Pair<Piece, Piece>(board.get(i).get(j), board.get(k).get(l)));
		
		int rand = (int)Math.floor(Math.random() * moveSet.size());
		
		return moveSet.get(rand);
	}
	
	public Piece getLifted()
	{
		return liftedPiece;
	}
	
	public Piece getNew()
	{
		return newPiece;
	}
}
