package jRubbik.solver;

import jRubbik.moves.IMove;
import jRubbik.state.CubeState;

public interface Pattern {
	public boolean matches(CubeState state);
	public IMove matchesAUF(CubeState state);
}
