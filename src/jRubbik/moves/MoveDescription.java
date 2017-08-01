package jRubbik.moves;

import jRubbik.state.CubeState;
import jRubbik.state.OrientatonState;

public class MoveDescription extends IMove {

	private IMove move;
	private String description;
	private boolean suppress_original;
	
	public MoveDescription(IMove move, String description, boolean suppress_original)
	{
		this.move = move;
		this.description = description;
		this.suppress_original = suppress_original;
	}
	
	@Override
	public void apply(CubeState state) {
		move.apply(state);
	}

	@Override
	public IMove reverse() {
		
		final String newdescription = description.isEmpty() ? "" :
										description.endsWith("'") ? description.substring(0, description.length()-1) : description+"'";
		
		return new MoveDescription(move.reverse(), newdescription, suppress_original);
	}

	@Override
	public IMove times(int n) {
		return new MoveDescription(move.times(n), description+n, suppress_original);
	}

	@Override
	public int length() {
		return move.length();
	}

	@Override
	public int length_htm() {
		return move.length_htm();
	}

	@Override
	public String toString()
	{
		return description + (suppress_original ? "" : ":"+move.toString());
	}
	
	
	public static IMove createMoveMessage(String message)
	{
		return new MoveDescription(MoveNull.NULL, message, true);
	}
	
	@Override
	public IMove orient(OrientatonState state) {
		return new MoveDescription(move.orient(state), description+"~", suppress_original);
	}
}
