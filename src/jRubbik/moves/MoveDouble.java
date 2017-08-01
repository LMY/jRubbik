package jRubbik.moves;

import jRubbik.constants.Color;
import jRubbik.state.CubeState;
import jRubbik.state.OrientatonState;

public class MoveDouble extends FlyWeightMove {

	public MoveDouble(Color dir, int reps) {
		super(dir, reps);
	}

	@Override
	protected String[] getArrayNames()  { return BasicMoves.NAMES_DOUBLE; }
	@Override
	protected IMove[] getArrayNormal()  { return BasicMoves.ALL_DOUBLE; }
	@Override
	protected IMove[] getArrayInverse() { return BasicMoves.ALL_DOUBLE_INV; }
	@Override
	protected IMove[] getArrayDouble()  { return BasicMoves.ALL_DOUBLE2; }
	
	@Override
	public int length() {
		return 2;
	}

	@Override
	public int length_htm() {
		return getReps()==2?4:2;
	}
	
	@Override
	public void apply(CubeState state) {
		
		final Color dir = getDir();
		final int reps = getReps();
		
		final IMove facemove = BasicMoves.color2simpleMove(getDir().opposite(), reps);
		final IMove orientmove = BasicMoves.color2orientationMove(getDir(), reps);
		
		facemove.apply(state);
		(dir == Color.WHITE || dir == Color.ORANGE || dir == Color.BLUE ? orientmove.reverse() : orientmove).apply(state);
	}
	
	@Override
	public IMove orient(OrientatonState state) {
		return BasicMoves.color2doubleMove(state.get(getDir()), getReps());
	}
}
