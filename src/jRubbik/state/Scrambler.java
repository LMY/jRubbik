package jRubbik.state;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jRubbik.constants.Color;
import jRubbik.moves.Algorithm;
import jRubbik.moves.Move;

public class Scrambler {

	private static final int LEN = 20;
	
	private Random random;
	
	public Scrambler()
	{
		reset();
	}
	
	public void reset()
	{
		random = new Random();
	}
	
	public Algorithm scramble()
	{
		return scramble(LEN);
	}
	
	public Algorithm scramble(int len)
	{
		Algorithm ret = new Algorithm();
		
		List<Integer> possible = new ArrayList<Integer>();
		for (int i=0; i<6; i++)
			possible.add(i);
		
		int last = -1;
		
		for (int i=0; i<len; i++)
		{
			int this_move;
			
			int m = random.nextInt(possible.size());
			this_move = possible.get(m);
			
			possible.remove(m);
			if (last >= 0)
				possible.add(last);
			
			ret.addMove(new Move(Color.create(this_move), random.nextInt(3)));
			
			last = this_move;
		}
		
		return ret;		
	}
	
	public static void scramble(CubeState state)
	{
		new Scrambler().scramble().apply(state);
	}
	
	
	public static CubeState getScrambledCube()
	{
		return getScrambledCube(LEN);
	}
	
	public static CubeState getScrambledCube(int len)
	{
		CubeState state = new CubeState();
		new Scrambler().scramble(len).apply(state);
		return state;
	}
}
