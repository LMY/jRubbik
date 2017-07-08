package jRubbik.moves;

import jRubbik.constants.Constants;
import jRubbik.state.CubeState;

public class Move extends IMove {
	
	public static IMove MOVE_U = new Move(2, 0);
	
	private int dir;
	private boolean reverse;
	private int reps;
	
	public Move(int dir, int reverse) {
		this.dir = dir;
		this.reverse = reverse==1;
		this.reps = reverse==2?2:1;
	}

	public int getDir() {
		return dir;
	}

	public boolean isReverse() {
		return reverse;
	}

	public int getReps() {
		return reps;
	}

	
	@Override
	public String toString() {
		return Constants.KubeMoveNames[dir]+(reps==2?"2":reverse?"'":"");
	}

	@Override
	public void apply(CubeState state) {
		
		permEdges(state);
		permCorners(state);
	}
	
	protected void permEdges(CubeState st) {
		
		int[] dispo = st.getEdges();
		int[] state = st.getState_edges();
		
		final int[] permutation = st.getOrientation().edges_permutations(dir);
		boolean inverts_edges = st.getOrientation().inverts_edges(dir);
		
		for (int i=0; i<reps; i++) {
			Constants.permutate(dispo, permutation, isReverse());
	
			// moves { F, Fi, B, Bi } toggle the state of affected edges
			if (inverts_edges)
				for (final int p : permutation)
					state[dispo[p]] ^= 1;
		}
	}

	protected void permCorners(CubeState st) {

		int[] dispo = st.getCorners();
		int[] state = st.getState_corners();
		
		
		final int[] permutation = st.getOrientation().corners_permutations(dir);
		final int const_rot_axis = st.getOrientation().const_rot_axis(dir);

		for (int i=0; i<reps; i++) {
			// calculate new states of corners
			for (int k=0; k<permutation.length; k++) {
				final int p = permutation[k];
				
				state[dispo[p]] = Constants.rotate_corner(state[dispo[p]], const_rot_axis);
//				state[p] = Constants.rotate_corner(state[p], const_rot_axis);				
			}
	
			// permutation of corners
			Constants.permutate(dispo, permutation, isReverse());
		}
	}

	@Override
	public IMove reverse() {
		return new Move(dir, reps==2?2 :  reverse?0:1 );
	}

	@Override
	public IMove times(int n) {
		
		while (n < 0)
			n += 4;
		n %= 4;
		
		if (n == 0)
			return NullMove.NULL;
		if (n == 1)
			return this;
		if (n == 2) {
			if (reps == 2)
				return NullMove.NULL;
			else
				return  new Move(dir, 2);
		}
		//if (n == 3)
			return reverse();
	}

	@Override
	public int length() {
		return 1;
	}

	@Override
	public int length_htm() {
		return reps;
	}
}
