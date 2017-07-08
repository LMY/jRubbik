package jRubbik.constants;


public enum Direction {

	FRONT, BACK, UP, DOWN, RIGHT, LEFT, INVALID;

	private static final String[] names = {  "FRONT", "BACK", "UP", "DOWN", "RIGHT", "LEFT", "INVALID" };
//		public static final String[] getNames() { return names; }
//		public String getName() { return names[ordinal()]; }
	
	private static Direction create(int ordinal) { return Direction.values()[ordinal]; }

	public static Direction create(String s)
	{
		for (int i=0; i<names.length; i++)
			if (s.equalsIgnoreCase(names[i]))
				return create(i);
		return INVALID;
	}
}
