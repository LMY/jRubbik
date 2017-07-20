package jRubbik.constants;

public class Constants {
	
	final static int CORNER_DFL = 0;
	final static int CORNER_DFR = 1;
	final static int CORNER_DBR = 2;
	final static int CORNER_DBL = 3;
	final static int CORNER_UFL = 4;
	final static int CORNER_UFR = 5;
	final static int CORNER_UBR = 6;
	final static int CORNER_UBL = 7;
	
	final static int[] corners_permF = { CORNER_UFL, CORNER_UFR, CORNER_DFR, CORNER_DFL };
	final static int[] corners_permB = { CORNER_UBR, CORNER_UBL, CORNER_DBL, CORNER_DBR };
	final static int[] corners_permU = { CORNER_UFR, CORNER_UFL, CORNER_UBL, CORNER_UBR };
	final static int[] corners_permD = { CORNER_DFL, CORNER_DFR, CORNER_DBR, CORNER_DBL };
	final static int[] corners_permR = { CORNER_UFR, CORNER_UBR, CORNER_DBR, CORNER_DFR };
	final static int[] corners_permL = { CORNER_UBL, CORNER_UFL, CORNER_DFL, CORNER_DBL };

	public final static int[][] corners_permutations = {
		corners_permF,
		corners_permB,
		corners_permU,
		corners_permD,
		corners_permR,
		corners_permL
	};

	final static int EDGE_SW = 0;
	final static int EDGE_SF = 1;
	final static int EDGE_SE = 2;
	final static int EDGE_SB = 3;
	final static int EDGE_MFW = 4;
	final static int EDGE_MFE = 5;
	final static int EDGE_MBE = 6;
	final static int EDGE_MBW = 7;
	final static int EDGE_NW = 8;
	final static int EDGE_NF = 9;
	final static int EDGE_NE = 10;
	final static int EDGE_NB = 11;

	final static int[] edges_permF = { EDGE_MFW, EDGE_NF,  EDGE_MFE, EDGE_SF };
	final static int[] edges_permB = { EDGE_SB,  EDGE_MBE, EDGE_NB,  EDGE_MBW };
	final static int[] edges_permU = { EDGE_NF,  EDGE_NW,  EDGE_NB,  EDGE_NE };
	final static int[] edges_permD = { EDGE_SW , EDGE_SF,  EDGE_SE,  EDGE_SB };
	final static int[] edges_permR = { EDGE_MFE, EDGE_NE,  EDGE_MBE, EDGE_SE };
	final static int[] edges_permL = { EDGE_MFW, EDGE_SW,  EDGE_MBW, EDGE_NW };
	
	public final static int[][] edges_permutations = {
		edges_permF,
		edges_permB,
		edges_permU,
		edges_permD,
		edges_permR,
		edges_permL
	};
	
	
	// PERMUTATIONS and RUBIK functions
	public static void permutate(int[] data, final int[] perm, boolean inverse)
	{
		if (inverse) {
			final int temp = data[perm[0]];

			for (int i = 0; i<perm.length - 1; i++)
				data[perm[i]] = data[perm[i + 1]];

			data[perm[perm.length - 1]] = temp;
		}
		else {
			final int temp = data[perm[perm.length - 1]];

			for (int i = perm.length - 1; i>0; i--)
				data[perm[i]] = data[perm[i - 1]];

			data[perm[0]] = temp;
		}
	}

	// a rotation keep a state constant, and swaps the other two. states are { 0, 1, 2 } = { U/D, F/B, R/L }
	public static int rotate_corner(int x, int const_rot_axis) {
		if (x == const_rot_axis) return x;

		if (x == 0) return const_rot_axis == 1 ? 2 : 1;
		if (x == 1) return const_rot_axis == 0 ? 2 : 0;
		/*if (x == 2)*/ return const_rot_axis == 1 ? 0 : 1;
	}

	// for a given move, get the state that is left unchanged
	public static int move_final_rot_axis(final int value) {	// final int value =  static_cast<unsigned int>(dir);
		if (value < 2) return 1;		// F, B
		else if (value < 4) return 0;	// U, D
		else return 2;					// R, L
	}
	
