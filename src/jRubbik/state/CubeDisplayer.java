package jRubbik.state;

import jRubbik.constants.Color;
import jRubbik.constants.Constants;

public class CubeDisplayer {

	public static Color[][] CORNER_COLORS = {
			{ Color.WHITE, Color.RED, Color.BLUE },
			{ Color.WHITE, Color.RED, Color.GREEN },
			{ Color.WHITE, Color.ORANGE, Color.GREEN },
			{ Color.WHITE, Color.ORANGE, Color.BLUE },
			{ Color.YELLOW, Color.RED, Color.BLUE },
			{ Color.YELLOW, Color.RED, Color.GREEN },
			{ Color.YELLOW, Color.ORANGE, Color.GREEN },
			{ Color.YELLOW, Color.ORANGE, Color.BLUE },
	};

	public static Color[][] EDGE_COLORS = {
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


	
	public static Color[][] getColors(CubeState cube)
	{
		final Color[][] colors = getUnorientedColors(cube);
		
		final OrientatonState state = cube.getOrientation();
		
		final Color[][] newcolors = new Color[colors.length][];
		final Color up = state.getUp();
		final Color front = state.getFront();
		
		// swap faces to new direction
		for (Color c : Color.ALL)
			newcolors[state.whereis(c).toInt()] = colors[c.toInt()];
		
		for (int i=0; i<newcolors.length; i++)
			colors[i] = newcolors[i];
		
		// now rotate the faces
		for (Color color : Color.ALL) {
			final int idx = color.toInt();
			rotate(colors[idx], obtain_rot(up, front, color));
		}

		return newcolors;
	}
	

	public static Color[][] getUnorientedColors(CubeState state) {

		final int[] corners = state.getCorners();
		final int[] edges = state.getEdges();

		final int[] state_corners = state.getState_corners();
		final int[] state_edges = state.getState_edges();

		final Color[][] colors = new Color[][]{
			/* front = RED */  {
				getEffectiveCornerColor(4, 1, corners, state_corners),
				getEffectiveEdgeColor(9, 1, edges, state_edges),
				getEffectiveCornerColor(5, 1, corners, state_corners),

				getEffectiveEdgeColor(4, 0, edges, state_edges),
				Color.RED,
				getEffectiveEdgeColor(5, 0, edges, state_edges),

				getEffectiveCornerColor(0, 1, corners, state_corners),
				getEffectiveEdgeColor(1, 1, edges, state_edges),
				getEffectiveCornerColor(1, 1, corners, state_corners)
			},

			/* front = ORANGE */  {
				getEffectiveCornerColor(6, 1, corners, state_corners),
				getEffectiveEdgeColor(11, 1, edges, state_edges),
				getEffectiveCornerColor(7, 1, corners, state_corners),

				getEffectiveEdgeColor(6, 0, edges, state_edges),
				Color.ORANGE,
				getEffectiveEdgeColor(7, 0, edges, state_edges),

				getEffectiveCornerColor(2, 1, corners, state_corners),
				getEffectiveEdgeColor(3, 1, edges, state_edges),
				getEffectiveCornerColor(3, 1, corners, state_corners)
			},

			/* front = YELLOW */  {
				getEffectiveCornerColor(7, 0, corners, state_corners),
				getEffectiveEdgeColor(11, 0, edges, state_edges),
				getEffectiveCornerColor(6, 0, corners, state_corners),

				getEffectiveEdgeColor(8, 0, edges, state_edges),
				Color.YELLOW,
				getEffectiveEdgeColor(10, 0, edges, state_edges),

				getEffectiveCornerColor(4, 0, corners, state_corners),
				getEffectiveEdgeColor(9, 0, edges, state_edges),
				getEffectiveCornerColor(5, 0, corners, state_corners)
			},

			/* front = WHITE */ {
				getEffectiveCornerColor(0, 0, corners, state_corners),
				getEffectiveEdgeColor(1, 0, edges, state_edges),
				getEffectiveCornerColor(1, 0, corners, state_corners),

				getEffectiveEdgeColor(0, 0, edges, state_edges),
				Color.WHITE,
				getEffectiveEdgeColor(2, 0, edges, state_edges),

				getEffectiveCornerColor(3, 0, corners, state_corners),
				getEffectiveEdgeColor(3, 0, edges, state_edges),
				getEffectiveCornerColor(2, 0, corners, state_corners)
			},

			/* front = GREEN */  {
				getEffectiveCornerColor(5, 2, corners, state_corners),
				getEffectiveEdgeColor(10, 1, edges, state_edges),
				getEffectiveCornerColor(6, 2, corners, state_corners),

				getEffectiveEdgeColor(5, 1, edges, state_edges),
				Color.GREEN,
				getEffectiveEdgeColor(6, 1, edges, state_edges),

				getEffectiveCornerColor(1, 2, corners, state_corners),
				getEffectiveEdgeColor(2, 1, edges, state_edges),
				getEffectiveCornerColor(2, 2, corners, state_corners)
			},

			/* front = BLUE */  {
				getEffectiveCornerColor(7, 2, corners, state_corners),
				getEffectiveEdgeColor(8, 1, edges, state_edges),				
				getEffectiveCornerColor(4, 2, corners, state_corners),

				getEffectiveEdgeColor(7, 1, edges, state_edges),
				Color.BLUE,
				getEffectiveEdgeColor(4, 1, edges, state_edges),

				getEffectiveCornerColor(3, 2, corners, state_corners),
				getEffectiveEdgeColor(0, 1, edges, state_edges),
				getEffectiveCornerColor(0, 2, corners, state_corners)
			}
		};
		
		return colors;
	}

	
	private static int obtain_rot(Color up, Color front, Color face)
	{
		final int upidx = up.toInt();
		final int frontidx = front.toInt();
		
		for (int i=0; i<Constants.orientationFaceRotations.length; i++)
			if (Constants.orientationFaceRotations[i][0] == upidx && Constants.orientationFaceRotations[i][1] == frontidx)
				return Constants.orientationFaceRotations[i][2 + face.toInt()];
		
		return -1;
	}
	
	private static Color getEffectiveCornerColor(int idx, int face, int[] corners, int[] state_corners) {

		final int state = state_corners[corners[idx]];
		
		final int colorIdx = state == face ? 0 :
			!((state+1)%3 == face)^(Constants.how_many_colors_in_common_corners(idx, corners[idx]) % 2 == 1) ? 1 : 2;

		return CORNER_COLORS[corners[idx]][colorIdx];
	}

	private static Color getEffectiveEdgeColor(int idx, int face, int[] edges, int[] state_edges) {

		final int state = state_edges[edges[idx]];
		idx = edges[idx];
		
		if (state == 0)
			return EDGE_COLORS[idx][0 != face ? 1 : 0];
		else
		{
			boolean good_edge = Constants.isEdgeBad(idx, state);

			if (good_edge)
				return EDGE_COLORS[idx][face==0 ? 1 : 0];
			else
				return EDGE_COLORS[idx][face==0 ? 0 : 1];
		}
	}

	

	private static void swap(Color[] colors, int i1, int i2) {
		final Color temp = colors[i1];
		colors[i1] = colors[i2];
		colors[i2] = temp;
	}

	
	private static void rotate(Color[] colors, int q) {

		while (q < 0)
			q += 4;
		q = q%4;

		if (q == 0)
			;
		else if (q == 1) {
			swap(colors, 1, 3);
			swap(colors, 3, 7);
			swap(colors, 7, 5);

			swap(colors, 0, 6);
			swap(colors, 6, 8);
			swap(colors, 8, 2);
		}
		else if (q == 2) {
			swap(colors, 0, 8);			
			swap(colors, 1, 7);
			swap(colors, 2, 6);
			swap(colors, 3, 5);
		}
		else {	//if (q == 3)
			swap(colors, 7, 5);
			swap(colors, 3, 7);
			swap(colors, 1, 3);

			swap(colors, 8, 2);
			swap(colors, 6, 8);
			swap(colors, 0, 6);
		}
	}
	
	
	
	public static String toString(CubeState state) {

		final StringBuilder ret = new StringBuilder();
		final Color[][] colors = CubeDisplayer.getColors(state);
		
		// YELLOW FACE
		ret.append("        ---------\n");
		ret.append("        | ");
		ret.append(colors[Color.YELLOW.toInt()][0].toChar()+" "+colors[Color.YELLOW.toInt()][1].toChar()+" "+colors[Color.YELLOW.toInt()][2].toChar()+" |\n");
		ret.append("        | ");
		ret.append(colors[Color.YELLOW.toInt()][3].toChar()+" "+colors[Color.YELLOW.toInt()][4].toChar()+" "+colors[Color.YELLOW.toInt()][5].toChar()+" |\n");
		ret.append("        | ");
		ret.append(colors[Color.YELLOW.toInt()][6].toChar()+" "+colors[Color.YELLOW.toInt()][7].toChar()+" "+colors[Color.YELLOW.toInt()][8].toChar()+" |\n");
		ret.append("---------------------------------\n");
		
		// UP LINE
		ret.append("| ");
		ret.append(colors[Color.BLUE.toInt()][0].toChar()+" "+colors[Color.BLUE.toInt()][1].toChar()+" "+colors[Color.BLUE.toInt()][2].toChar()+" ");
		ret.append("| ");
		ret.append(colors[Color.RED.toInt()][0].toChar()+" "+colors[Color.RED.toInt()][1].toChar()+" "+colors[Color.RED.toInt()][2].toChar()+" ");
		ret.append("| ");
		ret.append(colors[Color.GREEN.toInt()][0].toChar()+" "+colors[Color.GREEN.toInt()][1].toChar()+" "+colors[Color.GREEN.toInt()][2].toChar()+" ");
		ret.append("| ");
		ret.append(colors[Color.ORANGE.toInt()][0].toChar()+" "+colors[Color.ORANGE.toInt()][1].toChar()+" "+colors[Color.ORANGE.toInt()][2].toChar()+" ");
		ret.append("| ");
		ret.append("\n");
		
		//MIDDLE LINE
		ret.append("| ");
		ret.append(colors[Color.BLUE.toInt()][3].toChar()+" "+colors[Color.BLUE.toInt()][4].toChar()+" "+colors[Color.BLUE.toInt()][5].toChar()+" ");
		ret.append("| ");
		ret.append(colors[Color.RED.toInt()][3].toChar()+" "+colors[Color.RED.toInt()][4].toChar()+" "+colors[Color.RED.toInt()][5].toChar()+" ");
		ret.append("| ");
		ret.append(colors[Color.GREEN.toInt()][3].toChar()+" "+colors[Color.GREEN.toInt()][4].toChar()+" "+colors[Color.GREEN.toInt()][5].toChar()+" ");
		ret.append("| ");
		ret.append(colors[Color.ORANGE.toInt()][3].toChar()+" "+colors[Color.ORANGE.toInt()][4].toChar()+" "+colors[Color.ORANGE.toInt()][5].toChar()+" ");
		ret.append("| ");
		ret.append("\n");
		
		// BOTTOM LINE
		ret.append("| ");
		ret.append(colors[Color.BLUE.toInt()][6].toChar()+" "+colors[Color.BLUE.toInt()][7].toChar()+" "+colors[Color.BLUE.toInt()][8].toChar()+" ");
		ret.append("| ");
		ret.append(colors[Color.RED.toInt()][6].toChar()+" "+colors[Color.RED.toInt()][7].toChar()+" "+colors[Color.RED.toInt()][8].toChar()+" ");
		ret.append("| ");
		ret.append(colors[Color.GREEN.toInt()][6].toChar()+" "+colors[Color.GREEN.toInt()][7].toChar()+" "+colors[Color.GREEN.toInt()][8].toChar()+" ");
		ret.append("| ");
		ret.append(colors[Color.ORANGE.toInt()][6].toChar()+" "+colors[Color.ORANGE.toInt()][7].toChar()+" "+colors[Color.ORANGE.toInt()][8].toChar()+" ");
		ret.append("| ");
		ret.append("\n");
		
		
		// WHITE FACE
		ret.append("        ---------\n");
		ret.append("        | ");
		ret.append(colors[Color.WHITE.toInt()][0].toChar()+" "+colors[Color.WHITE.toInt()][1].toChar()+" "+colors[Color.WHITE.toInt()][2].toChar()+" |\n");
		ret.append("        | ");
		ret.append(colors[Color.WHITE.toInt()][3].toChar()+" "+colors[Color.WHITE.toInt()][4].toChar()+" "+colors[Color.WHITE.toInt()][5].toChar()+" |\n");
		ret.append("        | ");
		ret.append(colors[Color.WHITE.toInt()][6].toChar()+" "+colors[Color.WHITE.toInt()][7].toChar()+" "+colors[Color.WHITE.toInt()][8].toChar()+" |\n");
		ret.append("---------------------------------\n");
		
		ret.append("\n");
//		ret.append(appendArray("pC", corners, state_corners));
//		ret.append(appendArray("pE", edges, state_edges));
		
		return ret.toString();
	}
	
//	private static String appendArray(String string, int[] s2, int[] state) {
//		StringBuilder sb = new StringBuilder();
//		
//		sb.append(string+ " = { ");
//		for (int i = 0; i < s2.length; i++)
//			sb.append(s2[i] + "("+state[s2[i]]+")"+	(i != s2.length - 1 ? ", " : " }"));
//		sb.append("\n");
//		
//		return sb.toString();
//	}
}
