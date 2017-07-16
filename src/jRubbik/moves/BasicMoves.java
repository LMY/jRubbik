package jRubbik.moves;

import jRubbik.constants.Color;

public class BasicMoves {
	
	public static IMove MOVE_F = new Move(Color.RED, 0);
	public static IMove MOVE_B = new Move(Color.ORANGE, 0);
	public static IMove MOVE_U = new Move(Color.YELLOW, 0);
	public static IMove MOVE_D = new Move(Color.WHITE, 0);
	public static IMove MOVE_R = new Move(Color.GREEN, 0);
	public static IMove MOVE_L = new Move(Color.BLUE, 0);
	
	public static IMove MOVE_Fi = new Move(Color.RED, 1);
	public static IMove MOVE_Bi = new Move(Color.ORANGE, 1);
	public static IMove MOVE_Ui = new Move(Color.YELLOW, 1);
	public static IMove MOVE_Di = new Move(Color.WHITE, 1);
	public static IMove MOVE_Ri = new Move(Color.GREEN, 1);
	public static IMove MOVE_Li = new Move(Color.BLUE, 1);
	
	public static IMove MOVE_F2 = new Move(Color.RED, 2);
	public static IMove MOVE_B2 = new Move(Color.ORANGE, 2);
	public static IMove MOVE_U2 = new Move(Color.YELLOW, 2);
	public static IMove MOVE_D2 = new Move(Color.WHITE, 2);
	public static IMove MOVE_R2 = new Move(Color.GREEN, 2);
	public static IMove MOVE_L2 = new Move(Color.BLUE, 2);
	
	public static IMove MOVE_x = new MoveOrientation(MoveOrientation.MOVE_X, 0);
	public static IMove MOVE_y = new MoveOrientation(MoveOrientation.MOVE_Y, 0);
	public static IMove MOVE_z = new MoveOrientation(MoveOrientation.MOVE_Z, 0);
	
	public static IMove MOVE_xi = new MoveOrientation(MoveOrientation.MOVE_X, 1);
	public static IMove MOVE_yi = new MoveOrientation(MoveOrientation.MOVE_Y, 1);
	public static IMove MOVE_zi = new MoveOrientation(MoveOrientation.MOVE_Z, 1);
	
	public static IMove MOVE_x2 = new MoveOrientation(MoveOrientation.MOVE_X, 2);
	public static IMove MOVE_y2 = new MoveOrientation(MoveOrientation.MOVE_Y, 2);
	public static IMove MOVE_z2 = new MoveOrientation(MoveOrientation.MOVE_Z, 2);
	
	


	public static IMove MOVE_M = new MoveDescription(new CombinedMove(MOVE_R, MOVE_Li, MOVE_x), "M", true);
	public static IMove MOVE_Mi = new MoveDescription(new CombinedMove(MOVE_Ri, MOVE_L, MOVE_xi), "Mi", true);
	
	public static IMove MOVE_E = new MoveDescription(new CombinedMove(MOVE_U, MOVE_Di, MOVE_y), "E", true);
	public static IMove MOVE_Ei = new MoveDescription(new CombinedMove(MOVE_Ui, MOVE_D, MOVE_yi), "Ei", true);

	public static IMove MOVE_S = new MoveDescription(new CombinedMove(MOVE_Fi, MOVE_B, MOVE_z), "S", true);
	public static IMove MOVE_Si = new MoveDescription(new CombinedMove(MOVE_F, MOVE_Bi, MOVE_zi), "Si", true);
	
	
}