	private final static int[][] corners_incommon = new int[][] {
		{ 3, 2, 1, 2,  2, 1, 0, 1 },
		{ 2, 3, 2, 1,  1, 2, 1, 0 },
		{ 1, 2, 3, 2,  0, 1, 2, 1 },
		{ 2, 1, 2, 3,  1, 0, 1, 2 },
		
		{ 2, 1, 0, 1,  3, 2, 1, 2 },
		{ 1, 2, 1, 0,  2, 3, 2, 1 },
		{ 0, 1, 2, 1,  1, 2, 3, 2 },
		{ 1, 0, 1, 2,  2, 1, 2, 3 },
	};

	private final static int[][] edges_incommon = new int[][] {
		{ 2, 1, 1, 1,  1, 1, 0, 0,  1, 0, 0, 0 },
		{ 1, 2, 1, 1,  0, 1, 1, 0,  0, 1, 0, 0 },
		{ 1, 1, 2, 1,  0, 0, 1, 1,  0, 0, 1, 0 },
		{ 1, 1, 1, 2,  1, 0, 0, 1,  0, 0, 0, 1 },
		
		{ 1, 0, 0, 1,  2, 1, 0, 1,  1, 0, 0, 1 },
		{ 1, 1, 0, 0,  1, 2, 1, 0,  1, 1, 0, 0 },
		{ 0, 1, 1, 0,  0, 1, 2, 1,  0, 1, 1, 0 },
		{ 0, 0, 1, 1,  1, 0, 1, 2,  0, 0, 1, 1 },
		
		{ 1, 0, 0, 0,  1, 1, 0, 0,  2, 1, 1, 1 },
		{ 0, 1, 0, 0,  0, 1, 1, 0,  1, 2, 1, 1 },
		{ 0, 0, 1, 0,  0, 0, 1, 1,  1, 1, 2, 1 },
		{ 0, 0, 0, 1,  1, 0, 0, 1,  1, 1, 1, 2 },
	};
	
	private final static int[][] edges_corners_incommon = new int[][] {
		{ 2, 1, 1, 2,  2, 1, 0, 1,  1, 0, 0, 1 },
		{ 2, 2, 1, 1,  1, 2, 1, 0,  1, 1, 0, 0 },
		{ 1, 2, 2, 1,  0, 1, 2, 1,  0, 1, 1, 0 },
		{ 1, 1, 2, 2,  1, 0, 1, 2,  0, 0, 1, 1 },
		
		{ 1, 0, 0, 1,  2, 1, 0, 1,  2, 1, 1, 2 },
		{ 1, 1, 0, 0,  1, 2, 1, 0,  2, 2, 1, 1 },
		{ 0, 1, 1, 0,  0, 1, 2, 1,  1, 2, 2, 1 },
		{ 0, 0, 1, 1,  1, 0, 1, 2,  1, 1, 2, 2 },
	};

	public static int how_many_colors_in_common_corners(int c1, int c2)
	{
		return corners_incommon[c1][c2];
	}
	
	public static int how_many_colors_in_common_edgess(int e1, int e2)
	{
		return edges_incommon[e1][e2];
	}
	public static int how_many_colors_in_common_corner_edge(int c, int e)
	{
		return edges_corners_incommon[c][e];
	}
	
	public static boolean isEdgeBad(int edge, int state) {
		return (state==1 && (edge < 4 || edge >= 8)) || !(state==0 && (edge >= 4 && edge < 8));
	}
	
	
	// unused stuff
	
