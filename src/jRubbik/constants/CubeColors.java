package jRubbik.constants;

import jRubbik.state.OrientatonState;

public class CubeColors {

	public final static OrientatonState[] Corners = new OrientatonState[]{
			new OrientatonState(Color.RED, Color.YELLOW),
			new OrientatonState(Color.GREEN, Color.YELLOW),
			new OrientatonState(Color.ORANGE, Color.YELLOW),
			new OrientatonState(Color.BLUE, Color.YELLOW),
			
			new OrientatonState(Color.RED, Color.WHITE),
			new OrientatonState(Color.GREEN, Color.WHITE),
			new OrientatonState(Color.ORANGE, Color.WHITE),
			new OrientatonState(Color.BLUE, Color.WHITE),
	};
	
	public final static OrientatonState[] Edges = new OrientatonState[]{
			new OrientatonState(Color.BLUE, Color.YELLOW),
			new OrientatonState(Color.RED, Color.YELLOW),
			new OrientatonState(Color.GREEN, Color.YELLOW),
			new OrientatonState(Color.ORANGE, Color.YELLOW),
			
			new OrientatonState(Color.RED, Color.GREEN),
			new OrientatonState(Color.GREEN, Color.ORANGE),
			new OrientatonState(Color.ORANGE, Color.BLUE),
			new OrientatonState(Color.BLUE, Color.RED),
			
			new OrientatonState(Color.BLUE, Color.WHITE),
			new OrientatonState(Color.RED, Color.WHITE),
			new OrientatonState(Color.GREEN, Color.WHITE),
			new OrientatonState(Color.ORANGE, Color.WHITE),
	};
	
	public static Color getCornerColor(int idx, Color face) {
		return Corners[idx].get(Corners[idx].whereis(face));
	}
	
	public static Color getEdgeColor(int idx, Color face) {
		return Edges[idx].get(Edges[idx].whereis(face));
	}
	
//	public static Color getEdgeColor(CubeState state, Color face, int idx) 
//	{
//		return Edges[idx].get(face);
//	}
//	
//	public static Color getCornerColor(CubeState state, Color face, int idx) 
//	{
//		return Corners[idx].get(face);
////		
////		int[] corners = state.getCorners();
////		int[] edges = state.getEdges();
////		
////		int[] state_corners = state.getState_corners();
////		int[] state_edges = state.getState_edges();
////		
////		final OrientatonState orient = state.getOrientation();
////		
////		Color whereis = orient.whereis(face);
////		
////		boolean isForB = whereis == Color.RED || whereis == Color.ORANGE;
////		boolean isRorL = whereis == Color.BLUE || whereis == Color.GREEN;
////		
////		int idx2 = orient.corners_permutations(whereis)[idx];
////		
//	}
}
