package jRubbik.moves;

import java.util.ArrayList;
import java.util.List;

import jRubbik.constants.Constants;

public class MoveParser {

	public static final IMove MOVE_M = parseSequence("L' R");
	
	public static IMove parse(String name, String string) {
		return new MoveDescription(parse(string), name);
	}
	
	public static IMove parse(String string) {
		
		int modifiers = 0;
		if (string.endsWith("i") || string.endsWith("'"))
			modifiers = 1;
		else if (string.endsWith("2"))
			modifiers = 2;
		
		return atoMove(""+string.charAt(0), modifiers);
	}
	
	public static IMove parseSequence(String name, String string) {
		return new MoveDescription(parseSequence(string), name);
	}
	
	public static IMove parseSequence(String string) {
		
		String[] parts = string.split("[,\\s()]");
		List<IMove> moves = new ArrayList<IMove>();
		
		for (int i=0; i<parts.length; i++)
		{
			parts[i] = parts[i].trim();
			
			if (parts[i].isEmpty())
				continue;				
				
			moves.add(parse(parts[i]));
		}
		
		return new Algorithm(moves);
	}
	


	private static IMove atoMove(final String name, int modifiers) {

		for (int i = 0; i < Constants.KubeMoveNames.length; ++i)
			if (name.equals(Constants.KubeMoveNames[i]))
				return new Move(i, modifiers);

		for (int i = 0; i < MoveOrientation.RotMoveNames.length; ++i)
			if (name.equals(MoveOrientation.RotMoveNames[i]))
				return new MoveOrientation(i, modifiers);
		
		if (name.equals("M"))
			return modifiers < 0 ? MOVE_M.reverse() : modifiers==0?MOVE_M:MOVE_M.times(modifiers);
		
		return null; // throw
	}
}
