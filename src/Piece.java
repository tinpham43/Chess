import javax.swing.JButton;

public class Piece extends JButton {

	private int xPiece;
	private int yPiece;

	public Piece() {
		super();
		xPiece = 0;
		yPiece = 0;
	}
	
	public Piece(String s) {
		super(s);
		xPiece = 0;
		yPiece = 0;
	}
	
	public Piece(String s, int newX, int newY) {
		super(s);
		xPiece = newX;
		yPiece = newY;
	}
	
	public int getXPiece() {
		return xPiece;
	}
	
	public int getYPiece() {
		return yPiece;
	}
}
