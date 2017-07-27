package jRubbik.solver;

import java.util.ArrayList;
import java.util.List;

import jRubbik.moves.Algorithm;
import jRubbik.moves.IMove;
import jRubbik.moves.MoveNull;
import jRubbik.state.CubeState;

public class Library {

	public List<IMove> algorithms;
	public List<Pattern> patterns;
	
	public Library()
	{
		reset();
	}
	
	public IMove matches(CubeState state)
	{
		for (int i=0, imax=algorithms.size(); i<imax; i++)
		{
			final IMove alg = algorithms.get(i);
			final Pattern pattern = patterns.get(i);
			
			if (pattern == null || alg == null)
				continue;

			// if matches
			final IMove auf = pattern.matches(state);
			
			if (auf != null) {
				if (auf == MoveNull.NULL)	// without auf, simply return the algorithm
					return alg;		
				else						// with auf, add auf sequence and then algorithm
				{						
					final Algorithm retalg = new Algorithm();
					retalg.addMove(auf);
					retalg.addMove(alg);
					return retalg;
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
	
	public void addPLLAlgorithm(IMove alg) {
		algorithms.add(alg);
		patterns.add(PatternPLL.create(alg));
	}
	
	public void addOLLAlgorithm(IMove alg) {
		algorithms.add(alg);
		patterns.add(PatternOLL.create(alg));
	}

	public void addF2LAlgorithm(IMove alg) {
		algorithms.add(alg);
		patterns.add(PatternF2L.create(alg));
	}
}
