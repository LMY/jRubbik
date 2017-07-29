package jRubbik.solver;

import jRubbik.constants.Color;
import jRubbik.moves.BasicMoves;
import jRubbik.moves.IMove;
import jRubbik.moves.MoveNull;
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
	public boolean matches(CubeState state) {
		
		final OrientatonState orient = state.getOrientation().clone();
		final CubeState resstate = alg.get(state);			// possibly sets a new orient
		resstate.setOrientation(orient);					// restore the original orient
		
		final Color[][] colors = CubeDisplayer.getColors(resstate);
		
		final Color[] downface = CubeDisplayer.getFace(colors, Color.WHITE);
		final Color[] frontface = CubeDisplayer.getFace(colors, Color.RED);
		final Color[] rightface = CubeDisplayer.getFace(colors, Color.GREEN);

		return (downface[2] == downface[4] && frontface[8] == frontface[4] && rightface[6] == rightface[4] && // corner
			frontface[5] == frontface[4] && rightface[3] == rightface[4]);									// edge
	}
	
	@Override
	public IMove matchesAUF(CubeState state) {
		
		if (matches(state))
			return MoveNull.NULL;
		
		if (matches(BasicMoves.MOVE_U.get(state)))
			return BasicMoves.MOVE_U;

		if (matches(BasicMoves.MOVE_Ui.get(state)))
			return BasicMoves.MOVE_Ui;
		
		if (matches(BasicMoves.MOVE_U2.get(state)))
			return BasicMoves.MOVE_U2;
		
		return null;
	}
	
	
	public static Pattern create(IMove alg)
	{	
		return new PatternF2L(alg);
	}
}