	public final static int[/* up */][/* front */][ /* 0:corners, 1: edges */ ][/* idx */] orient_idxs = {
			/* up = RED */ {
				/* front = RED */ 		{ null, null },
				/* front = ORANGE */ 	{ null, null },
				/* front = YELLOW */	{ { 6, 7, 3, 2, 5, 4, 0, 1 }, { 11, 7, 3, 6, 10, 8, 0, 2, 9, 4, 1, 5 } },
				/* front = WHITE */		{ { 3, 2, 6, 7, 0, 1, 5, 4 }, { 3, 6, 11, 7, 0, 2, 10, 8, 1, 5, 9, 4 } },
				/* front = GREEN */		{ { 2, 6, 7, 3, 1, 5, 4, 0 }, { 6, 11, 7, 3, 2, 10, 8, 0, 5, 9, 4, 1 } },
				/* front = BLUE */		{ { 7, 3, 2, 6, 4, 0, 1, 5 }, { 7, 3, 6, 11, 8, 0, 2, 10, 4, 1, 5, 9 } },
			},
			/* up = ORANGE */ {
				/* front = RED */ 		{ null, null },
				/* front = ORANGE */ 	{ null, null },
				/* front = YELLOW */ 	{ { 4, 5, 1, 0, 7, 6, 2, 3 }, { 4, 9, 5, 1, 8, 10, 2, 0, 4, 11, 6, 3 } },
				/* front = WHITE */ 	{ { 1, 0, 4, 5, 2, 3, 7, 6 }, { 5, 1, 4, 9, 2, 0, 8, 10, 6, 3, 4, 11 } },
				/* front = GREEN */ 	{ { 5, 1, 0, 4, 6, 2, 3, 7 }, { 9, 5, 1, 4, 10, 2, 0, 8, 11, 6, 3, 4 } },
				/* front = BLUE */ 		{ { 0, 4, 5, 1, 3, 7, 6, 2 }, { 1, 4, 9, 5, 0, 8, 10, 2, 3, 4, 11, 6 } },
			},
			/* up = YELLOW */ {
				/* front = RED */ 		{ { 0, 1, 2, 3, 4, 5, 6, 7 }, { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 } },
				/* front = ORANGE */ 	{ { 2, 3, 0, 1, 6, 7, 0, 5 }, { 2, 3, 0, 1, 6, 7, 4, 5, 10, 11, 8, 9 } },
				/* front = YELLOW */ 	{ null, null },
				/* front = WHITE */ 	{ null, null },
				/* front = GREEN */ 	{ { 1, 2, 3, 0, 5, 6, 7, 0 }, { 1, 2, 3, 0, 5, 6, 7, 4, 9, 10, 11, 8 } },
				/* front = BLUE */ 		{ { 3, 0, 1, 2, 7, 0, 5, 6 }, { 3, 0, 1, 2, 7, 4, 5, 6, 11, 8, 9, 10 } }
			},
			/* up = WHITE */ {
				/* front = RED */ 		{ { 5, 4, 7, 6, 1, 0, 3, 2 }, { 9, 8, 11, 10, 5, 4, 7, 6, 1, 0, 3, 2 } },
				/* front = ORANGE */ 	{ { 7, 6, 5, 4, 3, 2, 1, 0 }, { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 } },
				/* front = YELLOW */ 	{ null, null },
				/* front = WHITE */ 	{ null, null },
				/* front = GREEN */ 	{ { 6, 5, 4, 7, 2, 1, 0, 3 }, { 10, 9, 8, 11, 6, 5, 4, 7, 2, 1, 0, 3 } },
				/* front = BLUE */ 		{ { 4, 7, 6, 5, 0, 3, 2, 1 }, { 8, 11, 10, 9, 4, 7, 6, 5, 0, 3, 2, 1 } }
			},
			/* up = GREEN */ {
				/* front = RED */ 		{ { 4, 0, 3, 7, 5, 1, 2, 6 }, { 8, 4, 0, 7, 9, 1, 3, 11, 10, 5, 2, 6 } },
				/* front = ORANGE */ 	{ { 3, 7, 4, 0, 2, 6, 5, 1 }, { 0, 7, 8, 4, 3, 11, 9, 1, 2, 6, 10, 5 } },
				/* front = YELLOW */ 	{ { 7, 4, 0, 3, 6, 5, 1, 2 }, { 7, 8, 4, 0, 11, 9, 1, 3, 6, 10, 5, 2 } },
				/* front = WHITE */ 	{ { 0, 3, 7, 4, 1, 2, 6, 5 }, { 4, 0, 7, 8, 1, 3, 11, 9, 5, 2, 6, 10 } },
				/* front = GREEN */ 	{ null, null },
				/* front = BLUE */ 		{ null, null },
			},
			/* up = BLUE */ {
				/* front = RED */ 		{ { 1, 5, 6, 2, 0, 4, 7, 3 }, { 2, 5, 10, 6, 1, 9, 11, 3, 0, 4, 8, 7 } },
				/* front = ORANGE */ 	{ { 6, 2, 1, 5, 7, 3, 0, 4 }, { 10, 6, 2, 5, 11, 3, 1, 9, 8, 7, 0, 4 } },
				/* front = YELLOW */ 	{ { 5, 6, 2, 1, 4, 7, 3, 0 }, { 5, 10, 6, 2, 9, 11, 3, 1, 4, 8, 7, 0 } },
				/* front = WHITE */ 	{ { 2, 1, 5, 6, 3, 0, 4, 7 }, { 6, 2, 5, 10, 3, 1, 9, 11, 7, 0, 4, 8 } },
				/* front = GREEN */ 	{ null, null },
				/* front = BLUE */ 		{ null, null },
			}
	};
	

