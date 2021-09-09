import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Pieces {
	
	private static boolean isLifted = false;
	private static boolean checkered = false;
	private static JButton liftedPiece = new JButton();
	private static ActionListener actionListener;
	
	public Pieces() {
		actionListener = new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				JButton piece = (JButton)actionEvent.getSource();
				
				if(!isLifted)
				{
					piece.setEnabled(false);
					liftedPiece = piece;
					isLifted = true;
				}
				else
				{
					String pieceString = piece.getActionCommand();
					Color pieceColor = piece.getForeground();
					piece.setText(liftedPiece.getActionCommand());
					piece.setForeground(liftedPiece.getForeground());
					liftedPiece.setEnabled(true); 
					liftedPiece.setText(pieceString);
					liftedPiece.setForeground(pieceColor);
					isLifted = false;
				}
		    }
		};
	}
	
	public void setButtonParameters(JButton button, ActionListener actionListener, String str)
	{
		if(str.contentEquals("white"))
			button.setForeground(Color.white);
		else
			button.setForeground(Color.black);

		if(checkered)
			button.setBackground(new Color(160,180,250));
		else
			button.setBackground(new Color(200,200,250));
		
		checkered = !checkered;
		
		button.addActionListener(actionListener);
	}
	
	public JButton getPiece(String piece, int x, int y, String color)
	{
		JButton button = new JButton(piece);
		button.setBounds(x,y,50,50);
		setButtonParameters(button, actionListener, color);
		return button;
	}
}
