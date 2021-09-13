import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;

public class Game {
	
	private static final Color GREY = new Color(150,150,150);
	private Color original;
	private boolean whiteTurn;
	private boolean isLifted;
	private boolean checkered;
	private int count;
	private Piece liftedPiece;
	private ActionListener actionListener;
	
	public Game() {
		whiteTurn = true;
		isLifted = false;
		checkered = false;
		count = 0;
		liftedPiece = new Piece();
		actionListener = new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				Piece piece = (Piece)actionEvent.getSource();
				String pieceString = piece.getActionCommand();
				Color pieceColor = piece.getForeground();
				
				if(!isLifted && !pieceString.equals("") && 
				   ((pieceColor.equals(Color.white) && whiteTurn == true) ||
					(pieceColor.equals(Color.black) && whiteTurn == false)))
				{
					original = piece.getBackground();
					piece.setBackground(GREY);
					liftedPiece = piece;
					
					isLifted = true;
				}
				else if(isLifted && piece.equals(liftedPiece))
				{
					liftedPiece.setBackground(original);
					isLifted = false;
				}
				else if(isLifted && !pieceString.equals("") &&
						pieceColor.equals(liftedPiece.getForeground()))
				{
					liftedPiece.setBackground(original);
					original = piece.getBackground();
					piece.setBackground(GREY);
					liftedPiece = piece;
				}
				else if(isLifted && MovePiece.validMove(liftedPiece, piece))
				{
						/*if(liftedPiece.getActionCommand().equals("K") && 
						   piece.getActionCommand().equals("R"))
							castle();
						else
						{*/
					Color liftedPieceColor = liftedPiece.getForeground();
					piece.setText(liftedPiece.getActionCommand());
					piece.setForeground(liftedPieceColor);
					liftedPiece.setText("");
					Board.getInstance().updateHeapMap();
						//}
						//Board.getInstance().printBoard();

					if(Board.getInstance().isCheck(liftedPieceColor))
					{
						liftedPiece.setText(piece.getActionCommand());
						piece.setText(pieceString);
						piece.setForeground(pieceColor);
						Board.getInstance().updateHeapMap();
						JOptionPane.showMessageDialog(new JFrame(), "In check!");
					}
					else
					{
						Color oppositeColor;
						if(liftedPieceColor.equals(Color.black))
							oppositeColor = Color.white;
						else
							oppositeColor = Color.black;

						if(Board.getInstance().isCheck(oppositeColor))
						{
							if(Board.getInstance().isCheckMate(oppositeColor))
								gameOver(oppositeColor);
							else
								JOptionPane.showMessageDialog(new JFrame(), "Check!");
						}
						
						checkConditions(piece);
						liftedPiece.setBackground(original);
						Board.getInstance().changeTurn();
						whiteTurn = !whiteTurn;
						isLifted = false;
					}
				}
				else if(isLifted)
					JOptionPane.showMessageDialog(new JFrame(), "Invalid move.");
		    }
		};
	}
	
	private void gameOver(Color oppositeColor)
	{
		JFrame restartFrame = new JFrame();
		JLabel label = new JLabel("Checkmate!");
		label.setBounds(50, 0, 150, 50);
		label.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		restartFrame.add(label);
		if(oppositeColor.equals(Color.black))
			label = new JLabel("White wins!");
		else
			label = new JLabel("Black wins!");
		label.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		label.setBounds(50, 50, 150, 20);
		restartFrame.add(label);
		restartFrame.add(Board.getInstance().resetButton(restartFrame, 55, 100));
		restartFrame.setTitle("Game Over");
		restartFrame.setSize(225, 215);
		restartFrame.setLayout(null);
		restartFrame.setVisible(true);
		restartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	private void castle()
	{
		/*piece.setText(liftedPiece.getActionCommand());
		piece.setForeground(liftedPiece.getForeground());
		liftedPiece.setText("");
		liftedPiece.setBackground(original);
		Board.getInstance().movePiece(liftedPiece.getXPiece(), liftedPiece.getYPiece(), 
									  piece.getXPiece(), piece.getYPiece());
		Board.getInstance().changeTurn();*/;
	}
	
	private void checkConditions(Piece piece)
	{
		if(piece.getActionCommand().equals("K"))
			piece.moveKing(true);
		else if(piece.getActionCommand().equals("R"))
			piece.moveRook(true);
		
		boolean temp1 = piece.hasKingMoved();
		boolean temp2 = piece.hasRookMoved();
		piece.moveKing(liftedPiece.hasKingMoved());
		piece.moveRook(liftedPiece.hasRookMoved());
		liftedPiece.moveKing(temp1);
		liftedPiece.moveRook(temp2);
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
