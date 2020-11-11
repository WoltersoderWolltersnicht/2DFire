package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import control.CMainWindow;
import model.Palette;
import model.Temperature;


	public class VDrawPanel extends JPanel {
		
		public Temperature temperature;
		public Palette palette;
		public BufferedImage screen;
		
		/**
		 * VDrawPanel Constructor:
		 */
		public VDrawPanel(){

			setBounds(0, 0, 810, 522);
			setBorder(new LineBorder(new Color(0, 0, 0)));
			
			//Creates BufferedImage of the detemined size:
			screen = new BufferedImage (810,510,BufferedImage.TYPE_INT_RGB);
			temperature = new Temperature (screen.getWidth(),screen.getHeight());
			palette = new Palette();
			
			//Creates a new Thread that every 10 seconds recalculates the fire and repaints:
	        new Thread(new Runnable() {
	            @Override
	            public void run() {
	                while (true) {
	                	
	                	temperature.setHeatPoints();
	                	temperature.calculateTemperature();
	                	//llama la clase paint:
	                    repaint();
	                    
	                    try {
	                    	//espera x milisegundos para volver a subir:
	                        Thread.sleep(10);
	                    } catch (InterruptedException ex) { }
	                }
	            }
	        }).start();
			
		}

		
		/**
		 * 
		 * Funktion that paints in the BufferedImage:
		 * 
		 */
	    public void paint(Graphics g) {
	    	
		    for (int y=0; y<temperature.temperatureList[0].length; y++) {	
		    	for (int x=0; x<temperature.temperatureList.length;x++) {
		    		
			    	if (temperature.temperatureList[x][y]>99) {
			    		
			    		screen.setRGB(x,y,palette.colorList[99].getRGB());
			    		
					}else if (temperature.temperatureList[x][y]<0){
						
						screen.setRGB(x, y, palette.colorList[0].getRGB());
						
					}else {
						
						screen.setRGB(x, y, palette.colorList[temperature.temperatureList[x][y]].getRGB());
					
					}
			    	
		    	}	
		    }

		    g.drawImage(screen, 10, 10, 810, 510, null);

	    }
	    
	    
    }
