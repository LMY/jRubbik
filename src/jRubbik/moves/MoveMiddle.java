package jRubbik.moves;

import jRubbik.constants.Color;
import jRubbik.state.CubeState;

public class MoveMiddle extends FlyWeightMove {

	public MoveMiddle(Color dir, int reps) {
		super(dir, reps);
	}

	@Override
	protected String[] getArrayNames()  { return BasicMoves.NAMES_MIDDLE; }
	@Override
	protected IMove[] getArrayNormal()  { return BasicMoves.ALL_MIDDLE; }
	@Override
	protected IMove[] getArrayInverse() { return BasicMoves.ALL_MIDDLE_INV; }
	@Override
	protected IMove[] getArrayDouble()  { return BasicMoves.ALL_MIDDLE2; }
	
	@Override
	public int length() {
		return 2;
//		return getReps()==2 ? 4 : 2;		
	}

	@Override
	public int length_htm() {
		return getReps()==2 ? 4 : 2;
	}
	
	@Override
	public void apply(CubeState state) {
		final Color dir = getDir();
		final int reps = getReps();
		
		for (int r=0;r<(reps==2?2:1); r++)
			if (dir == Color.GREEN || dir == Color.BLUE) {
				(isReverse() ? BasicMoves.MOVE_Ri : BasicMoves.MOVE_R).apply(state);
				(isReverse() ? BasicMoves.MOVE_L : BasicMoves.MOVE_Li).apply(state);
				(isReverse() ? BasicMoves.MOVE_x : BasicMoves.MOVE_xi).apply(state);
			}
			else if (dir == Color.RED || dir == Color.ORANGE) {
				(isReverse() ? BasicMoves.MOVE_F : BasicMoves.MOVE_Fi).apply(state);
				(isReverse() ? BasicMoves.MOVE_Bi : BasicMoves.MOVE_B).apply(state);
				(isReverse() ? BasicMoves.MOVE_zi : BasicMoves.MOVE_z).apply(state);
			}
			else /*if (dir == Color.WHITE || dir == Color.YELLOW)*/ {
				(isReverse() ? BasicMoves.MOVE_Ui : BasicMoves.MOVE_U).apply(state);
				(isReverse() ? BasicMoves.MOVE_D : BasicMoves.MOVE_Di).apply(state);
				(isReverse() ? BasicMoves.MOVE_y : BasicMoves.MOVE_yi).apply(state);
			}		
	}
}
