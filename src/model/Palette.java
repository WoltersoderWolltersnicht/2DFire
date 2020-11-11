package model;

import java.awt.Color;

public class Palette {
	
	public Color[] colorList;
	
	/**
	 * 
	 * Palette Constructor:
	 * 
	 */
	public Palette() {
		
		fillColors(Color.BLACK,Color.RED,Color.YELLOW,Color.WHITE);
		
	}

	/**
	 * Procedure that with 4 colors sets in to colorList an array with the graduation of the colors:
	 * 
	 * @param Group of colors
	 * @return Color[] Graduated Array of Colors
	 * 
	 */
	public void fillColors(Color color1, Color color2, Color color3, Color color4) {
	    	
	    	int r,g,b;
	    	Color[] list = new Color[100];
	    	r=color1.getRed();
	    	g=color1.getGreen();
	    	b=color1.getBlue();
	    	
	    	for (int i = 0; i < 33; i++) {
	    	    
	    	    r-= (color1.getRed()-color2.getRed())/33;
	    	    g-= (color1.getGreen()-color2.getGreen())/33;
	    	    b-= (color1.getBlue()-color2.getBlue())/33;
	    	    	    
	    	    list[i]=new Color(r, g, b);
	    	    
	    	}
	    	
	    	for (int i = 33; i < 66; i++ ) {
	    		
	    	    r-= (color2.getRed()-color3.getRed())/33;
	    	    g-= (color2.getGreen()-color3.getGreen())/33;
	    	    b-= (color2.getBlue()-color3.getBlue())/33;
	    	    		
	    	    list[i]=new Color(r, g, b);
	    	}
	    	
	    	for (int i = 66; i < 100; i++ ) {
	    		
	    	    r-= (color3.getRed()-color4.getRed())/33;
	    	    g-= (color3.getGreen()-color4.getGreen())/33;
	    	    b-= (color3.getBlue()-color4.getBlue())/33;
	    	    		
	    	    list[i]=new Color(r, g, b);
	    	}
	    	
	    	this.colorList = list;
	    	
	}
}
