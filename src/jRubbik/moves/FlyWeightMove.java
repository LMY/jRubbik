package jRubbik.moves;

import jRubbik.constants.Color;
import jRubbik.state.CubeState;

public abstract class FlyWeightMove extends IMove {

	private Color dir;
	private int reps;
	
	
	public FlyWeightMove(Color dir, int reps) {
		this.dir = dir;
		this.reps = reps;
	}
	
	public abstract void apply(CubeState state);
	public abstract int length();
	public abstract int length_htm();

	protected abstract String[] getArrayNames();
	protected abstract IMove[] getArrayNormal();
	protected abstract IMove[] getArrayInverse();
	protected abstract IMove[] getArrayDouble();
	
	
	@Override
	public String toString() {
		return getArrayNames()[dir.toInt()]+(reps==2?"2":reps==3?"'":"");
	}
	
	@Override
	public IMove reverse() {
		return reps==2? this :
				reps==3 ? getArrayNormal()[dir.toInt()] : getArrayInverse()[dir.toInt()];
	}

	@Override
	public IMove times(int n) {
		
		if (n < 0) n = 3 - ((-n) & 3);	// while (n < 0) n+=4;
		else if (n > 3) n &= 3; 		// if (n > 3) n %= 4;
		
		switch (n) {
			case 0: return MoveNull.NULL;
			case 1: return this;
			case 2: return reps == 2 ? MoveNull.NULL : getArrayDouble()[dir.toInt()];
			default:
					return reverse();
		}
	}
	
	public Color getDir() {
		return dir;
	}

	public boolean isReverse() {
		return reps==3;
	}

	public int getReps() {
		return reps;
	}
}
