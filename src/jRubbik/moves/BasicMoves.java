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
	
	public static IMove color2move(Color color, int mod) {
			return mod == 2 ? ALL_SIMPLE2[color.toInt()] :
				   mod == 1 ? ALL_SIMPLE_INV[color.toInt()] :
					   ALL_SIMPLE[color.toInt()];
	}
	
	
	// CUSTOM SEQUENCES
	public static IMove OFFICIAL_SCRAMBLE = new MoveDescription(MoveParser.parseSequence("R2 B2 R2 L' B' R2 U2 B2 F R U2 B2 F' D' R' F R2 L2 B' U'"), "OFFICIAL SCRAMBLE", true);
	
	
	public static IMove OLL_OCLL1 = MoveParser.parseLine("OLL_OCLL1;(R U R' U) R U2 R'");
	public static IMove OLL_OCLL2 = MoveParser.parseLine("OLL_OCLL2;R U2 R' U' R U' R'");
	public static IMove OLL_OCLL3 = MoveParser.parseLine("OLL_OCLL3;f (R U R' U') f' F (R U R' U') F'");
	public static IMove OLL_OCLL4 = MoveParser.parseLine("OLL_OCLL4;F (R U R' U') (R U R' U') (R U R' U') F'");
	public static IMove OLL_OCLL5 = MoveParser.parseLine("OLL_OCLL5;(r U R' U') (r' F R F')");
	public static IMove OLL_OCLL6 = MoveParser.parseLine("OLL_OCLL6;F' (r U R' U') (r' F R )");
	public static IMove OLL_OCLL7 = MoveParser.parseLine("OLL_OCLL7;R2 (D (R' U2) R) (D' (R' U2) R')");
	public static IMove OLL_solved = MoveParser.parseLine("OLL_solved;");
	public static IMove OLL_E1 = MoveParser.parseLine("OLL_E1;(R U R' U') M' (U R U' r')");
	public static IMove OLL_E2 = MoveParser.parseLine("OLL_E2; M' U M U2 M' U M");
	public static IMove OLL_P1 = MoveParser.parseLine("OLL_P1;f (R U R' U') f'");
	public static IMove OLL_P2 = MoveParser.parseLine("OLL_P2;f' (L' U' L U) f");
	public static IMove OLL_P3 = MoveParser.parseLine("OLL_P3;R U B' U' R' U R B R'");
	public static IMove OLL_P4 = MoveParser.parseLine("OLL_P4;R' U' F U R U' R' F' R");
	public static IMove OLL_W1 = MoveParser.parseLine("OLL_W1;(R U R' U) (R U' R' U') (R' F R F')");
	public static IMove OLL_W2 = MoveParser.parseLine("OLL_W2;(L' U' L U') (L' U L U) (L F' L' F)");
	public static IMove OLL_S1 = MoveParser.parseLine("OLL_S1;r U2 R' U' R U' r'");
	public static IMove OLL_S2 = MoveParser.parseLine("OLL_S2;r' U2 (R U R' U) r");
	public static IMove OLL_L1 = MoveParser.parseLine("OLL_L1;F (R U R' U') (R U R' U') F'");
	public static IMove OLL_L2 = MoveParser.parseLine("OLL_L2;F' (L' U' L U) (L' U' L U) F");
	public static IMove OLL_L3 = MoveParser.parseLine("OLL_L3;l' U' L U' L' U L U' L' U2 l");
	public static IMove OLL_L4 = MoveParser.parseLine("OLL_L4;(r U R' U) R U' R' U R U2 r'");
	public static IMove OLL_L5 = MoveParser.parseLine("OLL_L5;(R' F R' F') R2 U2 y (R' F R F')");
	public static IMove OLL_L6 = MoveParser.parseLine("OLL_L6;R' F R2 B' R2 F' R2 B R'");
	public static IMove OLL_F1 = MoveParser.parseLine("OLL_F1;(R U R' U') R' F R2 U R' U' F'");
	public static IMove OLL_F2 = MoveParser.parseLine("OLL_F2;(R U R' U) (R' F R F') R U2 R'");
	public static IMove OLL_F3 = MoveParser.parseLine("OLL_F3;(R U2 R') (R' F R F') (R U2 R')");
	public static IMove OLL_F4 = MoveParser.parseLine("OLL_F4;F R U' R' U' R U R' F'");
	public static IMove OLL_A1 = MoveParser.parseLine("OLL_A1;R2 U R' B' R U' R2 U R B R'");
	public static IMove OLL_A2 = MoveParser.parseLine("OLL_A2;(R U R' U') R U' R' F' U' F R U R'");
	public static IMove OLL_A3 = MoveParser.parseLine("OLL_A3;((R U R' U) R U2 R') (F (R U R' U') F')");
	public static IMove OLL_A4 = MoveParser.parseLine("OLL_A4;(R' F R F') (R' F R F') (R U R' U') (R U R')");
	public static IMove OLL_LB1 = MoveParser.parseLine("OLL_LB1;(r U R' U) R U2 r'");
	public static IMove OLL_LB2 = MoveParser.parseLine("OLL_LB2;r' U' R U' R' U2 r");
	public static IMove OLL_LB3 = MoveParser.parseLine("OLL_LB3;(F' (L' U' L U) F) y (F (R U R' U') F')");
	public static IMove OLL_LB4 = MoveParser.parseLine("OLL_LB4;(F (R U R' U') F') U (F (R U R' U') F' )");
	public static IMove OLL_LB5 = MoveParser.parseLine("OLL_LB5;R B' R' U' R U B U' R'");
	public static IMove OLL_LB6 = MoveParser.parseLine("OLL_LB6;R' (F (R U R' U') F') U R");
	public static IMove OLL_T1 = MoveParser.parseLine("OLL_T1;F (R U R' U') F'");
	public static IMove OLL_Xy = MoveParser.parseLine("OLL_T2;(R U R' U') (R' F R F')");
	public static IMove OLL_C1 = MoveParser.parseLine("OLL_C1;R' U' (R' F R F') U R");
	public static IMove OLL_C2 = MoveParser.parseLine("OLL_C2;(R U R2 U') (R' F) (R U) (R U') F'");
	public static IMove OLL_I1 = MoveParser.parseLine("OLL_I1;R' U2 R2 U R' U R U2 x' U' R' U");
	public static IMove OLL_I2 = MoveParser.parseLine("OLL_I2;(R U R' U) R d' R U' R' F'");
	public static IMove OLL_I3 = MoveParser.parseLine("OLL_I3;F (R U R' U') R F' (r U R' U') r'");
	public static IMove OLL_I4 = MoveParser.parseLine("OLL_I4;f (R U R' U') (R U R' U') f'");
	public static IMove OLL_K1 = MoveParser.parseLine("OLL_K1;(r U r') (R U R' U') (r U' r')");
	public static IMove OLL_K2 = MoveParser.parseLine("OLL_K2;(l' U' l) (L' U' L U) (l' U l)");
	public static IMove OLL_K3 = MoveParser.parseLine("OLL_K3;F U R U' R2 F' R (U R U' R')");
	public static IMove OLL_K4 = MoveParser.parseLine("OLL_K4;R' F R U R' F' R y' R U' R'");
	public static IMove OLL_O1 = MoveParser.parseLine("OLL_O1;R U2 R' (R' F R F') U2 (R' F R F')");
	public static IMove OLL_O2 = MoveParser.parseLine("OLL_O2;(F (R U R' U') F' ) (f (R U R' U') f')");
	public static IMove OLL_O3 = MoveParser.parseLine("OLL_O3;(f (R U R' U') f') U' (F (R U R' U') F' )");
	public static IMove OLL_O4 = MoveParser.parseLine("OLL_O4;(f (R U R' U') f') U (F (R U R' U') F' )");
	public static IMove OLL_O5 = MoveParser.parseLine("OLL_O5;(F (R U R' U) F') y' U2 (R' F R F')");
	public static IMove OLL_O6 = MoveParser.parseLine("OLL_O6;M U (R U R' U') M' (R' F R F')");
	public static IMove OLL_O7 = MoveParser.parseLine("OLL_O7;(R U R' U) (R' F R F') U2 (R' F R F')");
	public static IMove OLL_O8 = MoveParser.parseLine("OLL_O8;M U (R U R' U') M2 (U R U' r')");
	
	public static IMove PLL_Ua = MoveParser.parseLine("PLL_Ua;(R U')(R U)(R U)(R U') R' U' R2");
	public static IMove PLL_Ub = MoveParser.parseLine("PLL_Ub;R2 U (R U R' U')(R' U')(R' U R')");
	public static IMove PLL_Z = MoveParser.parseLine("PLL_Z;U2 (R U R' U)(R' U' R' U)(R U' R' U') R2 U R");
	public static IMove PLL_H = MoveParser.parseLine("PLL_H;M2 U M2 U2 M2 U M2");
	public static IMove PLL_Aa = MoveParser.parseLine("PLL_Aa;x ((R' U R') D2)((R U' R') D2) R2");
	public static IMove PLL_Ab = MoveParser.parseLine("PLL_Ab;x' ((R U' R) D2)((R' U R) D2) R");
	public static IMove PLL_E = MoveParser.parseLine("PLL_E;x'((R U' R') D (R U R')) D' ((R U R') D (R U' R')) D'");
	public static IMove PLL_solved = MoveParser.parseLine("PLL_solved;");
	public static IMove PLL_Ra = MoveParser.parseLine("PLL_Ra;(L U2 L' U2)(L F')(L' U' L U)(L F) L2 U");
	public static IMove PLL_Rb = MoveParser.parseLine("PLL_Rb;(R' U2 R U2)(R' F)(R U R' U')(R' F') R2 U'");
	public static IMove PLL_Ja = MoveParser.parseLine("PLL_Ja;(R' U L')(U2 R U' R' U2)(R L U')");
	public static IMove PLL_Jb = MoveParser.parseLine("PLL_Jb;(R U R' F')((R U R' U')(R' F)(R2 U' R') U')");
	public static IMove PLL_T = MoveParser.parseLine("PLL_T;(R U R' U')(R' F)(R2 U' R') U' (R U R' F')");
	public static IMove PLL_F = MoveParser.parseLine("PLL_F;(R' U2 R' d')(R' F')(R2 U' R' U)(R' F R U' F)");
	public static IMove PLL_V = MoveParser.parseLine("PLL_V;(R' U R' d')(R' F')(R2 U' R' U)(R' F R F)");
	public static IMove PLL_Y = MoveParser.parseLine("PLL_Y;F R U' R' U' (R U R' F')((R U R' U')(R' F R F'))");
	public static IMove PLL_Na = MoveParser.parseLine("PLL_Na;((L U' R) U2 (L' U R'))((L U' R) U2 (L' U R')) U");
	public static IMove PLL_Nb = MoveParser.parseLine("PLL_Nb;((R' U L') U2 (R U' L))((R' U L') U2 (R U' L)) U'");
	public static IMove PLL_Ga = MoveParser.parseLine("PLL_Ga;R2 u R' U R' U' R u' R2 (y' R' U R)");
	public static IMove PLL_Gb = MoveParser.parseLine("PLL_Gb;(R' U' R) y R2 u R' U R U' R u' R2");
	public static IMove PLL_Gc = MoveParser.parseLine("PLL_Gc;R2 u' R U' R U R' u R2 (y R U' R')");
	public static IMove PLL_Gd = MoveParser.parseLine("PLL_Gd;(R U R') y' R2 u' R U' R' U R' u R2");
	

	public static final IMove[] PLLs = {
			PLL_Ua, PLL_Ub, PLL_Z, PLL_H, PLL_Aa, PLL_Ab, PLL_E, PLL_Ra, PLL_Rb, PLL_Ja, 
			PLL_Jb, PLL_T, PLL_F, PLL_V, PLL_Y, PLL_Na, PLL_Nb, PLL_Ga, PLL_Gb, PLL_Gc, PLL_Gd };
	
	
	public static final IMove[] CUSTOM_SEQUENCES = {
			PLL_Y, PLL_T, PLL_F, PLL_Ua, PLL_Ub, PLL_Aa, PLL_Ab,
//			OFFICIAL_SCRAMBLE 
			};
	
	
	
	
	public static final IMove[][] ALL_COLLECTIONS = { 
			ALL_SIMPLE, ALL_SIMPLE_INV, ALL_SIMPLE2,
			ALL_ORIENTATION, ALL_ORIENTATION_INV, ALL_ORIENTATION2,
			ALL_MIDDLE, ALL_MIDDLE_INV, ALL_MIDDLE2,
			ALL_DOUBLE, ALL_DOUBLE_INV, ALL_DOUBLE2,
			
			PLLs,
			
			CUSTOM_SEQUENCES,
	};
}
