package jRubbik;

import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.UIManager;

import jRubbik.moves.IMove;
import jRubbik.moves.MoveParser;
import jRubbik.solver.SolverCFOP;
import jRubbik.state.CubeDisplayer;
import jRubbik.ui.jRubikWindow;

public class jRubbik {
	
	public static boolean USE_SCRAMBLE_DEBUG = true;
	public static String OFFICIAL_SCRAMBLE = "R2 B2 R2 L' B' R2 U2 B2 F R U2 B2 F' D' R' F R2 L2 B' U'";
	
	public static String SCRAMBLE_DEBUG = "U2 (R U')(R U)(R U)(R U') R' U' R2 U'"; 
			//OFFICIAL_SCRAMBLE;
	
	
	
	public static void main(String args[])
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception exception) {
			Utils.MessageBox(null, "Invalid look and feel.", "ERROR");
		}
		
		Locale.setDefault(Locale.US);
		NumberFormat.getInstance(Locale.US).setGroupingUsed(false);
		
		final jRubikWindow main = new jRubikWindow();
		
		main.setVisible(true);
		
//		
////		display("y R U R' U'");
////		display("M");
//		display("x R");
//		display("x U");
//		
//		display("y R");
////		display("y' R");
////		display("y2 R");
//		
//		solve(USE_SCRAMBLE_DEBUG ? MoveParser.parseSequence(SCRAMBLE_DEBUG) :  new Scrambler().scramble());

		
//		CubeState state = new CubeState();
//			
//		CubeState spattern = state.clone();
//		MoveParser.parseSequence("U'").apply(state);
//		CubeDisplayer.display(state);
		
//		
//		Pattern pattern = new Pattern(spattern);
//		
//		IMove seq = pattern.getAdjMatch(state, MoveParser.parseSequence("U"));
//		
//		if (seq == null)
//			System.out.println("NO MATCH");
//		else
//			System.out.println("auf: "+seq.toString());	
	}
	
	public static void solve(IMove scramble)
	{
		System.out.println("SCRAMBLE: "+scramble.toString());
		System.out.println();
		
		SolverCFOP solver = new SolverCFOP();
		IMove solution = solver.solve(scramble.get());
		
		System.out.println("Solution:\n"+solution.toString());
	}
	
	public static void display(String sequence)
	{
		System.out.println(sequence);
		CubeDisplayer.display(MoveParser.parseSequence(sequence).get());
		System.out.println();
	}
	
//	public static void test_alg(String alg, int times)
//	{
//		CubeState state = new CubeState();
//		IMove scramble = MoveParser.parseSequence(alg);
//		
//		System.out.println("Testing: "+scramble.toString());
//		System.out.println();
//		
//		for (int i=0; i<times; i++) {
//			scramble.apply(state);
//			CubeDisplayer.display(state);
//			System.out.println();
//		}
//	}
	
//	public static void testSexy6()
//	{
//		CubeState state = new CubeState();
//		CubeDisplayer.display(state);
//		System.out.println();
//		
//		IMove move = MoveParser.parseSequence("R U Ri Ui");
//		
//		for (int i=0; i<6; i++) {
//			move.apply(state);
//			CubeDisplayer.display(state);
//			System.out.println();
//			System.out.println();
//		}
//	}
}
