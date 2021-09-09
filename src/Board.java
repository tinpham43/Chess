import java.util.*;

public class Board {
	
	static final int SIZE = 8;
	private static Board instance = null;
	private static List<List<Character>> board = new ArrayList<List<Character>>(SIZE);
    
	private Board() {
		
		for(int i = 0; i < SIZE; i++)  {
			board.add(new ArrayList<Character>());
	    }
		
		board.get(0).add('R');
		board.get(0).add('H');
		board.get(0).add('B');
		board.get(0).add('Q');
		board.get(0).add('K');
		board.get(0).add('B');
		board.get(0).add('H');
		board.get(0).add('R');
		
		for(int i = 0; i < SIZE; i++)
			board.get(1).add('p');

		for(int i = 0; i < SIZE; i++)
			board.get(6).add('p');
		
		board.get(7).add('R');
		board.get(7).add('H');
		board.get(7).add('B');
		board.get(7).add('Q');
		board.get(7).add('K');
		board.get(7).add('B');
		board.get(7).add('H');
		board.get(7).add('R');
	}
	
	public static Board getInstance() {
		if(instance == null)
			instance = new Board();
		
		return instance;
	}
	
	public void printBoard() {
		for(Character i : board.get(0))
		{
			System.out.print('|');
			System.out.print(i);
		}
		System.out.println('|');
		
		for(Character i : board.get(1))
		{
			System.out.print('|');
			System.out.print(i);
		}
		System.out.println('|');
		
		for(int i = 0; i < SIZE - 4; i++)
		{
			for(int j = 0; j < SIZE; j++)
			{
				System.out.print("| ");
			}
			System.out.println('|');
		}

		for(Character i : board.get(6))
		{
			System.out.print('|');
			System.out.print(i);
		}
		System.out.println('|');
		
		for(Character i : board.get(7))
		{
			System.out.print('|');
			System.out.print(i);
		}
		System.out.println('|');
	}
}
