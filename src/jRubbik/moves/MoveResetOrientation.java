package jRubbik.moves;

import java.util.Stack;

import jRubbik.state.CubeState;
import jRubbik.state.OrientatonState;

public class MoveResetOrientation extends IMove {

	@Override
	public void apply(CubeState state) {
		orientations.push(state.getOrientation());
		state.resetOrientation();
	}

	private Stack<OrientatonState> orientations = new Stack<OrientatonState>();
	
	@Override
	public IMove reverse() {
		return new MoveApplyOrientation(orientations.pop());
	}

	@Override
	public IMove times(int n) {
		return this;
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
