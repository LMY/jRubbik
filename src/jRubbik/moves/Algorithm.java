package jRubbik.moves;

import java.util.ArrayList;
import java.util.List;

import jRubbik.state.CubeState;

public class Algorithm extends IMove {

	private List<IMove> moves;
	
	public Algorithm()
	{
		this(new ArrayList<IMove>());
	}
	
	public Algorithm(List<IMove> moves)
	{
		this.moves = moves;
	} 

//	public Algorithm(IMove[] iMoves) {
//		moves = new ArrayList<IMove>();
//		
//		for (IMove m : moves)
//			moves.add(m);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("(");
		boolean first = true;
		
		for (IMove m : moves) {	
			if (!first) {
				sb.append(" ");
			}
			first = false;
			sb.append(m.toString());
		}
		
		sb.append(")");
		
		return sb.toString();
	}
	

	
	public void addMove(IMove move) { moves.add(move); }

	public List<IMove> getMoves() {
		return moves;
	}

	@Override
	public IMove reverse() {
		Algorithm rev = new Algorithm();
		
		for (int i=moves.size()-1; i>=0; i--)
			rev.addMove(moves.get(i).reverse());
		
		return rev;
	}

	@Override
	public void apply(CubeState state) {
		
		
		for (IMove m : moves)
			m.apply(state);
	}
	
	
	@Override
	public IMove times(int n) {
		if (n < -1)
			return null;	// invalid argument, but I don't want this method to "throws Exception"
		if (n == -1)
			return reverse();
		if (n == 0)
			return NullMove.NULL;
		if (n == 1)
			return this;
		
		Algorithm rev = new Algorithm();
		
		for (int i=moves.size()-1; i>=0; i--)
			rev.addMove(moves.get(i).times(n));
		
		return rev;
	}

	@Override
	public int length() {
		int x = 0;
		
		for (IMove m : moves)
			x += m.length();
			
		return x;
	}

	@Override
	public int length_htm() {
		int x = 0;
		
		for (IMove m : moves)
			x += m.length_htm();
			
		return x;
	}


}
