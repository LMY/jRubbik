package jRubbik.constants;

public class Constants {
	
	public static final int CORNER_DFL = 0;
	public static final int CORNER_DFR = 1;
	public static final int CORNER_DBR = 2;
	public static final int CORNER_DBL = 3;
	public static final int CORNER_UFL = 4;
	public static final int CORNER_UFR = 5;
	public static final int CORNER_UBR = 6;
	public static final int CORNER_UBL = 7;
	
	final public static int[] corners_permF = { CORNER_DFL, CORNER_UFL, CORNER_UFR, CORNER_DFR };
	final public static int[] corners_permB = { CORNER_DBR, CORNER_DBL, CORNER_UBL, CORNER_UBR }; //   CORNER_UBR, CORNER_UBL, CORNER_DBL, CORNER_DBR };
	final public static int[] corners_permU = { CORNER_UFR, CORNER_UFL, CORNER_UBL, CORNER_UBR };
	final public static int[] corners_permD = { CORNER_DFL, CORNER_DFR, CORNER_DBR, CORNER_DBL }; //CORNER_DFL, CORNER_DFR, CORNER_DBR, CORNER_DBL };
	final public static int[] corners_permR = { CORNER_DFR, CORNER_UFR, CORNER_UBR, CORNER_DBR };
	final public static int[] corners_permL = { CORNER_DBL, CORNER_UBL, CORNER_UFL, CORNER_DFL }; //  CORNER_UFL, CORNER_DFL, CORNER_DBL, CORNER_UBL };

	final public static int[][] corners_permutations = {
		corners_permF,
		corners_permB,
		corners_permU,
		corners_permD,
		corners_permR,
		corners_permL
	};

	public static final int EDGE_SW = 0;
	public static final int EDGE_SF = 1;
	public static final int EDGE_SE = 2;
	public static final int EDGE_SB = 3;
	public static final int EDGE_MFW = 4;
	public static final int EDGE_MFE = 5;
	public static final int EDGE_MBE = 6;
	public static final int EDGE_MBW = 7;
	public static final int EDGE_NW = 8;
	public static final int EDGE_NF = 9;
	public static final int EDGE_NE = 10;
	public static final int EDGE_NB = 11;

	final public static int[] edges_permF = { EDGE_MFW, EDGE_NF,  EDGE_MFE, EDGE_SF };
	final public static int[] edges_permB = { EDGE_SB,  EDGE_MBE, EDGE_NB,  EDGE_MBW };
	final public static int[] edges_permU = { EDGE_NF,  EDGE_NW,  EDGE_NB,  EDGE_NE };
	final public static int[] edges_permD = { EDGE_SW , EDGE_SF,  EDGE_SE,  EDGE_SB };
	final public static int[] edges_permR = { EDGE_MFE, EDGE_NE,  EDGE_MBE, EDGE_SE };
	final public static int[] edges_permL = { EDGE_MFW, EDGE_SW,  EDGE_MBW, EDGE_NW };
	final public static int[][] edges_permutations = {
		edges_permF,
		edges_permB,
		edges_permU,
		edges_permD,
		edges_permR,
		edges_permL
	};
	
	
	public static final int MOVE_F = 0;
	public static final int MOVE_B = 1;
	public static final int MOVE_U = 2;
	public static final int MOVE_D = 3;
	public static final int MOVE_R = 4; 
	public static final int MOVE_L = 5;
	public static final int MOVE_INVALID = 255; // will cause crashes; and this is intended (-fno-exceptions)
	
	final public static String[] KubeMoveNames = { "F", "B", "U", "D", "R", "L" };


	
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
		
//		if (const_rot_axis == 0) {
//			if (x == 0) return 0;
//			else if (x == 1) return 2;
//			else /*if (x == 2)*/ return 1;
//		}
//		else if (const_rot_axis == 1) {
//			if (x == 0) return 2;
//			else if (x == 1) return 1;
//			else /*if (x == 2)*/ return 0;
//		}
//		else /*if (const_rot_axis == 2)*/ {
//			if (x == 0) return 1;
//			else if (x == 1) return 0;
//			else /*if (x == 2)*/ return 2;
//		}		
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
	
}
