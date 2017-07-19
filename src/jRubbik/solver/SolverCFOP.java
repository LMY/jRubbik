package jRubbik.solver;

import jRubbik.moves.Algorithm;
import jRubbik.moves.BasicMoves;
import jRubbik.moves.IMove;
import jRubbik.moves.NullMove;
import jRubbik.state.CubeState;

public class SolverCFOP implements Solver {

	public boolean ok_cross;
	public boolean ok_f2l_1;
	public boolean ok_f2l_2;
	public boolean ok_f2l_3;
	public boolean ok_f2l_4;
	
	public boolean ok_oll;
	public boolean ok_pll;
	
	
	private Library PLLs;
	
	
	
	public SolverCFOP()
	{
		PLLs = new Library();
		for (IMove x : BasicMoves.PLLs)
				PLLs.addAlgorithm(x);
	}
	
	
//	private void inspect(CubeState state)
//	{
//		ok_cross = false;
//		
//		ok_f2l_1 = false;		
//		ok_f2l_2 = false;
//		ok_f2l_3 = false;
//		ok_f2l_4 = false;
//		
//		ok_oll = false;
//		ok_pll = false;
//	}
	
	
	@Override
	public IMove solve(CubeState state) {
		
		state.resetOrientation();
		
		final Algorithm ret = new Algorithm();
		
//		inspect(state);
//		solveCross(state);
		
		System.out.println("solving:");
//		CubeDisplayer.display(state);
		
		IMove pllmove = PLLs.matches(state, BasicMoves.MOVE_U);

		if (pllmove == null)
			System.out.println("NO MATCH SORRY);");
		else {
			ret.addMove(pllmove);
			System.out.println("match for: "+pllmove.toString());
			System.out.println("che porta a:");
			CubeState PLLdone = pllmove.get(state);
//			CubeDisplayer.display(PLLdone);
			
			IMove aufmove = auf(PLLdone, BasicMoves.MOVE_U);
			System.out.println("AUF:");
//			CubeDisplayer.display(aufmove.get(PLLdone));
			ret.addMove(aufmove);
		}
		
//		for (IMove move : BasicMoves.ALL_MIDDLE)
//			System.out.println(""+move.toString()+" "+move.reverse().toString());
//		for (IMove move : BasicMoves.ALL_DOUBLE_INV)
//			System.out.println(""+move.toString()+" "+move.reverse().toString());
//		for (IMove move : BasicMoves.ALL_DOUBLE2)
//			System.out.println(""+move.toString()+" "+move.reverse().toString());
		return ret;
	}
	
	

	private IMove auf(CubeState pLLdone, IMove mOVE_U) {
		if (pLLdone.isSolved())
			return NullMove.NULL;
		if (mOVE_U.get(pLLdone).isSolved())
			return mOVE_U;
		
		IMove twice =  mOVE_U.times(2);
		if (twice.get(pLLdone).isSolved())
			return twice;
		
		IMove rev =  mOVE_U.reverse();
		if (rev.get(pLLdone).isSolved())
			return rev;
		
		return null;
	}


//	public Algorithm solveCross(CubeState state)
//	{
//		int e1 = 0;
//		int e2 = 1;
//		int e3 = 2;
//		int e4 = 3;
//		
//		crossInsert(state, e1);
//		crossInsert(state, e2);
//		crossInsert(state, e3);
//		crossInsert(state, e4);
//		
//		return null;
//	}
//	
//	public Algorithm crossInsert(CubeState state, int e)
//	{
//		int[] edges = state.getEdges();
//		int[] states = state.getState_edges();
//		
//		int pos = -1;
//		for (int i=0; i<edges.length; i++)
//			if (edges[i] == e) {
//				pos = i;
//				break;
//			}
//		
//		boolean good_edge = !Constants.isEdgeBad(edges[pos], states[edges[pos]]);
//		
//		System.out.println("Edge "+e+" is in position "+pos);
//		System.out.println((good_edge?"good":"bad")+" edge");
//		
//		return null;
//	}
//
//	
//	public static int fact(int n)
//	{
//		int res = 1;
//		
//		while (n > 0)
//			res *= n--;
//		
//		return res;
//	}
//	
//	public static int[][] getPerms(int n)
//	{
//		int[][] perms = new int[fact(n)][];
//		
//		
//		
//		return perms;
//	}
//	
//	public static void fill(int[] n, int starti)
//	{
//	}
		
	
	public final static int[][] cdowns = {
	    {0, 1, 4, 5},
	    {2, 3, 6, 7},
	    {4, 5, 6, 7},
	    {0, 1, 2, 3},
	    {1, 5, 6, 2},
	    {0, 4, 7, 3}
	};
	public final static int[][] cups = {
	    {2, 3, 6, 7},
	    {0, 1, 4, 5},
	    {0, 1, 2, 3},
	    {4, 5, 6, 7},
	    {0, 4, 7, 3},
	    {1, 5, 6, 2},
	};
	public final static int[][] edowns = {
	    {1, 4, 5, 9},
	    {3, 6, 7, 11},
	    {8, 9, 10, 11},
	    {0, 1, 2, 3},
	    {2, 5, 6, 10},
	    {0, 4, 7, 8},
	};
	
	public final static int[][] eups = {
	    {3, 6, 7, 11},
	    {1, 4, 5, 9},
	    {0, 1, 2, 3},
	    {8, 9, 10, 11},
	    {0, 4, 7, 8},
	    {2, 5, 6, 10},
	};
	
	public final static int[][] emids = {
	    {0, 2, 8, 10},
	    {0, 2, 8, 10},
	    {4, 5, 6, 7},
	    {4, 5, 6, 7},
	    {1, 3, 9, 11},
	    {1, 3, 9, 11},
	};
	
	public static int getposC(int[] corners, int idx) {
		for (int i=0; i<8; i++)
			if (corners[i] == idx)
				return i;
		return -1;
	}
	
	public static int getPosE(int[] edges, int idx) {
		for (int i=0; i<8; i++)
			if (edges[i] == idx)
				return i;
		return -1;
	}
	
	public static boolean isUpC(int pos)		{ return pos>=4; }
	public static boolean isDownC(int pos)		{ return pos<4; }
	public static boolean isUpE(int pos)		{ return pos>=8; }
	public static boolean isMiddleE(int pos)	{ return pos>=4 && pos<8; }
	public static boolean isDownE(int pos)		{ return pos<4; }
}
