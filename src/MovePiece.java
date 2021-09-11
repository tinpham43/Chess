import java.awt.Color;

public class MovePiece {

	private static MovePiece instance = null;
	private Piece piece;
	
	private MovePiece() {
		piece = new Piece();
	}

	public static MovePiece getInstance() {
		if(instance == null)
			instance = new MovePiece();
		
		return instance;
	}
	
	public void setPiece(Piece newPiece) {
		piece = newPiece;
	}
	
	public boolean validMove(Piece newPiece) {
		boolean ret = false;
		
		switch(piece.getActionCommand())
		{
			case "p":
				ret = movePawn(newPiece);
				break;
			case "R":
				moveRook(newPiece);
				break;
			case "H":
				moveKnight(newPiece);
				break;
			case "B":
				moveBishop(newPiece);
				break;
			case "Q":
				moveQueen(newPiece);
				break;
			case "K":
				moveKing(newPiece);
				break;
			default:
				break;
		}
		
		return ret;
	}
	
	private boolean movePawn(Piece newPiece) {
		String firstPiece = Board.getInstance().getPiece(newPiece.getXPiece(), newPiece.getYPiece() - 1);
		String secondPiece = Board.getInstance().getPiece(newPiece.getXPiece(), newPiece.getYPiece() - 2);
		int yDistance = Math.abs(newPiece.getYPiece() - piece.getYPiece());
		
		if(piece.getForeground().equals(Color.white) &&
		   piece.getXPiece() == newPiece.getXPiece())
		{
		   if((yDistance == 1 &&
			  (firstPiece.equals("") || (!firstPiece.equals("") && 
			   newPiece.getForeground() == Color.black))) ||
			  (yDistance == 2 &&
			  (secondPiece.equals("") || (!secondPiece.equals("") && 
			   newPiece.getForeground() == Color.black))))
			   return true;
		}
		else if(piece.getForeground().equals(Color.black) &&
				piece.getXPiece() == newPiece.getXPiece())
		{
		   if((yDistance == 1 &&
			  (firstPiece.equals("") || (!firstPiece.equals("") && 
			   newPiece.getForeground() == Color.white))) ||
			  (yDistance == 2 &&
			  (secondPiece.equals("") || (!secondPiece.equals("") && 
			   newPiece.getForeground() == Color.white))))
			   return true;
		}
		
		return false;
	}
	
	public void moveRook(Piece newPiece) {
			
	}
	
	public void moveKnight(Piece newPiece) {
		
	}
	
	public void moveBishop(Piece newPiece) {
		
	}
	
	public void moveQueen(Piece newPiece) {
		
	}
	
	public void moveKing(Piece newPiece) {
		
	}
}
