import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;

public class Game {
	
	private static final Color GREY = new Color(150,150,150);
	private Color original;
	private boolean playerTurn;
	private boolean isLifted;
	private boolean checkered;
	private int count;
	private Piece liftedPiece;
	private ActionListener actionListener;
	
	public Game() {
		playerTurn = true;
		isLifted = false;
		checkered = false;
		count = 0;
		liftedPiece = new Piece();
		actionListener = new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				Piece piece = (Piece)actionEvent.getSource();
				
				if(!isLifted && !piece.getActionCommand().equals("") && 
				   ((piece.getForeground() == Color.white && playerTurn == true) ||
					(piece.getForeground() == Color.black && playerTurn == false)))
				{
					original = piece.getBackground();
					piece.setBackground(GREY);
					liftedPiece = piece;
					MovePiece.getInstance().setPiece(liftedPiece);
					
					isLifted = true;
				}
				else if(isLifted && piece.equals(liftedPiece))
				{
					liftedPiece.setBackground(original);
					isLifted = false;
				}
				else if(isLifted && MovePiece.getInstance().validMove(piece))
				{
					piece.setText(liftedPiece.getActionCommand());
					piece.setForeground(liftedPiece.getForeground());
					liftedPiece.setText("");
					liftedPiece.setBackground(original);
					playerTurn = !playerTurn;
					Board.getInstance().changeTurn();
					
					isLifted = false;
				}
				else if(isLifted)
				{
					JOptionPane.showMessageDialog(new JFrame(), "Invalid move.");
				}
		    }
		};
	}
	
	public void setPieceParameters(Piece button, ActionListener actionListener, String str)
	{
		if(str.contentEquals("white"))
			button.setForeground(Color.white);
		else
			button.setForeground(Color.black);
		
		if(count++ == 8)
		{
			checkered = !checkered;
			count = 1;
		}
		
		if(checkered = !checkered)
			button.setBackground(new Color(160,180,250));
		else
			button.setBackground(new Color(190,190,250));
		
		button.addActionListener(actionListener);
	}
	
	public Piece getPiece(String piece, int x, int y, int xCoord, int yCoord, String color)
	{
		Piece button = new Piece(piece, x, y);
		button.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		button.setBounds(xCoord,yCoord,50,50);
		setPieceParameters(button, actionListener, color);
		return button;
	}
}
