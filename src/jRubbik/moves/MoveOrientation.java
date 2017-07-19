package jRubbik.moves;

import jRubbik.constants.Color;
import jRubbik.constants.Constants;
import jRubbik.state.CubeState;
import jRubbik.state.OrientatonState;

public class MoveOrientation extends IMove{
	
	private Color dir;
	private boolean reverse;
	private int reps;
	
	public MoveOrientation(Color dir, int reverse) {
		this.dir = dir;
		this.reverse = reverse==1;
		this.reps = reverse==2?2:1;
	}

	public Color getDir() {
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
		return Constants.RotMoveNames[dir.toInt()]+(reps==2?"2":reverse?"'":"");
	}

	
	@Override
	public void apply(CubeState state) {
		
		OrientatonState op = state.getOrientation();
		Color front = op.getFront();
		Color up = op.getUp();
		
		if (dir == Color.WHITE || dir == Color.YELLOW) {
			op.setFront(reps == 2 ? front.opposite() : front.next(reverse ? up.opposite() : up));
		}
		else if (dir == Color.RED || dir == Color.ORANGE) {
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
		return reps==2 ? this :
			reverse ? BasicMoves.ALL_ORIENTATION[dir.toInt()] : BasicMoves.ALL_ORIENTATION_INV[dir.toInt()];
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
