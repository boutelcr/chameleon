import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Point;
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
	
	public P2Shape(ArrayList<Point2D> nodes, Color inputColor) {
		int l = nodes.size();
		int[] xPoints = new int[l];
		int[] yPoints = new int[l];
		
		for (int i=0; i<l; i++) {
			xPoints[i] = (int) nodes.get(i).getX();
			yPoints[i] = (int) nodes.get(i).getY();
		}
		
		body = new Polygon(xPoints, yPoints, l);
		this.color = inputColor;
	}


	public Polygon getBody() {
		return body;
	}

	public ArrayList<String> getData() {
		ArrayList<String> nodes = new ArrayList<String>();
		String thisLine;
		Integer x;
		Integer y;
		
		for (int i=0; i<body.npoints; i++) {
			x = body.xpoints[i];
			y = body.ypoints[i];
			thisLine = x.toString() + "|" + y.toString();
			nodes.add(thisLine);
		}
		nodes.add("c " + roundToThree(color.getRed()) + " " + roundToThree(color.getGreen()) + " " + roundToThree(color.getBlue()));
		nodes.add("poly finished");
		
		return nodes;
	}

	
	public static ArrayList<P2Shape> polyRead(ArrayList<String> data) {
		ArrayList<P2Shape> shapes = new ArrayList<P2Shape>();
		ArrayList<Point2D> nodes = new ArrayList<Point2D>();
		char charHere;
		int coord = 0;
		int x = 0;
		int y = 0;
		int colorVal = 0;
		int[] rgb = {0,0,0};
		
		for (String dataLine : data) {
			if (dataLine.equals("poly finished")) {
//				shapes.add(new P2Shape(nodes));
				shapes.add(new P2Shape(nodes, new Color(rgb[0], rgb[1], rgb[2])));
				System.out.println("shape added");
				nodes.clear();
				
			} else if (dataLine.charAt(0) == 'c') {
				for (int i=0; i<3; i++) {
					for (int j=0; j<3; j++) {
						colorVal = colorVal*10 + Character.getNumericValue(dataLine.charAt(3 + (5*i) + j));
					}
					rgb[i] = Math.abs(colorVal);
					colorVal = 0;
				}
				System.out.println("Found color: " + rgb[0] + ", " + rgb[1] + ", " + rgb[2]);
			} else {				
				for (int i=0; i<dataLine.length(); i++) {
					charHere = dataLine.charAt(i);
					if (charHere == '|') {
						x = coord;
						coord = 0;
					} else {
						coord = coord*10 + Character.getNumericValue(charHere);
					}
				}
				y = coord;
				nodes.add(new Point(x,y));
				System.out.println("added node: " + x + ", " + y);
				coord = 0;
			}
			
		}
		
		return shapes;
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
	
		
	
	public String roundToThree(Integer colorVal) {
		String threeStr;
		if (colorVal > 99) threeStr = " " + colorVal.toString();
		else if (colorVal > 9) threeStr = " 0" + colorVal.toString();
		else threeStr = " 00" + colorVal.toString();	
		
		return threeStr;
	}
}
