package jRubbik.moves;

import jRubbik.constants.Color;

public class BasicMoves {
	
	public final static int MODIFIER_PLAIN = 0;
	public final static int MODIFIER_INVERSE = 3;
	public final static int MODIFIER_DOUBLE = 2;
	
	
	// STANDARD MOVES
	public final static IMove MOVE_F = new MoveSimple(Color.RED, MODIFIER_PLAIN);
	public final static IMove MOVE_B = new MoveSimple(Color.ORANGE, MODIFIER_PLAIN);
	public final static IMove MOVE_U = new MoveSimple(Color.YELLOW, MODIFIER_PLAIN);
	public final static IMove MOVE_D = new MoveSimple(Color.WHITE, MODIFIER_PLAIN);
	public final static IMove MOVE_R = new MoveSimple(Color.GREEN, MODIFIER_PLAIN);
	public final static IMove MOVE_L = new MoveSimple(Color.BLUE, MODIFIER_PLAIN);
	
	public final static IMove MOVE_Fi = new MoveSimple(Color.RED, MODIFIER_INVERSE);
	public final static IMove MOVE_Bi = new MoveSimple(Color.ORANGE, MODIFIER_INVERSE);
	public final static IMove MOVE_Ui = new MoveSimple(Color.YELLOW, MODIFIER_INVERSE);
	public final static IMove MOVE_Di = new MoveSimple(Color.WHITE, MODIFIER_INVERSE);
	public final static IMove MOVE_Ri = new MoveSimple(Color.GREEN, MODIFIER_INVERSE);
	public final static IMove MOVE_Li = new MoveSimple(Color.BLUE, MODIFIER_INVERSE);
	
	public final static IMove MOVE_F2 = new MoveSimple(Color.RED, MODIFIER_DOUBLE);
	public final static IMove MOVE_B2 = new MoveSimple(Color.ORANGE, MODIFIER_DOUBLE);
	public final static IMove MOVE_U2 = new MoveSimple(Color.YELLOW, MODIFIER_DOUBLE);
	public final static IMove MOVE_D2 = new MoveSimple(Color.WHITE, MODIFIER_DOUBLE);
	public final static IMove MOVE_R2 = new MoveSimple(Color.GREEN, MODIFIER_DOUBLE);
	public final static IMove MOVE_L2 = new MoveSimple(Color.BLUE, MODIFIER_DOUBLE);
	
	
	// ORIENTATION
	public final static IMove MOVE_x = new MoveOrientation(Color.GREEN, MODIFIER_PLAIN);
	public final static IMove MOVE_y = new MoveOrientation(Color.WHITE, MODIFIER_PLAIN);
	public final static IMove MOVE_z = new MoveOrientation(Color.RED, MODIFIER_PLAIN);
	
	public final static IMove MOVE_xi = new MoveOrientation(Color.GREEN, MODIFIER_INVERSE);
	public final static IMove MOVE_yi = new MoveOrientation(Color.WHITE, MODIFIER_INVERSE);
	public final static IMove MOVE_zi = new MoveOrientation(Color.RED, MODIFIER_INVERSE);
	
	public final static IMove MOVE_x2 = new MoveOrientation(Color.GREEN, MODIFIER_DOUBLE);
	public final static IMove MOVE_y2 = new MoveOrientation(Color.WHITE, MODIFIER_DOUBLE);
	public final static IMove MOVE_z2 = new MoveOrientation(Color.RED, MODIFIER_DOUBLE);
	

	// MIDDLE LAYER MOVES
	public final static IMove MOVE_M = new MoveMiddle(Color.GREEN, MODIFIER_PLAIN);
	public final static IMove MOVE_E = new MoveMiddle(Color.YELLOW, MODIFIER_PLAIN);
	public final static IMove MOVE_S = new MoveMiddle(Color.RED, MODIFIER_PLAIN);

	public final static IMove MOVE_Mi = new MoveMiddle(Color.GREEN, MODIFIER_INVERSE);
	public final static IMove MOVE_Ei = new MoveMiddle(Color.YELLOW, MODIFIER_INVERSE);
	public final static IMove MOVE_Si = new MoveMiddle(Color.RED, MODIFIER_INVERSE);
	
