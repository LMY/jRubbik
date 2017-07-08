package jRubbik.moves;

import jRubbik.state.CubeState;

public class MoveDescription extends IMove {

	private IMove move;
	private String description;
	
	public MoveDescription(IMove move, String description)
	{
		this.move = move;
		this.description = description;
	}
	
	@Override
	public void apply(CubeState state) {
		move.apply(state);
	}

	@Override
	public IMove reverse() {
		return new MoveDescription(move.reverse(), description+"-rev");
	}

	@Override
	public IMove times(int n) {
		return new MoveDescription(move.reverse(), description+"2");
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
		return description+":"+move.toString();
	}
}
