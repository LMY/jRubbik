package jRubbik.moves;

import jRubbik.constants.Color;

public class BasicMoves {
	
	// STANDARD MOVES
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
	
	
	// ORIENTATION
	public static IMove MOVE_x = new MoveOrientation(MoveOrientation.MOVE_X, 0);
	public static IMove MOVE_y = new MoveOrientation(MoveOrientation.MOVE_Y, 0);
	public static IMove MOVE_z = new MoveOrientation(MoveOrientation.MOVE_Z, 0);
	
	public static IMove MOVE_xi = new MoveOrientation(MoveOrientation.MOVE_X, 1);
	public static IMove MOVE_yi = new MoveOrientation(MoveOrientation.MOVE_Y, 1);
	public static IMove MOVE_zi = new MoveOrientation(MoveOrientation.MOVE_Z, 1);
	
	public static IMove MOVE_x2 = new MoveOrientation(MoveOrientation.MOVE_X, 2);
	public static IMove MOVE_y2 = new MoveOrientation(MoveOrientation.MOVE_Y, 2);
	public static IMove MOVE_z2 = new MoveOrientation(MoveOrientation.MOVE_Z, 2);
	

	// MIDDLE LAYER MOVES
	public static IMove MOVE_M = new MoveDescription(new CombinedMove(MOVE_R, MOVE_Li, MOVE_xi), "M", true);
	public static IMove MOVE_Mi = new MoveDescription(new CombinedMove(MOVE_Ri, MOVE_L, MOVE_x), "M'", true);
	public static IMove MOVE_M2 = new MoveDescription(new CombinedMove(MOVE_R2, MOVE_L2, MOVE_x2), "M2", true);
	
	public static IMove MOVE_E = new MoveDescription(new CombinedMove(MOVE_U, MOVE_Di, MOVE_yi), "E", true);
	public static IMove MOVE_Ei = new MoveDescription(new CombinedMove(MOVE_Ui, MOVE_D, MOVE_y), "E'", true);
	public static IMove MOVE_E2 = new MoveDescription(new CombinedMove(MOVE_U2, MOVE_D2, MOVE_y2), "E2", true);

	public static IMove MOVE_S = new MoveDescription(new CombinedMove(MOVE_Fi, MOVE_B, MOVE_z), "S", true);
	public static IMove MOVE_Si = new MoveDescription(new CombinedMove(MOVE_F, MOVE_Bi, MOVE_zi), "S'", true);
	public static IMove MOVE_S2 = new MoveDescription(new CombinedMove(MOVE_F2, MOVE_B2, MOVE_z2), "S2", true);
	
	
	// FAT TURNS
	public static IMove MOVE_r = new MoveDescription(new CombinedMove(MOVE_L, null, MOVE_x), "r", true);
	public static IMove MOVE_l = new MoveDescription(new CombinedMove(MOVE_R, null, MOVE_xi), "l", true);
	public static IMove MOVE_u = new MoveDescription(new CombinedMove(MOVE_D, null, MOVE_y), "u", true);
	public static IMove MOVE_d = new MoveDescription(new CombinedMove(MOVE_U, null, MOVE_yi), "d", true);
	public static IMove MOVE_f = new MoveDescription(new CombinedMove(MOVE_B, null, MOVE_z), "f", true);
	public static IMove MOVE_b = new MoveDescription(new CombinedMove(MOVE_F, null, MOVE_zi), "b", true);
	
	public static IMove MOVE_ri = new MoveDescription(new CombinedMove(MOVE_Li, null, MOVE_xi), "r'", true);
	public static IMove MOVE_li = new MoveDescription(new CombinedMove(MOVE_Ri, null, MOVE_x), "l'", true);
	public static IMove MOVE_ui = new MoveDescription(new CombinedMove(MOVE_Di, null, MOVE_yi), "u'", true);
	public static IMove MOVE_di = new MoveDescription(new CombinedMove(MOVE_Ui, null, MOVE_y), "d'", true);
	public static IMove MOVE_fi = new MoveDescription(new CombinedMove(MOVE_Bi, null, MOVE_zi), "f'", true);
	public static IMove MOVE_bi = new MoveDescription(new CombinedMove(MOVE_Fi, null, MOVE_z), "b'", true);
	
