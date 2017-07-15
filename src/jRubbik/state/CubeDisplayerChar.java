package jRubbik.state;

import jRubbik.constants.Constants;

public class CubeDisplayerChar {

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

	
	public static String toString(CubeState state) {

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
	
	private static String appendArray(String string, int[] s2, int[] state) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(string+ " = { ");
		for (int i = 0; i < s2.length; i++)
			sb.append(s2[i] + "("+state[s2[i]]+")"+	(i != s2.length - 1 ? ", " : " }"));
		sb.append("\n");
		
		return sb.toString();
	}

	private static char[][] CORNER_COLORS = {
			{ 'w', 'r', 'b' },
			{ 'w', 'r', 'g' },
			{ 'w', 'o', 'g' },
			{ 'w', 'o', 'b' },		
			{ 'y', 'r', 'b' },
			{ 'y', 'r', 'g' },
			{ 'y', 'o', 'g' },
			{ 'y', 'o', 'b' },				
	};

	private static char[][] EDGE_COLORS = {
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
	
	private static char getEdgeColorChar(int edge, int state, int face) {

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
	
	private static char getCornerColorChar(int corner, int state, int face, int corner_index) {
		
		int idx = state == face ? 0 :
			!((state+1)%3 == face)^(Constants.how_many_colors_in_common_corners(corner, corner_index) % 2 == 1) ? 1 : 2;
		
		return CORNER_COLORS[corner][idx];
	}
	
	private static char getCornerColorChar(int idx, int f, int[] corners, int[] state_corners)
	{
		if (corners[idx] < 0) return '*';
		return getCornerColorChar(corners[idx], state_corners[corners[idx]], f, idx);
	}
	
	private static char getEdgeColorChar(int idx, int f, int[] edges, int[] state_edges)
	{
		if (edges[idx] < 0) return '*';
		return getEdgeColorChar(edges[idx], state_edges[edges[idx]], f);
	}	
}
