package jRubbik.moves;

import jRubbik.state.CubeState;
import jRubbik.state.OrientatonState;

public class MoveResetOrientation extends IMove {

	public final static IMove INSTANCE = new MoveResetOrientation();
	
	private MoveResetOrientation() {}
	
	@Override
	public String toString() {
		return "$";
	}
	
	@Override
	public void apply(CubeState state) {
		state.resetOrientation();
	}
	
	@Override
	public IMove reverse() {
		return this;
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

	@Override
	public IMove orient(OrientatonState state) {
		return this; //TODO
	}
}
