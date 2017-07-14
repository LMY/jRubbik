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
		
		// swap faces to new direction
		for (Color c : Color.ALL)
			newcolors[state.whereis(c).toInt()] = colors[c.toInt()];
		
		for (int i=0; i<newcolors.length; i++)
			colors[i] = newcolors[i];
		
		// now rotate the faces
		
		// rotate up/down layer
		// right and left (blue and green) rotate +1 for each step rotate
		
		// up	front	rot_RED	rot_ORANGE	rot_YELLOW	rot_WHITE	rot_GREEN	rot_BLUE
		final int[][] realrot = {{ 0, 2, 2, 4, 2, 4, 3, 5 },
				{ 0, 3, 0, 2, 0, 2, 1, 3 },
				{ 0, 4, 5, 5, 5, 5, 6, 8 },
				{ 0, 5, 3, 3, 3, 3, 4, 6 },
				{ 1, 2, 4, 6, 2, 0, 7, 5 },
				{ 1, 3, 2, 4, 4, 2, 5, 3 },
				{ 1, 4, 3, 5, 7, 3, 6, 4 },
				{ 1, 5, 5, 7, 5, 1, 8, 6 },
				{ 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 2, 1, 0, 0, 2, 2, 0, 0 },
				{ 2, 4, 0, 0, 5, 3, 0, 0 },
				{ 2, 5, 0, 0, 3, 1, 0, 0 },
				{ 3, 0, 2, 2, 2, 2, 2, 2 },
				{ 3, 1, 2, 2, 0, 0, 2, 2 },
				{ 3, 4, 2, 2, 5, 3, 2, 2 },
				{ 3, 5, 2, 2, 3, 1, 2, 2 },
				{ 4, 0, 3, 1, 3, 3, 3, 3 },
				{ 4, 1, 3, 5, 5, 5, 3, 3 },
				{ 4, 2, 3, 3, 6, 4, 7, 5 },
				{ 4, 3, 3, 3, 8, 6, 5, 3 },
				{ 5, 0, 1, 3, 1, 1, 1, 1 },
				{ 5, 1, 3, 5, 3, 3, 1, 1 },
				{ 5, 2, 1, 5, 6, 4, 3, 1 },
				{ 5, 3, 1, 5, 4, 2, 1, 3 } }; 
		
		
		
		
		final int[] rot = new int[6];
		
		
		if (up == Color.YELLOW) {
		}
		else if (up == Color.RED) {
			rot[Color.GREEN.toInt()] += 1;
			rot[Color.BLUE.toInt()] += 3;
			
			rot[Color.WHITE.toInt()] += 2;
			rot[Color.ORANGE.toInt()] += 2;
		}
		else if (up == Color.WHITE) {
			rot[Color.BLUE.toInt()] += 2;
			rot[Color.GREEN.toInt()] += 2;
			
			rot[Color.RED.toInt()] += 2;
			rot[Color.ORANGE.toInt()] += 2;
		}
		else if (up == Color.ORANGE) {
			rot[Color.GREEN.toInt()] += 3;
			rot[Color.BLUE.toInt()] += 1;

			rot[Color.YELLOW.toInt()] += 2;
			rot[Color.ORANGE.toInt()] += 2;
		}
		else if (up == Color.BLUE) {
			// rotate ALL
			rot[Color.GREEN.toInt()] += 1;
			rot[Color.BLUE.toInt()] += 1;

			rot[Color.YELLOW.toInt()] += 1;
			rot[Color.ORANGE.toInt()] += 3;
			rot[Color.RED.toInt()] += 1;
			rot[Color.WHITE.toInt()] += 1;
		}		
		else if (up == Color.GREEN) {
			//opposite of blue
			rot[Color.GREEN.toInt()] += 3;
			rot[Color.BLUE.toInt()] += 3;

			rot[Color.YELLOW.toInt()] += 3;
			rot[Color.ORANGE.toInt()] += 1;
			rot[Color.RED.toInt()] += 3;
			rot[Color.WHITE.toInt()] += 3;
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
							lookfor == front.next(up) ? 1:
								lookfor == front.opposite() ? 2 : 3;
		

		rot[Color.YELLOW.toInt()] += howmany;
		rot[Color.WHITE.toInt()] += howmany;

		if (up == Color.YELLOW) {
			if (front == Color.GREEN || front == Color.BLUE)
				rot[Color.YELLOW.toInt()] += 2;
		}
		else if (up == Color.RED) {
			int t = front == Color.GREEN ? 3 : front == Color.YELLOW ? 2 : front == Color.BLUE ? 1 : 0;
			
			rot[Color.GREEN.toInt()] += t;
			rot[Color.BLUE.toInt()] += t;
			rot[Color.RED.toInt()] += t;
			rot[Color.ORANGE.toInt()] += t;
			
			if (front == Color.GREEN || front == Color.BLUE) {
				rot[Color.YELLOW.toInt()] += 2;
				rot[Color.BLUE.toInt()] += 2;
				rot[Color.GREEN.toInt()] += 2;
				rot[Color.RED.toInt()] += 2;
			}
		}
		else if (up == Color.ORANGE) {
			int t = front == Color.GREEN ? 1 : front == Color.YELLOW ? 2 : front == Color.BLUE ? 3 : 0;
			
			rot[Color.GREEN.toInt()] += t;
			rot[Color.BLUE.toInt()] += t;
			rot[Color.RED.toInt()] += t;
			rot[Color.ORANGE.toInt()] += t;
			
			rot[Color.GREEN.toInt()] += 2;
			rot[Color.BLUE.toInt()] += 2;
			rot[Color.RED.toInt()] += 2;
			rot[Color.ORANGE.toInt()] += 2;
				
			if (front == Color.BLUE || front == Color.GREEN)
				rot[Color.YELLOW.toInt()] += 2;
		}
		else if (up == Color.BLUE) {
			if (front != Color.RED)
				rot[Color.ORANGE.toInt()] += 2;
			
			if (front == Color.ORANGE) {
				rot[Color.RED.toInt()] += 2;
			}
			else if (front == Color.YELLOW) {
				rot[Color.YELLOW.toInt()] += 2;
				rot[Color.GREEN.toInt()] += 2;		
			}
			else if (front == Color.WHITE) {
				rot[Color.YELLOW.toInt()] += 2;
				rot[Color.BLUE.toInt()] += 2;
			}
		}
		else if (up == Color.WHITE) {
			if (front == Color.GREEN || front == Color.BLUE) {
				rot[Color.YELLOW.toInt()] += 2;
			}
		}
		else if (up == Color.GREEN) {
			if (front != Color.RED)
				rot[Color.ORANGE.toInt()] += 2;

			if (front == Color.YELLOW) {
				rot[Color.BLUE.toInt()] += 2;
				rot[Color.GREEN.toInt()] += 2;
			}			
			
			if (front == Color.ORANGE) {
				rot[Color.ORANGE.toInt()] += 2;
			}
			else if (front == Color.YELLOW || front == Color.WHITE) {
				rot[Color.YELLOW.toInt()] += 2;
				rot[Color.GREEN.toInt()] += 2;
			}
		}
		
//		System.out.print("Front: "+front.toString()+"\tUp: "+up.toString()+"\tLookfor: "+lookfor+"\tRot="+howmany);
//		System.out.print("\tIdx: ");
		
		System.out.print(""+up.toInt()+"\t"+front.toInt());
		
		for (Color color : Color.ALL) {
			final int idx = color.toInt();
			rotate(colors[idx], rot[idx]);
			
//			System.out.print(color.toString()+"="+rot[idx]+ " ");
			System.out.print("\t"+rot[idx]);
		}
		System.out.println();

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
