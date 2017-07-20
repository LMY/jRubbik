package jRubbik.state;

import jRubbik.utils.Utils;

public class CubeState {
	
	private int[] edges;
	private int[] corners;
	private int[] state_edges;
	private int[] state_corners;
	
	private OrientatonState orientation;
	
	public void resetOrientation() {
		orientation = new OrientatonState();
	}
	public OrientatonState getOrientation() {
		return orientation;
	}

	public void setOrientation(OrientatonState orientation) {
		this.orientation = orientation;
	}

	public static final int EDGES_COUNT = 12;
	public static final int CORNERS_COUNT = 8;
	
	public CubeState()
	{
		edges = new int[EDGES_COUNT];
		corners = new int[CORNERS_COUNT];
		state_edges = new int[EDGES_COUNT];
		state_corners = new int[CORNERS_COUNT];
		
		for (int i=0; i<EDGES_COUNT; i++)
		{
			edges[i] = i;
			state_edges[i] = 0;
		}
		
		for (int i=0; i<CORNERS_COUNT; i++)
		{
			corners[i] = i;
			state_corners[i] = 0;
		}
		
		resetOrientation();
	}
	
	public CubeState(CubeState cc)
	{
		this(Utils.cloneArray(cc.getEdges()),
				Utils.cloneArray(cc.getCorners()),
				Utils.cloneArray(cc.getState_edges()),
				Utils.cloneArray(cc.getState_corners()), cc.orientation.clone());
	}
	
	public CubeState(int[] edges, int[] corners, int[] state_edges, int[] state_corners, OrientatonState orientation)
	{
		this.edges = edges;
		this.corners = corners;
		this.state_edges = state_edges;
		this.state_corners = state_corners;
		this.orientation = orientation;
	}
	
	
	public CubeState clone() {
		return new CubeState(this);
	}
	
	
	
	public boolean isSolved()
	{
		for (int i=0; i<EDGES_COUNT; i++)
		{
			if (edges[i] != i)
				return false;
			if (state_edges[i] != 0)
				return false;
		}
		
		for (int i=0; i<CORNERS_COUNT; i++)
		{
			if (corners[i] != i)
				return false;
			if (state_corners[i] != 0)
				return false;
		}
		
		return true;
	}


	
	public int[] getEdges() {
		return edges;
	}

	public void setEdges(int[] edges) {
		this.edges = edges;
	}

	public int[] getCorners() {
		return corners;
	}

	public void setCorners(int[] corners) {
		this.corners = corners;
	}

	public int[] getState_edges() {
		return state_edges;
	}

	public void setState_edges(int[] state_edges) {
		this.state_edges = state_edges;
	}

	public int[] getState_corners() {
		return state_corners;
	}

	public void setState_corners(int[] state_corners) {
		this.state_corners = state_corners;
	}
}
