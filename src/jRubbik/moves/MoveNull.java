package jRubbik.moves;

import jRubbik.state.CubeState;
import jRubbik.state.OrientatonState;

public class MoveNull extends IMove {

	public final static IMove NULL = new MoveNull();
	
	private MoveNull() {}
	

	@Override
	public IMove reverse() {
		return NULL;
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public IMove times(int n) {
		return NULL;
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
	public void apply(CubeState state) {
	}


	@Override
	public IMove orient(OrientatonState state) {
		return this;
	}
}
