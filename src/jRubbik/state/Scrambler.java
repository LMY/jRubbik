package jRubbik.state;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jRubbik.moves.Algorithm;
import jRubbik.moves.BasicMoves;
import jRubbik.moves.IMove;

public class Scrambler {

	private final static int LEN = 20;
	
	private Random random;
	
	public Scrambler()
	{
		reset();
	}
	
	public void reset()
	{
		random = new Random();
	}
	
	public IMove scramble()
	{
		return scramble(LEN);
	}
	
	public IMove scramble(int len)
	{
		final Algorithm ret = new Algorithm();
		
		final List<Integer> possible = new ArrayList<Integer>();
		for (int i=0; i<6; i++)
			possible.add(i);
		
		int last = -1;
		
		for (int i=0; i<len; i++)
		{
			final int m = random.nextInt(possible.size());
			final int this_move = possible.get(m);
			
			possible.remove(m);
			if (last >= 0)
				possible.add(last);
			
			final int mod = random.nextInt(3);
			ret.addMove((mod == 2 ? BasicMoves.PUBLIC_ALL_SIMPLE2 : mod == 1 ? BasicMoves.PUBLIC_ALL_SIMPLE_INV : BasicMoves.PUBLIC_ALL_SIMPLE)[this_move]);
			
			last = this_move;
		}
		
		return ret;		
	}
	
	public static IMove getScramble() {
		return getScramble(LEN);
	}
	
	public static IMove getScramble(int len) { 
		return new Scrambler().scramble(len);
	}
}
