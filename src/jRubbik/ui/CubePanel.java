package jRubbik.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import jRubbik.moves.BasicMoves;
import jRubbik.moves.IMove;
import jRubbik.moves.MoveParser;
import jRubbik.state.CubeState;
import jRubbik.state.Scrambler;

public abstract class CubePanel extends JPanel {

	private static final long serialVersionUID = -8791902983413545183L;



	public abstract void display(IMove move);
	protected abstract void init();
	
	
	protected CubeState state;
	
	public CubePanel(CubeState state) {
		super();
		
		this.state = state;
		setLayout(new BorderLayout());

		final JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		add(south, BorderLayout.SOUTH);
		
		{
			final JPanel Panelbasic = new JPanel();
			Panelbasic.setLayout(new GridLayout(2, BasicMoves.ALL_SIMPLE.length));
			
			for (int i = 0; i<BasicMoves.ALL_SIMPLE.length; i++)
				Panelbasic.add(buttonMove(BasicMoves.ALL_SIMPLE[i]));
			for (int i = 0; i<BasicMoves.ALL_SIMPLE_INV.length; i++)
				Panelbasic.add(buttonMove(BasicMoves.ALL_SIMPLE_INV[i]));
			south.add(Panelbasic);
		}
		{
			final JPanel Panelbasic = new JPanel();
			Panelbasic.setLayout(new GridLayout(2, BasicMoves.ALL_DOUBLE.length));
			for (int i = 0; i<BasicMoves.ALL_DOUBLE.length; i++)
				Panelbasic.add(buttonMove(BasicMoves.ALL_DOUBLE[i]));
			for (int i = 0; i<BasicMoves.ALL_DOUBLE_INV.length; i++)
				Panelbasic.add(buttonMove(BasicMoves.ALL_DOUBLE_INV[i]));
			south.add(Panelbasic);
		}
		
		{
			final JPanel Panelbasic = new JPanel();
			Panelbasic.setLayout(new GridLayout(2,BasicMoves.ALL_MIDDLE.length));
			
			for (int i = 0; i<BasicMoves.ALL_MIDDLE.length; i++)
				Panelbasic.add(buttonMove(BasicMoves.ALL_MIDDLE[i]));
			for (int i = 0; i<BasicMoves.ALL_MIDDLE_INV.length; i++)
				Panelbasic.add(buttonMove(BasicMoves.ALL_MIDDLE_INV[i]));
			south.add(Panelbasic);
		}
		{
			final JPanel Panelbasic = new JPanel();
			Panelbasic.setLayout(new GridLayout(2, BasicMoves.ALL_ORIENTATION.length));
			for (int i = 0; i<BasicMoves.ALL_ORIENTATION.length; i++)
				Panelbasic.add(buttonMove(BasicMoves.ALL_ORIENTATION[i]));
			for (int i = 0; i<BasicMoves.ALL_ORIENTATION_INV.length; i++)
				Panelbasic.add(buttonMove(BasicMoves.ALL_ORIENTATION_INV[i]));
			south.add(Panelbasic);
		}
		{
			final JPanel Panelbasic = new JPanel();
			Panelbasic.setLayout(new GridLayout(2, BasicMoves.CUSTOM_SEQUENCES.length));
			for (int i = 0; i<BasicMoves.CUSTOM_SEQUENCES.length; i++)
				Panelbasic.add(buttonMove(BasicMoves.CUSTOM_SEQUENCES[i]));
//			for (int i = 0; i<BasicMoves.ALL_ORIENTATION_INV.length; i++)
//				Panelbasic.add(buttonMove(BasicMoves.ALL_ORIENTATION_INV[i]));
			south.add(Panelbasic);
		}
		
		
		final JButton scramble = new JButton("Scramble");
		scramble.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				perform(new Scrambler().scramble());
			}
		});
		south.add(scramble);
		
		final JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setState(new CubeState());
			}
		});
		south.add(reset);
		
		init();
		
		display();
	}
	
	

	public JButton buttonMove(final IMove move) {
		final JButton clearButton = new JButton(move.toString());
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				perform(move);
			}
		});
		clearButton.addKeyListener(new MyKeyListener());
		return clearButton;
	}
	
	
	public void display() { display(null); }

	public void perform(IMove move) {
		move.apply(state);
		display(move);
	}

	public CubeState getState() {
		return state;
	}

	public void setState(CubeState state) {
		this.state = state;
		display();
	}

	public class MyKeyListener implements KeyListener
	{
		@Override
		public void keyPressed(KeyEvent arg0) {
			char c = arg0.getKeyChar();
			
			if (Character.isSpaceChar(c) || c == 0)
				return;
			
			if (Character.isUpperCase(c)) c = Character.toLowerCase(c);
			else /*if (Character.isUpperCase(c))*/ c = Character.toUpperCase(c);
			
			boolean ctrl = arg0.isAltDown();
			
			try {
				String text = ""+c+(ctrl?"'":"");
				IMove move = MoveParser.parse(text);
				if (move != null)
					perform(move);
			}
			catch (Exception e) {}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}
}
