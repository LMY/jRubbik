package jRubbik.solver;

import jRubbik.moves.Algorithm;
import jRubbik.moves.IMove;
import jRubbik.moves.Move;
import jRubbik.moves.MoveParser;
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
		PLLs.addAlgorithm(MoveParser.parseSequence("Aperm1", "(R U')(R U)(R U)(R U') R' U' R2"));
		PLLs.addAlgorithm(MoveParser.parseSequence("Aperm2", "R2 U R U R' U' R' U' R' U R'"));
		
		PLLs.addAlgorithm(MoveParser.parseSequence("Zperm", "U R' U' R U' R U R U' R' U R U R2 U' R' U"));
		
		PLLs.addAlgorithm(MoveParser.parseSequence("Rperm1", "(L U2 L' U2)(L F')(L' U' L U)(L F) L2 U"));
		
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
		
		
		Algorithm ret = new Algorithm();
		
//		inspect(state);
//		solveCross(state);
		
		System.out.println("solving:");
//		CubeDisplayer.display(state);
		
		IMove pllmove = PLLs.matches(state);

		if (pllmove == null)
			System.out.println("NO MATCH SORRY);");
		else {
			ret.addMove(pllmove);
			System.out.println("match for: "+pllmove.toString());
			System.out.println("che porta a:");
			CubeState PLLdone = pllmove.get(state);
//			CubeDisplayer.display(PLLdone);
			
			IMove aufmove = auf(PLLdone, Move.MOVE_U);
			System.out.println("AUF:");
//			CubeDisplayer.display(aufmove.get(PLLdone));
			ret.addMove(aufmove);
		}
		
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
}
