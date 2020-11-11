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
	public VDrawPanel VDP;
	
	/**
	 * CMainWindow Constructor:
	 */
	public CMainWindow() {
		
		VMW = new VMainWindow();						
		VDP= new VDrawPanel();
		VDP.temperature.intensity=VMW.slider.getValue();
		VMW.getContentPane().add(VDP);
		
		//Slider ChangeListener: 
		VMW.slider.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				
				VDP.temperature.intensity=VMW.slider.getValue();
				
			}
		});
	
		
		//Button Red Fire Action Listener:
		VMW.btnRedFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VDP.palette.fillColors(Color.BLACK,Color.RED,Color.YELLOW,Color.WHITE);
				
			}
		});
		
		
		//Button Blue Fire Action Listener:
		VMW.btnBlueFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VDP.palette.fillColors(Color.BLACK,new Color(0,0,255),new Color(30,144,255),Color.WHITE);
				
			}
		});
		
		
		//Button Random Fire Action Listener:
		VMW.btnRandomFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				while(true) {
					
					Color c1 = new Color((int)(Math.random() * 0x1000000));
					Color c2 = new Color((int)(Math.random() * 0x1000000));
					Color c3 = new Color((int)(Math.random() * 0x1000000));
					Color c4 = new Color((int)(Math.random() * 0x1000000));
					
					try {
						
						VDP.palette.fillColors(c1,c2,c3,c4);
						break;
						
					}catch(Exception er) {}
				}	
			}	
		});
		
	}
	
}
