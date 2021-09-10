import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Game {
	
	static final Color GREY = new Color(150,150,150);
	static Color original;
	private static boolean playerTurn = true;
	private static boolean isLifted = false;
	private static boolean checkered = false;
	private static int count = 0;
	private static JButton liftedPiece = new JButton();
	private static ActionListener actionListener;
	private static Game instance = null;
	
	private Game() {
		actionListener = new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				JButton piece = (JButton)actionEvent.getSource();
				
				if(!isLifted && !piece.getActionCommand().equals("") && 
					((piece.getForeground() == Color.white && playerTurn == true) ||
					(piece.getForeground() == Color.black && playerTurn == false)))
				{
					original = piece.getBackground();
					piece.setBackground(GREY);
					liftedPiece = piece;
					isLifted = true;
				}
				else if(isLifted)
				{
					piece.setText(liftedPiece.getActionCommand());
					piece.setForeground(liftedPiece.getForeground());
					liftedPiece.setBackground(original);
					
					if(!piece.equals(liftedPiece))
					{
						liftedPiece.setText("");
						playerTurn = !playerTurn;
					}
					
					isLifted = false;
				}
		    }
		};
	}
	
	public static Game getInstance() {
		if(instance == null)
			instance = new Game();
		
		return instance;
	}
	
	public void resetGame() {
		instance = new Game();
	}
	
	public void setPieceParameters(JButton button, ActionListener actionListener, String str)
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
			button.setBackground(new Color(200,200,250));
		
		button.addActionListener(actionListener);
	}
	
	public JButton getPiece(String piece, int x, int y, String color)
	{
		JButton button = new JButton(piece);
		button.setBounds(x,y,50,50);
		setPieceParameters(button, actionListener, color);
		return button;
	}
}
