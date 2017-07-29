package jRubbik.solver;

import jRubbik.constants.Color;
import jRubbik.moves.BasicMoves;
import jRubbik.moves.IMove;
import jRubbik.moves.MoveNull;
import jRubbik.state.CubeDisplayer;
import jRubbik.state.CubeState;

public class PatternOLL implements Pattern {

	private boolean[] pface;
	private boolean[] pcrown;
	
	public PatternOLL(boolean[] pface, boolean[] pcrown)
	{
		this.pface = pface;
		this.pcrown = pcrown;
	}
	
	@Override
	public boolean matches(CubeState state)
	{
		final Color up = state.getOrientation().getUp();
		final Color[][] colors = CubeDisplayer.getColors(state);
		
		final Color[] cface = CubeDisplayer.getFace(colors, Color.YELLOW);
		final Color[] ccrown = CubeDisplayer.getCrown(colors, Color.YELLOW);

		final boolean[] bface = toBoolArray(cface, up);
		final boolean[] bcrown = toBoolArray(ccrown, up);
		
		return (arrayEquals(bface, pface) && arrayEquals(bcrown, pcrown));
	}

	@Override
	public IMove matchesAUF(CubeState state)
	{
		final Color up = state.getOrientation().getUp();
		final Color[][] colors = CubeDisplayer.getColors(state);
		
		final Color[] cface = CubeDisplayer.getFace(colors, Color.YELLOW);
		final Color[] ccrown = CubeDisplayer.getCrown(colors, Color.YELLOW);

		final boolean[] bface = toBoolArray(cface, up);
		final boolean[] bcrown = toBoolArray(ccrown, up);
		
		final IMove auf = BasicMoves.color2simpleMove(Color.YELLOW, 0);
		
		
		if (arrayEquals(bface, pface) && arrayEquals(bcrown, pcrown))
			return MoveNull.NULL;
		
		rotateCrown(bcrown);
		rotate(bface, 1);
		
		if (arrayEquals(bface, pface) && arrayEquals(bcrown, pcrown))
			return auf;
		
		rotateCrown(bcrown);
		rotate(bface, 1);
		
		if (arrayEquals(bface, pface) && arrayEquals(bcrown, pcrown))
			return auf.times(2);
		
		rotateCrown(bcrown);
		rotate(bface, 1);
		
		if (arrayEquals(bface, pface) && arrayEquals(bcrown, pcrown))
			return auf.reverse();
		
		return null;
	}

	private static boolean arrayEquals(boolean[] a, boolean[] b) {
		if (a.length != b.length)
			return false;
		
		for (int i=0; i<a.length; i++)
			if (a[i] != b[i])
				return false;
			
		return true;
	}
	
	private static boolean[] toBoolArray(Color[] array, Color up) {
		final boolean[] ret = new boolean[array.length];
		for (int i=0; i<ret.length; i++)
			ret[i] = (array[i]==up);
		return ret;
	}
	
	/**
	 * swap two elements in an array
	 */
	private static void swap(boolean[] colors, int i1, int i2) {
		final boolean temp = colors[i1];
		colors[i1] = colors[i2];
		colors[i2] = temp;
	}

	/**
	 * rotate an array of 9 (3x3) q * 90 deg.
	 * q=3 is inverse, q=2 is mirror, q=0 does nothing
	 * this function accepts any int, even negative and >=4 values
	 * @param colors
	 * @param q
	 */
	private static void rotate(boolean[] colors, int q) {

		if (q < 0) q = 3 - ((-q) & 3);	// while (n < 0) n+=4;
		else if (q > 3) q &= 3; 		// if (n > 3) n %= 4;

		if (q == 0)
			;
		else if (q == 1) {
			swap(colors, 1, 3);
			swap(colors, 3, 7);
			swap(colors, 7, 5);

			swap(colors, 0, 6);
			swap(colors, 6, 8);
			swap(colors, 8, 2);
		}
		else if (q == 2) {
			swap(colors, 0, 8);			
			swap(colors, 1, 7);
			swap(colors, 2, 6);
			swap(colors, 3, 5);
		}
		else {	//if (q == 3)
			swap(colors, 7, 5);
			swap(colors, 3, 7);
			swap(colors, 1, 3);

			swap(colors, 8, 2);
			swap(colors, 6, 8);
			swap(colors, 0, 6);
		}
	}
	
	private void rotateCrown(boolean[] bcrown) {
		
		boolean[] ret = new boolean[bcrown.length];
		
		for (int i=0; i<bcrown.length; i++)
			ret[i] = bcrown[(i+3) % bcrown.length];
		
		for (int i=0; i<bcrown.length; i++)
			bcrown[i] = ret[i];
		
//		for (int i=0, imax=bcrown.length/3; i<imax; i++)
//		
//		for (int i=0, imax=bcrown.length/3; i<imax; i++)
//			for (int k=0, kmax=bcrown.length/4; k<kmax; k++)
//				swap(bcrown, (3*i+k) % bcrown.length, (3*i+k+n) % bcrown.length);
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

		return new PatternOLL(pface, pcorona);
	}
}
