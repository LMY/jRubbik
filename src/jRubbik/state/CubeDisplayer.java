package jRubbik.state;

import jRubbik.constants.Color;
import jRubbik.constants.Constants;

public class CubeDisplayer {

	public final static int CORNER_RED_SW = 0;
	public final static int CORNER_RED_SE = 1;
	public final static int CORNER_RED_NW = 4;
	public final static int CORNER_RED_NE = 5;
	public final static int CORNER_GREEN_SW = 1;
	public final static int CORNER_GREEN_SE = 2;
	public final static int CORNER_GREEN_NW = 5;
	public final static int CORNER_GREEN_NE = 6;
	public final static int CORNER_ORANGE_SW = 3;
	public final static int CORNER_ORANGE_SE = 2;
	public final static int CORNER_ORANGE_NW = 7;
	public final static int CORNER_ORANGE_NE = 6;
	public final static int CORNER_BLUE_SW = 3;
	public final static int CORNER_BLUE_SE = 0;
	public final static int CORNER_BLUE_NW = 7;
	public final static int CORNER_BLUE_NE = 4;
	public final static int CORNER_WHITE_SW = 3;
	public final static int CORNER_WHITE_SE = 2;
	public final static int CORNER_WHITE_NW = 0;
	public final static int CORNER_WHITE_NE = 1;
	public final static int CORNER_YELLOW_SW = 4;
	public final static int CORNER_YELLOW_SE = 5;
	public final static int CORNER_YELLOW_NW = 7;
	public final static int CORNER_YELLOW_NE = 6;
	
	
	public static void display(CubeState state) {

		int[] corners = state.getCorners();
		int[] edges = state.getEdges();
		
		int[] state_corners = state.getState_corners();
		int[] state_edges = state.getState_edges();
		
		// YELLOW FACE
		System.out.println("        ---------");
		System.out.print("        | ");
		System.out.println(getCornerColorChar(CORNER_YELLOW_NW, 0, corners, state_corners)+" "+getEdgeColorChar(11, 0, edges, state_edges)+" "+getCornerColorChar(CORNER_YELLOW_NE, 0, corners, state_corners)+" |");
		System.out.print("        | ");
		System.out.println(getEdgeColorChar(8, 0, edges, state_edges)+" y "+getEdgeColorChar(10, 0, edges, state_edges)+" |");
		System.out.print("        | ");
		System.out.println(getCornerColorChar(CORNER_YELLOW_SW, 0, corners, state_corners)+" "+getEdgeColorChar(9, 0, edges, state_edges)+" "+getCornerColorChar(CORNER_YELLOW_SE, 0, corners, state_corners)+" |");
		System.out.println("---------------------------------");
		
		
		// UP LINE
		System.out.print("| ");
		System.out.print(getCornerColorChar(CORNER_BLUE_NW, 2, corners, state_corners)+" "+getEdgeColorChar(8, 1, edges, state_edges)+" "+getCornerColorChar(CORNER_BLUE_NE, 2, corners, state_corners)+" ");
		System.out.print("| ");
		System.out.print(getCornerColorChar(CORNER_RED_NW, 1, corners, state_corners)+" "+getEdgeColorChar(9, 1, edges, state_edges)+" "+getCornerColorChar(CORNER_RED_NE, 1, corners, state_corners)+" ");
		System.out.print("| ");
		System.out.print(getCornerColorChar(CORNER_GREEN_NW, 2, corners, state_corners)+" "+getEdgeColorChar(10, 1, edges, state_edges)+" "+getCornerColorChar(CORNER_GREEN_NE, 2, corners, state_corners)+" ");
		System.out.print("| ");
		System.out.print(getCornerColorChar(CORNER_ORANGE_NW, 1, corners, state_corners)+" "+getEdgeColorChar(11, 1, edges, state_edges)+" "+getCornerColorChar(CORNER_ORANGE_NE, 1, corners, state_corners)+" ");
		System.out.print("| ");
		System.out.println();
		
		//MIDDLE LINE
		System.out.print("| ");
		System.out.print(getEdgeColorChar(7, 1, edges, state_edges)+" b "+getEdgeColorChar(4, 1, edges, state_edges)+" ");
		System.out.print("| ");
		System.out.print(getEdgeColorChar(4, 0, edges, state_edges)+" r "+getEdgeColorChar(5, 0, edges, state_edges)+" ");		
		System.out.print("| ");
		System.out.print(getEdgeColorChar(5, 1, edges, state_edges)+" g "+getEdgeColorChar(6, 1, edges, state_edges)+" ");		
		System.out.print("| ");
		System.out.print(getEdgeColorChar(7, 0, edges, state_edges)+" o "+getEdgeColorChar(6, 0, edges, state_edges)+" ");		
		System.out.print("| ");
		System.out.println();
		
		// BOTTOM LINE
		System.out.print("| ");
		System.out.print(getCornerColorChar(CORNER_BLUE_SW, 2, corners, state_corners)+" "+getEdgeColorChar(0, 1, edges, state_edges)+" "+getCornerColorChar(CORNER_BLUE_SE, 2, corners, state_corners)+" ");
		System.out.print("| ");
		System.out.print(getCornerColorChar(CORNER_RED_SW, 1, corners, state_corners)+" "+getEdgeColorChar(1, 1, edges, state_edges)+" "+getCornerColorChar(CORNER_RED_SE, 1, corners, state_corners)+" ");
		System.out.print("| ");
		System.out.print(getCornerColorChar(CORNER_GREEN_SW, 2, corners, state_corners)+" "+getEdgeColorChar(2, 1, edges, state_edges)+" "+getCornerColorChar(CORNER_GREEN_SE, 2, corners, state_corners)+" ");
		System.out.print("| ");
		System.out.print(getCornerColorChar(CORNER_ORANGE_SW, 1, corners, state_corners)+" "+getEdgeColorChar(3, 1, edges, state_edges)+" "+getCornerColorChar(CORNER_ORANGE_SE, 1, corners, state_corners)+" ");
		System.out.print("| ");
		System.out.println();
		
		
		// WHITE FACE
		System.out.println("---------------------------------");
		System.out.print("        | ");
		System.out.println(getCornerColorChar(CORNER_WHITE_NW, 0, corners, state_corners)+" "+getEdgeColorChar(1, 0, edges, state_edges)+" "+getCornerColorChar(CORNER_WHITE_NE, 0, corners, state_corners)+" |");
		System.out.print("        | ");
		System.out.println(getEdgeColorChar(0, 0, edges, state_edges)+" w "+getEdgeColorChar(2, 0, edges, state_edges)+" |");
		System.out.print("        | ");
		System.out.println(getCornerColorChar(CORNER_WHITE_SW, 0, corners, state_corners)+" "+getEdgeColorChar(3, 0, edges, state_edges)+" "+getCornerColorChar(CORNER_WHITE_SE, 0, corners, state_corners)+" |");
		System.out.println("        ---------");		
		
//		printArray("pC", corners, state_corners);
//		printArray("pE", edges, state_edges);
//		if (state.isSolved()) System.out.println("SOLVED!");
	}
	
//	private static void printArray(String string, int[] s2, int[] state) {
//		System.out.print(string+ " = { ");
//		for (int i = 0; i < s2.length; i++)
//			System.out.print(s2[i] + "("+state[s2[i]]+")"+	(i != s2.length - 1 ? ", " : " }"));
//		System.out.println();
//	}

	
	public static Color getFuckingColorCorner(OrientatonState orient, Color who, int state, int idx)
	{
		
		return Color.INVALID;
	}
	
	

