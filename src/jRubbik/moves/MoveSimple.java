package jRubbik.moves;

import jRubbik.constants.Color;
import jRubbik.constants.Constants;
import jRubbik.state.CubeState;
import jRubbik.state.OrientatonState;

public class MoveSimple extends FlyWeightMove {

	public MoveSimple(Color dir, int reps) {
		super(dir, reps);
	}

	@Override
	protected String[] getArrayNames()  { return BasicMoves.NAMES_SIMPLE; }
	@Override
	protected IMove[] getArrayNormal()  { return BasicMoves.ALL_SIMPLE; }
	@Override
	protected IMove[] getArrayInverse() { return BasicMoves.ALL_SIMPLE_INV; }
	@Override
	protected IMove[] getArrayDouble()  { return BasicMoves.ALL_SIMPLE2; }
	
	@Override
	public int length() {
		return 1;
	}

	@Override
	public int length_htm() {
		return getReps();
	}
	
	@Override
	public void apply(CubeState state) {
		
		final Color dir = getDir();
		final int reps = getReps();
		final boolean reverse = isReverse();
		
		permEdges(state, dir, reps, reverse);
		permCorners(state, dir, reps, reverse);
	}
	
	private static void permEdges(CubeState st, Color dir, int reps, boolean reverse) {

		final int[] dispo = st.getEdges();
		final int[] state = st.getState_edges();
		
		final int[] permutation = st.getOrientation().edges_permutations(dir);
		final boolean inverts_edges = st.getOrientation().inverts_edges(dir);
		
		for (int i=0; i<(reps==2?2:1); i++) {
			Constants.permutate(dispo, permutation, reverse);
	
			// moves { F, Fi, B, Bi } toggle the state of affected edges
			if (inverts_edges)
				for (final int p : permutation)
					state[dispo[p]] ^= 1;
		}
	}

	private static void permCorners(CubeState st, Color dir, int reps, boolean reverse) {

		final int[] dispo = st.getCorners();
		final int[] state = st.getState_corners();
		
		final int[] permutation = st.getOrientation().corners_permutations(dir);
		final int const_rot_axis = st.getOrientation().const_rot_axis(dir);

		for (int i=0; i<(reps==2?2:1); i++) {
			// calculate new states of corners
			for (int k=0; k<permutation.length; k++) {
				final int p = permutation[k];
				
				state[dispo[p]] = Constants.rotate_corner(state[dispo[p]], const_rot_axis);
			}
	
			// permutation of corners
			Constants.permutate(dispo, permutation, reverse);
		}
	}
	
	@Override
	public IMove orient(OrientatonState state) {
		return BasicMoves.color2simpleMove(state.get(getDir()), getReps());
	}
}
