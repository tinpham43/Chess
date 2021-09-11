import java.awt.Color;
import java.util.List;

public class HeatMap {
	
	private static final int BOARD_SIZE = 8;
	PASS BY REFERENCE
	public static void updateHeatMap(List<List<Piece>> board) {
		for(int i = 0; i < BOARD_SIZE; i++)
		{
			for(int j = 0; j < BOARD_SIZE; j++)
			{
				if(board.get(i).get(j).getActionCommand().equals("p"))
				{
					if(board.get(i).get(j).getForeground().equals(Color.white))
					{
						if(j + 1 < BOARD_SIZE)
							board.get(i - 1).get(j + 1).updateWhiteMap(true);
						if(j - 1 >= 0)
							board.get(i - 1).get(j - 1).updateWhiteMap(true);
					}
					else
					{
						if(j + 1 < BOARD_SIZE)
							board.get(i + 1).get(j + 1).updateBlackMap(true);
						if(j - 1 >= 0)
							board.get(i + 1).get(j - 1).updateBlackMap(true);
					}
				}
				else if(board.get(i).get(j).getActionCommand().equals("R"))
				{
					int k = 0;
					
					for(k = i + 1; k < BOARD_SIZE; k++)
					{
						if(board.get(k).get(j).getActionCommand().equals(""))
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(j).updateWhiteMap(true);
							else
								board.get(k).get(j).updateBlackMap(true);
						}
						else
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(j).updateWhiteMap(true);
							else
								board.get(k).get(j).updateBlackMap(true);
							
							break;
						}
					}
					
					for(k = i - 1; k >= 0; k--)
					{
						if(board.get(k).get(j).getActionCommand().equals(""))
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(j).updateWhiteMap(true);
							else
								board.get(k).get(j).updateBlackMap(true);
						}
						else
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(j).updateWhiteMap(true);
							else
								board.get(k).get(j).updateBlackMap(true);
							
							break;
						}
					}
					
					for(k = j + 1; k < BOARD_SIZE; k++)
					{
						if(board.get(k).get(j).getActionCommand().equals(""))
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(i).get(k).updateWhiteMap(true);
							else
								board.get(i).get(k).updateBlackMap(true);
						}
						else
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(i).get(k).updateWhiteMap(true);
							else
								board.get(i).get(k).updateBlackMap(true);
							
							break;
						}
					}
					
					for(k = j - 1; k >= 0; k--)
					{
						if(board.get(k).get(j).getActionCommand().equals(""))
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(i).get(k).updateWhiteMap(true);
							else
								board.get(i).get(k).updateBlackMap(true);
						}
						else
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(i).get(k).updateWhiteMap(true);
							else
								board.get(i).get(k).updateBlackMap(true);
							
							break;
						}
					}
				}
				else if(board.get(i).get(j).getActionCommand().equals("H"))
				{
					;
				}
				else if(board.get(i).get(j).getActionCommand().equals("B"))
				{
					int k = 0;
					
					for(k = i + 1; k < BOARD_SIZE; k++)
					{
						if(board.get(k).get(k).getActionCommand().equals(""))
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(k).updateWhiteMap(true);
							else
								board.get(k).get(k).updateBlackMap(true);
						}
						else
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(k).updateWhiteMap(true);
							else
								board.get(k).get(k).updateBlackMap(true);
							
							break;
						}
					}
					
					for(k = i - 1; k >= 0; k--)
					{
						if(board.get(k).get(j).getActionCommand().equals(""))
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(k).updateWhiteMap(true);
							else
								board.get(k).get(k).updateBlackMap(true);
						}
						else
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(k).updateWhiteMap(true);
							else
								board.get(k).get(k).updateBlackMap(true);
							
							break;
						}
					}
					
					for(k = j + 1; k < BOARD_SIZE; k++)
					{
						if(board.get(k).get(j).getActionCommand().equals(""))
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(k).updateWhiteMap(true);
							else
								board.get(k).get(k).updateBlackMap(true);
						}
						else
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(k).updateWhiteMap(true);
							else
								board.get(k).get(k).updateBlackMap(true);
							
							break;
						}
					}
					
					for(k = j - 1; k >= 0; k--)
					{
						if(board.get(k).get(j).getActionCommand().equals(""))
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(k).updateWhiteMap(true);
							else
								board.get(k).get(k).updateBlackMap(true);
						}
						else
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(k).updateWhiteMap(true);
							else
								board.get(k).get(k).updateBlackMap(true);
							
							break;
						}
					}
				}
			}
		}
	}

}
