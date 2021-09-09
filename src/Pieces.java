import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Pieces {
	
	private static boolean isLifted = false;
	private static JButton liftedPiece = new JButton();
	private ActionListener actionListener;
	
	public Pieces() {
		actionListener = new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				JButton button = (JButton)actionEvent.getSource();
				
				if(!isLifted)
				{
					button.setEnabled(false);
					liftedPiece = button;
					isLifted = true;
				}
				else
				{
					String original = button.getActionCommand();
					button.setText(liftedPiece.getActionCommand());
					liftedPiece.setEnabled(true); 
					liftedPiece.setText(original);
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

		button.setBackground(new Color(150,150,150));
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
