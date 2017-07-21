package jRubbik.constants;

public enum Color {

	RED, ORANGE, YELLOW, WHITE, GREEN, BLUE, INVALID; 
	
	public final static Color[] ALL = { RED, ORANGE, YELLOW, WHITE, GREEN, BLUE };
	
	
	private final static String[] names = {  "RED", "ORANGE", "YELLOW", "WHITE", "GREEN", "BLUE", "INVALID" };
	public final static String[] getNames() { return names; }
	public String getName() { return names[ordinal()]; }
	
	public static Color create(int ordinal) { return Color.values()[ordinal]; }

	public static Color create(String s)
	{
		for (int i=0; i<names.length; i++)
			if (s.equalsIgnoreCase(names[i]))
				return create(i);
		return INVALID;
	}
	
	/**
	 * The color opposite to this.
	 * TODO: move into Constants
	 */
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

	/**
	 * in an orientation (front, up) returns the color to the right
	 * returns the color to the right if up is up and front = this
	 * @param up
	 * @return
	 */
	public Color next(Color up) {
		boolean inverse = up == WHITE | up == BLUE | up == ORANGE;
		
		final Color[] order =
				up == YELLOW || up == WHITE ? Constants.COLOR_ORDER[0] :
				up == GREEN || up == BLUE ? Constants.COLOR_ORDER[1] :
				/* up == RED || up == ORANGE ? */ Constants.COLOR_ORDER[2];
		
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
	
	/**
	 * Convert to java.awt.Color, for display
	 */
	public java.awt.Color toAwtColor() {
		switch (this) {
			case RED: return java.awt.Color.RED;
			case ORANGE: return java.awt.Color.MAGENTA;
			case YELLOW: return java.awt.Color.YELLOW;
			case WHITE: return java.awt.Color.WHITE;
			case GREEN: return java.awt.Color.GREEN;
			case BLUE: return java.awt.Color.BLUE;
			default: return java.awt.Color.BLACK;
		}
	}
			
	/**
	 * Convert to char, for display
	 */
	public char toChar() {
		switch (this) {
			case RED: return 'r';
			case ORANGE: return 'o';
			case YELLOW: return 'y';
			case WHITE: return 'w';
			case GREEN: return 'g';
			case BLUE: return 'b';
			default: return '?';
		}
	}
}
