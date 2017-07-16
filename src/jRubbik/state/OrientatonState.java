package jRubbik.state;

import jRubbik.constants.Color;
import jRubbik.constants.Constants;

public class OrientatonState {

	private Color front;
	private Color up;
	
	public OrientatonState()
	{
		this(Color.RED, Color.YELLOW);
	}
	
	public OrientatonState(Color front, Color up)
	{
		this.front = front;
		this.up = up;
	}
	
	public OrientatonState(OrientatonState orientatonState) {
		this(orientatonState.front, orientatonState.up);
	}

	public OrientatonState clone() {  return new OrientatonState(this); }

	
	
	public void setFront(Color front) {
		this.front = front;
	}

	public void setUp(Color up) {
		this.up = up;
	}
	

	
	
	public Color getFront() { return front; }
	public Color getBack() { return front.opposite(); }
	public Color getUp() { return up; }
	public Color getDown() { return up.opposite(); }
	public Color getRight() { return front.next(up); }
	public Color getLeft() { return getRight().opposite(); }
	
	public Color get(Color direction) {
		switch (direction) {
			case BLUE:
				return getLeft();
			case GREEN:
				return getRight();
	
			case ORANGE:
				return getBack();
			case RED:
				return getFront();
				
			case WHITE:
				return getDown();
			case YELLOW:
				return getUp();
			default:
				return Color.INVALID;
		}
	}

	public Color whereis(Color direction) {
		
		if (direction == up)
			return Color.YELLOW;
		if (direction == up.opposite())
			return Color.WHITE;
		
		if (direction == front)
			return Color.RED;
		if (direction == front.opposite())
			return Color.ORANGE;
		
		if (direction == front.next(up))
			return Color.GREEN;
		
		return Color.BLUE;
	}
	
	

	public int[] edges_permutations(Color dir) {
		return Constants.edges_permutations[get(dir).toInt()];
	}
	
	public int[] corners_permutations(Color dir) { 
		return Constants.corners_permutations[get(dir).toInt()];
	}
	
		public int const_rot_axis(Color dir) {
		return Constants.move_final_rot_axis(get(dir).toInt());
	}

	public boolean inverts_edges(Color dir) {
		final Color where = get(dir);
		
		if (where == Color.RED || where == Color.ORANGE)
			return true;
		
		return false;
	}
	
}
