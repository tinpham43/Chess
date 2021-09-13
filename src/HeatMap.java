import java.awt.Color;
import java.util.List;

public class HeatMap {
	
	private static final int BOARD_SIZE = 8;

	public static void updateHeatMap(List<List<Piece>> board) {
		for(int i = 0; i < BOARD_SIZE; i++)
		{
			for(int j = 0; j < BOARD_SIZE; j++)
			{
				board.get(i).get(j).updateWhiteMap(false);
				board.get(i).get(j).updateBlackMap(false);
			}
		}
		
		for(int i = 0; i < BOARD_SIZE; i++)
		{
			for(int j = 0; j < BOARD_SIZE; j++)
			{
				if(board.get(i).get(j).getActionCommand().equals("p"))
				{
					if(board.get(i).get(j).getForeground().equals(Color.white))
					{
						if(i - 1 >= 0 && j + 1 < BOARD_SIZE)
							board.get(i - 1).get(j + 1).updateWhiteMap(true);
						if(i - 1 >= 0 && j - 1 >= 0)
							board.get(i - 1).get(j - 1).updateWhiteMap(true);
					}
					else
					{
						if(i + 1 < BOARD_SIZE && j + 1 < BOARD_SIZE)
							board.get(i + 1).get(j + 1).updateBlackMap(true);
						if(i + 1 < BOARD_SIZE && j - 1 >= 0)
							board.get(i + 1).get(j - 1).updateBlackMap(true);
					}
				}
				else if(board.get(i).get(j).getActionCommand().equals("R"))
				{
					for(int k = i + 1; k < BOARD_SIZE; k++)
					{
						if(board.get(k).get(j).getActionCommand().equals("") ||
						   board.get(k).get(j).getActionCommand().equals("K"))
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
					
					for(int k = i - 1; k >= 0; k--)
					{
						if(board.get(k).get(j).getActionCommand().equals("") ||
						   board.get(k).get(j).getActionCommand().equals("K"))
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
					
					for(int k = j + 1; k < BOARD_SIZE; k++)
					{
						if(board.get(k).get(j).getActionCommand().equals("") ||
						   board.get(k).get(j).getActionCommand().equals("K"))
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
					
					for(int k = j - 1; k >= 0; k--)
					{
						if(board.get(k).get(j).getActionCommand().equals("") ||
						   board.get(k).get(j).getActionCommand().equals("K"))
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
					if(board.get(i).get(j).getForeground().equals(Color.white))
					{
						if(j + 2 < BOARD_SIZE && i - 1 >= 0)
							board.get(i - 1).get(j + 2).updateWhiteMap(true);
						if(j - 2 >= 0 && i - 1 >= 0)
							board.get(i - 1).get(j - 2).updateWhiteMap(true);
						if(j + 2 < BOARD_SIZE && i + 1 < BOARD_SIZE)
							board.get(i + 1).get(j + 2).updateWhiteMap(true);
						if(j - 2 >= 0 && i + 1 < BOARD_SIZE)
							board.get(i + 1).get(j - 2).updateWhiteMap(true);
						if(j + 1 < BOARD_SIZE && i - 2 >= 0)
							board.get(i - 2).get(j + 1).updateWhiteMap(true);
						if(j - 1 >= 0 && i - 2 >= 0)
							board.get(i - 2).get(j - 1).updateWhiteMap(true);
						if(j + 1 < BOARD_SIZE && i + 2 < BOARD_SIZE)
							board.get(i + 2).get(j + 1).updateWhiteMap(true);
						if(j - 1 >= 0 && i + 2 < BOARD_SIZE)
							board.get(i + 2).get(j - 1).updateWhiteMap(true);
					}
					else
					{
						if(j + 2 < BOARD_SIZE && i - 1 >= 0)
							board.get(i - 1).get(j + 2).updateBlackMap(true);
						if(j - 2 >= 0 && i - 1 >= 0)
							board.get(i - 1).get(j - 2).updateBlackMap(true);
						if(j + 2 < BOARD_SIZE && i + 1 < BOARD_SIZE)
							board.get(i + 1).get(j + 2).updateBlackMap(true);
						if(j - 2 >= 0 && i + 1 < BOARD_SIZE)
							board.get(i + 1).get(j - 2).updateBlackMap(true);
						if(j + 1 < BOARD_SIZE && i - 2 >= 0)
							board.get(i - 2).get(j + 1).updateBlackMap(true);
						if(j - 1 >= 0 && i - 2 >= 0)
							board.get(i - 2).get(j - 1).updateBlackMap(true);
						if(j + 1 < BOARD_SIZE && i + 2 < BOARD_SIZE)
							board.get(i + 2).get(j + 1).updateBlackMap(true);
						if(j - 1 >= 0 && i + 2 < BOARD_SIZE)
							board.get(i + 2).get(j - 1).updateBlackMap(true);
					}
				}
				else if(board.get(i).get(j).getActionCommand().equals("B"))
				{
					for(int k = i + 1, l = j + 1; k < BOARD_SIZE && l < BOARD_SIZE; k++, l++)
					{
						if(board.get(k).get(l).getActionCommand().equals("") ||
						   board.get(k).get(l).getActionCommand().equals("K"))
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(l).updateWhiteMap(true);
							else
								board.get(k).get(l).updateBlackMap(true);
						}
						else
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(l).updateWhiteMap(true);
							else
								board.get(k).get(l).updateBlackMap(true);
							
							break;
						}
					}
					
					for(int k = i - 1, l = j + 1; k >= 0 && l < BOARD_SIZE; k--, l++)
					{
						if(board.get(k).get(l).getActionCommand().equals("") ||
						   board.get(k).get(l).getActionCommand().equals("K"))
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(l).updateWhiteMap(true);
							else
								board.get(k).get(l).updateBlackMap(true);
						}
						else
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(l).updateWhiteMap(true);
							else
								board.get(k).get(l).updateBlackMap(true);
							
							break;
						}
					}
					
					for(int k = i + 1, l = j - 1; k < BOARD_SIZE && l >= 0; k++, l--)
					{
						if(board.get(k).get(l).getActionCommand().equals("") ||
						   board.get(k).get(l).getActionCommand().equals("K"))
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(l).updateWhiteMap(true);
							else
								board.get(k).get(l).updateBlackMap(true);
						}
						else
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(l).updateWhiteMap(true);
							else
								board.get(k).get(l).updateBlackMap(true);
							
							break;
						}
					}
					
					for(int k = i - 1, l = j - 1; k >= 0 && l >= 0; k--, l--)
					{
						if(board.get(k).get(l).getActionCommand().equals("") ||
						   board.get(k).get(l).getActionCommand().equals("K"))
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(l).updateWhiteMap(true);
							else
								board.get(k).get(l).updateBlackMap(true);
						}
						else
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(l).updateWhiteMap(true);
							else
								board.get(k).get(l).updateBlackMap(true);
							
							break;
						}
					}
				}
				else if(board.get(i).get(j).getActionCommand().equals("Q"))
				{
					for(int k = i + 1; k < BOARD_SIZE; k++)
					{
						if(board.get(k).get(j).getActionCommand().equals("") ||
						   board.get(k).get(j).getActionCommand().equals("K"))
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
					
					for(int k = i - 1; k >= 0; k--)
					{
						if(board.get(k).get(j).getActionCommand().equals("") ||
						   board.get(k).get(j).getActionCommand().equals("K"))
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
					
					for(int k = j + 1; k < BOARD_SIZE; k++)
					{
						if(board.get(k).get(j).getActionCommand().equals("") ||
						   board.get(k).get(j).getActionCommand().equals("K"))
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
					
					for(int k = j - 1; k >= 0; k--)
					{
						if(board.get(k).get(j).getActionCommand().equals("") ||
						   board.get(k).get(j).getActionCommand().equals("K"))
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
					
					for(int k = i + 1, l = j + 1; k < BOARD_SIZE && l < BOARD_SIZE; k++, l++)
					{
						if(board.get(k).get(l).getActionCommand().equals("") ||
						   board.get(k).get(l).getActionCommand().equals("K"))
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(l).updateWhiteMap(true);
							else
								board.get(k).get(l).updateBlackMap(true);
						}
						else
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(l).updateWhiteMap(true);
							else
								board.get(k).get(l).updateBlackMap(true);
							
							break;
						}
					}
					
					for(int k = i - 1, l = j + 1; k >= 0 && l < BOARD_SIZE; k--, l++)
					{
						if(board.get(k).get(l).getActionCommand().equals("") ||
						   board.get(k).get(l).getActionCommand().equals("K"))
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(l).updateWhiteMap(true);
							else
								board.get(k).get(l).updateBlackMap(true);
						}
						else
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(l).updateWhiteMap(true);
							else
								board.get(k).get(l).updateBlackMap(true);
							
							break;
						}
					}
					
					for(int k = i + 1, l = j - 1; k < BOARD_SIZE && l >= 0; k++, l--)
					{
						if(board.get(k).get(l).getActionCommand().equals("") ||
						   board.get(k).get(l).getActionCommand().equals("K"))
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(l).updateWhiteMap(true);
							else
								board.get(k).get(l).updateBlackMap(true);
						}
						else
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(l).updateWhiteMap(true);
							else
								board.get(k).get(l).updateBlackMap(true);
							
							break;
						}
					}
					
					for(int k = i - 1, l = j - 1; k >= 0 && l >= 0; k--, l--)
					{
						if(board.get(k).get(l).getActionCommand().equals("") ||
						   board.get(k).get(l).getActionCommand().equals("K"))
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(l).updateWhiteMap(true);
							else
								board.get(k).get(l).updateBlackMap(true);
						}
						else
						{
							if(board.get(i).get(j).getForeground().equals(Color.white))
								board.get(k).get(l).updateWhiteMap(true);
							else
								board.get(k).get(l).updateBlackMap(true);
							
							break;
						}
					}
				}
				else if(board.get(i).get(j).getActionCommand().equals("K"))
				{
					if(board.get(i).get(j).getForeground().equals(Color.white))
					{
						if(j + 1 < BOARD_SIZE)
							board.get(i).get(j + 1).updateWhiteMap(true);
						if(j - 1 >= 0)
							board.get(i).get(j - 1).updateWhiteMap(true);
						
						if(i + 1 < BOARD_SIZE)
						{
							board.get(i + 1).get(j).updateWhiteMap(true);
							
							if(j + 1 < BOARD_SIZE)
								board.get(i + 1).get(j + 1).updateWhiteMap(true);
							if(j - 1 >= 0)
								board.get(i + 1).get(j - 1).updateWhiteMap(true);
						}
						if(i - 1 >= 0)
						{
							board.get(i - 1).get(j).updateWhiteMap(true);
							
							if(j + 1 < BOARD_SIZE)
								board.get(i - 1).get(j + 1).updateWhiteMap(true);
							if(j - 1 >= 0)
								board.get(i - 1).get(j - 1).updateWhiteMap(true);
						}
					}
					else
					{
						if(j + 1 < BOARD_SIZE)
							board.get(i).get(j + 1).updateBlackMap(true);
						if(j - 1 >= 0)
							board.get(i).get(j - 1).updateBlackMap(true);
						
						if(i + 1 < BOARD_SIZE)
						{
							board.get(i + 1).get(j).updateBlackMap(true);
							
							if(j + 1 < BOARD_SIZE)
								board.get(i + 1).get(j + 1).updateBlackMap(true);
							if(j - 1 >= 0)
								board.get(i + 1).get(j - 1).updateBlackMap(true);
						}
						if(i - 1 >= 0)
						{
							board.get(i - 1).get(j).updateBlackMap(true);
							
							if(j + 1 < BOARD_SIZE)
								board.get(i - 1).get(j + 1).updateBlackMap(true);
							if(j - 1 >= 0)
								board.get(i - 1).get(j - 1).updateBlackMap(true);
						}
					}
				}
			}
		}

		//printHeatMap(board);
	}
	
	public static void printHeatMap(List<List<Piece>> board) {
		for(Piece i : board.get(0))
		{
			System.out.print('|');

			if(i.isWhiteMap())
				System.out.print("W");
			else
				System.out.print(" ");
		}
		System.out.println('|');
		
		for(Piece i : board.get(1))
		{
			System.out.print('|');

			if(i.isWhiteMap())
				System.out.print("W");
			else
				System.out.print(" ");
		}
		System.out.println('|');
		
		for(int i = 2; i < BOARD_SIZE - 2; i++)
		{
			for(Piece j : board.get(i))
			{
				System.out.print("|");
				
				if(j.isWhiteMap())
					System.out.print("W");
				else
					System.out.print(" ");
				
			}
			System.out.println('|');
		}

		for(Piece i : board.get(6))
		{
			System.out.print('|');
			
			if(i.isWhiteMap())
				System.out.print("W");
			else
				System.out.print(" ");
		}
		System.out.println('|');
		
		for(Piece i : board.get(7))
		{
			System.out.print('|');

			if(i.isWhiteMap())
				System.out.print("W");
			else
				System.out.print(" ");
		}
		System.out.println('|');
		System.out.println();
		
		//black
		for(Piece i : board.get(0))
		{
			System.out.print('|');

			if(i.isBlackMap())
				System.out.print("B");
			else
				System.out.print(" ");
		}
		System.out.println('|');
		
		for(Piece i : board.get(1))
		{
			System.out.print('|');

			if(i.isBlackMap())
				System.out.print("B");
			else
				System.out.print(" ");
		}
		System.out.println('|');
		
		for(int i = 2; i < BOARD_SIZE - 2; i++)
		{
			for(Piece j : board.get(i))
			{
				System.out.print("|");
				
				if(j.isBlackMap())
					System.out.print("B");
				else
					System.out.print(" ");
				
			}
			System.out.println('|');
		}

		for(Piece i : board.get(6))
		{
			System.out.print('|');
			
			if(i.isBlackMap())
				System.out.print("B");
			else
				System.out.print(" ");
		}
		System.out.println('|');
		
		for(Piece i : board.get(7))
		{
			System.out.print('|');

			if(i.isBlackMap())
				System.out.print("B");
			else
				System.out.print(" ");
		}
		System.out.println('|');
		System.out.println();
	}
}