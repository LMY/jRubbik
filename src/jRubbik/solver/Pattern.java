package jRubbik.solver;

import jRubbik.moves.IMove;
import jRubbik.state.CubeState;

public interface Pattern {
	public IMove matches(CubeState state);
}
