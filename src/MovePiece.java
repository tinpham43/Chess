import java.awt.Color;

public class MovePiece {

	public static boolean validMove(Piece liftedPiece, Piece newPiece) {
		boolean ret = false;

		switch(liftedPiece.getActionCommand())
		{
			case "p":
				ret = movePawn(liftedPiece, newPiece);
				break;
			case "R":
				ret = moveRook(liftedPiece, newPiece);
				break;
			case "H":
				ret = moveKnight(liftedPiece, newPiece);
				break;
			case "B":
				ret = moveBishop(liftedPiece, newPiece);
				break;
			case "Q":
				ret = moveQueen(liftedPiece, newPiece);
				break;
			case "K":
				ret = moveKing(liftedPiece, newPiece);
				break;
			default:
				break;
		}
		
		return ret;
	}

	private static boolean movePawn(Piece liftedPiece, Piece newPiece) {
		
		int yDistance = newPiece.getXPiece() - liftedPiece.getXPiece();

		if(liftedPiece.getForeground().equals(Color.white) &&
		   liftedPiece.getYPiece() == newPiece.getYPiece())
		{
			String firstPiece = Board.getInstance().getPiece(liftedPiece.getXPiece() - 1, liftedPiece.getYPiece());
			
		    if((yDistance == -1 && !firstPiece.equals("OOB") &&
			  newPiece.getActionCommand().equals("")) ||
			  (yDistance == -2 && firstPiece.equals("") &&
			  liftedPiece.getXPiece() == 6 &&
			  newPiece.getActionCommand().equals("")))
			   return true;
		}
		else if(liftedPiece.getForeground().equals(Color.white) &&
			   (liftedPiece.getYPiece() + 1 == newPiece.getYPiece() ||
				liftedPiece.getYPiece() - 1 == newPiece.getYPiece()))
		{
			if(yDistance == -1 && !newPiece.getActionCommand().equals("") &&
			  newPiece.getForeground().equals(Color.black))
			   return true;
		}
		else if(liftedPiece.getForeground().equals(Color.black) &&
				liftedPiece.getYPiece() == newPiece.getYPiece())
		{
			String firstPiece = Board.getInstance().getPiece(liftedPiece.getXPiece() + 1, liftedPiece.getYPiece());
			
		    if((yDistance == 1 && !firstPiece.equals("OOB") &&
		      newPiece.getActionCommand().equals("")) ||
			  (yDistance == 2 && firstPiece.equals("") &&
			  liftedPiece.getXPiece() == 1 &&
			  newPiece.getActionCommand().equals("")))
			   return true;
		}
		else if(liftedPiece.getForeground().equals(Color.black) &&
			   (liftedPiece.getYPiece() + 1 == newPiece.getYPiece() ||
				liftedPiece.getYPiece() - 1 == newPiece.getYPiece()))
		{
			if(yDistance == 1 && !newPiece.getActionCommand().equals("") &&
		      newPiece.getForeground().equals(Color.white))
			   return true;
		}
		
		return false;
	}
	
	private static boolean moveRook(Piece liftedPiece, Piece newPiece) {
		int xDistance = newPiece.getYPiece() - liftedPiece.getYPiece();
		int yDistance = newPiece.getXPiece() - liftedPiece.getXPiece();

		if(xDistance == 0 && (newPiece.getActionCommand().equals("") ||
		  !newPiece.getForeground().equals(liftedPiece.getForeground())))
		{
			int negative = yDistance < 0 ? -1 : 1;

			for(int i = 1; i <= (Math.abs(yDistance) - 1); i++)
			{
				if(!Board.getInstance().getPiece(liftedPiece.getXPiece() + (i * negative), liftedPiece.getYPiece()).equals(""))
					return false;
			}

			return true;
		}
		else if(yDistance == 0 && (newPiece.getActionCommand().equals("") ||
			   !newPiece.getForeground().equals(liftedPiece.getForeground())))
		{
			int negative = xDistance < 0 ? -1 : 1;
			
			for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
			{
				if(!Board.getInstance().getPiece(liftedPiece.getXPiece(), liftedPiece.getYPiece() + (i * negative)).equals(""))
					return false;
			}
			
			return true;
		}
		
		return false;
	}
	
	private static boolean moveKnight(Piece liftedPiece, Piece newPiece) {
		int xDistance = newPiece.getYPiece() - liftedPiece.getYPiece();
		int yDistance = newPiece.getXPiece() - liftedPiece.getXPiece();

		if(Math.abs(xDistance) == 1 && Math.abs(yDistance) == 2 && 
		  (newPiece.getActionCommand().equals("") ||
		  !newPiece.getForeground().equals(liftedPiece.getForeground())))
		{
			return true;
		}
		else if(Math.abs(xDistance) == 2 && Math.abs(yDistance) == 1 && 
			   (newPiece.getActionCommand().equals("") ||
			   !newPiece.getForeground().equals(liftedPiece.getForeground())))
		{
			return true;
		}
		
		return false;
	}
	
