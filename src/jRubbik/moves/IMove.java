package jRubbik.moves;

import jRubbik.state.CubeState;
import jRubbik.state.OrientatonState;

public abstract class IMove {
	
	public CubeState get() {
		return get(null);
	}
	
	public CubeState get(final CubeState input) {
		
		final CubeState output = input == null? new CubeState() : input.clone();
		apply(output);
		return output;
	}

	public abstract void apply(CubeState state);
	
	public abstract IMove reverse();
	public abstract IMove times(int n);
	public abstract int length();
	public abstract int length_htm();
	
	public abstract IMove orient(OrientatonState state);
}
