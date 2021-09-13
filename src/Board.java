import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Board {
	
	private static final int BOARD_SIZE = 8;
	private static JFrame f = new JFrame();
	private JLabel label;
	private List<List<Piece>> board;
	private Game game;
	private static Board instance = null;
	
	private Board() {
		f = new JFrame();
		label = new JLabel("White's turn");
		board = new ArrayList<List<Piece>>(BOARD_SIZE);
		game = new Game();
		
		for(int i = 0; i < BOARD_SIZE; i++)  {
			board.add(new ArrayList<Piece>());
	    }
		
		board.get(0).add(game.getPiece("R", 0, 0, 50, 50, "black"));
		board.get(0).add(game.getPiece("H", 0, 1, 100, 50, "black"));
		board.get(0).add(game.getPiece("B", 0, 2, 150, 50, "black"));
		board.get(0).add(game.getPiece("Q", 0, 3, 200, 50, "black"));
		board.get(0).add(game.getPiece("K", 0, 4, 250, 50, "black"));
		board.get(0).add(game.getPiece("B", 0, 5, 300, 50, "black"));
		board.get(0).add(game.getPiece("H", 0, 6, 350, 50, "black"));
		board.get(0).add(game.getPiece("R", 0, 7, 400, 50, "black"));
		
		for(int i = 0; i < BOARD_SIZE; i++)
		{
			int incr = 50 * (i + 1);
			board.get(1).add(game.getPiece("p", 1, i, incr, 100, "black"));
		}

		for(int i = 0; i < (BOARD_SIZE / 2); i++)
		{
			int yincr = 100 + 50 * (i + 1);
		
			for(int j = 0; j < BOARD_SIZE; j++)
			{
				int incr = 50 * (j + 1);
				board.get(i + 2).add(game.getPiece("", i + 2, j, incr, yincr, ""));
			}
		}

		for(int i = 0; i < BOARD_SIZE; i++)
		{
			int incr = 50 * (i + 1);
			board.get(6).add(game.getPiece("p", 6, i, incr, 350, "white"));
		}

		board.get(7).add(game.getPiece("R", 7, 0, 50, 400, "white"));
		board.get(7).add(game.getPiece("H", 7, 1, 100, 400, "white"));
		board.get(7).add(game.getPiece("B", 7, 2, 150, 400, "white"));
		board.get(7).add(game.getPiece("Q", 7, 3, 200, 400, "white"));
		board.get(7).add(game.getPiece("K", 7, 4, 250, 400, "white"));
		board.get(7).add(game.getPiece("B", 7, 5, 300, 400, "white"));
		board.get(7).add(game.getPiece("H", 7, 6, 350, 400, "white"));
		board.get(7).add(game.getPiece("R", 7, 7, 400, 400, "white"));
		
		updateHeapMap();
	}
	
	public static Board getInstance() {
		if(instance == null)
			instance = new Board();
		
		return instance;
	}
	
	public void createBoard() {
		f.add(turnLabel("(White's turn)", 200, 0));

		for(List<Piece> i : board)
			for(Piece j : i)
				f.add(j);

		f.add(resetButton(f, 0, 0));
		f.setTitle("Chess Game");
		f.setSize(515,550);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void updateHeapMap() {
		HeatMap.updateHeatMap(board);
	}
	
	public boolean isCheck(Color color) {
		for(int i = 0; i < BOARD_SIZE; i++)
		{
			for(int j = 0; j < BOARD_SIZE; j++)
			{
				if(board.get(i).get(j).getActionCommand().equals("K") &&
			       board.get(i).get(j).getForeground().equals(color) &&
				  (color.equals(Color.black) && board.get(i).get(j).isWhiteMap() ||
				   color.equals(Color.white) && board.get(i).get(j).isBlackMap()))
					return true;
			}
		}
		
		return false;
	}
	
	public boolean isCheckMate(Color color) {
		boolean mate = true;
		
		for(int i = 0; i < BOARD_SIZE; i++)
		{
			for(int j = 0; j < BOARD_SIZE; j++)
			{
				if(color.equals(Color.white) &&
				   board.get(i).get(j).getForeground().equals(Color.white) &&
				  !board.get(i).get(j).getActionCommand().equals(""))
				{
					for(int k = 0; k < BOARD_SIZE; k++)
					{
						for(int l = 0; l < BOARD_SIZE; l++)
						{
							if(MovePiece.validMove(board.get(i).get(j), board.get(k).get(l)))
							{
								String pieceString = board.get(k).get(l).getActionCommand();
								Color pieceColor = board.get(k).get(l).getForeground();
								Color liftedPieceColor = board.get(i).get(j).getForeground();
								board.get(k).get(l).setText(board.get(i).get(j).getActionCommand());
								board.get(k).get(l).setForeground(liftedPieceColor);
								board.get(i).get(j).setText("");
								updateHeapMap();
								
								if(!findKing(Color.white).isBlackMap())
									mate = false;
								
								board.get(i).get(j).setText(board.get(k).get(l).getActionCommand());
								board.get(k).get(l).setText(pieceString);
								board.get(k).get(l).setForeground(pieceColor);
								updateHeapMap();
								
								if(mate == false)
									return false;
							}
						}
					}
				}
				else if(color.equals(Color.black) &&
					   board.get(i).get(j).getForeground().equals(Color.black) &&
					  !board.get(i).get(j).getActionCommand().equals(""))
				{
					for(int k = 0; k < BOARD_SIZE; k++)
					{
						for(int l = 0; l < BOARD_SIZE; l++)
						{
							if(MovePiece.validMove(board.get(i).get(j), board.get(k).get(l)))
							{
								String pieceString = board.get(k).get(l).getActionCommand();
								Color pieceColor = board.get(k).get(l).getForeground();
								Color liftedPieceColor = board.get(i).get(j).getForeground();
								board.get(k).get(l).setText(board.get(i).get(j).getActionCommand());
								board.get(k).get(l).setForeground(liftedPieceColor);
								board.get(i).get(j).setText("");
								updateHeapMap();
								
								if(!findKing(Color.black).isWhiteMap())
									mate = false;
								
								board.get(i).get(j).setText(board.get(k).get(l).getActionCommand());
								board.get(k).get(l).setText(pieceString);
								board.get(k).get(l).setForeground(pieceColor);
								updateHeapMap();
								
								if(mate == false)
									return false;
							}
						}
					}
				}
			}
		}

		return mate;
	}
	
	public Piece findKing(Color color) {
		for(int i = 0; i < BOARD_SIZE; i++)
		{
			for(int j = 0; j < BOARD_SIZE; j++)
			{
				if(color.equals(Color.white) && 
				   board.get(i).get(j).getActionCommand().equals("K") &&
				   board.get(i).get(j).getForeground().equals(Color.white))
					return board.get(i).get(j);
				else if(color.equals(Color.black) && 
				   board.get(i).get(j).getActionCommand().equals("K") &&
				   board.get(i).get(j).getForeground().equals(Color.black))
					return board.get(i).get(j);
			}
		}
		
		return null;
	}
	
	public String getPiece(int x, int y) {
		if(x > 7 || x < 0 || y > 7 || y < 0)
			return "OOB";
		
		return board.get(x).get(y).getActionCommand();
	}
	
	public JLabel turnLabel(String s, int x, int y) {
		label = new JLabel(s);
		label.setBounds(x,y,150,50);
		label.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		
		return label;
	}
	
	public JButton resetButton(JFrame thisF, int x, int y) {
		JButton reset = new JButton("RESET");
		reset.setBounds(x,y,100,50);
		reset.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				f.dispose();
				if(!thisF.equals(null))
					thisF.dispose();
				instance = null;
				Board.getInstance().createBoard();
		    }
		});
		
		return reset;
	}
	
	public void changeTurn() {
		if(label.getText().equals("(White's turn)"))
			label.setText("(Black's turn)");
		else
			label.setText("(White's turn)");
	}
	
	public void printBoard() {
		for(Piece i : board.get(0))
		{
			System.out.print('|');

			if(i.getActionCommand().equals(""))
				System.out.print(" ");
			else
				System.out.print(i.getActionCommand());
		}
		System.out.println('|');
		
		for(Piece i : board.get(1))
		{
			System.out.print('|');

			if(i.getActionCommand().equals(""))
				System.out.print(" ");
			else
				System.out.print(i.getActionCommand());
		}
		System.out.println('|');
		
		for(int i = 2; i < BOARD_SIZE - 2; i++)
		{
			for(Piece j : board.get(i))
			{
				System.out.print("|");
				
				if(j.getActionCommand().equals(""))
					System.out.print(" ");
				else
					System.out.print(j.getActionCommand());
				
			}
			System.out.println('|');
		}

		for(Piece i : board.get(6))
		{
			System.out.print('|');
			
			if(i.getActionCommand().equals(""))
				System.out.print(" ");
			else
				System.out.print(i.getActionCommand());
		}
		System.out.println('|');
		
		for(Piece i : board.get(7))
		{
			System.out.print('|');

			if(i.getActionCommand().equals(""))
				System.out.print(" ");
			else
				System.out.print(i.getActionCommand());
		}
		System.out.println('|');
	}
}