	public final static IMove MOVE_M2 = new MoveMiddle(Color.GREEN, MODIFIER_DOUBLE);
	public final static IMove MOVE_E2 = new MoveMiddle(Color.YELLOW, MODIFIER_DOUBLE);
	public final static IMove MOVE_S2 = new MoveMiddle(Color.RED, MODIFIER_DOUBLE);
	
	
	// FAT TURNS
	public final static IMove MOVE_f = new MoveDouble(Color.RED, MODIFIER_PLAIN);
	public final static IMove MOVE_b = new MoveDouble(Color.ORANGE, MODIFIER_PLAIN);
	public final static IMove MOVE_u = new MoveDouble(Color.YELLOW, MODIFIER_PLAIN);
	public final static IMove MOVE_d = new MoveDouble(Color.WHITE, MODIFIER_PLAIN);
	public final static IMove MOVE_r = new MoveDouble(Color.GREEN, MODIFIER_PLAIN);
	public final static IMove MOVE_l = new MoveDouble(Color.BLUE, MODIFIER_PLAIN);
	
	public final static IMove MOVE_fi = new MoveDouble(Color.RED, MODIFIER_INVERSE);
	public final static IMove MOVE_bi = new MoveDouble(Color.ORANGE, MODIFIER_INVERSE);
	public final static IMove MOVE_ui = new MoveDouble(Color.YELLOW, MODIFIER_INVERSE);
	public final static IMove MOVE_di = new MoveDouble(Color.WHITE, MODIFIER_INVERSE);
	public final static IMove MOVE_ri = new MoveDouble(Color.GREEN, MODIFIER_INVERSE);
	public final static IMove MOVE_li = new MoveDouble(Color.BLUE, MODIFIER_INVERSE);
	
	public final static IMove MOVE_f2 = new MoveDouble(Color.RED, MODIFIER_DOUBLE);
	public final static IMove MOVE_b2 = new MoveDouble(Color.ORANGE, MODIFIER_DOUBLE);
	public final static IMove MOVE_u2 = new MoveDouble(Color.YELLOW, MODIFIER_DOUBLE);
	public final static IMove MOVE_d2 = new MoveDouble(Color.WHITE, MODIFIER_DOUBLE);
	public final static IMove MOVE_r2 = new MoveDouble(Color.GREEN, MODIFIER_DOUBLE);
	public final static IMove MOVE_l2 = new MoveDouble(Color.BLUE, MODIFIER_DOUBLE);
	
	
	
	// DEFINE COLLECTIONS (visible only inside this package)
	// these are defined for each color: array[color.toInt()]
	final static IMove[] ALL_SIMPLE = { MOVE_F, MOVE_B, MOVE_U, MOVE_D, MOVE_R, MOVE_L };
	final static IMove[] ALL_SIMPLE_INV = { MOVE_Fi, MOVE_Bi, MOVE_Ui, MOVE_Di, MOVE_Ri, MOVE_Li };
	final static IMove[] ALL_SIMPLE2 = { MOVE_F2, MOVE_B2, MOVE_U2, MOVE_D2, MOVE_R2, MOVE_L2 };
	final static String[] NAMES_SIMPLE = { "F", "B", "U", "D", "R", "L" };
	
	final static IMove[] ALL_ORIENTATION = {  MOVE_z, MOVE_z, MOVE_y, MOVE_y, MOVE_x, MOVE_x };
	final static IMove[] ALL_ORIENTATION_INV = {  MOVE_zi, MOVE_zi, MOVE_yi, MOVE_yi, MOVE_xi, MOVE_xi };
	final static IMove[] ALL_ORIENTATION2 = {  MOVE_z2, MOVE_z2, MOVE_y2, MOVE_y2, MOVE_x2, MOVE_x2 };
	final static String[] NAMES_ORIENTATION = { "z", "z", "y", "y", "x", "x" };
	
	final static IMove[] ALL_MIDDLE = { MOVE_S, MOVE_S, MOVE_E, MOVE_E, MOVE_M, MOVE_M };
	final static IMove[] ALL_MIDDLE_INV = { MOVE_Si, MOVE_Si, MOVE_Ei, MOVE_Ei, MOVE_Mi, MOVE_Mi };
	final static IMove[] ALL_MIDDLE2 = { MOVE_S2, MOVE_S2, MOVE_E2, MOVE_E2, MOVE_M2, MOVE_M2 };
	final static String[] NAMES_MIDDLE = { "S", "S", "E", "E", "M", "M" };
	
