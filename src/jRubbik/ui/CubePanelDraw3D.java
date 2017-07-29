package jRubbik.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.MouseInputListener;

import jRubbik.constants.Color;
import jRubbik.state.CubeState;
import jRubbik.utils.Point2d;
import jRubbik.utils.Point2i;
import jRubbik.utils.Point3d;

public class CubePanelDraw3D extends CubePanelCanvas {

	class MouseClickAndMotionListener implements MouseListener, MouseInputListener {
		@Override
		public void mousePressed(MouseEvent e) {
			updatestuff(e);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			updatestuff(e);
		}

		@Override
		public void mouseMoved(MouseEvent e) {}
		
		private void updatestuff(MouseEvent e) {
			setCenter(e.getX(), e.getY(), zclip);
			repaint();
//			invalidate();
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {}
		
		@Override
		public void mouseExited(MouseEvent e) {}
		
		@Override
		public void mouseEntered(MouseEvent e) {}
		
		@Override
		public void mouseClicked(MouseEvent e) {
		}
	}
	
	
	public CubePanelDraw3D(CubeState state) {
		super(state);
		final MouseClickAndMotionListener ml = new MouseClickAndMotionListener();

		addMouseListener(ml);
//		addMouseMotionListener(ml);
	}

	private static final long serialVersionUID = -913020583144845777L;

	@Override
	protected Point2i getPadding(int width, int height) {
		
//		setCenter(width/2, height/2, zclip);
		
		return new Point2i();
	}

	@Override
	protected void drawFace(Graphics g, Color[][] colors, Color facecolor, Point2i pad) {

		for (int x=0; x<3; x++)
			for (int y=0; y<3; y++) {
				
				final int idx = 3*y+x; //3*(2-y)+x;
				final Color drawColor = colors[facecolor.toInt()][idx];
				
				if (drawColor == null) continue;
				drawQuad(g, drawColor, x, y, facecolor);
			}
	}
	
	private double xc = 700;
	private double yc = 100;
	
	private double zclip = 4;
	
	final static double QuadLatus = 1.0;
	final static double QuadPadding = 0.0234375; // 0.03125
	
	final static double K = QuadLatus * 1.5; // center cube in (0,0,0)
	
	final static double Xshift = -4;
	final static double Yshift = +3;
	final static double Zshift = K+0.01;
	
	final static double zscale = 0.5;
	
	
	private static Point3d[] face_coords = {
			/* red */ new Point3d(-K +Xshift, -K +Yshift, (-K +Zshift)*zscale), 
			/* ora */ new Point3d(+K +Xshift, -K +Yshift, (+K +Zshift)*zscale), 
			/* yel */ new Point3d(-K +Xshift, -K +Yshift, (+K +Zshift)*zscale),
			/* whi */ new Point3d(-K +Xshift, -K +Yshift, (+K +Zshift)*zscale), 
			/* gre */ new Point3d(+K +Xshift, -K +Yshift, (-K +Zshift)*zscale), 
			/* blu */ new Point3d(-K +Xshift, -K +Yshift, (+K +Zshift)*zscale), 
		};
	
