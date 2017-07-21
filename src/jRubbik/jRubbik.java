package jRubbik;

import javax.swing.UIManager;


import jRubbik.moves.IMove;
import jRubbik.solver.SolverCFOP;
import jRubbik.state.CubeState;
import jRubbik.ui.jRubikWindow;
import jRubbik.utils.Utils;

public class jRubbik {
	
	public static void main(String args[])
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception exception) {
			Utils.MessageBox(null, "Invalid look and feel.", "ERROR");
		}
				
		final jRubikWindow main = new jRubikWindow();
		
		main.setVisible(true);
	}
	
	public static void testSolve(IMove auf, IMove pll, IMove auf2, IMove oll, IMove auf3) {
		
		System.out.print("Check: "+auf.toString()+" "+pll.toString()+" "+auf2.toString()+" "+oll.toString()+" "+auf3.toString()+"\t");
		
		CubeState state = auf.reverse().get();
		state = pll.reverse().get(state);
		state = auf2.reverse().get(state);
		state = oll.reverse().get(state);
		state = auf3.reverse().get(state);
		new SolverCFOP().solve(state);
	}
	
}
