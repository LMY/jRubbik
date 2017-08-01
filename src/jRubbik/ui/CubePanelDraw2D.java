package jRubbik.ui;

import java.awt.Graphics;


import jRubbik.constants.Color;
import jRubbik.state.CubeState;
import jRubbik.utils.Point2i;

public class CubePanelDraw2D extends CubePanelCanvas {
	private static final long serialVersionUID = -309685209173596186L;

	public CubePanelDraw2D() {
		this(null);
	}
	
	public CubePanelDraw2D(CubeState state) {
		super(state);
	}

	

	
	private final static double Kpadding_face = 1/15d;
	private final static double K_face = 2/15d;

	private int PADDING = 4;
	private int PADDING_FACE = 2;
	private int LAT = 30;
	
	@Override
	protected Point2i getPadding(int width, int height) {
		
		int latx = (int) ((double)width/(12d*(K_face+1)-3*Kpadding_face));
		int laty = (int) ((double)height/(9d*(K_face+1)-2*Kpadding_face));
		
		LAT = Math.min(latx, laty);
		PADDING = (int) Math.round(LAT*K_face);
		PADDING_FACE = (int) Math.round(LAT*Kpadding_face);
		
		return new Point2i((width - 12*(PADDING+LAT)-2*PADDING_FACE)/2, (height - 9*(PADDING+LAT)-2*PADDING_FACE)/2);
	}
	
	@Override
	protected void drawFace(Graphics g, Color[][] colors, Color facecolor, Point2i pad) {
		
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
	
	private void drawQuad(Graphics g, Point2i offset, Color c, int x, int y, Color facecolor) {
		
		g.setColor(c.toAwtColor());
		
		// mirror view for back face
//		x = facecolor == Color.ORANGE ? 2-x : x;
		
		g.fillRect(offset.getX() + x*(PADDING+LAT), offset.getY() + y*(PADDING+LAT), LAT, LAT);
	}
	
	private Point2i[] get_COLOR_OFFSETS() {
		return new Point2i[] {
				/* RED */ new Point2i(3*(PADDING+LAT), 3*(PADDING+LAT)),
				/* ORANGE */ new Point2i(9*(PADDING+LAT)+2*PADDING_FACE, 3*(PADDING+LAT)),
				/* YELLOW */ new Point2i(3*(PADDING+LAT), 0-PADDING_FACE),
				/* WHITE */ new Point2i(3*(PADDING+LAT), 6*(PADDING+LAT)+PADDING_FACE),
				/* GREEN */ new Point2i(6*(PADDING+LAT)+PADDING_FACE, 3*(PADDING+LAT)),
				/* BLUE */ new Point2i(0-PADDING_FACE, 3*(PADDING+LAT)),
			};
	}
	
//	private final static Point2i[] COLOR_OFFSETS = new Point2i[]{
//		/* RED */ new Point2i(3*(PADDING+LAT), 3*(PADDING+LAT)),
//		/* ORANGE */ new Point2i(9*(PADDING+LAT)+2*PADDING_FACE, 3*(PADDING+LAT)),
//		/* YELLOW */ new Point2i(3*(PADDING+LAT), 0-PADDING_FACE),
//		/* WHITE */ new Point2i(3*(PADDING+LAT), 6*(PADDING+LAT)+PADDING_FACE),
//		/* GREEN */ new Point2i(6*(PADDING+LAT)+PADDING_FACE, 3*(PADDING+LAT)),
//		/* BLUE */ new Point2i(0-PADDING_FACE, 3*(PADDING+LAT)),
//	};
	
	
	private Point2i offset(Color color) {
		return get_COLOR_OFFSETS()[color.toInt()];
	}

	@Override
	protected Color[] getColorsInOrder() {
		return Color.ALL;
	}
}
