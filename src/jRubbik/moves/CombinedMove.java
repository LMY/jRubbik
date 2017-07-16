package jRubbik.moves;

import jRubbik.state.CubeState;

public class CombinedMove extends IMove {

	private IMove facemove1;
	private IMove facemove2;
	private IMove orient;
	
	
	public CombinedMove(IMove facemove1, IMove facemove2, IMove orient) {
		this.facemove1 = facemove1;
		this.facemove2 = facemove2;
		this.orient = orient;
	}

	@Override
	public void apply(CubeState state) {
		if (facemove1 != null) facemove1.apply(state);
		if (facemove2 != null) facemove2.apply(state);
		if (orient != null) orient.apply(state);
	}

	@Override
	public IMove reverse() {
		return new CombinedMove(facemove1.reverse(), facemove2.reverse(), orient.reverse());
	}

	@Override
	public IMove times(int n) {
		return new CombinedMove(facemove1.times(n), facemove2.times(n), orient.times(n));
	}

	@Override
	public int length() {
		return facemove1.length()+facemove2.length()+orient.length();
	}

	@Override
	public int length_htm() {
		return facemove1.length_htm()+facemove2.length_htm()+orient.length_htm();
	}

}