	final static IMove[] ALL_DOUBLE = { MOVE_f, MOVE_b, MOVE_u, MOVE_d, MOVE_r, MOVE_l };
	final static IMove[] ALL_DOUBLE_INV = { MOVE_fi, MOVE_bi, MOVE_ui, MOVE_di, MOVE_ri, MOVE_li };
	final static IMove[] ALL_DOUBLE2 = { MOVE_f2, MOVE_b2, MOVE_u2, MOVE_d2, MOVE_r2, MOVE_l2 };
	final static String[] NAMES_DOUBLE = { "f", "b", "u", "d", "r", "l" };
	
	
	// DEFINE PUBLIC COLLECTIONS
	public final static IMove[] PUBLIC_ALL_SIMPLE = ALL_SIMPLE;
	public final static IMove[] PUBLIC_ALL_SIMPLE_INV = ALL_SIMPLE_INV;
	public final static IMove[] PUBLIC_ALL_SIMPLE2 = ALL_SIMPLE2;
	
	public final static IMove[] PUBLIC_ALL_ORIENTATION = {  MOVE_x, MOVE_y, MOVE_z };
	public final static IMove[] PUBLIC_ALL_ORIENTATION_INV = {  MOVE_xi, MOVE_yi, MOVE_zi };
	public final static IMove[] PUBLIC_ALL_ORIENTATION2 = {  MOVE_x2, MOVE_y2, MOVE_z2 };
	
	public final static IMove[] PUBLIC_ALL_MIDDLE = {  MOVE_M, MOVE_E, MOVE_S };
	public final static IMove[] PUBLIC_ALL_MIDDLE_INV = {  MOVE_Mi, MOVE_Ei, MOVE_Si };
	public final static IMove[] PUBLIC_ALL_MIDDLE2 = {  MOVE_M2, MOVE_E2, MOVE_S2 };
	
	public final static IMove[] PUBLIC_ALL_DOUBLE = ALL_DOUBLE;
	public final static IMove[] PUBLIC_ALL_DOUBLE_INV = ALL_DOUBLE_INV;
	public final static IMove[] PUBLIC_ALL_DOUBLE2 = ALL_DOUBLE2;
	
	

	public final static IMove MOVE_SEQ_SEXY = MoveParser.parseLine("Sexy;(R U R' U')");
	public final static IMove MOVE_SEQ_SEXY_INV = MOVE_SEQ_SEXY.reverse();
	public final static IMove MOVE_SEQ_SLEDGE = MoveParser.parseLine("SH;(R' F R F')");
	public final static IMove MOVE_SEQ_SLEDGE_INV = MOVE_SEQ_SLEDGE.reverse();
	
