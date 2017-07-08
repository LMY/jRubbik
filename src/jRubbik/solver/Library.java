package jRubbik.solver;

import java.util.ArrayList;
import java.util.List;

import jRubbik.moves.Algorithm;
import jRubbik.moves.IMove;
import jRubbik.moves.Move;
import jRubbik.moves.NullMove;
import jRubbik.state.CubeState;

public class Library {

	public List<IMove> algorithms;
	public List<Pattern[]> patterns;
	
	public Library()
	{
		reset();
	}
	
	public IMove matches(CubeState state)
	{
		for (int i=0, imax=algorithms.size(); i<imax; i++)
		{
			IMove alg = algorithms.get(i);
			Pattern[] pattern = patterns.get(i);
			
			if (pattern == null || alg == null)
				continue;

			// for each pattern of this alg
			for (int k=0; k<pattern.length; k++) {
				
				IMove auf = pattern[k].getAdjMatch(state, Move.MOVE_U);
				
				// if matches
				if (auf != null) {
					if (auf == NullMove.NULL)	// without auf, simply return the algorithm
						return alg;		
					else						// with auf, add auf sequence and then algorithm
					{						
						Algorithm retalg = new Algorithm();
						retalg.addMove(auf);
						retalg.addMove(alg);
						return retalg;
					}
				}
			}
		}
		
		// no match
		return null;
	}
	
	public void reset() {
		algorithms = new ArrayList<IMove>();
		patterns = new ArrayList<Pattern[]>();
	}
	
	public void addAlgorithm(IMove alg) {
		algorithms.add(alg);
		patterns.add(createPatterns(alg));
	}
	
	
	private static Pattern[] createPatterns(IMove algorithm)
	{
		IMove move = Move.MOVE_U;
		IMove revAlg = algorithm.reverse();
		
		Pattern[] patterns = new Pattern[4];
		patterns[0] = Pattern.fromState(revAlg.get(move.times(0).get()));
		patterns[1] = Pattern.fromState(revAlg.get(move.times(-1).get()));
		patterns[2] = Pattern.fromState(revAlg.get(move.times(1).get()));
		patterns[3] = Pattern.fromState(revAlg.get(move.times(2).get()));	
		
		return patterns;		
	}
	
	
}
