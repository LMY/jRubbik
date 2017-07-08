package jRubbik.constants;

public enum Color {

	RED, ORANGE, YELLOW, WHITE, GREEN, BLUE, INVALID; 
	
	public final static Color[] ALL = {RED, ORANGE, YELLOW, WHITE, GREEN, BLUE};
	
	
	private static final String[] names = {  "RED", "ORANGE", "YELLOW", "WHITE", "GREEN", "BLUE", "INVALID" };
	public static final String[] getNames() { return names; }
	public String getName() { return names[ordinal()]; }
	
	public static Color create(int ordinal) { return Color.values()[ordinal]; }

	public static Color create(String s)
	{
		for (int i=0; i<names.length; i++)
			if (s.equalsIgnoreCase(names[i]))
				return create(i);
		return INVALID;
	}
	
	public Color opposite()
	{
		switch (this) {
			case RED: return ORANGE;
			case ORANGE: return RED;
			case YELLOW: return WHITE;
			case WHITE: return YELLOW;
			case GREEN: return BLUE;
			case BLUE: return GREEN;
			default: return INVALID;
		}
	}
	
	public final static Color[][] ORDER = new Color[][]{
			{ RED, GREEN, ORANGE, BLUE },			// X: yellow up
			{ YELLOW, RED, WHITE, ORANGE },			// Y: green up
			{ YELLOW, BLUE, WHITE, GREEN },			// Z: red up
	};
	
	
	// front next up = right
	public Color next(Color up) {
		boolean inverse = up == WHITE | up == BLUE | up == ORANGE;
		
		Color[] order;
		
		if (up == YELLOW || up == WHITE)
			order = ORDER[0];
		else if (up == GREEN || up == BLUE)
			order = ORDER[1];
		else /* (up == RED || up == ORANGE) */
			order = ORDER[2];
		
		return this == order[0] ?
				order[ inverse ? order.length-1 : 1] :
				 this == order[1] ?
						 order[ inverse ? 0 : 2] :
				 this == order[2] ?
						 order[ inverse ? 1 : 3] :
//				 this == order[3] ?							 
						 order[ inverse ? 2 : 0];	
	}
		public int toInt() {
		return ordinal();
	}
	
	public java.awt.Color toAwtColor() {
		switch (this) {
			case RED: return java.awt.Color.RED;
			case ORANGE: return java.awt.Color.ORANGE;
			case YELLOW: return java.awt.Color.YELLOW;
			case WHITE: return java.awt.Color.WHITE;
			case GREEN: return java.awt.Color.GREEN;
			case BLUE: return java.awt.Color.BLUE;
			default: return java.awt.Color.BLACK;
		}
	}
			
	public char toChar() {
		switch (this) {
			case RED: return 'r';
			case ORANGE: return 'o';
			case YELLOW: return 'y';
			case WHITE: return 'w';
			case GREEN: return 'g';
			case BLUE: return 'g';
			default: return '?';
		}
	}
	

//	public static Color whatcolorat(Color who, Color up, Color front) {
//		
//		if (who == up)
//			return Color.YELLOW;
//		if (who == up.opposite())
//			return Color.WHITE;
//		
//		if (who == front)
//			return Color.RED;
//		if (who == front.opposite())
//			return Color.ORANGE;
//		
//		if (who == front.next(up))
//			return Color.GREEN;
//		
//		return Color.BLUE;
//	}
		

}
