package jRubbik.state;

import jRubbik.constants.Color;
import jRubbik.constants.Constants;

public class NewCubeDisplayer {

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

				getEffectiveEdgeColor(4, 0, edges, state_edges),	// Color.INVALID
				Color.RED,
				getEffectiveEdgeColor(5, 0, edges, state_edges),	// Color.INVALID

				getEffectiveCornerColor(0, 1, corners, state_corners),
				getEffectiveEdgeColor(1, 1, edges, state_edges),
				getEffectiveCornerColor(1, 1, corners, state_corners)
			},

			/* front = ORANGE */  {
				getEffectiveCornerColor(7, 1, corners, state_corners),
				getEffectiveEdgeColor(11, 1, edges, state_edges),
				getEffectiveCornerColor(6, 1, corners, state_corners),

				getEffectiveEdgeColor(7, 0, edges, state_edges),
				Color.ORANGE,
				getEffectiveEdgeColor(6, 0, edges, state_edges),

				getEffectiveCornerColor(3, 1, corners, state_corners),
				getEffectiveEdgeColor(3, 1, edges, state_edges),
				getEffectiveCornerColor(2, 1, corners, state_corners)
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

		Color up = state.getOrientation().getUp();
		Color front = state.getOrientation().getFront();

		int rotn = 0;
		Color[] cycleColors = null;
		int cyclen = 0;

		System.out.println("Front: "+front.toString()+"\tUp: "+up.toString());

		if (up == Color.YELLOW) {
			cycleColors = new Color[] { Color.GREEN, Color.ORANGE, Color.BLUE, Color.RED };

			if (front == Color.RED)
				;
			else if (front == Color.GREEN) {
				cycle(colors, cycleColors, 1);
				rotate(colors[Color.YELLOW.toInt()], 3);
				rotate(colors[Color.WHITE.toInt()], 1);
				invertHor(colors[Color.BLUE.toInt()]);
//				invertHor(colors[Color.GREEN.toInt()]);
			}
			else if (front == Color.ORANGE) {
				cycle(colors, cycleColors, 2);
				invertHor(colors[Color.YELLOW.toInt()]);
				invertHor(colors[Color.RED.toInt()]);
				invertHor(colors[Color.WHITE.toInt()]);
			}
			else if (front == Color.BLUE) {
				cycle(colors, cycleColors, 3);
				rotate(colors[Color.YELLOW.toInt()], 1);
				rotate(colors[Color.WHITE.toInt()], 3);
				invertHor(colors[Color.GREEN.toInt()]);
			}
		}
		else if (up == Color.WHITE) {
			rotn = 2;
			cycleColors = new Color[] { Color.GREEN, Color.ORANGE, Color.BLUE, Color.RED };

			swapVertical(colors, Color.WHITE.toInt(), Color.YELLOW.toInt());
			
			if (front == Color.RED) {
				swap(colors, Color.WHITE.toInt(), Color.YELLOW.toInt());
				swap(colors, Color.BLUE.toInt(), Color.GREEN.toInt());
			}
			else if (front == Color.GREEN) {
//				swap(colors, Color.GREEN.toInt(), Color.YELLOW.toInt());
//				swap(colors, Color.WHITE.toInt(), Color.YELLOW.toInt());
			}
			else if (front == Color.ORANGE)
				cycle(colors, cycleColors, 2);
			else if (front == Color.BLUE)
				cycle(colors, cycleColors, 1);
		}
		else if (up == Color.GREEN) {
			rotn = 1;
			cycleColors = new Color[] { Color.RED, Color.WHITE, Color.ORANGE, Color.YELLOW };

			if (front == Color.RED) {
				swap(colors, Color.WHITE.toInt(), Color.YELLOW.toInt());
				swap(colors, Color.BLUE.toInt(), Color.GREEN.toInt());
			}
			else if (front == Color.WHITE)
				cyclen = 1;
			else if (front == Color.ORANGE)
				cyclen = 2;
			else if (front == Color.YELLOW)
				cyclen = 3;
		}
		else if (up == Color.BLUE) {
			rotn = 3;
			cycleColors = new Color[] { Color.RED, Color.WHITE, Color.ORANGE, Color.YELLOW };

			if (front == Color.RED)
				cyclen = 0;
			else if (front == Color.WHITE)
				cyclen = 3;
			else if (front == Color.ORANGE)
				cyclen = 2;
			else if (front == Color.YELLOW)
				cyclen = 1;
		}
		else if (up == Color.RED) {
			cycleColors = new Color[] { Color.WHITE, Color.GREEN, Color.YELLOW, Color.BLUE };

			if (front == Color.WHITE) {
				rotn = 0;
				cyclen = 0;
			}
			else if (front == Color.GREEN) {
				rotn = 3;
				cyclen = 0;
			}
			else if (front == Color.YELLOW) {
				rotn = 2;
				cyclen = 0;
			}
			else if (front == Color.BLUE) {
				rotn = 1;
				cyclen = 0;
			}
		}

		return colors;
	}


	private static void invertHor(Color[] colors) {
		
		for (int y=0; y<3; y++)
		for (int i=0; i<3; i++) {
			Color temp = colors[3*i];
			colors[3*i] = colors[3*i+2];
			colors[3*i+2] = temp;
		}
	}

	public static void cycle(Color[][] colors, Color[] c, int times) {
		
		if (colors == null)
			return;
		
		int[] itc = new int[c.length];

		for (int i=0; i<c.length; i++)
			itc[i] = c[i].toInt();

		cycle(colors, itc, times);
	}

	public static void cycle(Color[][] colors, int[] c, int times) {

		for (int k=0; k<times; k++) {
			Color[] temp = colors[c[c.length-1]];

			for (int i=c.length-1; i>0; i--)
				colors[c[i]] = colors[c[i-1]];

			colors[c[0]] = temp;
		}
	}
	
	public static void swap(Color[][] colors, int i1, int i2) {
		Color[] temp = colors[i1];
		colors[i1] = colors[i2];
		colors[i2] = temp;
	}
	
	
	public static void swapVertical(Color[][] colors, int i1, int i2) {
		Color[] temp = colors[i1];
		colors[i1] = colors[i2];
		colors[i2] = temp;
		
		swap(colors[i1], 0, 2);
		swap(colors[i2], 0, 2);
	}
	
	
	public static void swap(Color[] colors, int i1, int i2) {
		Color temp = colors[i1];
		colors[i1] = colors[i2];
		colors[i2] = temp;
	}

	public static void rotate(Color[][] colors, int q) {
		
		if (q > 0)
			for (Color color : Color.ALL)
				rotate(colors[color.toInt()], q);
	}
	
	public static void rotate(Color[] colors, int q) {

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
			swap(colors, 1, 7);
			swap(colors, 3, 5);

			swap(colors, 0, 8);
			swap(colors, 6, 2);
		}
		else {	//if (q == -3)
			swap(colors, 7, 5);
			swap(colors, 3, 7);
			swap(colors, 1, 3);

			swap(colors, 8, 2);
			swap(colors, 6, 8);
			swap(colors, 0, 6);
		}
	}

}
