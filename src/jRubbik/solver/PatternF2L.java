package jRubbik.solver;

import jRubbik.constants.Color;
import jRubbik.moves.IMove;
import jRubbik.state.CubeDisplayer;
import jRubbik.state.CubeState;
import jRubbik.state.OrientatonState;

public class PatternF2L implements Pattern  {

	private IMove alg;
	
	public PatternF2L(IMove alg)
	{
		this.alg = alg;
	}
	
	
	@Override
	public IMove matches(CubeState state) {
		
		final OrientatonState orient = state.getOrientation().clone();
		final CubeState resstate = alg.get(state.clone());			// possibly sets a new orient
		resstate.setOrientation(orient);							// restore the original orient
		
		final Color[][] colors = CubeDisplayer.getColors(resstate);
		
		final Color colorDown = orient.getDown();
		final Color colorFront = orient.getFront();
		final Color colorRight = orient.getRight();
		
		final Color[] downface = CubeDisplayer.getFace(colors, colorDown);
		final Color[] frontface = CubeDisplayer.getFace(colors, colorFront);
		final Color[] rightface = CubeDisplayer.getFace(colors, colorRight);

		if (downface[2] == colorDown && frontface[8] == colorFront && rightface[6] == colorRight && // corner
			frontface[5] == colorFront && rightface[3] == colorRight)								// edge
		
				return alg;
		
		else
			return null;
	}
	
	
	public static Pattern create(IMove alg)
	{	
		return new PatternF2L(alg);
	}
}
