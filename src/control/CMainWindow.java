package control;


import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.VMainWindow;

public class CMainWindow {
	
	public VMainWindow VMW;
	public static int intensity; 
	
	public CMainWindow() {
		
		VMW = new VMainWindow();				
		intensity=VMW.slider.getValue();
		
		//ChangeListener Slider
		VMW.slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				intensity=VMW.slider.getValue();
				
			}
		});
	}
	


      
    
    
	
	
		
		

	
}
