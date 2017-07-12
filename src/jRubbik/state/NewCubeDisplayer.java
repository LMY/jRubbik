package jRubbik.state;

import jRubbik.constants.Color;
import jRubbik.constants.Constants;

public class NewCubeDisplayer {


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


	public static Color getEffectiveCornerColor(int idx, int face, int[] corners, int[] state_corners) {

		final int state = state_corners[corners[idx]];
		
		final int colorIdx = state == face ? 0 :
			!((state+1)%3 == face)^(Constants.how_many_colors_in_common_corners(idx, corners[idx]) % 2 == 1) ? 1 : 2;

		return CORNER_COLORS[corners[idx]][colorIdx];
	}

	public static Color getEffectiveEdgeColor(int idx, int face, int[] edges, int[] state_edges) {

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


	public static Color[][] getColors(CubeState state) {

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
		
		return applyOrientation(colors, state.getOrientation());
	}

	
	private static Color[][] applyOrientation(Color[][] colors, OrientatonState state)
	{
		final Color[][] newcolors = new Color[colors.length][];
		final Color up = state.getUp();
		final Color front = state.getFront();
		
		for (Color c : Color.ALL)
			newcolors[state.whereis(c).toInt()] = colors[c.toInt()];
		
		for (int i=0; i<newcolors.length; i++)
			colors[i] = newcolors[i];
		

		// rotate up/down layer
		// right and left (blue and green) rotate +1 for each step rotate
		if (up == Color.YELLOW) {
		}
		else if (up == Color.RED) {
			rotate(colors[Color.GREEN.toInt()], 1);
			rotate(colors[Color.BLUE.toInt()], 3);
			
			rotate(colors[Color.WHITE.toInt()], 2);
			rotate(colors[Color.ORANGE.toInt()], 2);
		}
		else if (up == Color.WHITE) {
			rotate(colors[Color.GREEN.toInt()], 2);
			rotate(colors[Color.BLUE.toInt()], 2);
			
			rotate(colors[Color.RED.toInt()], 2);
			rotate(colors[Color.ORANGE.toInt()], 2);		
		}
		else if (up == Color.ORANGE) {
			rotate(colors[Color.GREEN.toInt()], 3);
			rotate(colors[Color.BLUE.toInt()], 1);

			rotate(colors[Color.YELLOW.toInt()], 2);
			rotate(colors[Color.ORANGE.toInt()], 2);
		}
		else if (up == Color.BLUE) {
			rotate(colors[Color.GREEN.toInt()], 1);
			rotate(colors[Color.BLUE.toInt()], 1);

			rotate(colors[Color.YELLOW.toInt()], 1);
			rotate(colors[Color.ORANGE.toInt()], 3);
			rotate(colors[Color.RED.toInt()], 1);
			rotate(colors[Color.WHITE.toInt()], 1);
		}		
		else if (up == Color.GREEN) {
			//opposite of blue
			rotate(colors[Color.GREEN.toInt()], 3);
			rotate(colors[Color.BLUE.toInt()], 3);

			rotate(colors[Color.YELLOW.toInt()], 3);
			rotate(colors[Color.ORANGE.toInt()], 1);
			rotate(colors[Color.RED.toInt()], 3);
			rotate(colors[Color.WHITE.toInt()], 3);
		}			
		// front.next(up) = { Color.GREEN | Color.BLUE } | up = GREEN (front should be red) | up = BLUE (front should be orange)
		
		final Color lookfor = 
							up == Color.YELLOW ? Color.RED :
							up == Color.WHITE ? Color.ORANGE :
							up == Color.ORANGE ? Color.YELLOW :
							up == Color.RED ? Color.WHITE :
							up == Color.BLUE ? Color.RED :
							up == Color.GREEN ? Color.RED :
								Color.INVALID;
		
		final int howmany = 
						lookfor == front ? 0 :
							lookfor == front.next(up) ? 3:
								lookfor == front.opposite() ? 2 : 1;
		
		// Front: GREEN		Up: RED	Lookfor: WHITE	Rot=1		i 4 centrali: 3
		// Front: YELLOW	Up: RED	Lookfor: WHITE	Rot=2		i 4 centrali: 2
		// Front: BLUE		Up: RED	Lookfor: WHITE	Rot=3		i 4 centrali: 1
		
		// Front: GREEN		Up: ORANGE	Lookfor: YELLOW	Rot=1	i 4 centrali: 1, white 2
		// Front: WHITE		Up: ORANGE	Lookfor: YELLOW	Rot=2	i 4 centrali: 2
		// Front: BLUE		Up: ORANGE	Lookfor: YELLOW	Rot=3	i 4 centrali: 3, white 2
		
		// Front: YELLOW	Up: BLUE	Lookfor: RED	Rot=13  right, down, back 2
		// Front: ORANGE	Up: BLUE	Lookfor: RED	Rot=2	front, back 2
		// Front: WHITE		Up: BLUE	Lookfor: RED	Rot=3	left,down, back 2
		
		// Front: GREEN		Up: WHITE	Lookfor: ORANGE	Rot=1 	down 2
		// Front: BLUE		Up: WHITE	Lookfor: ORANGE	Rot=3 	down 2
		
		// Front: YELLOW	Up: GREEN	Lookfor: RED	Rot=3 	left, down, back 2
		
		// Front: WHITE		Up: GREEN	Lookfor: RED	Rot=1	right, down, back 2
		// Front: ORANGE	Up: GREEN	Lookfor: RED	Rot=2	front, back 2
		// Front: YELLOW	Up: GREEN	Lookfor: RED	Rot=3	left, down, back 2
		
		rotate(colors[Color.YELLOW.toInt()], howmany);
		rotate(colors[Color.WHITE.toInt()], howmany);
		
		System.out.println("Front: "+front.toString()+"\tUp: "+up.toString()+"\tLookfor: "+lookfor+"\tRot="+howmany);
		
		return newcolors;
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

//	private static void invertHor(Color[] colors) {
//		swap(colors, 0, 2);
//		swap(colors, 3, 5);
//		swap(colors, 6, 8);
//	}
//
//	private static void invertVert(Color[] colors) {
//		swap(colors, 0, 6);
//		swap(colors, 1, 7);
//		swap(colors, 2, 8);
//	}
//	
//	private static void invert(Color[] colors) {
//		swap(colors, 0, 8);
//		swap(colors, 1, 7);
//		swap(colors, 2, 6);
//		swap(colors, 3, 5);
//	}
}
