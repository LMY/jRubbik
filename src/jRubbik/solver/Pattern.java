package jRubbik.solver;

import jRubbik.moves.IMove;
import jRubbik.moves.NullMove;
import jRubbik.state.CubeState;

public class Pattern {

	public static int NOT_SET = -1;
	
	private CubeState pattern;
	
	public Pattern(CubeState pattern)
	{
		this.pattern = pattern;
	}
	
	
	public boolean matches(CubeState state)
	{
		int[] pe = pattern.getEdges();
		int[] pc = pattern.getCorners();
		int[] pse = pattern.getState_edges();
		int[] psc = pattern.getState_corners();
		
		int[] se = state.getEdges();
		int[] sc = state.getCorners();
		int[] sse = state.getState_edges();
		int[] ssc = state.getState_corners();
		
		for (int i=0; i<pe.length; i++) {
			if (pe[i] != NOT_SET && pe[i] != se[i])
				return false;
			if (pse[i] != NOT_SET && pse[i] != sse[se[i]])
				return false;
		}
		
		for (int i=0; i<pc.length; i++) {
			if (pc[i] != NOT_SET && pc[i] != sc[i])
				return false;
			if (psc[i] != NOT_SET && psc[i] != ssc[sc[i]])
				return false;
		}
		
		return true;
	}
	
	// returns AUF sequence or null if no match
	public IMove getAdjMatch(CubeState state, IMove auf)
	{
		if (matches(state))
			return NullMove.NULL;
		
		if (matches(auf.get(state)))
			return auf;
		
		IMove twice = auf.times(2);
		if (matches(twice.get(state)))
			return twice;
		
		IMove rev = auf.reverse();
		if (matches(rev.get(state)))
			return rev;		
		
		return null;
	}
	

	public static Pattern fromState(CubeState state)
	{	
		return new Pattern(state.clone());
		
//		int[] se = state.getEdges();
//		int[] sc = state.getCorners();
//		int[] sse = state.getState_edges();
//		int[] ssc = state.getState_corners();
//		
//		CubeState solved = new CubeState();
//		int[] solved_e = solved.getEdges();
//		int[] solved_c = solved.getCorners();
//		int[] solved_se = solved.getState_edges();
//		int[] solved_sc = solved.getState_corners();
//		
//		for (int i=0; i<solved_e.length; i++) {
//			if (se[i] != solved_e[i])
//				solved_e[i] = NOT_SET;
//				
//			if (sse[se[i]] != solved_se[i])
//				solved_se[i] = NOT_SET;
//		}
//		
//		for (int i=0; i<solved_c.length; i++) {
//			if (sc[i] != solved_c[i])
//				solved_c[i] = NOT_SET;
//				
//			if (ssc[sc[i]] != solved_sc[i])
//				solved_sc[i] = NOT_SET;
//		}
//		
//		Pattern ret = new Pattern(new CubeState(solved_e, solved_c, solved_se, solved_sc));
//		
////		System.out.println("FROM: ");
////		CubeDisplayer.display(state);
////		System.out.println("Pattern: ");
////		CubeDisplayer.display(ret.pattern);
////		System.out.println();
////		System.out.println();System.out.println();
//		
//		return ret;
	}
}
