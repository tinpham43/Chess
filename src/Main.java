//import java.util.*;
import javax.swing.*;
//import java.awt.event.*;
//import java.awt.*;

public class Main
{
	static final int BOARD_SIZE = 8;
	
	public static void main(String[] args)
	{
		Board board = Board.getInstance();
		board.printBoard();
		
		/*System.out.print("Please pick your piece: ");
		Scanner in = new Scanner(System.in);
		String userChoice = in.nextLine();
		if(userChoice.equals("R"))
			System.out.println("yo");*/
		
		JFrame f = new JFrame();//creating instance of JFrame
		Pieces pieces = new Pieces();
		
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
}
