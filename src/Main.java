import java.awt.event.*;
import javax.swing.*;

public class Main
{
	static JFrame f = new JFrame();
	
	public static void main(String[] args)
	{
		Board board = Board.getInstance();
		board.printBoard();
		
		JButton reset = new JButton("RESET");
		reset.setBounds(0,0,100,50);
		reset.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				f = new JFrame();
				board.createBoard(f);
		    }
		});
		
		f.add(reset);
		board.createBoard(f);
	}
}
