import javax.swing.JButton;

@SuppressWarnings("serial")
public class Piece extends JButton {

	private int xPiece;
	private int yPiece;
	private boolean whiteHeatMap;
	private boolean blackHeatMap;
	private boolean kingMoved;
	private boolean rookMoved;
	
	public Piece() {
		super();
		xPiece = 0;
		yPiece = 0;
		whiteHeatMap = false;
		blackHeatMap = false;
		kingMoved = false;
		rookMoved = false;
	}
	
	public Piece(String s) {
		super(s);
		xPiece = 0;
		yPiece = 0;
		whiteHeatMap = false;
		blackHeatMap = false;
		kingMoved = false;
		rookMoved = false;
	}
	
	public Piece(String s, int newX, int newY) {
		super(s);
		xPiece = newX;
		yPiece = newY;
		whiteHeatMap = false;
		blackHeatMap = false;
		kingMoved = false;
		rookMoved = false;
	}
	
	public int getXPiece() {
		return xPiece;
	}
	
	public int getYPiece() {
		return yPiece;
	}
	
	public void updateWhiteMap(boolean bool) {
		whiteHeatMap = bool;
	}
	
	public void updateBlackMap(boolean bool) {
		blackHeatMap = bool;
	}
	
	public boolean isWhiteMap() {
		return whiteHeatMap;
	}
	
	public boolean isBlackMap() {
		return blackHeatMap;
	}
	
	public void moveKing(boolean bool) {
		kingMoved = bool;
	}
	
	public boolean hasKingMoved() {
		return kingMoved;
	}
	
	public void moveRook(boolean bool) {
		rookMoved = bool;
	}
	
	public boolean hasRookMoved() {
		return rookMoved;
	}
}
