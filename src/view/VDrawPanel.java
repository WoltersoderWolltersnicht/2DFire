package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import control.CMainWindow;


	public class VDrawPanel extends JPanel {
		
		public Color [] palete;
		public int [][] temperature; 
		BufferedImage screen;
		public Color color;
		
		public VDrawPanel(){
			
			//Creates BufferedImage of 1200 with & 800 height;
			setSize(810,510);
			setBorder(new LineBorder(new Color(0, 0, 0)));
			screen = new BufferedImage (810,510,BufferedImage.TYPE_INT_RGB);
			
			
			//Initializes 2 dimension array of the sizes of the BufferedImage with 0 ;
			temperature = iniArray();
			
			//Creates an array of colors from 0 to 99
			palete=fillPalete2(Color.BLACK,Color.RED,Color.YELLOW,Color.WHITE);
			
			
	        new Thread(new Runnable() {
	            @Override
	            public void run() {
	                while (true) {
	                	//Calls paint Method
	                    repaint();
	                    try {
	                    	//Waits x milliseconds.
	                        Thread.sleep(10);
	                    } catch (InterruptedException ex) { }
	                }
	            }
	        }).start();
			
		}
        
		
		/**
		 * Initializes Arrays
		 * Set all Array positions to 0s
		 * @return
		 */
		private int[][] iniArray() {
			temperature = new int[screen.getWidth()][screen.getHeight()];
			
			for (int x=0;x<temperature.length;x++) {
				for (int y=0; y<temperature[0].length;y++) {
					
					temperature[x][y]=0;
					
				}
			}
			
			return temperature;
		}

		
		/**
		 * 
		 * Function that paints in the BufferedImage 
		 * 
		 */
	    public void paint(Graphics g) {
	    	
	    	//Introduces in the bottom row randomly 0 or 99 
			for (int i=0; i<temperature.length;i++ ) {
				
				temperature[i][temperature[0].length-1] = (Math.random() > 0.10) ? 0 : CMainWindow.intensity ;
			
			}

			
			/**
			 * 
			 * Calculates the average of the three below pixels
			 * (ignores the bottom row because it has no below pixels)
			 * 
			 */
			int resultados;
			for (int y = temperature[0].length-2; y>0 ; y--) {

				for(int x =temperature.length-2 ; x>1; x-- ) {
					
					resultados = temperature[x][y];

						try {
							resultados+=temperature[x][y+1];
						}catch(Exception e) {}
						
						try {
							resultados+=temperature[x-1][y+1];
						}catch(Exception e) {}
						
						try {
							resultados+=temperature[x+1][y+1];
						}catch(Exception e) {}
						resultados=resultados/4;
						
						temperature[x][y]=(resultados>1)? resultados-1 : resultados;
					
					
					if (temperature[x][y]>99) {
						screen.setRGB(x,y,palete[99].getRGB());
					}else if (temperature[x][y]<0){
						screen.setRGB(x, y, palete[0].getRGB());
					}else {
						screen.setRGB(x, y, palete[temperature[x][y]].getRGB());
					}	
				}
			}

	        g.drawImage(screen, 10, 10, 810, 510, null);

	    }
	    
/*	    public Color[] fillPalete() {
	    	
	    	
	    	Color[] palete = new Color[100]; 
	    	
	    	int r=255,g=255,b=255;
	    	
	    	for(int x=99 ; x>66 ; x-- ) {
	    		
	    		palete[x]=new Color(r, g, b);
	    		b-=7;
	    				
	    	}
	    	for(int x=66 ; x>33 ; x-- ) {
	    		
	    		palete[x]=new Color(r, g, b);
	    		g-=7;
	    		
	    	}
	    	for(int x=33 ; x>-1 ; x-- ) {
	    		
	    		palete[x]=new Color(r, g, b);
	    		r-=7;
	    		
	    	}
	 	  	
	    	return palete;
	    	
	    }
*/	    
	    public Color[] fillPalete2(Color c1, Color c2, Color c3, Color c4) {
	    	
	    	
	    	int r,g,b;
	    	Color[] list = new Color[100];
	    	r=c1.getRed();
	    	g=c1.getGreen();
	    	b=c1.getBlue();
	    	
	    	for (int i = 0; i < 33; i++) {
	    	    
	    	    r-= (c1.getRed()-c2.getRed())/33;
	    	    g-= (c1.getGreen()-c2.getGreen())/33;
	    	    b-= (c1.getBlue()-c2.getBlue())/33;
	    	    
	    	    System.out.println(r);
	    	    
	    	    System.out.println(b);
	    	    
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
	    	
			return list;
	
	    }
	    
    }
