import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Polygon;

// @Author - Caleb Boutell

public class P2Shape {
	
	//A drawable and clickable shape for Prototype 2 of our concept
	
	private Polygon body;
	private Color color;
//	public Point2D topLeftCorner; 
	

	public P2Shape(int x, int y, int scale) {
//		body = new Rectangle(x, y, 50, 50);
		body = new Polygon(new int[]{x, x+10*scale, x+40*scale, x+50*scale, x+50*scale}, new int[]{y, y+40*scale, y+45*scale, y+40*scale, y+30*scale}, 5);
		color = new Color(0,0,0);
	}
	
	public P2Shape(ArrayList<Point2D> nodes) {
		int l = nodes.size();
		int[] xPoints = new int[l];
		int[] yPoints = new int[l];
		
		for (int i=0; i<l; i++) {
			xPoints[i] = (int) nodes.get(i).getX();
			yPoints[i] = (int) nodes.get(i).getY();
		}
		
		body = new Polygon(xPoints, yPoints, l);
		color = new Color(0,0,0);
	}


	public Polygon getBody() {
		return body;
	}


	public void setBody(int x, int y, int scale) {
//		this.body = new Rectangle(x, y, x+50, y+50);;
		body = new Polygon(new int[]{x, x+10*scale, x+40*scale, x+50*scale, x+50*scale}, new int[]{y, y+40*scale, y+45*scale, y+40*scale, y+30*scale}, 5);
	}


	public Color getColor() {
		return color;
	}


	public void setColor(int r, int g, int b) {
		this.color = new Color(r, g, b);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
}
