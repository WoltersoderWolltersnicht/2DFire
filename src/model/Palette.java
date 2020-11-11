package model;

import java.awt.Color;

public class Palette {
	
	public Color[] colorList;
	
	public Palette() {
		
		//Inicializes an array of colors from 0 to 99
		fillColors(Color.BLACK,Color.RED,Color.YELLOW,Color.WHITE);
		
	}

	public void fillColors(Color c1, Color c2, Color c3, Color c4) {
	    	
	    	int r,g,b;
	    	Color[] list = new Color[100];
	    	r=c1.getRed();
	    	g=c1.getGreen();
	    	b=c1.getBlue();
	    	
	    	for (int i = 0; i < 33; i++) {
	    	    
	    	    r-= (c1.getRed()-c2.getRed())/33;
	    	    g-= (c1.getGreen()-c2.getGreen())/33;
	    	    b-= (c1.getBlue()-c2.getBlue())/33;
	    	    	    
	    	    list[i]=new Color(r, g, b);
	    	    
	    	}
	    	
	    	for (int i = 33; i < 66; i++ ) {
	    		
	    	    r-= (c2.getRed()-c3.getRed())/33;
	    	    g-= (c2.getGreen()-c3.getGreen())/33;
	    	    b-= (c2.getBlue()-c3.getBlue())/33;
	    	    		
	    	    list[i]=new Color(r, g, b);
	    	}
	    	
	    	for (int i = 66; i < 100; i++ ) {
	    		
	    	    r-= (c3.getRed()-c4.getRed())/33;
	    	    g-= (c3.getGreen()-c4.getGreen())/33;
	    	    b-= (c3.getBlue()-c4.getBlue())/33;
	    	    		
	    	    list[i]=new Color(r, g, b);
	    	}
	    	
	    	this.colorList = list;
	    	
	}
}
