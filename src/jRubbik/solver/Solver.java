package jRubbik.solver;

import java.util.List;

import jRubbik.moves.IMove;
import jRubbik.state.CubeState;

public interface Solver {
	public  List<IMove> solve(CubeState state);
}