	public static IMove MOVE_r2 = new MoveDescription(new CombinedMove(MOVE_L2, null, MOVE_x2), "r2", true);
	public static IMove MOVE_l2 = new MoveDescription(new CombinedMove(MOVE_R2, null, MOVE_x2), "l2", true);
	public static IMove MOVE_u2 = new MoveDescription(new CombinedMove(MOVE_D2, null, MOVE_y2), "u2", true);
	public static IMove MOVE_d2 = new MoveDescription(new CombinedMove(MOVE_U2, null, MOVE_y2), "d2", true);
	public static IMove MOVE_f2 = new MoveDescription(new CombinedMove(MOVE_B2, null, MOVE_z2), "f2", true);
	public static IMove MOVE_b2 = new MoveDescription(new CombinedMove(MOVE_F2, null, MOVE_z2), "b2", true);
	
	
	
	// DEFINE COLLECTIONS
	public static final IMove[] ALL_SIMPLE = { MOVE_F, MOVE_B, MOVE_U, MOVE_D, MOVE_R, MOVE_L };
	public static final IMove[] ALL_SIMPLE_INV = { MOVE_Fi, MOVE_Bi, MOVE_Ui, MOVE_Di, MOVE_Ri, MOVE_Li };
	public static final IMove[] ALL_SIMPLE2 = { MOVE_F2, MOVE_B2, MOVE_U2, MOVE_D2, MOVE_R2, MOVE_L2 };
	
	public static final IMove[] ALL_ORIENTATION = {  MOVE_x, MOVE_y, MOVE_z };
	public static final IMove[] ALL_ORIENTATION_INV = {  MOVE_xi, MOVE_yi, MOVE_zi };
	public static final IMove[] ALL_ORIENTATION2 = {  MOVE_x2, MOVE_y2, MOVE_z2 };
	
	public static final IMove[] ALL_MIDDLE = { MOVE_M, MOVE_E, MOVE_S };
	public static final IMove[] ALL_MIDDLE_INV = { MOVE_Mi, MOVE_Ei, MOVE_Si };
	public static final IMove[] ALL_MIDDLE2 = { MOVE_M2, MOVE_E2, MOVE_S2 };
	
	
	public static final IMove[] ALL_DOUBLE = { MOVE_f, MOVE_b, MOVE_u, MOVE_d, MOVE_r, MOVE_l };
	public static final IMove[] ALL_DOUBLE_INV = { MOVE_fi, MOVE_bi, MOVE_ui, MOVE_di, MOVE_ri, MOVE_li };
	public static final IMove[] ALL_DOUBLE2 = { MOVE_f2, MOVE_b2, MOVE_u2, MOVE_d2, MOVE_r2, MOVE_l2 };
	
	
	
	
	// CUSTOM SEQUENCES
	public static IMove OFFICIAL_SCRAMBLE = new MoveDescription(MoveParser.parseSequence("R2 B2 R2 L' B' R2 U2 B2 F R U2 B2 F' D' R' F R2 L2 B' U'"), "OFFICIAL SCRAMBLE", true);
	
	public static IMove PLL_Ua = new MoveDescription(MoveParser.parseSequence("(R U')(R U)(R U)(R U') R' U' R2"), "Ua", true);
	public static IMove PLL_Ub = new MoveDescription(MoveParser.parseSequence("R2 U (R U R' U')(R' U')(R' U R')"), "Ub", true);
	public static IMove PLL_Z = new MoveDescription(MoveParser.parseSequence("M2 U M2 U M' U2 M2 U2 M' U2"), "Z", true);
	public static IMove PLL_H = new MoveDescription(MoveParser.parseSequence("M2 U M2 U2 M2 U M2"), "H", true);
	
	public static IMove PLL_Aa = new MoveDescription(MoveParser.parseSequence("x (R' U R') D2 (R U' R') D2 R2 x'"), "Aa", true);
	public static IMove PLL_Ab = new MoveDescription(MoveParser.parseSequence("x' (R U' R) D2 (R' U R) D2 R2 x"), "Ab", true);
	public static IMove PLL_E = new MoveDescription(MoveParser.parseSequence("x' (R U' R') D (R U R') D' (R U R') D (R U' R') D' x"), "E", true);
	
	
	public static final IMove[] CUSTOM_SEQUENCES = { PLL_Ua, PLL_Ub, PLL_Z, PLL_H, PLL_Aa, PLL_Ab, PLL_E, OFFICIAL_SCRAMBLE };
	
	
	
	
	
	
	
	
	public static final IMove[][] ALL_COLLECTIONS = { 
			ALL_SIMPLE, ALL_SIMPLE_INV, ALL_SIMPLE2,
			ALL_ORIENTATION, ALL_ORIENTATION_INV, ALL_ORIENTATION2,
			ALL_MIDDLE, ALL_MIDDLE_INV, ALL_MIDDLE2,
			ALL_DOUBLE, ALL_DOUBLE_INV, ALL_DOUBLE2,
			CUSTOM_SEQUENCES,
	};
}