	// CUSTOM SEQUENCES
	public static IMove OFFICIAL_SCRAMBLE = new MoveDescription(MoveParser.parseSequence("R2 B2 R2 L' B' R2 U2 B2 F R U2 B2 F' D' R' F R2 L2 B' U'"), "OFFICIAL SCRAMBLE", true);
	
	
	public final static IMove OLL_OCLL1 = MoveParser.parseLine("OLL_OCLL1;(R U R' U) R U2 R'");
	public final static IMove OLL_OCLL2 = MoveParser.parseLine("OLL_OCLL2;R U2 R' U' R U' R'");
	public final static IMove OLL_OCLL3 = MoveParser.parseLine("OLL_OCLL3;f (R U R' U') f' F (R U R' U') F'");
	public final static IMove OLL_OCLL4 = MoveParser.parseLine("OLL_OCLL4;F (R U R' U') (R U R' U') (R U R' U') F'");
	public final static IMove OLL_OCLL5 = MoveParser.parseLine("OLL_OCLL5;(r U R' U') (r' F R F')");
	public final static IMove OLL_OCLL6 = MoveParser.parseLine("OLL_OCLL6;F' (r U R' U') (r' F R )");
	public final static IMove OLL_OCLL7 = MoveParser.parseLine("OLL_OCLL7;R2 (D (R' U2) R) (D' (R' U2) R')");
	public final static IMove OLL_solved = MoveParser.parseLine("OLL_solved;");
	public final static IMove OLL_E1 = MoveParser.parseLine("OLL_E1;(R U R' U') M' (U R U' r')");
	public final static IMove OLL_E2 = MoveParser.parseLine("OLL_E2; M' U M U2 M' U M");
	public final static IMove OLL_P1 = MoveParser.parseLine("OLL_P1;f (R U R' U') f'");
	public final static IMove OLL_P2 = MoveParser.parseLine("OLL_P2;f' (L' U' L U) f");
	public final static IMove OLL_P3 = MoveParser.parseLine("OLL_P3;R U B' U' R' U R B R'");
	public final static IMove OLL_P4 = MoveParser.parseLine("OLL_P4;R' U' F U R U' R' F' R");
	public final static IMove OLL_W1 = MoveParser.parseLine("OLL_W1;(R U R' U) (R U' R' U') (R' F R F')");
	public final static IMove OLL_W2 = MoveParser.parseLine("OLL_W2;(L' U' L U') (L' U L U) (L F' L' F)");
	public final static IMove OLL_S1 = MoveParser.parseLine("OLL_S1;r U2 R' U' R U' r'");
	public final static IMove OLL_S2 = MoveParser.parseLine("OLL_S2;r' U2 (R U R' U) r");
	public final static IMove OLL_L1 = MoveParser.parseLine("OLL_L1;F (R U R' U') (R U R' U') F'");
	public final static IMove OLL_L2 = MoveParser.parseLine("OLL_L2;F' (L' U' L U) (L' U' L U) F");
	public final static IMove OLL_L3 = MoveParser.parseLine("OLL_L3;l' U' L U' L' U L U' L' U2 l");
	public final static IMove OLL_L4 = MoveParser.parseLine("OLL_L4;(r U R' U) R U' R' U R U2 r'");
	public final static IMove OLL_L5 = MoveParser.parseLine("OLL_L5;(R' F R' F') R2 U2 y (R' F R F')");
	public final static IMove OLL_L6 = MoveParser.parseLine("OLL_L6;R' F R2 B' R2 F' R2 B R'");
	public final static IMove OLL_F1 = MoveParser.parseLine("OLL_F1;(R U R' U') R' F R2 U R' U' F'");
	public final static IMove OLL_F2 = MoveParser.parseLine("OLL_F2;(R U R' U) (R' F R F') R U2 R'");
	public final static IMove OLL_F3 = MoveParser.parseLine("OLL_F3;(R U2 R') (R' F R F') (R U2 R')");
	public final static IMove OLL_F4 = MoveParser.parseLine("OLL_F4;F R U' R' U' R U R' F'");
	public final static IMove OLL_A1 = MoveParser.parseLine("OLL_A1;R2 U R' B' R U' R2 U R B R'");
	public final static IMove OLL_A2 = MoveParser.parseLine("OLL_A2;(R U R' U') R U' R' F' U' F R U R'");
	public final static IMove OLL_A3 = MoveParser.parseLine("OLL_A3;((R U R' U) R U2 R') (F (R U R' U') F')");
	public final static IMove OLL_A4 = MoveParser.parseLine("OLL_A4;(R' F R F') (R' F R F') (R U R' U') (R U R')");
	public final static IMove OLL_LB1 = MoveParser.parseLine("OLL_LB1;(r U R' U) R U2 r'");
	public final static IMove OLL_LB2 = MoveParser.parseLine("OLL_LB2;r' U' R U' R' U2 r");
	public final static IMove OLL_LB3 = MoveParser.parseLine("OLL_LB3;(F' (L' U' L U) F) y (F (R U R' U') F')");
	public final static IMove OLL_LB4 = MoveParser.parseLine("OLL_LB4;(F (R U R' U') F') U (F (R U R' U') F' )");
	public final static IMove OLL_LB5 = MoveParser.parseLine("OLL_LB5;R B' R' U' R U B U' R'");
	public final static IMove OLL_LB6 = MoveParser.parseLine("OLL_LB6;R' (F (R U R' U') F') U R");
	public final static IMove OLL_T1 = MoveParser.parseLine("OLL_T1;F (R U R' U') F'");
	public final static IMove OLL_Xy = MoveParser.parseLine("OLL_T2;(R U R' U') (R' F R F')");
	public final static IMove OLL_C1 = MoveParser.parseLine("OLL_C1;R' U' (R' F R F') U R");
	public final static IMove OLL_C2 = MoveParser.parseLine("OLL_C2;(R U R2 U') (R' F) (R U) (R U') F'");
	public final static IMove OLL_I1 = MoveParser.parseLine("OLL_I1;R' U2 R2 U R' U R U2 x' U' R' U");
	public final static IMove OLL_I2 = MoveParser.parseLine("OLL_I2;(R U R' U) R d' R U' R' F'");
	public final static IMove OLL_I3 = MoveParser.parseLine("OLL_I3;F (R U R' U') R F' (r U R' U') r'");
	public final static IMove OLL_I4 = MoveParser.parseLine("OLL_I4;f (R U R' U') (R U R' U') f'");
	public final static IMove OLL_K1 = MoveParser.parseLine("OLL_K1;(r U r') (R U R' U') (r U' r')");
	public final static IMove OLL_K2 = MoveParser.parseLine("OLL_K2;(l' U' l) (L' U' L U) (l' U l)");
	public final static IMove OLL_K3 = MoveParser.parseLine("OLL_K3;F U R U' R2 F' R (U R U' R')");
	public final static IMove OLL_K4 = MoveParser.parseLine("OLL_K4;R' F R U R' F' R y' R U' R'");
	public final static IMove OLL_O1 = MoveParser.parseLine("OLL_O1;R U2 R' (R' F R F') U2 (R' F R F')");
	public final static IMove OLL_O2 = MoveParser.parseLine("OLL_O2;(F (R U R' U') F' ) (f (R U R' U') f')");
	public final static IMove OLL_O3 = MoveParser.parseLine("OLL_O3;(f (R U R' U') f') U' (F (R U R' U') F' )");
	public final static IMove OLL_O4 = MoveParser.parseLine("OLL_O4;(f (R U R' U') f') U (F (R U R' U') F' )");
	public final static IMove OLL_O5 = MoveParser.parseLine("OLL_O5;(F (R U R' U) F') y' U2 (R' F R F')");
	public final static IMove OLL_O6 = MoveParser.parseLine("OLL_O6;M U (R U R' U') M' (R' F R F')");
	public final static IMove OLL_O7 = MoveParser.parseLine("OLL_O7;(R U R' U) (R' F R F') U2 (R' F R F')");
	public final static IMove OLL_O8 = MoveParser.parseLine("OLL_O8;M U (R U R' U') M2 (U R U' r')");
	
