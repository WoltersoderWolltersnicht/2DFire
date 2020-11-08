import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class fireWindow extends JFrame {

	private JPanel contentPane;
		
	Color [] palete;
	int [][] temperature; 
	BufferedImage screen;
	Random ran= new Random();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					new fireWindow().setVisible(true);;

			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fireWindow() {
		setSize(1300,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//Creates BufferedImage of 1200 with & 800 heigth;
		screen = new BufferedImage (1200,800,BufferedImage.TYPE_INT_RGB);
		//Inicialices 2 dimension array of the sizes of the BufferedImage ful with 0 ;
		temperature = new int[screen.getWidth()][screen.getHeight()];
		
		for (int x=0;x<temperature.length;x++) {
			for (int y=0; y<temperature[0].length;y++) {
				
				temperature[x][y]=0;
				
			}
		}
		
		//Creates an array of colors from 0 to 99
		palete=fillPalete();
		

		
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                	//llama la clase paint
                    repaint();
                    try {
                    	//espera x milisegundos para volver a subir.
                        Thread.sleep(10);
                    } catch (InterruptedException ex) { }
                }
            }
        }).start();
		
	}
	
	/**
	 * 
	 * Funktion that paints in the BufferedImage 
	 * 
	 */
    public void paint(Graphics g) {
    	
    	//Introduces in the botom row randomly 0 or 99 
		for (int i=0; i<temperature.length;i++ ) {
			
			temperature[i][temperature[0].length-1] = (Math.random() > 0.35) ? 0 : 99 ;
			
		}

		/**
		 * 
		 * Calculates the average of the three below pixels
		 * (ignores the botom row because it has no below pixels)
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
		
        g.drawImage(screen, 0, 0, 1200, 800, null);

    }
    
    
    public Color[] fillPalete() {
    	
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
}
