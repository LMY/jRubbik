package jRubbik.ui;

import java.awt.Graphics;

import jRubbik.constants.Color;
import jRubbik.state.CubeState;
import jRubbik.utils.Point2d;
import jRubbik.utils.Point2i;
import jRubbik.utils.Point3d;

public class CubePanelDraw3D extends CubePanelCanvas {

	public CubePanelDraw3D(CubeState state) {
		super(state);
	}

	private static final long serialVersionUID = -913020583144845777L;

	@Override
	protected Point2i getPadding(int width, int height) {
		return new Point2i(100,100);
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
	
	
	final static  double K = 1.5;
	final static double zfc = 1;
	final static double F = 3;
	
	private static Point3d[][] face_coords = {
			/* red */ { new Point3d(-K, -K, zfc), new Point3d(K, K, zfc) },
			/* ora */ { new Point3d(K, -K, zfc+F), new Point3d(-K, K, zfc+F) },
			/* yel */ { new Point3d(-K, K, zfc), new Point3d(K, K, zfc+F)},
			/* whi */ { new Point3d(-K, -K, zfc), new Point3d(K, -K, zfc+F)},
			/* gre */ { new Point3d(-K, -K, zfc+F), new Point3d(-K, K, zfc) },
			/* blu */ { new Point3d(K, -K, zfc),  new Point3d(K, K, zfc+F) }
		};
	
	private void drawQuad(Graphics g, Color c, int x, int y, Color facecolor) {
		
		g.setColor(c.toAwtColor());
		
		Point2i offset = Point2i.ZERO;
		
		final Point3d delta = Point3d.multiply(Point3d.subtract(face_coords[facecolor.toInt()][1], face_coords[facecolor.toInt()][0]), (double)1/3);
		final Point3d[] pts = new Point3d[4];
		
		
		for (int dx=0; dx<2; dx++)
			for (int dy=0; dy<2; dy++) {
				final Point3d sads = new Point3d(delta.getX() * dx, delta.getY() * dy, delta.getZ() * 1);
				
				pts[dy*2+dx] = Point3d.add(face_coords[facecolor.toInt()][0], sads);
			}
		
		fillQuad(g, pts);
	}
	
	private double xc = 500;
	private double yc = 500;
	private double zc = 10;
	
	public void setCenter(double xc, double yc, double zc) {
		this.xc = xc;
		this.yc = yc;
		this.zc = zc;
	}
	
	
	/**
	 * Apply perspective projection, draw a polygon
	 * @param g
	 * @param points
	 */
	private void fillQuad(Graphics g, Point3d[] points)
	{
		final Point2d[] pts = new Point2d[points.length];
		
		for (int i=0; i< points.length; i++)
			pts[i] = new Point2d(
								calc_x(points[i].getX(), points[i].getZ()),
								calc_y(points[i].getY(), points[i].getZ()));
		
		fillQuad(g, pts);
	}
	
	/**
	 * draw a 2d polygon
	 * @param g
	 * @param points
	 */
	private void fillQuad(Graphics g, Point2d[] points)
	{
		final int[] xPoints = new int[points.length];
		final int[] yPoints = new int[points.length];
		
		for (int i=0; i<points.length; i++) {
			xPoints[i] = (int)points[i].getX();
			yPoints[i] = (int)points[i].getY();
		}
		
		g.drawPolygon(xPoints, yPoints, xPoints.length);
	}
	
	private double calc_x(double x, double z) {
		return ((x - xc) * (1/(z-zc)));
	}
	private double calc_y(double y, double z) {
		return ((y - yc) * (1/(z-zc)));
	}
}
