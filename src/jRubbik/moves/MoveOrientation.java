package jRubbik.moves;

import jRubbik.constants.Color;
import jRubbik.state.CubeState;
import jRubbik.state.OrientatonState;

public class MoveOrientation extends FlyWeightMove {
	
	public MoveOrientation(Color dir, int reps) {
		super(dir, reps);
	}

	@Override
	protected String[] getArrayNames()  { return BasicMoves.NAMES_ORIENTATION; }
	@Override
	protected IMove[] getArrayNormal()  { return BasicMoves.ALL_ORIENTATION; }
	@Override
	protected IMove[] getArrayInverse() { return BasicMoves.ALL_ORIENTATION_INV; }
	@Override
	protected IMove[] getArrayDouble()  { return BasicMoves.ALL_ORIENTATION2; }
	
	@Override
	public int length() {
		return 0;
	}

	@Override
	public int length_htm() {
		return 0;
	}
	
	@Override
	public void apply(CubeState state) {
		final Color dir = getDir();
		final int reps = getReps();
		
		final OrientatonState op = state.getOrientation();
		final Color front = op.getFront();
		final Color up = op.getUp();
		final boolean reverse = isReverse();
		
		if (dir == Color.WHITE || dir == Color.YELLOW) {
			op.setFront(reps == 2 ? front.opposite() : front.next(reverse ? up.opposite() : up));
		}
		else if (dir == Color.BLUE || dir == Color.GREEN) {
			if (reps == 2) {
				op.setFront(front.opposite());
				op.setUp(up.opposite());
			}
			else {
				op.setFront(reverse ? up : up.opposite());
				op.setUp(reverse ? front.opposite() : front);
			}
		}
		else /*if (dir == MOVE_Z)*/ {
			op.setUp(reps == 2 ? up.opposite() : up.next(reverse ? front.opposite() : front));
		}
	}
}
