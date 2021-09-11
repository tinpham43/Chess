import java.awt.Font;
import java.util.*;
import javax.swing.*;

public class Board {
	
	private static final int BOARD_SIZE = 8;
	private JLabel label;
	private List<List<String>> board;
	private static Board instance = null;
	
	private Board() {
		label = new JLabel("White's turn");
		board = new ArrayList<List<String>>(BOARD_SIZE);
		
		for(int i = 0; i < BOARD_SIZE; i++)  {
			board.add(new ArrayList<String>());
	    }
		
		board.get(0).add("R");
		board.get(0).add("H");
		board.get(0).add("B");
		board.get(0).add("Q");
		board.get(0).add("K");
		board.get(0).add("B");
		board.get(0).add("H");
		board.get(0).add("R");
		
		for(int i = 0; i < BOARD_SIZE; i++)
			board.get(1).add("p");
		
		for(int i = 0; i < BOARD_SIZE / 2; i++)
			board.get(i + 2).add("");

		for(int i = 0; i < BOARD_SIZE; i++)
			board.get(6).add("p");
		
		board.get(7).add("R");
		board.get(7).add("H");
		board.get(7).add("B");
		board.get(7).add("Q");
		board.get(7).add("K");
		board.get(7).add("B");
		board.get(7).add("H");
		board.get(7).add("R");
	}
	
	public static Board getInstance() {
		if(instance == null)
			instance = new Board();
		
		return instance;
	}
	
	public void createBoard(JFrame f) {
		Game game = new Game();
		
		f.add(turnLabel());
		
		f.add(game.getPiece("R", 0, 0, 50, 50, "black"));//adding button in JFrame  
		f.add(game.getPiece("H", 1, 0, 100, 50, "black"));
		f.add(game.getPiece("B", 2, 0, 150, 50, "black"));
		f.add(game.getPiece("Q", 3, 0, 200, 50, "black"));
		f.add(game.getPiece("K", 4, 0, 250, 50, "black"));
		f.add(game.getPiece("B", 5, 0, 300, 50, "black"));
		f.add(game.getPiece("H", 6, 0, 350, 50, "black"));
		f.add(game.getPiece("R", 7, 0, 400, 50, "black"));
		
		for(int i = 0; i < BOARD_SIZE; i++)
		{
			int incr = 50 * (i + 1);
			f.add(game.getPiece("p", i, 1, incr, 100, "black"));
		}
		
		for(int i = 0; i < BOARD_SIZE / 2; i++)
		{
			int yincr = 100 + 50 * (i + 1);
			
			for(int j = 0; j < BOARD_SIZE; j++)
			{
				int incr = 50 * (j + 1);
				f.add(game.getPiece("", j, i + 2, incr, yincr, "black"));
			}
		}
		
		for(int i = 0; i < BOARD_SIZE; i++)
		{
			int incr = 50 * (i + 1);
			f.add(game.getPiece("p", i, 6, incr, 350, "white"));
		}
		
		f.add(game.getPiece("R", 0, 7, 50, 400, "white"));
		f.add(game.getPiece("H", 1, 7, 100, 400, "white"));
		f.add(game.getPiece("B", 2, 7, 150, 400, "white"));
		f.add(game.getPiece("Q", 3, 7, 200, 400, "white"));
		f.add(game.getPiece("K", 4, 7, 250, 400, "white"));
		f.add(game.getPiece("B", 5, 7, 300, 400, "white"));
		f.add(game.getPiece("H", 6, 7, 350, 400, "white"));
		f.add(game.getPiece("R", 7, 7, 400, 400, "white"));
		
		f.setTitle("Chess Game");
		f.setSize(515,550);//400 width and 500 height
		f.setLayout(null);//using no layout managers
		f.setVisible(true);//making the frame visible
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String getPiece(int x, int y) {
		System.out.println(board.get(6).get(6));
		return board.get(x).get(y);
	}
	
	public JLabel turnLabel() {
		label = new JLabel("(White's turn)");
		label.setBounds(200,0,150,50);
		label.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		
		return label;
	}
	
	public void changeTurn() {
		if(label.getText().equals("(White's turn)"))
			label.setText("(Black's turn)");
		else
			label.setText("(White's turn)");
	}
	
	public void printBoard() {
		for(String i : board.get(0))
		{
			System.out.print('|');
			System.out.print(i);
		}
		System.out.println('|');
		
		for(String i : board.get(1))
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

		for(String i : board.get(6))
		{
			System.out.print('|');
			System.out.print(i);
		}
		System.out.println('|');
		
		for(String i : board.get(7))
		{
			System.out.print('|');
			System.out.print(i);
		}
		System.out.println('|');
	}
}
