package jRubbik.solver;

import jRubbik.moves.IMove;
import jRubbik.state.CubeState;

public interface Solver {
	public IMove solve(CubeState state);
}
