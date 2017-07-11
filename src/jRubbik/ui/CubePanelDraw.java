package jRubbik.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

import jRubbik.constants.Color;
import jRubbik.moves.IMove;
import jRubbik.state.CubeState;
import jRubbik.state.NewCubeDisplayer;

public class CubePanelDraw extends CubePanel {
	private static final long serialVersionUID = -309685209173596186L;

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
	
	public CubePanelDraw(CubeState state) {
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
	
	private final static int PADDING = 5;
	private final static int PADDING_FACE = 3;
	private final static int LAT = 40;
	

	
	
	private void draw(Graphics g, int width, int height)
	{
		// clear
		g.setColor(java.awt.Color.LIGHT_GRAY);
		g.fillRect(0, 0, (int)width, (int)height);

		if (state == null)
			return;
		
		final Point2i pad = new Point2i((width - 12*(PADDING+LAT)-2*PADDING_FACE)/2, (height - 9*(PADDING+LAT)-2*PADDING_FACE)/2);
		final FontMetrics fm = g.getFontMetrics();
		final int htext = fm.getAscent();
		
		final Color[][] colors = NewCubeDisplayer.getColors(state);

		// draw all faces
		for (Color color : Color.ALL)
			drawFace(g, colors, color, pad);

		
		if (message != null && !message.isEmpty()) {
			g.setColor(java.awt.Color.BLACK);
			g.drawString(message, 1, htext+1);
			message = "";
		}
		
//		System.out.println(CubeDisplayer.toString2(state));
	}
	
	private void drawFace(Graphics g, Color[][] colors, Color facecolor, Point2i pad) {
		
		final Point2i offset = Point2i.add(offset(facecolor), pad);
		
		for (int x=0; x<3; x++)
			for (int y=0; y<3; y++) {
				
				final int idx = 3*y+x; //3*(2-y)+x;
				final Color drawColor = colors[facecolor.toInt()][idx];
				
				if (drawColor == null) continue;
				drawQuad(g, offset, drawColor, x, y, facecolor);
				
//				g.setColor(java.awt.Color.BLACK);
//				g.drawString(""+4, offset.getX() + x*(PADDING+LAT)+18, offset.getY() + y*(PADDING+LAT)+23);
			}
		
	}
	
	private static void drawQuad(Graphics g, Point2i offset, Color c, int x, int y, Color facecolor) {
		
		g.setColor(c.toAwtColor());
		
		// mirror view for back face
		x = facecolor == Color.ORANGE ? 2-x : x;
		
		g.fillRect(offset.getX() + x*(PADDING+LAT), offset.getY() + y*(PADDING+LAT), LAT, LAT);
	}
	
	
	private final static Point2i[] COLOR_OFFSETS = new Point2i[]{
		/* RED */ new Point2i(3*(PADDING+LAT), 3*(PADDING+LAT)),
		/* ORANGE */ new Point2i(9*(PADDING+LAT)+2*PADDING_FACE, 3*(PADDING+LAT)),
		/* YELLOW */ new Point2i(3*(PADDING+LAT), 0-PADDING_FACE),
		/* WHITE */ new Point2i(3*(PADDING+LAT), 6*(PADDING+LAT)+PADDING_FACE),
		/* GREEN */ new Point2i(6*(PADDING+LAT)+PADDING_FACE, 3*(PADDING+LAT)),
		/* BLUE */ new Point2i(0-PADDING_FACE, 3*(PADDING+LAT)),
	};
	
	
	private static Point2i offset(Color color) {
		return COLOR_OFFSETS[color.toInt()];
	}

	
	private String message = "";
	
	@Override
	public void display(IMove move) {
		
		if (move != null)
			message = move.toString();
		
		repaint();
	}
}
