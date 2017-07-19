package jRubbik.moves;

import jRubbik.state.CubeState;

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
		return new MoveDescription(move.reverse(), description+"'", suppress_original);
	}

	@Override
	public IMove times(int n) {
		return new MoveDescription(move.reverse(), description+"2", suppress_original);
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
		return description+(suppress_original?"":":"+move.toString());
	}
}
