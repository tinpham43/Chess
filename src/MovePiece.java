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
				ret = moveRook(newPiece);
				break;
			case "H":
				ret = moveKnight(newPiece);
				break;
			case "B":
				ret = moveBishop(newPiece);
				break;
			case "Q":
				ret = moveQueen(newPiece);
				break;
			case "K":
				ret = moveKing(newPiece);
				break;
			default:
				break;
		}
		
		return ret;
	}

	private boolean movePawn(Piece newPiece) {
		
		int yDistance = newPiece.getXPiece() - piece.getXPiece();

		if(piece.getForeground().equals(Color.white) &&
		   piece.getYPiece() == newPiece.getYPiece())
		{
			String firstPiece = Board.getInstance().getPiece(piece.getXPiece() - 1, piece.getYPiece());
			
		    if((yDistance == -1 && !firstPiece.equals("OOB") &&
			  (newPiece.getActionCommand().equals(""))) ||
			  (yDistance == -2 && firstPiece.equals("") &&
			  (newPiece.getActionCommand().equals(""))))
			   return true;
		}
		else if(piece.getForeground().equals(Color.white) &&
				piece.getYPiece() + 1 == newPiece.getYPiece() ||
				piece.getYPiece() - 1 == newPiece.getYPiece())
		{
			if((yDistance == -1 && !newPiece.getActionCommand().equals("") &&
			  (newPiece.getForeground().equals(Color.black))))
			   return true;
		}
		else if(piece.getForeground().equals(Color.black) &&
				piece.getYPiece() == newPiece.getYPiece())
		{
			String firstPiece = Board.getInstance().getPiece(piece.getXPiece() + 1, piece.getYPiece());
			
		    if((yDistance == 1 && !firstPiece.equals("OOB") &&
		      (newPiece.getActionCommand().equals(""))) ||
			  (yDistance == 2 && firstPiece.equals("") &&
			  (newPiece.getActionCommand().equals(""))))
			   return true;
		}
		else if(piece.getForeground().equals(Color.black) &&
				piece.getYPiece() + 1 == newPiece.getYPiece() ||
				piece.getYPiece() - 1 == newPiece.getYPiece())
		{
			if((yDistance == 1 && !newPiece.getActionCommand().equals("") &&
		      (newPiece.getForeground().equals(Color.white))))
			   return true;
		}
		
		return false;
	}
	
	private boolean moveRook(Piece newPiece) {
		int xDistance = newPiece.getYPiece() - piece.getYPiece();
		int yDistance = newPiece.getXPiece() - piece.getXPiece();

		if(xDistance == 0 && (newPiece.getActionCommand().equals("") ||
		  !newPiece.getForeground().equals(piece.getForeground())))
		{
			int negative = yDistance < 0 ? -1 : 1;

			for(int i = 1; i <= (Math.abs(yDistance) - 1); i++)
			{
				if(!Board.getInstance().getPiece(piece.getXPiece() + (i * negative), piece.getYPiece()).equals(""))
					return false;
			}

			return true;
		}
		else if(yDistance == 0 && (newPiece.getActionCommand().equals("") ||
			   !newPiece.getForeground().equals(piece.getForeground())))
		{
			int negative = xDistance < 0 ? -1 : 1;
			
			for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
			{
				if(!Board.getInstance().getPiece(piece.getXPiece(), piece.getYPiece() + (i * negative)).equals(""))
					return false;
			}
			
			return true;
		}
		
		return false;
	}
	
	private boolean moveKnight(Piece newPiece) {
		return true;
	}
	
	private boolean moveBishop(Piece newPiece) {
		return true;
	}
	
	private boolean moveQueen(Piece newPiece) {
		return true;
	}
	
	private boolean moveKing(Piece newPiece) {
		return true;
	}
}