	private static Point3d[][] face_deltas = {
			/* red */ { new Point3d(QuadLatus, 0, 0), new Point3d(0, QuadLatus, 0) },
			/* ora */ { new Point3d(-QuadLatus, 0, 0), new Point3d(0, QuadLatus, 0) },
			/* yel */ { new Point3d(QuadLatus, 0, 0), new Point3d(0, 0, -QuadLatus*zscale) },
			/* whi */ { new Point3d(QuadLatus, 0, 0),new Point3d(0, 0, -QuadLatus*zscale) },
			/* gre */ { new Point3d(0, 0, QuadLatus*zscale),new Point3d(0, QuadLatus, 0) },
			/* blu */ { new Point3d(0, QuadLatus, 0),  new Point3d(0, 0, -QuadLatus*zscale) }
		};
	
	
	private void drawQuad(Graphics g, Color drawColor, int x, int y, Color facecolor) {


		
		final Point3d face_offset = face_coords[facecolor.toInt()];
		
		final Point3d deltax = face_deltas[facecolor.toInt()][0];
		final Point3d deltay = face_deltas[facecolor.toInt()][1];
		
		final Point3d offset = Point3d.add(face_offset, Point3d.add(Point3d.multiply(deltax, x), Point3d.multiply(deltay, y)));
		
		final Point3d sdeltax = Point3d.multiply(deltax, QuadPadding * 1.0/deltax.length());
		final Point3d sdeltay = Point3d.multiply(deltay, QuadPadding * 1.0/deltay.length());
		
		final Point3d[] pts = new Point3d[4];

		pts[0] = Point3d.add(offset, Point3d.add(Point3d.multiply(deltax, 0), Point3d.multiply(deltay, 0)));
		pts[1] = Point3d.add(offset, Point3d.add(Point3d.multiply(deltax, 1), Point3d.multiply(deltay, 0)));
		pts[2] = Point3d.add(offset, Point3d.add(Point3d.multiply(deltax, 1), Point3d.multiply(deltay, 1)));
		pts[3] = Point3d.add(offset, Point3d.add(Point3d.multiply(deltax, 0), Point3d.multiply(deltay, 1)));
		
		g.setColor(java.awt.Color.BLACK);
		fillQuad_3D(g, pts, false);
		
		pts[0] = Point3d.add(pts[0], Point3d.add(Point3d.multiply(sdeltax, +1), Point3d.multiply(sdeltay, +1)));
		pts[1] = Point3d.add(pts[1], Point3d.add(Point3d.multiply(sdeltax, -1), Point3d.multiply(sdeltay, +1)));
		pts[2] = Point3d.add(pts[2], Point3d.add(Point3d.multiply(sdeltax, -1), Point3d.multiply(sdeltay, -1)));
		pts[3] = Point3d.add(pts[3], Point3d.add(Point3d.multiply(sdeltax, +1), Point3d.multiply(sdeltay, -1)));
		
		g.setColor(drawColor.toAwtColor());
		fillQuad_3D(g, pts, false);
	}
	

	
	public void setCenter(double xc, double yc, double zc) {
		this.xc = xc;
		this.yc = yc;
		this.zclip = zc;
	}
	
	
	/**
	 * Apply perspective projection, draw a polygon
	 * @param g
	 * @param points
	 */
	private void fillQuad_3D(Graphics g, Point3d[] points, boolean debug)
	{
		final Point2d[] pts = new Point2d[points.length];
		
		for (int i=0; i< points.length; i++) {
			
			final double z = points[i].getZ();
			if (z < 0 || z > zclip)
				return;
			
			final double ZOOM = 60;
			
			double cxx = xc + ZOOM* points[i].getX() * (1 - z/zclip);
			double cyy = yc + ZOOM* points[i].getY() * (1 - z/zclip);
			
			pts[i] = new Point2d(cxx, cyy);
		
			if (debug)
				System.out.println(points[i].toString()+" -> "+pts[i].toString()  );
		}
		
		fillQuad_2D(g, pts);
	}
	
	/**
	 * draw a 2d polygon
	 * @param g
	 * @param points
	 */
	private void fillQuad_2D(Graphics g, Point2d[] points)
	{
		final int[] xPoints = new int[points.length];
		final int[] yPoints = new int[points.length];
		
		for (int i=0; i<points.length; i++) {
			xPoints[i] = (int)points[i].getX();
			yPoints[i] = (int)points[i].getY();
		}
		
		g.fillPolygon(xPoints, yPoints, xPoints.length);
	}

	@Override
	protected Color[] getColorsInOrder() {
		return new Color[] { Color.ORANGE, Color.WHITE, Color.BLUE, Color.YELLOW, Color.GREEN, Color.RED };
	}
}
