package jRubbik.moves;

import jRubbik.state.CubeState;

public class NullMove extends IMove {

	public final static IMove NULL = new NullMove();
	
	private NullMove() {}
	

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
}
