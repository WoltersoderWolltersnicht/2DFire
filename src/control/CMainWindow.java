package control;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.VDrawPanel;
import view.VMainWindow;

public class CMainWindow {
	
	public VMainWindow VMW;
	public CDrawPanel CDP;
	
	public CMainWindow() {
		
		VMW = new VMainWindow();						
		CDP= new CDrawPanel();
		CDP.VDP.temperature.intensity=VMW.slider.getValue();
		VMW.getContentPane().add(CDP.VDP);
		
		//Slider ChangeListener 
		VMW.slider.addChangeListener(new ChangeListener() {
			

			
		@Override
		public void stateChanged(ChangeEvent e) {
				
				CDP.VDP.temperature.intensity=VMW.slider.getValue();
				
			}
		});
	
		VMW.btnRedFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CDP.VDP.palette.fillColors(Color.BLACK,Color.RED,Color.YELLOW,Color.WHITE);
				
			}
		});
		
		VMW.btnBlueFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CDP.VDP.palette.fillColors(Color.BLACK,new Color(0,0,255),new Color(30,144,255),Color.WHITE);
				
			}
		});
		
		VMW.btnRandomFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				while(true) {
					Color c1 = new Color((int)(Math.random() * 0x1000000));
					Color c2 = new Color((int)(Math.random() * 0x1000000));
					Color c3 = new Color((int)(Math.random() * 0x1000000));
					Color c4 = new Color((int)(Math.random() * 0x1000000));
				try {
					CDP.VDP.palette.fillColors(c1,c2,c3,c4);
					break;
				}catch(Exception er) {
					
					
					
				}
				}	
			}	
		});
	}
	


      
    
    
	
	
		
		

	
}
