import java.awt.event.*;
import javax.swing.*;

public class Main
{
	static JFrame f = new JFrame();
	
	public static void main(String[] args)
	{
		Board.getInstance().printBoard();

		JButton reset = new JButton("RESET");
		reset.setBounds(0,0,100,50);
		reset.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				f.dispose();
				f = new JFrame();
				f.add(reset);
				Board.getInstance().createBoard(f);
		    }
		});
		
		f.add(reset);
		Board.getInstance().createBoard(f);
	}
}
