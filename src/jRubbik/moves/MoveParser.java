package jRubbik.moves;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MoveParser {

	public static IMove parse(String name, String string) {
		return new MoveDescription(parse(string), name, false);
	}
	
	private static final IMove[][] PARSE_COLLECTIONS = { 
			BasicMoves.ALL_SIMPLE, BasicMoves.ALL_SIMPLE_INV, BasicMoves.ALL_SIMPLE2,
			BasicMoves.ALL_ORIENTATION, BasicMoves.ALL_ORIENTATION_INV, BasicMoves.ALL_ORIENTATION2,
			BasicMoves.ALL_MIDDLE, BasicMoves.ALL_MIDDLE_INV, BasicMoves.ALL_MIDDLE2,
			BasicMoves.ALL_DOUBLE, BasicMoves.ALL_DOUBLE_INV, BasicMoves.ALL_DOUBLE2 };

	
	public static IMove parse(String string) {
		
		if (string.isEmpty())
			return NullMove.NULL;
		
		// do not use BasicMoves.ALL_COLLECTIONS! otherwise in BasicMoves you can't call parse/parseSequence because BasicMoves.ALL_COLLECTIONS would still be null
		for (IMove[] collection : PARSE_COLLECTIONS)
			for (IMove move : collection)
				if (string.equals(move.toString()))
					return move;
		
		return null; //throw
	}
	
	public static IMove parseSequence(String name, String string) {
		return new MoveDescription(parseSequence(string), name, false);
	}
	
	public static IMove parseLine(String string) {
		return parseLine(string, true);
	}
	public static IMove parseLine(String string, boolean suppress) {
		
		final StringTokenizer tok = new StringTokenizer(string, ";");
		final String name = tok.nextToken();
		
		return new MoveDescription(parseSequence(tok.hasMoreTokens() ? tok.nextToken() : ""), name, suppress);
	}
	
	public static IMove parseSequence(String string) {
		
//		string = string.replaceAll("\\[\\]", "");
		
		final String[] parts = string.split("[,\\s()]");
		final List<IMove> moves = new ArrayList<IMove>();
		
		for (int i=0; i<parts.length; i++)
		{
			parts[i] = parts[i].trim();
			
			if (parts[i].isEmpty())
				continue;				
				
			moves.add(parse(parts[i]));
		}
		
		return new Algorithm(moves);
	}
}
