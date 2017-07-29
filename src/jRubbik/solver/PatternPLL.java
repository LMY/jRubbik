package jRubbik.solver;

import jRubbik.constants.Color;
import jRubbik.moves.BasicMoves;
import jRubbik.moves.IMove;
import jRubbik.moves.MoveNull;
import jRubbik.state.CubeDisplayer;
import jRubbik.state.CubeState;

public class PatternPLL implements Pattern {
	private int[][] pattern;
	
	private PatternPLL(int[][] pattern)
	{
		this.pattern = pattern;
	}
	
	@Override
	public boolean matches(CubeState state)
	{
		final Color[][] colors = CubeDisplayer.getColors(state);
		final Color[] crown = CubeDisplayer.getCrown(colors, Color.YELLOW);

		final Color value = crown[(pattern[0][0])%12];
		boolean ok = true;
		
		for (int k=1; k<3; k++)
			if (value != crown[(pattern[0][k])%12]) {
				ok = false;
				break;
			}
			
		if (ok)		
			for (int p=1; p<4; p++) {
				Color value2 = crown[(pattern[p][0])%12];
				boolean ok2 = true;
				
				for (int k=1; k<3; k++)
					if (value2 != crown[(pattern[p][k])%12]) {
						ok2 = false;
						break;
					}
				
				if (!ok2)
					continue;
			
				return true;
	
			}
	
		return false;
	}
	
	@Override
	public IMove matchesAUF(CubeState state)
	{
		final IMove auf = BasicMoves.color2simpleMove(Color.YELLOW, 0);
	
		final Color[][] colors = CubeDisplayer.getColors(state);
		final Color[] crown = CubeDisplayer.getCrown(colors, Color.YELLOW);
		
		for (int shift=0; shift<12; shift += 3) {
	
			final Color value = crown[(pattern[0][0] + shift)%12];
			boolean ok = true;
			
			for (int k=1; k<3; k++)
				if (value != crown[(pattern[0][k] + shift)%12]) {
					ok = false;
					break;
				}
				
			if (!ok)
				continue;
			
			for (int p=1; p<4; p++) {
				Color value2 = crown[(pattern[p][0] + shift)%12];
				boolean ok2 = true;
				
				for (int k=1; k<3; k++)
					if (value2 != crown[(pattern[p][k] + shift)%12]) {
						ok2 = false;
						break;
					}
				
				if (!ok2)
					continue;
			
				if (shift == 0) return MoveNull.NULL;
				else if (shift == 3) return auf;
				else if (shift == 6) return auf.times(2);
				else /*if (shift == 6)*/ return auf.reverse();
			}
		}
	
		return null;
	}
	
	public static Pattern create(IMove alg)
	{	
		final IMove rev = alg.reverse();
		final CubeState state = rev.get();
		final Color up = state.getOrientation().getUp();
	
		final Color[][] colors = CubeDisplayer.getColors(state);
		final Color[] crown = CubeDisplayer.getCrown(colors, up);

		final int[][] pos = new int[4][3];
//		final int[] idx = { 0, 0, 0, 0 };
		
		int posidx = 0;
//		for (int i=0; i<crown.length; i++)
//			for (int k=0; k<4; k++)
//				if (idx[k] == 0 || crown[pos[k][0]] == crown[i])
//					pos[k][idx[k]++] = i;

		for (int i=0; i<crown.length; i++) {
			if (crown[i] == Color.INVALID)
				continue;
			
			int idx = 0;
			pos[posidx][idx++] = i;
			
			for (int k=i+1; k<crown.length; k++) {
				if (crown[k] == Color.INVALID)
					continue;
				
				if (crown[i] == crown[k]) {
					pos[posidx][idx++] = k;
					crown[k] = Color.INVALID;
				}
			}
			
			posidx++;
		}
				
		return new PatternPLL(pos);
	}
}