	public static String toString2(CubeState state) {

		int[] corners = state.getCorners();
		int[] edges = state.getEdges();
		
		int[] state_corners = state.getState_corners();
		int[] state_edges = state.getState_edges();
		
		StringBuilder ret = new StringBuilder();
		
		final OrientatonState orient = state.getOrientation();
		
		// YELLOW FACE
		ret.append("        ---------\n");
		ret.append("        | ");
		ret.append(getCornerColorChar(CORNER_YELLOW_NW, 0, corners, state_corners)+" "+getEdgeColorChar(11, 0, edges, state_edges)+" "+getCornerColorChar(CORNER_YELLOW_NE, 0, corners, state_corners)+" |\n");
		ret.append("        | ");
		ret.append(getEdgeColorChar(8, 0, edges, state_edges)+" "+orient.getUp().toChar()+" "+getEdgeColorChar(10, 0, edges, state_edges)+" |\n");
		ret.append("        | ");
		ret.append(getCornerColorChar(CORNER_YELLOW_SW, 0, corners, state_corners)+" "+getEdgeColorChar(9, 0, edges, state_edges)+" "+getCornerColorChar(CORNER_YELLOW_SE, 0, corners, state_corners)+" |\n");
		ret.append("---------------------------------\n");
		
		
		// UP LINE
		ret.append("| ");
		ret.append(getCornerColorChar(CORNER_BLUE_NW, 2, corners, state_corners)+" "+getEdgeColorChar(8, 1, edges, state_edges)+" "+getCornerColorChar(CORNER_BLUE_NE, 2, corners, state_corners)+" ");
		ret.append("| ");
		ret.append(getCornerColorChar(CORNER_RED_NW, 1, corners, state_corners)+" "+getEdgeColorChar(9, 1, edges, state_edges)+" "+getCornerColorChar(CORNER_RED_NE, 1, corners, state_corners)+" ");
		ret.append("| ");
		ret.append(getCornerColorChar(CORNER_GREEN_NW, 2, corners, state_corners)+" "+getEdgeColorChar(10, 1, edges, state_edges)+" "+getCornerColorChar(CORNER_GREEN_NE, 2, corners, state_corners)+" ");
		ret.append("| ");
		ret.append(getCornerColorChar(CORNER_ORANGE_NW, 1, corners, state_corners)+" "+getEdgeColorChar(11, 1, edges, state_edges)+" "+getCornerColorChar(CORNER_ORANGE_NE, 1, corners, state_corners)+" ");
		ret.append("| ");
		ret.append("\n");
		
		//MIDDLE LINE
		ret.append("| ");
		ret.append(getEdgeColorChar(7, 1, edges, state_edges)+" "+orient.getLeft().toChar()+" "+getEdgeColorChar(4, 1, edges, state_edges)+" ");
		ret.append("| ");
		ret.append(getEdgeColorChar(4, 0, edges, state_edges)+" "+orient.getFront().toChar()+" "+getEdgeColorChar(5, 0, edges, state_edges)+" ");		
		ret.append("| ");
		ret.append(getEdgeColorChar(5, 1, edges, state_edges)+" "+orient.getRight().toChar()+" "+getEdgeColorChar(6, 1, edges, state_edges)+" ");		
		ret.append("| ");
		ret.append(getEdgeColorChar(7, 0, edges, state_edges)+" "+orient.getBack().toChar()+" "+getEdgeColorChar(6, 0, edges, state_edges)+" ");		
		ret.append("| ");
		ret.append("\n");
		
		// BOTTOM LINE
		ret.append("| ");
		ret.append(getCornerColorChar(CORNER_BLUE_SW, 2, corners, state_corners)+" "+getEdgeColorChar(0, 1, edges, state_edges)+" "+getCornerColorChar(CORNER_BLUE_SE, 2, corners, state_corners)+" ");
		ret.append("| ");
		ret.append(getCornerColorChar(CORNER_RED_SW, 1, corners, state_corners)+" "+getEdgeColorChar(1, 1, edges, state_edges)+" "+getCornerColorChar(CORNER_RED_SE, 1, corners, state_corners)+" ");
		ret.append("| ");
		ret.append(getCornerColorChar(CORNER_GREEN_SW, 2, corners, state_corners)+" "+getEdgeColorChar(2, 1, edges, state_edges)+" "+getCornerColorChar(CORNER_GREEN_SE, 2, corners, state_corners)+" ");
		ret.append("| ");
		ret.append(getCornerColorChar(CORNER_ORANGE_SW, 1, corners, state_corners)+" "+getEdgeColorChar(3, 1, edges, state_edges)+" "+getCornerColorChar(CORNER_ORANGE_SE, 1, corners, state_corners)+" ");
		ret.append("| ");
		ret.append("\n");
		
		
		// WHITE FACE
		ret.append("---------------------------------\n");
		ret.append("        | ");
		ret.append(getCornerColorChar(CORNER_WHITE_NW, 0, corners, state_corners)+" "+getEdgeColorChar(1, 0, edges, state_edges)+" "+getCornerColorChar(CORNER_WHITE_NE, 0, corners, state_corners)+" |\n");
		ret.append("        | ");
		ret.append(getEdgeColorChar(0, 0, edges, state_edges)+" "+orient.getDown().toChar()+" "+getEdgeColorChar(2, 0, edges, state_edges)+" |\n");
		ret.append("        | ");
		ret.append(getCornerColorChar(CORNER_WHITE_SW, 0, corners, state_corners)+" "+getEdgeColorChar(3, 0, edges, state_edges)+" "+getCornerColorChar(CORNER_WHITE_SE, 0, corners, state_corners)+" |\n");
		ret.append("        ---------\n");
		
		ret.append("\n");
		ret.append(appendArray("pC", corners, state_corners));
		ret.append(appendArray("pE", edges, state_edges));
		
		return ret.toString();
	}
	
	
	
	
	public static String toString(CubeState state) {

		int[] corners = state.getCorners();
		int[] edges = state.getEdges();
		
		int[] state_corners = state.getState_corners();
		int[] state_edges = state.getState_edges();
		
		StringBuilder ret = new StringBuilder();
		
		final OrientatonState orient = state.getOrientation();
		
		int corner_red_sw = orient.corners_permutations(Color.RED)[0];
		int corner_red_se = orient.corners_permutations(Color.RED)[1];
		int corner_red_nw = orient.corners_permutations(Color.RED)[2];
		int corner_red_ne = orient.corners_permutations(Color.RED)[3];
		int corner_green_sw = orient.corners_permutations(Color.GREEN)[0];
		int corner_green_se = orient.corners_permutations(Color.GREEN)[1];
		int corner_green_nw = orient.corners_permutations(Color.GREEN)[2];
		int corner_green_ne = orient.corners_permutations(Color.GREEN)[3];
		int corner_orange_sw = orient.corners_permutations(Color.ORANGE)[0];
		int corner_orange_se = orient.corners_permutations(Color.ORANGE)[1];
		int corner_orange_nw = orient.corners_permutations(Color.ORANGE)[2];
		int corner_orange_ne = orient.corners_permutations(Color.ORANGE)[3];
		int corner_blue_sw = orient.corners_permutations(Color.BLUE)[0];
		int corner_blue_se = orient.corners_permutations(Color.BLUE)[1];
		int corner_blue_nw = orient.corners_permutations(Color.BLUE)[2];
		int corner_blue_ne = orient.corners_permutations(Color.BLUE)[3];
		int corner_white_sw = orient.corners_permutations(Color.WHITE)[0];
		int corner_white_se = orient.corners_permutations(Color.WHITE)[1];
		int corner_white_nw = orient.corners_permutations(Color.WHITE)[2];
		int corner_white_ne = orient.corners_permutations(Color.WHITE)[3];
		int corner_yellow_sw = orient.corners_permutations(Color.YELLOW)[0];
		int corner_yellow_se = orient.corners_permutations(Color.YELLOW)[1];
		int corner_yellow_nw = orient.corners_permutations(Color.YELLOW)[2];
		int corner_yellow_ne = orient.corners_permutations(Color.YELLOW)[3];
		
		int edge_red_sw = orient.edges_permutations(Color.RED)[0];
		int edge_red_se = orient.edges_permutations(Color.RED)[1];
		int edge_red_nw = orient.edges_permutations(Color.RED)[2];
		int edge_red_ne = orient.edges_permutations(Color.RED)[3];
		int edge_green_sw = orient.edges_permutations(Color.GREEN)[0];
		int edge_green_se = orient.edges_permutations(Color.GREEN)[1];
		int edge_green_nw = orient.edges_permutations(Color.GREEN)[2];
		int edge_green_ne = orient.edges_permutations(Color.GREEN)[3];
		int edge_orange_sw = orient.edges_permutations(Color.ORANGE)[0];
		int edge_orange_se = orient.edges_permutations(Color.ORANGE)[1];
		int edge_orange_nw = orient.edges_permutations(Color.ORANGE)[2];
		int edge_orange_ne = orient.edges_permutations(Color.ORANGE)[3];
		int edge_blue_sw = orient.edges_permutations(Color.BLUE)[0];
		int edge_blue_se = orient.edges_permutations(Color.BLUE)[1];
		int edge_blue_nw = orient.edges_permutations(Color.BLUE)[2];
		int edge_blue_ne = orient.edges_permutations(Color.BLUE)[3];
		int edge_white_sw = orient.edges_permutations(Color.WHITE)[0];
		int edge_white_se = orient.edges_permutations(Color.WHITE)[1];
		int edge_white_nw = orient.edges_permutations(Color.WHITE)[2];
		int edge_white_ne = orient.edges_permutations(Color.WHITE)[3];
		int edge_yellow_sw = orient.edges_permutations(Color.YELLOW)[0];
		int edge_yellow_se = orient.edges_permutations(Color.YELLOW)[1];
		int edge_yellow_nw = orient.edges_permutations(Color.YELLOW)[2];
		int edge_yellow_ne = orient.edges_permutations(Color.YELLOW)[3];
		
		// YELLOW FACE
		ret.append("        ---------\n");
		ret.append("        | ");
		ret.append(getCornerColorChar(corner_yellow_nw, 0, corners, state_corners)+" "+getEdgeColorChar(11, 0, edges, state_edges)+" "+getCornerColorChar(corner_yellow_ne, 0, corners, state_corners)+" |\n");
		ret.append("        | ");
		ret.append(getEdgeColorChar(8, 0, edges, state_edges)+" "+orient.getUp().toChar()+" "+getEdgeColorChar(10, 0, edges, state_edges)+" |\n");
		ret.append("        | ");
		ret.append(getCornerColorChar(corner_yellow_sw, 0, corners, state_corners)+" "+getEdgeColorChar(9, 0, edges, state_edges)+" "+getCornerColorChar(corner_yellow_se, 0, corners, state_corners)+" |\n");
		ret.append("---------------------------------\n");
		
		
		// UP LINE
		ret.append("| ");
		ret.append(getCornerColorChar(corner_blue_nw, 2, corners, state_corners)+" "+getEdgeColorChar(8, 1, edges, state_edges)+" "+getCornerColorChar(corner_blue_ne, 2, corners, state_corners)+" ");
		ret.append("| ");
		ret.append(getCornerColorChar(corner_red_nw, 1, corners, state_corners)+" "+getEdgeColorChar(9, 1, edges, state_edges)+" "+getCornerColorChar(corner_red_ne, 1, corners, state_corners)+" ");
		ret.append("| ");
		ret.append(getCornerColorChar(corner_green_nw, 2, corners, state_corners)+" "+getEdgeColorChar(10, 1, edges, state_edges)+" "+getCornerColorChar(corner_green_ne, 2, corners, state_corners)+" ");
		ret.append("| ");
		ret.append(getCornerColorChar(corner_orange_nw, 1, corners, state_corners)+" "+getEdgeColorChar(11, 1, edges, state_edges)+" "+getCornerColorChar(corner_orange_ne, 1, corners, state_corners)+" ");
		ret.append("| ");
		ret.append("\n");
		
		//MIDDLE LINE
		ret.append("| ");
		ret.append(getEdgeColorChar(7, 1, edges, state_edges)+" "+orient.getLeft().toChar()+" "+getEdgeColorChar(4, 1, edges, state_edges)+" ");
		ret.append("| ");
		ret.append(getEdgeColorChar(4, 0, edges, state_edges)+" "+orient.getFront().toChar()+" "+getEdgeColorChar(5, 0, edges, state_edges)+" ");		
		ret.append("| ");
		ret.append(getEdgeColorChar(5, 1, edges, state_edges)+" "+orient.getRight().toChar()+" "+getEdgeColorChar(6, 1, edges, state_edges)+" ");		
		ret.append("| ");
		ret.append(getEdgeColorChar(7, 0, edges, state_edges)+" "+orient.getBack().toChar()+" "+getEdgeColorChar(6, 0, edges, state_edges)+" ");		
		ret.append("| ");
		ret.append("\n");
		
		// BOTTOM LINE
		ret.append("| ");
		ret.append(getCornerColorChar(corner_blue_sw, 2, corners, state_corners)+" "+getEdgeColorChar(0, 1, edges, state_edges)+" "+getCornerColorChar(corner_blue_se, 2, corners, state_corners)+" ");
		ret.append("| ");
		ret.append(getCornerColorChar(corner_red_sw, 1, corners, state_corners)+" "+getEdgeColorChar(1, 1, edges, state_edges)+" "+getCornerColorChar(corner_red_se, 1, corners, state_corners)+" ");
		ret.append("| ");
		ret.append(getCornerColorChar(corner_green_sw, 2, corners, state_corners)+" "+getEdgeColorChar(2, 1, edges, state_edges)+" "+getCornerColorChar(corner_green_se, 2, corners, state_corners)+" ");
		ret.append("| ");
		ret.append(getCornerColorChar(corner_orange_sw, 1, corners, state_corners)+" "+getEdgeColorChar(3, 1, edges, state_edges)+" "+getCornerColorChar(corner_orange_se, 1, corners, state_corners)+" ");
		ret.append("| ");
		ret.append("\n");
		
		
		// WHITE FACE
		ret.append("---------------------------------\n");
		ret.append("        | ");
		ret.append(getCornerColorChar(corner_white_nw, 0, corners, state_corners)+" "+getEdgeColorChar(1, 0, edges, state_edges)+" "+getCornerColorChar(corner_white_ne, 0, corners, state_corners)+" |\n");
		ret.append("        | ");
		ret.append(getEdgeColorChar(0, 0, edges, state_edges)+" "+orient.getDown().toChar()+" "+getEdgeColorChar(2, 0, edges, state_edges)+" |\n");
		ret.append("        | ");
		ret.append(getCornerColorChar(corner_white_sw, 0, corners, state_corners)+" "+getEdgeColorChar(3, 0, edges, state_edges)+" "+getCornerColorChar(corner_white_se, 0, corners, state_corners)+" |\n");
		ret.append("        ---------\n");
		
		ret.append("\n");
		ret.append(appendArray("pC", corners, state_corners));
		ret.append(appendArray("pE", edges, state_edges));
		
		return ret.toString();
	}
	
