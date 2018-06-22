package unl.cse.recursion;

import java.awt.*;
import java.applet.*;

public class SierpinskiTriangle extends Applet 
{  
	public static long count ;
	public void SeirpTri(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int n)  
	{
		count++;
		this.setBackground(new Color(0,0,0));
		this.setSize(700, 500);
		if ( n == 0 )
	    {
			g.setColor(new Color(0, 255, 0));
			g.drawLine(x1, y1, x2, y2);     // if n = 0 draw the triangle
	        g.drawLine(x2, y2, x3, y3);
	        g.drawLine(x3, y3, x1, y1);
	        return;     
	    }
	    
		int xa, ya, xb, yb, xc, yc;   // make 3 new triangles by connecting the midpoints of
	    xa = (x1 + x2) / 2;             //. the previous triangle 
	    ya = (y1 + y2) / 2;
	    xb = (x1 + x3) / 2;
	    yb = (y1 + y3) / 2;
	    xc = (x2 + x3) / 2;
	    yc = (y2 + y3) / 2;
	    SeirpTri(g, x1, y1, xa, ya, xb, yb, n - 1);   // recursively call the function using the 3 triangles
	    SeirpTri(g, xa, ya, x2, y2, xc, yc, n - 1);
	    SeirpTri(g, xb, yb, xc, yc, x3, y3, n - 1);
	}
	
	public long getCount(){
		return count;
	}
	public void paint(Graphics g)    
	{
		int recursions = 1;
		// call the recursive function sending in the number of recursions
	    SeirpTri(g, 319, 0, 0, 479, 639, 479, recursions);
	    System.out.println("count = "+ getCount());
	}        
}