	private static boolean moveBishop(Piece liftedPiece, Piece newPiece) {
		int xDistance = newPiece.getYPiece() - liftedPiece.getYPiece();
		int yDistance = newPiece.getXPiece() - liftedPiece.getXPiece();

		if(Math.abs(xDistance) == Math.abs(yDistance) && 
		  (newPiece.getActionCommand().equals("") ||
		  !newPiece.getForeground().equals(liftedPiece.getForeground())))
		{
			if(xDistance > 0 && yDistance > 0)
			{
				for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
				{
					if(!Board.getInstance().getPiece(liftedPiece.getXPiece() + i, liftedPiece.getYPiece() + i).equals(""))
						return false;
				}
				
				return true;
			}
			else if(xDistance > 0 && yDistance < 0)
			{
				for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
				{
					if(!Board.getInstance().getPiece(liftedPiece.getXPiece() - i, liftedPiece.getYPiece() + i).equals(""))
						return false;
				}
				
				return true;
			}
			else if(xDistance < 0 && yDistance > 0)
			{
				for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
				{
					if(!Board.getInstance().getPiece(liftedPiece.getXPiece() + i, liftedPiece.getYPiece() - i).equals(""))
						return false;
				}
				
				return true;
			}
			else if(xDistance < 0 && yDistance < 0)
			{
				for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
				{
					if(!Board.getInstance().getPiece(liftedPiece.getXPiece() - i, liftedPiece.getYPiece() - i).equals(""))
						return false;
				}
				
				return true;
			}
		}
		
		return false;
	}
	
	private static boolean moveQueen(Piece liftedPiece, Piece newPiece) {
		int xDistance = newPiece.getYPiece() - liftedPiece.getYPiece();
		int yDistance = newPiece.getXPiece() - liftedPiece.getXPiece();

		if(Math.abs(xDistance) == Math.abs(yDistance) && 
		  (newPiece.getActionCommand().equals("") ||
		  !newPiece.getForeground().equals(liftedPiece.getForeground())))
		{
			if(xDistance > 0 && yDistance > 0)
			{
				for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
				{
					if(!Board.getInstance().getPiece(liftedPiece.getXPiece() + i, liftedPiece.getYPiece() + i).equals(""))
						return false;
				}
				
				return true;
			}
			else if(xDistance > 0 && yDistance < 0)
			{
				for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
				{
					if(!Board.getInstance().getPiece(liftedPiece.getXPiece() - i, liftedPiece.getYPiece() + i).equals(""))
						return false;
				}
				
				return true;
			}
			else if(xDistance < 0 && yDistance > 0)
			{
				for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
				{
					if(!Board.getInstance().getPiece(liftedPiece.getXPiece() + i, liftedPiece.getYPiece() - i).equals(""))
						return false;
				}
				
				return true;
			}
			else if(xDistance < 0 && yDistance < 0)
			{
				for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
				{
					if(!Board.getInstance().getPiece(liftedPiece.getXPiece() - i, liftedPiece.getYPiece() - i).equals(""))
						return false;
				}
				
				return true;
			}
		}
		else if(xDistance == 0 && (newPiece.getActionCommand().equals("") ||
				  !newPiece.getForeground().equals(liftedPiece.getForeground())))
		{
			int negative = yDistance < 0 ? -1 : 1;

			for(int i = 1; i <= (Math.abs(yDistance) - 1); i++)
			{
				if(!Board.getInstance().getPiece(liftedPiece.getXPiece() + (i * negative), liftedPiece.getYPiece()).equals(""))
					return false;
			}

			return true;
		}
		else if(yDistance == 0 && (newPiece.getActionCommand().equals("") ||
			   !newPiece.getForeground().equals(liftedPiece.getForeground())))
		{
			int negative = xDistance < 0 ? -1 : 1;
			
			for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
			{
				if(!Board.getInstance().getPiece(liftedPiece.getXPiece(), liftedPiece.getYPiece() + (i * negative)).equals(""))
					return false;
			}
			
			return true;
		}
		
		return false;
	}
	
	private static boolean moveKing(Piece liftedPiece, Piece newPiece) {
		int xDistance = newPiece.getYPiece() - liftedPiece.getYPiece();
		int yDistance = newPiece.getXPiece() - liftedPiece.getXPiece();

		if(liftedPiece.getForeground().equals(Color.white) &&
			xDistance > 0 && 
				!liftedPiece.hasKingMoved() && !newPiece.hasRookMoved() &&
			newPiece.getActionCommand().equals(""))
		{
			int negative = xDistance < 0 ? -1 : 1;
			
			for(int i = 1; i <= (Math.abs(xDistance) - 1); i++)
			{
				if(!Board.getInstance().getPiece(liftedPiece.getXPiece(), liftedPiece.getYPiece() + (i * negative)).equals(""))
					return false;
			}
			
			return true;
		}
		else if(xDistance <= 1 && xDistance >= -1 && 
			    yDistance <= 1 && yDistance >= -1 && 
			   (newPiece.getActionCommand().equals("") ||
			   !newPiece.getForeground().equals(liftedPiece.getForeground())))
		{
			return true;
		}
		
		return false;
	}
}