	public final static IMove PLL_Ua = MoveParser.parseLine("PLL_Ua;(R U')(R U)(R U)(R U') R' U' R2");
	public final static IMove PLL_Ub = MoveParser.parseLine("PLL_Ub;R2 U (R U R' U')(R' U')(R' U R')");
	public final static IMove PLL_Z = MoveParser.parseLine("PLL_Z;U2 (R U R' U)(R' U' R' U)(R U' R' U') R2 U R");
	public final static IMove PLL_H = MoveParser.parseLine("PLL_H;M2 U M2 U2 M2 U M2");
	public final static IMove PLL_Aa = MoveParser.parseLine("PLL_Aa;x ((R' U R') D2)((R U' R') D2) R2 x'");
	public final static IMove PLL_Ab = MoveParser.parseLine("PLL_Ab;x' ((R U' R) D2)((R' U R) D2) R2 x");
	public final static IMove PLL_E = MoveParser.parseLine("PLL_E;x'((R U' R') D (R U R')) D' ((R U R') D (R U' R')) D' x");
	public final static IMove PLL_solved = MoveParser.parseLine("PLL_solved;");
	public final static IMove PLL_Ra = MoveParser.parseLine("PLL_Ra;(L U2 L' U2)(L F')(L' U' L U)(L F) L2 U");
	public final static IMove PLL_Rb = MoveParser.parseLine("PLL_Rb;(R' U2 R U2)(R' F)(R U R' U')(R' F') R2 U'");
	public final static IMove PLL_Ja = MoveParser.parseLine("PLL_Ja;(R' U L')(U2 R U' R' U2)(R L U')");
	public final static IMove PLL_Jb = MoveParser.parseLine("PLL_Jb;(R U R' F')((R U R' U')(R' F)(R2 U' R') U')");
	public final static IMove PLL_T = MoveParser.parseLine("PLL_T;(R U R' U')(R' F)(R2 U' R') U' (R U R' F')");
	public final static IMove PLL_F = MoveParser.parseLine("PLL_F;(R' U2 R' d')(R' F')(R2 U' R' U)(R' F R U' F) y'");
	public final static IMove PLL_V = MoveParser.parseLine("PLL_V;(R' U R' d')(R' F')(R2 U' R' U)(R' F R F) y'");
	public final static IMove PLL_Y = MoveParser.parseLine("PLL_Y;F R U' R' U' (R U R' F')((R U R' U')(R' F R F'))");
	public final static IMove PLL_Na = MoveParser.parseLine("PLL_Na;((L U' R) U2 (L' U R'))((L U' R) U2 (L' U R')) U");
	public final static IMove PLL_Nb = MoveParser.parseLine("PLL_Nb;((R' U L') U2 (R U' L))((R' U L') U2 (R U' L)) U'");
	public final static IMove PLL_Ga = MoveParser.parseLine("PLL_Ga;R2 u R' U R' U' R u' R2 (y' R' U R) y");
	public final static IMove PLL_Gb = MoveParser.parseLine("PLL_Gb;(R' U' R) y R2 u R' U R U' R u' R2 y'");
	public final static IMove PLL_Gc = MoveParser.parseLine("PLL_Gc;R2 u' R U' R U R' u R2 (y R U' R') y'");
	public final static IMove PLL_Gd = MoveParser.parseLine("PLL_Gd;(R U R') y' R2 u' R U' R' U R' u R2 y");
	

