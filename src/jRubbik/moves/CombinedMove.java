package jRubbik.moves;

import jRubbik.constants.Color;
import jRubbik.state.CubeState;

public class CombinedMove extends IMove {

//	public static IMove MOVE_M = new CombinedMove(Move.MOVE_R, new o)
	
	private IMove facemove;
	private IMove orient;
	
	
	public CombinedMove(IMove facemove, IMove orient) {
		this.facemove = facemove;
		this.orient = orient;
	}

	@Override
	public void apply(CubeState state) {
		facemove.apply(state);
		orient.apply(state);
	}

	@Override
	public IMove reverse() {
		return new CombinedMove(facemove.reverse(), orient.reverse());
	}

	@Override
	public IMove times(int n) {
		return new CombinedMove(facemove.times(n), orient.times(n));
	}

	@Override
	public int length() {
		return facemove.length()+orient.length();
	}

	@Override
	public int length_htm() {
		return facemove.length_htm()+orient.length_htm();
	}

}
