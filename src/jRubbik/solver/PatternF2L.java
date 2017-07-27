package jRubbik.solver;

import jRubbik.constants.Color;
import jRubbik.moves.IMove;
import jRubbik.state.CubeDisplayer;
import jRubbik.state.CubeState;

public class PatternF2L implements Pattern  {

	public PatternF2L()
	{
		
	}
	
	
	@Override
	public IMove matches(CubeState state) {
		return null;
	}
	
	
	public static Pattern create(IMove alg)
	{	
		final IMove rev = alg.reverse();
		final CubeState state = rev.get();
		final Color up = state.getOrientation().getUp();
	
		final Color[][] colors = CubeDisplayer.getColors(state);
		final Color[] crown = CubeDisplayer.getCrown(colors, up);
		final Color[] face = CubeDisplayer.getFace(colors, up);

		final boolean[] pface = new boolean[face.length];
		final boolean[] pcorona = new boolean[crown.length];
		
		for (int i=0; i<face.length; i++)
			pface[i] = (face[i] == up);
		
		for (int i=0; i<crown.length; i++)
			pcorona[i] = (crown[i] == up);

		return new PatternF2L();
	}
}