	public final static IMove[] PLLs = {
			PLL_solved, PLL_Ua, PLL_Ub, PLL_Z, PLL_H, PLL_Aa, PLL_Ab, PLL_E, PLL_Ra, PLL_Rb, PLL_Ja, 
			PLL_Jb, PLL_T, PLL_F, PLL_V, PLL_Y, PLL_Na, PLL_Nb, PLL_Ga, PLL_Gb, PLL_Gc, PLL_Gd };
	
	public final static IMove[] OLLs = { OLL_OCLL1, OLL_OCLL2, OLL_OCLL3, OLL_OCLL4, OLL_OCLL5, OLL_OCLL6, OLL_OCLL7, OLL_solved,
			OLL_E1, OLL_E2, OLL_P1, OLL_P2, OLL_P3, OLL_P4, OLL_W1, OLL_W2, OLL_S1, OLL_S2, OLL_L1, OLL_L2, OLL_L3, OLL_L4, OLL_L5, OLL_L6,
			OLL_F1, OLL_F2, OLL_F3, OLL_F4, OLL_A1, OLL_A2, OLL_A3, OLL_A4, OLL_LB1, OLL_LB2, OLL_LB3, OLL_LB4, OLL_LB5, OLL_LB6, OLL_T1, OLL_Xy, OLL_C1,
			OLL_C2, OLL_I1, OLL_I2, OLL_I3, OLL_I4, OLL_K1, OLL_K2, OLL_K3, OLL_K4, OLL_O1, OLL_O2, OLL_O3, OLL_O4, OLL_O5, OLL_O6, OLL_O7, OLL_O8 };
	
	public final static IMove[] COMMON_SEQUENCES = {
			MOVE_SEQ_SEXY, MOVE_SEQ_SEXY_INV,
			MOVE_SEQ_SLEDGE, MOVE_SEQ_SLEDGE_INV,
	};
			
//			OFFICIAL_SCRAMBLE 
	
	
	public final static IMove[][] ALL_COLLECTIONS = { 
			ALL_SIMPLE, ALL_SIMPLE_INV, ALL_SIMPLE2,
			ALL_ORIENTATION, ALL_ORIENTATION_INV, ALL_ORIENTATION2,
			ALL_MIDDLE, ALL_MIDDLE_INV, ALL_MIDDLE2,
			ALL_DOUBLE, ALL_DOUBLE_INV, ALL_DOUBLE2,
			
			OLLs,
			PLLs,
			
			COMMON_SEQUENCES
	};
	
	
	
	
	// HELPER FUNCTIONS
	public static IMove color2move(Color color, int mod, IMove[] msimple, IMove[] mrev, IMove[] mdouble) {
			return mod == MODIFIER_DOUBLE ? mdouble[color.toInt()] :
				   mod == MODIFIER_INVERSE ? mrev[color.toInt()] :
					   msimple[color.toInt()];
	}
	
	public static IMove color2simpleMove(Color color, int mod) {
		return color2move(color, mod, ALL_SIMPLE, ALL_SIMPLE_INV, ALL_SIMPLE2);
	}
	
	public static IMove color2orientationMove(Color color, int mod) {
		return color2move(color, mod, ALL_ORIENTATION, ALL_ORIENTATION_INV, ALL_ORIENTATION2);
	}
	
	public static IMove color2middleMove(Color color, int mod) {
		return color2move(color, mod, ALL_MIDDLE, ALL_MIDDLE_INV, ALL_MIDDLE2);
	}
	
	public static IMove color2doubleMove(Color color, int mod) {
		return color2move(color, mod, ALL_DOUBLE, ALL_DOUBLE_INV, ALL_DOUBLE2);
	}
}
