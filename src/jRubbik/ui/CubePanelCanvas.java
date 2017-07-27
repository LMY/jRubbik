package jRubbik.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import jRubbik.constants.Color;
import jRubbik.moves.IMove;
import jRubbik.state.CubeDisplayer;
import jRubbik.state.CubeState;
import jRubbik.utils.Point2i;

public abstract class CubePanelCanvas extends CubePanel {

	private static final long serialVersionUID = -67198559360623931L;

	
	
	private class PanelCanvas extends JPanel
	{
		private static final long serialVersionUID = 3550142486159378249L;
		
		public PanelCanvas() { super(); }
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);

			final Dimension size = getSize();
			final double width = size.getWidth();
			final double height = size.getHeight();

			draw(g, (int)width, (int)height);
		}
	}
	
	
	private JPanel canvasPanel;
	
	public CubePanelCanvas(CubeState state) {
		super(state);
	}
	
	@Override
	protected void init(){
		canvasPanel = new PanelCanvas();
		
//		final MouseTranslator mousetranslator = new MouseTranslator();
//		canvasPanel.addMouseMotionListener(mousetranslator);
//		canvasPanel.addMouseWheelListener(mousetranslator);
//		canvasPanel.addMouseListener(new PopClickListener(createPopup()));
		
		canvasPanel = new PanelCanvas();
		add(canvasPanel, BorderLayout.CENTER);
	}

	public void setMouseListener(MouseListener ml)
	{
		canvasPanel.addMouseListener(ml);
	}
	public void addMouseMotionListener(MouseInputAdapter ml)
	{
		canvasPanel.addMouseMotionListener(ml);
	}
	
	 private static Font serifFont = new Font(Font.decode(null).getName(), Font.BOLD, 14);
	 
	private void draw(Graphics g, int width, int height)
	{
		// clear
		g.setColor(java.awt.Color.LIGHT_GRAY);
		g.fillRect(0, 0, (int)width, (int)height);

		if (state == null)
			return;
		
		final Point2i pad = getPadding(width, height);
		g.setFont(serifFont);
		final FontMetrics fm = g.getFontMetrics();
		final int htext = fm.getAscent();
		
		final Color[][] colors = CubeDisplayer.getColors(state);

		// draw all faces
		for (Color color : getColorsInOrder())
			drawFace(g, colors, color, pad);


		
		if (message != null && !message.isEmpty()) {
			g.setColor(java.awt.Color.BLACK);
			g.drawString(message, 1, htext+1);
			message = "";
		}
		
//		System.out.println(CubeDisplayer.toString2(state));
	}
	
	protected abstract Color[] getColorsInOrder();

	protected abstract Point2i getPadding(int width, int height);
	protected abstract void drawFace(Graphics g, Color[][] colors, Color facecolor, Point2i pad);

	
	private String message = "";
	
	@Override
	public void display(IMove move) {
		
		if (move != null)
			message = move.toString();
		
		repaint();
	}
}