	//up	front	rot_RED	rot_ORANGE	rot_YELLOW	rot_WHITE	rot_GREEN	rot_BLUE
	public final static int[][] orientationFaceRotations = {
									/* FRONT, BACK, UP, DOWN, RIGHT, LEFT */
	/* up		front */			/* red, orange, yellow, white, green, blue */
	/* RED		YELLOW */	{ 0, 2,		2, 0, 2, 0, 3, 1 },
	/* RED		WHITE */	{ 0, 3, 	0, 2, 0, 2, 1, 3 },
	/* RED		GREEN */	{ 0, 4, 	1, 3, 1, 1, 2, 0 },
	/* RED		BLUE */		{ 0, 5, 	3, 1, 3, 3, 0, 2 },
	
	/* ORANGE	YELLOW */	{ 1, 2, 	0, 2, 2, 0, 3, 1 },
	/* ORANGE	WHITE */	{ 1, 3, 	2, 0, 0, 2, 1, 3 },
	/* ORANGE	GREEN */	{ 1, 4, 	3, 1, 3, 3, 2, 0 },
	/* ORANGE	BLUE */		{ 1, 5, 	1, 3, 1, 1, 0, 2 },
	
	/* YELLOW	RED */		{ 2, 0, 	0, 0, 0, 0, 0, 0 },
	/* YELLOW	ORANGE */	{ 2, 1, 	0, 0, 2, 2, 0, 0 },
	/* YELLOW	GREEN */	{ 2, 4, 	0, 0, 1, 3, 0, 0 },
	/* YELLOW	BLUE */		{ 2, 5, 	0, 0, 3, 1, 0, 0 },
	
	/* WHITE	RED */		{ 3, 0, 	2, 2, 2, 2, 2, 2 },
	/* WHITE	ORANGE */	{ 3, 1, 	2, 2, 0, 0, 2, 2 },
	/* WHITE	GREEN */	{ 3, 4, 	2, 2, 1, 3, 2, 2 },
	/* WHITE	BLUE */		{ 3, 5, 	2, 2, 3, 1, 2, 2 },
	
	/* GREEN	RED */		{ 4, 0, 	3, 1, 3, 3, 3, 3 },
	/* GREEN	ORANGE */	{ 4, 1, 	1, 3, 1, 1, 3, 3 },
	/* GREEN	YELLOW */	{ 4, 2, 	3, 3, 2, 0, 3, 1 },
	/* GREEN	WHITE */	{ 4, 3, 	3, 3, 0, 2, 1, 3 },
	
	/* BLUE		RED */		{ 5, 0, 	1, 3, 1, 1, 1, 1 },
	/* BLUE		ORANGE */	{ 5, 1, 	3, 1, 3, 3, 1, 1 },
	/* BLUE		YELLOW */	{ 5, 2, 	1, 3, 2, 0, 3, 1 },
	/* BLUE		WHITE */	{ 5, 3, 	1, 3, 0, 2, 1, 3 } }; 
}
