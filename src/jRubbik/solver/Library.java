package jRubbik.solver;

import java.util.ArrayList;
import java.util.List;

import jRubbik.moves.Algorithm;
import jRubbik.moves.IMove;
import jRubbik.moves.NullMove;
import jRubbik.state.CubeState;

public class Library {

	public List<IMove> algorithms;
	public List<Pattern> patterns;
	
	public Library()
	{
		reset();
	}
	
	public IMove matches(CubeState state, IMove up)
	{
		for (int i=0, imax=algorithms.size(); i<imax; i++)
		{
			IMove alg = algorithms.get(i);
			Pattern pattern = patterns.get(i);
			
			if (pattern == null || alg == null)
				continue;

			// for each pattern of this alg
			for (int k=0; k<4; k++) {
				final IMove auf = pattern.getAdjMatch(up.times(k).get(state), up);
				
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
		patterns = new ArrayList<Pattern>();
	}
	
	public void addAlgorithm(IMove alg) {
			
		algorithms.add(alg);
		final IMove revAlg = alg.reverse();
		patterns.add(Pattern.createPLL_fromState(revAlg.get()));
	}	
}
