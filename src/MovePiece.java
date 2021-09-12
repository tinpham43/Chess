import java.awt.Color;

public class MovePiece {

	private static MovePiece instance = null;
	
	private MovePiece() {

	}

	public static MovePiece getInstance() {
		if(instance == null)
			instance = new MovePiece();
		
		return instance;
	}

	public boolean validMove(Piece piece, Piece newPiece) {
		boolean ret = false;

		switch(piece.getActionCommand())
		{
			case "p":
				ret = movePawn(piece, newPiece);
				break;
			case "R":
				ret = moveRook(piece, newPiece);
				break;
			case "H":
				ret = moveKnight(piece, newPiece);
				break;
			case "B":
				ret = moveBishop(piece, newPiece);
				break;
			case "Q":
				ret = moveQueen(piece, newPiece);
				break;
			case "K":
				ret = moveKing(piece, newPiece);
				break;
			default:
				break;
		}
		
		return ret;
	}

	private boolean movePawn(Piece piece, Piece newPiece) {
		
		int yDistance = newPiece.getXPiece() - piece.getXPiece();

		if(piece.getForeground().equals(Color.white) &&
		   piece.getYPiece() == newPiece.getYPiece())
		{
			String firstPiece = Board.getInstance().getPiece(piece.getXPiece() - 1, piece.getYPiece());
			
		    if((yDistance == -1 && !firstPiece.equals("OOB") &&
			  newPiece.getActionCommand().equals("")) ||
			  (yDistance == -2 && firstPiece.equals("") &&
			  piece.getXPiece() == 6 &&
			  newPiece.getActionCommand().equals("")))
			   return true;
		}
		else if(piece.getForeground().equals(Color.white) &&
			   (piece.getYPiece() + 1 == newPiece.getYPiece() ||
				piece.getYPiece() - 1 == newPiece.getYPiece()))
		{
			if(yDistance == -1 && !newPiece.getActionCommand().equals("") &&
			  newPiece.getForeground().equals(Color.black))
			   return true;
		}
		else if(piece.getForeground().equals(Color.black) &&
				piece.getYPiece() == newPiece.getYPiece())
		{
			String firstPiece = Board.getInstance().getPiece(piece.getXPiece() + 1, piece.getYPiece());
			
		    if((yDistance == 1 && !firstPiece.equals("OOB") &&
		      newPiece.getActionCommand().equals("")) ||
			  (yDistance == 2 && firstPiece.equals("") &&
			  piece.getXPiece() == 1 &&
			  newPiece.getActionCommand().equals("")))
			   return true;
		}
		else if(piece.getForeground().equals(Color.black) &&
			   (piece.getYPiece() + 1 == newPiece.getYPiece() ||
				piece.getYPiece() - 1 == newPiece.getYPiece()))
		{
			if(yDistance == 1 && !newPiece.getActionCommand().equals("") &&
		      newPiece.getForeground().equals(Color.white))
			   return true;
		}
		
		return false;
	}
	
	private boolean moveRook(Piece piece, Piece newPiece) {
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
	
	private boolean moveKnight(Piece piece, Piece newPiece) {
		int xDistance = newPiece.getYPiece() - piece.getYPiece();
		int yDistance = newPiece.getXPiece() - piece.getXPiece();

		if(Math.abs(xDistance) == 1 && Math.abs(yDistance) == 2 && 
		  (newPiece.getActionCommand().equals("") ||
		  !newPiece.getForeground().equals(piece.getForeground())))
		{
			return true;
		}
		else if(Math.abs(xDistance) == 2 && Math.abs(yDistance) == 1 && 
			   (newPiece.getActionCommand().equals("") ||
			   !newPiece.getForeground().equals(piece.getForeground())))
		{
			return true;
		}
		
		return false;
	}
	
	private boolean moveBishop(Piece piece, Piece newPiece) {
		int xDistance = newPiece.getYPiece() - piece.getYPiece();
		int yDistance = newPiece.getXPiece() - piece.getXPiece();

		if(Math.abs(xDistance) == Math.abs(yDistance) && 
		  (newPiece.getActionCommand().equals("") ||
		  !newPiece.getForeground().equals(piece.getForeground())))
		{
			if(xDistance > 0 && yDistance > 0)
			{
				for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
				{
					if(!Board.getInstance().getPiece(piece.getXPiece() + i, piece.getYPiece() + i).equals(""))
						return false;
				}
				
				return true;
			}
			else if(xDistance > 0 && yDistance < 0)
			{
				for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
				{
					if(!Board.getInstance().getPiece(piece.getXPiece() - i, piece.getYPiece() + i).equals(""))
						return false;
				}
				
				return true;
			}
			else if(xDistance < 0 && yDistance > 0)
			{
				for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
				{
					if(!Board.getInstance().getPiece(piece.getXPiece() + i, piece.getYPiece() - i).equals(""))
						return false;
				}
				
				return true;
			}
			else if(xDistance < 0 && yDistance < 0)
			{
				for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
				{
					if(!Board.getInstance().getPiece(piece.getXPiece() - i, piece.getYPiece() - i).equals(""))
						return false;
				}
				
				return true;
			}
		}
		
		return false;
	}
	
	private boolean moveQueen(Piece piece, Piece newPiece) {
		int xDistance = newPiece.getYPiece() - piece.getYPiece();
		int yDistance = newPiece.getXPiece() - piece.getXPiece();

		if(Math.abs(xDistance) == Math.abs(yDistance) && 
		  (newPiece.getActionCommand().equals("") ||
		  !newPiece.getForeground().equals(piece.getForeground())))
		{
			if(xDistance > 0 && yDistance > 0)
			{
				for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
				{
					if(!Board.getInstance().getPiece(piece.getXPiece() + i, piece.getYPiece() + i).equals(""))
						return false;
				}
				
				return true;
			}
			else if(xDistance > 0 && yDistance < 0)
			{
				for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
				{
					if(!Board.getInstance().getPiece(piece.getXPiece() - i, piece.getYPiece() + i).equals(""))
						return false;
				}
				
				return true;
			}
			else if(xDistance < 0 && yDistance > 0)
			{
				for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
				{
					if(!Board.getInstance().getPiece(piece.getXPiece() + i, piece.getYPiece() - i).equals(""))
						return false;
				}
				
				return true;
			}
			else if(xDistance < 0 && yDistance < 0)
			{
				for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
				{
					if(!Board.getInstance().getPiece(piece.getXPiece() - i, piece.getYPiece() - i).equals(""))
						return false;
				}
				
				return true;
			}
		}
		else if(xDistance == 0 && (newPiece.getActionCommand().equals("") ||
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
	
	private boolean moveKing(Piece piece, Piece newPiece) {
		int xDistance = newPiece.getYPiece() - piece.getYPiece();
		int yDistance = newPiece.getXPiece() - piece.getXPiece();

		/*if(!piece.hasKingMoved() && !newPiece.hasRookMoved() &&
			newPiece.getActionCommand().equals(""))
		{
			int negative = xDistance < 0 ? -1 : 1;
			
			for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
			{
				if(!Board.getInstance().getPiece(piece.getXPiece(), piece.getYPiece() + (i * negative)).equals(""))
					return false;
			}
			
			return true;
		}
		else */if(xDistance <= 1 && xDistance >= -1 && 
			    yDistance <= 1 && yDistance >= -1 && 
			   (newPiece.getActionCommand().equals("") ||
			   !newPiece.getForeground().equals(piece.getForeground())))
		{
			return true;
		}
		
		return false;
	}
}
