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
		return new CombinedMove(facemove1 != null ? facemove1.reverse() : null,
								facemove2 != null ? facemove2.reverse() : null,
								orient != null ? orient.reverse() : null);
	}

	@Override
	public IMove times(int n) {
		
		while (n < 0)
			n += 4;
		n %= 4;
		
		if (n == 0)
			return NullMove.NULL;
		if (n == 1)
			return this;
		if (n == 2)
			return NullMove.NULL;
		//if (n == 3)
			return reverse();
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
