package jRubbik.moves;

import jRubbik.constants.Color;
import jRubbik.state.CubeState;
import jRubbik.state.OrientatonState;

public class MoveOrientation extends IMove{
	
	public static final int MOVE_Z = 0;
	public static final int MOVE_X = 1;
	public static final int MOVE_Y = 2; 
	public static final int MOVE_INVALID = 255; // will cause crashes; and this is intended (-fno-exceptions)
	

	final public static String[] RotMoveNames = { "z", "x", "y" };
	
	private int dir;
	private boolean reverse;
	private int reps;
	
	public MoveOrientation(int dir, int reverse) {
		this.dir = dir;
		this.reverse = reverse==1;
		this.reps = reverse==2?2:1;
	}

	public int getDir() {
		return dir;
	}

	public boolean isReverse() {
		return reverse;
	}

	public int getReps() {
		return reps;
	}
	@Override
	public String toString() {
		return RotMoveNames[dir]+(reps==2?"2":reverse?"'":"");
	}

	
	@Override
	public void apply(CubeState state) {
		
		OrientatonState op = state.getOrientation();
		Color front = op.getFront();
		Color up = op.getUp();
		
		if (dir == MOVE_Y) {
			op.setFront(reps == 2 ? front.opposite() : front.next(reverse ? up.opposite() : up));
		}
		else if (dir == MOVE_X) {
			if (reps == 2) {
				op.setFront(front.opposite());
				op.setUp(up.opposite());
			}
			else {
				Color newfront = reverse ? up : up.opposite();
				Color newup = reverse ? front.opposite() : front;
				
				op.setFront(newfront);
				op.setUp(newup);
			}
		}
		else /*if (dir == MOVE_Z)*/ {
			op.setUp(reps == 2 ? up.opposite() : up.next(reverse ? front.opposite() : front));
		}
		
//		state.setOrientation(op);
	}

	@Override
	public IMove reverse() {
		return new MoveOrientation(dir, reps==2?2 :  reverse?0:1 );
	}

	@Override
	public IMove times(int n) {
		while (n < 0)
			n += 4;
		n %= 4;
		
		if (n == 0)
			return NullMove.NULL;
		if (n == 1)
			return this;
		if (n == 2) {
			if (reps == 2)
				return NullMove.NULL;
			else
				return  new MoveOrientation(dir, 2);
		}
		//if (n == 3)
			return reverse();
	}

	@Override
	public int length() {
		return 0;
	}

	@Override
	public int length_htm() {
		return 0;
	}	
}
