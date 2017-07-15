package jRubbik.moves;

import jRubbik.constants.Color;
import jRubbik.state.CubeState;
import jRubbik.state.OrientatonState;

public class MoveApplyOrientation extends IMove {

	private Color up;
	private Color front;
	
	public MoveApplyOrientation(Color up, Color front) {
		this.up = up;
		this.front = front;
	}
	
	public MoveApplyOrientation(OrientatonState state) {
		this(state.getUp(), state.getFront());
	}
	
	@Override
	public void apply(CubeState state) {
		state.getOrientation().setUp(up);
		state.getOrientation().setFront(front);
	}

	@Override
	public IMove reverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMove times(int n) {
		return null;
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