	private static String appendArray(String string, int[] s2, int[] state) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(string+ " = { ");
		for (int i = 0; i < s2.length; i++)
			sb.append(s2[i] + "("+state[s2[i]]+")"+	(i != s2.length - 1 ? ", " : " }"));
		sb.append("\n");
		
		return sb.toString();
	}

	public static char[][] CORNER_COLORS = {
			{ 'w', 'r', 'b' },
			{ 'w', 'r', 'g' },
			{ 'w', 'o', 'g' },
			{ 'w', 'o', 'b' },		
			{ 'y', 'r', 'b' },
			{ 'y', 'r', 'g' },
			{ 'y', 'o', 'g' },
			{ 'y', 'o', 'b' },				
	};


	
	public static char[][] EDGE_COLORS = {
			{ 'w', 'b' },
			{ 'w', 'r' },
			{ 'w', 'g' },
			{ 'w', 'o' },
			
			{ 'r', 'b' },
			{ 'r', 'g' },			
			{ 'o', 'g' },
			{ 'o', 'b' },
			
			{ 'y', 'b' },
			{ 'y', 'r' },
			{ 'y', 'g' },
			{ 'y', 'o' },
	};
	

	
	
	public static char getEdgeColorChar(int edge, int state, int face) {

		if (state == 0)
			return EDGE_COLORS[edge][0 != face ? 1 : 0];
		else
		{
			boolean good_edge = Constants.isEdgeBad(edge, state);
			
			if (good_edge)
				return EDGE_COLORS[edge][face==0 ? 1 : 0];
			else
				return EDGE_COLORS[edge][face==0 ? 0 : 1];
		}
	}
	
	public static char getCornerColorChar(int corner, int state, int face, int corner_index) {
		
		int idx = state == face ? 0 :
			!((state+1)%3 == face)^(Constants.how_many_colors_in_common_corners(corner, corner_index) % 2 == 1) ? 1 : 2;
		
		return CORNER_COLORS[corner][idx];
		
//		if (state != face) {
//			int distance = 3-Constants.how_many_colors_in_common_corners(corner, corner_index);
//			
//			if (state == 0)
//			{
//				if (face == 1) idx = distance % 2 == 0 ? 1 : 2;
//				else/* if (face == 2)*/ idx = distance % 2 == 0 ? 2 : 1;
//			}
//			else if (state == 1)
//			{
//				if (face == 0) idx = distance % 2 == 0 ? 2 : 1;
//				else idx = distance % 2 == 0 ? 1 : 2;
//			}
//			else
//			{
//				if (face == 1) idx = distance % 2 == 0 ? 2 : 1;
//				else /*if (face == 0)*/ idx = distance % 2 == 0 ? 1 : 2;
//			}
//		}
	}
	
	public static char getCornerColorChar(int idx, int f, int[] corners, int[] state_corners)
	{
		if (corners[idx] < 0) return '*';
		return getCornerColorChar(corners[idx], state_corners[corners[idx]], f, idx);
	}
	
	public static char getEdgeColorChar(int idx, int f, int[] edges, int[] state_edges)
	{
		if (edges[idx] < 0) return '*';
		return getEdgeColorChar(edges[idx], state_edges[edges[idx]], f);
	}	
	
	
	
	
	
	
	
	
	
	public static Color[][] CORNER_COLORS_COLORS = {
			{ Color.WHITE, Color.RED, Color.BLUE },
			{ Color.WHITE, Color.RED, Color.GREEN },
			{ Color.WHITE, Color.ORANGE, Color.GREEN },
			{ Color.WHITE, Color.ORANGE, Color.BLUE },		
			{ Color.YELLOW, Color.RED, Color.BLUE },
			{ Color.YELLOW, Color.RED, Color.GREEN },
			{ Color.YELLOW, Color.ORANGE, Color.GREEN },
			{ Color.YELLOW, Color.ORANGE, Color.BLUE },				
	};
	
	public static Color[][] EDGE_COLORS_COLORS = {
			{ Color.WHITE, Color.BLUE },
			{ Color.WHITE, Color.RED },
			{ Color.WHITE, Color.GREEN },
			{ Color.WHITE, Color.ORANGE },		
			
			{ Color.RED, Color.BLUE },
			{ Color.RED, Color.GREEN },
			{ Color.ORANGE, Color.GREEN },
			{ Color.ORANGE, Color.BLUE },
			
			{ Color.YELLOW, Color.BLUE },
			{ Color.YELLOW, Color.RED },
			{ Color.YELLOW, Color.GREEN },
			{ Color.YELLOW, Color.ORANGE },				
	};
	
	public static Color getCornerColor(int corner_index, int face, int[] corners, int[] state_corners)
	{
		if (corners[corner_index] < 0)
			return Color.INVALID;
		else
		{
			int corner = corners[corner_index];
			int state = state_corners[corners[corner_index]];
			
			int idx2 = state == face ? 0 :
				!((state+1)%3 == face)^(Constants.how_many_colors_in_common_corners(corner, corner_index) % 2 == 1) ? 1 : 2;
			
			return CORNER_COLORS_COLORS[corner][idx2];
		}
	}
	
	private static Color getEdgeColorAsColor(int edge, int state, int face) {

		if (state == 0)
			return EDGE_COLORS_COLORS[edge][0 != face ? 1 : 0];
		else
		{
			boolean good_edge = Constants.isEdgeBad(edge, state);
			
			if (good_edge)
				return EDGE_COLORS_COLORS[edge][face==0 ? 1 : 0];
			else
				return EDGE_COLORS_COLORS[edge][face==0 ? 0 : 1];
		}
	}
	
	public static Color getEdgeColor(int idx, int f, int[] edges, int[] state_edges)
	{
		if (edges[idx] < 0)
			return Color.INVALID;
		else {
			return getEdgeColorAsColor(edges[idx], state_edges[edges[idx]], f);
		}
	}	

	public static Color getFuckingColor(CubeState state, Color face, int x, int y) 
	{
		int[] corners = state.getCorners();
		int[] edges = state.getEdges();
		
		int[] state_corners = state.getState_corners();
		int[] state_edges = state.getState_edges();
		
		final OrientatonState orient = state.getOrientation();

		
		if (x == 1 && y == 1)
			return orient.get(face);
		
		

		if (x == 1 && y == 1)
			return orient.get(face);
		
		Color whereis = orient.whereis(face);
		
		boolean isForB = whereis == Color.RED || whereis == Color.ORANGE;
		boolean isRorL = whereis == Color.BLUE || whereis == Color.GREEN;
		
		boolean iscorner = ((x== 0 && y == 0) || (x== 0 && y == 2) || (x== 2 && y == 0) || (x== 2 && y == 2));
//		boolean isedge = !iscorner;
		
//		if (iscorner) {
//			final int idx = (x==0?0:1) + (y==0?0:2);
//			final int corner_state = isForB ? 1 : isRorL ? 2 : 0;
//			
//			return getCornerColor(orient.corners_permutations(face)[idx], corner_state, corners, state_corners);
//		}
//		else {
//			
//			// 1 0 -->  0
//			// 0 1 -->  1
//			// 0 2 -->  2
//			// 2 0 -->  3
//			final int idx = x==0?(y==1?1:2): x==1?0 : 2;
//			final int edge_state = isForB ? 1 : 0;
//			
//			return getEdgeColor(orient.edges_permutations(face)[idx], edge_state, edges, state_edges);
//		}
		
		return Color.INVALID;
	}
	

}
