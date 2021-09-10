import java.util.*;
import javax.swing.*;

public class Board {
	
	static final int BOARD_SIZE = 8;
	private static Board instance = null;
	private static List<List<Character>> board = new ArrayList<List<Character>>(BOARD_SIZE);
    
	private Board() {
		for(int i = 0; i < BOARD_SIZE; i++)  {
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
		
		for(int i = 0; i < BOARD_SIZE; i++)
			board.get(1).add('p');

		for(int i = 0; i < BOARD_SIZE; i++)
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
	
	public void createBoard(JFrame f) {
		//creating instance of JFrame
		Game pieces = Game.getInstance();
		
		
		
		f.add(pieces.getPiece("R", 50, 50, "black"));//adding button in JFrame  
		f.add(pieces.getPiece("H", 100, 50, "black"));
		f.add(pieces.getPiece("B", 150, 50, "black"));
		f.add(pieces.getPiece("Q", 200, 50, "black"));
		f.add(pieces.getPiece("K", 250, 50, "black"));
		f.add(pieces.getPiece("B", 300, 50, "black"));
		f.add(pieces.getPiece("H", 350, 50, "black"));
		f.add(pieces.getPiece("R", 400, 50, "black"));
		
		for(int i = 0; i < BOARD_SIZE; i++)
		{
			int incr = 50 * (i + 1);
			f.add(pieces.getPiece("p", incr, 100, "black"));
		}
		
		for(int i = 0; i < BOARD_SIZE / 2; i++)
		{
			int yincr = 100 + 50 * (i + 1);
			
			for(int j = 0; j < BOARD_SIZE; j++)
			{
				int incr = 50 * (j + 1);
				f.add(pieces.getPiece("", incr, yincr, "black"));
			}
		}
		
		for(int i = 0; i < BOARD_SIZE; i++)
		{
			int incr = 50 * (i + 1);
			f.add(pieces.getPiece("p", incr, 350, "white"));
		}
		
		f.add(pieces.getPiece("R", 50, 400, "white"));
		f.add(pieces.getPiece("H", 100, 400, "white"));
		f.add(pieces.getPiece("B", 150, 400, "white"));
		f.add(pieces.getPiece("Q", 200, 400, "white"));
		f.add(pieces.getPiece("K", 250, 400, "white"));
		f.add(pieces.getPiece("B", 300, 400, "white"));
		f.add(pieces.getPiece("H", 350, 400, "white"));
		f.add(pieces.getPiece("R", 400, 400, "white"));
		
		f.setSize(515,550);//400 width and 500 height
		f.setLayout(null);//using no layout managers
		f.setVisible(true);//making the frame visible
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
		
		for(int i = 0; i < BOARD_SIZE - 4; i++)
		{
			for(int j = 0; j < BOARD_SIZE; j++)
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
