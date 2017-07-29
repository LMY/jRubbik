package jRubbik.solver;

import java.util.ArrayList;
import java.util.List;

import jRubbik.constants.Color;
import jRubbik.moves.BasicMoves;
import jRubbik.moves.IMove;
import jRubbik.moves.MoveDescription;
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
	private Library OLLs;
	private Library F2Ls;
	
	
	public SolverCFOP()
	{
		PLLs = new Library();
		for (IMove x : BasicMoves.PLLs)
			PLLs.addPLLAlgorithm(x);

		OLLs = new Library();
		for (IMove x : BasicMoves.OLLs)
			OLLs.addOLLAlgorithm(x);
		
		F2Ls = new Library();
		for (IMove x : BasicMoves.F2Ls)
			F2Ls.addF2LAlgorithm(x);
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
	public List<IMove> solve(CubeState state) {
		
		final List<IMove> ret = new ArrayList<IMove>();
		ret.add(MoveDescription.createMoveMessage("solve start"));
		
//		inspect(state);
//		solveCross(state);
		
		
		final IMove ollauf = solveOLL_internal(state);
		if (ollauf == null) {
			ret.add(MoveDescription.createMoveMessage("OLL Fail"));
			return ret;
		}
		ret.add(ollauf);
		state = ollauf.get(state);
		
		
		final IMove pllmove = solvePLL_internal(state);
		if (pllmove == null) {
			ret.add(MoveDescription.createMoveMessage("PLL Fail"));
			return ret;
		}
		ret.add(pllmove);
		state = pllmove.get(state);
		
		
		final IMove aufmove = solveAUF_internal(state);
		if (aufmove == null) {
			ret.add(MoveDescription.createMoveMessage("AUF Fail"));
			return ret;
		}
		ret.add(aufmove);
		
//		System.out.println("match for: "+ollauf.toString()+"\t"+pllmove.toString()+"\tAUF: "+aufmove.toString()+"\t"+(aufmove.get(state).isSolved()?"solved":"FAIL"));

		return ret;
	}
	
	
	private IMove solveF2L_internal(CubeState state) {
		return F2Ls.matches(state);
	}

	private IMove solveOLL_internal(CubeState state) {
		return OLLs.matches(state);
	}

	private IMove solvePLL_internal(CubeState state) {
		return PLLs.matches(state);
	}
	
	public List<IMove> solveF2L(CubeState state) {
		
		final List<IMove> ret = new ArrayList<IMove>();
		
		final IMove move = solveF2L_internal(state);
		ret.add(move != null ? move : MoveDescription.createMoveMessage("F2L Fail"));

		return ret;
	}

	public List<IMove> solveOLL(CubeState state) {

		final List<IMove> ret = new ArrayList<IMove>();
		
		final IMove move = solveOLL_internal(state);
		ret.add(move != null ? move : MoveDescription.createMoveMessage("OLL Fail"));

		return ret;
	}

	public List<IMove> solvePLL(CubeState state) {
		
		final List<IMove> ret = new ArrayList<IMove>();
		
		final IMove move = solvePLL_internal(state);
		ret.add(move != null ? move : MoveDescription.createMoveMessage("PLL Fail"));

		return ret;
	}
	
	private IMove solveAUF_internal(CubeState state) {
		
		final IMove move = BasicMoves.color2simpleMove(Color.YELLOW, 0);
		
		for (int i=0; i<4; i++) {
			final IMove mm = move.times(i);
			if (mm.get(state).isSolved())
				return mm;
		}
		
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
