package jRubbik.ui;

import java.awt.BorderLayout;

import jRubbik.moves.IMove;
import jRubbik.state.CubeDisplayer;
import jRubbik.state.CubeState;

public class CubePanelText extends CubePanel {


	private static final long serialVersionUID = -309685209173596186L;

	
	
	private DebugPanel debug;
	
	public CubePanelText(CubeState state) {
		super(state);
	}
	
	@Override
	protected void init(){
		debug = new DebugPanel();
		add(debug, BorderLayout.CENTER);
	}
	
	@Override
	public void display(IMove move) {
		debug.setText((move!=null?move.toString():"")+"\n" + CubeDisplayer.toString2(state));
	}
}
