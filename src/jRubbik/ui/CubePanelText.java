package jRubbik.ui;

import jRubbik.moves.IMove;
import jRubbik.state.CubeDisplayer;
import jRubbik.state.CubeState;

public class CubePanelText extends DebugPanel {

	private static final long serialVersionUID = -309685209173596186L;
	
	
	private CubeState state;
	
	public CubePanelText(CubeState state) {
		super();
		this.state = state;
	}
	
	public void display(IMove move) {
		setText((move!=null?move.toString():"")+"\n" + CubeDisplayer.toString(state));
	}
}
